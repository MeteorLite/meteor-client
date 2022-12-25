package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint

object Loot {
    inline infix fun <reified T> first(id: T) = getFirst(id)
    inline infix fun <reified T> exists(id: T) = contains(id)
    inline infix fun <reified T> exists(id: Iterable<T>) = contains(id)

    fun getAt(worldPoint: WorldPoint) : MutableList<TileItem> {
        val loots: MutableList<TileItem> = mutableListOf()
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                        if (y.worldX == worldPoint.x && y.worldY == worldPoint.y && y.plane == worldPoint.plane) {
                            loots.addAll(y.groundItems)
                            return loots
                        }
                }
            }
        }
        return loots
    }
    fun getAll(sortByDistance: Boolean = false): ArrayList<TileItem>? {
        var loots: ArrayList<TileItem>? = null
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                    if (!y?.groundItems.isNullOrEmpty())
                        for (item in y.groundItems) {
                            if (loots == null) {
                                loots = ArrayList()
                                loots!!.add(item)
                            } else
                                loots!!.add(item)
                        }
                }
            }
        }
        loots?.let {
            if (sortByDistance) {
                return ArrayList(it.sortedBy { loot -> Main.client.localPlayer?.let { it1 -> loot.distanceTo(it1) } })
            }
        }
        return loots
    }
    inline fun <reified T> getFirst( name: T): TileItem {
        return getAll()!!.first { name == it.getName()}
    }

    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach{if(contains(it)) return true}
        return  false
    }
    inline fun <reified T> contains(id: T): Boolean {
        return when(T::class){
            Int::class -> getAll()!!.any { it.getId() == id || it.notedId == id } ?: false
            String::class -> getAll()!!.any { it.getName() == id  }?: false
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }
}