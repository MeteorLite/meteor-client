package meteor.api.movement.pathfinder

import net.runelite.api.coords.WorldPoint
import java.util.HashMap
import java.lang.AssertionError

class CoordMap {
    private val regions = arrayOfNulls<ByteArray>(256 * 256)
    private val custom: MutableMap<WorldPoint, WorldPoint> = HashMap()
    fun containsKey(key: WorldPoint): Boolean {
        return region(key)!![index(key)].toInt() != 0
    }

    operator fun get(key: WorldPoint): WorldPoint? {
        val code = region(key)!![index(key)]
        return when (code) {
            NONE -> null
            CUSTOM -> custom[key]!!
            N -> key.dy(1)
            NE -> key.dx(1).dy(1)
            E -> key.dx(1)
            SE -> key.dx(1).dy(-1)
            S -> key.dy(-1)
            SW -> key.dx(-1).dy(-1)
            W -> key.dx(-1)
            NW -> key.dx(-1).dy(1)
            else -> throw AssertionError()
        }
    }

    fun put(key: WorldPoint, value: WorldPoint?) {
        region(key)!![index(key)] = CUSTOM
        custom[key] = value!!
    }

    fun putN(key: WorldPoint) {
        region(key)!![index(key)] = N
    }

    fun putNE(key: WorldPoint) {
        region(key)!![index(key)] = NE
    }

    fun putE(key: WorldPoint) {
        region(key)!![index(key)] = E
    }

    fun putSE(key: WorldPoint) {
        region(key)!![index(key)] = SE
    }

    fun putS(key: WorldPoint) {
        region(key)!![index(key)] = S
    }

    fun putSW(key: WorldPoint) {
        region(key)!![index(key)] = SW
    }

    fun putW(key: WorldPoint) {
        region(key)!![index(key)] = W
    }

    fun putNW(key: WorldPoint) {
        region(key)!![index(key)] = NW
    }

    private fun index(WorldPoint: WorldPoint): Int {
        return WorldPoint.x % 64 + WorldPoint.y % 64 * 64 + WorldPoint.plane % 64 * 64 * 64
    }

    private fun region(WorldPoint: WorldPoint): ByteArray? {
        val regionIndex = WorldPoint.x / 64 * 256 + WorldPoint.y / 64
        var region = regions[regionIndex]
        if (region == null) {
            regions[regionIndex] = ByteArray(4 * 64 * 64)
            region = regions[regionIndex]
        }
        return region
    }

    companion object {
        const val NONE: Byte = 0
        const val CUSTOM: Byte = 1
        const val N: Byte = 2
        const val NE: Byte = 3
        const val E: Byte = 4
        const val SE: Byte = 5
        const val S: Byte = 6
        const val SW: Byte = 7
        const val W: Byte = 8
        const val NW: Byte = 9
    }
}