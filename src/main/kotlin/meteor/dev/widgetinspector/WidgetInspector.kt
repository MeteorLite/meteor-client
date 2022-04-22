/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.dev.widgetinspector

import eventbus.events.CheatEntered
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOptionClicked
import lombok.Getter
import meteor.Main
import meteor.rs.ClientThread
import meteor.ui.overlay.OverlayManager
import meteor.util.ColorUtil
import javax.swing.JFrame
import javax.swing.JTree
import javax.swing.JCheckBox
import javax.swing.tree.DefaultMutableTreeNode
import java.awt.BorderLayout
import javax.swing.event.TreeSelectionEvent
import javax.swing.JScrollPane
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.JButton
import java.awt.event.ActionEvent
import java.awt.event.ItemEvent
import javax.swing.JSplitPane
import javax.swing.SwingUtilities
import javax.swing.tree.DefaultTreeModel
import net.runelite.api.*
import net.runelite.api.widgets.*
import java.awt.Color
import java.awt.Dimension
import java.util.*
import java.util.stream.Stream
import javax.swing.tree.TreePath

object WidgetInspector : JFrame() {
    private val client = Main.client
    private val clientThread = ClientThread
    private val overlay = WidgetInspectorOverlay(this)
    private val overlayManager = OverlayManager
    private val widgetTree: JTree
    private val infoTableModel = WidgetInfoTableModel
    private val alwaysOnTop: JCheckBox
    private val hideHidden: JCheckBox
    private var root: DefaultMutableTreeNode? = null
    private val widgetIdMap: MutableMap<Int, WidgetInfo> = HashMap()
    val SELECTED_WIDGET_COLOR = Color.CYAN
    private var SELECTED_WIDGET_HUE = 0f

    @Getter
    var selectedWidget: Widget? = null

    @Getter
    var selectedItem = 0
    private var picker: Widget? = null

    @Getter
    var pickerSelected = false

    init {
        val hsb = FloatArray(3)
        Color.RGBtoHSB(
            SELECTED_WIDGET_COLOR.red,
            SELECTED_WIDGET_COLOR.green,
            SELECTED_WIDGET_COLOR.blue,
            hsb
        )
        SELECTED_WIDGET_HUE = hsb[0]

        title = "OpenOSRS Widget Inspector"
        layout = BorderLayout()
        widgetTree = JTree(DefaultMutableTreeNode())
        widgetTree.isRootVisible = false
        widgetTree.showsRootHandles = true
        widgetTree.selectionModel.addTreeSelectionListener { e: TreeSelectionEvent? ->
            val selected = widgetTree.lastSelectedPathComponent
            if (selected is WidgetTreeNode) {
                val widget = selected.widget
                setSelectedWidget(widget, -1, false)
            } else if (selected is WidgetItemNode) {
                val node = selected
                setSelectedWidget(node.widgetItem.widget, node.widgetItem.index, false)
            }
        }
        val treeScrollPane = JScrollPane(widgetTree)
        treeScrollPane.preferredSize = Dimension(200, 400)
        val widgetInfo = JTable(infoTableModel)
        val infoScrollPane = JScrollPane(widgetInfo)
        infoScrollPane.preferredSize = Dimension(400, 400)
        val bottomPanel = JPanel()
        add(bottomPanel, BorderLayout.SOUTH)
        val refreshWidgetsBtn = JButton("Refresh")
        refreshWidgetsBtn.addActionListener { e: ActionEvent? -> refreshWidgets() }
        bottomPanel.add(refreshWidgetsBtn)
        alwaysOnTop = JCheckBox("Always on top")
        //alwaysOnTop.addItemListener { ev: ItemEvent? -> config.inspectorAlwaysOnTop(alwaysOnTop.isSelected) }
        bottomPanel.add(alwaysOnTop)
        hideHidden = JCheckBox("Hide hidden")
        hideHidden.isSelected = true
        hideHidden.addItemListener { ev: ItemEvent? -> refreshWidgets() }
        bottomPanel.add(hideHidden)
        val revalidateWidget = JButton("Revalidate")
        revalidateWidget.addActionListener { ev: ActionEvent? ->
            clientThread.invokeLater {
                if (selectedWidget == null) {
                    return@invokeLater
                }
                selectedWidget!!.revalidate()
            }
        }
        bottomPanel.add(revalidateWidget)
        val split = JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoScrollPane)
        add(split, BorderLayout.CENTER)
        pack()
        subscribe()
    }

    private fun refreshWidgets() {
        clientThread.invokeLater {
            val rootWidgets = client.widgetRoots
            root = DefaultMutableTreeNode()
            val wasSelectedWidget = selectedWidget
            val wasSelectedItem = selectedItem
            selectedWidget = null
            selectedItem = -1
            for (widget in rootWidgets) {
                val childNode = addWidget("R", widget)
                if (childNode != null) {
                    root!!.add(childNode)
                }
            }
            SwingUtilities.invokeLater {
                widgetTree.model = DefaultTreeModel(root)
                setSelectedWidget(wasSelectedWidget, wasSelectedItem, true)
            }
        }
    }

    private fun addWidget(type: String, widget: Widget?): DefaultMutableTreeNode? {
        if (widget == null || hideHidden.isSelected && widget.isHidden) {
            return null
        }
        val node: DefaultMutableTreeNode = WidgetTreeNode(type, widget)
        var childComponents = widget.dynamicChildren
        if (childComponents != null) {
            for (component in childComponents) {
                val childNode = addWidget("D", component)
                if (childNode != null) {
                    node.add(childNode)
                }
            }
        }
        childComponents = widget.staticChildren
        if (childComponents != null) {
            for (component in childComponents) {
                val childNode = addWidget("S", component)
                if (childNode != null) {
                    node.add(childNode)
                }
            }
        }
        childComponents = widget.nestedChildren
        if (childComponents != null) {
            for (component in childComponents) {
                val childNode = addWidget("N", component)
                if (childNode != null) {
                    node.add(childNode)
                }
            }
        }
        val items = widget.widgetItems
        if (items != null) {
            for (item in items) {
                if (item == null) {
                    continue
                }
                node.add(WidgetItemNode(item))
            }
        }
        return node
    }

    private fun setSelectedWidget(widget: Widget?, item: Int, updateTree: Boolean) {
        infoTableModel.setWidget(widget)
        if (selectedWidget === widget && selectedItem == item) {
            return
        }
        selectedWidget = widget
        selectedItem = item
        if (root == null || !updateTree) {
            return
        }
        clientThread.invoke {
            val treePath = Stack<Widget>()
            var w = widget
            while (w != null) {
                treePath.push(w)
                w = w.parent
            }
            var node: DefaultMutableTreeNode = root as DefaultMutableTreeNode
            deeper@ while (!treePath.empty()) {
                val w = treePath.pop()
                val it: Enumeration<*> = node.children()
                while (it.hasMoreElements()) {
                    val inner = it.nextElement() as WidgetTreeNode
                    if (inner.widget.id == w.id && inner.widget.index == w.index) {
                        node = inner
                        continue@deeper
                    }
                }
            }
            if (selectedItem != -1) {
                val it: Enumeration<*> = node.children()
                while (it.hasMoreElements()) {
                    val wiw = it.nextElement()
                    if (wiw is WidgetItemNode) {
                        val inner = wiw
                        if (inner.widgetItem.index == selectedItem) {
                            node = inner
                            break
                        }
                    }
                }
            }
            val fnode = node
            SwingUtilities.invokeLater {
                widgetTree.selectionModel.clearSelection()
                widgetTree.selectionModel.addSelectionPath(TreePath(fnode.path))
            }
        }
    }

    fun open() {
        overlayManager.add(overlay)
        clientThread.invokeLater { addPickerWidget() }
        isVisible = true
    }

    fun close() {
        overlayManager.remove(overlay)
        clientThread.invokeLater { removePickerWidget() }
        setSelectedWidget(null, -1, false)
        isVisible = false
    }

    private fun removePickerWidget() {
        if (picker == null) {
            return
        }
        val parent = picker!!.parent ?: return
        val children = parent.children
        if (children == null || children.size <= picker!!.index || children[picker!!.index] !== picker) {
            return
        }
        children[picker!!.index] = null
    }

    private fun addPickerWidget() {
        removePickerWidget()
        var x = 10
        var y = 2
        var parent = client.getWidget(WidgetInfo.MINIMAP_ORBS)
        if (parent == null) {
            val roots = client.widgetRoots
            parent = Stream.of(*roots)
                .filter { w: Widget -> w.type == WidgetType.LAYER && w.contentType == 0 && !w.isSelfHidden }
                .sorted(Comparator.comparingInt { w: Widget -> w.relativeX + w.relativeY }
                    .reversed()
                    .thenComparingInt { obj: Widget -> obj.id }
                    .reversed())
                .findFirst().get()
            x = 4
            y = 4
        }
        picker = parent.createChild(-1, WidgetType.GRAPHIC)
        val picker = picker!!
        picker.spriteId = SpriteID.MOBILE_FINGER_ON_INTERFACE
        picker.originalWidth = 15
        picker.originalHeight = 17
        picker.originalX = x
        picker.originalY = y
        picker.revalidate()
        picker.targetVerb = "Select"
        picker.name = "Pick"
        picker.clickMask = WidgetConfig.USE_WIDGET or WidgetConfig.USE_ITEM
        picker.noClickThrough = true
        picker.setOnTargetEnterListener(JavaScriptCallback {
            pickerSelected = true
            picker.opacity = 30
            client.setAllWidgetsAreOpTargetable(true)
        })
        picker.setOnTargetLeaveListener(JavaScriptCallback { onPickerDeselect() })
    }

    private fun subscribe() {
        Main.eventBus.subscribe<MenuOptionClicked>(eventbus.Events.MENU_OPTION_CLICKED) {
            val it = it.data
            if (pickerSelected) {
                onPickerDeselect()
                client.spellSelected = false
                it.consume()
                val target = getWidgetOrWidgetItemForMenuOption(it.getMenuAction()!!, it.getParam0(), it.getParam1())
                target?.let {
                    if (it is WidgetItem) {
                        val iw = it
                        setSelectedWidget(iw.widget, iw.index, true)
                    } else {
                        setSelectedWidget(target as Widget, -1, true)
                    }
                }
            }
        }
        Main.eventBus.subscribe<MenuEntryAdded>(eventbus.Events.MENU_ENTRY_ADDED) {
            if (pickerSelected) {
                val menuEntries = client.menuEntries
                for (i in menuEntries.indices) {
                    val entry = menuEntries[i]
                    if (entry.type != MenuAction.ITEM_USE_ON_WIDGET
                        && entry.type != MenuAction.SPELL_CAST_ON_WIDGET
                    ) {
                        continue
                    }
                    var name = WidgetInfo.TO_GROUP(entry.param1).toString() + "." + WidgetInfo.TO_CHILD(entry.param1)
                    if (entry.param0 != -1) {
                        name += " [" + entry.param0 + "]"
                    }
                    val color = colorForWidget(i, menuEntries.size)
                    entry.target = ColorUtil.wrapWithColorTag(name, color)
                }
            }
        }
        Main.eventBus.subscribe<CheatEntered>(eventbus.Events.CHEAT_ENTERED) {
            val it = it.data
            if (it.cheat == "widgets") {
                client.addChatMessage(ChatMessageType.TRADEREQ, "Meteor", "WidgetInspector", "")
                it.consumed = true
                if (isVisible)
                    close()
                else
                    open()
            }
            else if (it.cheat == "invalidate") {
                client.invalidateStretching(true)
                it.consumed = true
            }
        }
    }

    private fun onPickerDeselect() {
        client.setAllWidgetsAreOpTargetable(false)
        picker!!.opacity = 0
        pickerSelected = false
    }

    fun colorForWidget(index: Int, length: Int): Color {
        val h = SELECTED_WIDGET_HUE + .1f + .8f / length * index
        return Color.getHSBColor(h, 1f, 1f)
    }

    fun getWidgetOrWidgetItemForMenuOption(type: MenuAction, param0: Int, param1: Int): Any? {
        if (type == MenuAction.SPELL_CAST_ON_WIDGET) {
            var w = client.getWidget(param1)
            if (param0 != -1) {
                w = w!!.getChild(param0)
            }
            return w
        } else if (type == MenuAction.ITEM_USE_ON_WIDGET) {
            val w = client.getWidget(param1)
            return w!!.getWidgetItem(param0)
        }
        return null
    }





    fun getWidgetInfo(packedId: Int): WidgetInfo? {
        if (widgetIdMap.isEmpty()) {
            //Initialize map here so it doesn't create the index
            //until it's actually needed.
            val widgets = WidgetInfo.values()
            for (w in widgets) {
                widgetIdMap[w.packedId] = w
            }
        }
        return widgetIdMap[packedId]
    }

    fun getWidgetIdentifier(widget: Widget): String {
        val id = widget.id
        var str = WidgetInfo.TO_GROUP(id).toString() + "." + WidgetInfo.TO_CHILD(id)
        if (widget.index != -1) {
            str += "[" + widget.index + "]"
        }
        val info = getWidgetInfo(id)
        if (info != null) {
            str += " " + info.name
        }
        return str
    }
}