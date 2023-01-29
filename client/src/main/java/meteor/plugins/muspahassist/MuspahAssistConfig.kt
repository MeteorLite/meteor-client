package meteor.plugins.muspahassist

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.plugins.alchemicalhydra.HydraConfig
import net.runelite.api.Prayer

@ConfigGroup("muspahassist")
interface MuspahAssistConfig : Config {

    @ConfigItem(
        keyName = "rangeOnly",
        name = "Range Only",
        description = "Toggle this if you only plan to use range",
        position = 0
    )
    fun rangeOnly(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "offensivePrayerToggle",
        name = "Offensive Prayer",
        description = "Toggles the option to use offensive prayers with Auto Prayer",
        position = 1
    )
    fun offensivePrayerToggle(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "rangeOffensivePrayer",
        name = "Range Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 2
    )
    fun rangeOffensivePrayer(): RangeOffensivePrayers {
        return RangeOffensivePrayers.RIGOUR
    }
    @ConfigItem(
        keyName = "mageOffensivePrayer",
        name = "Range Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 3
    )
    fun mageOffensivePrayer(): MageOffensivePrayers {
        return MageOffensivePrayers.AUGURY
    }
    @ConfigItem(
        keyName = "offensivePrayerToggle",
        name = "Smite",
        description = "Toggles the option to use offensive prayers with Auto Prayer",
        position = 4
    )
    fun smiteToggle(): Boolean {
        return false
    }

    enum class RangeOffensivePrayers(val prayer: Prayer) {
        EAGLE_EYE(Prayer.EAGLE_EYE), RIGOUR(Prayer.RIGOUR);
    }

    enum class MageOffensivePrayers(val prayer: Prayer) {
        MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT), AUGURY(Prayer.AUGURY);
    }
}