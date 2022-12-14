package meteor.plugins.objecthider

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ConfigSection

@ConfigGroup("objecthider")
interface ObjectHiderConfig : Config {
    @ConfigItem(
        keyName = "objectIds",
        name = "Object IDs",
        description = "Configure hidden objects by id. Format: (id), (id)",
        position = 1,
        section = "Hide by ID"
    )
    fun objectIds(): String {
        return ""
    }

    @ConfigItem(
        keyName = "objectNames",
        name = "Objects names",
        description = "Configure hidden objects by name. Format: (Tree), (Mom)",
        position = 3,
        section = "Hide by name"
    )
    fun objectNames(): String {
        return ""
    }

    @ConfigItem(
        keyName = "hideAllGameObjects",
        name = "Hide all game objects",
        description = "",
        position = 5,
        section = "Hide all objects"
    )
    fun hideAllGameObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllDecorativeObjects",
        name = "Hide all decorative objects",
        description = "",
        position = 6,
        section = "Hide all objects"
    )
    fun hideAllDecorativeObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllWallObjects",
        name = "Hide all wall objects",
        description = "",
        position = 7,
        section = "Hide all objects"
    )
    fun hideAllWallObjects(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideAllGroundObjects",
        name = "Hide all ground objects",
        description = "",
        position = 8,
        section = "Hide all objects"
    )
    fun hideAllGroundObjects(): Boolean {
        return false
    }

    @ConfigSection(name = "Hide by ID", description = "Hide objects by ID", position = 0)
    val hideObjectsID: String

    @ConfigSection(name = "Hide by name", description = "Hide objects by name", position = 2)
    val hideObjectsName: String

    @ConfigSection(name = "Hide all objects", description = "Hide all objects", position = 4)
    val hideAllObjects: String

}