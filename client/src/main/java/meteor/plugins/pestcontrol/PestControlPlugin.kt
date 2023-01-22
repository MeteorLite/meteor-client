/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO it SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.pestcontrol

import com.google.common.collect.ImmutableSet
import eventbus.events.ChatMessage
import eventbus.events.GameStateChanged
import eventbus.events.NpcDespawned
import eventbus.events.NpcSpawned
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ChatMessageType
import net.runelite.api.GameState
import net.runelite.api.NPC
import net.runelite.api.NpcID
import java.util.regex.Pattern

@PluginDescriptor(
    name = "Pest Control",
    description = "Show helpful information for the Pest Control minigame",
    tags = ["minigame", "overlay"]
)
class PestControlPlugin : Plugin() {
    private val SHIELD_DROP =
        Pattern.compile("The ([a-z]+), [^ ]+ portal shield has dropped!", Pattern.CASE_INSENSITIVE)

    val spinners: MutableList<NPC> = ArrayList()

    private val overlay = overlay(PestControlOverlay(this))

    override fun onStop() {
        spinners.clear()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        val gameState: GameState = it.gameState;
        
        if (gameState == GameState.CONNECTION_LOST || gameState == GameState.LOGIN_SCREEN || gameState == GameState.HOPPING) {
            spinners.clear()
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (overlay.game != null && it.type === ChatMessageType.GAMEMESSAGE) {
            val matcher = SHIELD_DROP.matcher(it.message)
            if (matcher.lookingAt()) {
                overlay.game!!.fall(matcher.group(1))
            }
        }
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc: NPC = it.npc
        if (SPINNER_IDS.contains(npc.id)) {
            spinners.add(npc)
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        spinners.remove(it.npc)
    }

    companion object {
        private val SPINNER_IDS: Set<Int> = ImmutableSet.of(
            NpcID.SPINNER,
            NpcID.SPINNER_1710,
            NpcID.SPINNER_1711,
            NpcID.SPINNER_1712,
            NpcID.SPINNER_1713
        )
    }
}