package meteor.api.coords

import meteor.api.coords.Area
import net.runelite.api.coords.WorldPoint
import java.awt.Polygon

class PolygonalArea(val plane: Int, vararg points: WorldPoint) : Area {

    private val polygon = Polygon()

    init {
        for (p in points) {
            polygon.addPoint(p.x, p.y)
        }
    }

    /**
     * Checks if polygon contains given point.
     */
    override operator fun contains(point: WorldPoint): Boolean {
        return polygon.contains(point.x, point.y)
    }
}
