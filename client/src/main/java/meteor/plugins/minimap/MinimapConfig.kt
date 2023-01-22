/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package meteor.plugins.minimap

import meteor.config.legacy.Alpha
import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import java.awt.Color

@ConfigGroup(MinimapConfig.GROUP)
interface MinimapConfig : Config {
    @ConfigItem(
        keyName = "hideMinimap",
        name = "Hide minimap",
        description = "Do not show the minimap on screen (Resizable only)",
        position = 1

    )
    fun hideMinimap(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(
        keyName = "itemColor",
        name = "Item color",
        description = "Set the minimap color items are drawn in",
        position = 2
    )
    fun itemColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "npcColor",
        name = "NPC color",
        description = "Set the minimap color NPCs are drawn in",
        position = 3
    )
    fun npcColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "playerColor",
        name = "Player color",
        description = "Set the minimap Color players are drawn in",
        position = 4
    )
    fun playerColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "friendColor",
        name = "Friends color",
        description = "Set the minimap color your friends are drawn in",
        position = 5,
    )
    fun friendColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "team",
        name = "Team color",
        description = "Set the minimap color your team is drawn in",

        )
    fun teamColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "clan",
        name = "Friends Chat color",
        description = "Set the minimap color your friends chat members are drawn in",

        )
    fun friendsChatColor(): Color {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "clanchat",
        name = "Clan Chat color",
        description = "Set the minimap color your clan chat members are drawn in",

        )
    fun clanChatColor(): Color {
        return Color.CYAN
    }

    companion object {
        const val GROUP = "minimap"


    }
}