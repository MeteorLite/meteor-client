/*
 * Copyright (c) 2018 Abex
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

import com.google.common.collect.ImmutableMap
import meteor.rs.ClientThread
import net.runelite.api.widgets.Widget
import java.util.function.Function
import javax.swing.SwingUtilities
import javax.swing.table.AbstractTableModel

object WidgetInfoTableModel : AbstractTableModel() {
    private val clientThread = ClientThread
    private val fields: List<WidgetField<*>> = populateWidgetFields()
    private var widget: Widget? = null
    private var values: Map<WidgetField<*>, Any>? = null
    private const val COL_FIELD = 0
    private const val COL_VALUE = 1

    fun setWidget(w: Widget?) {
        clientThread.invoke {
            val newValues: Map<WidgetField<*>, Any>? = if (w == null) null else fields.stream().collect(
                ImmutableMap.toImmutableMap(
                    Function.identity()
                ) { i: WidgetField<*> -> i.getValue(w) })
            SwingUtilities.invokeLater {
                widget = w
                values = newValues
                fireTableStructureChanged()
            }
        }
    }

    override fun getRowCount(): Int {
        return if (values == null) {
            0
        } else values!!.size
    }

    override fun getColumnCount(): Int {
        return 2
    }

    override fun getColumnName(col: Int): String? {
        return when (col) {
            COL_FIELD -> "Field"
            COL_VALUE -> "Value"
            else -> null
        }
    }

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any? {
        val field: WidgetField<*> = fields[rowIndex]
        return when (columnIndex) {
            COL_FIELD -> field.name
            COL_VALUE -> values!![field]!!
            else -> null
        }
    }

    override fun isCellEditable(rowIndex: Int, columnIndex: Int): Boolean {
        if (columnIndex == COL_VALUE) {
            val field: WidgetField<*> = fields[rowIndex]
            return field.isSettable
        }
        return false
    }

    override fun setValueAt(value: Any, rowIndex: Int, columnIndex: Int) {
        val field: WidgetField<*> = fields[rowIndex]
        clientThread.invoke {
            widget?.let { field.setValue(it, value) }
            setWidget(widget)
        }
    }

    private fun populateWidgetFields(): List<WidgetField<*>> {
        val out: MutableList<WidgetField<*>> = ArrayList<WidgetField<*>>()
        out.add(WidgetField("Id", Widget::getId))
        out.add(WidgetField("Actions", Widget::rawActions))
        out.add(
            WidgetField(
                "Type",
                { obj: Widget -> obj.type },
                { obj: Widget, i: Int -> obj.type = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ContentType",
                { obj: Widget -> obj.contentType },
                { obj: Widget, i: Int -> obj.contentType = i },
                Int::class.java
            )
        )
        out.add(WidgetField("ParentId", Widget::getParentId))
        out.add(
            WidgetField(
                "SelfHidden",
                { obj: Widget -> obj.isSelfHidden },
                { obj: Widget, b: Boolean -> obj.isHidden = b },
                Boolean::class.java
            )
        )
        out.add(WidgetField("Hidden", Widget::isHidden))
        out.add(
            WidgetField(
                "Text",
                { obj: Widget -> obj.text },
                { obj: Widget, s: String? -> obj.text = s },
                String::class.java
            )
        )
        out.add(
            WidgetField(
                "TextColor",
                { w -> Integer.toString(w.textColor, 16) },
                { w, str -> w.textColor = str.toInt(16) },
                String::class.java
            )
        )
        out.add(
            WidgetField(
                "Opacity",
                { obj: Widget -> obj.opacity },
                { obj: Widget, i: Int -> obj.opacity = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "FontId",
                { obj: Widget -> obj.fontId },
                { obj: Widget, i: Int -> obj.fontId = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "TextShadowed",
                { obj: Widget -> obj.textShadowed },
                { obj: Widget, b: Boolean -> obj.textShadowed = b },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "Name",
                { w -> w.name.trim() },
                { obj: Widget, s: String? -> obj.name = s },
                String::class.java
            )
        )
        out.add(
            WidgetField(
                "ItemId",
                { obj: Widget -> obj.itemId },
                { obj: Widget, i: Int -> obj.itemId = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ItemQuantity",
                { obj: Widget -> obj.itemQuantity },
                { obj: Widget, i: Int -> obj.itemQuantity = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ItemQuantityMode",
                { obj: Widget -> obj.itemQuantityMode },
                { obj: Widget, i: Int -> obj.itemQuantityMode = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ModelId",
                { obj: Widget -> obj.modelId },
                { obj: Widget, i: Int -> obj.modelId = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ModelType",
                { obj: Widget -> obj.modelType },
                { obj: Widget, i: Int -> obj.modelType = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "AnimationId",
                { obj: Widget -> obj.animationId },
                { obj: Widget, i: Int -> obj.animationId = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "RotationX",
                { obj: Widget -> obj.rotationX },
                { obj: Widget, i: Int -> obj.rotationX = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "RotationY",
                { obj: Widget -> obj.rotationY },
                { obj: Widget, i: Int -> obj.rotationY = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "RotationZ",
                { obj: Widget -> obj.rotationZ },
                { obj: Widget, i: Int -> obj.rotationZ = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ModelZoom",
                { obj: Widget -> obj.modelZoom },
                { obj: Widget, i: Int -> obj.modelZoom = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "SpriteId",
                { obj: Widget -> obj.spriteId },
                { obj: Widget, i: Int -> obj.spriteId = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "SpriteTiling",
                { obj: Widget -> obj.spriteTiling },
                { obj: Widget, b: Boolean -> obj.spriteTiling = b },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "BorderType",
                { obj: Widget -> obj.borderType },
                { obj: Widget, i: Int -> obj.borderType = i },
                Int::class.java
            )
        )
        out.add(WidgetField("IsIf3", Widget::isIf3))
        out.add(
            WidgetField(
                "HasListener",
                { obj: Widget -> obj.hasListener() },
                { obj: Widget, b: Boolean -> obj.setHasListener(b) },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "Filled",
                { obj: Widget -> obj.isFilled },
                { obj: Widget, b: Boolean -> obj.isFilled = b },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "OriginalX",
                { obj: Widget -> obj.originalX },
                { obj: Widget, i: Int -> obj.originalX = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "OriginalY",
                { obj: Widget -> obj.originalY },
                { obj: Widget, i: Int -> obj.originalY = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "OriginalWidth",
                { obj: Widget -> obj.originalWidth },
                { obj: Widget, i: Int -> obj.originalWidth = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "OriginalHeight",
                { obj: Widget -> obj.originalHeight },
                { obj: Widget, i: Int -> obj.originalHeight = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "XPositionMode",
                { obj: Widget -> obj.xPositionMode },
                { obj: Widget, i: Int -> obj.xPositionMode = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "YPositionMode",
                { obj: Widget -> obj.yPositionMode },
                { obj: Widget, i: Int -> obj.yPositionMode = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "WidthMode",
                { obj: Widget -> obj.widthMode },
                { obj: Widget, i: Int -> obj.widthMode = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "HeightMode",
                { obj: Widget -> obj.heightMode },
                { obj: Widget, i: Int -> obj.heightMode = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "LineHeight",
                { obj: Widget -> obj.lineHeight },
                { obj: Widget, i: Int -> obj.lineHeight = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "XTextAlignment",
                { obj: Widget -> obj.xTextAlignment },
                { obj: Widget, i: Int -> obj.xTextAlignment = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "YTextAlignment",
                { obj: Widget -> obj.yTextAlignment },
                { obj: Widget, i: Int -> obj.yTextAlignment = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "RelativeX",
                { obj: Widget -> obj.relativeX },
                { obj: Widget, i: Int -> obj.relativeX = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "RelativeY",
                { obj: Widget -> obj.relativeY },
                { obj: Widget, i: Int -> obj.relativeY = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "Width",
                { obj: Widget -> obj.width },
                { obj: Widget, i: Int -> obj.width = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "Height",
                { obj: Widget -> obj.height },
                { obj: Widget, i: Int -> obj.height = i },
                Int::class.java
            )
        )
        out.add(WidgetField("CanvasLocation", Widget::getCanvasLocation))
        out.add(WidgetField("Bounds", Widget::getBounds))
        out.add(
            WidgetField(
                "ScrollX",
                { obj: Widget -> obj.scrollX },
                { obj: Widget, i: Int -> obj.scrollX = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ScrollY",
                { obj: Widget -> obj.scrollY },
                { obj: Widget, i: Int -> obj.scrollY = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ScrollWidth",
                { obj: Widget -> obj.scrollWidth },
                { obj: Widget, i: Int -> obj.scrollWidth = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "ScrollHeight",
                { obj: Widget -> obj.scrollHeight },
                { obj: Widget, i: Int -> obj.scrollHeight = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "DragDeadZone",
                { obj: Widget -> obj.dragDeadZone },
                { obj: Widget, i: Int -> obj.dragDeadZone = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "DragDeadTime",
                { obj: Widget -> obj.dragDeadTime },
                { obj: Widget, i: Int -> obj.dragDeadTime = i },
                Int::class.java
            )
        )
        out.add(
            WidgetField(
                "NoClickThrough",
                { obj: Widget -> obj.noClickThrough },
                { obj: Widget, b: Boolean -> obj.noClickThrough = b },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "NoScrollThrough",
                { obj: Widget -> obj.noScrollThrough },
                { obj: Widget, b: Boolean -> obj.noScrollThrough = b },
                Boolean::class.java
            )
        )
        out.add(
            WidgetField(
                "TargetVerb",
                { obj: Widget -> obj.targetVerb },
                { obj: Widget, s: String? -> obj.targetVerb = s },
                String::class.java
            )
        )
        out.add(WidgetField("DragParent", Widget::getDragParent))
/*        out.add(WidgetField("ModalMode") label@{ w ->
            val attachment: WidgetNode? = client!!.componentTable[w.getParentId()]
            if (attachment != null) {
                return@label attachment.getModalMode()
            }
            null
        })*/
        out.add(WidgetField("OnOpListener", Widget::getOnOpListener))
        out.add(WidgetField("OnKeyListener", Widget::getOnKeyListener))
        out.add(WidgetField("OnLoadListener", Widget::getOnLoadListener))
        out.add(WidgetField("OnInvTransmitListener", Widget::getOnInvTransmitListener))
        out.add(WidgetField("OnVarTransmitListener", Widget::getOnVarTransmitListener))
        return out
    }
}