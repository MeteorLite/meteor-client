package meteor.plugins.oneclickchins

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("oneclickchins")
interface Oneclickchinsconfig : Config {
    @ConfigItem(
        keyName = "playerspotted",
        name = "AFK if player visible",
        description = "Consumes all clicks if another player is spotted. Idk if this is even needed. This may cause problems if people are doing agility course. needs to be tested",
        position = 0
    )
    fun playerspotted(): Boolean {
        return false
    }
}