/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.plugins.tileindicators

import meteor.config.legacy.*
import java.awt.Color

@ConfigGroup("tileindicators")
interface TileIndicatorsConfig : Config {
    @ConfigItem(
        keyName = "highlightDestinationTile",
        name = "Highlight destination tile",
        description = "Highlights tile player is walking to",
        position = 1,
        section = "Destination Tile"
    )
    fun highlightDestinationTile(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "highlightDestinationColor",
        name = "Highlight color",
        description = "Configures the highlight color of current destination",
        position = 2,
        section = "Destination Tile"
    )
    fun highlightDestinationColor(): Color? {
        return Color.GRAY
    }

    @Alpha
    @ConfigItem(
        keyName = "destinationTileFillColor",
        name = "Fill color",
        description = "Configures the fill color of destination tile",
        position = 3,
        section = "Destination Tile"
    )
    fun destinationTileFillColor(): Color? {
        return Color(0, 0, 0, 50)
    }

    @ConfigItem(
        keyName = "destinationTileBorderWidth",
        name = "Border width",
        description = "Width of the destination tile marker border",
        position = 4,
        section = "Destination Tile"
    )
    fun destinationTileBorderWidth(): Double {
        return 2.0
    }

    @ConfigItem(
        keyName = "highlightHoveredTile",
        name = "Highlight hovered tile",
        description = "Highlights tile player is hovering with mouse",
        position = 1,
        section = "Hovered Tile"
    )
    fun highlightHoveredTile(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(
        keyName = "highlightHoveredColor",
        name = "Highlight color",
        description = "Configures the highlight color of hovered tile",
        position = 2,
        section = "Hovered Tile"
    )
    fun highlightHoveredColor(): Color? {
        return Color(0, 0, 0, 0)
    }

    @Alpha
    @ConfigItem(
        keyName = "hoveredTileFillColor",
        name = "Fill color",
        description = "Configures the fill color of hovered tile",
        position = 3,
        section = "Hovered Tile"
    )
    fun hoveredTileFillColor(): Color? {
        return Color(0, 0, 0, 50)
    }

    @ConfigItem(
        keyName = "hoveredTileBorderWidth",
        name = "Border width",
        description = "Width of the hovered tile marker border",
        position = 4,
        section = "Hovered Tile"
    )
    fun hoveredTileBorderWidth(): Double {
        return 2.0
    }

    @ConfigItem(
        keyName = "highlightCurrentTile",
        name = "Highlight true tile",
        description = "Highlights true tile player is on as seen by server",
        position = 1,
        section = "Current Tile"
    )
    fun highlightCurrentTile(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(
        keyName = "highlightCurrentColor",
        name = "Highlight color",
        description = "Configures the highlight color of current true tile",
        position = 2,
        section = "Current Tile"
    )
    fun highlightCurrentColor(): Color? {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(
        keyName = "currentTileFillColor",
        name = "Fill color",
        description = "Configures the fill color of current true tile",
        position = 3,
        section = "Current Tile"
    )
    fun currentTileFillColor(): Color? {
        return Color(0, 0, 0, 50)
    }

    @ConfigItem(
        keyName = "currentTileBorderWidth",
        name = "Border width",
        description = "Width of the true tile marker border",
        position = 4,
        section = "Current Tile"
    )
    fun currentTileBorderWidth(): Double {
        return 2.0
    }


    @ConfigSection(name = "Destination Tile", description = "Destination tile configuration", position = 0)
    val destinationTile: String

    @ConfigSection(name = "Hovered Tile", description = "Hovered tile configuration", position = 1)
    val hoveredTile: String

    @ConfigSection(name = "Current Tile", description = "Current tile configuration", position = 2)
    val currentTile: String

}