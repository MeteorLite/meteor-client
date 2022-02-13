package meteor.api.items

import Main.client
import net.runelite.api.EquipmentInventorySlot
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.ItemContainer
import net.runelite.api.widgets.WidgetInfo
import java.util.ArrayList
import java.util.function.Predicate

class Equipment : Items() {
    override fun all(filter: Predicate<Item>): List<Item?> {
        val items: MutableList<Item?> = ArrayList()
        val container: ItemContainer = client.getItemContainer(InventoryID.EQUIPMENT)
            ?: return items
        Inventory.Companion.cacheItems(container)
        val containerItems = container.items
        var i = 0
        val containerItemsLength = containerItems.size
        while (i < containerItemsLength) {
            val item = containerItems[i]
            if (item.id != -1 && item.name != null && item.name != "null") {
                val widgetInfo = getEquipmentWidgetInfo(item.slot)
                item.actionParam = -1
                item.slot = i
                if (widgetInfo != null) {
                    item.widgetId = widgetInfo.packedId
                    if (filter.test(item)) {
                        items.add(item)
                    }
                }
            }
            i++
        }
        return items
    }

    companion object {
        private val EQUIPMENT = Equipment()
        fun getAll(filter: Predicate<Item>): List<Item?> {
            return EQUIPMENT.all(filter)
        }

        val all: List<Item?>
            get() = getAll { x: Item? -> true }

        fun getAll(vararg ids: Int): List<Item?>? {
            return EQUIPMENT.all(*ids)
        }

        fun getAll(vararg names: String): List<Item?>? {
            return EQUIPMENT.all(*names)
        }

        fun getFirst(filter: Predicate<Item>): Item? {
            return EQUIPMENT.first(filter)
        }

        fun getFirst(vararg ids: Int): Item? {
            return EQUIPMENT.first(*ids)
        }

        fun getFirst(vararg names: String): Item? {
            return EQUIPMENT.first(*names)
        }

        private fun getEquipmentWidgetInfo(itemIndex: Int): WidgetInfo? {
            for (equipmentInventorySlot in EquipmentInventorySlot.values()) {
                if (equipmentInventorySlot.slotIdx == itemIndex) {
                    return equipmentInventorySlot.widgetInfo
                }
            }
            return null
        }

        operator fun contains(filter: Predicate<Item>): Boolean {
            return EQUIPMENT.exists(filter)
        }

        operator fun contains(id: Int): Boolean {
            return EQUIPMENT.exists(id)
        }

        operator fun contains(name: String?): Boolean {
            return EQUIPMENT.exists(name)
        }

        fun fromSlot(slot: EquipmentInventorySlot): Item? {
            return getFirst { x: Item? -> slot.widgetInfo.packedId == x!!.widgetId }
        }
    }
}