/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018, Levi <me@levischuck.com>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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

import meteor.Logger.Companion.getLogger
import net.runelite.api.Experience
import net.runelite.api.Skill
import java.util.*

class XpStateSingle(private val skill: Skill, var startXp: Long) {
    private val actions: MutableMap<XpActionType, XpAction> = EnumMap(
        XpActionType::class.java
    )

    var xpGainedSinceReset = 0
    set(value)  {
        field = value
        lastChangeMillis = System.currentTimeMillis()
    }
    var xpGainedBeforeReset = 0

    var actionType = XpActionType.EXPERIENCE

    var skillTime: Long = 0

    var lastChangeMillis: Long = 0
    var startLevelExp = 0
    var endLevelExp = 0
    private val log = getLogger(XpStateSingle::class.java)
    fun getXpAction(type: XpActionType): XpAction {
        return actions.computeIfAbsent(type) { k: XpActionType? -> XpAction() }
    }

    val currentXp: Long
        get() = startXp + totalXpGained

    val totalXpGained: Int
        get() = xpGainedBeforeReset + xpGainedSinceReset
    private val actionsHr: Int
        private get() = toHourly(getXpAction(actionType).actionsSinceReset)

    private fun toHourly(value: Int): Int {
        return (1.0 / (timeElapsedInSeconds / 3600.0) * value).toInt()
    }

    // If the skill started just now, we can divide by near zero, this results in odd behavior.
    // To prevent that, pretend the skill has been active for a minute (60 seconds)
    // This will create a lower estimate for the first minute,
    // but it isn't ridiculous like saying 2 billion XP per hour.
    private val timeElapsedInSeconds: Long
        private get() =// If the skill started just now, we can divide by near zero, this results in odd behavior.
        // To prevent that, pretend the skill has been active for a minute (60 seconds)
        // This will create a lower estimate for the first minute,
            // but it isn't ridiculous like saying 2 billion XP per hour.
            Math.max(60, skillTime / 1000)
    private val xpRemaining: Int
        private get() = endLevelExp - currentXp.toInt()// Make sure to account for the very last action at the end

    // Let's not divide by zero (or negative)
    private val actionsRemaining: Int
        private get() {
            val action = getXpAction(actionType)
            if (action.actionsHistoryInitialized) {
                val xpRemaining: Long = xpRemaining * action.actionExps.size.toLong()
                var totalActionXp: Long = 0
                for (actionXp in action.actionExps) {
                    totalActionXp += actionXp.toLong()
                }

                // Let's not divide by zero (or negative)
                if (totalActionXp > 0) {
                    // Make sure to account for the very last action at the end
                    val remainder = xpRemaining % totalActionXp
                    val quotient = xpRemaining / totalActionXp
                    return Math.toIntExact(quotient + if (remainder > 0) 1 else 0)
                }
            }
            return Int.MAX_VALUE
        }
    private val skillProgress: Double
        private get() {
            val xpGained = (currentXp - startLevelExp).toDouble()
            val xpGoal = (endLevelExp - startLevelExp).toDouble()
            return xpGained / xpGoal * 100
        }

    // formula is xpRemaining / xpPerSecond
    // xpPerSecond being xpGained / seconds
    // This can be simplified so division is only done once and we can work in whole numbers!
    private val secondsTillLevel: Long
        private get() {
            val seconds = timeElapsedInSeconds
            return if (seconds <= 0 || xpGainedSinceReset <= 0) {
                -1
            } else xpRemaining * seconds / xpGainedSinceReset

            // formula is xpRemaining / xpPerSecond
            // xpPerSecond being xpGained / seconds
            // This can be simplified so division is only done once and we can work in whole numbers!
        }

    private fun getTimeTillLevel(goalTimeType: XpGoalTimeType): String {
        val remainingSeconds = secondsTillLevel
        if (remainingSeconds < 0) {
            return "\u221e"
        }

        // Java 8 doesn't have good duration / period objects to represent spans of time that can be formatted
        // Rather than importing another dependency like joda time (which is practically built into java 10)
        // below will be a custom formatter that handles spans larger than 1 day
        val durationDays = remainingSeconds / (24 * 60 * 60)
        val durationHours = remainingSeconds % (24 * 60 * 60) / (60 * 60)
        val durationHoursTotal = remainingSeconds / (60 * 60)
        val durationMinutes = remainingSeconds % (60 * 60) / 60
        val durationSeconds = remainingSeconds % 60
        return when (goalTimeType) {
            XpGoalTimeType.DAYS -> {
                if (durationDays > 1) {
                    return String.format(
                        "%d days %02d:%02d:%02d",
                        durationDays,
                        durationHours,
                        durationMinutes,
                        durationSeconds
                    )
                } else if (durationDays == 1L) {
                    return String.format("1 day %02d:%02d:%02d", durationHours, durationMinutes, durationSeconds)
                }
                if (durationHoursTotal > 1) {
                    return String.format("%d hours %02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else if (durationHoursTotal == 1L) {
                    return String.format("1 hour %02d:%02d", durationMinutes, durationSeconds)
                }
                // durationDays = 0 or durationHoursTotal = 0 or goalTimeType = SHORT if we got here.
                // return time remaining in hh:mm:ss or mm:ss format where hh can be > 24
                if (durationHoursTotal > 0) {
                    String.format("%02d:%02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else String.format("%02d:%02d", durationMinutes, durationSeconds)

                // Minutes and seconds will always be present
            }
            XpGoalTimeType.HOURS -> {
                if (durationHoursTotal > 1) {
                    return String.format("%d hours %02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else if (durationHoursTotal == 1L) {
                    return String.format("1 hour %02d:%02d", durationMinutes, durationSeconds)
                }
                if (durationHoursTotal > 0) {
                    String.format("%02d:%02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else String.format("%02d:%02d", durationMinutes, durationSeconds)
            }
            XpGoalTimeType.SHORT -> {
                if (durationHoursTotal > 0) {
                    String.format("%02d:%02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else String.format("%02d:%02d", durationMinutes, durationSeconds)
            }
            else -> {
                if (durationHoursTotal > 0) {
                    String.format("%02d:%02d:%02d", durationHoursTotal, durationMinutes, durationSeconds)
                } else String.format("%02d:%02d", durationMinutes, durationSeconds)
            }
        }
    }

    val xpHr: Int
        get() = toHourly(xpGainedSinceReset)

    fun resetPerHour() {
        //reset actions per hour
        for (action in actions.values) {
            action.actions = action.actions + action.actionsSinceReset
            action.actionsSinceReset = (0)
        }

        //reset xp per hour
        xpGainedBeforeReset += xpGainedSinceReset
        xpGainedSinceReset = (0)
        skillTime = (0)
    }

    fun update(currentXp: Long, goalStartXp: Int, goalEndXp: Int): Boolean {
        if (startXp == -1L) {
            log.warn("Attempted to update skill state {} but was not initialized with current xp", skill)
            return false
        }
        val originalXp = totalXpGained + startXp
        val actionExp = (currentXp - originalXp).toInt()

        // No experience gained
        if (actionExp == 0) {
            return false
        }

        // Update EXPERIENCE action
        val action = getXpAction(XpActionType.EXPERIENCE)
        if (action.actionsHistoryInitialized) {
            action.actionExps[action.actionExpIndex] = actionExp
        } else {
            // populate all values in our action history array with this first value that we see
            // so the average value of our action history starts out as this first value we see
            Arrays.fill(action.actionExps, actionExp)
            action.actionsHistoryInitialized = (true)
        }
        action.actionExpIndex = ((action.actionExpIndex + 1) % action.actionExps.size)
        action.actionsSinceReset = (action.actionsSinceReset + 1)

        // Calculate experience gained
        xpGainedSinceReset = ((currentXp - (startXp + xpGainedBeforeReset)).toInt())

        // Determine XP goals, overall has no goals
        if (skill != Skill.OVERALL) {
            startLevelExp = if (goalStartXp < 0 || currentXp > goalEndXp) {
                Experience.getXpForLevel(Experience.getLevelForXp(currentXp.toInt()))
            } else {
                goalStartXp
            }
            endLevelExp = if (goalEndXp <= 0 || currentXp > goalEndXp) {
                val currentLevel = Experience.getLevelForXp(currentXp.toInt())
                if (currentLevel + 1 <= Experience.MAX_VIRT_LEVEL) Experience.getXpForLevel(currentLevel + 1) else Experience.MAX_SKILL_XP
            } else {
                goalEndXp
            }
        }
        return true
    }

    fun tick(delta: Long) {
        // Don't tick skills that have not gained XP or have been reset.
        if (xpGainedSinceReset <= 0) {
            return
        }
        skillTime += delta
    }

    fun snapshot(): XpSnapshotSingle {
        return XpSnapshotSingle.Builder()
            .startLevel(Experience.getLevelForXp(startLevelExp))
            .endLevel(Experience.getLevelForXp(endLevelExp))
            .xpGainedInSession(totalXpGained)
            .xpRemainingToGoal(xpRemaining)
            .xpPerHour(xpHr)
            .skillProgressToGoal(skillProgress)
            .actionType(actionType)
            .actionsInSession(getXpAction(actionType).actions + getXpAction(actionType).actionsSinceReset)
            .actionsRemainingToGoal(actionsRemaining)
            .actionsPerHour(actionsHr)
            .timeTillGoal(getTimeTillLevel(XpGoalTimeType.DAYS))
            .timeTillGoalHours(getTimeTillLevel(XpGoalTimeType.HOURS))
            .timeTillGoalShort(getTimeTillLevel(XpGoalTimeType.SHORT))
            .startGoalXp(startLevelExp)
            .endGoalXp(endLevelExp)
            .build()
    }
}