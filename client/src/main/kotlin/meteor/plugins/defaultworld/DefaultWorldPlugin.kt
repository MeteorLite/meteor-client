/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.plugins.defaultworld

import eventbus.Events
import eventbus.events.ClientTick
import eventbus.events.GameStateChanged
import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.Main
import meteor.config.ConfigManager
import meteor.game.WorldService
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.WorldUtil.toWorldTypes
import net.runelite.api.GameState
import org.rationalityfrontline.kevent.KEVENT

@PluginDescriptor(
    name = "Default World",
    description = "Enable a default world to be selected when launching the client",
    tags = ["home"]
)
class DefaultWorldPlugin : Plugin() {
    val log = Logger("Default World Plugin")

    //We always set last world, even if unsubscribed
    init {
        KEVENT.subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) {
            if (it.data.gameState == GameState.LOGGED_IN) {
                if (it.data.lastGameState == GameState.LOADING) {
                    return@subscribe
                }

                ConfigManager.setConfiguration("defaultworld", "lastWorld", client.world)
            }
        }
    }

    private val config = configuration<DefaultWorldConfig>()
    private val worldService = WorldService

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGIN_SCREEN) {
             if (applyWorld())
                 unsubscribe()
        }
    }

    private fun applyWorld() : Boolean {
        if (client.gameState != GameState.LOGIN_SCREEN) {
            return false
        }
        if (System.getProperty("cli.world") != null) {
            return false
        }
        val newWorld = if (config.useLastWorld()) config.lastWorld() else config.world()

        if (newWorld == 0)
            return false

        val correctedWorld = if (newWorld < 300) newWorld + 300 else newWorld

        /*
        Old School RuneScape worlds start on 301 so don't even bother trying to find lower id ones
        and also do not try to set world if we are already on it
        */
        if (correctedWorld <= 300 || client.world == correctedWorld) {
            return false
        }
        val worldResult = worldService.getWorlds()
        if (worldResult == null) {
            log.warn("Failed to lookup worlds.")
            return false
        }
        val world = worldResult.findWorld(correctedWorld)
        if (world == null) {
            log.warn("World {} not found.", correctedWorld)
            return false
        }
        val rsWorld = client.createWorld()
        rsWorld.activity = world.activity
        rsWorld.address = world.address
        rsWorld.id = world.id
        rsWorld.playerCount = world.players
        rsWorld.location = world.location
        rsWorld.types = toWorldTypes(world.types)
        client.changeWorld(rsWorld)
        return true
    }
}