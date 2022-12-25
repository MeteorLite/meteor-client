package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.Player

object Players {
    fun getAll(): MutableList<Player>? {
        var players: MutableList<Player>? = null
        for (player in Main.client.players) {
            if(players == null) {
                players = mutableListOf()
            }
            player?.let {
                    players.add(it)
            }
        }
        return players
    }

    fun getAll(names: MutableList<String>): MutableList<Player>? {
        return getAll()?.filter { names.contains(it.name) }?.toMutableList()
    }

    fun getFirst(name: String): Player? {
        return getAll()?.firstOrNull { it.name == name }
    }
}