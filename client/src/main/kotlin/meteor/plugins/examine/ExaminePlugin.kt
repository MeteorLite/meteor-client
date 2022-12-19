/*
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
package meteor.plugins.examine

import eventbus.events.ChatMessage
import eventbus.events.GameStateChanged
import eventbus.events.MenuOptionClicked
import meteor.Main
import meteor.chat.QueuedMessage.Companion.builder
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.QuantityFormatter.formatNumber
import net.runelite.api.ChatMessageType
import net.runelite.api.ItemComposition
import net.runelite.api.ItemID
import net.runelite.api.MenuAction
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.chat.ChatColorType
import net.runelite.client.chat.ChatMessageBuilder
import net.runelite.client.chat.ChatMessageManager
import java.util.*
import kotlin.math.max

@PluginDescriptor(
    name = "Examine",
    description = "Shows additional examine information (eg. GE Average, HA Value)",
    tags = ["npcs", "items", "inventory", "objects", "prices", "high alchemy"]
)
class ExaminePlugin : Plugin() {
    private val pending: Deque<PendingExamine> = ArrayDeque()
    private val itemManager = Main.itemManager
    private val chatMessageManager = Main.chatMessageManager
    override fun onGameStateChanged(it: GameStateChanged) {
        pending.clear()
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption() != "Examine") {
            return
        }
        val type: ExamineType
        val id: Int
        var quantity = -1
        when (it.getMenuAction()) {
            MenuAction.EXAMINE_ITEM -> {
                type = ExamineType.ITEM
                id = it.getId()
                val widgetId = it.getParam1()
                val widgetGroup = WidgetInfo.TO_GROUP(widgetId)
                val widgetChild = WidgetInfo.TO_CHILD(widgetId)
                val widget = client.getWidget(widgetGroup, widgetChild)
                val widgetItem = widget!!.getWidgetItem(it.getParam0())
                quantity = if (widgetItem != null && widgetItem.id >= 0) widgetItem.quantity else 1

                // Examine on inventory items with more than 100000 quantity is handled locally and shows the item stack
                // count, instead of sending the examine packet, so that you can see how many items are in the stack.
                // Replace that message with one that formats the quantity using the quantity formatter instead.
                if (quantity >= 100000) {
                    val itemId = it.getId()
                    val message = ChatMessageBuilder()
                        .append(formatNumber(quantity.toLong())).append(" x ").append(
                            itemManager.getItemComposition(itemId)!!.name
                        )
                    chatMessageManager.queue(
                        builder()
                            .type(ChatMessageType.ITEM_EXAMINE)
                            .runeLiteFormattedMessage(message.build())
                    )
                    it.consume()
                }
            }
            MenuAction.EXAMINE_ITEM_GROUND -> {
                type = ExamineType.ITEM
                id = it.getId()
            }
            MenuAction.CC_OP_LOW_PRIORITY -> {
                type = ExamineType.IF3_ITEM // these are spoofed by us from a [proc,examine_item] script edit
                val qi = findItemFromWidget(it.getParam1(), it.getParam0()) ?: return
                quantity = qi[0]
                id = qi[1]
            }
            else -> return
        }
        val pendingExamine = PendingExamine()
        pendingExamine.responseType = type
        pendingExamine.id = id
        pendingExamine.quantity = quantity
        pending.push(pendingExamine)
    }

    override fun onChatMessage(it: ChatMessage) {
        val type: ExamineType = ExamineType.IF3_ITEM
        if (pending.isEmpty()) {
            return
        }
        val pendingExamine = pending.poll()
        if (pendingExamine.responseType != type) {
            return
        }
        val itemId = pendingExamine.id
        val itemQuantity = pendingExamine.quantity
        if (itemId == ItemID.COINS_995) {
            return
        }
        val itemComposition = itemManager.getItemComposition(itemId)
        getItemPrice(itemComposition!!.id, itemComposition, itemQuantity)
    }

    private fun findItemFromWidget(widgetId: Int, childIdx: Int): IntArray? {
        val widgetGroup = WidgetInfo.TO_GROUP(widgetId)
        val widget = client.getWidget(widgetId) ?: return null
        if (WidgetInfo.EQUIPMENT.groupId == widgetGroup) {
            val widgetItem = widget.getChild(1)
            if (widgetItem != null) {
                return intArrayOf(widgetItem.itemQuantity, widgetItem.itemId)
            }
        } else if (WidgetInfo.SMITHING_INVENTORY_ITEMS_CONTAINER.groupId == widgetGroup) {
            val widgetItem = widget.getChild(2)
            if (widgetItem != null) {
                return intArrayOf(widgetItem.itemQuantity, widgetItem.itemId)
            }
        } else if (WidgetID.SHOP_GROUP_ID == widgetGroup) {
            val widgetItem = widget.getChild(childIdx)
            if (widgetItem != null) {
                return intArrayOf(1, widgetItem.itemId)
            }
        } else {
            val widgetItem = widget.getChild(childIdx)
            if (widgetItem != null && widgetItem.itemId > -1) {
                return intArrayOf(widgetItem.itemQuantity, widgetItem.itemId)
            }
        }
        return null
    }

    fun getItemPrice(id: Int, itemComposition: ItemComposition?, quantity: Int) {
        // quantity is at least 1
        var quantity1 = quantity
        quantity1 = max(1, quantity1)
        val gePrice = itemManager.getItemPrice(id)
        val alchPrice = itemComposition!!.haPrice
        if (gePrice > 0 || alchPrice > 0) {
            val message = ChatMessageBuilder()
                .append(ChatColorType.NORMAL)
                .append("Price of ")
                .append(ChatColorType.HIGHLIGHT)
            if (quantity1 > 1) {
                message
                    .append(formatNumber(quantity1.toLong()))
                    .append(" x ")
            }
            message
                .append(itemComposition.name)
                .append(ChatColorType.NORMAL)
                .append(":")
            if (gePrice > 0) {
                message
                    .append(ChatColorType.NORMAL)
                    .append(" GE average ")
                    .append(ChatColorType.HIGHLIGHT)
                    .append(formatNumber(gePrice.toLong() * quantity1))
                if (quantity1 > 1) {
                    message
                        .append(ChatColorType.NORMAL)
                        .append(" (")
                        .append(ChatColorType.HIGHLIGHT)
                        .append(formatNumber(gePrice.toLong()))
                        .append(ChatColorType.NORMAL)
                        .append("ea)")
                }
            }
            if (alchPrice > 0) {
                message
                    .append(ChatColorType.NORMAL)
                    .append(" HA value ")
                    .append(ChatColorType.HIGHLIGHT)
                    .append(formatNumber(alchPrice.toLong() * quantity1))
                if (quantity1 > 1) {
                    message
                        .append(ChatColorType.NORMAL)
                        .append(" (")
                        .append(ChatColorType.HIGHLIGHT)
                        .append(formatNumber(alchPrice.toLong()))
                        .append(ChatColorType.NORMAL)
                        .append("ea)")
                }
            }
            chatMessageManager.queue(
                builder()
                    .type(ChatMessageType.ITEM_EXAMINE)
                    .runeLiteFormattedMessage(message.build())
            )
        }
    }
}