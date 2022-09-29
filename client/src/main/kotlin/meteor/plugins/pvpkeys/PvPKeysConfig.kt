package meteor.plugins.pvpkeys

import com.godaddy.android.colorpicker.HsvColor
import meteor.config.legacy.ModifierlessKeybind
import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.Range
import java.awt.event.KeyEvent

@ConfigGroup("pvpkeys")
interface PvPKeysConfig : Config {


    @ConfigItem(
        keyName = "color",
        name = "Color",
        description = "color shit"
    )
    fun color(): HsvColor {
        return HsvColor.DEFAULT
    }

    @ConfigItem(keyName = "Magepray", name = "Toggle prot mage", description = "")
    fun Magepray(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_1, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Rangepray", name = "Toggle prot range", description = "")
    fun Rangepray(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_2, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Meleepray", name = "Toggle prot melee", description = "")
    fun Meleepray(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_3, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Smite", name = "Toggle smite", description = "")
    fun Smite(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_4, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Brew", name = "Sip Brew", description = "")
    fun Brew(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_5, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Restore", name = "Sip Restore", description = "")
    fun Restore(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_6, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Quickpray", name = "Toggle Quick Prayer", description = "")
    fun Quickpray(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_TAB, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Magegear", name = "Swap to mage gear", description = "")
    fun Magegear(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_Q, KeyEvent.KEY_PRESSED)
    }

    @Range(textInput = true)
    @ConfigItem(keyName = "MageIDs", name = "Mage gear id's", description = "", textField = true)
    fun MageIDs(): String? {
        return ""
    }

    @ConfigItem(keyName = "Rangegear", name = "Swap to Range gear", description = "")
    fun Rangegear(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_W, KeyEvent.KEY_PRESSED)
    }

    @Range(textInput = true)
    @ConfigItem(keyName = "RangeIDs", name = "Range gear id's", description = "", textField = true)
    fun RangeIDs(): String? {
        return ""
    }

    @ConfigItem(keyName = "Meleegear", name = "Swap to Melee gear", description = "")
    fun Meleegear(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_E, KeyEvent.KEY_PRESSED)
    }

    @Range(textInput = true)
    @ConfigItem(keyName = "MeleeIDs", name = "Melee gear id's", description = "", textField = true)
    fun MeleeIDs(): String? {
        return ""
    }

    @ConfigItem(keyName = "Icebarrage", name = "Select Ice Barrage", description = "")
    fun Icebarrage(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_R, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Iceblitz", name = "Select Ice Blitz(t)", description = "")
    fun Iceblitz(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_T, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Bloodblitz", name = "Select Blood Blitz(y)", description = "")
    fun Bloodblitz(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_Y, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Augury", name = "Toggle augury(a)", description = "")
    fun Augury(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_A, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Rigour", name = "Toggle rigour(s)", description = "")
    fun Rigour(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_S, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Piety", name = "Toggle piety(d)", description = "")
    fun Piety(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_D, KeyEvent.KEY_PRESSED)
    }

    @ConfigItem(keyName = "Lasttarger", name = "Last target", description = "")
    fun Lasttarget(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_SPACE, KeyEvent.KEY_PRESSED)
    }
}
