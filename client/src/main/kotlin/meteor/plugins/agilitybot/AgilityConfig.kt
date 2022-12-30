package meteor.plugins.agilitybot

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("agilitybot")
interface AgilityConfig : Config {
    @ConfigItem(name = "Course", keyName = "course", description = "Course to complete")
    fun course(): Course? {
        return Course.NEAREST
    }
}