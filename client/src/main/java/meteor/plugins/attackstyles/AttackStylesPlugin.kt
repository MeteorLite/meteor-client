/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package meteor.plugins.attackstyles

import com.google.common.annotations.VisibleForTesting
import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.ScriptPostFired
import eventbus.events.VarbitChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(name = "Attack Styles", description = "Show your current attack style as an overlay", tags = ["combat", "defence", "magic", "overlay", "ranged", "strength", "warn", "pure"])
class AttackStylesPlugin : Plugin() {
    private var equippedWeaponTypeVarbit = -1
    var attackStyle: AttackStyle? = null
        private set
    private val warnedSkills: MutableSet<Skill> = HashSet()
    var isWarnedSkillSelected = false
        private set

    val hiddenWidgets: Table<WeaponType?, WidgetInfo, Boolean> = HashBasedTable.create()
    private val clientThread = ClientThread
    private val config = configuration<AttackStylesConfig>()
    private val overlay = AttackStylesOverlay(this, config)
    override fun onStart() {
        overlayManager.add(overlay)
        if (client.gameState == GameState.LOGGED_IN) {
            clientThread.invoke { pStart() }
        }
    }

    private fun pStart() {
        resetWarnings()
        val attackStyleVarbit = client.getVarpValue(VarPlayer.ATTACK_STYLE)
        equippedWeaponTypeVarbit = client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE)
        val castingModeVarbit = client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE)
        updateAttackStyle(
                equippedWeaponTypeVarbit,
                attackStyleVarbit,
                castingModeVarbit)
        updateWarning(false)
        processWidgets()
    }

    override fun onStop() {
        overlayManager.remove(overlay)
        hideWarnedStyles(false)
        processWidgets()
        hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), false)
    }

    override fun onScriptPostFired(scriptPostFired: ScriptPostFired) {
        if (scriptPostFired.scriptId == ScriptID.COMBAT_INTERFACE_SETUP) {
            processWidgets()
        }
    }

    /**
     * Hide or unhide widgets depending on widgetsToHide
     */
    private fun processWidgets() {
        val equippedWeaponType: WeaponType? = WeaponType.getWeaponType(equippedWeaponTypeVarbit)
        if (hiddenWidgets.containsRow(equippedWeaponType)) {
            for (widgetKey in hiddenWidgets.row(equippedWeaponType).keys) {
                hideWidget(client.getWidget(widgetKey), hiddenWidgets[equippedWeaponType, widgetKey]!!)
            }
        }
        hideWidget(client.getWidget(WidgetInfo.COMBAT_AUTO_RETALIATE), config.hideAutoRetaliate())
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGGED_IN) {
            resetWarnings()
        }
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        if (it.varpId == VarPlayer.ATTACK_STYLE.id || it.varbitId == Varbits.EQUIPPED_WEAPON_TYPE || it.varbitId == Varbits.DEFENSIVE_CASTING_MODE) {
            val currentAttackStyleVarbit = client.getVarpValue(VarPlayer.ATTACK_STYLE)
            val currentEquippedWeaponTypeVarbit = client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE)
            val currentCastingModeVarbit = client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE)
            val weaponSwitch = currentEquippedWeaponTypeVarbit != equippedWeaponTypeVarbit
            equippedWeaponTypeVarbit = currentEquippedWeaponTypeVarbit
            updateAttackStyle(equippedWeaponTypeVarbit, currentAttackStyleVarbit,
                    currentCastingModeVarbit)
            updateWarning(weaponSwitch)

            // this isn't required, but will hide styles 1 tick earlier than the script event, which fires
            // 1 tick after the combat options is unhidden
            if (weaponSwitch) {
                processWidgets()
            }
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "attackIndicator") {
            val enabled = java.lang.Boolean.TRUE.toString() == it.newValue
            when (it.key) {
                "warnForDefensive" -> updateWarnedSkills(enabled, Skill.DEFENCE)
                "warnForAttack" -> updateWarnedSkills(enabled, Skill.ATTACK)
                "warnForStrength" -> updateWarnedSkills(enabled, Skill.STRENGTH)
                "warnForRanged" -> updateWarnedSkills(enabled, Skill.RANGED)
                "warnForMagic" -> updateWarnedSkills(enabled, Skill.MAGIC)
                "removeWarnedStyles" -> hideWarnedStyles(enabled)
            }
            processWidgets()
        }
    }

    private fun resetWarnings() {
        updateWarnedSkills(config.warnForAttack(), Skill.ATTACK)
        updateWarnedSkills(config.warnForStrength(), Skill.STRENGTH)
        updateWarnedSkills(config.warnForDefence(), Skill.DEFENCE)
        updateWarnedSkills(config.warnForRanged(), Skill.RANGED)
        updateWarnedSkills(config.warnForMagic(), Skill.MAGIC)
    }

    private fun updateAttackStyle(equippedWeaponType: Int, attackStyleIndex: Int, castingMode: Int) {
        val attackStyles: Array<AttackStyle> = WeaponType.getWeaponType(equippedWeaponType)!!.attackStyles
        if (attackStyleIndex < attackStyles.size) {
            attackStyle = attackStyles[attackStyleIndex]
            if (attackStyle == null) {
                attackStyle = AttackStyle.OTHER
            } else if (attackStyle == AttackStyle.CASTING && castingMode == 1) {
                attackStyle = AttackStyle.DEFENSIVE_CASTING
            }
        }
    }

    private fun updateWarnedSkills(enabled: Boolean, skill: Skill) {
        if (enabled) {
            warnedSkills.add(skill)
        } else {
            warnedSkills.remove(skill)
        }
        updateWarning(false)
    }

    private fun updateWarning(weaponSwitch: Boolean) {
        isWarnedSkillSelected = false
        if (attackStyle != null) {
            for (skill in attackStyle!!.skills) {
                if (warnedSkills.contains(skill)) {
                    if (weaponSwitch) { // NOPMD EmptyIfStmt
                        // TODO : chat message to warn players that their weapon switch also caused an unwanted attack style change
                    }
                    isWarnedSkillSelected = true
                    break
                }
            }
        }
        hideWarnedStyles(config.removeWarnedStyles())
    }

    private fun hideWarnedStyles(enabled: Boolean) {
        val equippedWeaponType: WeaponType = WeaponType.getWeaponType(equippedWeaponTypeVarbit)
                ?: return
        val attackStyles = equippedWeaponType.attackStyles

        // Iterate over attack styles
        for (i in attackStyles.indices) {
            val attackStyle = attackStyles[i]
                    ?: continue
            var warnedSkill = false
            for (skill in attackStyle.skills) {
                if (warnedSkills.contains(skill)) {
                    warnedSkill = true
                    break
                }
            }

            // Magic staves defensive casting mode
            if (attackStyle == AttackStyle.DEFENSIVE_CASTING || !enabled) {
                hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_BOX, enabled && warnedSkill)
                hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_ICON, enabled && warnedSkill)
                hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_SHIELD, enabled && warnedSkill)
                hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_DEFENSIVE_SPELL_TEXT, enabled && warnedSkill)
            }
            when (i) {
                0 -> hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_ONE, enabled && warnedSkill)
                1 -> hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_TWO, enabled && warnedSkill)
                2 -> hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_THREE, enabled && warnedSkill)
                3 -> hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_STYLE_FOUR, enabled && warnedSkill)
                4 -> hiddenWidgets.put(equippedWeaponType, WidgetInfo.COMBAT_SPELLS, enabled && warnedSkill)
                else -> {}
            }
        }
    }

    private fun hideWidget(widget: Widget?, hidden: Boolean) {
        if (widget != null) {
            widget.isHidden = hidden
        }
    }

    @VisibleForTesting
    fun getWarnedSkills(): Set<Skill> {
        return warnedSkills
    }
}