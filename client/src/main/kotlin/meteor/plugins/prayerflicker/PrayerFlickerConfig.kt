package meteor.plugins.prayerflicker

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ModifierlessKeybind
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@ConfigGroup("prayerflicker")
interface PrayerFlickerConfig : Config {
    @ConfigItem(
        keyName = "toggle",
        name = "Toggle",
        description = "Toggles prayer flicker.",
        position = 1,
    )
    fun toggle(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_PLUS, InputEvent.CTRL_DOWN_MASK)
    }
}