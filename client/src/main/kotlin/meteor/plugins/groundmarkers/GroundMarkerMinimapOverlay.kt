/*
 * Copyright (c) 2019, Benjamin <https://github.com/genetic-soybean>
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

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class GroundMarkerMinimapOverlay(
    private val config: GroundMarkerConfig,
    private val plugin: GroundMarkerPlugin
) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.LOW
        layer = OverlayLayer.ABOVE_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!config.drawTileOnMinimmap()) {
            return null
        }
        val points: MutableCollection<ColorTileMarker> = plugin.points
        for (point in points) {
            val worldPoint: WorldPoint? = point.worldPoint
            if (worldPoint?.plane != client.plane) {
                continue
            }
            val tileColor = point.color

            drawOnMinimap(graphics, worldPoint, Color(tileColor!!))
        }
        return null
    }

    private fun drawOnMinimap(graphics: Graphics2D, point: WorldPoint, color: Color?) {
        val playerLocation: WorldPoint = client.localPlayer!!.worldLocation
        if (point.distanceTo(playerLocation) >= MAX_DRAW_DISTANCE) {
            return
        }
        val lp: LocalPoint = LocalPoint.fromWorld(client, point) ?: return
        val posOnMinimap: Point = Perspective.localToMinimap(client, lp) ?: return
        OverlayUtil.renderMinimapRect(graphics, posOnMinimap, TILE_WIDTH, TILE_HEIGHT, color)
    }

    companion object {
        private const val MAX_DRAW_DISTANCE = 16
        private const val TILE_WIDTH = 4
        private const val TILE_HEIGHT = 4
    }
}