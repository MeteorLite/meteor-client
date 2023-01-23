package meteor.plugins.scriptcreator.script.api


import net.runelite.api.InventoryID

object Item {

    /**
     * This function uses the `has` function to check if the player's inventory contains an item with an id
     * that matches the given id. If the id is of type Int, it will match based on the Item's id field.
     * If the id is of type String, it will match based on the Item's name field (case-insensitive).
     * If a matching item is found in the inventory, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's inventory contains the specified id
     *
     * @param id a value of type T, which can be either an Int or a String
     *
     */
    inline infix fun <reified T> has(id: T) = has(id, InventoryID.INVENTORY) ?: false



    /**
     * This function uses the `has` function to check if the player's inventory contains all the items
     * with ids that match the given ids. If the ids are of type Int, it will match based on the Item's id field.
     * If the ids are of type String, it will match based on the Item's name field (case-insensitive).
     * If all the given ids are found in the inventory, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's inventory contains all the given ids
     * @param id a List of values of type T, which can be either a list of Strings or Ints
     *

     */
    inline infix fun <reified T> hasAll(id: List<T>) = has(id, InventoryID.INVENTORY)

    /**
     *
     * This function uses the `getAll` function to get all the items in the player's inventory that have an id
     * that matches any of the given ids. If the ids are of type Int, it will match based on the Item's id field.
     * If the ids are of type String, it will match based on the Item's name field (case-insensitive).
     * If any matching items are found in the inventory, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's inventory contains any of the given ids
     * @param id a List of values of type T, which can be either a list of Strings or Ints
     *

     */
    inline infix fun <reified T> hasAny(id: List<T>) = getAll(id).any()


    /**
     *
     * This function uses the `getFirst` function to get the first item in the player's inventory
     * with an id that matches the given id. If the id is of type Int, it will match based on the Item's id field.
     * If the id is of type String, it will match based on the Item's name field (case-insensitive).
     * If a matching item is found in the inventory, it is returned, otherwise an IllegalArgumentException is thrown.
     *
     * @return the first item in the player's inventory that matches the given id
     *
     * @param id a value of type T, which can be either an Int or a String
     */
    inline infix fun <reified T> first(id: T) = getFirst(id)

    /**
     *
     * This function uses the `getAll` function to get a list of all items in the player's inventory
     * with ids that match any of the given ids. If the ids are of type Int, it will match based on the Item's id field.
     * If the ids are of type String, it will match based on the Item's name field (case-insensitive).
     * If at least one matching item is found in the inventory, the first item in the list is returned,
     * otherwise an IllegalArgumentException is thrown.
     *
     * @return the first item in the player's inventory that matches any of the given ids
     *
     * @param ids a List of values of type T, which can be either a list of Strings or Ints
     *
     */
    inline infix fun <reified T> firstIn(id: List<T>) = getAll(id).first()

    /**
     *
     *
     * This function uses the `isCarrying` function to check if the player is currently carrying an item with an id
     * that matches the given id in their inventory. If the id is of type Int, it will match based on the Item's id field.
     * If the id is of type String, it will match based on the Item's name field (case-insensitive).
     * If a matching item is found in the inventory, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player is currently carrying the specified id in their inventory
     *
     * @param id a value of type T, which can be either an Int or a String
     *
     */
    inline infix fun <reified T> carrying(id: T) = isCarrying(id, InventoryID.INVENTORY)

    /**
     *
     * This function uses the `isFull` function to check if the player's inventory is full.
     * If the inventory is full, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's inventory is full
     *
     *
     */
    val isFull: Boolean get() = isFull(InventoryID.INVENTORY)

    /**
     *
     *
     * This function uses the `isEmpty` function to check if the player's inventory is empty.
     * If the inventory is empty, the function returns true, otherwise it returns false.
     *
     * @return a Boolean value indicating whether the player's inventory is empty
     *
     *
     */
    val isEmpty: Boolean get() = isEmpty(InventoryID.INVENTORY)
}
