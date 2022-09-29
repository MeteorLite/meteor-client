package meteor.plugins.banksetups

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("Bank Setups")
interface BankSetupConfig : Config {

    @ConfigItem(
        keyName = "Bank Setup Name",
        name = "Bank Setup Name",
        description = "sets the value of new setup"

    )
    fun setupName(): String {
        return "New set"
    }
}