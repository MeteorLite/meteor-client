package meteor.plugins.hiscore

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup(value = "hiscore")
interface HiscoreConfig : Config {

    @ConfigItem(
        name = "Username",
        keyName = "username",
        description = ""
    )
    fun username(): String {
        return "Open0SRS"
    }
}