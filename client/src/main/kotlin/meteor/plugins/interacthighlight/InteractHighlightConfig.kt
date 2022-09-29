/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package meteor.plugins.interacthighlight

import meteor.config.legacy.*
import java.awt.Color

@ConfigGroup("interacthighlight")
interface InteractHighlightConfig : Config {
    @ConfigItem(
        keyName = "npcShowHover",
        name = "Show on hover",
        description = "Outline NPCs when hovered",
        position = 1,
        section = "Settings for NPC highlight"
    )
    fun npcShowHover(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "npcShowInteract",
        name = "Show on interact",
        description = "Outline NPCs when interacted",
        position = 2,
        section = "Settings for NPC highlight"
    )
    fun npcShowInteract(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "npcHoverHighlightColor",
        name = "NPC hover",
        description = "The color of the hover outline for NPCs",
        position = 3,
        section = "Settings for NPC highlight"
    )
    fun npcHoverHighlightColor(): Color? {
        return Color(-0x6f000100, true)
    }

    @Alpha
    @ConfigItem(
        keyName = "npcAttackHoverHighlightColor",
        name = "NPC attack hover",
        description = "The color of the attack hover outline for NPCs",
        position = 4,
        section = "Settings for NPC highlight"
    )
    fun npcAttackHoverHighlightColor(): Color? {
        return Color(-0x6f000100, true)
    }

    @Alpha
    @ConfigItem(
        keyName = "npcInteractHighlightColor",
        name = "NPC interact",
        description = "The color of the target outline for NPCs",
        position = 5,
        section = "Settings for NPC highlight"
    )
    fun npcInteractHighlightColor(): Color? {
        return Color(-0x6f010000, true)
    }

    @Alpha
    @ConfigItem(
        keyName = "npcAttackHighlightColor",
        name = "NPC attack",
        description = "The color of the outline on attacked NPCs",
        position = 6,
        section = "Settings for NPC highlight"
    )
    fun npcAttackHighlightColor(): Color? {
        return Color(-0x6f010000, true)
    }

    @ConfigItem(
        keyName = "objectShowHover",
        name = "Show on hover",
        description = "Outline objects when hovered",
        position = 1,
        section = "Settings for object highlight"
    )
    fun objectShowHover(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "objectShowInteract",
        name = "Show on interact",
        description = "Outline objects when interacted",
        position = 2,
        section = "Settings for object highlight"
    )
    fun objectShowInteract(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "objectHoverHighlightColor",
        name = "Object hover",
        description = "The color of the hover outline for objects",
        position = 4,
        section = "Settings for object highlight"
    )
    fun objectHoverHighlightColor(): Color? {
        return Color(-0x6fff0001, true)
    }

    @Alpha
    @ConfigItem(
        keyName = "objectInteractHighlightColor",
        name = "Object interact",
        description = "The color of the target outline for objects",
        position = 6,
        section = "Settings for object highlight"
    )
    fun objectInteractHighlightColor(): Color? {
        return Color(-0x6f010000, true)
    }

    @ConfigItem(
        keyName = "borderWidth",
        name = "Border Width",
        description = "Width of the outlined border",
        position = 7
    )
    fun borderWidth(): Int {
        return 4
    }

    @ConfigItem(
        keyName = "outlineFeather",
        name = "Outline feather",
        description = "Specify between 0-4 how much of the model outline should be faded",
        position = 8
    )
    @Range(max = 4)
    fun outlineFeather(): Int {
        return 4
    }


    @ConfigSection(name = "NPCs", description = "Settings for NPC highlight", position = 0)
    val SettingsforNPChighlight: String

    @ConfigSection(name = "Objects", description = "Settings for object highlight", position = 1)
    val Settingsforobjecthighlight: String

}