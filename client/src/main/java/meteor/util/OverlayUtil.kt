package meteor.util

import meteor.Main
import net.runelite.api.*
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import net.runelite.api.vars.InterfaceTab
import java.awt.*
import java.awt.image.BufferedImage


object OverlayUtil {
    private const val MINIMAP_DOT_RADIUS = 4

    fun renderPolygon(graphics: Graphics2D, poly: Shape, color: Color) {
        renderPolygon(graphics, poly, color, BasicStroke(2F))
    }

    fun renderPolygon(
        graphics: Graphics2D, poly: Shape, color: Color,
        borderStroke: Stroke
    ) {
        graphics.color = color
        val originalStroke = graphics.stroke
        graphics.stroke = borderStroke
        graphics.draw(poly)
        graphics.color = Color(0, 0, 0, 50)
        graphics.fill(poly)
        graphics.stroke = originalStroke
    }

    fun renderTextLocation(graphics: Graphics2D, txtLoc: Point, text: String, color: Color) {
        val x = txtLoc.x
        val y = txtLoc.y
        graphics.color = Color.BLACK
        graphics.drawString(text, x + 1, y + 1)
        graphics.color = ColorUtil.colorWithAlpha(color, 0xFF)
        graphics.drawString(text, x, y)
    }

    fun renderTextLocation(
        graphics: Graphics2D, txtString: String, fontSize: Int,
        fontStyle: Int, fontColor: Color, canvasPoint: Point?, shadows: Boolean, yOffset: Int
    ) {
        graphics.font = Font("Arial", fontStyle, fontSize)
        if (canvasPoint != null) {
            val canvasCenterPoint = Point(
                canvasPoint.x,
                canvasPoint.y + yOffset
            )
            val canvasCenterPoint_shadow = Point(
                canvasPoint.x + 1,
                canvasPoint.y + 1 + yOffset
            )
            if (shadows) {
                renderTextLocation(
                    graphics,
                    canvasCenterPoint_shadow,
                    txtString,
                    Color.BLACK
                )
            }
            renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor)
        }
    }

    fun renderActorOverlay(graphics: Graphics2D, actor: Actor, text: String, color: Color) {
        val poly = actor.canvasTilePoly
        if (poly != null) {
            renderPolygon(graphics, poly, color)
        }
        val textLocation = actor.getCanvasTextLocation(graphics, text, actor.logicalHeight + 40)
        if (textLocation != null) {
            renderTextLocation(graphics, textLocation, text, color)
        }
    }

    fun renderTileOverlay(graphics: Graphics2D, tileObject: TileObject, text: String, color: Color) {
        val poly = tileObject.canvasTilePoly
        if (poly != null) {
            renderPolygon(graphics, poly, color)
        }
        val minimapLocation = tileObject.minimapLocation
        if (minimapLocation != null) {
            renderMinimapLocation(graphics, minimapLocation, color)
        }
        val textLocation = tileObject.getCanvasTextLocation(graphics, text, 0)
        if (textLocation != null) {
            renderTextLocation(graphics, textLocation, text, color)
        }
    }

    fun renderTileOverlay(
        graphics: Graphics2D,
        localLocation: LocalPoint,
        image: BufferedImage,
        color: Color
    ) {
        val poly = Perspective.getCanvasTilePoly(Main.client, localLocation)
        if (poly != null) {
            renderPolygon(graphics, poly, color)
        }
        renderImageLocation(graphics, localLocation, image, 0)
    }

    fun renderImageLocation(
        graphics: Graphics2D,
        localPoint: LocalPoint,
        image: BufferedImage,
        zOffset: Int
    ) {
        val imageLocation = Perspective.getCanvasImageLocation(
            Main.client,
            localPoint, image, zOffset
        )
        if (imageLocation != null) {
            renderImageLocation(graphics, imageLocation, image)
        }
    }

    fun fillTile(graphics: Graphics2D, point: WorldPoint, color: Color) {
        val client = Main.client
        if (point.plane != client.plane) {
            return
        }
        val lp = LocalPoint.fromWorld(client, point) ?: return
        val poly = Perspective.getCanvasTilePoly(client, lp) ?: return
        graphics.color = color
        graphics.fill(poly)
    }

    fun renderMinimapLocation(graphics: Graphics2D, mini: Point, color: Color) {
        graphics.color = Color.BLACK
        graphics.fillOval(
            mini.x - MINIMAP_DOT_RADIUS / 2,
            mini.y - MINIMAP_DOT_RADIUS / 2 + 1,
            MINIMAP_DOT_RADIUS,
            MINIMAP_DOT_RADIUS
        )
        graphics.color = ColorUtil.colorWithAlpha(color, 0xFF)
        graphics.fillOval(
            mini.x - MINIMAP_DOT_RADIUS / 2,
            mini.y - MINIMAP_DOT_RADIUS / 2,
            MINIMAP_DOT_RADIUS,
            MINIMAP_DOT_RADIUS
        )
    }

    fun renderImageLocation(graphics: Graphics2D, imgLoc: Point, image: BufferedImage) {
        val x = imgLoc.x
        val y = imgLoc.y
        graphics.drawImage(image, x, y, null)
    }

    fun renderImageLocation(graphics: Graphics2D, imgLoc: LocalPoint, image: BufferedImage) {
        val x = imgLoc.x
        val y = imgLoc.y
        graphics.drawImage(image, x, y, null)
    }

    fun renderMinimapRect(graphics: Graphics2D, center: Point, width: Int, height: Int, color: Color?) {
        val angle = Main.client.mapAngle * Perspective.UNIT
        graphics.color = color
        graphics.rotate(angle, center.x.toDouble(), center.y.toDouble())
        graphics.drawRect(center.x - width / 2, center.y - height / 2, width - 1, height - 1)
        graphics.rotate(-angle, center.x.toDouble(), center.y.toDouble())
    }

    fun renderHoverableArea(
        graphics: Graphics2D,
        area: Shape?,
        mousePosition: Point,
        fillColor: Color,
        borderColor: Color,
        borderHoverColor: Color
    ) {
        if (area != null) {
            if (area.contains(mousePosition.x.toDouble(), mousePosition.y.toDouble())) {
                graphics.color = borderHoverColor
            } else {
                graphics.color = borderColor
            }
            graphics.draw(area)
            graphics.color = fillColor
            graphics.fill(area)
        }
    }

    fun renderActorOverlayImage(
        graphics: Graphics2D,
        actor: Actor,
        image: BufferedImage,
        color: Color,
        zOffset: Int
    ) {
        val poly = actor.canvasTilePoly
        if (poly != null) {
            renderPolygon(graphics, poly, color)
        }
        val imageLocation = actor.getCanvasImageLocation(image, zOffset)
        if (imageLocation != null) {
            renderImageLocation(graphics, imageLocation, image)
        }
    }

    fun drawTiles(
        graphics: Graphics2D, point: WorldPoint,
        playerPoint: WorldPoint?, color: Color, strokeWidth: Int, outlineAlpha: Int, fillAlpha: Int
    ) {
        if (point.distanceTo(playerPoint) >= 32) {
            return
        }
        val lp = LocalPoint.fromWorld(Main.client, point) ?: return
        val poly = Perspective.getCanvasTilePoly(Main.client, lp) ?: return
        drawStrokeAndFillPoly(graphics, color, strokeWidth, outlineAlpha, fillAlpha, poly)
    }

    fun drawStrokeAndFillPoly(
        graphics: Graphics2D, color: Color, strokeWidth: Int,
        outlineAlpha: Int, fillAlpha: Int, poly: Polygon?
    ) {
        graphics.color = Color(color.red, color.green, color.blue, outlineAlpha)
        graphics.stroke = BasicStroke(strokeWidth.toFloat())
        graphics.draw(poly)
        graphics.color = Color(color.red, color.green, color.blue, fillAlpha)
        graphics.fill(poly)
    }

    fun renderPrayerOverlay(graphics: Graphics2D, prayer: Prayer, color: Color): Rectangle? {
        val widget = Main.client.getWidget(prayer.widgetInfo)
        if (widget == null || Main.client.getVarcIntValue(VarClientInt.INVENTORY_TAB.index) != InterfaceTab.PRAYER.id) {
            return null
        }
        val bounds = widget.bounds
        renderPolygon(graphics, rectangleToPolygon(bounds), color)
        return bounds
    }

    private fun rectangleToPolygon(rect: Rectangle): Polygon {
        val xpoints = intArrayOf(rect.x, rect.x + rect.width, rect.x + rect.width, rect.x)
        val ypoints = intArrayOf(rect.y, rect.y, rect.y + rect.height, rect.y + rect.height)
        return Polygon(xpoints, ypoints, 4)
    }
}