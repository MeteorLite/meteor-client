package meteor.plugins.agilitybot

import meteor.config.ConfigManager.getConfig
import kotlin.jvm.JvmOverloads
import net.runelite.api.coords.WorldPoint
import meteor.plugins.agilitybot.ObstacleFactory
import net.runelite.api.TileObject
import meteor.plugins.agilitybot.Course
import meteor.plugins.PluginDescriptor
import meteor.config.ConfigManager
import net.runelite.api.Locatable
import java.util.ArrayList
import kotlin.math.max
import kotlin.math.min

class Area @JvmOverloads constructor(val start: Location, val end: Location, val plane: Int = 0) {
    private val tiles: MutableList<Location>

    init {
        tiles = ArrayList()
        val startX = start.x
        val startY = start.y
        val endX = end.x
        val endY = end.y
        for (x in min(startX, endX)..max(startX, endX)) {
            for (y in max(startY, endY) downTo min(startY, endY)) {
                tiles.add(Location(x, y, plane))
            }
        }
    }

    @JvmOverloads
    constructor(minX: Int, minY: Int, maxX: Int, maxY: Int, floorLevel: Int = 0) : this(
        Location(minX, minY),
        Location(maxX, maxY),
        floorLevel
    ) {
    }

    val locations: List<Location>
        get() = tiles
    val width: Int
        get() = 1 + max(start.x, end.x) - min(start.x, end.x)
    val height: Int
        get() = 1 + max(start.y, end.y) - min(start.y, end.y)

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