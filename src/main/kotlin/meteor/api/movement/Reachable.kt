package meteor.api.movement

import Main.client
import meteor.api.entities.Players
import meteor.api.game.GameThread.invokeLater
import meteor.api.scene.Tiles
import net.runelite.api.*
import net.runelite.api.coords.Direction
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.security.Security.getProvider
import java.util.*


object Reachable{
    fun check(flag: Int, checkFlag: Int): Boolean {
        return flag and checkFlag != 0
    }

    fun isObstacle(endFlag: Int): Boolean {
        return check(endFlag, 0x100 or 0x20000 or 0x200000 or 0x1000000)
    }

    fun isObstacle(worldPoint: WorldPoint?): Boolean {
        return isObstacle(getCollisionFlag(worldPoint))
    }

    fun getCollisionFlag(point: WorldPoint?): Int {
        val collisionMaps: Array<CollisionData> = client.getCollisionMaps() ?: return 0xFFFFFF
        val collisionData = collisionMaps[client.getPlane()] ?: return 0xFFFFFF
        val localPoint = LocalPoint.fromWorld(client, point) ?: return 0xFFFFFF
        return collisionData.flags[localPoint.sceneX][localPoint.sceneY]
    }
    fun isWalled(direction: Direction?, startFlag: Int): Boolean {
        return when (direction) {
            Direction.NORTH -> check(startFlag, 0x2)
            Direction.SOUTH -> check(startFlag, 0x20)
            Direction.WEST -> check(startFlag, 0x80)
            Direction.EAST -> check(startFlag, 0x8)
            else -> throw IllegalArgumentException()
        }
    }

    fun isWalled(source: WorldPoint, destination: WorldPoint): Boolean {
        return isWalled(Tiles.getAt(source)!!, Tiles.getAt(destination)!!)
    }

    fun isWalled(source: Tile, destination: Tile): Boolean {
        val wall: WallObject = source.getWallObject() ?: return false
        val a: WorldPoint = source.getWorldLocation()
        val b: WorldPoint = destination.getWorldLocation()
        return when (wall.orientationA) {
            1 -> a.dx(-1) == b || a.dx(-1).dy(1) == b || a.dx(-1).dy(-1) == b
            2 -> a.dy(1) == b || a.dx(-1).dy(1) == b || a.dx(1).dy(1) == b
            4 -> a.dx(1) == b || a.dx(1).dy(1) == b || a.dx(1).dy(-1) == b
            8 -> a.dy(-1) == b || a.dx(-1).dy(-1) == b || a.dx(-1).dy(1) == b
            else -> false
        }
    }

    fun hasDoor(source: WorldPoint, direction: Direction?): Boolean {
        val tile: Tile = Tiles.getAt(source) ?: return false
        return hasDoor(tile, direction)
    }

    fun hasDoor(source: Tile, direction: Direction?): Boolean {
        val wall: WallObject = source.getWallObject() ?: return false
        if (!wall.isDefinitionCached) {
            invokeLater { client.getObjectComposition(wall.id) }
        }
        return isWalled(direction, getCollisionFlag(source.getWorldLocation())) && wall.hasAction("Open", "Close")
    }

    fun isDoored(source: Tile, destination: Tile?): Boolean {
        val wall = source.wallObject ?: return false
        if (!wall.isDefinitionCached) {
            invokeLater { client.getObjectComposition(wall.id) }
        }
        return isWalled(source, destination!!) && wall.hasAction("Open")
    }

    fun canWalk(direction: Direction?, startFlag: Int, endFlag: Int): Boolean {
        return if (isObstacle(endFlag)) {
            false
        } else !isWalled(direction, startFlag)
    }

    fun getNeighbour(direction: Direction?, source: WorldPoint): WorldPoint? {
        return when (direction) {
            Direction.NORTH -> source.dy(1)
            Direction.SOUTH -> source.dy(-1)
            Direction.WEST -> source.dx(-1)
            Direction.EAST -> source.dx(1)
            else -> throw IllegalArgumentException()
        }
    }
    fun getNeighbours(
        current: WorldPoint,
        targetObject: Locatable?,
    ): List<WorldPoint> {
        val neighbours = mutableListOf<WorldPoint>()
        for (direction in Direction.values()) {
            val neighbour = getNeighbour(direction, current)

            // Check if object interactable
            if (targetObject != null
                && targetObject.worldLocation == neighbour
                && !isWalled(direction, getCollisionFlag(current))
            ) {
                if (neighbour != null) {
                    neighbours.add(neighbour)
                }
                continue
            }

            if (!canWalk(direction, getCollisionFlag(current), getCollisionFlag(neighbour))) {
                continue
            }

            if (neighbour != null) {
                neighbours.add(neighbour)
            }
        }

        return neighbours
    }
    fun getVisitedTiles(destination: WorldPoint, obj: Locatable? = null): List<WorldPoint> {
        val local = Players.local ?: return emptyList()
        val visited = mutableListOf<WorldPoint>()
        val queue = LinkedList<WorldPoint>()

        if (destination.distanceTo(local.worldLocation) > 30) {
            return visited
        }

        val loc = local.worldLocation ?: return visited

        if (loc.plane != destination.plane) {
            return visited
        }

        queue.add(loc)

        while (!queue.isEmpty()) {
            if (visited.size > 1000) {
                return visited
            }

            val current = queue.pop()
            visited.add(current)

            if (current == destination) {
                return visited
            }

            val neighbours = getNeighbours(current, obj)
                .filter { !visited.contains(it) && !queue.contains(it) }

            queue.addAll(neighbours)
        }

        return visited
    }

    fun isInteractable(obj: Locatable): Boolean {
        return getVisitedTiles(obj.worldLocation, obj)
            .contains(obj.worldLocation)
    }

    fun isWalkable(point: WorldPoint): Boolean {
        return getVisitedTiles(point)
            .contains(point)
    }




}