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
package meteor.plugins.oneclickchins


import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint


@PluginDescriptor(
    name = "One Click Chinchompas",
    enabledByDefault = false,
    description = "one click chinchompas. Requires you to lay the traps initially(WHILE PLUGIN IS ON) as it only resets."
)
class Oneclickchinsplugin : Plugin() {
    private val traps: MutableMap<WorldPoint, BoxTrap?> = HashMap<WorldPoint, BoxTrap?>()
    private val fallenTraps: MutableMap<WorldPoint, BoxTrap?> = HashMap<WorldPoint, BoxTrap?>()
    private var timeout = 0
    private val config = configuration<Oneclickchinsconfig>()
    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject: GameObject = it.gameObject
        val trapLocation: WorldPoint = gameObject.worldLocation
        val myTrap = traps[trapLocation]
        when (gameObject.id) {
            ObjectID.BOX_TRAP_9380 ->                 // If the player is on that tile, assume he is the one that placed the trap
                // Note that a player can move and set up a trap in the same tick, and this
                // event runs after the player movement has been updated, so we need to
                // compare to the trap location to the last location of the player.
                if (trapLocation.distanceTo(client.localPlayer!!.worldLocation) == 0) {
                    traps[trapLocation] = BoxTrap(gameObject)
                    timeout = 0
                }

            ObjectID.SHAKING_BOX, ObjectID.SHAKING_BOX_9382, ObjectID.SHAKING_BOX_9383 -> {
                if (myTrap != null) {
                    myTrap.state = BoxTrap.State.FULL
                    myTrap.gameObject = it.gameObject
                    myTrap.resetTimer()
                }
                if (myTrap != null) {
                    myTrap.state = BoxTrap.State.EMPTY
                    myTrap.gameObject = it.gameObject
                    myTrap.resetTimer()
                }
            }

            ObjectID.BOX_TRAP_9385 -> if (myTrap != null) {
                myTrap.state = BoxTrap.State.EMPTY
                myTrap.gameObject = it.gameObject
                myTrap.resetTimer()
            }
        }
    }


    override fun onItemSpawned(it: ItemSpawned) {
        //if item spawn location matches where a lain trap was
        if (traps.values.any{ boxTrap: BoxTrap? ->
                boxTrap?.gameObject?.worldLocation == it.tile.worldLocation
            }) {
            traps.remove(it.item.tile.worldLocation)
            fallenTraps[it.tile.worldLocation] = BoxTrap(it)
        }
    }


    override fun onItemDespawned(it: ItemDespawned) {
        if (fallenTraps.values.
                any{ fallenBoxTrap: BoxTrap? -> fallenBoxTrap?.tileItem == it.item }
        ) {
            fallenTraps.remove(it.item.tile.worldLocation)
        }
    }
    override fun onStop() {
        traps.clear()
        fallenTraps.clear()
    }


    override fun onGameTick(it: GameTick) {
        if (timeout > 0) {
            timeout--
        }
    }

    override fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) return
        val text = "<col=00ff00>One Click Chinchompas"
        client.insertMenuItem(
            text, "", MenuAction.UNKNOWN
                .id, 0, 0, 0, true
        )
    }


    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption().equals("<col=00ff00>One Click Chinchompas")) handleClick(it)
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        val TRAP_RESET_ANIMATION = 5212
        if (client.localPlayer == null) return
        if (client.localPlayer!!.animation == TRAP_RESET_ANIMATION) {
            timeout = 9
        }
    }

    private fun handleClick(event: MenuOptionClicked) {
        if (timeout > 0) return
        if (client.players.size > 1 && config.playerspotted()) {
            event.consume()
            return
        }
        //i think pick up fallen ones IF there's less than 30s(.5) after they fall, gives some wiggle room.
        if (fallenTraps.values.any { boxTrap: BoxTrap? -> boxTrap?.trapTimeRemaining!! < 30 }
            || resetTrapMenuEntry() == null && resetExpiredTrapMenuEntry() != null) {
            event.menuEntry = resetExpiredTrapMenuEntry()!!
            return
        }
        if (resetTrapMenuEntry() != null) {
            event.menuEntry = resetTrapMenuEntry()!!
        }
    }

    private fun getLocation(tileObject: TileObject): Point {
        return if (tileObject is GameObject) tileObject.sceneMinLocation else Point(
            tileObject.localLocation.sceneX,
            tileObject.localLocation.sceneY
        )
    }

    private fun resetTrapMenuEntry(): MenuEntry? {
        val trap = getOptimalTrap(traps) ?: return null
        return createMenuEntry(
            trap.id,
            MenuAction.GAME_OBJECT_SECOND_OPTION,
            getLocation(trap).x,
            getLocation(trap).y,
            true
        )
    }

    private fun resetExpiredTrapMenuEntry(): MenuEntry? {
        val `object` = getOptimalFallenTrap(fallenTraps) ?: return null
        return createMenuEntry(
            `object`.getId(),
            MenuAction.GROUND_ITEM_FOURTH_OPTION,
            `object`.tile.localLocation.sceneX,
            `object`.tile.localLocation.sceneY,
            true
        )
    }

    fun createMenuEntry(
        identifier: Int,
        type: MenuAction?,
        param0: Int,
        param1: Int,
        forceLeftClick: Boolean
    ): MenuEntry {
        return client.createMenuEntry(0).setOption("").setTarget("").setIdentifier(identifier).setType(type)
            .setParam0(param0).setParam1(param1).setForceLeftClick(forceLeftClick)
    }

    private fun getOptimalTrap(boxTraps: Map<WorldPoint, BoxTrap?>): GameObject? {
        var boxtrap: BoxTrap?
        /*need to work on optimizing this, may be different depending on number of traps
        must never let a trap despawn or be visible to other players
        must never let a caught chin fall over
        full has high priority unless groundItem will despawn*/boxtrap =
            boxTraps.values.filter { boxTrap: BoxTrap? ->
                boxTrap!!.state == BoxTrap.State.FULL
            }.minByOrNull { obj: BoxTrap? -> obj!!.trapTimeRemaining }
        if (boxtrap == null) { //failed(empty) has lowest priority
            boxtrap = boxTraps.values
                .filter { boxTrap: BoxTrap? -> boxTrap!!.state == BoxTrap.State.EMPTY }.minByOrNull { obj: BoxTrap? -> obj!!.trapTimeRemaining }
        }
        return boxtrap?.gameObject
    }

    private fun getOptimalFallenTrap(fallenBoxTraps: Map<WorldPoint, BoxTrap?>): TileItem? {
        val fallenBoxTrap =
            fallenBoxTraps.values.minByOrNull { obj: BoxTrap? -> obj!!.trapTimeRemaining}

        return fallenBoxTrap?.tileItem
    }
}