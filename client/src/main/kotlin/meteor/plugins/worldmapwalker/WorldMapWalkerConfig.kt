package meteor.plugins.worldmapwalker


import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("worldmap")
interface WorldMapWalkerConfig : Config {
    @ConfigItem(
        keyName = "shiftClickToWalk",
        name = "Shift click on map to walk",
        description = "Lets you walk to destinations with shift clicks"
    )
    fun shiftClickToWalk(): Boolean {
        return true
    }

    @ConfigItem(keyName = "showPaths", name = "Show walk path", description = "Highlights the walking path in game")
    fun showPaths(): Boolean {
        return true
    }
}