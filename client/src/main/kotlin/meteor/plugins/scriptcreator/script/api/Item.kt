package meteor.plugins.scriptcreator.script.api


import net.runelite.api.InventoryID

object Item {

    inline infix fun <reified T> has(id: T) = has(id, InventoryID.INVENTORY)
    inline infix fun <reified T> hasAll(id: MutableList<T>) = has(id, InventoryID.INVENTORY)
    inline infix fun <reified T> hasAny(id: MutableList<T>) = getAll(id).any()
    inline infix fun <reified T> first(id:T) = getFirst(id)
    inline infix fun <reified T> firstIn(id:List<T>) = getAll(id).first()
    inline infix fun <reified T> carrying(id: T) = isCarrying(id, InventoryID.INVENTORY)
}
