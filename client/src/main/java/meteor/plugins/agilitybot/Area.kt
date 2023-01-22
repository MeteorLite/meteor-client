package meteor.plugins.agilitybot

import net.runelite.api.Locatable

class Area(val start: Location, val end: Location, val plane: Int = 0) {
    private val tiles: MutableList<Location>

    init {
        tiles = ArrayList()
        val startX = start.x
        val startY = start.y
        val endX = end.x
        val endY = end.y
        for (x in startX.coerceAtMost(endX)..startX.coerceAtLeast(endX)) {
            for (y in startY.coerceAtLeast(endY) downTo startY.coerceAtMost(endY)) {
                tiles.add(Location(x, y, plane))
            }
        }
    }

    constructor(minX: Int, minY: Int, maxX: Int, maxY: Int, floorLevel: Int = 0) : this(
        Location(minX, minY),
        Location(maxX, maxY),
        floorLevel
    )

    val locations: List<Location>
        get() = tiles
    val width: Int
        get() = 1 + start.x.coerceAtLeast(end.x) - start.x.coerceAtMost(end.x)
    val height: Int
        get() = 1 + start.y.coerceAtLeast(end.y) - start.y.coerceAtMost(end.y)

    operator fun contains(l: Locatable): Boolean {
        val location = l.worldLocation
        val var3: Iterator<*> = locations.iterator()
        var tile: Location
        do {
            if (!var3.hasNext()) {
                return false
            }
            tile = var3.next() as Location
        } while (location != tile.toWorldPoint())
        return true
    }

    val center: Location
        get() {
            val tiles = locations
            var x = 0
            var y = 0
            var t: Location
            val var4: Iterator<*> = tiles.iterator()
            while (var4.hasNext()) {
                t = var4.next() as Location
                x += t.x
                y += t.y
            }
            x /= tiles.size
            y /= tiles.size
            return Location(x, y)
        }
}