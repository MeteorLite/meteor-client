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

import meteor.ui.components.LayoutableRenderableEntity
import meteor.ui.components.SplitComponent
import meteor.ui.overlay.ComponentOrientation
import java.awt.Point

class XpSnapshotSingle {
    var actionType: XpActionType? = null
    var startLevel = 0
    var endLevel = 0
    var startGoalXp = 0
    var endGoalXp = 0
    var xpGainedInSession = 0
    var xpRemainingToGoal = 0
    var xpPerHour = 0
    var skillProgressToGoal = 0.0
    var actionsInSession = 0
    var actionsRemainingToGoal = 0
    var actionsPerHour = 0
    var timeTillGoal: String? = null
    var timeTillGoalHours: String? = null
    var timeTillGoalShort: String? = null

    class Builder {
        val snapshot = XpSnapshotSingle()
        fun actionType(x: XpActionType) : Builder {
            snapshot.actionType = x
            return this
        }
        fun startLevel(i: Int) : Builder {
            snapshot.startLevel = i
            return this
        }
        fun endLevel(i: Int) : Builder {
            snapshot.endLevel = i
            return this
        }
        fun startGoalXp(i: Int) : Builder {
            snapshot.startGoalXp = i
            return this
        }
        fun endGoalXp(i: Int) : Builder {
            snapshot.endGoalXp = i
            return this
        }

        fun xpGainedInSession(i: Int) : Builder {
            snapshot.xpGainedInSession = i
            return this
        }

        fun xpRemainingToGoal(i: Int) : Builder {
            snapshot.xpRemainingToGoal = i
            return this
        }

        fun xpPerHour(i: Int) : Builder {
            snapshot.xpPerHour = i
            return this
        }

        fun skillProgressToGoal(d: Double) : Builder {
            snapshot.skillProgressToGoal = d
            return this
        }

        fun actionsInSession(i: Int) : Builder {
            snapshot.actionsInSession = i
            return this
        }

        fun actionsRemainingToGoal(i: Int) : Builder {
            snapshot.actionsRemainingToGoal = i
            return this
        }

        fun actionsPerHour(i: Int) : Builder {
            snapshot.actionsPerHour = i
            return this
        }

        fun timeTillGoal(s: String) : Builder {
            snapshot.timeTillGoal = s
            return this
        }

        fun timeTillGoalHours(s: String) : Builder {
            snapshot.timeTillGoalHours = s
            return this
        }

        fun timeTillGoalShort(s: String) : Builder {
            snapshot.timeTillGoalShort = s
            return this
        }

        fun build(): XpSnapshotSingle {
            return snapshot
        }
    }
}