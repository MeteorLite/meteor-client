package meteor.api.loot

import meteor.Main

object Loots {
    fun getAll(sortByDistance: Boolean = false): ArrayList<Loot>? {
        var loots: ArrayList<Loot>? = null
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                    if (!y?.groundItems.isNullOrEmpty())
                        for (item in y.groundItems) {
                            if (loots == null) {
                                loots = ArrayList()
                                loots!!.add(Loot(item))
                            } else
                                loots!!.add(Loot(item))
                        }
                }
            }
        }
        loots?.let {
            if (sortByDistance) {
                return ArrayList(it.sortedBy { loot -> loot.loot.distanceTo(Main.client.localPlayer) })
            }
        }
        return loots
    }

    fun getFirst(vararg names: String, sortByDistance: Boolean = true): Loot? {
        return getAll(sortByDistance)?.firstOrNull { names.contains(it.loot.name)}
    }

    fun getFirst(vararg ids: Int, sortByDistance: Boolean = true): Loot? {
        return getAll(sortByDistance)?.firstOrNull { ids.contains(it.loot.id)}
    }

    fun exists(name: String): Boolean {
        return getAll()?.any { it.loot.name == name } ?: false
    }

    fun exists(id: Int): Boolean {
        return getAll()?.any { it.loot.id == id || it.loot.notedId == id } ?: false
    }
}