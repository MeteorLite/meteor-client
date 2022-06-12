package meteor.plugins.objecthider

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.ConfigSection

@ConfigGroup("objecthider")
interface ObjectHiderConfig : Config {
    @ConfigItem(
        keyName = "objectIds",
        name = "Object IDs",
        description = "Configure hidden objects by id. Format: (id), (id)",
        position = 1,
        section = hideObjectsID
    )
    fun objectIds(): String {
        return ""
    }

    @ConfigItem(
        keyName = "objectNames",
        name = "Objects names",
        description = "Configure hidden objects by name. Format: (Tree), (Mom)",
        position = 3,
        section = hideObjectsName
    )
    fun objectNames(): String {
        return ""
    }

    @ConfigItem(
        keyName = "hideAllGameObjects",
        name = "Hide all game objects",
        description = "",
        position = 5,
        section = hideAllObjects
    )
    fun hideAllGameObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllDecorativeObjects",
        name = "Hide all decorative objects",
        description = "",
        position = 6,
        section = hideAllObjects
    )
    fun hideAllDecorativeObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllWallObjects",
        name = "Hide all wall objects",
        description = "",
        position = 7,
        section = hideAllObjects
    )
    fun hideAllWallObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllGroundObjects",
        name = "Hide all ground objects",
        description = "",
        position = 8,
        section = hideAllObjects
    )
    fun hideAllGroundObjects(): Boolean {
        return false
    }

    companion object {
        @ConfigSection(name = "Hide by ID", description = "Hide objects by ID", position = 0)
        const val hideObjectsID = "Hide by ID"

        @ConfigSection(name = "Hide by name", description = "Hide objects by name", position = 2)
        const val hideObjectsName = "Hide by name"

        @ConfigSection(name = "Hide all objects", description = "Hide all objects", position = 4)
        const val hideAllObjects = "Hide all objects"
    }
}