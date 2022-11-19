package meteor.plugins.cannonreloader

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.Range

@ConfigGroup("Cannon")
interface CannonReloaderConfig : Config {

    @ConfigItem(
        keyName = "minReloadAmount", name = "Minimum count for reload",
        description = "The minimum cannonball count when we want to reload", position = 1
    )
    @Range(
        min = 1,
        max = 30
    )
    fun minReloadAmount() : Int {
        return 9;
    }
    @ConfigItem(
        keyName = "maxReloadAmount", name = "Maximum count for reload",
        description = "The maximum cannonball count when we want to reload", position = 2
    )
    @Range(
        min = 1,
        max = 30
    )
    fun maxReloadAmount() : Int {
        return 14;
    }
}