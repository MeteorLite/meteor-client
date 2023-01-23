package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.Player

object Players {
    /**
     * Returns a list of all players in the current game.
     * @return a list of all players in the current game
     */
    fun getAll(): List<Player> {
        return Main.client.players.filterNotNull()
    }

    /**
     * Returns a list of all players in the current game with names that are contained in the specified list.
     * @param names the list of names to search for
     * @return a list of all players in the current game with names that are contained in the specified list
     */
    fun getAll(names: MutableList<String>): MutableList<Player>? {
        return getAll().filter { it.name in names }?.toMutableList()
    }

    /**
     * Returns the first player in the current game with a name that contains the specified string.
     * @param name the string to search for in player names
     * @return the first player in the current game with a name that contains the specified string, or null if no such player exists
     */
    fun getFirst(name: String): Player? {
        return getAll().firstOrNull { it.name.lowercase().contains(name) }
    }
}