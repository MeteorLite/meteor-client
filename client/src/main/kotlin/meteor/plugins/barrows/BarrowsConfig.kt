/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.barrows

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import java.awt.Color

@ConfigGroup("barrows")
interface BarrowsConfig : Config {
    @ConfigItem(keyName = "showBrotherLoc", name = "Show Brothers location", description = "Configures whether or not the brothers location is displayed", position = 1)
    fun showBrotherLoc(): Boolean {
        return true
    }

    @ConfigItem(keyName = "showChestValue", name = "Show Value of Chests", description = "Configure whether to show total exchange value of chest when opened", position = 2)
    fun showChestValue(): Boolean {
        return true
    }

    @ConfigItem(keyName = "brotherLocColor", name = "Brother location color", description = "Change the color of the name displayed on the minimap", position = 3)
    fun brotherLocColor(): Color? {
        return Color.CYAN
    }

    @ConfigItem(keyName = "deadBrotherLocColor", name = "Dead Brother loc. color", description = "Change the color of the name displayed on the minimap for a dead brother", position = 4)
    fun deadBrotherLocColor(): Color? {
        return Color.RED
    }

    @ConfigItem(keyName = "showPuzzleAnswer", name = "Show Puzzle Answer", description = "Configures if the puzzle answer should be shown.", position = 5)
    fun showPuzzleAnswer(): Boolean {
        return true
    }

    @ConfigItem(keyName = "showPrayerDrainTimer", name = "Show Prayer Drain Timer", description = "Configure whether or not a countdown until the next prayer drain is displayed", position = 6)
    fun showPrayerDrainTimer(): Boolean {
        return true
    }
}