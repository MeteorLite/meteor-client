package meteor.api.entities

import Main.client

import net.runelite.api.Player
import net.runelite.api.coords.WorldPoint
import java.util.function.Predicate
import java.util.stream.Collectors

class Players : Entities<Player>() {
    override fun all(filter: Predicate<in Player>): List<Player> {
        return client.getPlayers()
            .stream()
            .filter(filter)
            .collect(Collectors.toList())
    }

    companion object {
        private val PLAYERS = Players()
        fun getAll(filter: Predicate<Player>): List<Player> {
            return PLAYERS.all(filter)
        }

        fun getAll(vararg names: String): List<Player?> {
            return PLAYERS.all(*names)
        }

        fun getNearest(filter: Predicate<Player?>): Player? {
            return getNearest(local.worldLocation, filter)
        }

        fun getNearest(vararg names: String): Player? {
            return getNearest(local.worldLocation, *names)
        }

        fun getNearest(to: WorldPoint?, filter: Predicate<Player?>): Player? {
            return PLAYERS.nearest(to, filter)
        }

        fun getNearest(to: WorldPoint?, vararg names: String): Player? {
            return PLAYERS.nearest(to, *names)
        }

        val hintArrowed: Player
            get() = client.getHintArrowPlayer()
        val local: Player
            get() = client.getLocalPlayer()
                ?: throw IllegalStateException("Local player was null")
    }
}