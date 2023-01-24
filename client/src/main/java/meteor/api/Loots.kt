package meteor.api

import meteor.Main
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint

/**
 * an object for working with "ground items", we call them Loots
 * @author Null
 * @author Darwin
 */
object Loots {

    /**
     * gets all loots at the specified [worldPoint]
     * @param worldPoint the world location to check
     */
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

    /**
     * gets all loots
     * @param sortByDistance whether we should sort by distance nearest to farthest
     */
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

    /**
     * gets all loots with names matching provides [names]
     * @param names loot names we should look for
     * @param sortByDistance whether we should sort by distance nearest to farthest
     */
    fun getFirst(vararg names: String, sortByDistance: Boolean = true): TileItem? {
        return getAll(sortByDistance)?.firstOrNull { names.contains(it.getName())}
    }

    /**
     * gets all loots with names matching provides [ids]
     * @param ids loot ids we should look for
     * @param sortByDistance whether we should sort by distance nearest to farthest
     */
    fun getFirst(vararg ids: Int, sortByDistance: Boolean = true): TileItem? {
        return getAll(sortByDistance)?.firstOrNull { ids.contains(it.getId())}
    }

    /**
     * checks if any loot exists with the provided [name]
     * @param name loot name we should look for
     */
    fun exists(name: String): Boolean {
        return getAll()?.any { it.getName() == name } ?: false
    }

    /**
     * checks if any loot exists with the provided [names]
     * @param names loot names we should look for
     */
    fun exists(names: List<String>): Boolean {
        return getAll()?.any { it.getName() in names } ?: false
    }

    /**
     * checks if any loot exists with the provided [id]
     * @param id loot id we should look for
     */
    fun exists(id: Int): Boolean {
        return getAll()?.any { it.getId() == id || it.notedId == id } ?: false
    }
}