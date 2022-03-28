/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package meteor.dev.widgetinspector

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import net.runelite.api.Client
import net.runelite.api.MenuEntry
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetItem
import java.awt.*
import java.awt.geom.Rectangle2D

class WidgetInspectorOverlay(val inspector: WidgetInspector
) : Overlay() {
    init {
        position = (OverlayPosition.DYNAMIC)
        layer = (OverlayLayer.ABOVE_WIDGETS)
        priority = (OverlayPriority.HIGHEST)
        drawAfterInterface(WidgetID.FULLSCREEN_CONTAINER_TLI)
    }

    override fun render(g: Graphics2D): Dimension? {
        val w = inspector.selectedWidget
        if (w != null) {
            var wiw: Any = w
            if (inspector.selectedItem != -1) {
                wiw = w.getWidgetItem(inspector.selectedItem)
            }
            renderWiw(g, wiw, WidgetInspector.SELECTED_WIDGET_COLOR)
        }
        if (inspector.pickerSelected) {
            val menuOpen = client.isMenuOpen
            val entries: Array<MenuEntry> = client.menuEntries
            for (i in entries.indices) {
                val e: MenuEntry = entries[i]
                val wiw =
                    inspector.getWidgetOrWidgetItemForMenuOption(e.type, e.param0, e.param1) ?: continue
                val color = inspector.colorForWidget(i, entries.size)
                renderWiw(g, wiw, color)
            }
        }
        return null
    }

    private fun renderWiw(g: Graphics2D, wiw: Any, color: Color?) {
        g.setColor(color)
        if (wiw is WidgetItem) {
            val wi: WidgetItem = wiw as WidgetItem
            val bounds: Rectangle = wi.getCanvasBounds()
            g.draw(bounds)
            val text: String = wi.getId().toString() + ""
            val fm: FontMetrics = g.getFontMetrics()
            val textBounds: Rectangle2D = fm.getStringBounds(text, g)
            val textX: Int = (bounds.getX() + bounds.getWidth() / 2 - textBounds.getWidth() / 2).toInt()
            val textY: Int = (bounds.getY() + bounds.getHeight() / 2 + textBounds.getHeight() / 2).toInt()
            g.setColor(Color.BLACK)
            g.drawString(text, textX + 1, textY + 1)
            g.setColor(Color.ORANGE)
            g.drawString(text, textX, textY)
        } else {
            val w = wiw as Widget
            g.draw(w.bounds)
        }
    }
}