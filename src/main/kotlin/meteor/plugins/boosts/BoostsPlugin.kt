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

import com.google.common.collect.ImmutableSet
import eventbus.events.ConfigChanged
import meteor.game.SkillIconManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.util.ImageUtil
import net.runelite.api.*
import java.util.*

@PluginDescriptor(
    name = "Boosts",
    description = "Show combat and/or skill boost information",
    tags = ["combat", "skilling", "overlay"]
)
class BoostsPlugin : Plugin() {
    override var config = configuration<BoostsConfig>()
    private val boostsOverlay = overlay(BoostsOverlay(config, this))

    val skillsToDisplay: MutableSet<Skill> = EnumSet.noneOf(
        Skill::class.java
    )
    private val shownSkills: MutableSet<Skill> = EnumSet.noneOf(
        Skill::class.java
    )
    private val lastSkillLevels = IntArray(Skill.values().size - 1)
    private val infoBoxManager = InfoBoxManager
    private val skillIconManager = SkillIconManager

    private var isChangedDown = false
    private var isChangedUp = false
    private var lastChangeDown = -1
    private var lastChangeUp = -1
    private var preserveBeenActive = false
    private var lastTickMillis: Long = 0

    override fun onStart() {
        updateShownSkills()
        Arrays.fill(lastSkillLevels, -1)

        // Add infoboxes for everything at startup and then determine inside if it will be rendered
        infoBoxManager.addInfoBox(
            StatChangeIndicator(
                true, ImageUtil.loadImageResource(javaClass, "debuffed.png"), this,
                config
            )
        )
        infoBoxManager.addInfoBox(
            StatChangeIndicator(
                false, ImageUtil.loadImageResource(javaClass, "buffed.png"), this,
                config
            )
        )
        for (skill in Skill.values()) {
            if (skill != Skill.OVERALL) {
                infoBoxManager.addInfoBox(
                    BoostIndicator(skill, skillIconManager.getSkillImage(skill), this, client, config)
                )
            }
        }
    }

    override fun onStop() {
        infoBoxManager.removeIf { t -> t is BoostIndicator || t is StatChangeIndicator }
        preserveBeenActive = false
        lastChangeDown = -1
        lastChangeUp = -1
        isChangedUp = false
        isChangedDown = false
        skillsToDisplay.clear()
    }

    override fun onGameStateChanged(): ((Event<eventbus.events.GameStateChanged>) -> Unit) = {
        when (it.data.new) {
            GameState.LOGIN_SCREEN, GameState.HOPPING -> {
                // After world hop and log out timers are in undefined state so just reset
                lastChangeDown = -1
                lastChangeUp = -1
            }
        }
    }

    override fun onConfigChanged(): ((Event<ConfigChanged>) -> Unit) = {
        if (it.data.group.equals("boosts")) {
            updateShownSkills()
            if (config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER) {
                lastChangeDown = -1
            }
            if (config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER) {
                lastChangeUp = -1
            }
        }
    }

    override fun onStatChanged(): ((Event<eventbus.events.StatChanged>) -> Unit) = {
        val it = it.data
        val skill = it.skill
        if (BOOSTABLE_COMBAT_SKILLS.contains(skill) || BOOSTABLE_NON_COMBAT_SKILLS.contains(skill)) {
            val skillIdx = skill.ordinal
            val last = lastSkillLevels[skillIdx]
            val cur = client.getBoostedSkillLevel(skill)
            if (cur == last - 1) {
                // Stat was restored down (from buff)
                lastChangeDown = client.tickCount
            }
            if (cur == last + 1) {
                // Stat was restored up (from debuff)
                lastChangeUp = client.tickCount
            }
            lastSkillLevels[skillIdx] = cur
            updateBoostedStats()
        }
    }

    override fun onGameTick(): ((Event<eventbus.events.GameTick>) -> Unit) = {
        lastTickMillis = System.currentTimeMillis()
        if (changeUpTicks <= 0) {
            when (config.displayNextDebuffChange()) {
                BoostsConfig.DisplayChangeMode.ALWAYS -> if (lastChangeUp != -1) {
                    lastChangeUp = client.tickCount
                }
                BoostsConfig.DisplayChangeMode.BOOSTED, BoostsConfig.DisplayChangeMode.NEVER -> lastChangeUp = -1
            }
        }
        if (changeDownTicks <= 0) {
            when (config.displayNextBuffChange()) {
                BoostsConfig.DisplayChangeMode.ALWAYS -> if (lastChangeDown != -1) {
                    lastChangeDown = client.tickCount
                }
                BoostsConfig.DisplayChangeMode.BOOSTED, BoostsConfig.DisplayChangeMode.NEVER -> lastChangeDown = -1
            }
        }
    }

    private fun updateShownSkills() {
        when (config.displayBoosts()) {
            BoostsConfig.DisplayBoosts.NONE -> {
                shownSkills.removeAll(BOOSTABLE_COMBAT_SKILLS)
                shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS)
            }
            BoostsConfig.DisplayBoosts.COMBAT -> {
                shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS)
                shownSkills.removeAll(BOOSTABLE_NON_COMBAT_SKILLS)
            }
            BoostsConfig.DisplayBoosts.NON_COMBAT -> {
                shownSkills.removeAll(BOOSTABLE_COMBAT_SKILLS)
                shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS)
            }
            BoostsConfig.DisplayBoosts.BOTH -> {
                shownSkills.addAll(BOOSTABLE_COMBAT_SKILLS)
                shownSkills.addAll(BOOSTABLE_NON_COMBAT_SKILLS)
            }
        }
        updateBoostedStats()
    }

    private fun updateBoostedStats() {
        // Reset is boosted
        isChangedDown = false
        isChangedUp = false
        skillsToDisplay.clear()

        // Check if we are still boosted
        for (skill in Skill.values()) {
            if (!shownSkills.contains(skill)) {
                continue
            }
            val boosted = client.getBoostedSkillLevel(skill)
            val base = client.getRealSkillLevel(skill)
            if (boosted > base) {
                isChangedUp = true
            } else if (boosted < base) {
                isChangedDown = true
            }
            if (boosted != base) {
                skillsToDisplay.add(skill)
            }
        }
    }

    fun canShowBoosts(): Boolean {
        return isChangedDown || isChangedUp
    }

    /**
     * Calculates the amount of time until boosted stats decay, accounting for the effect of preserve
     * prayer. Preserve extends the time of boosted stats by 50% while active. The length of a boost
     * is split into 4 sections of 15 seconds each. If the preserve prayer is active for the entire
     * duration of the final section it will "activate" adding an additional 15 second section to the
     * boost timing. If again the preserve prayer is active for that entire section a second 15 second
     * section will be added.
     *
     *
     * Preserve is only required to be on for the 4th and 5th sections of the boost timer to gain full
     * effect (seconds 45-75).
     *
     * @return integer value in ticks until next boost change
     */
    val changeDownTicks: Int
        get() {
            if (lastChangeDown == -1 || config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
                (config.displayNextBuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED
                        && !isChangedUp)
            ) {
                return -1
            }
            val ticksSinceChange = client.tickCount - lastChangeDown
            val isPreserveActive = client.isPrayerActive(Prayer.PRESERVE)
            if (isPreserveActive && (ticksSinceChange < 75 || preserveBeenActive)
                || ticksSinceChange > 125
            ) {
                preserveBeenActive = true
                return 150 - ticksSinceChange
            }
            preserveBeenActive = false
            return if (ticksSinceChange > 100) 125 - ticksSinceChange else 100 - ticksSinceChange
        }

    /**
     * Restoration from debuff is separate timer as restoration from buff because of preserve messing
     * up the buff timer. Restoration timer is always in 100 tick cycles.
     *
     * @return integer value in ticks until next stat restoration up
     */
    val changeUpTicks: Int
        get() {
            if (lastChangeUp == -1 || config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.NEVER ||
                (config.displayNextDebuffChange() == BoostsConfig.DisplayChangeMode.BOOSTED
                        && !isChangedDown)
            ) {
                return -1
            }
            val ticksSinceChange = client.tickCount - lastChangeUp
            return 100 - ticksSinceChange
        }

    /**
     * Converts tick-based time to accurate second time
     *
     * @param time tick-based time
     * @return second-based time
     */
    fun getChangeTime(time: Int): Int {
        val diff = System.currentTimeMillis() - lastTickMillis
        return if (time != -1) ((time * Constants.GAME_TICK_LENGTH - diff) / 1000.0).toInt() else time
    }

    companion object {
        private val BOOSTABLE_COMBAT_SKILLS: Set<Skill> = ImmutableSet.of(
            Skill.ATTACK,
            Skill.STRENGTH,
            Skill.DEFENCE,
            Skill.RANGED,
            Skill.MAGIC
        )
        private val BOOSTABLE_NON_COMBAT_SKILLS: Set<Skill> = ImmutableSet.of(
            Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
            Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING,
            Skill.RUNECRAFT,
            Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER
        )
    }
}