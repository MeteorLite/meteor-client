package meteor.plugins.autobankpin


import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.Secret

@ConfigGroup("autobankpin")
interface AutoBankPinConfig : Config {
    @Secret
    @ConfigItem(
        keyName = "bankpin",
        name = "Bank Pin",
        description = "Bank pin that will be entered",
        textField = true,
        position = 0,
    )
    fun bankpin(): String {
        return ""
    }
}