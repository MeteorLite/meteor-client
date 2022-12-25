package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.NPC

object Npc {

    inline infix fun <reified T> first(id:T) = getFirst(id)
    inline infix fun <reified T> exists(id: T) = contains(id)
    inline infix fun <reified T> exists(id: Iterable<T>) = contains(id)




    fun getAll(alive: Boolean = false, sortByDistance: Boolean = false): MutableList<NPC> {
        val npcs = Main.client.npcs.filter { (alive && !it.isDead) || !alive }.toMutableList()
        return if (sortByDistance) {
            npcs.sortBy { npc -> npc.distanceTo(Main.client.localPlayer) }
            npcs
        } else {
            npcs
        }
    }
    inline fun <reified T> getAll( ids: Iterable<T>,alive: Boolean = false, sortByDistance: Boolean = false): MutableList<NPC>  {
        return when(T::class) {
            Int::class ->   getAll().filter { obj -> ids.any { it == obj.id } }.toMutableList()
            String::class -> getAll().filter { obj -> ids.any { it.toString().lowercase() == obj.name.lowercase()}}.toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }
    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach{if(contains(it)) return true}
        return  false
    }
    inline fun <reified T> contains(id: T): Boolean {
        return when(T::class){
            Int::class -> getAll().any { it.id == id  }
            String::class -> getAll().any { it.name == id  }
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }
    inline fun <reified T> getFirst(id: T): NPC  {
        return when(T::class){
            Int::class -> getAll().first { it.id == id }
            String::class -> getAll().first { it.name.lowercase()  == id.toString().lowercase() }
            else -> throw IllegalArgumentException("Use the right type getFirst() requires  String || Int")
        }
    }

}