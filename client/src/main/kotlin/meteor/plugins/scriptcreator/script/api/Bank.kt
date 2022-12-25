package meteor.plugins.scriptcreator.script.api
import net.runelite.api.InventoryID

object Bank {
    inline infix fun <reified T> contains(id: T) = has(id, InventoryID.BANK)
    inline infix fun <reified T> contains(id: MutableList<T>) = containsAll(id, InventoryID.BANK)
    inline infix fun <reified T> first(id:T) = getFirst(id, InventoryID.BANK)

}