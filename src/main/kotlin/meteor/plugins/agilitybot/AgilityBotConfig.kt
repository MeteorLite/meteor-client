package meteor.plugins.agilitybot

import meteor.config.Config
import meteor.config.ConfigAnnotations.ConfigGroup
import meteor.config.ConfigAnnotations.ConfigItem

@ConfigGroup("AgilityBot")
interface AgilityBotConfig : Config {
    @ConfigItem(name = "Course", keyName = "course", description = "Course to complete")
    fun course(): Course? {
        return Course.NEAREST
    }
}