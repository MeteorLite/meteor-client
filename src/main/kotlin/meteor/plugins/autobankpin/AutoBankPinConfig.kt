package meteor.plugins.autobankpin


import meteor.config.Config
import meteor.config.ConfigAnnotations.*

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