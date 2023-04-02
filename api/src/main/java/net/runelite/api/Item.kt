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
import eventbus.Events
import meteor.Logger
import meteor.api.loot.Interact
import net.runelite.api.util.Text
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Point
import java.awt.Rectangle
import java.util.*

import java.util.stream.Collectors

open class Item(private val id : Int = 0, val quantity: Int = 0) : Identifiable, EntityNameable {
    companion object {
        lateinit var client: Client
        var log = Logger("Item")
    }

    var slot = 0
    var actionParam = 0
    var widgetId = 0

    override fun getId(): Int {
        return id
    }

    override fun getName(): String? {
        val name = composition.name ?: return "null"
        return Text.removeTags(Text.sanitize(name))
    }

    val type: Type
        get() = Type[widgetId]

    fun calculateWidgetId(containerInfo: WidgetInfo?): Int {
        return calculateWidgetId(client.getWidget(containerInfo))
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
        get() = client.getItemComposition(getId())
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
            val widget = client.getWidget(widgetId)
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
                val widget = client.getWidget(widgetId)
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
            Type.UNKNOWN -> client.logger.error("Couldn't determine item type for: {}, widgetid: {}", id, widgetId)
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

    open fun hasAction(vararg actions: String): Boolean {
        val raw: Array<String?> = rawActions ?: return false
        return if (actions.isEmpty()) {
            Arrays.stream(raw).anyMatch { obj: String? ->
                Objects.nonNull(
                    obj
                )
            }
        } else Arrays.stream(actions).anyMatch { x: String? ->
            actions.contains(
                x
            )
        }
    }

    fun getMenu(actionIndex: Int, opcode: Int): AutomatedMenu? {
        when (type) {
            Type.TRADE, Type.TRADE_INVENTORY -> {
                val itemWidget = client.getWidget(widgetId) ?: return null
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

            Type.UNKNOWN -> client.logger.error("Couldn't determine item type for: {}, widgetid: {}", id, widgetId)
        }
        return null
    }

    fun getMenu(actionIndex: Int, opcode: Int, tileObject: TileObject): AutomatedMenu? {
        when (type) {
            Type.INVENTORY -> {
                val menu = getMenu(if (actionIndex == 0) 0 else actionIndex + 1, opcode, slot, widgetId)
                menu.identifier = tileObject.id
                menu.param0 = tileObject.worldLocation.x - client.baseX
                menu.param1 = tileObject.worldLocation.y - client.baseY
                return menu
            }
            else -> {}
        }
        return null
    }

    val jagexClickPoint: Point
        get() {
            val widget: Widget = client.getWidget(widgetId)
                ?: return Point(0, 0)
            if (type != Type.EQUIPMENT) {
                val slot = widget.getChild(slot)
                if (slot != null) {
                    return if (slot.bounds != null) slot.jagexClickPoint() else Point(0, 0)
                }
            }
            return widget.jagexClickPoint()
        }

    private val bounds: Rectangle
        get() {
            val widget: Widget = client.getWidget(widgetId)
                ?: return Rectangle(-1, -1, 0, 0)
            if (type != Type.EQUIPMENT) {
                widget.getChild(slot)?.let {
                    return Rectangle(it.canvasLocation.x, it.canvasLocation.y, it.width, it.height)
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

     fun use() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Use]")
        client.invokeMenuAction(
            "Use",
            "<col=ff9040>${name}</col>",
            0,
            MenuAction.WIDGET_TARGET.id,
            slot,
            WidgetInfo.INVENTORY.packedId,
            id,
            -1,
            -1
        )
    }

   infix fun useOn(item: Item) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        log.info("[Use-on Item] [${item.name}]")
        client.invokeMenuAction(
            "Use",
            "<col=ff9040>${name}</col><col=ffffff> -> <col=ff9040>${item.name}</col>",
            0,
            MenuAction.WIDGET_TARGET_ON_WIDGET.id,
            item.slot,
            WidgetInfo.INVENTORY.packedId,
            item.id,
            -1,
            -1
        )
    }

    infix fun useOn(npc: NPC) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        log.info("[Use-on NPC] [${npc.name}]")
        client.callbacks.post(Events.INTERACT, getMenu(0, MenuAction.WIDGET_TARGET_ON_NPC.id)?.let { Interact(it) })
    }

    infix fun useOn(player: Player) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        log.info("[Use-on Player] [${player.name}]")
        client.callbacks.post(Events.INTERACT, getMenu(0, MenuAction.WIDGET_TARGET_ON_PLAYER.id)?.let { Interact(it) })
    }

    infix fun useOn(loot: TileItem) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        log.info("[Use-on Loot] [${loot.getName()}]")
        client.callbacks.post(Events.INTERACT, getMenu(0, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM.id)?.let { Interact(it) })
    }

    infix fun useOn(obj: TileObject) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        log.info("[Use-on Object] [${obj.name}]")
        client.callbacks.post(Events.INTERACT, getMenu(0, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT.id, obj)?.let { Interact(it) })
    }

    fun spellUseOn() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Spell Use-on]")
        slot = getSlot(id)
        client.callbacks.post(Events.INTERACT, getMenu(0, MenuAction.WIDGET_USE_ON_ITEM.id)?.let { Interact(it) })
    }

    fun getSlot(id: Int): Int {
        client.getItemContainer(InventoryID.INVENTORY)?.let {
            var slot = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (item.id == id)
                        return slot
                    slot++
                }
        }
        return -1
    }

    fun wield() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Wield]")
        interact("Wield")
    }

    fun eat() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Eat]")
        interact("Eat")
    }

    fun drink() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Drink]")
        interact("Drink")
    }

    fun drop() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Drop]")
        interact("Drop")
    }

    fun rub() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Rub]")
        interact("Rub")
    }

    infix fun interact(action: String) {
        if (actions == null) {
            return
        }
        val index = rawActions?.indexOf(action)
        if (index == -1) {
            log.warn("Action idx not found for $action")
            return
        }
        if (index != null) {
            invoke(index)
        }
    }

    infix fun interact(idx: Int) {
        invoke(idx)
    }

    fun invoke(index: Int) {
        client.callbacks.post(Events.INTERACT, getMenu(index)?.let { Interact(it) })
    }
}