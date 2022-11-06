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

import com.google.common.eventbus.Subscribe
import eventbus.events.ConfigChanged
import eventbus.events.GameObjectSpawned
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ObjectID
import net.runelite.api.coords.Direction
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.time.Instant

@PluginDescriptor(
    name = "Hunter",
    description = "Show the interactState of your traps",
    tags = ["overlay", "skilling", "timers"]
)
class HunterPlugin : Plugin() {
    internal val traps: MutableMap<WorldPoint, HunterTrap> = HashMap()

    private val config = configuration<HunterConfig>()
    private val overlay = overlay(TrapOverlay(this,config))

    private var lastActionTime = Instant.ofEpochMilli(0)
    private var lastTickLocalPlayerLocation: WorldPoint? = null

    override fun onStart() {
        overlay.updateConfig()
    }

    override fun onStop() {
        lastActionTime = Instant.ofEpochMilli(0)
        traps.clear()
    }

    @Subscribe
    override fun onGameObjectSpawned(event: GameObjectSpawned) {
        val gameObject = event.gameObject
        val trapLocation = gameObject.worldLocation
        val myTrap = traps[trapLocation]
        val localPlayer = client.localPlayer
        when (gameObject.id) {
            ObjectID.DEADFALL, ObjectID.MONKEY_TRAP ->         // If player is right next to "object" trap assume that player placed the trap
                if (localPlayer!!.worldLocation.distanceTo(trapLocation) <= 2) {
                    traps[trapLocation] = HunterTrap(gameObject)
                    lastActionTime = Instant.now()
                }
            ObjectID.MAGIC_BOX, ObjectID.BOX_TRAP_9380, ObjectID.BIRD_SNARE_9345 ->         // If the player is on that tile, assume he is the one that placed the trap
                // Note that a player can move and set up a trap in the same tick, and this
                // event runs after the player movement has been updated, so we need to
                // compare to the trap location to the last location of the player.
                if (lastTickLocalPlayerLocation != null
                    && trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0
                ) {
                    traps[trapLocation] = HunterTrap(gameObject)
                    lastActionTime = Instant.now()
                }
            ObjectID.NET_TRAP_9343, ObjectID.NET_TRAP, ObjectID.NET_TRAP_8992, ObjectID.NET_TRAP_9002 -> if (lastTickLocalPlayerLocation != null
                && trapLocation.distanceTo(lastTickLocalPlayerLocation) == 0
            ) {
                // Net traps facing to the north and east must have their tile translated.
                // As otherwise, the wrong tile is stored.
                val trapOrientation = gameObject.orientation.nearestDirection
                var translatedTrapLocation = trapLocation
                if (trapOrientation == Direction.SOUTH) translatedTrapLocation = trapLocation.dy(-1)
                else if (trapOrientation == Direction.WEST) translatedTrapLocation = trapLocation.dx(-1)
                traps[translatedTrapLocation] = HunterTrap(gameObject)
                lastActionTime = Instant.now()
            }
            ObjectID.MAGIC_BOX_19226, ObjectID.SHAKING_BOX, ObjectID.SHAKING_BOX_9382, ObjectID.SHAKING_BOX_9383, ObjectID.SHAKING_BOX_9384, ObjectID.BOULDER_20648, ObjectID.BOULDER_20649, ObjectID.BOULDER_20650, ObjectID.BOULDER_20651, ObjectID.BIRD_SNARE_9373, ObjectID.BIRD_SNARE_9375, ObjectID.BIRD_SNARE_9377, ObjectID.BIRD_SNARE_9379, ObjectID.BIRD_SNARE_9348, ObjectID.NET_TRAP_9004, ObjectID.NET_TRAP_8986, ObjectID.NET_TRAP_8734, ObjectID.NET_TRAP_8996, ObjectID.LARGE_BOULDER_28830, ObjectID.LARGE_BOULDER_28831 -> if (myTrap != null) {
                myTrap.state = HunterTrap.State.FULL
                myTrap.resetTimer()
                lastActionTime = Instant.now()
            }
            ObjectID.MAGIC_BOX_FAILED, ObjectID.BOX_TRAP_9385, ObjectID.BIRD_SNARE -> if (myTrap != null) {
                myTrap.state = HunterTrap.State.EMPTY
                myTrap.resetTimer()
                lastActionTime = Instant.now()
            }
            ObjectID.MAGIC_BOX_19225, ObjectID.BOX_TRAP, ObjectID.BOX_TRAP_2026, ObjectID.BOX_TRAP_2028, ObjectID.BOX_TRAP_2029, ObjectID.BOX_TRAP_9381, ObjectID.BOX_TRAP_9390, ObjectID.BOX_TRAP_9391, ObjectID.BOX_TRAP_9392, ObjectID.BOX_TRAP_9393, ObjectID.BOX_TRAP_9386, ObjectID.BOX_TRAP_9387, ObjectID.BOX_TRAP_9388, ObjectID.BOX_TRAP_9394, ObjectID.BOX_TRAP_9396, ObjectID.BOX_TRAP_9397, ObjectID.BIRD_SNARE_9346, ObjectID.BIRD_SNARE_9347, ObjectID.BIRD_SNARE_9349, ObjectID.BIRD_SNARE_9374, ObjectID.BIRD_SNARE_9376, ObjectID.BIRD_SNARE_9378, ObjectID.DEADFALL_19218, ObjectID.DEADFALL_19851, ObjectID.DEADFALL_20128, ObjectID.DEADFALL_20129, ObjectID.DEADFALL_20130, ObjectID.DEADFALL_20131, ObjectID.NET_TRAP_9003, ObjectID.NET_TRAP_9005, ObjectID.NET_TRAP_8972, ObjectID.NET_TRAP_8974, ObjectID.NET_TRAP_8985, ObjectID.NET_TRAP_8987, ObjectID.NET_TRAP_8993, ObjectID.NET_TRAP_8997, ObjectID.MONKEY_TRAP_28828, ObjectID.MONKEY_TRAP_28829 -> if (myTrap != null) {
                myTrap.state = HunterTrap.State.TRANSITION
            }
        }
    }

    /**
     * Iterates over all the traps that were placed by the local player and checks if the trap is
     * still there. If the trap is gone, it removes the trap from the local players trap collection.
     */
    @Subscribe
    override fun onGameTick(event: GameTick) {
        // Check if all traps are still there, and remove the ones that are not.
        val it: MutableIterator<Map.Entry<WorldPoint, HunterTrap>> = traps.entries.iterator()
        val tiles = client.scene.tiles
        val expire = Instant.now().minus(HunterTrap.Companion.TRAP_TIME.multipliedBy(2))
        while (it.hasNext()) {
            val (world, trap) = it.next()
            val local = LocalPoint.fromWorld(client, world)

            // Not within the client's viewport
            if (local == null) {
                // Cull very old traps
                if (trap.placedOn.isBefore(expire)) {
                    it.remove()
                    continue
                }
                continue
            }
            val tile = tiles[world.plane][local.sceneX][local.sceneY] ?: return
            val objects = tile.gameObjects
            var containsBoulder = false
            var containsAnything = false
            var containsYoungTree = false
            for (gameObj in objects) {
                if (gameObj != null) {
                    containsAnything = true
                    if (gameObj.id == ObjectID.BOULDER_19215
                        || gameObj.id == ObjectID.LARGE_BOULDER
                    ) {
                        containsBoulder = true
                        break
                    }

                    // Check for young trees (used while catching salamanders) in the tile.
                    // Otherwise, hunter timers will never disappear after a trap is dismantled
                    if (gameObj.id == ObjectID.YOUNG_TREE_8732 || gameObj.id == ObjectID.YOUNG_TREE_8990 || gameObj.id == ObjectID.YOUNG_TREE_9000 || gameObj.id == ObjectID.YOUNG_TREE_9341) {
                        containsYoungTree = true
                    }
                }
            }
            if (!containsAnything || containsYoungTree) {
                it.remove()
            } else if (containsBoulder) // For traps like deadfalls. This is different because when the trap is gone, there is still a GameObject (boulder)
            {
                it.remove()
            }
        }
        lastTickLocalPlayerLocation = client.localPlayer!!.worldLocation
    }

    @Subscribe
    override fun onConfigChanged(event: ConfigChanged) {
        if (event.group == "hunterplugin") {
            overlay.updateConfig()
        }
    }
}