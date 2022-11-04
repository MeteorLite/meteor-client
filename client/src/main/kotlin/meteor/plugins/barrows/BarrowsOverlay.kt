/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.barrows

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class BarrowsOverlay constructor(plugin: BarrowsPlugin, config: BarrowsConfig) : Overlay() {
    private val plugin: BarrowsPlugin
    private val config: BarrowsConfig

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_WIDGETS
        this.plugin = plugin
        this.config = config
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (plugin.isBarrowsLoaded && config.showBrotherLoc()) {
            renderBarrowsBrothers(graphics)
        }
        val puzzleAnswer = plugin.puzzleAnswer
        if (puzzleAnswer != null && config.showPuzzleAnswer() && !puzzleAnswer.isHidden) {
            val answerRect = puzzleAnswer.bounds
            graphics.color = Color.GREEN
            graphics.draw(answerRect)
        }
        return null
    }

    private fun renderBarrowsBrothers(graphics: Graphics2D) {
        for (brother in BarrowsBrothers.values()) {
            val localLocation = LocalPoint.fromWorld(client, brother.worldLocation) ?: continue
            val brotherLetter = brother.brotherName[0].toString()
            val miniMapLocation = Perspective.getCanvasTextMiniMapLocation(client, graphics,
                    localLocation, brotherLetter)
            if (miniMapLocation != null) {
                graphics.color = Color.black
                graphics.drawString(brotherLetter, miniMapLocation.x + 1, miniMapLocation.y + 1)
                if (client.getVarbitValue(brother.varbit) > 0) {
                    graphics.color = config.deadBrotherLocColor()
                } else {
                    graphics.color = config.brotherLocColor()
                }
                graphics.drawString(brotherLetter, miniMapLocation.x, miniMapLocation.y)
            }
        }
    }
}