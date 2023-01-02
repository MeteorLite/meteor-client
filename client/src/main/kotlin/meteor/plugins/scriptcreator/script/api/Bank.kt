package meteor.plugins.scriptcreator.script.api

import meteor.Main.client
import meteor.api.items.Items.deposit
import meteor.api.items.Items.withdraw
import net.runelite.api.InventoryID
import net.runelite.api.widgets.WidgetInfo

object Bank {

    /**
     *
     * Opens the player's bank by interacting with the first object found in the game world with the name "bank".
     * If the object has an interact option of "Use" or "Bank", it will be selected.
     *
     */
    val open: Unit?
        get()  = Object.getAll().sortedBy { client.localPlayer?.distanceTo(it.worldLocation) }
                    .find { it.name.contains("Bank", true) && (it.hasAction("Use") || it.hasAction("Bank")) }
                    ?.interact { it == "Bank" || "Use" == it }



    /**
     * This getter function checks the visibility of the WidgetInfo.BANK_ITEM_CONTAINER widget to determine
     * if the player's bank is currently open. If the widget is visible, the function returns true,
     * otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's bank is currently open
     *
     *
     */
    val isOpen: Boolean get() = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER)?.isVisible ?: false

    /**
     *
     * Deposits all currently equipped items by interacting with the WidgetInfo.BANK_DEPOSIT_EQUIPMENT widget
     * with the option "Deposit worn items".
     *
     */
    val depositEquipment get() = client.getWidget(WidgetInfo.BANK_DEPOSIT_EQUIPMENT)?.interact("Deposit worn items")

    /**
     *
     * Deposits all items in the player's inventory by interacting with the WidgetInfo.BANK_DEPOSIT_INVENTORY widget
     * with the option "Deposit inventory".
     *
     */
    val depositInventory get() = client.getWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY)?.interact("Deposit inventory")


    /**
     * This function uses the `withdraw` function to withdraw the maximum possible number of the specified item
     * from the player's bank. The item is identified by its name, and the number withdrawn is determined by
     * the maximum value of the Int data type (Int.MAX_VALUE).
     *
     * @param item a String representing the name of the item to withdraw
     * Withdraws the maximum possible number of the specified item from the player's bank.
     *
     *
     */
    infix fun withdrawAll(item: String) = withdraw(Item first item, Int.MAX_VALUE)

    /**
     * This function uses the `deposit` function to deposit all the specified item from the player's inventory
     * into the player's bank. The item is identified by its name, and the number deposited is determined by
     * the maximum value of the Int data type (Int.MAX_VALUE).
     *
     * @param item a String representing the name of the item to deposit
     * Deposits all the specified item from the player's inventory into the player's bank.
     *
     *
     */
    infix fun depositAll(item: String) = deposit(Item first item, Int.MAX_VALUE)

    /**
     * This getter function uses the `isFull` function to check if the player's bank is full.
     * It passes the InventoryID.BANK value to the `isFull` function to specify that it should check the bank.
     * If the bank is full, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's bank is full
     *
     *
     */
    val isFull: Boolean get() = isFull(InventoryID.BANK)

    /**
     * This getter function uses the `isEmpty` function to check if the player's bank is empty.
     * It passes the InventoryID.BANK value to the `isEmpty` function to specify that it should check the bank.
     * If the bank is empty, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's bank is empty
     *
     *
     */
    val isEmpty: Boolean get() = isEmpty(InventoryID.BANK)

    /**
     *
     * @param id a value of type T, which can be either an Int or a String
     * @return a Boolean value indicating whether the player's bank contains the specified id
     *
     * This function uses the `has` function to check if the player's bank contains an item with an id that
     * matches the given id. If the id is of type Int, it will match based on the Item's id field. If the id
     * is of type String, it will match based on the Item's name field (case-insensitive). If a matching item
     * is found in the bank, the function returns true, otherwise it returns false.
     *
     */
    inline infix fun <reified T> contains(id: T) = has(id, InventoryID.BANK)

    /**
     * This function uses the `containsAll` function to check if the player's bank contains all the items
     * with ids that match the given ids. If the ids are of type Int, it will match based on the Item's id field.
     * If the ids are of type String, it will match based on the Item's name field (case-insensitive). If all
     *
     *  the given ids are found in the bank, the function returns true, otherwise it returns false.
     *
     * @param id a MutableList of values of type T, which can be either a list of Strings or Ints
     * @return a Boolean value indicating whether the player's bank contains all the given ids
     *
     *
     */
    inline infix fun <reified T> contains(id: MutableList<T>) = containsAll(id, InventoryID.BANK)

    /**
     * This function uses the `getFirst` function to get the first Item object in the player's bank with an id
     * that matches the given id. If the id is of type Int, it will match based on the Item's id field. If the id
     * is of type String, it will match based on the Item's name field (case-insensitive). The function
     * passes the InventoryID.BANK value to the `getFirst` function to specify that it should search the player's bank.
     *
     * @param id a value of type T, which can be either an Int or a String
     * @return the first Item object in the player's bank with an id that matches the given id
     *
     *
     */
    inline infix fun <reified T> first(id: T) = getFirst(id, InventoryID.BANK)


}