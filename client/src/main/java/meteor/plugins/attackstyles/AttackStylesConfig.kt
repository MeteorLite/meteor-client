/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package meteor.plugins.attackstyles

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("attackIndicator")
interface AttackStylesConfig : Config {
    @ConfigItem(keyName = "alwaysShowStyle", name = "Always show style", description = "Show attack style indicator at all times", position = 1)
    fun alwaysShowStyle(): Boolean {
        return true
    }

    @ConfigItem(keyName = "warnForDefensive", name = "Warn for defence", description = "Show warning when a Defence skill combat option is selected", position = 2)
    fun warnForDefence(): Boolean {
        return false
    }

    @ConfigItem(keyName = "warnForAttack", name = "Warn for attack", description = "Show warning when an Attack skill combat option is selected", position = 3)
    fun warnForAttack(): Boolean {
        return false
    }

    @ConfigItem(keyName = "warnForStrength", name = "Warn for strength", description = "Show warning when a Strength skill combat option is selected", position = 4)
    fun warnForStrength(): Boolean {
        return false
    }

    @ConfigItem(keyName = "warnForRanged", name = "Warn for ranged", description = "Show warning when a Ranged skill combat option is selected", position = 5)
    fun warnForRanged(): Boolean {
        return false
    }

    @ConfigItem(keyName = "warnForMagic", name = "Warn for magic", description = "Show warning when a Magic skill combat option is selected", position = 6)
    fun warnForMagic(): Boolean {
        return false
    }

    @ConfigItem(keyName = "hideAutoRetaliate", name = "Hide auto retaliate", description = "Hide auto retaliate from the combat options tab", position = 7)
    fun hideAutoRetaliate(): Boolean {
        return false
    }

    @ConfigItem(keyName = "removeWarnedStyles", name = "Remove warned styles", description = "Remove warned styles from the combat options tab", position = 8)
    fun removeWarnedStyles(): Boolean {
        return false
    }
}