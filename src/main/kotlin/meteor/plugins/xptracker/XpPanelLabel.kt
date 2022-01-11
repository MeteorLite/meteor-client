/*
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

import meteor.util.QuantityFormatter.quantityToRSDecimalStack
import java.util.function.Function

enum class XpPanelLabel(var key: String, var valueFunc: Function<XpSnapshotSingle, String>?) {
    TIME_TO_LEVEL("TTL", Function { obj: XpSnapshotSingle -> obj.timeTillGoalShort!! }), XP_GAINED(
        "XP Gained",
        Function { snap: XpSnapshotSingle -> format(snap.xpGainedInSession) }),
    XP_HOUR("XP/hr", Function { snap: XpSnapshotSingle -> format(snap.xpPerHour) }), XP_LEFT(
        "XP Left",
        Function { snap: XpSnapshotSingle -> format(snap.xpRemainingToGoal) }),
    ACTIONS_LEFT(
        "Actions",
        Function { snap: XpSnapshotSingle -> format(snap.actionsRemainingToGoal) }),
    ACTIONS_HOUR(
        "Actions/hr",
        Function { snap: XpSnapshotSingle -> format(snap.actionsPerHour) }),
    ACTIONS_DONE("Actions Done", Function { snap: XpSnapshotSingle -> format(snap.actionsInSession) });

    /**
     * Get the action key label based on if the Action type is an xp drop or kill
     *
     * @param snapshot
     * @return
     */
    fun getActionKey(snapshot: XpSnapshotSingle): String {
        val actionKey = key
        return if (snapshot.actionType == XpActionType.ACTOR_HEALTH) {
            actionKey!!.replace("Action", "Kill")
        } else actionKey
    }

    companion object {
        private fun format(`val`: Int): String {
            return quantityToRSDecimalStack(`val`, true)
        }
    }
}