package meteor.api.movement.pathfinder

import net.runelite.api.coords.WorldPoint

interface CollisionMap {
    fun n(x: Int, y: Int, z: Int): Boolean
    fun e(x: Int, y: Int, z: Int): Boolean
    fun s(x: Int, y: Int, z: Int): Boolean {
        return n(x, y - 1, z)
    }

    fun w(x: Int, y: Int, z: Int): Boolean {
        return e(x - 1, y, z)
    }

    fun ne(x: Int, y: Int, z: Int): Boolean {
        return n(x, y, z) && e(x, y + 1, z) && e(x, y, z) && n(x + 1, y, z)
    }

    fun nw(x: Int, y: Int, z: Int): Boolean {
        return n(x, y, z) && w(x, y + 1, z) && w(x, y, z) && n(x - 1, y, z)
    }

    fun se(x: Int, y: Int, z: Int): Boolean {
        return s(x, y, z) && e(x, y - 1, z) && e(x, y, z) && s(x + 1, y, z)
    }

    fun sw(x: Int, y: Int, z: Int): Boolean {
        return s(x, y, z) && w(x, y - 1, z) && w(x, y, z) && s(x - 1, y, z)
    }

    fun n(worldPoint: WorldPoint): Boolean {
        return n(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun s(worldPoint: WorldPoint): Boolean {
        return s(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun w(worldPoint: WorldPoint): Boolean {
        return w(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun e(worldPoint: WorldPoint): Boolean {
        return e(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun ne(worldPoint: WorldPoint): Boolean {
        return ne(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun nw(worldPoint: WorldPoint): Boolean {
        return nw(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun se(worldPoint: WorldPoint): Boolean {
        return se(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun sw(worldPoint: WorldPoint): Boolean {
        return sw(worldPoint.x, worldPoint.y, worldPoint.plane)
    }
}