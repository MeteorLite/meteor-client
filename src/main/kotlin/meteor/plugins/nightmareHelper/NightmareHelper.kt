/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package meteor.plugins.nightmareHelper


import dev.hoot.api.widgets.Prayers
import eventbus.events.AnimationChanged
import eventbus.events.ChatMessage
import eventbus.events.GameStateChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*


@PluginDescriptor(name = "Nightmare Auto Pray",
    description = "Auto prayer for nightmare and Phosani",
    tags = [],
    enabledByDefault = false)
class NightmareHelper : Plugin() {
    var nm: NPC? = null
    var cursed = false
    var inFight = false

    override fun onStart() {
        reset()
    }

    override fun onStop() {
        reset()
    }

    private fun reset() {
        inFight = false
        nm = null
        cursed = false
    }


    override fun onChatMessage(it: ChatMessage) {
        if (!inFight || nm == null || it.message.contains("the nightmare has awoken.")) {
            return
        }
        if (it.message.contains("the nightmare has cursed you, shuffling your prayers!")) {
            cursed = true
        }
        if (it.message.contains("you feel the effects of the nightmare's curse wear off.")) {
            cursed = false
        }
    }

    private fun activateMage() {
        if (!Prayers.isEnabled(Prayer.PROTECT_FROM_MAGIC)) {
            Prayers.toggle(Prayer.PROTECT_FROM_MAGIC)
        }
    }

    private fun activateRange() {
        if (!Prayers.isEnabled(Prayer.PROTECT_FROM_MISSILES)) {
            Prayers.toggle(Prayer.PROTECT_FROM_MISSILES)
        }
    }

    private fun activateMelee() {
        if (!Prayers.isEnabled(Prayer.PROTECT_FROM_MELEE)) {
            Prayers.toggle(Prayer.PROTECT_FROM_MELEE)
        }
    }


    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gamestate) {
            GameState.LOADING -> reset()
            else -> {}
        }
    }


    override fun onAnimationChanged(it: AnimationChanged) {
        val actor: Actor = (it.actor as? NPC) ?: return
        val npc: NPC = actor as NPC

        // this will trigger once when the fight begins
        if (nm == null && npc.name != null && (npc.name
                .equals("The Nightmare", ignoreCase = true) || npc.name
                .equals("Phosani's Nightmare", ignoreCase = true))
        ) {
            //reset everything
            nm = npc
            inFight = true
        }
        if (!inFight || npc != nm) {
            return
        }
        val animID: Int = npc.animation
        if (animID == NIGHTMARE_MAGIC_ATTACK) {
            if (!cursed) {
                activateMage()
            } else {
                activateMelee()
            }
        } else if (animID == NIGHTMARE_MELEE_ATTACK) {
            if (!cursed) {
                activateMelee()
            } else {
                activateRange()
            }
        } else if (animID == NIGHTMARE_RANGE_ATTACK) {
            if (!cursed) {
                activateRange()
            } else {
                activateMage()
            }
        }
    }

    companion object {
        private const val NIGHTMARE_MELEE_ATTACK = 8594
        private const val NIGHTMARE_RANGE_ATTACK = 8596
        private const val NIGHTMARE_MAGIC_ATTACK = 8595
    }
}