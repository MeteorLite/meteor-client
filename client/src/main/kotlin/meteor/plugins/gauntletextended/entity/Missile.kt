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
import java.awt.image.BufferedImage
import java.lang.IllegalArgumentException
import net.runelite.api.*
import java.awt.Color

class Missile(
    val projectile: Projectile,
    skillIconManager: SkillIconManager,
    private var iconSize: Int
) {
    private val originalIcon: BufferedImage

    val outlineColor: Color

    val fillColor: Color
    var icon: BufferedImage? = null

    init {
        originalIcon = getOriginalIcon(skillIconManager, projectile.id)
        outlineColor = getOutlineColor(projectile.id)
        fillColor = Color(outlineColor.red, outlineColor.green, outlineColor.blue, FILL_ALPHA)
    }

    fun setIconSize(iconSize: Int) {
        this.iconSize = iconSize
        icon = resizeImage(originalIcon, iconSize, iconSize)
    }

    companion object {
        private const val FILL_ALPHA = 100
        private fun getOutlineColor(projectileId: Int): Color {
            return when (projectileId) {
                ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK -> Color.CYAN
                ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK -> Color.GREEN
                ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK -> Color.MAGENTA
                else -> throw IllegalArgumentException("Unsupported gauntlet projectile id: $projectileId")
            }
        }

        private fun getOriginalIcon(skillIconManager: SkillIconManager, projectileId: Int): BufferedImage {
            return when (projectileId) {
                ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK -> skillIconManager.getSkillImage(
                    Skill.MAGIC
                )
                ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK -> skillIconManager.getSkillImage(
                    Skill.RANGED
                )
                ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK -> skillIconManager.getSkillImage(
                    Skill.PRAYER
                )
                else -> throw IllegalArgumentException("Unsupported gauntlet projectile id: $projectileId")
            }
        }
    }
}