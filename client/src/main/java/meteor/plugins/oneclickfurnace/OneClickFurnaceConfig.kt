package meteor.plugins.oneclickfurnace

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("oneclickfurnace")
interface OneClickFurnaceConfig : Config {
    @ConfigItem(
        position = 0,
        keyName = "method",
        name = "Crafting Method",
        description = "Choose what you want to craft"
    )
    fun method(): CraftingMethods {
        return CraftingMethods.CannonBalls
    }

    @ConfigItem(
        position = 1,
        keyName = "consumeClicks",
        name = "Consume Clicks",
        description = "Consume clicks while moving/crafting"
    )
    fun consumeClicks(): Boolean {
        return true
    }
}