/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package meteor.ui.worldmap

import com.google.common.base.Splitter
import com.google.common.base.Strings
import meteor.FontManager
import meteor.plugins.worldmap.WorldMapPoint
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.ColorUtil
import meteor.util.JagexColors
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import net.runelite.api.events.MenuOptionClicked
import net.runelite.api.widgets.JavaScriptCallback
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Dimension
import java.awt.FontMetrics
import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.geom.Area
import java.awt.image.BufferedImage
import java.util.*
import javax.inject.Singleton
import kotlin.math.ceil


class WorldMapOverlay( val worldMapPointManager: WorldMapPointManager) : Overlay() {
     val mapMenuEntries: MutableList<MenuEntry> = ArrayList<MenuEntry>()

    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGHEST
        layer = OverlayLayer.MANUAL
        drawAfterInterface(WidgetID.WORLD_MAP_GROUP_ID)
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val points = worldMapPointManager.worldMapPoints
        if (points.isEmpty()) {
            return null
        }
        val widget: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_VIEW)
        val bottomBar: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_BOTTOM_BAR)
        if (widget == null || bottomBar == null) {
            return null
        }
        bottomBar.setOnTimerListener( JavaScriptCallback {
            if (client.isMenuOpen || mapMenuEntries.isEmpty()) {
                return@JavaScriptCallback
            }
            var entries: Array<MenuEntry?> = client.menuEntries
            val end = entries.size
            entries = Arrays.copyOf<MenuEntry>(entries, end + mapMenuEntries.size)
            var i = 0
            while (i < mapMenuEntries.size) {
                entries[end + i] = mapMenuEntries[i]
                i++
            }
            client.menuEntries = entries
        } as JavaScriptCallback?)
        bottomBar.setHasListener(true)
        val worldMapRectangle = widget.bounds
        val mapViewArea = getWorldMapClipArea(worldMapRectangle)
        val canvasBounds = Rectangle(
            0, 0, client.canvasWidth,
            client.canvasHeight
        )
        val canvasViewArea = getWorldMapClipArea(canvasBounds)
        var currentClip: Area? = null
        var mousePos = client.mouseCanvasPosition
        if (!mapViewArea.contains(mousePos!!.x.toDouble(), mousePos.y.toDouble())) {
            mousePos = null
        }
        mapMenuEntries.clear()
        var tooltipPoint: WorldMapPoint? = null
        for (worldPoint in points) {
            val image: BufferedImage? = worldPoint.image
            val point: WorldPoint? = worldPoint.worldPoint
            if (image != null && point != null) {
                var drawPoint = mapWorldPointToGraphicsPoint(point) ?: continue
                if (worldPoint.snapToEdge && canvasViewArea !== currentClip) {
                    graphics.clip = canvasViewArea
                    currentClip = canvasViewArea
                } else if (!worldPoint.snapToEdge && mapViewArea !== currentClip) {
                    graphics.clip = mapViewArea
                    currentClip = mapViewArea
                }
                if (worldPoint.snapToEdge) {
                    // Get a smaller rect for edge-snapped icons so they display correctly at the edge
                    val snappedRect = widget.bounds
                    snappedRect.grow(-image.width / 2, -image.height / 2)
                    val unsnappedRect = Rectangle(snappedRect)
                    if (worldPoint.imagePoint != null) {
                        val dx: Int = worldPoint.imagePoint!!.x - image.width / 2
                        val dy: Int = worldPoint.imagePoint!!.y - image.height / 2
                        unsnappedRect.translate(dx, dy)
                    }
                    // Make the unsnap rect slightly smaller so a smaller snapped image doesn't cause a freak out
                    if (worldPoint.currentlyEdgeSnapped) {
                        unsnappedRect.grow(-image.width, -image.height)
                    }
                    if (unsnappedRect.contains(drawPoint.x, drawPoint.y)) {
                        if (worldPoint.currentlyEdgeSnapped) {
                            worldPoint.currentlyEdgeSnapped = false
                            worldPoint.onEdgeUnsnap()
                        }
                    } else {
                        drawPoint = clipToRectangle(drawPoint, snappedRect)
                        if (!worldPoint.currentlyEdgeSnapped) {
                            worldPoint.currentlyEdgeSnapped = true
                            worldPoint.onEdgeSnap()
                        }
                    }
                }
                var drawX = drawPoint.x
                var drawY = drawPoint.y
                if (worldPoint.imagePoint == null) {
                    drawX -= image.width / 2
                    drawY -= image.height / 2
                } else {
                    drawX -= worldPoint.imagePoint!!.x
                    drawY -= worldPoint.imagePoint!!.y
                }
                graphics.drawImage(image, drawX, drawY, null)
                val clickbox = Rectangle(drawX, drawY, image.width, image.height)
                if (mousePos != null && clickbox.contains(mousePos.x, mousePos.y)) {
                    if (!Strings.isNullOrEmpty(worldPoint.tooltip)) {
                        tooltipPoint = worldPoint
                    }
                    if (worldPoint.jumpOnClick) {
                        assert(worldPoint.name != null)
                        var target: WorldPoint? = worldPoint.target
                        if (target == null) {
                            target = worldPoint.worldPoint
                        }
                        val entry = MenuEntry()
                        entry.type = MenuAction.RUNELITE.id
                        entry.option = FOCUS_ON
                        entry.target = ColorUtil.wrapWithColorTag(worldPoint.name!!, JagexColors.MENU_TARGET)
                        entry.identifier = target!!.plane shl 28 or (target.x shl 14) or target.y
                        mapMenuEntries.add(entry)
                    }
                }
            }
        }
        val rsTooltip: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_TOOLTIP)
        if (rsTooltip != null) {
            rsTooltip.isHidden = tooltipPoint != null
        }
        tooltipPoint?.let { drawTooltip(graphics, it) }
        return null
    }

    override fun onMenuOptionClicked():((Any)->Unit) ={ it as MenuOptionClicked
        if (it.menuAction == MenuAction.RUNELITE && FOCUS_ON == it.menuOption) {
            val pxy = it.id
            val wp = WorldPoint(
                pxy shr 14 and 0x3fff,
                pxy and 0x3fff,
                pxy shr 28
            )
            client.renderOverview.setWorldMapPositionTarget(wp)
        }
    }

    /**
     * Get the screen coordinates for a WorldPoint on the world map
     *
     * @param worldPoint WorldPoint to get screen coordinates of
     * @return Point of screen coordinates of the center of the world point
     */
    fun mapWorldPointToGraphicsPoint(worldPoint: WorldPoint): Point? {
        val ro: RenderOverview = client.renderOverview
        if (!ro.worldMapData.surfaceContainsPosition(worldPoint.x, worldPoint.y)) {
            return null
        }
        val pixelsPerTile: Float = ro.worldMapZoom
        val map: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_VIEW)
        if (map != null) {
            val worldMapRect = map.bounds
            val widthInTiles = ceil(worldMapRect.getWidth() / pixelsPerTile).toInt()
            val heightInTiles = ceil(worldMapRect.getHeight() / pixelsPerTile).toInt()
            val worldMapPosition: Point = ro.worldMapPosition

            //Offset in tiles from anchor sides
            val yTileMax = worldMapPosition.y - heightInTiles / 2
            val yTileOffset: Int = (yTileMax - worldPoint.y - 1) * -1
            val xTileOffset: Int = worldPoint.x + widthInTiles / 2 - worldMapPosition.x
            var xGraphDiff = (xTileOffset * pixelsPerTile).toInt()
            var yGraphDiff = (yTileOffset * pixelsPerTile).toInt()

            //Center on tile.
            yGraphDiff -= (pixelsPerTile - ceil((pixelsPerTile / 2).toDouble())).toInt()
            xGraphDiff += (pixelsPerTile - ceil((pixelsPerTile / 2).toDouble())).toInt()
            yGraphDiff = worldMapRect.height - yGraphDiff
            yGraphDiff += worldMapRect.getY().toInt()
            xGraphDiff += worldMapRect.getX().toInt()
            return Point(xGraphDiff, yGraphDiff)
        }
        return null
    }

    /**
     * Gets a clip area which excludes the area of widgets which overlay the world map.
     *
     * @param baseRectangle The base area to clip from
     * @return An [Area] representing `baseRectangle`, with the area of visible
     * widgets overlaying the world map clipped from it.
     */
    private fun getWorldMapClipArea(baseRectangle: Rectangle): Area {
        val overview: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_OVERVIEW_MAP)
        val surfaceSelector: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_SURFACE_SELECTOR)
        val clipArea = Area(baseRectangle)
        if (overview != null && !overview.isHidden) {
            clipArea.subtract(Area(overview.bounds))
        }
        if (surfaceSelector != null && !surfaceSelector.isHidden) {
            clipArea.subtract(Area(surfaceSelector.bounds))
        }
        return clipArea
    }

    private fun drawTooltip(graphics: Graphics2D, worldPoint: WorldMapPoint) {
        val tooltip = worldPoint.tooltip
        var drawPoint = worldPoint.worldPoint?.let { mapWorldPointToGraphicsPoint(it) }
        if (tooltip == null || tooltip.length <= 0 || drawPoint == null) {
            return
        }
        val rows = TOOLTIP_SPLITTER.splitToList(tooltip)
        if (rows.isEmpty()) {
            return
        }
        drawPoint = Point(
            drawPoint.x + TOOLTIP_OFFSET_WIDTH,
            drawPoint.y + TOOLTIP_OFFSET_HEIGHT
        )
        val bounds = Rectangle(0, 0, client.canvasWidth, client.canvasHeight)
        val mapArea = getWorldMapClipArea(bounds)
        graphics.clip = mapArea
        graphics.color = JagexColors.TOOLTIP_BACKGROUND
        graphics.font = FontManager.runescapeFont
        val fm: FontMetrics = graphics.fontMetrics
        val width = rows.stream().map { str: String? -> fm.stringWidth(str) }
            .max { obj: Int, anotherInteger: Int? -> obj.compareTo(anotherInteger!!) }.get()
        val height = fm.height
        val tooltipRect = Rectangle(
            drawPoint.x - TOOLTIP_PADDING_WIDTH,
            drawPoint.y - TOOLTIP_PADDING_HEIGHT, width + TOOLTIP_PADDING_WIDTH * 2,
            height * rows.size + TOOLTIP_PADDING_HEIGHT * 2
        )
        graphics
            .fillRect(
                tooltipRect.getX().toInt(),
                tooltipRect.getY().toInt(),
                tooltipRect.getWidth().toInt(),
                tooltipRect.getHeight().toInt()
            )
        graphics.color = JagexColors.TOOLTIP_BORDER
        graphics
            .drawRect(
                tooltipRect.getX().toInt(),
                tooltipRect.getY().toInt(),
                tooltipRect.getWidth().toInt(),
                tooltipRect.getHeight().toInt()
            )
        graphics.color = JagexColors.TOOLTIP_TEXT
        for (i in rows.indices) {
            graphics.drawString(
                rows[i], drawPoint.x,
                drawPoint.y + TOOLTIP_TEXT_OFFSET_HEIGHT + (i + 1) * height
            )
        }
    }

    private fun clipToRectangle(drawPoint: Point, mapDisplayRectangle: Rectangle): Point {
        var clippedX = drawPoint.x
        if (drawPoint.x < mapDisplayRectangle.getX()) {
            clippedX = mapDisplayRectangle.getX().toInt()
        }
        if (drawPoint.x > mapDisplayRectangle.getX() + mapDisplayRectangle.getWidth()) {
            clippedX = (mapDisplayRectangle.getX() + mapDisplayRectangle.getWidth()).toInt()
        }
        var clippedY = drawPoint.y
        if (drawPoint.y < mapDisplayRectangle.getY()) {
            clippedY = mapDisplayRectangle.getY().toInt()
        }
        if (drawPoint.y > mapDisplayRectangle.getY() + mapDisplayRectangle.getHeight()) {
            clippedY = (mapDisplayRectangle.getY() + mapDisplayRectangle.getHeight()).toInt()
        }
        return Point(clippedX, clippedY)
    }

    companion object {
        private const val FOCUS_ON = "Focus on"
        private const val TOOLTIP_OFFSET_HEIGHT = 25
        private const val TOOLTIP_OFFSET_WIDTH = 5
        private const val TOOLTIP_PADDING_HEIGHT = 1
        private const val TOOLTIP_PADDING_WIDTH = 2
        private const val TOOLTIP_TEXT_OFFSET_HEIGHT = -2
        private val TOOLTIP_SPLITTER = Splitter.on("<br>").trimResults()
            .omitEmptyStrings()
    }
}