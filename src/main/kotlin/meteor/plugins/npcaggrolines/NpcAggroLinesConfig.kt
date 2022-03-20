/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package meteor.plugins.npcaggrolines

import meteor.config.Config
import meteor.config.ConfigAnnotations.*
import java.awt.Color

@ConfigGroup("npcUnaggroArea")
interface NpcAggroLinesConfig : Config {
    @ConfigItem(
        keyName = "npcUnaggroShowTimer",
        name = "Show timer",
        description = "Display a timer until NPCs become unaggressive",
        position = 1
    )
    fun showTimer(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "npcUnaggroShowAreaLines",
        name = "Show area lines",
        description = "Display lines, when walked past, the unaggressive timer resets",
        position = 2
    )
    fun showAreaLines(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "npcAggroAreaColor",
        name = "Aggressive colour",
        description = "Choose colour to use for marking NPC unaggressive area when NPCs are aggressive",
        position = 3
    )
    fun aggroAreaColor(): Color? {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "npcUnaggroAreaColor",
        name = "Unaggressive colour",
        description = "Choose colour to use for marking NPC unaggressive area after NPCs have lost aggression",
        position = 4
    )
    fun unaggroAreaColor(): Color? {
        return Color.RED
    }

    @ConfigItem(
        keyName = "notifyExpire",
        name = "Notify Expiration",
        description = "Send a notifcation when the unaggressive timer expires",
        position = 5
    )
    fun notifyExpire(): Boolean {
        return false
    }

    companion object {
        const val CONFIG_GROUP = "npcUnaggroArea"
        const val CONFIG_CENTER1 = "center1"
        const val CONFIG_CENTER2 = "center2"
        const val CONFIG_LOCATION = "location"
        const val CONFIG_DURATION = "duration"
    }
}