package meteor.plugins.agilitybot

import meteor.config.ConfigManager.getConfig
import kotlin.jvm.JvmOverloads
import net.runelite.api.coords.WorldPoint
import meteor.plugins.agilitybot.ObstacleFactory
import net.runelite.api.TileObject
import meteor.plugins.agilitybot.Course
import meteor.plugins.PluginDescriptor
import meteor.config.ConfigManager

class Location @JvmOverloads constructor(val x: Int, val y: Int, val z: Int = 0) {

    fun toWorldPoint(): WorldPoint {
        return WorldPoint(x, y, z)
    }
}