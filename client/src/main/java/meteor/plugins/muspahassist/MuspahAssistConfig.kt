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
        name = "Mage Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 3
    )
    fun mageOffensivePrayer(): MageOffensivePrayers {
        return MageOffensivePrayers.AUGURY
    }
    @ConfigItem(
        keyName = "smiteToggle",
        name = "Smite",
        description = "Toggles the option to use offensive prayers with Auto Prayer",
        position = 4
    )
    fun smiteToggle(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "rangeGearButton",
        name = "",
        description = "",
        position = 6,
        composePanel = true
    )
    fun rangeGearButton(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "RangeIDs",
        name = "Range Gear",
        description = "",
        textField = true,
        position = 7
    )
    fun RangeIDs(): String? {
        return ""
    }

    @ConfigItem(
        keyName = "mageGearButton",
        name = "",
        description = "",
        position = 8,
        composePanel = true
    )
    fun mageGearButton(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "MageIDs",
        name = "Mage Gear",
        description = "",
        textField = true,
        position = 9
    )
    fun MageIDs(): String? {
        return ""
    }
    @ConfigItem(
        keyName = "shieldGearButton",
        name = "",
        description = "",
        position = 10,
        composePanel = true
    )
    fun shieldGearButton(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "shieldIDs",
        name = "Shield Phase Gear",
        description = "",
        textField = true,
        position = 11
    )
    fun ShieldIDs(): String? {
        return ""
    }



    enum class RangeOffensivePrayers(val prayer: Prayer) {
        EAGLE_EYE(Prayer.EAGLE_EYE), RIGOUR(Prayer.RIGOUR);
    }

    enum class MageOffensivePrayers(val prayer: Prayer) {
        MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT), AUGURY(Prayer.AUGURY);
    }
}