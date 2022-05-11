/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018, Levi <me@levischuck.com>
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
package meteor.plugins.xptracker

import com.google.common.collect.ImmutableList
import eventbus.events.*
import meteor.Main
import meteor.game.NPCManager
import meteor.game.SkillIconManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayManager
import net.runelite.api.*
import net.runelite.api.util.Text
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import net.runelite.http.api.xp.XpClient
import java.util.*
import java.util.concurrent.TimeUnit

@Suppress("NAME_SHADOWING")
@PluginDescriptor(
    name = "XP Tracker",
    description = "Enable the XP Tracker panel",
    tags = ["experience", "levels", "panel"],
    configGroup = "xpTracker"
)
class XpTrackerPlugin : Plugin() {
    private val skillIconManager = SkillIconManager
    override val config = configuration<XpTrackerConfig>()
    private val npcManager = NPCManager
    private val xpClient: XpClient = Main.xpClient
    private val xpState = XpState(config)

    private val executorService = Main.executor
    private var lastWorldType: XpWorldType? = null
    private var lastUsername: String? = null
    private var lastTickMillis: Long = 0
    private var fetchXp // fetch lastXp for the online xp tracker
            = false
    private var lastXp: Long = 0
    private var initializeTracker = false
    private val xpPauseState = XpPauseState()
    private var startedCooldowns = false
    private var ignoredfirstHPUpdate = false
    private val skillUpdates = HashMap<Skill, Long>()
    private val lastSkillXPs = HashMap<Skill, Int>()

    override fun onStart() {
        // Initialize the tracker & last xp if already logged in
        fetchXp = true
        initializeTracker = true
        if (!startedCooldowns) executorService.scheduleAtFixedRate({
            if (client.localPlayer != null) {
                if (skillUpdates.size > 0) {
                    for (s in skillUpdates.keys) {
                        val elapsedMilli = System.currentTimeMillis() - skillUpdates[s]!!
                        if (elapsedMilli / 1000 / 60 > config.infoboxCooldown()) if (hasOverlay(s)) removeOverlay(
                            s
                        )
                    }
                }
            }
        }, 0, config.infoboxCooldown().toLong(), TimeUnit.MINUTES)
        startedCooldowns = true
    }

    override fun onStop() {
        OverlayManager.removeIf { e: Overlay? -> e is XpInfoBoxOverlay }
        xpState.reset()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        val state = it.gameState
        if (state == GameState.LOGGED_IN) {
            // LOGGED_IN is triggered between region changes too.
            // Check that the username changed or the world type changed.
            val type = worldSetToType(client.worldType)
            if (client.username != lastUsername || lastWorldType !== type) {
                // Reset
                lastUsername = client.username
                // xp is not available until after login is finished, so fetch it on the next gametick
                fetchXp = true
                lastWorldType = type
                resetState()
            }
        } else if (state == GameState.LOGGING_IN || state == GameState.HOPPING) {
            initializeTracker = true
        } else if (state == GameState.LOGIN_SCREEN) {
            val local = client.localPlayer
            if (local != null) {
                val username = local.name
                if (username != null) {
                    val totalXp = client.overallExperience
                    // Don't submit xptrack unless xp threshold is reached
                    if (Math.abs(totalXp - lastXp) > XP_THRESHOLD) {
                        xpClient.update(username)
                        lastXp = totalXp
                    }
                }
            }
        }
    }

    private fun worldSetToType(types: EnumSet<WorldType>): XpWorldType {
        var xpType = XpWorldType.NORMAL
        for (type in types) {
            val t = XpWorldType.of(type)
            if (t !== XpWorldType.NORMAL) {
                xpType = t
            }
        }
        return xpType
    }

    /**
     * Adds an overlay to the canvas for tracking a specific skill.
     *
     * @param skill the skill for which the overlay should be added
     */
    fun addOverlay(skill: Skill?) {
        removeOverlay(skill)
        OverlayManager.add(
            XpInfoBoxOverlay(
                this, config, skill!!, skillIconManager.getSkillImage(
                    skill
                )!!
            )
        )
    }

    /**
     * Removes an overlay from the overlayManager if it's present.
     *
     * @param skill the skill for which the overlay should be removed.
     */
    fun removeOverlay(skill: Skill?) {
        OverlayManager.removeIf { e: Overlay? -> e is XpInfoBoxOverlay && e.skill === skill }
    }

    /**
     * Check if there is an overlay on the canvas for the skill.
     *
     * @param skill the skill which should have an overlay.
     * @return true if the skill has an overlay.
     */
    fun hasOverlay(skill: Skill?): Boolean {
        return OverlayManager.anyMatch { o: Overlay? -> o is XpInfoBoxOverlay && o.skill === skill }
    }

    /**
     * Reset internal state and re-initialize all skills with XP currently cached by the RS client
     * This is called by the user manually clicking resetSkillState in the UI.
     * It reloads the current skills from the client after resetting internal state.
     */
    fun resetAndInitState() {
        resetState()
        for (skill in Skill.values()) {
            var currentXp: Long
            currentXp = if (skill == Skill.OVERALL) {
                client.overallExperience
            } else {
                client.getSkillExperience(skill).toLong()
            }
            xpState.initializeSkill(skill, currentXp)
            removeOverlay(skill)
        }
    }

    /**
     * Throw out everything, the user has chosen a different account or world type.
     * This resets both the internal state and UI elements
     */
    private fun resetState() {
        xpState.reset()
        OverlayManager.removeIf { e: Overlay? -> e is XpInfoBoxOverlay }
    }

    /**
     * Reset an individual skill with the client's current known state of the skill
     * Will also clear the skill from the UI.
     *
     * @param skill Skill to reset
     */
    fun resetSkillState(skill: Skill?) {
        val currentXp = client.getSkillExperience(skill)
        xpState.resetSkill(skill!!, currentXp.toLong())
        removeOverlay(skill)
    }

    /**
     * Reset all skills except for the one provided
     *
     * @param skill Skill to ignore during reset
     */
    fun resetOtherSkillState(skill: Skill) {
        for (s in Skill.values()) {
            // Overall is not reset from resetting individual skills
            if (skill != s && s != Skill.OVERALL) {
                resetSkillState(s)
            }
        }
    }

    /**
     * Reset the xp gained since last reset of the skill
     * Does not clear the skill from the UI.
     *
     * @param skill Skill to reset per hour rate
     */
    fun resetSkillPerHourState(skill: Skill?) {
        xpState.resetSkillPerHour(skill!!)
    }

    /**
     * Reset the xp gained since last reset of all skills including OVERALL
     * Does not clear the UI.
     */
    fun resetAllSkillsPerHourState() {
        for (skill in Skill.values()) {
            resetSkillPerHourState(skill)
        }
    }

    override fun onStatChanged(it: StatChanged) {
        try {
            val skill = it.skill
            val currentXp = it.xp
            val currentLevel = it.level
            val startGoal = startGoalVarpForSkill(skill)
            val endGoal = endGoalVarpForSkill(skill)
            val startGoalXp = if (startGoal != null) client.getVar(startGoal) else -1
            val endGoalXp = if (endGoal != null) client.getVar(endGoal) else -1
            if (!initializeTracker) {
                // This is the XP sync on login, wait until after login to begin counting
                if (!config.hideMaxed() && currentLevel < Experience.MAX_REAL_LEVEL) {
                    val state = xpState.getSkill(skill)
                    state.actionType = XpActionType.EXPERIENCE
                    val interacting = client.localPlayer!!.interacting
                    if (interacting is NPC && COMBAT.contains(skill)) {
                        val xpModifier = worldSetToType(client.worldType).modifier(client)
                        val npc = interacting
                        xpState.updateNpcExperience(skill, npc, npcManager.getHealth(npc.id), xpModifier)
                    }
                    xpState.updateSkill(skill, currentXp.toLong(), startGoalXp, endGoalXp)
                    // Also update the total experience
                    xpState.updateSkill(Skill.OVERALL, client.overallExperience, -1, -1)
                    if (it.skill == Skill.HITPOINTS)
                        if (!ignoredfirstHPUpdate) {
                            ignoredfirstHPUpdate = true
                        }
                        if (config.addToCanvasOnUpdate()) {
                            skillUpdates[skill] = System.currentTimeMillis()
                            if (!hasOverlay(skill)) {
                                if (lastSkillXPs.getOrDefault(skill, client.getSkillExperience(skill)) != client.getSkillExperience(
                                        skill
                                    )
                                ) {
                                    addOverlay(skill)
                                }
                            }
                            lastSkillXPs[skill] = client.getSkillExperience(skill)
                        }
                }
            }
        } catch(e: Exception) {
            e.printStackTrace()
        }


    }

    override fun onGameTick(it: GameTick) {
        if (initializeTracker) {
            initializeTracker = false

            // Check for xp gained while logged out
            for (skill in Skill.values()) {
                if (skill == Skill.OVERALL || !xpState.isInitialized(skill)) {
                    continue
                }
                val skillState = xpState.getSkill(skill)
                val currentXp = client.getSkillExperience(skill)
                if (skillState.currentXp != currentXp.toLong()) {
                    if (currentXp < skillState.currentXp) {
                        resetState()
                        break
                    }

                    // Offset start xp for offline gains
                    val diff = currentXp - skillState.currentXp
                    skillState.startXp = skillState.startXp + diff
                }
            }

            // Initialize the tracker with the initial xp if not already initialized
            for (skill in Skill.values()) {
                if (skill == Skill.OVERALL) {
                    continue
                }
                if (!xpState.isInitialized(skill)) {
                    val currentXp = client.getSkillExperience(skill)
                    // goal exps are not necessary for skill initialization
                    val xpUpdateResult = xpState.updateSkill(skill, currentXp.toLong(), -1, -1)
                    assert(xpUpdateResult === XpUpdateResult.INITIALIZED)
                }
            }

            // Initialize the overall xp
            if (!xpState.isInitialized(Skill.OVERALL)) {
                val overallXp = client.overallExperience
                xpState.initializeSkill(Skill.OVERALL, overallXp)
            }
        }
        if (fetchXp) {
            lastXp = client.overallExperience
            fetchXp = false
        }
        rebuildSkills()
    }

/*    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        val widgetID = it.param1
        if (WidgetInfo.TO_GROUP(widgetID) == WidgetID.SKILLS_GROUP_ID && it.option.startsWith("View")
            && config.skillTabOverlayMenuOptions()
        ) {
            // Get skill from menu option, eg. "View <col=ff981f>Attack</col> guide"
            val skillText = it.option!!.split(" ").toTypedArray()[1]
            val skill = Skill.valueOf(Text.removeTags(skillText).uppercase(Locale.getDefault()))
            var menuEntries = client.menuEntries
            menuEntries = Arrays.copyOf(menuEntries, menuEntries.size + 1)
            menuEntries[menuEntries.size - 1] = MenuEntry()
            val menuEntry = menuEntries[menuEntries.size - 1]
            menuEntry.target = skillText
            menuEntry.option =
                if (hasOverlay(skill)) MENUOP_REMOVE_CANVAS_TRACKER else MENUOP_ADD_CANVAS_TRACKER
            menuEntry.param0 = it.actionParam0
            menuEntry.param1 = widgetID
            menuEntry.type = MenuAction.RUNELITE.id
            client.menuEntries = menuEntries
        }
    }*/

    override fun onMenuEntryAdded(event: MenuEntryAdded) {
        val widgetID: Int = event.param1
        if (WidgetInfo.TO_GROUP(widgetID) != WidgetID.SKILLS_GROUP_ID || !event.option!!.startsWith("View")
        ) {
            return
        }

        // Get skill from menu option, eg. "View <col=ff981f>Attack</col> guide"
        val skillText: String = event.option!!.split(" ").get(1)
        val skill = Skill.valueOf(Text.removeTags(skillText).toUpperCase())
        client.createMenuEntry(-1)
            .setTarget(skillText)
            .setOption(if (hasOverlay(skill)) MENUOP_REMOVE_CANVAS_TRACKER else MENUOP_ADD_CANVAS_TRACKER)
            .setType(MenuAction.RUNELITE)
            .onClick { e: MenuEntry? ->
                if (hasOverlay(skill)) {
                    removeOverlay(skill)
                } else {
                    addOverlay(skill)
                }
            }
    }

    fun getSkillState(skill: Skill?): XpStateSingle {
        return xpState.getSkill(skill!!)
    }

    fun getSkillSnapshot(skill: Skill?): XpSnapshotSingle {
        return xpState.getSkillSnapshot(skill!!)
    }

    init {
        Main.executor.scheduleAtFixedRate(this::tickSkillTimes, 0L, 1L, TimeUnit.SECONDS)
    }

    fun tickSkillTimes() {
        try {
            // Adjust unpause states
            for (skill in Skill.values()) {
                val skillExperience: Long = if (skill == Skill.OVERALL) {
                    client.overallExperience
                } else {
                    client.getSkillExperience(skill).toLong()
                }
                xpPauseState.tickXp(skill, skillExperience, config.pauseSkillAfter())
            }
            val loggedIn: Boolean = when (client.gameState) {
                GameState.LOGIN_SCREEN, GameState.LOGGING_IN, GameState.LOGIN_SCREEN_AUTHENTICATOR -> false
                else -> true
            }
            xpPauseState.tickLogout(config.pauseOnLogout(), loggedIn)
            if (lastTickMillis == 0L) {
                lastTickMillis = System.currentTimeMillis()
                return
            }
            val nowMillis = System.currentTimeMillis()
            val tickDelta = nowMillis - lastTickMillis
            lastTickMillis = nowMillis
            for (skill in Skill.values()) {
                if (!xpPauseState.isPaused(skill)) {
                    xpState.tick(skill, tickDelta)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun rebuildSkills() {}
    fun pauseSkill(skill: Skill?, pause: Boolean) {}
    fun pauseAllSkills(pause: Boolean) {
        for (skill in Skill.values()) {
            pauseSkill(skill, pause)
        }
    }

    companion object {
        /**
         * Amount of EXP that must be gained for an update to be submitted.
         */
        private const val XP_THRESHOLD = 10000
        private const val MENUOP_ADD_CANVAS_TRACKER = "Add to canvas"
        private const val MENUOP_REMOVE_CANVAS_TRACKER = "Remove from canvas"
        val COMBAT: List<Skill> = ImmutableList.of(
            Skill.ATTACK,
            Skill.STRENGTH,
            Skill.DEFENCE,
            Skill.RANGED,
            Skill.HITPOINTS,
            Skill.MAGIC
        )

        private fun startGoalVarpForSkill(skill: Skill): VarPlayer? {
            return when (skill) {
                Skill.ATTACK -> VarPlayer.ATTACK_GOAL_START
                Skill.MINING -> VarPlayer.MINING_GOAL_START
                Skill.WOODCUTTING -> VarPlayer.WOODCUTTING_GOAL_START
                Skill.DEFENCE -> VarPlayer.DEFENCE_GOAL_START
                Skill.MAGIC -> VarPlayer.MAGIC_GOAL_START
                Skill.RANGED -> VarPlayer.RANGED_GOAL_START
                Skill.HITPOINTS -> VarPlayer.HITPOINTS_GOAL_START
                Skill.AGILITY -> VarPlayer.AGILITY_GOAL_START
                Skill.STRENGTH -> VarPlayer.STRENGTH_GOAL_START
                Skill.PRAYER -> VarPlayer.PRAYER_GOAL_START
                Skill.SLAYER -> VarPlayer.SLAYER_GOAL_START
                Skill.FISHING -> VarPlayer.FISHING_GOAL_START
                Skill.RUNECRAFT -> VarPlayer.RUNECRAFT_GOAL_START
                Skill.HERBLORE -> VarPlayer.HERBLORE_GOAL_START
                Skill.FIREMAKING -> VarPlayer.FIREMAKING_GOAL_START
                Skill.CONSTRUCTION -> VarPlayer.CONSTRUCTION_GOAL_START
                Skill.HUNTER -> VarPlayer.HUNTER_GOAL_START
                Skill.COOKING -> VarPlayer.COOKING_GOAL_START
                Skill.FARMING -> VarPlayer.FARMING_GOAL_START
                Skill.CRAFTING -> VarPlayer.CRAFTING_GOAL_START
                Skill.SMITHING -> VarPlayer.SMITHING_GOAL_START
                Skill.THIEVING -> VarPlayer.THIEVING_GOAL_START
                Skill.FLETCHING -> VarPlayer.FLETCHING_GOAL_START
                else -> null
            }
        }

        private fun endGoalVarpForSkill(skill: Skill): VarPlayer? {
            return when (skill) {
                Skill.ATTACK -> VarPlayer.ATTACK_GOAL_END
                Skill.MINING -> VarPlayer.MINING_GOAL_END
                Skill.WOODCUTTING -> VarPlayer.WOODCUTTING_GOAL_END
                Skill.DEFENCE -> VarPlayer.DEFENCE_GOAL_END
                Skill.MAGIC -> VarPlayer.MAGIC_GOAL_END
                Skill.RANGED -> VarPlayer.RANGED_GOAL_END
                Skill.HITPOINTS -> VarPlayer.HITPOINTS_GOAL_END
                Skill.AGILITY -> VarPlayer.AGILITY_GOAL_END
                Skill.STRENGTH -> VarPlayer.STRENGTH_GOAL_END
                Skill.PRAYER -> VarPlayer.PRAYER_GOAL_END
                Skill.SLAYER -> VarPlayer.SLAYER_GOAL_END
                Skill.FISHING -> VarPlayer.FISHING_GOAL_END
                Skill.RUNECRAFT -> VarPlayer.RUNECRAFT_GOAL_END
                Skill.HERBLORE -> VarPlayer.HERBLORE_GOAL_END
                Skill.FIREMAKING -> VarPlayer.FIREMAKING_GOAL_END
                Skill.CONSTRUCTION -> VarPlayer.CONSTRUCTION_GOAL_END
                Skill.HUNTER -> VarPlayer.HUNTER_GOAL_END
                Skill.COOKING -> VarPlayer.COOKING_GOAL_END
                Skill.FARMING -> VarPlayer.FARMING_GOAL_END
                Skill.CRAFTING -> VarPlayer.CRAFTING_GOAL_END
                Skill.SMITHING -> VarPlayer.SMITHING_GOAL_END
                Skill.THIEVING -> VarPlayer.THIEVING_GOAL_END
                Skill.FLETCHING -> VarPlayer.FLETCHING_GOAL_END
                else -> null
            }
        }
    }
}