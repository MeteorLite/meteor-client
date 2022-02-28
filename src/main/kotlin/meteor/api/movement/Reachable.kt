package meteor.api.movement

import Main
import meteor.api.game.GameThread.invokeLater
import meteor.api.scene.Tiles.getAt
import net.runelite.api.GameObject
import net.runelite.api.Locatable
import net.runelite.api.Tile
import net.runelite.api.WallObject
import net.runelite.api.coords.Direction
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

object Reachable {

    private val MAX_ATTEMPTED_TILES = 1000

    fun canWalk(direction: Direction?, startFlag: Int, endFlag: Int): Boolean {
        return if (isObstacle(endFlag)) {
            false
        } else !isWalled(direction, startFlag)!!
    }

    fun getNeighbour(direction: Direction?, source: WorldPoint): WorldPoint? {
        return when (direction) {
            Direction.NORTH -> source.dy(1)
            Direction.SOUTH -> source.dy(-1)
            Direction.WEST -> source.dx(-1)
            Direction.EAST -> source.dx(1)
            else -> null
        }
    }
    
    fun isWalled(direction: Direction?, startFlag: Int): Boolean? {
        return when (direction) {
            Direction.NORTH -> check(startFlag, 0x2)
            Direction.SOUTH -> check(startFlag, 0x20)
            Direction.WEST -> check(startFlag, 0x80)
            Direction.EAST -> check(startFlag, 0x8)
            else -> null
        }
    }

    fun isWalled(source: Tile, destination: Tile): Boolean {
        val wall = source.wallObject ?: return false
        val a = source.worldLocation
        val b = destination.worldLocation
        return when (wall.orientationA) {
            1 -> a.dx(-1) == b || a.dx(-1).dy(1) == b || a.dx(-1).dy(-1) == b
            2 -> a.dy(1) == b || a.dx(-1).dy(1) == b || a.dx(1).dy(1) == b
            4 -> a.dx(1) == b || a.dx(1).dy(1) == b || a.dx(1).dy(-1) == b
            8 -> a.dy(-1) == b || a.dx(-1).dy(-1) == b || a.dx(-1).dy(1) == b
            else -> false
        }
    }

    fun hasDoor(source: Tile, direction: Direction?): Boolean {
        val wall = source.wallObject ?: return false
        if (!wall.isDefinitionCached) {
            invokeLater { Main.client.getObjectComposition(wall.id) }
        }
        return isWalled(direction, getCollisionFlag(source.worldLocation)) == true && wall.hasAction("Open", "Close")
    }

    fun isDoored(source: Tile, destination: Tile): Boolean {
        val wall = source.wallObject ?: return false
        if (!wall.isDefinitionCached) {
            invokeLater { Main.client.getObjectComposition(wall.id) }
        }
        return isWalled(source, destination) && wall.hasAction("Open")
    }


    fun getVisitedTiles(destination: WorldPoint, targetObject: Locatable?): List<WorldPoint> {
        val local = Main.client.localPlayer
        // Don't check if too far away
        if (local == null || destination.distanceTo(local.worldLocation) > 35) {
            return emptyList()
        }
        val visitedTiles: MutableList<WorldPoint> = ArrayList()
        val queue = LinkedList<WorldPoint>()
        if (local.worldLocation.plane != destination.plane) {
            return visitedTiles
        }
        queue.add(local.worldLocation)
        while (!queue.isEmpty()) {
            // Stop if too many attempts, for performance
            if (visitedTiles.size > MAX_ATTEMPTED_TILES) {
                return visitedTiles
            }
            val current = queue.pop()
            visitedTiles.add(current)
            if (current == destination) {
                return visitedTiles
            }
            val neighbours = getNeighbours(current, targetObject)
                .stream().filter { x: WorldPoint ->
                    !visitedTiles.contains(x) && !queue.contains(
                        x
                    )
                }
                .collect(Collectors.toList())
            queue.addAll(neighbours)
        }
        return visitedTiles
    }

    fun isInteractable(locatable: Locatable): Boolean {
        return getVisitedTiles(locatable.worldLocation, locatable).contains(locatable.worldLocation)
    }

    fun isWalkable(worldPoint: WorldPoint): Boolean {
        return getVisitedTiles(worldPoint, null).contains(worldPoint)
    }


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
        val collisionMaps = Main.client.collisionMaps ?: return 0xFFFFFF
        val collisionData = collisionMaps[Main.client.plane] ?: return 0xFFFFFF
        val localPoint = LocalPoint.fromWorld(Main.client, point) ?: return 0xFFFFFF
        return collisionData.flags[localPoint.sceneX][localPoint.sceneY]
    }

    fun isWalled(source: WorldPoint?, destination: WorldPoint?): Boolean {
        return isWalled(getAt(source!!)!!, getAt(destination!!)!!)
    }

    fun hasDoor(source: WorldPoint?, direction: Direction?): Boolean {
        val tile = getAt(source!!) ?: return false
        return hasDoor(tile, direction)
    }

    fun getNeighbours(current: WorldPoint, targetObject: Locatable?): ArrayList<WorldPoint> {
        var out = ArrayList<WorldPoint>()
        for (dir in Direction.values()) {
            val neighbor = getNeighbour(dir, current)!!
            if (neighbor.isInScene(Main.client))
                continue

            if (targetObject != null) {
                val containsPoint: Boolean
                if (targetObject is GameObject) {
                    containsPoint = targetObject.worldArea.contains(neighbor);
                } else {
                    containsPoint = targetObject.worldLocation.equals(neighbor);
                }

                if (containsPoint
                    && (!isWalled(dir, getCollisionFlag(current))!! || targetObject is WallObject)) {
                    out.add(neighbor);
                    continue;
                }
            }

            if (!canWalk(dir, getCollisionFlag(current), getCollisionFlag(neighbor))) {
                continue;
            }

            out.add(neighbor);
        }
        return out;
    }
}