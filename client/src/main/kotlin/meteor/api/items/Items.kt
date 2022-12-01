package meteor.api.items

import dev.hoot.api.commons.Time
import dev.hoot.api.game.GameThread
import dev.hoot.api.items.Bank
import dev.hoot.api.widgets.Dialog
import meteor.Main
import meteor.api.packets.ClientPackets
import net.runelite.api.InventoryID
import net.runelite.api.Item
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
        return getAll(id)?.any { it.id == id || it.notedId == id } ?: false
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

    fun getCount(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): Int {
        var count = 0
        getAll(*ids, container = container)?.forEach {
            count += it.quantity
        }
        return count
    }

    fun getCount(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): Int {
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

                    val newItem = Item(item.id, item.quantity)
                    newItem.widgetId = WidgetInfo.INVENTORY.packedId
                    newItem.slot = slot
                    if (items == null) {
                        items = ArrayList()
                        items!!.add(newItem)
                    } else
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

                    val newItem = Item(item.id, item.quantity)
                    newItem.widgetId = WidgetInfo.EQUIPMENT.packedId
                    newItem.slot = slot
                    if (items == null) {
                        items = ArrayList()
                        items!!.add(newItem)
                    } else
                        items!!.add(newItem)
                    slot++
                }
        }
        return items
    }

    fun getItems(items: List<Item>): List<IntArray> {
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

    fun getAtSlot(index: Int, inventoryID: InventoryID = InventoryID.INVENTORY): Item? {
        Main.client.getItemContainer(inventoryID)?.let {
            var slot = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (slot == index)
                        return Item(item.id, item.quantity)
                    slot++
                }
        }
        return null
    }

    fun getSlot(id: Int, inventoryID: InventoryID = InventoryID.INVENTORY): Int {
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

    fun isFull(inventoryID: InventoryID = InventoryID.INVENTORY): Boolean {
        when (inventoryID) {
            InventoryID.INVENTORY -> return getAll()?.size == 28
            else -> {
                return false
            }
        }
    }

    fun cacheItems(container: ItemContainer) {
        val uncached = Arrays.stream(container.items)
            .filter { x: Item ->
                !Main.client.isItemDefinitionCached(x.id)
            }
            .collect(Collectors.toList())
        if (!uncached.isEmpty()) {
            GameThread.invokeLater<Any?> {
                for (item in uncached) {
                    Main.client.getItemComposition(item.id)
                }
                null
            }
        }
    }

    fun getInventory(filter: Predicate<Item?>): List<Item> {
        val items: MutableList<Item> = ArrayList()
        val container = Main.client.getItemContainer(InventoryID.INVENTORY) ?: return items
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
        val items: List<Item> = getInventory { true }!!
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

    fun getFreeSlots(inventoryID: InventoryID = InventoryID.INVENTORY): Int {
        return when (inventoryID) {

            InventoryID.INVENTORY -> {
                getAll()?.let {
                    return 28 - it.size
                }
                return -1
            }
            else -> {
                -1
            }
        }
    }

    private fun hasAction(vararg actions: String): Boolean {
        return Arrays.stream(actions).anyMatch { x -> actions.contains(x) }
    }

    @JvmStatic
    fun withdraw(item: Item, amount: Int, withdrawMode: Bank.WithdrawMode? = Bank.WithdrawMode.DEFAULT) {
        if (Bank.isOpen()) {
            item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_ITEM_CONTAINER)

            val withdrawOption = Bank.WithdrawOption.ofAmount(item, amount)
            if (withdrawMode == Bank.WithdrawMode.NOTED && !Bank.isNotedWithdrawMode()) {
                Bank.setWithdrawMode(true)
                Time.sleepUntil({ Bank.isNotedWithdrawMode() }, 1200)
            }

            if (withdrawMode == Bank.WithdrawMode.ITEM && Bank.isNotedWithdrawMode()) {
                Bank.setWithdrawMode(false)
                Time.sleepUntil({ !Bank.isNotedWithdrawMode() }, 1200)
            }

            if (withdrawOption == Bank.WithdrawOption.X && hasAction("Withdraw-$amount")) {
                item.interact(Bank.WithdrawOption.LAST_QUANTITY.menuIndex)
            } else {
                item.interact(withdrawOption.menuIndex)
                if (withdrawOption == Bank.WithdrawOption.X) {
                    Time.sleepUntil({ Dialog.isEnterInputOpen() }, 1200)
                    Dialog.enterInput(amount)
                }
            }
        }
    }

    @JvmStatic
    fun deposit(item: Item, amount: Int) {
        if (Bank.isOpen()) {
            item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)

            val withdrawOption = Bank.WithdrawOption.ofAmount(item, amount)

            if (withdrawOption == Bank.WithdrawOption.X && hasAction("Deposit-$amount")) {
                item.interact(Bank.WithdrawOption.LAST_QUANTITY.menuIndex + 1)
            } else {
                val menu = item.getMenu(withdrawOption.menuIndex + 1)
                menu?.let {
                    ClientPackets.createClientPacket(it)!!.send()
                    if (withdrawOption == Bank.WithdrawOption.X) {
                        Dialog.enterInput(amount)
                    }
                }
            }
        }
    }

    @JvmStatic
    fun offer(item: Item, quantity: Int) {
        when (quantity) {
            1 -> item.interact("Offer")
            5 -> item.interact("Offer-5")
            10 -> item.interact("Offer-10")
            else -> if (quantity > item.quantity) {
                item.interact("Offer-All")
            } else {
                item.interact("Offer-X")
                Dialog.enterInput(quantity)
            }
        }
    }

    @JvmStatic
    fun withdrawLastQuantity(item: Item, withdrawMode: Bank.WithdrawMode = Bank.WithdrawMode.DEFAULT) {
        val withdrawOption = Bank.WithdrawOption.LAST_QUANTITY
        if (withdrawMode == Bank.WithdrawMode.NOTED && !Bank.isNotedWithdrawMode()) {
            Bank.setWithdrawMode(true)
        }

        if (withdrawMode == Bank.WithdrawMode.ITEM && Bank.isNotedWithdrawMode()) {
            Bank.setWithdrawMode(false)
        }

        item.interact(withdrawOption.menuIndex)
    }
}