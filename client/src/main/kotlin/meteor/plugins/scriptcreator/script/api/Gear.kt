package meteor.plugins.scriptcreator.script.api


import net.runelite.api.InventoryID

object Gear {
    /**
     * This function uses the `has` function to check if the player's equipment contains an item with an id
     * that matches the given id. If the id is of type Int, it will match based on the Item's id field.
     * If the id is of type String, it will match based on the Item's name field (case-insensitive).
     * If a matching item is found in the equipment, the function returns true, otherwise it returns false.
     *
     * @param id a value of type T, which can be either an Int or a String
     * @return a Boolean value indicating whether the player's equipment contains the specified id
     *
     *
     */
    inline infix fun <reified T> contains(id: T) = has(id, InventoryID.EQUIPMENT)

    /**
     * This function uses the `containsAll` function to check if the player's equipment contains all the items
     * with ids that match the given ids. If the ids are of type Int, it will match based on the Item's id field.
     * If the ids are of type String, it will match based on the Item's name field (case-insensitive).
     * If all the given ids are found in the equipment, the function returns true, otherwise it returns false.
     *
     * @param id a MutableList of values of type T, which can be either a list of Strings or Ints
     * @return a Boolean value indicating whether the player's equipment contains all the given ids
     *
     *
     */
    inline infix fun <reified T> contains(id: MutableList<T>) = containsAll(id, InventoryID.EQUIPMENT)

    /**
     * This function uses the `getFirst` function to get the first Item object in the player's equipment with an id
     * that matches the given id. If the id is of type Int, it will match based on the Item's id field.
     * If the id is of type String, it will match based on the Item's name field (case-insensitive).
     * The function passes the InventoryID.EQUIPMENT value to the `getFirst` function to specify that it should
     * search the player's equipment.
     *
     * @param id a value of type T, which can be either an Int or a String
     * @return the first Item object in the player's equipment with an id that matches the given id
     *
     *
     */
    inline infix fun <reified T> first(id: T) = getFirst(id, InventoryID.EQUIPMENT)
}