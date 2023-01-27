/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package meteor.plugins.blastmine

import eventbus.events.GameObjectSpawned
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import net.runelite.api.GameState
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(name = "Blast Mine", description = "Show helpful information for the Blast Mine minigame", tags = ["explode", "explosive", "mining", "minigame", "skilling"])
class BlastMinePlugin : Plugin() {
    val rocks: MutableMap<WorldPoint, BlastMineRock> = HashMap()
    private val config = configuration<BlastMinePluginConfig>()
    private val blastMineRockOverlay = BlastMineRockOverlay(this, config)
    private val blastMineOreCountOverlay = BlastMineOreCountOverlay(config)
    override fun onStart() {
        overlayManager.add(blastMineRockOverlay)
        overlayManager.add(blastMineOreCountOverlay)
    }

    override fun onStop() {
        overlayManager.remove(blastMineRockOverlay)
        overlayManager.remove(blastMineOreCountOverlay)
        val blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE)
        if (blastMineWidget != null) {
            blastMineWidget.isHidden = false
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject = it.gameObject
        val blastMineRockType: BlastMineRockType = BlastMineRockType.getRockType(gameObject.id)
                ?: return
        val newRock = BlastMineRock(gameObject, blastMineRockType)
        val oldRock = rocks[gameObject.worldLocation]
        if (oldRock == null || oldRock.type != newRock.type) {
            rocks[gameObject.worldLocation] = newRock
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            rocks.clear()
        }
    }

    override fun onGameTick(it: GameTick) {
        if (rocks.isEmpty()) {
            return
        }
        rocks.values.removeIf { rock: BlastMineRock -> rock.remainingTimeRelative == 1.0 && rock.type != BlastMineRockType.NORMAL || rock.remainingFuseTimeRelative == 1.0 && rock.type == BlastMineRockType.LIT }
    }
}