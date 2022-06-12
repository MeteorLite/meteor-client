package meteor.plugins.banksetups

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem

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