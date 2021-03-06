/*
 * Copyright (c) 2018, Brett Middle <https://github.com/bmiddle>
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
package meteor.plugins.combatlevel

import com.google.common.annotations.VisibleForTesting
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.Tooltip
import meteor.ui.overlay.TooltipManager
import meteor.util.ColorUtil.wrapWithColorTag
import net.runelite.api.Experience
import net.runelite.api.Skill
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class CombatLevelOverlay(private val config: CombatLevelConfig) : Overlay() {
    private val tooltipManager = TooltipManager
    override fun render(graphics: Graphics2D): Dimension? {
        val combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL)
        if (!config.showLevelsUntil()
            || client.localPlayer!!.combatLevel == Experience.MAX_COMBAT_LEVEL || combatLevelWidget == null || combatLevelWidget.isHidden
        ) {
            return null
        }
        val combatCanvas = combatLevelWidget.bounds ?: return null
        if (combatCanvas
                .contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)
        ) {
            tooltipManager.add(Tooltip(levelsUntilTooltip))
        }
        return null
    }

    // grab combat skills from player
    @get:VisibleForTesting
    val levelsUntilTooltip:

    // find the needed levels until level up

    // create tooltip string
            String
        get() {
            // grab combat skills from player
            val attackLevel = client.getRealSkillLevel(Skill.ATTACK)
            val strengthLevel = client.getRealSkillLevel(Skill.STRENGTH)
            val defenceLevel = client.getRealSkillLevel(Skill.DEFENCE)
            val hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS)
            val magicLevel = client.getRealSkillLevel(Skill.MAGIC)
            val rangeLevel = client.getRealSkillLevel(Skill.RANGED)
            val prayerLevel = client.getRealSkillLevel(Skill.PRAYER)

            // find the needed levels until level up
            val meleeNeed = Experience
                .getNextCombatLevelMelee(
                    attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
                    magicLevel, rangeLevel, prayerLevel
                )
            val hpDefNeed = Experience
                .getNextCombatLevelHpDef(
                    attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
                    magicLevel, rangeLevel, prayerLevel
                )
            val rangeNeed = Experience
                .getNextCombatLevelRange(
                    attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
                    magicLevel, rangeLevel, prayerLevel
                )
            val magicNeed = Experience
                .getNextCombatLevelMagic(
                    attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
                    magicLevel, rangeLevel, prayerLevel
                )
            val prayerNeed = Experience
                .getNextCombatLevelPrayer(
                    attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
                    magicLevel, rangeLevel, prayerLevel
                )

            // create tooltip string
            val sb = StringBuilder()
            sb.append(wrapWithColorTag("Next combat level:</br>", COMBAT_LEVEL_COLOUR))
            if (attackLevel + strengthLevel < Experience.MAX_REAL_LEVEL * 2) {
                sb.append(meleeNeed).append(" Attack/Strength</br>")
            }
            if (hitpointsLevel + defenceLevel < Experience.MAX_REAL_LEVEL * 2) {
                sb.append(hpDefNeed).append(" Defence/Hitpoints</br>")
            }
            if (rangeLevel < Experience.MAX_REAL_LEVEL) {
                sb.append(rangeNeed).append(" Ranged</br>")
            }
            if (magicLevel < Experience.MAX_REAL_LEVEL) {
                sb.append(magicNeed).append(" Magic</br>")
            }
            if (prayerLevel < Experience.MAX_REAL_LEVEL) {
                sb.append(prayerNeed).append(" Prayer")
            }
            return sb.toString()
        }

    companion object {
        private val COMBAT_LEVEL_COLOUR = Color(0xff981f)
    }
}