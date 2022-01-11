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
import java.util.EnumSet

internal class XpPauseStateSingle(val skill: Skill) {

    private val pauseReasons: MutableSet<XpPauseReason> = EnumSet.noneOf(
        XpPauseReason::class.java
    )

    var lastChangeMillis: Long = 0

    var xp: Long = 0
    val isPaused: Boolean
        get() = !pauseReasons.isEmpty()

    fun login(): Boolean {
        return pauseReasons.remove(XpPauseReason.PAUSED_LOGOUT)
    }

    fun logout(): Boolean {
        return pauseReasons.add(XpPauseReason.PAUSED_LOGOUT)
    }

    fun timeout(): Boolean {
        return pauseReasons.add(XpPauseReason.PAUSED_TIMEOUT)
    }

    fun manualPause(): Boolean {
        return pauseReasons.add(XpPauseReason.PAUSE_MANUAL)
    }

    fun xpChanged(xp: Long): Boolean {
        this.xp = xp
        lastChangeMillis = System.currentTimeMillis()
        return clearAll()
    }

    fun unpause(): Boolean {
        lastChangeMillis = System.currentTimeMillis()
        return clearAll()
    }

    private fun clearAll(): Boolean {
        if (pauseReasons.isEmpty()) {
            return false
        }
        pauseReasons.clear()
        return true
    }

    private enum class XpPauseReason {
        PAUSE_MANUAL, PAUSED_LOGOUT, PAUSED_TIMEOUT
    }
}