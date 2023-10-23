package meteor.plugins.devtools


import androidx.compose.ui.unit.LayoutDirection
import meteor.Configuration
import meteor.config.legacy.*
import meteor.ui.components.ComponentConstants
import java.awt.BorderLayout
import java.awt.Color

@ConfigGroup(Configuration.MASTER_GROUP)
interface DevToolsConfig : Config {

    @ConfigItem(
            keyName = "location",
            name = "Location",
            description = "",
            position = 0
    )
    fun location(): Boolean {
        return false
    }

    @ConfigItem(
            name = "Camera",
            keyName = "camera",
            description = "",
            position = 1,
    )
    fun camera(): Boolean {
        return false
    }

    @ConfigItem(
            name = "Game Objects",
            keyName = "gameObjects",
            description = "",
            position = 2,
    )
    fun gameObjects(): Boolean {
        return false
    }

    @ConfigItem(
            name = "Wall Objects",
            keyName = "wallObjects",
            description = "",
            position = 2,
    )
    fun wallObjects(): Boolean {
        return false
    }

}
