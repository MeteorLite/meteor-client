/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.hunter


import lombok.Getter
import lombok.Setter
import net.runelite.api.GameObject
import net.runelite.api.coords.WorldPoint
import java.time.Duration
import java.time.Instant

/**
 * Wrapper class for a GameObject that represents a hunter trap.
 */
internal class HunterTrap(gameObject: GameObject) {
    /**
     * The time in milliseconds when the trap was placed.
     */
    var placedOn: Instant

    /**
     * The interactState of the trap.
     */

    var state: State

    /**
     * The ID of the game object this is representing
     */

    val objectId: Int
    val worldLocation: WorldPoint

    /**
     * Constructor for a HunterTrap object
     *
     * @param gameObject The gameobject thats corresponds with this trap.
     */
    init {
        state = State.OPEN
        placedOn = Instant.now()
        objectId = gameObject.id
        worldLocation = gameObject.worldLocation
    }

    /**
     * Calculates how much time is left before the trap is collapsing.
     *
     * @return Value between 0 and 1. 0 means the trap was laid moments ago. 1 is a trap that's about
     * to collapse.
     */
    val trapTimeRelative: Double
        get() {
            val duration = Duration.between(placedOn, Instant.now())
            return if (duration < TRAP_TIME) duration.toMillis().toDouble() / TRAP_TIME.toMillis() else 1.0
        }

    /**
     * Resets the time value when the trap was placed.
     */
    fun resetTimer() {
        placedOn = Instant.now()
    }

    /**
     * The states a trap can be in.
     */
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
        FULL,

        /**
         * A trap that is closing.
         */
        TRANSITION
    }

    companion object {
        /**
         * A hunter trap stays up 1 minute before collapsing.
         */
        val TRAP_TIME = Duration.ofMinutes(1)
    }
}