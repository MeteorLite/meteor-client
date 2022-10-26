/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package meteor.plugins.fps

import eventbus.events.FocusChanged
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Point
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.plugins.gauntletextended.overlay.Overlay
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

/**
 * The built in FPS overlay has a few problems that this one does not have, most of all: it is distracting.
 * 1. The built in one also shows memory, which constantly fluctuates and garbage collects.
 * It is useful for devs profiling memory.
 * 2. The built in one shifts around constantly because it is not monospace.
 * This locks "FPS:" into one position (the far top right corner of the canvas),
 * along with a locked position for the FPS value.
 */
class FpsOverlay internal constructor(
    plugin: FpsPlugin?, // Local dependencies
    private val config: FpsConfig
) : Overlay(plugin) {


    // Often changing values
    private var isFocused = true

    init {

        layer = OverlayLayer.ABOVE_WIDGETS
        priority = OverlayPriority.HIGH
        position = OverlayPosition.DYNAMIC
    }

    override fun onFocusChanged(event: FocusChanged) {
        isFocused = event.focused
    }

    private val isEnforced: Boolean
        private get() = (config.limitFps()
                || config.limitFpsUnfocused() && !isFocused)
    private val fpsValueColor: Color
        private get() = if (isEnforced) Color.red else Color.yellow

    override fun render(graphics: Graphics2D): Dimension? {
        if (!config.drawFps()) {
            return null
        }

        // On resizable bottom line mode the logout button is at the top right, so offset the overlay
        // to account for it
        val logoutButton = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_LOGOUT_BUTTON)
        var xOffset = X_OFFSET
        if (logoutButton != null && !logoutButton.isHidden) {
            xOffset += logoutButton.width
        }
        val text = client.fps.toString() + FPS_STRING
        val textWidth = graphics.fontMetrics.stringWidth(text)
        val textHeight = graphics.fontMetrics.ascent - graphics.fontMetrics.descent
        val width = client.realDimensions.getWidth().toInt()
        val point = Point(width - textWidth - xOffset, textHeight + Y_OFFSET)
        OverlayUtil.renderTextLocation(graphics, point, text, fpsValueColor)
        return null
    }

    override fun determineLayer() {}

    companion object {
        private const val Y_OFFSET = 1
        private const val X_OFFSET = 1
        private const val FPS_STRING = " FPS"
    }
}