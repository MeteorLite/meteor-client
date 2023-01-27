/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.tearsofguthix

import eventbus.events.DecorativeObjectDespawned
import eventbus.events.DecorativeObjectSpawned
import eventbus.events.GameStateChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import net.runelite.api.DecorativeObject
import net.runelite.api.GameState
import net.runelite.api.ObjectID
import java.time.Instant

@PluginDescriptor(
    name = "Tears Of Guthix",
    description = "Show timers for the Tears Of Guthix streams",
    tags = ["minigame", "overlay", "skilling", "timers", "tog"]
)
class TearsOfGuthixPlugin : Plugin() {
    private val config = configuration<TearsOfGuthixConfig>()
    private val overlay = TearsOfGuthixOverlay(this, config)
    val streams: MutableMap<DecorativeObject, Instant> = HashMap()
    override fun onStart() {
        overlayManager.add(overlay)
    }

    override fun onStop() {
        overlayManager.remove(overlay)
        streams.clear()
    }

    override fun onGameStateChanged(event: GameStateChanged) {
        when (event.gameState) {
            GameState.LOADING, GameState.LOGIN_SCREEN, GameState.HOPPING -> streams.clear()
            else -> {}
        }
    }

    override fun onDecorativeObjectSpawned(it: DecorativeObjectSpawned) {
        val `object` = it.decorativeObject
        if (`object`.id == ObjectID.BLUE_TEARS || `object`.id == ObjectID.BLUE_TEARS_6665 || `object`.id == ObjectID.GREEN_TEARS || `object`.id == ObjectID.GREEN_TEARS_6666) {
            if (client.localPlayer!!.worldLocation.regionID == TOG_REGION) {
                streams[it.decorativeObject] = Instant.now()
            }
        }
    }

    override fun onDecorativeObjectDespawned(it: DecorativeObjectDespawned) {
        if (streams.isEmpty()) {
            return
        }
        val `object` = it.decorativeObject
        streams.remove(`object`)
    }

    companion object {
        private const val TOG_REGION = 12948
    }
}