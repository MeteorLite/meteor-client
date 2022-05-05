package meteor.api.loot

import meteor.Main

object Loots {
    fun getAll(): ArrayList<Loot>? {
        var loots : ArrayList<Loot>? = null
        Main.client.scene.tiles.forEach {z ->
            z?.forEach {x ->
                x?.forEach {y ->
                    if (!y?.groundItems.isNullOrEmpty())
                        for (item in y.groundItems) {
                            if (loots == null) {
                                loots = ArrayList()
                                loots!!.add(Loot(item))
                            }
                            else
                                loots!!.add(Loot(item))
                        }
                }
            }
        }
        return loots
    }

    fun getFirst(name: String): Loot? {
        return getAll()?.firstOrNull { it.loot.name == name }
    }

    fun getFirst(id: Int): Loot? {
        return getAll()?.firstOrNull { it.loot.id == id }
    }

    fun exists(name: String): Boolean {
        return getAll()?.any { it.loot.name == name } ?: false
    }

    fun exists(id: Int): Boolean {
        return getAll()?.any { it.loot.id == id || it.loot.notedId == id } ?: false
    }
}