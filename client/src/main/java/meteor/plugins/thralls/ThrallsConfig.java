package meteor.plugins.thralls;

import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;
import meteor.config.legacy.ModifierlessKeybind;

import java.awt.event.KeyEvent;

/**
 * @author Hayden#7709
 */
@ConfigGroup("thralls")
public interface ThrallsConfig extends Config {

    @ConfigItem(
            keyName = "autoCastThralls",
            name = "Auto Cast Thralls?",
            description = "Select if you want to the script to automatically cast thralls.",
            position = 1
    )
    default boolean autoCastThralls() {
        return false;
    }

    @ConfigItem(
            keyName = "thrallType",
            name = "Thrall Type",
            description = "Choose which thrall you want to summon (Highest lvl Thrall by default)",
            position = 0
    )
    default ThrallType getThrallType() {
        return ThrallType.SUPERIOR_ZOMBIE;
    }

    @ConfigItem(
            keyName = "manualTrigger",
            name = "Manual Trigger",
            description = "Press this key to cast Thralls",
            position = 3)
    default ModifierlessKeybind getManualTrigger() {
        return new ModifierlessKeybind(KeyEvent.VK_F10, KeyEvent.KEY_PRESSED);
    }
}
