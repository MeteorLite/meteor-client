package meteor.plugins.keyremapping

import meteor.config.legacy.ModifierlessKeybind
import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.ConfigSection
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@ConfigGroup("keyremapping")
interface KeyRemappingConfig : Config {
    @ConfigItem(
        position = 1,
        keyName = "cameraRemap",
        name = "Remap Camera",
        description = "Configures whether the camera movement uses remapped keys",
        section = "Settings for remapping the camera"
    )
    fun cameraRemap(): Boolean {
        return true
    }

    @ConfigItem(
        position = 2,
        keyName = "up",
        name = "Camera Up key",
        description = "The key which will replace up.",
        section = "Settings for remapping the camera"
    )
    fun up(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_W, 0)
    }

    @ConfigItem(
        position = 3,
        keyName = "down",
        name = "Camera Down key",
        description = "The key which will replace down.",
        section = "Settings for remapping the camera"
    )
    fun down(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_S, 0)
    }

    @ConfigItem(
        position = 4,
        keyName = "left",
        name = "Camera Left key",
        description = "The key which will replace left.",
        section = "Settings for remapping the camera"
    )
    fun left(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_A, 0)
    }

    @ConfigItem(
        position = 5,
        keyName = "right",
        name = "Camera Right key",
        description = "The key which will replace right.",
        section = "Settings for remapping the camera"
    )
    fun right(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_D, 0)
    }

    @ConfigItem(
        position = 6,
        keyName = "fkeyRemap",
        name = "Remap F Keys",
        description = "Configures whether F-Keys use remapped keys",
        section = "Settings for remapping the F Keys"
    )
    fun fkeyRemap(): Boolean {
        return false
    }

    @ConfigItem(
        position = 7,
        keyName = "f1",
        name = "F1",
        description = "The key which will replace {F1}.",
        section = "Settings for remapping the F Keys"
    )
    fun f1(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_1, 0)
    }

    @ConfigItem(
        position = 8,
        keyName = "f2",
        name = "F2",
        description = "The key which will replace {F2}.",
        section = "Settings for remapping the F Keys"
    )
    fun f2(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_2, 0)
    }

    @ConfigItem(
        position = 9,
        keyName = "f3",
        name = "F3",
        description = "The key which will replace {F3}.",
        section = "Settings for remapping the F Keys"
    )
    fun f3(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_3, 0)
    }

    @ConfigItem(
        position = 10,
        keyName = "f4",
        name = "F4",
        description = "The key which will replace {F4}.",
        section = "Settings for remapping the F Keys"
    )
    fun f4(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_4, 0)
    }

    @ConfigItem(
        position = 11,
        keyName = "f5",
        name = "F5",
        description = "The key which will replace {F5}.",
        section = "Settings for remapping the F Keys"
    )
    fun f5(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_5, 0)
    }

    @ConfigItem(
        position = 12,
        keyName = "f6",
        name = "F6",
        description = "The key which will replace {F6}.",
        section = "Settings for remapping the F Keys"
    )
    fun f6(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_6, 0)
    }

    @ConfigItem(
        position = 13,
        keyName = "f7",
        name = "F7",
        description = "The key which will replace {F7}.",
        section = "Settings for remapping the F Keys"
    )
    fun f7(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_7, 0)
    }

    @ConfigItem(
        position = 14,
        keyName = "f8",
        name = "F8",
        description = "The key which will replace {F8}.",
        section = "Settings for remapping the F Keys"
    )
    fun f8(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_8, 0)
    }

    @ConfigItem(
        position = 15,
        keyName = "f9",
        name = "F9",
        description = "The key which will replace {F9}.",
        section = "Settings for remapping the F Keys"
    )
    fun f9(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_9, 0)
    }

    @ConfigItem(
        position = 16,
        keyName = "f10",
        name = "F10",
        description = "The key which will replace {F10}.",
        section = "Settings for remapping the F Keys"
    )
    fun f10(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_0, 0)
    }

    @ConfigItem(
        position = 17,
        keyName = "f11",
        name = "F11",
        description = "The key which will replace {F11}.",
        section = "Settings for remapping the F Keys"
    )
    fun f11(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_MINUS, 0)
    }

    @ConfigItem(
        position = 18,
        keyName = "f12",
        name = "F12",
        description = "The key which will replace {F12}.",
        section = "Settings for remapping the F Keys"
    )
    fun f12(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_EQUALS, 0)
    }

    @ConfigItem(
        position = 19,
        keyName = "esc",
        name = "ESC",
        description = "The key which will replace {ESC}.",
        section = "Settings for remapping the F Keys"
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


    @ConfigSection(name = "Camera Remapping", description = "Settings for remapping the camera", position = 0)
    val cameraSection: String

    @ConfigSection(name = "F Key Remapping", description = "Settings for remapping the F Keys", position = 1)
    val SettingsforremappingtheFKeys: String

}