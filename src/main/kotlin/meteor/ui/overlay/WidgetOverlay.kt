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
package meteor.ui.overlay

import net.runelite.api.widgets.WidgetInfo
import java.awt.Graphics2D
import net.runelite.api.widgets.Widget
import java.awt.Dimension
import java.awt.Rectangle
import java.util.*

open class WidgetOverlay private constructor( private val widgetInfo: WidgetInfo,
                                             overlayPosition: OverlayPosition) : Overlay() {
    override val name: String
        get() = Objects.toString(widgetInfo)
    override var parentBounds: Rectangle = getParentBounds()

    override fun render(graphics: Graphics2D): Dimension? {
        val widget = client.getWidget(widgetInfo)
        val parent = getParentBounds(widget)
        if (parent.isEmpty) {
            return null
        }
        val bounds = bounds
        // The widget relative pos is relative to the parent
        widget!!.relativeX = bounds.x - parent.x
        widget.relativeY = bounds.y - parent.y
        return Dimension(widget.width, widget.height)
    }

    private fun getParentBounds(widget: Widget?): Rectangle {
        if (widget == null || widget.isHidden) {
            parentBounds.bounds = Rectangle()
            return parentBounds
        }
        val parent = widget.parent
        val bounds: Rectangle = if (parent == null) {
            Rectangle(client.realDimensions)
        } else {
            parent.bounds
        }
        parentBounds.bounds = bounds
        return bounds
    }

    @JvmName("getParentBounds1")
    private fun getParentBounds(): Rectangle {
        if (!client.isClientThread) {
            // During overlay drag this is called on the EDT, so we just
            // cache and reuse the last known parent bounds.
            return parentBounds
        }
        val widget = client.getWidget(widgetInfo)
        return getParentBounds(widget)
    }

    companion object {
        fun createOverlays(): Collection<WidgetOverlay> {
            return listOf(
                    WidgetOverlay(WidgetInfo.RESIZABLE_MINIMAP_WIDGET,
                            OverlayPosition.CANVAS_TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET,
                            OverlayPosition.CANVAS_TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.FOSSIL_ISLAND_OXYGENBAR, OverlayPosition.TOP_CENTER),
                    WidgetOverlay(WidgetInfo.RAIDS_POINTS_INFOBOX, OverlayPosition.TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.TOB_PARTY_INTERFACE, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.TOB_PARTY_STATS, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.GWD_KC, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.TITHE_FARM, OverlayPosition.TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.PEST_CONTROL_BOAT_INFO, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.PEST_CONTROL_KNIGHT_INFO_CONTAINER,
                            OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.PEST_CONTROL_ACTIVITY_SHIELD_INFO_CONTAINER,
                            OverlayPosition.TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.ZEAH_MESS_HALL_COOKING_DISPLAY,
                            OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.PVP_KILLDEATH_COUNTER, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.SKOTIZO_CONTAINER, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.KOUREND_FAVOUR_OVERLAY, OverlayPosition.TOP_CENTER),
                    WidgetOverlay(WidgetInfo.PYRAMID_PLUNDER_DATA, OverlayPosition.TOP_CENTER),
                    WidgetOverlay(WidgetInfo.LMS_INFO, OverlayPosition.TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.LMS_KDA, OverlayPosition.TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.GAUNTLET_TIMER_CONTAINER, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.HALLOWED_SEPULCHRE_TIMER_CONTAINER,
                            OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.HEALTH_OVERLAY_BAR, OverlayPosition.TOP_CENTER),
                    WidgetOverlay(WidgetInfo.TOB_HEALTH_BAR, OverlayPosition.TOP_CENTER),
                    WidgetOverlay(WidgetInfo.NIGHTMARE_PILLAR_HEALTH, OverlayPosition.TOP_LEFT),
                    WidgetOverlay(WidgetInfo.VOLCANIC_MINE_VENTS_INFOBOX_GROUP,
                            OverlayPosition.BOTTOM_RIGHT),
                    WidgetOverlay(WidgetInfo.VOLCANIC_MINE_STABILITY_INFOBOX_GROUP,
                            OverlayPosition.BOTTOM_LEFT),
                    WidgetOverlay(WidgetInfo.MULTICOMBAT_FIXED, OverlayPosition.BOTTOM_RIGHT),
                    WidgetOverlay(WidgetInfo.MULTICOMBAT_RESIZEABLE_MODERN,
                            OverlayPosition.CANVAS_TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.MULTICOMBAT_RESIZEABLE_CLASSIC,
                            OverlayPosition.CANVAS_TOP_RIGHT),
                    WidgetOverlay(WidgetInfo.TEMPOROSS_STATUS_INDICATOR, OverlayPosition.TOP_LEFT)
            )
        }
    }

    init {
        priority = OverlayPriority.HIGHEST
        layer = OverlayLayer.UNDER_WIDGETS
        position = overlayPosition
        // It's almost possible to drawAfterInterface(widgetInfo.getGroupId()) here, but that fires
        // *after* the native components are drawn, which is too late.
    }
}