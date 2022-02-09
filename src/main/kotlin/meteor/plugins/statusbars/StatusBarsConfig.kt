/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
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
package meteor.plugins.statusbars

import meteor.config.Config
import meteor.config.ConfigAnnotations.*
import meteor.plugins.statusbars.config.BarMode

@ConfigGroup(StatusBarsConfig.GROUP)
interface StatusBarsConfig : Config {
    @ConfigItem(
        keyName = "enableCounter",
        name = "Show counters",
        description = "Shows current value of the status on the bar"
    )
    fun enableCounter(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "enableSkillIcon",
        name = "Show icons",
        description = "Adds skill icons at the top of the bars."
    )
    fun enableSkillIcon(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "enableRestorationBars",
        name = "Show restores",
        description = "Visually shows how much will be restored to your status bar."
    )
    fun enableRestorationBars(): Boolean {
        return true
    }

    @ConfigItem(keyName = "leftBarMode", name = "Left Bar", description = "Configures the left status bar")
    fun leftBarMode(): BarMode? {
        return BarMode.HITPOINTS
    }

    @ConfigItem(keyName = "rightBarMode", name = "Right Bar", description = "Configures the right status bar")
    fun rightBarMode(): BarMode? {
        return BarMode.PRAYER
    }

    @Range(min = 0, max = 12)
    @ConfigItem(
        keyName = "hideAfterCombatDelay",
        name = "Hide after combat delay",
        description = "Amount of ticks before hiding status bars after no longer in combat. 0 = always show status bars."
    )
    @Units(Units.TICKS)
    fun hideAfterCombatDelay(): Int {
        return 0
    }

    companion object {
        const val GROUP = "statusbars"
    }
}