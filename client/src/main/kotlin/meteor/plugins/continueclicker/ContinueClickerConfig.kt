package meteor.plugins.continueclicker

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem


@ConfigGroup("ContinueClicker")
interface ContinueClickerConfig : Config {
    @ConfigItem(
        keyName = "continueChat",
        name = "Continue all chats",
        description = "Progress through all click here to continue... chats",
        position = 0
    )
    fun continueChat(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "questHelper",
        name = "Select Quest Helper options",
        description = "Enable to auto select highlighted quest helper options",
        position = 5
    )
    fun questHelper(): Boolean {
        return true
    }
}