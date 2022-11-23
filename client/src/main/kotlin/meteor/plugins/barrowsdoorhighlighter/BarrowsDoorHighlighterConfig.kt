package meteor.plugins.barrowsdoorhighlighter

import meteor.config.legacy.Alpha
import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

import java.awt.Color


@ConfigGroup("BarrowsDoorHighlighter")
interface BarrowsDoorHighlighterConfig : Config {
    enum class HighlightDoors {
        LOCKED, UNLOCKED, BOTH, NEITHER
    }

    @ConfigItem(
        keyName = "highlightDoors",
        name = "Highlight Doors",
        description = "Select which type of doors to highlight.",
        position = 0
    )
    fun highlightDoors(): HighlightDoors? {
        return HighlightDoors.BOTH
    }

    @Alpha
    @ConfigItem(
        keyName = "unlockedDoorColor",
        name = "Unlocked Door Color",
        description = "Select the unlocked door color.",
        position = 1
    )
    fun unlockedDoorColor(): Color? {
        return Color.GREEN
    }

    @Alpha
    @ConfigItem(
        keyName = "lockedDoorColor",
        name = "Locked Door Color",
        description = "Select the locked door color.",
        position = 2
    )
    fun lockedDoorColor(): Color? {
        return Color.RED
    }
}