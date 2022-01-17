package meteor.util

import net.runelite.api.Actor
import net.runelite.api.Point
import net.runelite.api.TileObject
import java.awt.*

object OverlayUtil {
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
}