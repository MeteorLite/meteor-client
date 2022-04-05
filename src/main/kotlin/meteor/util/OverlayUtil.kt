package meteor.util

import meteor.Main
import net.runelite.api.Actor
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.TileObject
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
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


        val textLocation = tileObject.getCanvasTextLocation(graphics, text, 0)
        if (textLocation != null) {
            renderTextLocation(graphics, textLocation, text, color)
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
}