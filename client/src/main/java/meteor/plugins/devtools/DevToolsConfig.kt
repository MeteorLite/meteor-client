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
            name = "Models",
            keyName = "models",
            description = "",
            position = 2,
    )
    fun models(): Boolean {
        return false
    }

}
