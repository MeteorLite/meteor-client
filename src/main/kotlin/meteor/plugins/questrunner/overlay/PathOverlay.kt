package meteor.plugins.questrunner.overlay

import meteor.api.entities.Players
import meteor.api.movement.pathfinder.Walker
import meteor.plugins.questrunner.QuestRunnerPlugin
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import net.runelite.api.Perspective
import net.runelite.api.Player
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.GeneralPath
import java.awt.geom.Path2D
import java.util.ArrayList
import java.util.concurrent.ExecutionException

class PathOverlay(val plugin: QuestRunnerPlugin) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        priority = OverlayPriority.HIGHEST
    }

    private fun renderPath(graphics: Graphics2D, path: List<WorldPoint?>, startIndex: Int) {
        val pathToDraw: ArrayList<LocalPoint> = ArrayList<LocalPoint>(path.size - startIndex)
        for (i in startIndex until path.size) {
            LocalPoint.fromWorld(client, path[i])?.also { pathToDraw.add(it) }
        }
        val generalPath = GeneralPath(Path2D.WIND_EVEN_ODD, pathToDraw.size)
        for (currentTile in pathToDraw) {
            val pathPoint: Point? = Perspective.localToCanvas(client, currentTile, client.plane)
            if (pathPoint == null) {
                graphics.color = Color.CYAN
                graphics.draw(generalPath)
                generalPath.reset()
            } else {
                if (generalPath.currentPoint == null) {
                    generalPath.moveTo(pathPoint.x.toFloat(), pathPoint.y.toFloat())
                } else {
                    generalPath.lineTo(pathPoint.x.toFloat(), pathPoint.y.toFloat())
                }
            }
        }
        if (generalPath.currentPoint != null) {
            graphics.color = Color.CYAN
            graphics.draw(generalPath)
        }
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (QuestRunnerPlugin.walkTarget == null) {
            return null
        }
        val path: List<WorldPoint?> = try {
            Walker.PATH_CACHE.get(QuestRunnerPlugin.walkTarget!!)
        } catch (e: ExecutionException) {
            Walker.buildPath(QuestRunnerPlugin.walkTarget!!, false)
        }
        if (path.isEmpty()) {
            return null
        }
        val player: Player = Players.local
        var minDist: Int = path[0]!!.distanceTo(player)
        var index = 0
        for (i in 1 until path.size) {
            val dist: Int = path[i]!!.distanceTo(player)
            if (dist == 0) {
                index = i
                minDist = 0
                break
            }
            if (dist < minDist) {
                index = i
                minDist = dist
            }
        }
        if (index > 0) {
            index--
        }

        renderPath(graphics, path, index)
        QuestRunnerPlugin.walkTarget!!.outline(client, graphics, Color.GREEN, "Destination")
        return null
    }
}