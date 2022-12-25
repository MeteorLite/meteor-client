package meteor.plugins.scriptcreator.script.api


import net.runelite.api.InventoryID

object Gear{
    inline infix fun <reified T> contains(id: T) = has(id, InventoryID.EQUIPMENT)
    inline infix fun <reified T> contains(id: MutableList<T>) = containsAll(id, InventoryID.EQUIPMENT)
    inline infix fun <reified T> first(id:T) = getFirst(id, InventoryID.EQUIPMENT)
}