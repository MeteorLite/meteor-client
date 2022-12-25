package meteor.plugins.scriptcreator.script.api

import meteor.api.items.Items
import net.runelite.api.InventoryID
import net.runelite.api.Item

inline fun <reified T>  getFirst(id: T, container : InventoryID = InventoryID.INVENTORY): Item {
    return when(T::class) {
        Int::class -> {
            when(container) {
                InventoryID.BANK -> Items.getAll(InventoryID.BANK)!!.first { it.id == id }
                InventoryID.INVENTORY -> Items.getAll(InventoryID.INVENTORY)!!.first { it.id == id }
                else -> throw IllegalArgumentException("Wrong container type")
            }
        }
        String::class -> {
            when(container) {
                InventoryID.BANK -> Items.getAll(InventoryID.BANK)!!.first {         it.name?.lowercase() == id.toString().lowercase() }
                InventoryID.INVENTORY -> Items.getAll(InventoryID.INVENTORY)!!.first {
                    it.name?.lowercase() == id.toString().lowercase()
                }
                else -> throw IllegalArgumentException("Wrong container type")
            }

            }
        else -> throw IllegalArgumentException("Use the right type getFirst() requires String || Int")
        }
}
inline fun <reified T> getAll( ids: Iterable<T>): MutableList<Item>  {
    return when(T::class) {
        Int::class ->   Items.getAll()!!.filter { obj -> ids.any { it == obj.id } }.toMutableList()
        String::class -> Items.getAll()!!.filter { obj -> ids.any { it.toString().lowercase() == obj.name?.lowercase()}}.toMutableList()
        else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
    }
}

inline fun <reified T> containsAll(ids: MutableList<T>, container: InventoryID): Boolean {
    ids.forEach { if (has(it, container )) return true }
    return false
}
inline fun<reified T> has(id: T, container: InventoryID): Boolean {
    return when(T::class){
        Int::class -> Items.getAll(container)!!.any { it.id == id } ?: false
        String::class -> Items.getAll(container)!!.any { it.name == id}?: false
        else -> throw IllegalArgumentException("Wrong type use Int || String")
    }
}


inline fun <reified T>isCarrying(id: T,container : InventoryID): Boolean {
    return has(id,container) || has(id,container)
}

