package meteor.plugins.autoeater

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("autoeater")
interface AutoEaterConfig : Config {
    @ConfigItem(keyName = "minHp", name = "Minimum hp", description = "Minimum health to eat at", position = 1, textField = true)
    fun minHp(): Int {
        return 25
    }

    @ConfigItem(keyName = "maxHp", name = "Maximum hp", description = "Maximum health to eat at", position = 2, textField = true)
    fun maxHp(): Int {
        return 50
    }

    @ConfigItem(keyName = "foodNamesToEat", name = "Food name(s)", description = "Food name(s) seperated by comma", position = 3, textField = true)
    fun foodNamesToEat(): String {
        return "Lobster,Salmon"
    }

    @ConfigItem(keyName = "foodIdsToEat", name = "Food id(s)", description = "Food id(s) seperated by comma", position = 4, textField = true)
    fun foodIdsToEat(): String {
        return "1891,1893,1895"
    }
}