/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package meteor.plugins.gauntletextended.entity

import meteor.util.ImageUtil.resizeImage
import meteor.game.SkillIconManager
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import java.awt.image.BufferedImage
import dev.hoot.api.widgets.Prayers
import java.lang.IllegalStateException
import net.runelite.api.*
import java.awt.Color

class Hunllef(
    val npc: NPC,
    skillIconManager: SkillIconManager,
    iconSize: Int,
    plugin: GauntletExtendedPlugin
) {
    private val originalMagicIcon: BufferedImage
    private val originalRangeIcon: BufferedImage
    private var magicIcon: BufferedImage? = null
    private var rangeIcon: BufferedImage? = null

    var attackPhase: AttackPhase

    var attackCount: Int

    var playerAttackCount: Int

    var ticksUntilNextAttack: Int
    private var iconSize: Int
    private val plugin: GauntletExtendedPlugin

    init {
        originalMagicIcon = skillIconManager.getSkillImage(Skill.MAGIC)
        originalRangeIcon = skillIconManager.getSkillImage(Skill.RANGED)
        this.iconSize = iconSize
        attackCount = MAX_ATTACK_COUNT
        playerAttackCount = MAX_PLAYER_ATTACK_COUNT
        ticksUntilNextAttack = 0
        attackPhase = AttackPhase.RANGE
        this.plugin = plugin
    }

    fun decrementTicksUntilNextAttack() {
        if (ticksUntilNextAttack > 0) {
            ticksUntilNextAttack--
        }
    }

    fun updatePlayerAttackCount() {
        if (--playerAttackCount <= 0) {
            playerAttackCount = MAX_PLAYER_ATTACK_COUNT
        }
    }

    fun updateAttackCount() {
        ticksUntilNextAttack = ATTACK_TICK_SPEED
        if (--attackCount <= 0) {
            attackPhase = if (attackPhase == AttackPhase.RANGE) AttackPhase.MAGIC else AttackPhase.RANGE
            attackCount = MAX_ATTACK_COUNT
        }
        if (plugin.config.autoPray()) {
            if (attackPhase == AttackPhase.RANGE) {
                if (!Prayers.isEnabled(Prayer.PROTECT_FROM_MISSILES)) Prayers.toggle(Prayer.PROTECT_FROM_MISSILES)
            } else if (attackPhase == AttackPhase.MAGIC) {
                if (!Prayers.isEnabled(Prayer.PROTECT_FROM_MAGIC)) Prayers.toggle(Prayer.PROTECT_FROM_MAGIC)
            }
        }
    }

    fun setIconSize(iconSize: Int) {
        this.iconSize = iconSize
        magicIcon = resizeImage(originalMagicIcon, iconSize, iconSize)
        rangeIcon = resizeImage(originalRangeIcon, iconSize, iconSize)
    }

    val icon: BufferedImage
        get() = when (attackPhase) {
            AttackPhase.MAGIC -> {
                if (magicIcon == null) {
                    magicIcon = resizeImage(originalMagicIcon, iconSize, iconSize)
                }
                magicIcon!!
            }
            AttackPhase.RANGE -> {
                if (rangeIcon == null) {
                    rangeIcon = resizeImage(originalRangeIcon, iconSize, iconSize)
                }
                rangeIcon!!
            }
            else -> throw IllegalStateException("Unexpected boss attack phase: $attackPhase")
        }

    enum class AttackPhase(val color: Color? = null, val prayer: Prayer? = null) {
        MAGIC(Color.CYAN, Prayer.PROTECT_FROM_MAGIC), RANGE(Color.GREEN, Prayer.PROTECT_FROM_MISSILES);

    }

    companion object {
        private const val ATTACK_TICK_SPEED = 6
        private const val MAX_ATTACK_COUNT = 4
        private const val MAX_PLAYER_ATTACK_COUNT = 6
    }
}