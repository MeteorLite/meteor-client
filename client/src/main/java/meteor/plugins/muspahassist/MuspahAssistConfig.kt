package meteor.plugins.muspahassist

import meteor.config.legacy.Alpha
import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.plugins.alchemicalhydra.HydraConfig
import meteor.ui.components.ComponentConstants
import net.runelite.api.Prayer
import java.awt.Color

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
        description = "",
        position = 4
    )
    fun smiteToggle(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "conserve",
        name = "Conserve Prayer",
        description = "Can potentially be dangerous if connection is bad",
        position = 5
    )
    fun flickPrayer(): Boolean {
        return false
    }
    @ConfigItem(
        keyName = "showOverlay",
        name = "Show Overlay",
        description = "",
        position = 6
    )
    fun showOverlay(): Boolean {
        return true
    }
    @ConfigItem(
        keyName = "rangeGearButton",
        name = "",
        description = "",
        position = 7,
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
        position = 8
    )
    fun RangeIDs(): String? {
        return ""
    }

    @ConfigItem(
        keyName = "mageGearButton",
        name = "",
        description = "",
        position = 9,
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
        position = 10
    )
    fun MageIDs(): String? {
        return ""
    }
    @ConfigItem(
        keyName = "shieldGearButton",
        name = "",
        description = "",
        position = 11,
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
        position = 12
    )
    fun ShieldIDs(): String? {
        return ""
    }
    @Alpha
    @ConfigItem(
        keyName = "overlayBackgroundColor",
        name = "Overlay Color",
        description = "",
        position = 13
    )
    fun overlayColor(): Color {
        return Color.CYAN
    }

    enum class RangeOffensivePrayers(val prayer: Prayer) {
        EAGLE_EYE(Prayer.EAGLE_EYE), RIGOUR(Prayer.RIGOUR);
    }

    enum class MageOffensivePrayers(val prayer: Prayer) {
        MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT), AUGURY(Prayer.AUGURY);
    }
}