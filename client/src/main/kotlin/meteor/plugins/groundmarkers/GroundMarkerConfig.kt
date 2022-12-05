/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.plugins.groundmarkers

import meteor.config.legacy.Alpha
import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import java.awt.Color

@ConfigGroup( "groundMarker")
interface GroundMarkerConfig : Config {
    @Alpha
    @ConfigItem(keyName = "markerColor", name = "Tile color", description = "Configures the color of marked tile")
    fun markerColor(): Color? {
        return Color.YELLOW
    }

    @ConfigItem(
        keyName = "rememberTileColors",
        name = "Remember color per tile",
        description = "Color tiles using the color from time of placement"
    )
    fun rememberTileColors(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "drawOnMinimap",
        name = "Draw tiles on minimap",
        description = "Configures whether marked tiles should be drawn on minimap"
    )
    fun drawTileOnMinimmap(): Boolean {
        return false
    }

    @ConfigItem(
        keyName ="showImportExport",
        name = "Show Import/Export options",
        description = "Show the Import/Export options on the minimap right-click menu"
    )
    fun showImportExport(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showClear",
        name = "Show Clear option",
        description = "Show the Clear option on the minimap right-click menu, which deletes all currently loaded markers"
    )
    fun showClear(): Boolean {
        return false
    }

    @ConfigItem(keyName = "borderWidth", name = "Border Width", description = "Width of the marked tile border")
    fun borderWidth(): Double {
        return 2.toDouble()
    }

    @ConfigItem(keyName = "fillOpacity", name = "Fill Opacity", description = "Opacity of the tile fill color")
    fun fillOpacity(): Int {
        return 50
    }

}