/*
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

import net.runelite.api.NPC
import net.runelite.api.Skill
import java.util.*
import javax.inject.Inject

/**
 * Internal state for the XpTrackerPlugin
 *
 *
 * Note: This class's operations are not currently synchronized.
 * It is intended to be called by the XpTrackerPlugin on the client thread.
 */
internal class XpState(var xpTrackerConfig: XpTrackerConfig) {

    private var interactedNPC: NPC? = null

    /**
     * Resets a single skill
     *
     * @param skill     Skill to reset
     * @param currentXp Current XP to set to, if unknown set to -1
     */
    fun resetSkill(skill: Skill, currentXp: Long) {
        xpSkills.remove(skill)
        xpSkills[skill] = XpStateSingle(skill, currentXp)
    }

    /**
     * Resets the per hour rates of a single skill
     *
     * @param skill Skill to reset per hour rates
     */
    fun resetSkillPerHour(skill: Skill) {
        xpSkills[skill]!!.resetPerHour()
    }

    /**
     * Updates a skill with the current known XP.
     * When the result of this operation is XpUpdateResult.UPDATED, the UI should be updated accordingly.
     * This is to distinguish events that reload all the skill's current values (such as world hopping)
     * and also first-login when the skills are not initialized (the start XP will be -1 in this case).
     *
     * @param skill       Skill to update
     * @param currentXp   Current known XP for this skill
     * @param goalStartXp Possible XP start goal
     * @param goalEndXp   Possible XP end goal
     * @return Whether or not the skill has been initialized, there was no change, or it has been updated
     */
    fun updateSkill(skill: Skill, currentXp: Long, goalStartXp: Int, goalEndXp: Int): XpUpdateResult {
        val state = getSkill(skill)
        return if (state.startXp == -1L) {
            if (currentXp >= 0) {
                initializeSkill(skill, currentXp)
                XpUpdateResult.INITIALIZED
            } else {
                XpUpdateResult.NO_CHANGE
            }
        } else {
            val startXp = state.startXp
            val gainedXp = state.totalXpGained
            if (startXp + gainedXp > currentXp) {
                // Reinitialize with lesser currentXp, this can happen with negative xp lamps
                initializeSkill(skill, currentXp)
                XpUpdateResult.INITIALIZED
            } else {
                if (state.update(
                        currentXp,
                        goalStartXp,
                        goalEndXp
                    )
                ) XpUpdateResult.UPDATED else XpUpdateResult.NO_CHANGE
            }
        }
    }

    private fun getCombatXPModifier(skill: Skill): Double {
        return if (skill == Skill.HITPOINTS) {
            SHARED_XP_MODIFIER
        } else DEFAULT_XP_MODIFIER
    }

    /**
     * Updates skill with average actions based on currently interacted NPC.
     *
     * @param skill     experience gained skill
     * @param npc       currently interacted NPC
     * @param npcHealth health of currently interacted NPC
     */
    fun updateNpcExperience(skill: Skill, npc: NPC?, npcHealth: Int?, xpModifier: Int) {
        if (npc == null || npc.combatLevel <= 0 || npcHealth == null) {
            return
        }
        val state = getSkill(skill)
        val actionExp = (npcHealth * getCombatXPModifier(skill) * xpModifier).toInt()
        val action = state.getXpAction(XpActionType.ACTOR_HEALTH)
        if (action.actionsHistoryInitialized) {
            action.actionExps[action.actionExpIndex] = actionExp
            if (interactedNPC !== npc) {
                action.actionExpIndex = (action.actionExpIndex + 1) % action.actionExps.size
            }
        } else {
            // So we have a decent average off the bat, lets populate all values with what we see.
            Arrays.fill(action.actionExps, actionExp)
            action.actionsHistoryInitialized = true
        }
        interactedNPC = npc
        state.actionType = XpActionType.ACTOR_HEALTH
    }

    /**
     * Update number of actions performed for skill if last interacted NPC died.
     * (eg. amount of kills in this case)
     *
     * @param skill     skill to update actions for
     * @param npc       npc that just died
     * @param npcHealth max health of npc that just died
     * @return UPDATED in case new kill was successfully added
     */
    fun updateNpcKills(skill: Skill, npc: NPC, npcHealth: Int?): XpUpdateResult {
        val state = getSkill(skill)
        if (state.xpGainedSinceReset <= 0 || npcHealth == null || npc !== interactedNPC) {
            return XpUpdateResult.NO_CHANGE
        }
        val xpAction = state.getXpAction(XpActionType.ACTOR_HEALTH)
        xpAction.actionsSinceReset = xpAction.actionsSinceReset + 1
        return if (xpAction.actionsHistoryInitialized) XpUpdateResult.UPDATED else XpUpdateResult.NO_CHANGE
    }

    fun tick(skill: Skill, delta: Long) {
        val state = getSkill(skill)
        state.tick(delta)
        val resetAfterMinutes = xpTrackerConfig!!.resetSkillRateAfter()
        if (resetAfterMinutes > 0) {
            val now = System.currentTimeMillis()
            val resetAfterMillis = resetAfterMinutes * 60 * 1000
            val lastChangeMillis = state.lastChangeMillis
            // When pauseSkillAfter is 0, it is effectively disabled
            if (lastChangeMillis != 0L && now - lastChangeMillis >= resetAfterMillis) {
                state.resetPerHour()
            }
        }
    }

    /**
     * Forcefully initialize a skill with a known start XP from the current XP.
     * This is used in resetAndInitState by the plugin. It should not result in showing the XP in the UI.
     *
     * @param skill     Skill to initialize
     * @param currentXp Current known XP for the skill
     */
    fun initializeSkill(skill: Skill, currentXp: Long) {
        xpSkills[skill] = XpStateSingle(skill, currentXp)
    }

    fun isInitialized(skill: Skill): Boolean {
        val xpStateSingle = xpSkills[skill]
        return xpStateSingle != null && xpStateSingle.startXp != -1L
    }

    fun getSkill(skill: Skill): XpStateSingle {
        return xpSkills.computeIfAbsent(skill) { s: Skill? ->
            XpStateSingle(
                s!!, -1
            )
        }
    }

    /**
     * Obtain an immutable snapshot of the provided skill
     * intended for use with the UI which operates on another thread
     *
     * @param skill Skill to obtain the snapshot for
     * @return An immutable snapshot of the specified skill for this session since first login or last reset
     */
    fun getSkillSnapshot(skill: Skill): XpSnapshotSingle {
        return getSkill(skill).snapshot()
    }

    /**
     * Obtain an immutable snapshot of the provided skill
     * intended for use with the UI which operates on another thread
     *
     * @return An immutable snapshot of total information for this session since first login or last reset
     */
    val totalSnapshot: XpSnapshotSingle
        get() = getSkill(Skill.OVERALL).snapshot()
    private val xpSkills: MutableMap<Skill, XpStateSingle> = EnumMap(
        Skill::class.java
    )
    private val DEFAULT_XP_MODIFIER = 4.0
    private val SHARED_XP_MODIFIER = DEFAULT_XP_MODIFIER / 3.0

    /**
     * Destroys all internal state, however any XpSnapshotSingle or XpSnapshotTotal remain unaffected.
     */
    fun reset() {
        xpSkills.clear()
    }
}