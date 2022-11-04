package meteor.plugins.exptracker

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup(value = "exptracker")
interface ExpTrackerConfig : Config {

    @ConfigItem(
        name = "notes",
        keyName = "notes",
        description = ""
    )
    fun getNotes(): String {
        return ""
    }
}