/*
 * Copyright (c) 2018 Hydrox6 <ikada@protonmail.ch>
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
package meteor.plugins.poison

import meteor.ui.overlay.*
import net.runelite.api.widgets.WidgetInfo
import java.awt.Dimension
import java.awt.Graphics2D

internal class PoisonOverlay(private val plugin: PoisonPlugin) : Overlay() {
    private val tooltipManager = TooltipManager

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (plugin.lastDamage <= 0) {
            return null
        }
        val healthOrb = client.getWidget(WidgetInfo.MINIMAP_HEALTH_ORB)
        if (healthOrb == null || healthOrb.isHidden) {
            return null
        }
        val bounds = healthOrb.bounds
        if (bounds.getX() <= 0) {
            return null
        }
        val mousePosition = client.mouseCanvasPosition
        if (bounds.contains(mousePosition.x, mousePosition.y)) {
            tooltipManager.add(Tooltip(plugin.createTooltip()))
        }
        return null
    }
}