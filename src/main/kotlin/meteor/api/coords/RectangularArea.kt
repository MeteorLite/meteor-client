package meteor.api.coords

import meteor.api.commons.Rand
import meteor.api.coords.Area
import net.runelite.api.coords.WorldPoint

data class RectangularArea(val x1: Int, val y1: Int, val x2: Int, val y2: Int, val plane: Int) : Area {

    var minX = 0
    var maxX = 0
    var minY = 0
    var maxY = 0

    init {
        if (x1 <= x2) {
            minX = x1
            maxX = x2
        } else {
            minX = x2
            maxX = x1
        }

        if (y1 <= y2) {
            minY = y1
            maxY = y2
        } else {
            minY = y2
            maxY = y1
        }
    }

    constructor(x1: Int, x2: Int, y1: Int, y2: Int) : this(x1, x2, y1, y2, 0)

    /**
     * Checks if rectangular area contains given point.
     */
    override operator fun contains(point: WorldPoint): Boolean {
        if (point.plane == -1 || point.plane != plane) {
            return false
        }

        val x = point.x
        val y = point.y
        return x >= minX && y >= minY && x <= maxX && y <= maxY
    }

    fun getNearestTile(from: WorldPoint): WorldPoint {
        val x: Int = if (from.x <= minX) {
            minX
        } else if (from.x >= maxX) {
            maxX
        } else {
            from.x
        }
        val y: Int = if (from.y <= minY) {
            minY
        } else if (from.y >= maxY) {
            maxY
        } else {
            from.y
        }

        return WorldPoint(x, y, plane)
    }

    fun getRandomTile(): WorldPoint {
        return WorldPoint(Rand.nextInt(minX, maxX), Rand.nextInt(minY, maxY), plane)
    }

    fun getCenter(): WorldPoint {
        return WorldPoint((minX + maxX) / 2, (minY + maxY) / 2, plane)
    }
}
