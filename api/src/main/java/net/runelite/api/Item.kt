/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.api

import dev.hoot.api.EntityNameable
import dev.hoot.api.Identifiable
import dev.hoot.api.SceneEntity
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.util.Randomizer
import net.runelite.api.util.Text
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Point
import java.awt.Rectangle
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.stream.Collectors

open class Item(val client: Client? = null, private val id : Int = 0, val quantity: Int = 0) : Identifiable, EntityNameable {
    override fun getId(): Int {
        return id
    }
    var slot = 0

    // Interaction
    var actionParam = 0
    var widgetId = 0
    override fun getName(): String? {
        val name = composition.name ?: return "null"
        return Text.removeTags(Text.sanitize(name))
    }

    val type: Type
        get() = Type[widgetId]

    fun calculateWidgetId(containerInfo: WidgetInfo?): Int {
        return calculateWidgetId(client!!.getWidget(containerInfo))
    }

    fun calculateWidgetId(containerWidget: Widget?): Int {
        if (containerWidget == null) {
            return -1
        }
        val children = containerWidget.children ?: return -1
        return Arrays.stream(children)
            .filter { x: Widget -> x.itemId == getId() }.findFirst()
            .map { obj: Widget -> obj.id }
            .orElse(-1)
    }

    val composition: ItemComposition
        get() = client!!.getItemComposition(getId())
    val isTradable: Boolean
        get() = composition.isTradeable
    val isStackable: Boolean
        get() = composition.isStackable
    val isMembers: Boolean
        get() = composition.isMembers
    val notedId: Int
        get() = composition.linkedNoteId
    val isNoted: Boolean
        get() = composition.note > -1
    val isPlaceholder: Boolean
        get() = composition.placeholderTemplateId > -1
    val storePrice: Int
        get() = composition.price
    val clickPoint: Point
        get() = Randomizer.getRandomPointIn(bounds)
    val rawActions: Array<String?>?
        get() {
            val widget = client!!.getWidget(widgetId)
            if (widget != null) {
                if (type == Type.EQUIPMENT) {
                    return widget.rawActions
                }
                val itemChild = widget.getChild(slot)
                return if (itemChild != null) {
                    itemChild.rawActions
                } else widget.rawActions
            }
            return null
        }

    fun getActionOpcode(action: Int): Int {
        if (action == 0) {
            if (rawActions!![0] == null) {
                return MenuAction.WIDGET_TARGET.id
            }
        }
        return if (action >= 4) MenuAction.CC_OP_LOW_PRIORITY.id else MenuAction.CC_OP.id
    }

    fun getMenu(actionIndex: Int): AutomatedMenu? {
        when (type) {
            Type.TRADE, Type.TRADE_INVENTORY -> {
                val widget = client!!.getWidget(widgetId)
                if (widget != null) {
                    val itemChild = widget.getChild(slot)
                    if (itemChild != null) {
                        return itemChild.getMenu(actionIndex)
                    }
                }
            }

            Type.EQUIPMENT, Type.INVENTORY -> return getMenu(
                actionIndex,
                if (actionIndex > 4) MenuAction.CC_OP_LOW_PRIORITY.id else MenuAction.CC_OP.id
            )

            Type.BANK, Type.BANK_INVENTORY -> return getMenu(actionIndex, MenuAction.CC_OP.id)
            Type.UNKNOWN -> client!!.logger.error("Couldn't determine item type for: {}, widgetid: {}", id, widgetId)
        }
        return null
    }

    fun getMenu(identifier: Int, opcode: Int, param0: Int, param1: Int): AutomatedMenu {
        return if (this is SceneEntity) {
            AutomatedMenu(
                identifier, opcode, param0, param1, -1, -1,
                (this as SceneEntity).tag
            )
        } else {
            AutomatedMenu(identifier, opcode, param0, param1, -1, -1)
        }
    }

    val actions: List<String>?
        get() = if (rawActions == null) {
            null
        } else Arrays.stream(rawActions).map { str: String? -> Text.removeTags(str) }
            .collect(Collectors.toList())

    fun getMenu(actionIndex: Int, opcode: Int): AutomatedMenu? {
        when (type) {
            Type.TRADE, Type.TRADE_INVENTORY -> {
                val itemWidget = client!!.getWidget(widgetId) ?: return null
                return itemWidget.getMenu(actionIndex, opcode)
            }

            Type.EQUIPMENT -> return getMenu(actionIndex + 1, opcode, actionParam, widgetId)
            Type.INVENTORY -> return getMenu(if (actionIndex == 0) 0 else actionIndex + 1, opcode, slot, widgetId)
            Type.BANK -> return getMenu(actionIndex, opcode, slot, WidgetInfo.BANK_ITEM_CONTAINER.packedId)
            Type.BANK_INVENTORY -> return getMenu(
                actionIndex,
                opcode,
                slot,
                WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId
            )

            Type.UNKNOWN -> client!!.logger.error("Couldn't determine item type for: {}, widgetid: {}", id, widgetId)
        }
        return null
    }

    private val bounds: Rectangle
        get() {
            val widget: Widget = client!!.getWidget(widgetId)
                ?: return Rectangle(-1, -1, 0, 0)
            if (type != Type.EQUIPMENT) {
                val slot = widget.getChild(slot)
                if (slot != null) {
                    return if (slot.bounds != null) slot.bounds else Rectangle(-1, -1, 0, 0)
                }
            }
            val bounds = widget.bounds
            if (bounds == null) {
                val itemBounds = widget.getWidgetItem(slot).canvasBounds
                return itemBounds ?: Rectangle(-1, -1, 0, 0)
            }
            return bounds
        }

    enum class Type(val inventoryID: InventoryID?) {
        INVENTORY(InventoryID.INVENTORY), EQUIPMENT(InventoryID.EQUIPMENT), BANK(InventoryID.BANK), BANK_INVENTORY(
            InventoryID.INVENTORY
        ),
        TRADE(InventoryID.TRADE), TRADE_INVENTORY(InventoryID.INVENTORY), UNKNOWN(null);

        companion object {
            operator fun get(widgetId: Int): Type {
                return when (WidgetInfo.TO_GROUP(widgetId)) {
                    WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID -> TRADE
                    WidgetID.PLAYER_TRADE_INVENTORY_GROUP_ID -> TRADE_INVENTORY
                    WidgetID.EQUIPMENT_GROUP_ID -> EQUIPMENT
                    WidgetID.BANK_GROUP_ID -> BANK
                    WidgetID.BANK_INVENTORY_GROUP_ID -> BANK_INVENTORY
                    WidgetID.INVENTORY_GROUP_ID -> INVENTORY
                    else -> UNKNOWN
                }
            }
        }
    }

    companion object {
        private val random = ThreadLocalRandom.current()
    }
}