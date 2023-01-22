package meteor.plugins.oneclickagility

import dev.hoot.api.game.Game
import meteor.Main.client
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint

class ObstacleArea internal constructor(
    private val minX: Int,
    private val maxX: Int,
    private val minY: Int,
    private val maxY: Int,
    private val z: Int,
    val nextObstacleID: Int
) {
   var nextObstacle: TileObject? = null
    fun containsObject(locatable: Locatable): Boolean {
        return containsObject(locatable.worldLocation)
    }

    fun containsObject(worldPoint: WorldPoint): Boolean {
        return containsObject(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    private fun containsObject(x: Int, y: Int, z: Int): Boolean {
        return x in minX..maxX && y >= minY && y <= maxY && z == this.z
    }

    fun createMenuEntry(): MenuEntry? {
        return if (nextObstacle != null) {
            if (nextObstacle!!.distanceTo(Game.getClient().localPlayer!!.worldLocation) < 1) null else client.createMenuEntry(
                nextObstacle!!.rawActions!![0],
                nextObstacle!!.name,
                nextObstacle!!.id,
                MenuAction.GAME_OBJECT_FIRST_OPTION.id,
                getObjectParam(nextObstacle!!),
                getObjectParam1(nextObstacle!!),
                true
            )
        } else null
    }

    private fun getObjectParam(gameObject: Locatable): Int {
        return if (gameObject is GameObject) {
            gameObject.sceneMinLocation.x
        } else gameObject.localLocation.sceneX
    }

    private fun getObjectParam1(gameObject: Locatable): Int {
        return if (gameObject is GameObject) {
            gameObject.sceneMinLocation.y
        } else gameObject.localLocation.sceneY
    }
}