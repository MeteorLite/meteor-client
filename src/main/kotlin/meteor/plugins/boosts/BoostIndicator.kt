/*
 * Copyright (c) 2018 Kamiel
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
package meteor.plugins.boosts

import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxPriority
import net.runelite.api.Client
import net.runelite.api.Skill
import java.awt.Color
import java.awt.image.BufferedImage

class BoostIndicator internal constructor(
    val skill: Skill,
    image: BufferedImage?,
    private val boostPlugin: BoostsPlugin,
    private val client: Client?,
    private val config: BoostsConfig?
) : InfoBox(image, boostPlugin) {
    init {
        tooltip = (skill.getName() + " boost")
        priority = (InfoBoxPriority.HIGH)
    }

    override val text: String
        get() {
            if (!config!!.useRelativeBoost()) {
                return client!!.getBoostedSkillLevel(skill).toString()
            }
            val boost = client!!.getBoostedSkillLevel(skill) - client.getRealSkillLevel(skill)
            var text = boost.toString()
            if (boost > 0) {
                text = "+$text"
            }
            return text
        }
    override val textColor: Color
        get() {
            val boosted = client!!.getBoostedSkillLevel(skill)
            val base = client.getRealSkillLevel(skill)
            if (boosted < base) {
                return Color(238, 51, 51)
            }
            return if (boosted - base <= config!!.boostThreshold()) Color.YELLOW else Color.GREEN
        }

    override fun render(): Boolean {
        return config!!.displayInfoboxes() && boostPlugin.canShowBoosts() && boostPlugin.skillsToDisplay
            .contains(skill)
    }

    override val name: String
        get() = "Boost " + skill.getName()
}