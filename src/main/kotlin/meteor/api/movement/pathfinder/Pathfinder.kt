package meteor.api.movement.pathfinder

import meteor.api.movement.Reachable
import net.runelite.api.coords.WorldPoint
import java.util.*
import java.util.ArrayDeque

class Pathfinder(val collisionMap: CollisionMap, val transportCoords: Map<WorldPoint, List<Transport>>, val startCoords: List<WorldPoint>,
                 val destination: WorldPoint) {
    private val boundary: Deque<WorldPoint> = ArrayDeque()
    private val predecessors = CoordMap()
    private var nearest: WorldPoint? = null
    fun find(): List<WorldPoint> {
        boundary.addAll(startCoords)
        var bestDistance = 6942069f
        for (start in startCoords) {
            predecessors.put(start, null)
        }
        while (!boundary.isEmpty()) {
            var current: WorldPoint? = boundary.removeFirst()
            if (current == destination) {
                val result: LinkedList<WorldPoint> = LinkedList<WorldPoint>()
                while (current != null) {
                    result.add(0, current)
                    current = predecessors[current]
                }
                return result
            }
            val distance: Float = current!!.distanceToHypotenuse(destination)
            if (nearest == null || distance < bestDistance) {
                nearest = current
                bestDistance = distance
            }
            try {
                if (distance == bestDistance && distance == 1f && !Reachable.isWalled(current, destination)) {
                    nearest = current
                }
            } catch (e: NullPointerException) {
                Walker.LOCAL_PATH_CACHE.refresh(destination)
                Walker.PATH_CACHE.refresh(destination)
            }
            if ((destination.isInScene(Main.client)
                        && Reachable.isObstacle(destination) && boundary.size > 200) || boundary.size > 1000
            ) {
                break
            }
            addNeighbours(current)
        }
        if (nearest != null) {
            val result: LinkedList<WorldPoint> = LinkedList<WorldPoint>()
            var node: WorldPoint? = nearest
            while (node != null) {
                result.add(0, node)
                node = predecessors[node]
            }
            return result
        }
        return emptyList<WorldPoint>()
    }

    private fun addNeighbours(position: WorldPoint) {
        for (transport in transportCoords[position] ?: ArrayList()) {
            if (predecessors.containsKey(transport.destination)) {
                continue
            }
            predecessors.put(transport.destination, position)
            boundary.addLast(transport.destination)
        }
        if (collisionMap.w(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(-1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putE(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.e(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putW(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.s(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dy(-1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putN(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.n(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dy(1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putS(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.sw(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(-1).dy(-1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putNE(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.se(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(1).dy(-1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putNW(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.nw(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(-1).dy(1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putSE(neighbor)
                boundary.addLast(neighbor)
            }
        }
        if (collisionMap.ne(position.x, position.y, position.plane)) {
            val neighbor: WorldPoint = position.dx(1).dy(1)
            if (!predecessors.containsKey(neighbor)) {
                predecessors.putSW(neighbor)
                boundary.addLast(neighbor)
            }
        }
    }
}