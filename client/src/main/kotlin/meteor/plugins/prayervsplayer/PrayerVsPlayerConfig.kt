package meteor.plugins.prayervsplayer

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ModifierlessKeybind
import java.awt.event.KeyEvent

@ConfigGroup("prayervsplayer")
interface PrayerVsPlayerConfig : Config {
    @ConfigItem(keyName = "toggleKey", name = "Toggle Key", description = "Hotkey to enable/disable prayer toggle")
    fun ToggleKey(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_SPACE, KeyEvent.KEY_PRESSED)
    }
}