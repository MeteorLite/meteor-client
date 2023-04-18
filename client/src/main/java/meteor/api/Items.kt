package meteor.api

import dev.hoot.api.commons.Time
import dev.hoot.api.items.Bank
import dev.hoot.api.items.Bank.WithdrawMode
import dev.hoot.api.items.Bank.WithdrawOption
import dev.hoot.api.widgets.Dialog
import meteor.Main
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.queries.BankItemQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.*

/**
 * an object for working with Items in various item containers
 * @author Null
 * @author Darwin
 * @author Dab
 */
object Items {

    /**
     * checks if inventory contains at least one of the [ids] provided
     * @param ids a list of item ids to check for
     */
    fun inventoryContains(vararg ids: Int): Boolean {
        ids.forEach { if (inventoryContains(it)) return true }
        return false
    }

    /**
     * checks if inventory contains at least one of the [ids] provided as a mutable list
     * @param ids a mutable list of item ids to check for
     */
    fun inventoryContains(ids: MutableList<Int>): Boolean {
        ids.forEach { if (inventoryContains(it)) return true }
        return false
    }

    /**
     * checks if inventory contains at least one of the [names] provided
     * @param names a list of item names to check for
     */
    fun inventoryContains(vararg names: String): Boolean {
        names.forEach { if (inventoryContains(it)) return true }
        return false
    }

    /**
     * checks if equipped items contains at least one of the [ids] provided
     * @param ids a list of item ids to check for
     */
    fun equipmentContains(vararg ids: Int): Boolean {
        ids.forEach { if (equipmentContains(it)) return true }
        return false
    }

    /**
     * checks if equipped items contains at least one of the [names] provided
     * @param names a list of item names to check for
     */
    fun equipmentContains(vararg names: String): Boolean {
        names.forEach { if (equipmentContains(it)) return true }
        return false
    }

    /**
     * checks if inventory contains the [id] provided
     * @param id the item id to check for
     */
    fun inventoryContains(id: Int): Boolean {
        return getAll(id)?.any { it.id == id || it.notedId == id } ?: false
    }

    /**
     * checks if inventory contains the [name] provided
     * @param name the item name to check for
     */
    fun inventoryContains(name: String): Boolean {
        return getAll(name)?.any { it.name == name } ?: false
    }

    /**
     * checks if equipped items contains the [id] provided
     * @param id the item id to check for
     */
    fun equipmentContains(id: Int): Boolean {
        return getAll(id, container = InventoryID.EQUIPMENT)?.any { it.id == id } ?: false
    }

    /**
     * checks if equipped items contains the [name] provided
     * @param name the item name to check for
     */
    fun equipmentContains(name: String): Boolean {
        return getAll(name, container = InventoryID.EQUIPMENT)?.any { it.name == name } ?: false
    }

    /**
     * checks if bank contains the [id] provided
     * @param id the item id to check for
     */
    fun bankContains(id: Int): Boolean {
        return getAll(id, container = InventoryID.BANK)?.any { it.id == id } ?: false
    }

    /**
     * checks if inventory or quipped items contains the [id] provided
     * @param id the item id to check for
     */
    fun isCarrying(id: Int): Boolean {
        return inventoryContains(id) || equipmentContains(id)
    }

    /**
     * checks if inventory or quipped items contains the [name] provided
     * @param name the item id to check for
     */
    fun isCarrying(name: String): Boolean {
        return inventoryContains(name) || equipmentContains(name)
    }

    /**
     * checks the specified item [container] and returns all matching items with the [ids] provided
     * @param ids the item ids to look for
     * @param container the item container to check
     */
    fun getAll(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): ArrayList<Item>? {
        return getAll(container!!)?.filter { ids.contains(it.id) } as ArrayList?
    }

    /**
     * checks the specified item [container] and returns all matching items with the [names] provided
     * @param names the item names to look for
     * @param container the item container to check
     */
    fun getAll(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): ArrayList<Item>? {
        return getAll(container!!)?.filter { names.contains(it.name) } as ArrayList?
    }

    /**
     * checks the specified item [container] and returns the first matching item with the [ids] provided
     * @param ids the item ids to look for
     * @param container the item container to check
     */
    fun getFirst(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(*ids, container = container)?.firstOrNull()
    }

    /**
     * checks the specified item [container] and returns the first matching item with the [id] provided
     * @param ids the item id to look for
     * @param container the item container to check
     */
    fun getFirst(id: Int, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(id, container = container)?.firstOrNull()
    }

    /**
     * checks the specified item [container] and returns the first matching item with the [names] provided
     * @param names the item names to look for
     * @param container the item container to check
     */
    fun getFirst(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(*names, container = container)?.firstOrNull()
    }

    /**
     * checks the specified item [container] and returns the first matching item with the [name] provided
     * @param name the item name to look for
     * @param container the item container to check
     */
    fun getFirst(name: String, container: InventoryID? = InventoryID.INVENTORY): Item? {
        return getAll(name, container = container)?.firstOrNull()
    }

    /**
     * checks the specified item [container] and returns the first matching item that contains one of the [actions] provided
     * @param actions the item action to look for
     * @param container the item container to check
     */
    fun getFirstWithAction(action:String): Item? {
        return getAll()?.firstOrNull { it.hasAction(action) }
    }

    /**
     * checks the specified item [container] and returns the amount of items matching any of the [ids] provided
     * @param ids the item action to look for
     * @param container the item container to check
     */
    fun getCount(vararg ids: Int, container: InventoryID? = InventoryID.INVENTORY): Int {
        var count = 0
        getAll(*ids, container = container)?.forEach {
            count += it.quantity
        }
        return count
    }

    /**
     * checks the specified item [container] and returns the amount of items matching any of the [names] provided
     * @param names the item action to look for
     * @param container the item container to check
     */
    fun getCount(vararg names: String, container: InventoryID? = InventoryID.INVENTORY): Int {
        var count = 0
        getAll(*names, container = container)?.forEach {
            count += it.quantity
        }
        return count
    }

    /**
     * returns all items from a specified [container]
     * @param container the item container to check
     */
    fun getAll(container: InventoryID = InventoryID.INVENTORY): ArrayList<Item>? {
        var items: ArrayList<Item>? = null
        Main.client.getItemContainer(container)?.let {
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

    /**
     * returns an item at a specific [slot] in the specified [container]
     * @param slot the index of the [container] we are searching
     * @param container the item container to check
     */
    fun getAtSlot(slot: Int, container: InventoryID = InventoryID.INVENTORY): Item? {
        Main.client.getItemContainer(container)?.let {
            var idx = 0
            if (it.items.isNotEmpty())
                for (item in it.items) {
                    if (idx == slot)
                        return Item(item.id, item.quantity)
                    idx++
                }
        }
        return null
    }

    /**
     * returns the slot of an item with the specified [id] in the specified [container]
     * @param id the id of the item who's slot we are looking for
     * @param container the item container to check
     */
    fun getSlot(id: Int, container: InventoryID = InventoryID.INVENTORY): Int {
        Main.client.getItemContainer(container)?.let {
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

    /**
     * checks to see if the specified [container] is full
     * @param container the item container to check
     */
    fun isFull(container: InventoryID = InventoryID.INVENTORY): Boolean {
        return when (container) {
            InventoryID.INVENTORY -> getAll()?.size == 28
            else -> {
                false
            }
        }
    }

    /**
     * returns the first empty inventory slot or -1 if inventory is full
     */
    fun getFirstEmptyInventorySlot(): Int {
        var idx = 0
        while (idx < 28) {
            val item: Item? = getAtSlot(idx)
            item?.let {
                return idx
            }
            idx++
        }
        return -1
    }

    /**
     * returns the number of free slots in the specified item [container]
     * @param container the item container to check
     */
    fun getFreeSlots(container: InventoryID = InventoryID.INVENTORY): Int {
        return when (container) {

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

    /**
     * withdraws an [amount] of the specified [item] using the specified [withdrawMode]
     * @param item the item to withdraw
     * @param amount the amount to withdraw
     * @param withdrawMode the way the item will be withdrawn (Item/Note)
     */
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

            if (withdrawOption == Bank.WithdrawOption.X && item.actions?.contains("Withdraw-$amount") == true) {
                item.interact(Bank.WithdrawOption.LAST_QUANTITY.menuIndex)
            } else {
                when(amount) {
                    5 -> {item.interact(WithdrawOption.FIVE.menuIndex)}
                    10 -> {item.interact(WithdrawOption.TEN.menuIndex)}
                    else -> {
                        item.interact(withdrawOption.menuIndex)
                    }
                }
                
                if (withdrawOption == Bank.WithdrawOption.X) {
                    Time.sleepUntil({ Dialog.isEnterInputOpen() }, 1200)
                    Dialog.enterInput(amount)
                    Time.sleepUntil({ !Dialog.isOpen() }, 1200)
                }
            }
        }
    }

    fun withdrawAll(item: Item, withdrawMode: WithdrawMode = Bank.WithdrawMode.NOTED){
        if (Bank.isOpen()){
            item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_ITEM_CONTAINER)
            val withdrawOption = WithdrawOption.ALL
            if (withdrawMode == Bank.WithdrawMode.NOTED && !Bank.isNotedWithdrawMode()) {
                Bank.setWithdrawMode(true)
                Time.sleepUntil({ Bank.isNotedWithdrawMode() }, 1200)
            }

            item.interact(withdrawOption.menuIndex)
        }
    }

    /**
     * This is a holdover for a plugin awaiting rework
     */
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

    /**
     * deposits an [amount] of the specified [item]
     * @param item the item to deposit
     * @param amount the amount to deposit
     */
    @JvmStatic
    fun deposit(item: Item, amount: Int) {
        if (Bank.isOpen()) {
            item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)

            val withdrawOption = Bank.WithdrawOption.ofAmount(item, amount)

            if (withdrawOption == Bank.WithdrawOption.X && item.actions?.contains("Deposit-$amount") == true) {
                item.interact(Bank.WithdrawOption.LAST_QUANTITY.menuIndex + 1)
            } else if (withdrawOption == Bank.WithdrawOption.ALL && item.actions?.contains("Deposit-All") == true) {
                item.interact(Bank.WithdrawOption.ALL.menuIndex + 1)
            } else {
                val menu = item.getMenu(withdrawOption.menuIndex + 1)
                menu?.let {
                    ClientPackets.createClientPacket(it)!!.send()
                    if (withdrawOption == Bank.WithdrawOption.X) {
                        Dialog.enterInput(amount)
                        Time.sleepUntil({ !Dialog.isOpen() }, 1200)
                    }
                }
            }
        }
    }

    /**
     * withdraws the last amount used of the specified [item] using the specified [withdrawMode]
     * @param item the item to withdraw
     * @param withdrawMode the way the item will be withdrawn (Item/Note)
     */
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

    fun getBankItemWidget(id: Int): Widget? {
        return BankItemQuery().idEquals(id).result(Main.client).first()?.widget
    }

    /**
     * offer the specified [quantity] of the specified [item] on the Grand Exchange
     * @param item the item to deposit
     * @param quantity the amount to deposit
     */
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
                Time.sleepUntil({ !Dialog.isOpen() }, 1200)
            }
        }
    }
}