package meteor.plugins.oneclick3tfish

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("oneclick3tfish")
interface OneClick3TFishConfig : Config {
    @ConfigItem(position = 0, keyName = "manipType", name = "Tick Manip type", description = "")
    fun manipType(): TickMethod {
        return TickMethod.HERB_TAR
    }

    @ConfigItem(
        position = 1,
        keyName = "flavorText",
        name = "Menu Entry Text",
        description = "Change the menu entry to show what action it will perform"
    )
    fun flavorText(): Boolean {
        return false
    }

    @ConfigItem(
        position = 2,
        keyName = "clickAnywhere",
        name = "Click Anywhere",
        description = "Enable this if you dont want to manually click on the spot"
    )
    fun clickAnywhere(): Boolean {
        return false
    }

    @ConfigItem(
        position = 3,
        keyName = "dropFish",
        name = "Drop Fish",
        description = "Drop fish if you click right after tick manipulating"
    )
    fun dropFish(): Boolean {
        return true
    }
}