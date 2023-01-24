package meteor.api

import meteor.Main

/**
 * an object for working with Players
 * @author Null
 */
object Players {

    /**
     * gets all players
     */
    fun getAll(): ArrayList<net.runelite.api.Player>? {
        var npcs: ArrayList<net.runelite.api.Player>? = null
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

    /**
     * gets all players whose name matches any of the provided [names]
     * @param names the player names we should filter for
     */
    fun getAll(vararg names: String): ArrayList<net.runelite.api.Player>? {
        return getAll()?.filter { names.contains(it.name) } as ArrayList?
    }

    /**
     * gets a player whose name matches the provided [name]
     * @param name the player name we should filter for
     */
    fun getFirst(name: String): net.runelite.api.Player? {
        return getAll(name)?.firstOrNull()
    }
}