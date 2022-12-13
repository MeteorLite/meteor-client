package meteor.plugins.keyremapping

import meteor.config.legacy.ModifierlessKeybind
import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ConfigSection
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@ConfigGroup("keyremapping")
interface KeyRemappingConfig : Config {
    @ConfigItem(
        position = 1,
        keyName = "cameraRemap",
        name = "Remap Camera",
        description = "Configures whether the camera movement uses remapped keys",
        section = "Camera Remapping"
    )
    fun cameraRemap(): Boolean {
        return true
    }

    @ConfigItem(
        position = 2,
        keyName = "up",
        name = "Camera Up key",
        description = "The key which will replace up.",
        section = "Camera Remapping"
    )
    fun up(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_W, 0)
    }

    @ConfigItem(
        position = 3,
        keyName = "down",
        name = "Camera Down key",
        description = "The key which will replace down.",
        section = "Camera Remapping"
    )
    fun down(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_Z, 0)
    }

    @ConfigItem(
        position = 4,
        keyName = "left",
        name = "Camera Left key",
        description = "The key which will replace left.",
        section = "Camera Remapping"
    )
    fun left(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_X, 0)
    }

    @ConfigItem(
        position = 5,
        keyName = "right",
        name = "Camera Right key",
        description = "The key which will replace right.",
        section = "Camera Remapping"
    )
    fun right(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_D, 0)
    }

    @ConfigItem(
        position = 6,
        keyName = "fkeyRemap",
        name = "Remap F Keys",
        description = "Configures whether F-Keys use remapped keys",
        section = "F Key Remapping"
    )
    fun fkeyRemap(): Boolean {
        return false
    }

    @ConfigItem(
        position = 7,
        keyName = "f1",
        name = "F1",
        description = "The key which will replace {F1}.",
        section = "F Key Remapping"
    )
    fun f1(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_1, 0)
    }

    @ConfigItem(
        position = 8,
        keyName = "f2",
        name = "F2",
        description = "The key which will replace {F2}.",
        section = "F Key Remapping"
    )
    fun f2(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_2, 0)
    }

    @ConfigItem(
        position = 9,
        keyName = "f3",
        name = "F3",
        description = "The key which will replace {F3}.",
        section = "F Key Remapping"
    )
    fun f3(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_3, 0)
    }

    @ConfigItem(
        position = 10,
        keyName = "f4",
        name = "F4",
        description = "The key which will replace {F4}.",
        section = "F Key Remapping"
    )
    fun f4(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_4, 0)
    }

    @ConfigItem(
        position = 11,
        keyName = "f5",
        name = "F5",
        description = "The key which will replace {F5}.",
        section = "F Key Remapping"
    )
    fun f5(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_5, 0)
    }

    @ConfigItem(
        position = 12,
        keyName = "f6",
        name = "F6",
        description = "The key which will replace {F6}.",
        section = "F Key Remapping"
    )
    fun f6(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_6, 0)
    }

    @ConfigItem(
        position = 13,
        keyName = "f7",
        name = "F7",
        description = "The key which will replace {F7}.",
        section = "F Key Remapping"
    )
    fun f7(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_7, 0)
    }

    @ConfigItem(
        position = 14,
        keyName = "f8",
        name = "F8",
        description = "The key which will replace {F8}.",
        section = "F Key Remapping"
    )
    fun f8(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_8, 0)
    }

    @ConfigItem(
        position = 15,
        keyName = "f9",
        name = "F9",
        description = "The key which will replace {F9}.",
        section = "F Key Remapping"
    )
    fun f9(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_9, 0)
    }

    @ConfigItem(
        position = 16,
        keyName = "f10",
        name = "F10",
        description = "The key which will replace {F10}.",
        section = "F Key Remapping"
    )
    fun f10(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_0, 0)
    }

    @ConfigItem(
        position = 17,
        keyName = "f11",
        name = "F11",
        description = "The key which will replace {F11}.",
        section = "F Key Remapping"
    )
    fun f11(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_MINUS, 0)
    }

    @ConfigItem(
        position = 18,
        keyName = "f12",
        name = "F12",
        description = "The key which will replace {F12}.",
        section = "F Key Remapping"
    )
    fun f12(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_EQUALS, 0)
    }

    @ConfigItem(
        position = 19,
        keyName = "esc",
        name = "ESC",
        description = "The key which will replace {ESC}.",
        section = "F Key Remapping"
    )
    fun esc(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_ESCAPE, 0)
    }

    @ConfigItem(
        position = 20,
        keyName = "space",
        name = "Space",
        description = "The key which will replace {Space} when dialogs are open."
    )
    fun space(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_SPACE, 0)
    }

    @ConfigItem(
        position = 21,
        keyName = "control",
        name = "Control",
        description = "The key which will replace {Control}."
    )
    fun control(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_UNDEFINED, InputEvent.CTRL_DOWN_MASK)
    }


    @ConfigSection(
        name = "Camera Remapping",
        description = "Settings for remapping the camera",
        position = 0,
        closedByDefault = false)
    val cameraSection: String

    @ConfigSection(name = "F Key Remapping",
        description = "Settings for remapping the F Keys",
        position = 1,
        closedByDefault = false)
    val SettingsforremappingtheFKeys: String

}