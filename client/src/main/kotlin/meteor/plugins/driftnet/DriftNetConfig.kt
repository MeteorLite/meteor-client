/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.driftnet

import meteor.config.legacy.*
import java.awt.Color

@ConfigGroup(DriftNetPlugin.CONFIG_GROUP)
interface DriftNetConfig : Config {
    @ConfigItem(position = 1, keyName = "showNetStatus", name = "Show net status", description = "Show net status and fish count")
    fun showNetStatus(): Boolean {
        return true
    }

    @ConfigItem(position = 2, keyName = "countColor", name = "Fish count color", description = "Color of the fish count text")
    fun countColor(): Color? {
        return Color.WHITE
    }

    @ConfigItem(position = 3, keyName = "highlightUntaggedFish", name = "Highlight untagged fish", description = "Highlight the untagged fish")
    fun highlightUntaggedFish(): Boolean {
        return true
    }

    @ConfigItem(position = 4, keyName = "timeoutDelay", name = "Tagged timeout", description = "Time required for a tag to expire")
    @Range(min = 1, max = 100)
    @Units(Units.TICKS)
    fun timeoutDelay(): Int {
        return 60
    }

    @Alpha
    @ConfigItem(keyName = "untaggedFishColor", name = "Untagged fish color", description = "Color of untagged fish", position = 5)
    fun untaggedFishColor(): Color? {
        return Color.CYAN
    }

    @ConfigItem(keyName = "tagAnnette", name = "Tag Annette", description = "Tag Annette when no nets in inventory", position = 6)
    fun tagAnnetteWhenNoNets(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(keyName = "annetteTagColor", name = "Annette tag color", description = "Color of Annette tag", position = 7)
    fun annetteTagColor(): Color? {
        return Color.RED
    }
}