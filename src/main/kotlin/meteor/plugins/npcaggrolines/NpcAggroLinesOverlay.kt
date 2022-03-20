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

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import net.runelite.api.geometry.Geometry
import java.awt.*
import java.awt.geom.GeneralPath
import java.time.Instant

class NpcAggroLinesOverlay(
    config: NpcAggroLinesConfig,
    plugin: NpcAggroLinesPlugin
) : Overlay() {
    private val config: NpcAggroLinesConfig
    private val plugin: NpcAggroLinesPlugin

    init {
        this.config = config
        this.plugin = plugin
        layer = OverlayLayer.ABOVE_SCENE
        priority = OverlayPriority.LOW
        position = OverlayPosition.DYNAMIC
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (plugin.safeCenters[1] == null) {
            return null
        }
        val lines = plugin.linesToDisplay[client.plane] ?: return null
        var outlineColor = config.unaggroAreaColor()
        val timer = plugin.currentTimer
        if (outlineColor == null || timer == null || Instant.now().compareTo(timer.endTime) < 0) {
            outlineColor = config.aggroAreaColor()
        }
        renderPath(graphics, lines, outlineColor)
        return null
    }

    private fun renderPath(graphics: Graphics2D, path: GeneralPath, color: Color?) {
        var path: GeneralPath? = path
        val playerLp = client.localPlayer!!.localLocation
        val viewArea = Rectangle(
            playerLp.x - MAX_LOCAL_DRAW_LENGTH,
            playerLp.y - MAX_LOCAL_DRAW_LENGTH,
            MAX_LOCAL_DRAW_LENGTH * 2,
            MAX_LOCAL_DRAW_LENGTH * 2
        )
        graphics.color = color
        graphics.stroke = BasicStroke(1F)
        path = Geometry.clipPath(path, viewArea)
        path = Geometry.filterPath(path) { p1: FloatArray, p2: FloatArray ->
            Perspective.localToCanvas(
                client, LocalPoint(
                    p1[0].toInt(), p1[1].toInt()
                ), client.plane
            ) != null &&
                    Perspective.localToCanvas(client, LocalPoint(p2[0].toInt(), p2[1].toInt()), client.plane) != null
        }
        path = Geometry.transformPath(path) { coords: FloatArray ->
            val point =
                Perspective.localToCanvas(client, LocalPoint(coords[0].toInt(), coords[1].toInt()), client.plane)
            coords[0] = point!!.x.toFloat()
            coords[1] = point.y.toFloat()
        }
        graphics.draw(path)
    }

    companion object {
        private const val MAX_LOCAL_DRAW_LENGTH = 20 * Perspective.LOCAL_TILE_SIZE
    }
}