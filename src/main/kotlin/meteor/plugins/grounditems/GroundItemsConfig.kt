/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package meteor.plugins.grounditems

import meteor.config.legacy.*
import meteor.plugins.grounditems.GroundItemsConfig
import meteor.plugins.grounditems.config.PriceDisplayMode
import meteor.plugins.grounditems.config.ItemHighlightMode
import meteor.plugins.grounditems.config.MenuHighlightMode
import meteor.plugins.grounditems.config.ValueCalculationMode
import meteor.plugins.grounditems.config.DespawnTimerMode
import meteor.plugins.grounditems.config.HighlightTier
import java.awt.Color

@ConfigGroup("grounditems")
interface GroundItemsConfig : Config {
    @ConfigItem(
        keyName = "highlightedItems",
        name = "Highlighted Items",
        description = "Configures specifically highlighted ground items. Format: (item), (item)",
        position = 0,
        section = itemLists
    )
    fun highlightedItems(): String {
        return ""
    }

    @ConfigItem(keyName = "highlightedItems", name = "", description = "")
    fun setHighlightedItem(key: String)

    @ConfigItem(
        keyName = "hiddenItems",
        name = "Hidden Items",
        description = "Configures hidden ground items. Format: (item), (item)",
        position = 1,
        section = itemLists
    )
    fun hiddenItems() : String {
        return "Vial, Ashes, Coins, Bones, Bucket, Jug, Seaweed"
    }

    @ConfigItem(keyName = "hiddenItems", name = "", description = "")
    fun setHiddenItems(key: String)

    @ConfigItem(
        keyName = "showHighlightedOnly",
        name = "Show Highlighted items only",
        description = "Configures whether or not to draw items only on your highlighted list",
        position = 2
    )
    fun showHighlightedOnly(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "dontHideUntradeables",
        name = "Do not hide untradeables",
        description = "Configures whether or not untradeable items ignore hiding under settings",
        position = 3
    )
    fun dontHideUntradeables(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showMenuItemQuantities",
        name = "Show Menu Item Quantities",
        description = "Configures whether or not to show the item quantities in the menu",
        position = 4
    )
    fun showMenuItemQuantities(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "recolorMenuHiddenItems",
        name = "Recolor Menu Hidden Items",
        description = "Configures whether or not hidden items in right-click menu will be recolored",
        position = 5
    )
    fun recolorMenuHiddenItems(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "highlightTiles",
        name = "Highlight Tiles",
        description = "Configures whether or not to highlight tiles containing ground items",
        position = 6
    )
    fun highlightTiles(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "priceDisplayMode",
        name = "Price Display Mode",
        description = "Configures which price types are shown alongside ground item name",
        position = 9
    )
    fun priceDisplayMode(): PriceDisplayMode? {
        return PriceDisplayMode.BOTH
    }

    @ConfigItem(
        keyName = "itemHighlightMode",
        name = "Item Highlight Mode",
        description = "Configures how ground items will be highlighted",
        position = 10
    )
    fun itemHighlightMode(): ItemHighlightMode? {
        return ItemHighlightMode.BOTH
    }

    @ConfigItem(
        keyName = "menuHighlightMode",
        name = "Menu Highlight Mode",
        description = "Configures what to highlight in right-click menu",
        position = 11
    )
    fun menuHighlightMode(): MenuHighlightMode? {
        return MenuHighlightMode.NAME
    }

    @ConfigItem(
        keyName = "highlightValueCalculation",
        name = "Highlight Value Calculation",
        description = "Configures which coin value is used to determine highlight color",
        position = 12
    )
    fun valueCalculationMode(): ValueCalculationMode? {
        return ValueCalculationMode.HIGHEST
    }

    @get:ConfigItem(
        keyName = "hideUnderValue",
        name = "Hide under value",
        description = "Configures hidden ground items under both GE and HA value",
        position = 13
    )
    @get:Range(textInput = true)
    val hideUnderValue: Int
        get() = 0

    @Alpha
    @ConfigItem(
        keyName = "defaultColor",
        name = "Default items",
        description = "Configures the color for default, non-highlighted items",
        position = 14
    )
    fun defaultColor(): Color? {
        return Color.WHITE
    }

    @Alpha
    @ConfigItem(
        keyName = "highlightedColor",
        name = "Highlighted items",
        description = "Configures the color for highlighted items",
        position = 15
    )
    fun highlightedColor(): Color? {
        return Color.decode("#AA00FF")
    }

    @Alpha
    @ConfigItem(
        keyName = "hiddenColor",
        name = "Hidden items",
        description = "Configures the color for hidden items in right-click menu and when holding ALT",
        position = 16
    )
    fun hiddenColor(): Color? {
        return Color.GRAY
    }

    @Alpha
    @ConfigItem(
        keyName = "lowValueColor",
        name = "Low value items",
        description = "Configures the color for low value items",
        position = 17
    )
    fun lowValueColor(): Color? {
        return Color.decode("#66B2FF")
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "lowValuePrice",
        name = "Low value price",
        description = "Configures the start price for low value items",
        position = 18
    )
    fun lowValuePrice(): Int {
        return 20000
    }

    @Alpha
    @ConfigItem(
        keyName = "mediumValueColor",
        name = "Medium value items",
        description = "Configures the color for medium value items",
        position = 19
    )
    fun mediumValueColor(): Color? {
        return Color.decode("#99FF99")
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "mediumValuePrice",
        name = "Medium value price",
        description = "Configures the start price for medium value items",
        position = 20
    )
    fun mediumValuePrice(): Int {
        return 100000
    }

    @Alpha
    @ConfigItem(
        keyName = "highValueColor",
        name = "High value items",
        description = "Configures the color for high value items",
        position = 21
    )
    fun highValueColor(): Color? {
        return Color.decode("#FF9600")
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "highValuePrice",
        name = "High value price",
        description = "Configures the start price for high value items",
        position = 22
    )
    fun highValuePrice(): Int {
        return 1000000
    }

    @Alpha
    @ConfigItem(
        keyName = "insaneValueColor",
        name = "Insane value items",
        description = "Configures the color for insane value items",
        position = 23
    )
    fun insaneValueColor(): Color? {
        return Color.decode("#FF66B2")
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "insaneValuePrice",
        name = "Insane value price",
        description = "Configures the start price for insane value items",
        position = 24
    )
    fun insaneValuePrice(): Int {
        return 10000000
    }

    @ConfigItem(
        keyName = "onlyShowLoot",
        name = "Only show loot",
        description = "Only shows drops from NPCs and players",
        position = 25
    )
    fun onlyShowLoot(): Boolean {
        return false
    }

    @Range(max = 750)
    @ConfigItem(
        keyName = "doubleTapDelay",
        name = "Double-tap delay",
        description = "Delay for the double-tap ALT to hide ground items. 0 to disable.",
        position = 26
    )
    @Units(
        Units.MILLISECONDS
    )
    fun doubleTapDelay(): Int {
        return 250
    }

    @ConfigItem(
        keyName = "collapseEntries",
        name = "Collapse ground item menu",
        description = "Collapses ground item menu entries together and appends count",
        position = 27
    )
    fun collapseEntries(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "groundItemTimers",
        name = "Despawn timer",
        description = "Shows despawn timers for items you've dropped and received as loot",
        position = 28
    )
    fun groundItemTimers(): DespawnTimerMode? {
        return DespawnTimerMode.OFF
    }

    @ConfigItem(
        keyName = "textOutline",
        name = "Text Outline",
        description = "Use an outline around text instead of a text shadow",
        position = 29
    )
    fun textOutline(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showLootbeamForHighlighted",
        name = "Highlighted item lootbeams",
        description = "Configures lootbeams to show for all highlighted items.",
        position = 30
    )
    fun showLootbeamForHighlighted(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showLootbeamTier",
        name = "Lootbeam tier",
        description = "Configures which price tiers will trigger a lootbeam",
        position = 31
    )
    fun showLootbeamTier(): HighlightTier? {
        return HighlightTier.HIGH
    }

    companion object {
        @ConfigSection(
            name = "Item Lists",
            keyName = "itemLists",
            description = "The highlighted and hidden item lists",
            position = 0,
            closedByDefault = true
        )
        const val itemLists = "Item Lists"
    }
}