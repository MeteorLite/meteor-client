/*
 * Copyright (c) 2018, Charlie Waters
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
package meteor.plugins.itemprices

import meteor.game.ItemManager
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.Tooltip
import meteor.ui.overlay.TooltipManager
import meteor.util.ColorUtil
import meteor.util.QuantityFormatter
import net.runelite.api.*
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D


class ItemPricesOverlay(var plugin: ItemPricesPlugin) : Overlay() {
    val config = plugin.config
    private val tooltipManager = TooltipManager
    private val itemStringBuilder = StringBuilder()

    var itemManager = ItemManager

    init {
        position = OverlayPosition.DYNAMIC

    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (client.isMenuOpen) {
            return null
        }
        val menuEntries = client.menuEntries
        val last = menuEntries.size - 1
        if (last < 0) {
            return null
        }
        val menuEntry = menuEntries[last]
        val action = menuEntry.type
        val widgetId = menuEntry.param1
        val groupId = WidgetInfo.TO_GROUP(widgetId)
        val isAlching = menuEntry.option == "Cast" && menuEntry.target
            .contains("High Level Alchemy")
        when (action) {
            MenuAction.WIDGET_USE_ON_ITEM -> {
                if (!config.showWhileAlching() || !isAlching) {
                    return null
                }
                when (groupId) {
                    WidgetID.EXPLORERS_RING_ALCH_GROUP_ID -> {
                        if (!config.showWhileAlching()) {
                            return null
                        }
                        if (config.hideInventory() && !(config.showWhileAlching() && isAlching)) {
                            return null
                        }
                        // Make tooltip
                        val text = makeValueTooltip(menuEntry)
                        if (text != null) {
                            tooltipManager
                                .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                        }
                    }
                    WidgetID.INVENTORY_GROUP_ID -> {
                        if (config.hideInventory() && !(config.showWhileAlching() && isAlching)) {
                            return null
                        }
                        val text = makeValueTooltip(menuEntry)
                        if (text != null) {
                            tooltipManager
                                .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                        }
                    }
                    WidgetID.BANK_GROUP_ID, WidgetID.BANK_INVENTORY_GROUP_ID, WidgetID.SEED_VAULT_GROUP_ID, WidgetID.SEED_VAULT_INVENTORY_GROUP_ID -> {
                        val text = makeValueTooltip(menuEntry)
                        if (text != null) {
                            tooltipManager
                                .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                        }
                    }
                }
            }
            MenuAction.CC_OP, MenuAction.ITEM_USE, MenuAction.ITEM_FIRST_OPTION, MenuAction.ITEM_SECOND_OPTION, MenuAction.ITEM_THIRD_OPTION, MenuAction.ITEM_FOURTH_OPTION, MenuAction.ITEM_FIFTH_OPTION -> when (groupId) {
                WidgetID.EXPLORERS_RING_ALCH_GROUP_ID -> {
                    if (!config.showWhileAlching()) {
                        return null
                    }
                    if (config.hideInventory() && !(config.showWhileAlching() && isAlching)) {
                        return null
                    }
                    val text = makeValueTooltip(menuEntry)
                    if (text != null) {
                        tooltipManager
                            .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                    }
                }
                WidgetID.INVENTORY_GROUP_ID -> {
                    val text = makeValueTooltip(menuEntry)
                    if (text != null) {
                        tooltipManager
                            .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                    }
                    if (config.hideInventory() && !(config.showWhileAlching() && isAlching)) {
                        return null
                    }
                }
                WidgetID.BANK_GROUP_ID, WidgetID.BANK_INVENTORY_GROUP_ID, WidgetID.SEED_VAULT_GROUP_ID, WidgetID.SEED_VAULT_INVENTORY_GROUP_ID -> {
                    val text = makeValueTooltip(menuEntry)
                    if (text != null) {
                        tooltipManager
                            .add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                    }
                }
            }
            else -> {}
        }
        return null
    }

    private fun addTooltip(menuEntry: MenuEntry, isAlching: Boolean, groupId: Int) {
        // Item tooltip values
        when (groupId) {
            WidgetID.EXPLORERS_RING_ALCH_GROUP_ID -> {
                if (!config.showWhileAlching()) {
                    return
                }
                if (config.hideInventory() && (!config.showWhileAlching() || !isAlching)) {
                    return
                }
                // Make tooltip
                val text = makeValueTooltip(menuEntry)
                if (text != null) {
                    tooltipManager.add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                }
            }
            WidgetID.INVENTORY_GROUP_ID, WidgetID.POH_TREASURE_CHEST_INVENTORY_GROUP_ID -> {
                if (config.hideInventory() && (!config.showWhileAlching() || !isAlching)) {
                    return
                }
                val text = makeValueTooltip(menuEntry)
                if (text != null) {
                    tooltipManager.add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                }
            }
            WidgetID.BANK_GROUP_ID, WidgetID.BANK_INVENTORY_GROUP_ID, WidgetID.SEED_VAULT_GROUP_ID, WidgetID.SEED_VAULT_INVENTORY_GROUP_ID -> {
                val text = makeValueTooltip(menuEntry)
                if (text != null) {
                    tooltipManager.add(Tooltip(ColorUtil.prependColorTag(text, Color(238, 238, 238))))
                }
            }
        }
    }

    private fun makeValueTooltip(menuEntry: MenuEntry): String? {
        // Disabling both disables all value tooltips
        if (!config.showGEPrice() && !config.showHAValue()) {
            return null
        }
        val widgetId = menuEntry.param1
        var container: ItemContainer? = null

        // Inventory item
        when (widgetId) {
            INVENTORY_ITEM_WIDGETID, BANK_INVENTORY_ITEM_WIDGETID, EXPLORERS_RING_ITEM_WIDGETID, SEED_VAULT_INVENTORY_ITEM_WIDGETID -> {
                container = client.getItemContainer(InventoryID.INVENTORY)
            }
            BANK_ITEM_WIDGETID -> {
                container = client.getItemContainer(InventoryID.BANK)
            }
            SEED_VAULT_ITEM_WIDGETID -> {
                container = client.getItemContainer(InventoryID.SEED_VAULT)
            }
        }
        if (container == null) {
            return null
        }

        // Find the item in the container to get stack size
        val index = menuEntry.param0
        val item = container.getItem(index)
        return item?.let { getItemStackValueText(it) }
    }

    private fun getItemStackValueText(item: Item): String? {
        val id = itemManager.canonicalize(item.id)
        val qty = item.quantity

        // Special case for coins and platinum tokens
        if (id == ItemID.COINS_995) {
            return QuantityFormatter.formatNumber(qty.toLong()) + " gp"
        } else if (id == ItemID.PLATINUM_TOKEN) {
            return QuantityFormatter.formatNumber(qty * 1000L) + " gp"
        }
        val itemDef = itemManager.getItemComposition(id)

        // Only check prices for things with store prices
        if (itemDef!!.price <= 0) {
            return null
        }
        var gePrice = 0
        var haPrice = 0
        var haProfit = 0
        val itemHaPrice = itemDef.haPrice
        if (config.showGEPrice()) {
            gePrice = itemManager.getItemPrice(id)
        }
        if (config.showHAValue()) {
            haPrice = itemHaPrice
        }
        if (gePrice > 0 && itemHaPrice > 0 && config.showAlchProfit()) {
            haProfit = calculateHAProfit(itemHaPrice, gePrice)
        }
        return if (gePrice > 0 || haPrice > 0) {
            stackValueText(qty, gePrice, haPrice, haProfit)
        } else null
    }

    private fun stackValueText(qty: Int, gePrice: Int, haValue: Int, haProfit: Int): String {
        if (gePrice > 0) {
            itemStringBuilder.append("GE: ")
                .append(QuantityFormatter.quantityToStackSize(gePrice.toLong() * qty))
                .append(" gp")
            if (config.showEA() && qty > 1) {
                itemStringBuilder.append(" (")
                    .append(QuantityFormatter.quantityToStackSize(gePrice.toLong()))
                    .append(" ea)")
            }
        }
        if (haValue > 0) {
            if (gePrice > 0) {
                itemStringBuilder.append("</br>")
            }
            itemStringBuilder.append("HA: ")
                .append(QuantityFormatter.quantityToStackSize(haValue.toLong() * qty))
                .append(" gp")
            if (config.showEA() && qty > 1) {
                itemStringBuilder.append(" (")
                    .append(QuantityFormatter.quantityToStackSize(haValue.toLong()))
                    .append(" ea)")
            }
        }
        if (haProfit != 0) {
            val haColor = haProfitColor(haProfit)
            itemStringBuilder.append("</br>")
            itemStringBuilder.append("HA Profit: ")
                .append(ColorUtil.wrapWithColorTag((haProfit.toLong() * qty).toString(), haColor))
                .append(" gp")
            if (config.showEA() && qty > 1) {
                itemStringBuilder.append(" (")
                    .append(ColorUtil.wrapWithColorTag(haProfit.toString(), haColor))
                    .append(" ea)")
            }
        }

        // Build string and reset builder
        val text = itemStringBuilder.toString()
        itemStringBuilder.setLength(0)
        return text
    }

    private fun calculateHAProfit(haPrice: Int, gePrice: Int): Int {
        val natureRunePrice = itemManager.getItemPrice(ItemID.NATURE_RUNE)
        return haPrice - gePrice - natureRunePrice
    }

    companion object {
        private val INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.packedId
        private val BANK_INVENTORY_ITEM_WIDGETID = WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER
            .packedId
        private val BANK_ITEM_WIDGETID = WidgetInfo.BANK_ITEM_CONTAINER.packedId
        private val EXPLORERS_RING_ITEM_WIDGETID = WidgetInfo.EXPLORERS_RING_ALCH_INVENTORY
            .packedId
        private val SEED_VAULT_ITEM_WIDGETID = WidgetInfo.SEED_VAULT_ITEM_CONTAINER
            .packedId
        private val SEED_VAULT_INVENTORY_ITEM_WIDGETID = WidgetInfo.SEED_VAULT_INVENTORY_ITEMS_CONTAINER
            .packedId

        private fun haProfitColor(haProfit: Int): Color {
            return if (haProfit >= 0) Color.GREEN else Color.RED
        }
    }
}