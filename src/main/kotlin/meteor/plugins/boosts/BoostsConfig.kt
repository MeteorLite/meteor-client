/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.boosts

import net.runelite.client.config.*

@ConfigGroup("boosts")
interface BoostsConfig : Config {
    @ConfigItem(
        keyName = "displayBoosts",
        name = "Display Boosts",
        description = "Configures which skill boosts to display",
        position = 1
    )
    fun displayBoosts(): DisplayBoosts? {
        return DisplayBoosts.BOTH
    }

    @ConfigItem(
        keyName = "relativeBoost",
        name = "Use Relative Boosts",
        description = "Configures whether or not relative boost is used",
        position = 2
    )
    fun useRelativeBoost(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "displayIndicators",
        name = "Display as infoboxes",
        description = "Configures whether or not to display the boost as infoboxes",
        position = 3
    )
    fun displayInfoboxes(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "displayNextBuffChange",
        name = "Next buff change",
        description = "Configures whether or not to display when the next buffed stat change will be",
        position = 4
    )
    fun displayNextBuffChange(): DisplayChangeMode {
        return DisplayChangeMode.BOOSTED
    }

    @ConfigItem(
        keyName = "displayNextDebuffChange",
        name = "Next debuff change",
        description = "Configures whether or not to display when the next debuffed stat change will be",
        position = 5
    )
    fun displayNextDebuffChange(): DisplayChangeMode {
        return DisplayChangeMode.NEVER
    }

    @Range(min = 1, max = 25)
    @ConfigItem(
        keyName = "boostThreshold",
        name = "Boost threshold",
        description = "The threshold at which boosted levels will be displayed in a different color. A value of 0 will disable the feature.",
        position = 6
    )
    fun boostThreshold(): Int {
        return 0
    }

    enum class DisplayChangeMode(val type: String) {
        ALWAYS("Always"), BOOSTED("Boosted"), NEVER("Never");

        override fun toString(): String {
            return type
        }
    }

    enum class DisplayBoosts(val type: String) {
        NONE("None"), COMBAT("Combat"), NON_COMBAT("Non Combat"), BOTH("Both");

        override fun toString(): String {
            return type
        }
    }
}