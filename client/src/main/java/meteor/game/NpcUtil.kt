/*
 * Copyright (c) 2022, Jordan Atwood <nightfirecat@nightfirec.at>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.game

import eventbus.events.AnimationChanged
import eventbus.events.NpcChanged
import meteor.plugins.EventSubscriber
import net.runelite.api.AnimationID
import net.runelite.api.NPC
import net.runelite.api.NpcID
import meteor.util.RuntimeConfig
import meteor.util.RuntimeConfigLoader.configFuture
import org.apache.commons.lang3.ArrayUtils

object NpcUtil : EventSubscriber() {
    private val runtimeConfig: RuntimeConfig? = configFuture.get()

    init {
        subscribe()
    }

    /**
     * Returns whether an NPC is dying and can no longer be interacted with, or if it is still alive or in some special
     * state where it can be 0hp without dying. (For example, Gargoyles and other slayer monsters with item weaknesses
     * are not killed by reaching 0hp, so would not be dead based on that alone.)
     *
     * @param npc NPC to check whether it is dying
     * @return `true` if the NPC is dying
     */
    fun isDying(npc: NPC): Boolean {
        val id = npc.id
        return when (id) {
            NpcID.GARGOYLE, NpcID.GARGOYLE_413, NpcID.GARGOYLE_1543, NpcID.MARBLE_GARGOYLE, NpcID.MARBLE_GARGOYLE_7408, NpcID.DAWN, NpcID.DAWN_7852, NpcID.DAWN_7853, NpcID.DAWN_7884, NpcID.DAWN_7885, NpcID.DUSK, NpcID.DUSK_7851, NpcID.DUSK_7854, NpcID.DUSK_7855, NpcID.DUSK_7882, NpcID.DUSK_7883, NpcID.DUSK_7886, NpcID.DUSK_7887, NpcID.DUSK_7888, NpcID.DUSK_7889, NpcID.ZYGOMITE, NpcID.ZYGOMITE_1024, NpcID.ANCIENT_ZYGOMITE, NpcID.ROCKSLUG, NpcID.ROCKSLUG_422, NpcID.GIANT_ROCKSLUG, NpcID.DESERT_LIZARD, NpcID.DESERT_LIZARD_460, NpcID.DESERT_LIZARD_461, NpcID.LIZARD, NpcID.SMALL_LIZARD, NpcID.SMALL_LIZARD_463, NpcID.GROWTHLING, NpcID.KALPHITE_QUEEN_963, NpcID.VETION, NpcID.WITCHS_EXPERIMENT, NpcID.WITCHS_EXPERIMENT_6394, NpcID.WITCHS_EXPERIMENT_HARD, NpcID.WITCHS_EXPERIMENT_SECOND_FORM, NpcID.WITCHS_EXPERIMENT_SECOND_FORM_6395, NpcID.WITCHS_EXPERIMENT_SECOND_FORM_HARD, NpcID.WITCHS_EXPERIMENT_THIRD_FORM, NpcID.WITCHS_EXPERIMENT_THIRD_FORM_6396, NpcID.WITCHS_EXPERIMENT_THIRD_FORM_HARD, NpcID.NAZASTAROOL, NpcID.NAZASTAROOL_5354, NpcID.NAZASTAROOL_6398, NpcID.NAZASTAROOL_6399, NpcID.NAZASTAROOL_HARD, NpcID.NAZASTAROOL_HARD_6338, NpcID.KOLODION_1605, NpcID.KOLODION_1606, NpcID.KOLODION_1607, NpcID.KOLODION_1608, NpcID.MUTANT_TARN, NpcID.XAMPHUR_10955, NpcID.XAMPHUR_10956, NpcID.KOSCHEI_THE_DEATHLESS, NpcID.KOSCHEI_THE_DEATHLESS_3898, NpcID.KOSCHEI_THE_DEATHLESS_3899, NpcID.DAMIS, NpcID.DAMIS_6346, NpcID.DAMIS_HARD, NpcID.CHOMPY_BIRD, NpcID.JUBBLY_BIRD, NpcID.ENT, NpcID.ENT_7234, NpcID.HOPELESS_CREATURE, NpcID.HOPELESS_CREATURE_1073, NpcID.WALL_BEAST -> false

            NpcID.DRAKE_8613, NpcID.GUARDIAN_DRAKE_10401, NpcID.ALCHEMICAL_HYDRA_8622, NpcID.XARPUS_8341, NpcID.XARPUS_10769, NpcID.XARPUS_10773, NpcID.THE_NIGHTMARE_9433, NpcID.PHOSANIS_NIGHTMARE_9424 -> true
            NpcID.ZALCANO_9050 -> npc.isDead
            else -> {
                if (runtimeConfig != null) {
                    val ignoredNpcs = runtimeConfig.ignoreDeadNpcs
                    if (ignoredNpcs != null && ignoredNpcs.contains(id)) {
                        return false
                    }
                    val forceDeadNpcs = runtimeConfig.forceDeadNpcs
                    if (forceDeadNpcs != null && forceDeadNpcs.contains(id)) {
                        return true
                    }
                    val pureIsDeadNpcs = runtimeConfig.nonAttackNpcs
                    if (pureIsDeadNpcs != null && pureIsDeadNpcs.contains(id)) {
                        return npc.isDead
                    }
                }
                val npcComposition = npc.transformedComposition
                val hasAttack = npcComposition != null && ArrayUtils.contains(npcComposition.actions, "Attack")
                hasAttack && npc.isDead
            }
        }
    }

    override fun onNpcChanged(e: NpcChanged) {
        val npc = e.npc
        val id = npc.id
        when (id) {
            NpcID.KALPHITE_QUEEN_965, NpcID.VETION_REBORN, NpcID.WITCHS_EXPERIMENT_FOURTH_FORM, NpcID.WITCHS_EXPERIMENT_FOURTH_FORM_6397, NpcID.WITCHS_EXPERIMENT_FOURTH_FORM_HARD, NpcID.NAZASTAROOL_5355, NpcID.NAZASTAROOL_6400, NpcID.NAZASTAROOL_HARD_6339, NpcID.KOLODION_1609, NpcID.TARN_6476, NpcID.KOSCHEI_THE_DEATHLESS_3900, NpcID.DAMIS_683, NpcID.DAMIS_6347, NpcID.DAMIS_HARD_1135, NpcID.HOPELESS_CREATURE_1074, NpcID.THE_NIGHTMARE, NpcID.PHOSANIS_NIGHTMARE, NpcID.AWAKENED_ALTAR, NpcID.AWAKENED_ALTAR_7290, NpcID.AWAKENED_ALTAR_7292, NpcID.AWAKENED_ALTAR_7294 -> npc.isDead = false
            else -> if (runtimeConfig != null) {
                val resetDeadOnChangeNpcs = runtimeConfig.resetDeadOnChangeNpcs
                if (resetDeadOnChangeNpcs != null && resetDeadOnChangeNpcs.contains(id)) {
                    npc.isDead = false
                }
            }
        }
    }

    override fun onAnimationChanged(animationChanged: AnimationChanged) {
        val actor = animationChanged.actor
        val anim = actor.animation
        when (anim) {
            AnimationID.CORP_DEATH -> {
                if (actor !is NPC || actor.id != NpcID.CORPOREAL_BEAST) {
                    return
                }
                actor.setDead(true)
            }

            AnimationID.VERZIK_P2_BLUE_NYLO_EXPLOSION, AnimationID.VERZIK_P2_GREEN_NYLO_EXPLOSION, AnimationID.VERZIK_P2_WHITE_NYLO_EXPLOSION, AnimationID.VERZIK_P2_PURPLE_NYLO_EXPLOSION, AnimationID.VERZIK_P2_RED_NYLO_EXPLOSION -> actor.isDead = true
            else -> if (runtimeConfig != null) {
                val forceDeadAnimations = runtimeConfig.forceDeadAnimations
                if (forceDeadAnimations != null && forceDeadAnimations.contains(anim)) {
                    actor.isDead = true
                }
            }
        }
    }
}