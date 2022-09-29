package meteor.plugins.autobankpin


import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.Secret

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