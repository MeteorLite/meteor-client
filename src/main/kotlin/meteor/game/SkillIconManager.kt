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
package meteor.game

import meteor.util.ImageUtil.loadImageResource
import net.runelite.api.Skill
import java.awt.image.BufferedImage
import java.util.*

object SkillIconManager {
    // * 2 to account for the small version of each icon
    private val imgCache = arrayOfNulls<BufferedImage>(Skill.values().size * 2)
    fun getSkillImage(skill: Skill, small: Boolean): BufferedImage? {
        val skillIdx = skill.ordinal + if (small) Skill.values().size else 0
        if (imgCache[skillIdx] != null) {
            return imgCache[skillIdx]
        }
        val skillIconPath = ((if (small) "/skill_icons_small/" else "/skill_icons/")
                + skill.getName().lowercase(Locale.getDefault()) + ".png")
        val skillImage = loadImageResource(javaClass, skillIconPath)
        imgCache[skillIdx] = skillImage
        return skillImage
    }

    fun getSkillImage(skill: Skill): BufferedImage? {
        return getSkillImage(skill, false)
    }
}