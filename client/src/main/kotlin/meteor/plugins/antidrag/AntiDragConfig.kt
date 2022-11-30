/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
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
package meteor.plugins.antidrag

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import net.runelite.api.Constants

@ConfigGroup(AntiDragPlugin.Companion.CONFIG_GROUP)
interface AntiDragConfig : Config {
    @ConfigItem(
        keyName = "dragDelay",
        name = "Drag Delay",
        description = "Configures the inventory drag delay in client ticks (20ms)",
        position = 1
    )
    fun dragDelay(): Int {
        return Constants.GAME_TICK_LENGTH / Constants.CLIENT_TICK_LENGTH // one game tick
    }

    @ConfigItem(
        keyName = "onShiftOnly",
        name = "On Shift Only",
        description = "Configures whether to only adjust the delay while holding shift.",
        position = 2
    )
    fun onShiftOnly(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "disableOnCtrl",
        name = "Disable On Control Pressed",
        description = "Configures whether to ignore the delay while holding control.",
        position = 3
    )
    fun disableOnCtrl(): Boolean {
        return false
    }
}