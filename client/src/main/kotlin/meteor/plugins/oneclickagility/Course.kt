package meteor.plugins.oneclickagility

import meteor.Main
import net.runelite.api.*

open class Course internal constructor(var obstacleIDs: List<Int>, var obstacleAreaList: List<ObstacleArea>) {

    fun getCurrentObstacleArea(player: Player?): ObstacleArea? {
        if (player == null) return null
        for (area in obstacleAreaList) {
            if (area.containsObject(player)) {
                return area
            }
        }
        return null
    }

    open fun addObstacle(obstacle: TileObject) {
        for (area in obstacleAreaList) {
            if (obstacle.id == area.nextObstacleID) {
                area.nextObstacle = obstacle
                return
            }
        }
    }

    open fun removeObstacle(obstacle: TileObject) {
        for (area in obstacleAreaList) {
            if (obstacle.id == area.nextObstacleID) {
                area.nextObstacle = null
                return
            }
        }
    }
}