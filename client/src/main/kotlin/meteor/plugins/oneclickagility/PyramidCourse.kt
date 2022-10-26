package meteor.plugins.oneclickagility

import net.runelite.api.TileObject

class PyramidCourse internal constructor(obstacleIDs: List<Int>, obstacleAreaList: List<ObstacleArea>) :
    Course(obstacleIDs, obstacleAreaList) {
    override fun addObstacle(obstacle: TileObject) {
        for (area in obstacleAreaList) {
            if (obstacle.id == area.nextObstacleID && area.containsObject(obstacle)) {
                area.nextObstacle = obstacle
                return
            }
        }
    }

    override fun removeObstacle(obstacle: TileObject) {
        for (area in obstacleAreaList) {
            if (obstacle.id == area.nextObstacleID && area.containsObject(obstacle)) {
                area.nextObstacle = null
                return
            }
        }
    }
}