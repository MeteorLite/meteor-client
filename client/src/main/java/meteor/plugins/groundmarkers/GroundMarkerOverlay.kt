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

import com.google.common.base.Strings
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.*
import javax.inject.Inject

class GroundMarkerOverlay(
    private val config: GroundMarkerConfig,
    private val plugin: GroundMarkerPlugin
) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.LOW
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val points: Collection<ColorTileMarker?> = plugin.points
        if (points.isEmpty()) {
            return null
        }
        val stroke: Stroke = BasicStroke(config.borderWidth().toFloat())
        for (point in points) {
            val worldPoint: WorldPoint? = point?.worldPoint
            if (worldPoint?.plane != client.plane) {
                continue
            }
            val tileColor = point.color

            drawTile(graphics, worldPoint, Color(tileColor!!), point.label, stroke)
        }
        return null
    }

    private fun drawTile(graphics: Graphics2D, point: WorldPoint, color: Color?, label: String?, borderStroke: Stroke) {
        val playerLocation: WorldPoint = client.localPlayer!!.worldLocation
        if (point.distanceTo(playerLocation) >= MAX_DRAW_DISTANCE) {
            return
        }
        val lp: LocalPoint = LocalPoint.fromWorld(client, point) ?: return
        val poly: Polygon? = Perspective.getCanvasTilePoly(client, lp)

        if (poly != null) {
            OverlayUtil.renderPolygon(graphics, poly, color!!, borderStroke)
        }
        if (!Strings.isNullOrEmpty(label)) {
            val canvasTextLocation: Point? = Perspective.getCanvasTextLocation(client, graphics, lp, label, 0)
            if (canvasTextLocation != null) {
                OverlayUtil.renderTextLocation(graphics, canvasTextLocation, label!!, color!!)
            }
        }
    }

    companion object {
        private const val MAX_DRAW_DISTANCE = 32
    }
}