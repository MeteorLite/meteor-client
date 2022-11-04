/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.game.npcoverlay

import eventbus.events.GameStateChanged
import eventbus.events.NpcChanged
import eventbus.events.NpcDespawned
import eventbus.events.NpcSpawned
import meteor.Main
import meteor.plugins.EventSubscriber
import meteor.rs.ClientThread
import meteor.ui.overlay.OverlayManager.add
import net.runelite.api.GameState
import net.runelite.api.NPC
import ui.overlay.outline.ModelOutlineRenderer
import java.util.function.Function

class NpcOverlayService : EventSubscriber() {
    private val client = Main.client
    private val clientThread = ClientThread
    private val highlightFunctions: MutableList<Function<NPC, HighlightedNpc?>> = ArrayList()
    private val highlightedNpcs: MutableMap<NPC, HighlightedNpc> = HashMap()

    init {
        add(NpcOverlay(ModelOutlineRenderer(), highlightedNpcs))
        add(NpcMinimapOverlay(highlightedNpcs))
        subscribe()
    }

    override fun onGameStateChanged(event: GameStateChanged) {
        if (event.gameState == GameState.LOGIN_SCREEN ||
                event.gameState == GameState.HOPPING) {
            highlightedNpcs.clear()
        }
    }

    override fun onNpcSpawned(npcSpawned: NpcSpawned) {
        val npc = npcSpawned.npc
        for (f in highlightFunctions) {
            val highlightedNpc = f.apply(npc)
            if (highlightedNpc != null) {
                highlightedNpcs[npc] = highlightedNpc
                return
            }
        }
    }

    override fun onNpcDespawned(npcDespawned: NpcDespawned) {
        val npc = npcDespawned.npc
        highlightedNpcs.remove(npc)
    }

    override fun onNpcChanged(event: NpcChanged) {
        val npc = event.npc
        highlightedNpcs.remove(npc)
        for (f in highlightFunctions) {
            val highlightedNpc = f.apply(npc)
            if (highlightedNpc != null) {
                highlightedNpcs[npc] = highlightedNpc
                return
            }
        }
    }

    fun rebuild() {
        clientThread.invoke {
            highlightedNpcs.clear()
            outer@ for (npc in client.npcs) {
                for (f in highlightFunctions) {
                    val highlightedNpc = f.apply(npc)
                    if (highlightedNpc != null) {
                        highlightedNpcs[npc] = highlightedNpc
                        continue@outer
                    }
                }
            }
        }
    }

    fun registerHighlighter(p: Function<NPC, HighlightedNpc?>) {
        highlightFunctions.add(p)
        rebuild()
    }

    fun unregisterHighlighter(p: Function<NPC, HighlightedNpc?>) {
        highlightFunctions.remove(p)
        rebuild()
    }
}