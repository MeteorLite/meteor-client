/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package meteor.plugins.indicators

import meteor.config.legacy.*
import java.awt.Color

@ConfigGroup("indicators")
interface IndicatorsConfig : Config {
    @ConfigItem(
        keyName = "drawNpcName",
        name = "Draw NPC names",
        description = "render npc name above bounding box",
            position = 0
    )
    fun drawNpcName(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "drawNpcBounds",
            name = "Draw NPC bounds",
            description = "render npc bounding box",
            position = 1
    )
    fun drawNpcBounds(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "npcColor",
            name = "NPC Color",
            description = "render color for NPC configs",
            position = 2
    )
    fun npcColor(): Color {
        return Color.yellow
    }

    @ConfigItem(
            keyName = "drawPlayerName",
            name = "Draw Player names",
            description = "render NPC name above bounding box",
            position = 3
    )
    fun drawPlayerName(): Boolean {
        return true
    }

    @ConfigItem(
            keyName = "drawPlayerBounds",
            name = "Draw Player bounds",
            description = "render Player bounding box",
            position = 4
    )
    fun drawPlayerBounds(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "playerColor",
            name = "Player Color",
            description = "render color for Player configs",
            position = 5
    )
    fun playerColor(): Color {
        return Color.red
    }

    @ConfigItem(
            keyName = "drawTileItemName",
            name = "Draw TileItem names",
            description = "render TileItem name above bounding box",
            position = 6
    )
    fun drawTileItemName(): Boolean {
        return true
    }

    @ConfigItem(
            keyName = "drawNpcBounds",
            name = "Draw TileItem bounds",
            description = "render TileItem bounding box",
            position = 7
    )
    fun drawTileItemBounds(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "tileItemColor",
            name = "TileItem Color",
            description = "render color for TileItem configs",
            position = 8
    )
    fun tileItemColor(): Color {
        return Color.white
    }

    @ConfigItem(
            keyName = "drawLocalPlayerName",
            name = "Draw local Player name",
            description = "render local Player name above bounding box",
            position = 9
    )
    fun drawLocalPlayerName(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "drawLocalPlayerBounds",
            name = "Draw local Player bounds",
            description = "render local Player bounding box",
            position = 10
    )
    fun drawLocalPlayerBounds(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "drawLocalPlayerTile",
            name = "Draw local Player Tile",
            description = "render local Player bounding box",
            position = 11
    )
    fun drawLocalPlayerTile(): Boolean {
        return false
    }

    @ConfigItem(
            keyName = "localPlayerColor",
            name = "Local Player Color",
            description = "render color for local Player configs",
            position = 12

    )
    fun localPlayerColor(): Color {
        return Color.blue
    }
}