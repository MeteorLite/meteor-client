/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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

import eventbus.events.ConfigChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.widgets.WidgetInfo
import java.text.DecimalFormat
import java.util.regex.Pattern

@PluginDescriptor(
    name = "Combat Level",
    description = "Show a more accurate combat level in Combat Options panel and other combat level functions",
    tags = ["wilderness", "attack", "range"]
)
class CombatLevelPlugin : Plugin() {
    override var config = configuration<CombatLevelConfig>()
    private val overlay = overlay(CombatLevelOverlay(config))
    override fun onStart() {
        if (config.wildernessAttackLevelRange()) {
            appendAttackLevelRangeText()
        }
    }

    override fun onStop() {
        val combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL)
        if (combatLevelWidget != null) {
            val widgetText = combatLevelWidget.text
            if (widgetText.contains(".")) {
                combatLevelWidget.text = widgetText.substring(0, widgetText.indexOf("."))
            }
        }
        shutDownAttackLevelRange()
    }

    override fun onGameTick(): ((Event<eventbus.events.GameTick>) -> Unit) = {
        if (client.gameState == GameState.LOGGED_IN) {
            val combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL)
            if (combatLevelWidget != null && config.showPreciseCombatLevel()) {
                val combatLevelPrecise = Experience.getCombatLevelPrecise(
                    client.getRealSkillLevel(Skill.ATTACK),
                    client.getRealSkillLevel(Skill.STRENGTH),
                    client.getRealSkillLevel(Skill.DEFENCE),
                    client.getRealSkillLevel(Skill.HITPOINTS),
                    client.getRealSkillLevel(Skill.MAGIC),
                    client.getRealSkillLevel(Skill.RANGED),
                    client.getRealSkillLevel(Skill.PRAYER)
                )
                combatLevelWidget.text = "Combat Lvl: " + DECIMAL_FORMAT.format(combatLevelPrecise)
            }
        }
    }

    override fun onConfigChanged(): ((Event<ConfigChanged>) -> Unit) = {
        val it = it.data
        if (CONFIG_GROUP == it.group && ATTACK_RANGE_CONFIG_KEY == it.key) {
            if (config.wildernessAttackLevelRange()) {
                appendAttackLevelRangeText()
            } else {
                shutDownAttackLevelRange()
            }
        }
    }

    override fun onScriptPostFired(): ((Event<eventbus.events.ScriptPostFired>) -> Unit) = {
        val it = it.data
        if (it.scriptId == ScriptID.PVP_WIDGET_BUILDER && config
                .wildernessAttackLevelRange()
        ) {
            appendAttackLevelRangeText()
        }
    }

    private fun appendAttackLevelRangeText() {
        val wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL) ?: return
        val wildernessLevelText = wildernessLevelWidget.text
        val m = WILDERNESS_LEVEL_PATTERN.matcher(wildernessLevelText)
        if (!m.matches()
            || WorldType.isPvpWorld(client.worldType)
        ) {
            return
        }
        val wildernessLevel = m.group(1).toInt()
        val combatLevel = client.localPlayer!!.combatLevel
        wildernessLevelWidget.text =
            wildernessLevelText + "<br>" + combatAttackRange(combatLevel, wildernessLevel)
    }

    private fun shutDownAttackLevelRange() {
        if (WorldType.isPvpWorld(client.worldType)) {
            return
        }
        val wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL)
        if (wildernessLevelWidget != null) {
            val wildernessLevelText = wildernessLevelWidget.text
            if (wildernessLevelText.contains("<br>")) {
                wildernessLevelWidget.text = wildernessLevelText.substring(0, wildernessLevelText.indexOf("<br>"))
            }
        }
    }

    companion object {
        private val DECIMAL_FORMAT = DecimalFormat("#.###")
        private const val CONFIG_GROUP = "combatlevel"
        private const val ATTACK_RANGE_CONFIG_KEY = "wildernessAttackLevelRange"
        private val WILDERNESS_LEVEL_PATTERN = Pattern.compile("^Level: (\\d+)$")
        private const val MIN_COMBAT_LEVEL = 3
        private fun combatAttackRange(combatLevel: Int, wildernessLevel: Int): String {
            return Math.max(MIN_COMBAT_LEVEL, combatLevel - wildernessLevel).toString() + "-" + Math
                .min(Experience.MAX_COMBAT_LEVEL, combatLevel + wildernessLevel)
        }
    }
}