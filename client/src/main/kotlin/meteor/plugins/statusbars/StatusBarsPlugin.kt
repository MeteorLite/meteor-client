/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package meteor.plugins.statusbars

import eventbus.events.ConfigChanged
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.api.Varbits
import org.apache.commons.lang3.ArrayUtils

@PluginDescriptor(
    name = "Status Bars",
    description = "Draws status bars next to players inventory showing current HP & Prayer and healing amounts"
)
class StatusBarsPlugin : Plugin() {
    override val config = configuration<StatusBarsConfig>()
    private val overlay = overlay(StatusBarsOverlay(this, config))
    private val clientThread = ClientThread

    var barsDisplayed = false
    var lastCombatActionTickCount = 0
    override fun onStart() {
        clientThread.invokeLater { checkStatusBars() }
    }

    override fun onStop() {
        barsDisplayed = false
    }

    override fun onGameTick(it: GameTick) {
        checkStatusBars()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (StatusBarsConfig.GROUP == it.group && it.key.equals("hideAfterCombatDelay")) {
            clientThread.invokeLater { checkStatusBars() }
        }
    }

    private fun checkStatusBars() {
        val localPlayer = client.localPlayer ?: return
        val interacting = localPlayer.interacting
        if (config.hideAfterCombatDelay() == 0) {
            barsDisplayed = true
        } else if (interacting is NPC && ArrayUtils.contains(interacting.composition.actions, "Attack")
            || interacting is Player && client.getVarbitValue(Varbits.PVP_SPEC_ORB) == 1
        ) {
            lastCombatActionTickCount = client.tickCount
            barsDisplayed = true
        } else if (client.tickCount - lastCombatActionTickCount >= config.hideAfterCombatDelay()) {
            barsDisplayed = false
        }
    }
}