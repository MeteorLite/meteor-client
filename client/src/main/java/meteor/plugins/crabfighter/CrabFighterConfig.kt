package meteor.plugins.crabfighter

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.plugins.crabfighter.CrabHome

@ConfigGroup("Crab Fighter")
interface CrabFighterConfig : Config {

    @ConfigItem(
        position = 0,
        keyName = "home",
        name = "Crab Home",
        description = "Select the area which you want crabs"
    )
    fun home(): CrabHome {
        return CrabHome.RELLEKA_NORTH
    }
}
