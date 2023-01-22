package meteor.plugins.agilitybot

import net.runelite.api.coords.WorldPoint

class Location(val x: Int, val y: Int, val z: Int = 0) {

    fun toWorldPoint(): WorldPoint {
        return WorldPoint(x, y, z)
    }
}