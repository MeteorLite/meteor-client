/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package meteor.plugins.devtools.overlays

import meteor.plugins.devtools.DevToolsConfig
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import net.runelite.api.Model
import net.runelite.api.Perspective
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D


class ModelsOverlay(private val config: DevToolsConfig) : Overlay() {

    init {
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (config.wallObjects())
            for (m in client.getScene().getModels().filterNotNull().filter { it.isWallObject })
                renderObjectOverlay(m, graphics)
        if (config.gameObjects())
            for (m in client.getScene().getModels().filterNotNull().filter { !it.isWallObject })
                renderObjectOverlay(m, graphics)
        return null
    }

    fun renderObjectOverlay(m: Model, graphics: Graphics2D) {
        if (m.getLocalX() > 0 && m.getLocalY() > 0) {
            if (m.isWallObject()) graphics.color = Color.GREEN
            else graphics.color = Color.MAGENTA
            val p = Perspective.getCanvasTileAreaPoly(client, m.getLocalLocation(), m.getSize())
            if (p != null) {
                graphics.draw(p)
            }
            val centerPoint = m.centerLocation
            drawTextAboveBoundsShadowed(centerPoint.x, centerPoint.y, graphics, m.getObjectID().toString() + ":" + m.getName())
        }
    }

    fun drawTextAboveBoundsShadowed(x: Int, y: Int, graphics: Graphics2D, text: String?) {
        val originalColor = graphics.color
        val textWidth = getTextWidth(graphics, text)
        val p = Perspective.localToCanvas(client, x, y, client.getPlane(), false)
        if (p != null) {
            graphics.color = Color.BLACK
            graphics.drawString(text, p.x - (textWidth / 2) + 1, p.y + 1)
            graphics.color = originalColor
            graphics.drawString(text, p.x - (textWidth / 2), p.y)
        }
    }

    fun getTextWidth(graphics: Graphics2D, text: String?): Int {
        return graphics.fontMetrics.getStringBounds(text, graphics).width.toInt()
    }
}
