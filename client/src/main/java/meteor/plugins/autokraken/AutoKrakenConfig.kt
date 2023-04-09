package meteor.plugins.autokraken

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("autokraken")
interface AutoKrakenConfig: Config {
    @ConfigItem(
        keyName = "loot",
        name = "Loots",
        description = "What to loot",
        position = 0,
    )
    fun loot(): String {
        return "Kraken tentacle,Shark,Raw shark,Raw monkfish"
    }

    @ConfigItem(
        keyName = "food",
        name = "Food",
        description = "What to eat.",
        position = 1,
    )
    fun food(): String {
        return "Shark"
    }

    @ConfigItem(
        keyName = "healthMin",
        name = "Minimum health",
        description = "",
        position = 2,
    )
    fun healthMin(): Int {
        return 50
    }

    @ConfigItem(
        keyName = "healthMax",
        name = "Maximum health",
        description = "",
        position = 3,
    )
    fun healthMax(): Int {
        return 70
    }
}