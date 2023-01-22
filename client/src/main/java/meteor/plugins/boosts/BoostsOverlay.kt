/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import meteor.plugins.xptracker.XpInfoBoxOverlay.Companion.OPTION_CONFIGURE
import meteor.ui.components.LineComponent
import meteor.ui.overlay.*
import meteor.util.ColorUtil
import net.runelite.api.MenuAction
import net.runelite.api.Skill
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class BoostsOverlay(
    private val config: BoostsConfig,
    private val plugin: BoostsPlugin
) : OverlayPanel() {
    init {
        layer = OverlayLayer.ALWAYS_ON_TOP
        resizable = false
        position = OverlayPosition.TOP_LEFT
        priority = OverlayPriority.MED
        menuEntries
            .add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Boosts overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (config.displayInfoboxes()) {
            return null
        }
        var nextChange = plugin.changeDownTicks
        if (nextChange != -1) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Next + restore in")
                    .right(plugin.getChangeTime(nextChange).toString())
                    .build()
            )
        }
        nextChange = plugin.changeUpTicks
        if (nextChange != -1) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Next - restore in")
                    .right(plugin.getChangeTime(nextChange).toString())
                    .build()
            )
        }
        val boostedSkills: Set<Skill> = plugin.skillsToDisplay
        if (boostedSkills.isEmpty()) {
            return super.render(graphics)
        }
        if (plugin.canShowBoosts()) {
            for (skill in boostedSkills) {
                val boosted = client.getBoostedSkillLevel(skill)
                val base = client.getRealSkillLevel(skill)
                val boost = boosted - base
                val strColor = getTextColor(boost)
                var str: String
                if (config.useRelativeBoost()) {
                    str = boost.toString()
                    if (boost > 0) {
                        str = "+$str"
                    }
                } else {
                    str = (ColorUtil.prependColorTag(Integer.toString(boosted), strColor)
                            + ColorUtil.prependColorTag("/$base", Color.WHITE))
                }
                panelComponent.children.add(
                    LineComponent.Builder()
                        .left(skill.getName())
                        .right(str)
                        .rightColor(strColor)
                        .build()
                )
            }
        }
        return super.render(graphics)
    }

    private fun getTextColor(boost: Int): Color {
        if (boost < 0) {
            return Color(238, 51, 51)
        }
        return if (boost <= config.boostThreshold()) Color.YELLOW else Color.GREEN
    }
}