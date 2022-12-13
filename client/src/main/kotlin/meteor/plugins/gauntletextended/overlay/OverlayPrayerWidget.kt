/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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
package meteor.plugins.gauntletextended.overlay

import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import meteor.util.OverlayUtil.renderPrayerOverlay
import net.runelite.api.Point
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.plugins.gauntletextended.GauntletExtendedConfig.PrayerHighlightMode
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics2D

class OverlayPrayerWidget(private val plugin: GauntletExtendedPlugin, private val config: GauntletExtendedConfig) :
    Overlay(
        plugin
    ) {

    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGH
        determineLayer()
    }

    override fun render(graphics2D: Graphics2D): Dimension? {
        val prayerHighlightMode = config.prayerOverlay()
        if (prayerHighlightMode == PrayerHighlightMode.NONE || prayerHighlightMode == PrayerHighlightMode.BOX) {
            return null
        }
        val hunllef = plugin.hunllef ?: return null
        val npc = hunllef.npc
        if (npc == null || npc.isDead) {
            return null
        }

        // Overlay outline on the prayer widget
        val phase = hunllef.attackPhase
        val prayer = phase.prayer
        val phaseColor = phase.color
        val rectangle = renderPrayerOverlay(graphics2D, prayer!!, phaseColor!!) ?: return null

        // Overlay tick count on the prayer widget
        val ticksUntilAttack = hunllef.ticksUntilNextAttack
        val text = ticksUntilAttack.toString()
        val fontSize = 16
        val fontStyle = Font.BOLD
        val fontColor = if (ticksUntilAttack == 1) Color.WHITE else phaseColor
        val x = (rectangle.getX() + rectangle.getWidth() / 2).toInt()
        val y = (rectangle.getY() + rectangle.getHeight() / 2).toInt()
        val point = Point(x, y)
        val canvasPoint = Point(point.x - 3, point.y + 6)
        OverlayUtil.renderTextLocation(graphics2D, text, fontSize, fontStyle, fontColor!!, canvasPoint, true, 0)
        return null
    }

    override fun determineLayer() {
        layer = OverlayLayer.ABOVE_WIDGETS
    }
}