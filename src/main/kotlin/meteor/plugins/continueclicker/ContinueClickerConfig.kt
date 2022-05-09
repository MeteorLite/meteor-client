package meteor.plugins.continueclicker

import net.runelite.client.config.*


@ConfigGroup("ContinueClicker")
interface ContinueClickerConfig : Config {
    @ConfigItem(keyName = "continueChat",
        name = "Continue all chats",
        description = "Progress through all click here to continue... chats",
        position = 0)
    fun continueChat(): Boolean {
        return true
    }

    @ConfigItem(keyName = "questHelper",
        name = "Select Quest Helper options",
        description = "Enable to auto select highlighted quest helper options",
        position = 5)
    fun questHelper(): Boolean {
        return true
    }
}