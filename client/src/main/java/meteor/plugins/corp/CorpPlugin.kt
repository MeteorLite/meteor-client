/*
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
package meteor.plugins.corp

import eventbus.events.*
import meteor.Main
import meteor.chat.QueuedMessage.Companion.builder
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import meteor.chat.ChatColorType
import meteor.chat.ChatMessageBuilder
import meteor.game.npcoverlay.HighlightedNpc
import meteor.plugins.attackstyles.AttackStylesConfig
import java.awt.Color
import java.util.function.Function

@PluginDescriptor(name = "Corporeal Beast", description = "Show damage statistics and highlight dark energy cores", tags = ["bosses", "combat", "pve", "overlay"])
class CorpPlugin : Plugin() {
    var corp: NPC? = null
    var core: NPC? = null
    private var yourDamage = 0
    var totalDamage = 0
    val players: MutableSet<Actor?> = HashSet()
    private val chatMessageManager = Main.chatMessageManager
    private val config = configuration<CorpConfig>()
    private val corpOverlay = CorpDamageOverlay(this, config)
    private val npcOverlayService = Main.npcOverlayService
    private val isCore = Function { npc: NPC ->
        if (npc === core) {
            return@Function HighlightedNpc.builder()
                    .npc(npc)
                    .tile(true)
                    .highlightColor(Color.RED.brighter())
                    .render { config.markDarkCore() }
        }
        null
    }

    override fun onStart() {
        npcOverlayService.registerHighlighter(isCore)
        overlayManager.add(corpOverlay)
    }

    override fun onStop() {
        npcOverlayService.unregisterHighlighter(isCore)
        overlayManager.remove(corpOverlay)
        core = null
        corp = core
        yourDamage = 0
        totalDamage = 0
        players.clear()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            players.clear()
        }
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc = it.npc
        when (npc.id) {
            NpcID.CORPOREAL_BEAST -> {
                corp = npc
                yourDamage = 0
                totalDamage = 0
                players.clear()
            }

            NpcID.DARK_ENERGY_CORE -> core = npc
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        val npc = it.npc
        if (npc === corp) {
            corp = null
            players.clear()
            if (npc.isDead) {
                // Show kill stats
                val message = ChatMessageBuilder()
                        .append(ChatColorType.NORMAL)
                        .append("Corporeal Beast: Your damage: ")
                        .append(ChatColorType.HIGHLIGHT)
                        .append(Integer.toString(yourDamage))
                        .append(ChatColorType.NORMAL)
                        .append(", Total damage: ")
                        .append(ChatColorType.HIGHLIGHT)
                        .append(Integer.toString(totalDamage))
                        .build()
                chatMessageManager.queue(builder()
                        .type(ChatMessageType.CONSOLE)
                        .runeLiteFormattedMessage(message))
            }
        } else if (npc === core) {
            core = null
        }
    }

    override fun onHitsplatApplied(it: HitsplatApplied) {
        val actor = it.actor
        if (actor !== corp) {
            return
        }
        totalDamage += it.hitsplat.amount
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        val source = it.source
        val target = it.target
        if (corp == null || target !== corp) {
            return
        }
        players.add(source)
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        if (corp != null && it.varbitId == Varbits.CORP_DAMAGE) {
            val myDamage = it.value
            // avoid resetting our counter when the client's is reset
            if (myDamage > 0) {
                yourDamage = myDamage
            }
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        val menuEntry = it.menuEntry
        menuEntry?.let {
            val npc = menuEntry.npc
            if (npc == null || DARK_ENERGY_CORE != npc.name) {
                return
            }
            if (menuEntry.type != MenuAction.NPC_SECOND_OPTION || menuEntry.option != ATTACK
                    || !config.leftClickCore()) {
                return
            }
            menuEntry.isDeprioritized = true
        }

    }

    companion object {
        private const val ATTACK = "Attack"
        private const val DARK_ENERGY_CORE = "Dark energy core"
    }
}