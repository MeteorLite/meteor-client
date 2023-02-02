/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
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
@file:Suppress("DEPRECATION")

package meteor.plugins.coxhelper

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.coxhelper.NPCContainer.Attackstyle
import net.runelite.api.*
import net.runelite.api.util.Text

import java.util.regex.Pattern

@PluginDescriptor(
    name = "CoX Helper",
    enabledByDefault = false,
    description = "All-in-one plugin for Chambers of Xeric",
    tags = ["CoX", "chamber", "xeric", "helper"]
)

class CoxPlugin : Plugin() {
    internal val npcContainers: MutableMap<NPC, NPCContainer?> = HashMap()

    var config = configuration<CoxConfig>()

    private val coxOverlay = overlay(CoxOverlay(this, config))

    private val coxInfoBox = overlay(CoxInfoBox(this))

    private val coxDebugBox: CoxDebugBox? = null


    var vanguards = 0
    var tektonActive = false
    var tektonAttackTicks = 0

    override fun onStart() {
        Olm.hardRest()
    }

    fun shutdown() {
        overlayManager.remove(coxOverlay)
        overlayManager.remove(coxInfoBox)
        overlayManager.remove(coxDebugBox)
    }

    override fun onChatMessage(it: ChatMessage) {
        if (!inRaid()) {
            return
        }
        if (it.type == ChatMessageType.GAMEMESSAGE) {
            val tpMatcher = TP_REGEX.matcher(it.message)
            if (tpMatcher.matches()) {
                for (player in client.players) {
                    val rawPlayerName = player.name
                    if (rawPlayerName != null) {
                        val fixedPlayerName: String = Text.sanitize(rawPlayerName)
                        if (fixedPlayerName == Text.sanitize(tpMatcher.group(1))) {
                            Olm.victims.add(Victim(player, Victim.Type.TELEPORT))
                        }
                    }
                }
            }
            when (Text.standardize(it.messageNode.value)) {
                "the great olm rises with the power of acid." -> Olm.phaseType = (Olm.PhaseType.ACID)
                "the great olm rises with the power of crystal." -> Olm.phaseType = (Olm.PhaseType.CRYSTAL)
                "the great olm rises with the power of flame." -> Olm.phaseType = (Olm.PhaseType.FLAME)
                "the great olm fires a sphere of aggression your way. your prayers have been sapped.", "the great olm fires a sphere of aggression your way." -> Olm.prayer =
                    Prayer.PROTECT_FROM_MELEE
                "the great olm fires a sphere of magical power your way. your prayers have been sapped.", "the great olm fires a sphere of magical power your way." -> Olm.prayer =
                    Prayer.PROTECT_FROM_MAGIC
                "the great olm fires a sphere of accuracy and dexterity your way. your prayers have been sapped.", "the great olm fires a sphere of accuracy and dexterity your way." -> Olm.prayer =
                    Prayer.PROTECT_FROM_MISSILES
            }
        }
    }

 override fun onProjectileSpawned(it: ProjectileSpawned) {
        if (!inRaid()) {
            return
        }
        val projectile: Projectile = it.projectile
        when (projectile.id) {
            ProjectileID.OLM_MAGE_ATTACK -> Olm.prayer = Prayer.PROTECT_FROM_MAGIC
            ProjectileID.OLM_RANGE_ATTACK -> Olm.prayer = Prayer.PROTECT_FROM_MISSILES
            ProjectileID.OLM_ACID_TRAIL -> {
                val actor: Actor = projectile.interacting
                if (actor is Player) {
                    Olm.victims.add(Victim(actor as Player, Victim.Type.ACID))
                }
            }
        }
    }

    override fun onGraphicChanged(it: GraphicChanged) {
        if (!inRaid()) {
            return
        }
        if (it.actor !is Player) {
            return
        }
        val player: Player = it.actor as Player
        if (player.graphic == GraphicID.OLM_BURN) {
            Olm.victims.add(Victim(player, Victim.Type.BURN))
        }
    }
    override fun onNpcSpawned(it: NpcSpawned) {
        if (!inRaid()) {
            return
        }
        val npc: NPC = it.npc
        when (npc.id) {
            NpcID.TEKTON, NpcID.TEKTON_7541, NpcID.TEKTON_7542, NpcID.TEKTON_7545, NpcID.TEKTON_ENRAGED, NpcID.TEKTON_ENRAGED_7544 -> {
                npcContainers[npc] = NPCContainer(npc)
                tektonAttackTicks = 27
            }
            NpcID.MUTTADILE, NpcID.MUTTADILE_7562, NpcID.MUTTADILE_7563, NpcID.GUARDIAN, NpcID.GUARDIAN_7570 -> npcContainers[npc] =
                NPCContainer(npc)
            NpcID.VANGUARD, NpcID.VANGUARD_7526, NpcID.VANGUARD_7527, NpcID.VANGUARD_7528, NpcID.VANGUARD_7529 -> {
                vanguards++
                npcContainers[npc] = NPCContainer(npc)
            }
        }
    }

 override fun onNpcDespawned(it: NpcDespawned) {
        if (!inRaid()) {
            return
        }
        val npc: NPC = it.npc
        when (npc.id) {
            NpcID.TEKTON, NpcID.TEKTON_7541, NpcID.TEKTON_7542, NpcID.TEKTON_7545, NpcID.TEKTON_ENRAGED, NpcID.TEKTON_ENRAGED_7544, NpcID.MUTTADILE, NpcID.MUTTADILE_7562, NpcID.MUTTADILE_7563, NpcID.GUARDIAN, NpcID.GUARDIAN_7570, NpcID.GUARDIAN_7571, NpcID.GUARDIAN_7572 -> if (npcContainers.remove(
                    it.npc
                ) != null && npcContainers.isNotEmpty()
            ) {
                npcContainers.remove(it.npc)
            }
            NpcID.VANGUARD, NpcID.VANGUARD_7526, NpcID.VANGUARD_7527, NpcID.VANGUARD_7528, NpcID.VANGUARD_7529 -> {
                if (npcContainers.remove(it.npc) != null && npcContainers.isNotEmpty()) {
                    npcContainers.remove(it.npc)
                }
                vanguards--
            }
        }
    }

override fun onGameTick(it: GameTick) {
        if (!inRaid()) {
            Olm.hardRest()
            return
        }
        handleNpcs()
        if (Olm.active) {
            Olm.update()
        }
    }

    private fun handleNpcs() {
        this.npcContainers.values.forEach {
            when (it?.npc?.id) {
                NpcID.TEKTON, NpcID.TEKTON_7541, NpcID.TEKTON_7542, NpcID.TEKTON_7545, NpcID.TEKTON_ENRAGED, NpcID.TEKTON_ENRAGED_7544 -> {
                    it.ticksUntilAttack = it.ticksUntilAttack - 1
                    it.attackStyle = Attackstyle.MELEE
                    when (it.npc.animation) {
                        TEKTON_AUTO1, TEKTON_AUTO2, TEKTON_AUTO3, TEKTON_ENRAGE_AUTO1, TEKTON_ENRAGE_AUTO2, TEKTON_ENRAGE_AUTO3 -> {
                            tektonActive = true
                            if (it.ticksUntilAttack < 1) {
                                it.ticksUntilAttack = 4
                            }
                        }
                        TEKTON_FAST_AUTO1, TEKTON_FAST_AUTO2 -> {
                            tektonActive = true
                            if (it.ticksUntilAttack < 1) {
                                it.ticksUntilAttack = 3
                            }
                        }
                        TEKTON_ANVIL -> {
                            tektonActive = false
                            tektonAttackTicks = 47
                            if (it.ticksUntilAttack < 1) {
                                it.ticksUntilAttack = 15
                            }
                        }
                    }
                }
                NpcID.GUARDIAN, NpcID.GUARDIAN_7570, NpcID.GUARDIAN_7571, NpcID.GUARDIAN_7572 -> {
                    it.ticksUntilAttack = it.ticksUntilAttack - 1
                    it.attackStyle = Attackstyle.MELEE
                    if (it.npc.animation == ANIMATION_ID_G1 &&
                        it.ticksUntilAttack < 1
                    ) {
                        it.ticksUntilAttack = 5
                    }
                }
                NpcID.VANGUARD_7529 -> if (it.attackStyle == Attackstyle.UNKNOWN) {
                    it.attackStyle = Attackstyle.MAGE
                }
                NpcID.VANGUARD_7528 -> if (it.attackStyle == Attackstyle.UNKNOWN) {
                    it.attackStyle = Attackstyle.RANGE
                }
                NpcID.VANGUARD_7527 -> if (it.attackStyle == Attackstyle.UNKNOWN) {
                    it.attackStyle = Attackstyle.MELEE
                }
            }
        }
        if (tektonActive && tektonAttackTicks > 0) {
            tektonAttackTicks--
        }
    }

    fun inRaid(): Boolean {
        return client.getVar(Varbits.IN_RAID) == 1
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {

        when (it.gameObject.id) {
            Olm.HEAD_GAMEOBJECT_RISING, Olm.HEAD_GAMEOBJECT_READY -> {
                if (Olm.head == null) {
                    Olm.startPhase()
                }
                Olm.head = it.gameObject
            }
            Olm.LEFT_HAND_GAMEOBJECT_RISING, Olm.LEFT_HAND_GAMEOBJECT_READY -> Olm.hand = it.gameObject
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {

        val id: Int = it.gameObject.id
        if (id == Olm.HEAD_GAMEOBJECT_READY) {
            Olm.head = null
        }
    }

    companion object {
        private const val ANIMATION_ID_G1 = 430
        private val TP_REGEX =
            Pattern.compile("You have been paired with <col=ff0000>(.*)</col>! The magical power will enact soon...")
        const val TEKTON_ANVIL = 7475
        const val TEKTON_AUTO1 = 7482
        const val TEKTON_AUTO2 = 7483
        const val TEKTON_AUTO3 = 7484
        const val TEKTON_FAST_AUTO1 = 7478
        const val TEKTON_FAST_AUTO2 = 7488
        const val TEKTON_ENRAGE_AUTO1 = 7492
        const val TEKTON_ENRAGE_AUTO2 = 7493
        const val TEKTON_ENRAGE_AUTO3 = 7494
    }
}