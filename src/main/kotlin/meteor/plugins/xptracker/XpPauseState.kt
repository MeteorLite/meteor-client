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

import net.runelite.api.Skill
import java.util.EnumMap

internal class XpPauseState {
    // Internal state
    private val skillPauses: MutableMap<Skill, XpPauseStateSingle> = EnumMap(
        Skill::class.java
    )
    private var cachedIsLoggedIn = false
    fun pauseSkill(skill: Skill): Boolean {
        return findPauseState(skill).manualPause()
    }

    fun unpauseSkill(skill: Skill): Boolean {
        return findPauseState(skill).unpause()
    }

    fun isPaused(skill: Skill): Boolean {
        return findPauseState(skill).isPaused
    }

    fun tickXp(skill: Skill, currentXp: Long, pauseAfterMinutes: Int) {
        val state = findPauseState(skill)
        if (state.xp != currentXp) {
            state.xpChanged(currentXp)
        } else if (pauseAfterMinutes > 0) {
            val now = System.currentTimeMillis()
            val pauseAfterMillis = pauseAfterMinutes * 60 * 1000
            val lastChangeMillis = state.lastChangeMillis
            // When config.pauseSkillAfter is 0, it is effectively disabled
            if (lastChangeMillis != 0L && now - lastChangeMillis >= pauseAfterMillis) {
                state.timeout()
            }
        }
    }

    fun tickLogout(pauseOnLogout: Boolean, loggedIn: Boolean) {
        // Deduplicated login and logout calls
        if (!cachedIsLoggedIn && loggedIn) {
            cachedIsLoggedIn = true
            for (skill in Skill.values()) {
                findPauseState(skill).login()
            }
        } else if (cachedIsLoggedIn && !loggedIn) {
            cachedIsLoggedIn = false

            // If configured, then let the pause state know to pause with reason: logout
            if (pauseOnLogout) {
                for (skill in Skill.values()) {
                    findPauseState(skill).logout()
                }
            }
        }
    }

    private fun findPauseState(skill: Skill): XpPauseStateSingle {
        return skillPauses.computeIfAbsent(skill) { skill: Skill? -> XpPauseStateSingle(skill!!) }
    }
}