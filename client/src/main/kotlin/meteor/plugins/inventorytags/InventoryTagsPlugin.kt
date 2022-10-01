/*
 * Copyright (c) 2018 kulers
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
package meteor.plugins.inventorytags

import com.google.common.base.MoreObjects
import com.google.common.collect.ImmutableList
import eventbus.events.ConfigChanged
import meteor.config.ConfigManager
import meteor.menus.MenuManager
import meteor.menus.WidgetMenuOption
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.ColorUtil.prependColorTag
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.events.MenuOpened
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.util.*

@PluginDescriptor(
    name = "Inventory Tags",
    description = "Add the ability to tag items in your inventory",
    tags = ["highlight", "items", "overlay", "tagging"],
    enabledByDefault = false
)
class InventoryTagsPlugin : Plugin() {

    override val config: InventoryTagsConfig = configuration()
    private val overlay = overlay(InventoryTagsOverlay(this))

    private var editorMode = false
    fun getTag(itemId: Int): String? {
        val tag = ConfigManager.getConfiguration("inventorytags", ITEM_KEY_PREFIX + itemId)
        return if (tag == null || tag.isEmpty()) {
            null
        } else tag
    }

    private fun setTag(itemId: Int, tag: String) {
        ConfigManager.setConfiguration("inventorytags", ITEM_KEY_PREFIX + itemId, tag)
    }

    private fun unsetTag(itemId: Int) {
        ConfigManager.unsetConfiguration("inventorytags", ITEM_KEY_PREFIX + itemId)
    }

    @Throws(Exception::class)
    override fun onStart() {
        refreshInventoryMenuOptions()
    }

    @Throws(Exception::class)
    override fun onStop() {
        removeInventoryMenuOptions()
        editorMode = false
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "inventorytags") {
            overlay.invalidateCache()
        }
    }

    override fun onMenuOpened(it: MenuOpened) {
        val firstEntry = it.firstEntry
        if (firstEntry == null || !editorMode) {
            return
        }
        val itemId: Int =
            if (firstEntry.type == MenuAction.WIDGET_TARGET && firstEntry.widget!!.id == WidgetInfo.INVENTORY.id) {
                firstEntry.widget!!.itemId
            } else if (firstEntry.isItemOp) {
                firstEntry.itemId
            } else {
                return
            }

        // Set menu to only be Cancel
        client.menuEntries = Arrays.copyOf(client.menuEntries, 1)
        for (groupName in GROUPS) {
            val group = getTag(itemId)
            val color = getGroupNameColor(groupName)
            client.createMenuEntry(-1)
                .setOption(if (groupName == group) MENU_REMOVE else MENU_SET)
                .setTarget(prependColorTag(groupName, MoreObjects.firstNonNull(color, Color.WHITE)))
                .setType(MenuAction.RUNELITE)
                .onClick { e: MenuEntry ->
                    if (e.option == MENU_SET) {
                        setTag(itemId, groupName)
                    } else {
                        unsetTag(itemId)
                    }
                }
        }
    }

    fun getGroupNameColor(name: String?): Color? {
        when (name) {
            SETNAME_GROUP_1 -> return config.group1Color
            SETNAME_GROUP_2 -> return config.group2Color
            SETNAME_GROUP_3 -> return config.group3Color
            SETNAME_GROUP_4 -> return config.group4Color
            SETNAME_GROUP_5 -> return config.group5Color
            SETNAME_GROUP_6 -> return config.group6Color
        }
        return null
    }

    private fun removeInventoryMenuOptions() {
        MenuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE)
        MenuManager.removeManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE)
        MenuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE)
        MenuManager.removeManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE)
        MenuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE)
        MenuManager.removeManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE)
    }

    private fun refreshInventoryMenuOptions() {
        removeInventoryMenuOptions()
        if (editorMode) {
            MenuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_SAVE) { menuEntry: MenuEntry -> save(menuEntry) }
            MenuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_SAVE) { menuEntry: MenuEntry -> save(menuEntry) }
            MenuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE) { menuEntry: MenuEntry ->
                save(
                    menuEntry
                )
            }
        } else {
            MenuManager.addManagedCustomMenu(FIXED_INVENTORY_TAB_CONFIGURE) { menuEntry: MenuEntry ->
                configure(
                    menuEntry
                )
            }
            MenuManager.addManagedCustomMenu(RESIZABLE_INVENTORY_TAB_CONFIGURE) { menuEntry: MenuEntry ->
                configure(
                    menuEntry
                )
            }
            MenuManager.addManagedCustomMenu(RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE) { menuEntry: MenuEntry ->
                configure(
                    menuEntry
                )
            }
        }
    }

    private fun save(menuEntry: MenuEntry) {
        editorMode = false
        refreshInventoryMenuOptions()
    }

    private fun configure(menuEntry: MenuEntry) {
        editorMode = true
        refreshInventoryMenuOptions()
    }

    companion object {
        private const val ITEM_KEY_PREFIX = "item_"
        private const val SETNAME_GROUP_1 = "Group 1"
        private const val SETNAME_GROUP_2 = "Group 2"
        private const val SETNAME_GROUP_3 = "Group 3"
        private const val SETNAME_GROUP_4 = "Group 4"
        private const val SETNAME_GROUP_5 = "Group 5"
        private const val SETNAME_GROUP_6 = "Group 6"
        private const val CONFIGURE = "Configure"
        private const val SAVE = "Save"
        private const val MENU_TARGET = "Inventory Tags"
        private const val MENU_SET = "Mark"
        private const val MENU_REMOVE = "Remove"
        private val FIXED_INVENTORY_TAB_CONFIGURE = WidgetMenuOption(
            CONFIGURE,
            MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB
        )
        private val FIXED_INVENTORY_TAB_SAVE = WidgetMenuOption(
            SAVE,
            MENU_TARGET, WidgetInfo.FIXED_VIEWPORT_INVENTORY_TAB
        )
        private val RESIZABLE_INVENTORY_TAB_CONFIGURE = WidgetMenuOption(
            CONFIGURE,
            MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB
        )
        private val RESIZABLE_INVENTORY_TAB_SAVE = WidgetMenuOption(
            SAVE,
            MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_INVENTORY_TAB
        )
        private val RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_CONFIGURE = WidgetMenuOption(
            CONFIGURE,
            MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB
        )
        private val RESIZABLE_BOTTOM_LINE_INVENTORY_TAB_SAVE = WidgetMenuOption(
            SAVE,
            MENU_TARGET, WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_TAB
        )
        private val GROUPS: List<String> = ImmutableList.of(
            SETNAME_GROUP_6,
            SETNAME_GROUP_5,
            SETNAME_GROUP_4,
            SETNAME_GROUP_3,
            SETNAME_GROUP_2,
            SETNAME_GROUP_1
        )
    }
}