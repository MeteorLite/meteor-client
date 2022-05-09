package meteor.api.items

import meteor.Main
import net.runelite.api.InventoryID
import net.runelite.api.widgets.WidgetInfo

object Items {

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
            InventoryID.INVENTORY -> return Main.client.getItemContainer(inventoryID)?.items?.filter {
                (it != null && it.name != "null")
            }?.size == 28
            else -> {return false}
        }
    }
}