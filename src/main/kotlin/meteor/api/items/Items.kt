package meteor.api.items

import dev.hoot.api.commons.Predicates
import dev.hoot.api.game.Game
import dev.hoot.api.game.GameThread
import dev.hoot.api.items.Inventory
import meteor.Main
import net.runelite.api.InventoryID
import net.runelite.api.ItemContainer
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

object Items {


    fun inventoryContains(vararg ids: Int): Boolean {
        ids.forEach { if (inventoryContains(it)) return true }
        return false
    }

    fun inventoryContains(vararg names: String): Boolean {
        names.forEach { if (inventoryContains(it)) return true }
        return false
    }

    fun equipmentContains(vararg ids: Int): Boolean {
        ids.forEach { if (equipmentContains(it)) return true }
        return false
    }

    fun equipmentContains(vararg names: String): Boolean {
        names.forEach { if (equipmentContains(it)) return true }
        return false
    }

    fun inventoryContains(id: Int): Boolean {
        return getAll(id)?.any { it.id == id || it.notedId == id} ?: false
    }

    fun inventoryContains(name: String): Boolean {
        return getAll(name)?.any { it.name == name } ?: false
    }

    fun equipmentContains(id: Int): Boolean {
        return getAll(id, container = InventoryID.EQUIPMENT)?.any { it.id == id } ?: false
    }

    fun equipmentContains(name: String): Boolean {
        return getAll(name, container = InventoryID.EQUIPMENT)?.any { it.name == name } ?: false
    }

    fun bankContains(id: Int): Boolean {
        return getAll(id, container = InventoryID.BANK)?.any { it.id == id } ?: false
    }

    fun isCarrying(id: Int): Boolean {
        return inventoryContains(id) || equipmentContains(id)
    }

    fun isCarrying(name: String): Boolean {
        return inventoryContains(name) || equipmentContains(name)
    }

    fun getAll(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): ArrayList<Item>? {
        return getAll(container!!)?.filter { ids.contains(it.id) } as ArrayList?
    }

    fun getAll(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): ArrayList<Item>? {
        return getAll(container!!)?.filter { names.contains(it.name) } as ArrayList?
    }

    fun getFirst(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(*ids, container = container)?.firstOrNull()
    }
    fun getFirstBank(vararg ids: Int, container: InventoryID? = InventoryID.BANK): Item? {
        return getAll(*ids, container = container)?.firstOrNull()
    }

    fun getFirst(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(*names, container = container)?.firstOrNull()
    }

    fun getCount(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY) : Int {
        var count = 0
        getAll(*ids, container = container)?.forEach {
            count += it.quantity
        }
        return count
    }

    fun getCount(vararg names: String, container: InventoryID? = InventoryID.INVENTORY) : Int {
        var count = 0
        getAll(*names, container = container)?.forEach {
            count += it.quantity
        }
        return count
    }

    fun getAll(inventoryID: InventoryID = InventoryID.INVENTORY): ArrayList<Item>? {
        var items: ArrayList<Item>? = null
        Main.client.getItemContainer(inventoryID)?.let {
            var slot = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (item.id == -1) {
                        slot++
                        continue
                    }

                    val newItem = Item(Main.client, item.id, item.quantity)
                    newItem.widgetId = WidgetInfo.INVENTORY.packedId
                    newItem.slot = slot
                    if (items == null) {
                        items = ArrayList()
                        items!!.add(newItem)
                    }
                    else
                        items!!.add(newItem)
                    slot++
                }
        }
        return items
    }

    fun getAllGear(inventoryID: InventoryID = InventoryID.EQUIPMENT): ArrayList<Item>? {
        var items: ArrayList<Item>? = null
        Main.client.getItemContainer(inventoryID)?.let {
            var slot = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (item.id == -1) {
                        slot++
                        continue
                    }

                    val newItem = Item(Main.client, item.id, item.quantity)
                    newItem.widgetId = WidgetInfo.EQUIPMENT.packedId
                    newItem.slot = slot
                    if (items == null) {
                        items = ArrayList()
                        items!!.add(newItem)
                    }
                    else
                        items!!.add(newItem)
                    slot++
                }
        }
        return items
    }

    fun getItems(items: List<net.runelite.api.Item>): List<IntArray> {
        val retItems: MutableList<IntArray> = ArrayList()
        var currItemID = -1
        var currQuantity = -1
        items.forEach {
            when {
                it.id != currItemID -> {
                    if (currItemID != -1) {
                        retItems.add(intArrayOf(currItemID, currQuantity))
                    }
                    currItemID = it.id
                    currQuantity = it.quantity
                    if (items.size - 1 == items.indexOf(it)) {
                        retItems.add(intArrayOf(currItemID, currQuantity))
                    }
                    return@forEach
                }
                else -> {
                    currQuantity++
                    if (items.size - 1 == items.indexOf(it)) {
                        retItems.add(intArrayOf(currItemID, currQuantity))
                    }
                }
            }
        }
        return retItems
    }
    fun getAtSlot(index: Int, inventoryID: InventoryID = InventoryID.INVENTORY) : Item? {
        Main.client.getItemContainer(inventoryID)?.let {
            var slot = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (slot == index)
                        return Item(Main.client, item.id, item.quantity)
                    slot++
                }
        }
        return null
    }

    fun getSlot(id: Int, inventoryID: InventoryID = InventoryID.INVENTORY) : Int {
        Main.client.getItemContainer(inventoryID)?.let {
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

    fun isFull(inventoryID: InventoryID = InventoryID.INVENTORY) : Boolean {
        when (inventoryID) {
            InventoryID.INVENTORY -> return getAll()?.size == 28
            else -> {return false}
        }
    }
    fun cacheItems(container: ItemContainer) {
        val uncached = Arrays.stream(container.items)
            .filter { x: net.runelite.api.Item ->
                !Game.getClient().isItemDefinitionCached(x.id)
            }
            .collect(Collectors.toList())
        if (!uncached.isEmpty()) {
            GameThread.invokeLater<Any?> {
                for (item in uncached) {
                    Game.getClient().getItemComposition(item.id)
                }
                null
            }
        }
    }
    fun getInventory(filter: Predicate<net.runelite.api.Item?>): List<net.runelite.api.Item>? {
        val items: MutableList<net.runelite.api.Item> = java.util.ArrayList()
        val container = Game.getClient().getItemContainer(InventoryID.INVENTORY) ?: return items
        cacheItems(container)
        val containerItems = container.items
        var i = 0
        val containerItemsLength = containerItems.size
        while (i < containerItemsLength) {
            val item = containerItems[i]
            if (item.id != -1 && item.name != null && item.name != "null") {
                item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
                item.slot = i
                if (filter.test(item)) {
                    items.add(item)
                }
            }
            i++
        }
        return items
    }
    fun getFirstEmptySlot(): Int {
        val items: List<net.runelite.api.Item> = getInventory { true }!!
        var lastIndex = 0
        if (items.isEmpty()) {
            return lastIndex
        }
        items.forEach {
            if (it.slot - 1 > lastIndex) {
                return lastIndex + 1
            }
            lastIndex = it.slot
        }
        return if (lastIndex != 27) {
            lastIndex + 1
        } else -1
    }

    fun getFreeSlots(inventoryID: InventoryID = InventoryID.INVENTORY) : Int {
        return when (inventoryID) {
            InventoryID.INVENTORY -> 28 - getAll()?.size!!
            else -> {
                -1
            }
        }
    }

}