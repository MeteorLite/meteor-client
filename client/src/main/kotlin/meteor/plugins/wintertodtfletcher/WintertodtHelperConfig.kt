package meteor.plugins.wintertodtfletcher

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.Range

@ConfigGroup("wintertodthelper")
interface WintertodtHelperConfig : Config {
    @Range(min = 5, max = 89)
    @ConfigItem(
        position = 1,
        keyName = "healAt",
        name = "Heal at",
        description = "Automatically eat any available food when health hits this value"
    )
    fun healAt(): Int {
        return 7
    }
}