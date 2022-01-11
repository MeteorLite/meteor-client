package meteor.util

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
}