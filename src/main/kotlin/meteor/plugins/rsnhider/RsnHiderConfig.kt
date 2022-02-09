package meteor.plugins.rsnhider

import meteor.config.ConfigAnnotations.*
import meteor.config.Config

@ConfigGroup("rsnhider")
interface RsnHiderConfig : Config {
    @ConfigItem(
        name = "Hide in widgets (Lag warning)",
        keyName = "hideWidgets",
        description = "Hides your RSN everywhere. Might lag your game."
    )
    fun hideWidgets(): Boolean {
        return false
    }

    @ConfigItem(name = "Custom rsn", keyName = "customRsn", description = "Use a custom rsn instead of a random rsn")
    fun customRsn(): String {
        return ""
    }
}