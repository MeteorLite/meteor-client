package meteor.plugins.oneclickchins

import eventbus.events.ItemSpawned
import net.runelite.api.GameObject
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint
import java.time.Duration
import java.time.Instant

class BoxTrap {

    private val worldLocation: WorldPoint
    internal var tileItem: TileItem? = null
    var gameObject: GameObject? = null
    private var placedOn: Instant
    internal var state: State

    internal constructor(gameObject: GameObject) {
        state = State.OPEN
        placedOn = Instant.now()
        worldLocation = gameObject.worldLocation
        this.gameObject = gameObject
    }

    internal constructor(itemSpawned: ItemSpawned) {
        state = State.ITEM
        placedOn = Instant.now()
        worldLocation = itemSpawned.tile.worldLocation
        tileItem = itemSpawned.item
    }

    internal enum class State {
        /**
         * A laid out trap.
         */
        OPEN,

        /**
         * A trap that is empty.
         */
        EMPTY,

        /**
         * A trap that caught something.
         */
        FULL, ITEM
    }

    val trapTimeRemaining: Int
        get() {
            val duration = Duration.between(placedOn, Instant.now())
            return 60 - duration.toSecondsPart()
        }

    /**
     * Resets the time value when the trap was placed.
     */
    fun resetTimer() {
        placedOn = Instant.now()
    }
}