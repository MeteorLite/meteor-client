package meteor.api.players

import meteor.Main

object Players {
    fun getAll(): ArrayList<net.runelite.api.Player>? {
        var npcs : ArrayList<net.runelite.api.Player>? = null
        for (player in Main.client.players) {
            player?.let {
                if (npcs == null) {
                    npcs = ArrayList()
                    npcs!!.add(it)
                } else
                    npcs!!.add(it)
            }
        }
        return npcs
    }

    fun getAll(vararg names: String): ArrayList<net.runelite.api.Player>? {
        return getAll()?.filter { names.contains(it.name) } as ArrayList?
    }

    fun getFirst(name: String) : net.runelite.api.Player? {
        return getAll(name)?.firstOrNull()
    }
}