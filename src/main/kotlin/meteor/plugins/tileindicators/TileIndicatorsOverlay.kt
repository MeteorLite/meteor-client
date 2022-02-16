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

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Client
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.*


class TileIndicatorsOverlay(plugin: TileIndicatorsPlugin): Overlay() {
     var config = plugin.configuration<TileIndicatorsConfig>()
    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        priority = OverlayPriority.MED
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (config.highlightHoveredTile()) {
            // If we have tile "selected" render it
            if (client.selectedSceneTile != null) {
                renderTile(
                    graphics,
                    client.selectedSceneTile!!.localLocation,
                    config.highlightHoveredColor(),
                    config.hoveredTileBorderWidth()
                )
            }
        }
        if (config.highlightDestinationTile()) {
            renderTile(
                graphics,
                client.localDestinationLocation,
                config.highlightDestinationColor(),
                config.destinationTileBorderWidth()
            )
        }
        if (config.highlightCurrentTile()) {
            val playerPos = client.localPlayer!!.worldLocation ?: return null
            val playerPosLocal: LocalPoint = LocalPoint.fromWorld(client, playerPos) ?: return null
            renderTile(graphics, playerPosLocal, config.highlightCurrentColor(), config.currentTileBorderWidth())
        }
        return null
    }

    private fun renderTile(graphics: Graphics2D, dest: LocalPoint?, color: Color?, borderWidth: Int) {
        if (dest == null) {
            return
        }
        val poly: Polygon = Perspective.getCanvasTilePoly(client, dest) ?: return
        OverlayUtil.renderPolygon(graphics, poly, color!!, BasicStroke(borderWidth.toFloat()))
    }
}