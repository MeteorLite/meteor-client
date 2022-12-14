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

class Resource(
    val gameObject: GameObject,
    skillIconManager: SkillIconManager,
    private var iconSize: Int
) {
    private val originalIcon: BufferedImage
    var icon: BufferedImage? = null

    init {
        originalIcon = getOriginalIcon(skillIconManager, gameObject.id)
    }

    fun setIconSize(iconSize: Int) {
        this.iconSize = iconSize
        icon = resizeImage(originalIcon, iconSize, iconSize)
    }

    companion object {
        private fun getOriginalIcon(skillIconManager: SkillIconManager, objectId: Int): BufferedImage {
            return when (objectId) {
                ObjectID.CRYSTAL_DEPOSIT, ObjectID.CORRUPT_DEPOSIT -> skillIconManager.getSkillImage(
                    Skill.MINING
                )
                ObjectID.PHREN_ROOTS, ObjectID.PHREN_ROOTS_36066 -> skillIconManager.getSkillImage(
                    Skill.WOODCUTTING
                )
                ObjectID.FISHING_SPOT_36068, ObjectID.FISHING_SPOT_35971 -> skillIconManager.getSkillImage(
                    Skill.FISHING
                )
                ObjectID.GRYM_ROOT, ObjectID.GRYM_ROOT_36070 -> skillIconManager.getSkillImage(
                    Skill.HERBLORE
                )
                ObjectID.LINUM_TIRINUM, ObjectID.LINUM_TIRINUM_36072 -> skillIconManager.getSkillImage(
                    Skill.FARMING
                )
                else -> throw IllegalArgumentException("Unsupported gauntlet resource gameobject id: $objectId")
            }
        }
    }
}