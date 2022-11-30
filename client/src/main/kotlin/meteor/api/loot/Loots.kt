package meteor.api.loot

import meteor.Main
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint

object Loots {
    fun getAt(worldPoint: WorldPoint) : ArrayList<TileItem>? {
        var loots: ArrayList<TileItem>? = null
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                    if (!y?.groundItems.isNullOrEmpty())
                    {
                        if (y.worldX == worldPoint.x && y.worldY == worldPoint.y && y.plane == worldPoint.plane) {
                            for (item in y.groundItems) {
                                if (loots == null) {
                                    loots = ArrayList()
                                    loots!!.add(item)
                                } else
                                    loots!!.add(item)
                            }
                            return loots
                        }
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

    fun getFirst(vararg names: String, sortByDistance: Boolean = true): TileItem? {
        return getAll(sortByDistance)?.firstOrNull { names.contains(it.getName())}
    }

    fun getFirst(vararg ids: Int, sortByDistance: Boolean = true): TileItem? {
        return getAll(sortByDistance)?.firstOrNull { ids.contains(it.getId())}
    }
    
    fun exists(name: String): Boolean {
        return getAll()?.any { it.getName() == name } ?: false
    }
    fun exists(name: List<String>): Boolean {
        return getAll()?.any { it.getName() in name } ?: false
    }
    fun exists(id: Int): Boolean {
        return getAll()?.any { it.getId() == id || it.notedId == id } ?: false
    }
}