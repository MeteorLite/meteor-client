package meteor.plugins.oneclicksandstone

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem


@ConfigGroup("oneclicsandstone")
interface OneClickSandstoneConfig : Config {
    @ConfigItem(
        position = 0,
        keyName = "forceMineNorth",
        name = "North Rocks Only?",
        description = "Will only mine the rocks at the north that people normally mine otherwise will mine the nearest rock at all times."
    )
    fun forceMineNorth(): Boolean {
        return true
    }

    @ConfigItem(position = 1, keyName = "humidify", name = "Cast Humidify", description = "Cast Humidify")
    fun humidify(): Boolean {
        return true
    }
}