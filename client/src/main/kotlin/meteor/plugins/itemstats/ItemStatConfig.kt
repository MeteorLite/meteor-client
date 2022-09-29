/*
 * Copyright (c) 2018 Abex
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
package meteor.plugins.itemstats

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import java.awt.Color

@ConfigGroup("itemstat")
interface ItemStatConfig : Config {
    @ConfigItem(
        keyName = "consumableStats",
        name = "Enable consumable stats",
        description = "Enables tooltips for consumable items (food, boosts)"
    )
    fun consumableStats(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "equipmentStats",
        name = "Enable equipment stats",
        description = "Enables tooltips for equipment items (combat bonuses, weight, prayer bonuses)"
    )
    fun equipmentStats(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "geStats",
        name = "Enable GE item information",
        description = "Shows an item information panel when buying items in the GE"
    )
    fun geStats(): Boolean {
        return true
    }

    @ConfigItem(keyName = "relative", name = "Show Relative", description = "Show relative stat change in tooltip")
    fun relative(): Boolean {
        return true
    }

    @ConfigItem(keyName = "absolute", name = "Show Absolute", description = "Show absolute stat change in tooltip")
    fun absolute(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "theoretical",
        name = "Show Theoretical",
        description = "Show theoretical stat change in tooltip"
    )
    fun theoretical(): Boolean {
        return false
    }

    @ConfigItem(keyName = "showWeight", name = "Show Weight", description = "Show weight in tooltip")
    fun showWeight(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "showStatsInBank",
        name = "Show Stats In Bank",
        description = "Show item stats on bank items tooltip"
    )
    fun showStatsInBank(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "alwaysShowBaseStats",
        name = "Always Show Base Stats",
        description = "Always include the base items stats in the tooltip"
    )
    fun alwaysShowBaseStats(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "colorBetterUncapped",
        name = "Better (Uncapped)",
        description = "Color to show when the stat change is fully consumed",
        position = 10
    )
    fun colorBetterUncapped(): Color {
        return Color(0x33EE33)
    }

    @ConfigItem(
        keyName = "colorBetterSomecapped",
        name = "Better (Some capped)",
        description = "Color to show when some stat changes are capped, but some are not",
        position = 11
    )
    fun colorBetterSomeCapped(): Color {
        return Color(0x9CEE33)
    }

    @ConfigItem(
        keyName = "colorBetterCapped",
        name = "Better (Capped)",
        description = "Color to show when the stat change is positive, but not fully consumed",
        position = 12
    )
    fun colorBetterCapped(): Color {
        return Color(0xEEEE33)
    }

    @ConfigItem(
        keyName = "colorNoChange",
        name = "No change",
        description = "Color to show when there is no change",
        position = 13
    )
    fun colorNoChange(): Color {
        return Color(0xEEEEEE)
    }

    @ConfigItem(
        keyName = "colorWorse",
        name = "Worse",
        description = "Color to show when the stat goes down",
        position = 14
    )
    fun colorWorse(): Color {
        return Color(0xEE3333)
    }
}