/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package meteor.plugins.opponentinfo

import meteor.Main
import meteor.hiscore.HiscoreManager
import meteor.ui.components.LineComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.PanelComponent
import meteor.ui.table.TitleComponent.Companion.builder
import net.runelite.api.Player
import net.runelite.api.Skill
import net.runelite.api.util.Text
import net.runelite.http.api.hiscore.HiscoreResult
import net.runelite.http.api.hiscore.HiscoreSkill
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class PlayerComparisonOverlay(
    private val opponentInfoPlugin: OpponentInfoPlugin,
    private val config: OpponentInfoConfig
) : Overlay() {
    private val hiscoreManager = HiscoreManager
    private val panelComponent = PanelComponent()

    init {
        position = OverlayPosition.BOTTOM_LEFT
        layer = OverlayLayer.ABOVE_WIDGETS
        //addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay");
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!config.lookupOnInteraction()) {
            return null
        }
        val opponent = opponentInfoPlugin.lastOpponent as? Player ?: return null

        // Don't try to look up NPC names
        val opponentName = Text.removeTags(opponent.name)
        val hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.hiscoreEndpoint) ?: return null
        panelComponent.children.clear()
        generateComparisonTable(panelComponent, hiscoreResult)
        return panelComponent.render(graphics)
    }

    private fun generateComparisonTable(panelComponent: PanelComponent, opponentSkills: HiscoreResult) {
        val opponentName = opponentSkills.player
        panelComponent.children.add(
            builder()
                .text(opponentName)
                .color(HIGHLIGHT_COLOR)
        )
        panelComponent.children.add(
            LineComponent.Builder()
                .left(LEFT_COLUMN_HEADER)
                .leftColor(HIGHLIGHT_COLOR)
                .right(RIGHT_COLUMN_HEADER)
                .rightColor(HIGHLIGHT_COLOR)
                .build()
        )
        for (i in COMBAT_SKILLS.indices) {
            val hiscoreSkill = HISCORE_COMBAT_SKILLS[i]
            val skill = COMBAT_SKILLS[i]
            val opponentSkill = opponentSkills.getSkill(hiscoreSkill)
            if (opponentSkill == null || opponentSkill.level == -1) {
                continue
            }
            val playerSkillLevel = client.getRealSkillLevel(skill)
            val opponentSkillLevel = opponentSkill.level
            panelComponent.children.add(
                LineComponent.Builder()
                    .left(hiscoreSkill.getName())
                    .right("$playerSkillLevel/$opponentSkillLevel")
                    .rightColor(comparisonStatColor(playerSkillLevel, opponentSkillLevel))
                    .build()
            )
        }
    }

    companion object {
        private val HIGHER_STAT_TEXT_COLOR = Color.GREEN
        private val LOWER_STAT_TEXT_COLOR = Color.RED
        private val NEUTRAL_TEXT_COLOR = Color.WHITE
        private val HIGHLIGHT_COLOR = Color(255, 200, 0, 255)
        private val COMBAT_SKILLS = arrayOf(
            Skill.ATTACK,
            Skill.STRENGTH,
            Skill.DEFENCE,
            Skill.HITPOINTS,
            Skill.RANGED,
            Skill.MAGIC,
            Skill.PRAYER
        )
        private val HISCORE_COMBAT_SKILLS = arrayOf(
            HiscoreSkill.ATTACK,
            HiscoreSkill.STRENGTH,
            HiscoreSkill.DEFENCE,
            HiscoreSkill.HITPOINTS,
            HiscoreSkill.RANGED,
            HiscoreSkill.MAGIC,
            HiscoreSkill.PRAYER
        )
        private const val LEFT_COLUMN_HEADER = "Skill"
        private const val RIGHT_COLUMN_HEADER = "You/Them"
        private fun comparisonStatColor(a: Int, b: Int): Color {
            if (a > b) {
                return HIGHER_STAT_TEXT_COLOR
            }
            return if (a < b) {
                LOWER_STAT_TEXT_COLOR
            } else NEUTRAL_TEXT_COLOR
        }
    }
}