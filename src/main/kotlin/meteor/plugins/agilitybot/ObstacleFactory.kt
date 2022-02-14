package meteor.plugins.agilitybot

import meteor.config.ConfigManager.getConfig
import kotlin.jvm.JvmOverloads
import net.runelite.api.coords.WorldPoint
import meteor.plugins.agilitybot.ObstacleFactory
import net.runelite.api.TileObject
import meteor.plugins.agilitybot.Course
import meteor.plugins.PluginDescriptor
import meteor.config.ConfigManager
import java.util.ArrayList

class ObstacleFactory {
    private val obstacles: MutableList<Obstacle> = ArrayList()
    fun append(area: Area, name: String, action: String, tile: Location?): ObstacleFactory {
        val obs = Obstacle(area, name, action, tile)
        obstacles.add(obs)
        return this
    }

    fun append(area: Area, name: String, action: String, id: Int): ObstacleFactory {
        val obs = Obstacle(area, name, action, false, null, id)
        obstacles.add(obs)
        return this
    }

    fun append(area: Area, name: String, action: String): ObstacleFactory {
        val obs = Obstacle(area, name, action)
        obstacles.add(obs)
        return this
    }

    fun array(): Array<Obstacle> {
        return obstacles.toTypedArray()
    }

    companion object {
        fun newInstance(bool: Boolean): ObstacleFactory {
            return ObstacleFactory()
        }
    }
}