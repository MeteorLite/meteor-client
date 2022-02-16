package meteor.api.movement.pathfinder

import meteor.api.movement.Reachable
import meteor.api.scene.Tiles
import net.runelite.api.Tile
import net.runelite.api.coords.Direction
import net.runelite.api.coords.WorldPoint

class LocalCollisionMap : CollisionMap {
    override fun n(x: Int, y: Int, z: Int): Boolean {
        val current = WorldPoint(x, y, z)
        if (Reachable.isObstacle(current)) {
            return false
        }
        val currentTile: Tile? = Tiles.getAt(current)
        val destinationTile: Tile? = Tiles.getAt(current.dy(1))
        return if (currentTile != null && destinationTile != null && (Reachable.isDoored(
                currentTile,
                destinationTile
            ) || Reachable.isDoored(
                destinationTile,
                currentTile
            ))
        ) {
            !Reachable.isObstacle(destinationTile.worldLocation)
        } else Reachable.canWalk(
            Direction.NORTH,
            Reachable.getCollisionFlag(current),
            Reachable.getCollisionFlag(current.dy(1))
        )
    }

    override fun e(x: Int, y: Int, z: Int): Boolean {
        val current = WorldPoint(x, y, z)
        if (Reachable.isObstacle(current)) {
            return false
        }
        val currentTile: Tile? = Tiles.getAt(current)
        val destinationTile: Tile? = Tiles.getAt(current.dx(1))
        return if (currentTile != null && destinationTile != null && (Reachable.isDoored(
                currentTile,
                destinationTile
            ) || Reachable.isDoored(
                destinationTile,
                currentTile
            ))
        ) {
            !Reachable.isObstacle(destinationTile.worldLocation)
        } else Reachable.canWalk(
            Direction.EAST,
            Reachable.getCollisionFlag(current),
            Reachable.getCollisionFlag(current.dx(1))
        )
    }
}