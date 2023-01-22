/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package meteor.menus

import com.google.common.base.Preconditions
import com.google.common.collect.LinkedHashMultimap
import com.google.common.collect.Multimap
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOptionClicked
import eventbus.events.PlayerMenuOptionsChanged
import eventbus.events.WidgetMenuOptionClicked
import meteor.Main
import meteor.Main.client
import meteor.Main.eventBus
import meteor.Main.logger
import meteor.plugins.EventSubscriber
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import java.util.function.Consumer

object MenuManager : EventSubscriber() {

    //Maps the indexes that are being used to the menu option.
    private val playerMenuIndexMap: MutableMap<Int, String> = HashMap()

    //Used to manage custom non-player menu options
    private val managedMenuOptions: Multimap<Int, WidgetMenuOption> = LinkedHashMultimap.create()

    private const val IDX_LOWER = 4
    private const val IDX_UPPER = 8

    init {
        subscribe()
        eventListening = true
    }

    /**
     * Adds a CustomMenuOption to the list of managed menu options.
     *
     * @param customMenuOption The custom menu to add
     * @param callback callback to be called when the menu is clicked
     */
    fun addManagedCustomMenu(customMenuOption: WidgetMenuOption, callback: Consumer<MenuEntry>) {
        managedMenuOptions.put(customMenuOption.widgetId, customMenuOption)
        Main.onClicksWidget.put(customMenuOption, callback);
        //customMenuOption.callback = callback
    }

    /**
     * Removes a CustomMenuOption from the list of managed menu options.
     *
     * @param customMenuOption The custom menu to add
     */
    fun removeManagedCustomMenu(customMenuOption: WidgetMenuOption) {
        managedMenuOptions.remove(customMenuOption.widgetId, customMenuOption)
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (client.spellSelected || it.opcode != MenuAction.CC_OP.id) {
            return
        }
        val widgetId: Int = it.param1
        val options: Collection<WidgetMenuOption> = managedMenuOptions.get(widgetId)
        if (options.isEmpty()) {
            return
        }
        val menuEntries: Array<MenuEntry> = client.menuEntries

        // Menu entries are sorted with higher-index entries appearing toward the top of the minimenu, so insert older
        // managed menu entries at higher indices and work backward for newer entries so newly-added entries appear at
        // the bottom
        var insertIdx = -1
        for (currentMenu in options) {
            // Exit if we've inserted the managed menu entries already
            if (menuContainsCustomMenu(menuEntries, currentMenu)) {
                return
            }
            val menuEntry = client.createMenuEntry(insertIdx--)
                .setOption(currentMenu.menuOption)
                .setTarget(currentMenu.getMenuTarget())
                .setType(MenuAction.RUNELITE)
                .setParam1(widgetId)
            currentMenu.callback?.let {
                Main.onClicks[menuEntry] = it
            }
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuAction() != MenuAction.RUNELITE) {
            return
        }

        val widgetId: Int = it.getParam1()
        val options: Collection<WidgetMenuOption> = managedMenuOptions.get(widgetId)
        for (curMenuOption in options) {
            if (curMenuOption.getMenuTarget() == it.getMenuTarget() && curMenuOption.menuOption == it.getMenuOption()) {
                curMenuOption.widget?.let {widget ->
                    WidgetMenuOptionClicked(
                        it.getMenuOption()!!,
                        it.getMenuTarget()!!,
                        widget,
                        curMenuOption.widgetId
                    )
                    eventBus.post(eventbus.Events.WIDGET_MENU_OPTION_CLICKED, it)
                }
                return
            }
        }
    }

    fun addPlayerMenuItem(menuText: String) {
        Preconditions.checkNotNull(menuText)
        val playerMenuIndex = findEmptyPlayerMenuIndex()
        if (playerMenuIndex == IDX_UPPER) {
            return  // no more slots
        }
        addPlayerMenuItem(playerMenuIndex, menuText)
    }

    fun removePlayerMenuItem(menuText: String) {
        Preconditions.checkNotNull(menuText)
        for ((key, value) in playerMenuIndexMap) {
            if (value.equals(menuText, ignoreCase = true)) {
                removePlayerMenuItem(key)
                break
            }
        }
    }

    override fun onPlayerMenuOptionsChanged(it: PlayerMenuOptionsChanged) {
        val idx: Int = it.index
        val menuText = playerMenuIndexMap[idx]
            ?: return  // not our menu

        //Only allow adding unique options
        for (option in client.playerOptions) {
            if (option == menuText)
                return
        }

        // find new index for this option
        val newIdx = findEmptyPlayerMenuIndex()
        if (newIdx == IDX_UPPER) {
            return
        }
        playerMenuIndexMap.remove(idx)
        addPlayerMenuItem(newIdx, menuText)
    }

    private fun addPlayerMenuItem(playerOptionIndex: Int, menuText: String) {
        client.playerOptions[playerOptionIndex] = menuText
        client.playerOptionsPriorities[playerOptionIndex] = true
        client.playerMenuTypes[playerOptionIndex] = MenuAction.RUNELITE_PLAYER.id
        playerMenuIndexMap[playerOptionIndex] = menuText
    }

    private fun removePlayerMenuItem(playerOptionIndex: Int) {
        client.playerOptions[playerOptionIndex] = null
        playerMenuIndexMap.remove(playerOptionIndex)
    }

    /**
     * Find the next empty player menu slot index
     */
    private fun findEmptyPlayerMenuIndex(): Int {
        var index = IDX_LOWER
        val playerOptions = client.playerOptions
        while (index < IDX_UPPER && playerOptions[index] != null) {
            index++
        }
        return index
    }

    private fun menuContainsCustomMenu(menuEntries: Array<MenuEntry>, customMenuOption: WidgetMenuOption): Boolean {
        for (menuEntry in menuEntries) {
            val option: String = menuEntry.option
            val target: String = menuEntry.target
            if (option == customMenuOption.menuOption && target == customMenuOption.getMenuTarget()) {
                return true
            }
        }
        return false
    }
}