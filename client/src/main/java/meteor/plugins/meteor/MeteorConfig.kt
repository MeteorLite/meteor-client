package meteor.plugins.meteor


import androidx.compose.ui.unit.LayoutDirection
import meteor.Configuration
import meteor.config.legacy.*
import meteor.ui.components.ComponentConstants
import java.awt.BorderLayout
import java.awt.Color

@ConfigGroup(Configuration.MASTER_GROUP)
interface MeteorConfig : Config {

    @ConfigItem(
        keyName = "toolbarExpanded",
        name = "Open Toolbar Automatically",
        description = "",
        position = 0
    )
    fun toolbarExpanded(): Boolean {
        return true
    }

    @ConfigItem(
        name = "Always on top",
        keyName = "alwaysOnTop",
        description = "",
        position = 1,
    )
    fun alwaysOnTop(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "fullscreen",
        name = "Borderless Fullscreen",
        description = "",
        position = 2
    )
    fun fullscreen(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Lock window size",
        keyName = "lockWindowSize",
        description = "",
        position = 3,
    )
    fun lockWindowSize(): Boolean {
        return false
    }

    @ConfigItem(
        name = "lockedWindowSize",
        keyName = "lockedWindowSize",
        description = "",
        position = 4,
        hidden = true,
        unhide = "nothingBITCH"
    )
    fun lockedWindowSize(): String {
        return "1280:720"
    }
    @ConfigItem(
        name = "MeteorColor",
        keyName = "MeteorColor",
        description = "",
        position = 5,
    )
    fun uiColor(): Color {
        return Color.CYAN
    }
    @ConfigItem(
        name = "SecondaryColor",
        keyName = "Secondary Color",
        description = "",
        position = 6,
    )
    fun secondColor(): Color {
        return Color(156, 217, 209)
    }
    @ConfigItem(
        name = "Light theme/Dark theme",
        keyName = "Light theme/Dark theme",
        description = "",
        position = 7,
    )
    fun theme(): Boolean {
        return true
    }

    @Range(min = 35, max = 100, textInput = false)
    @ConfigItem(
        name = "toolbar width",
        keyName = "toolbar width",
        description = "",
        position = 8,
    )
    fun toolbarWidth(): Int {
        return 45
    }

    @Range(min = 8, max = 45, textInput = false)
    @ConfigItem(
        name = "Plugin list Text Size",
        keyName = "Plugin list Text Size",
        description = "Slide this to change the plugin list text size",
        position = 9,
    )
    fun pluginListTextSize(): Int {
        return 14
    }

    @Range(min = 1, max = 19, textInput = false)
    @ConfigItem(
        name = "Plugin List Spacer",
        keyName = "Plugin list Spacer",
        description = "",
        position = 10,
    )
    fun pluginSpaceBetween(): Int {
        return 7
    }

    @Alpha
    @ConfigItem(
        keyName = "overlayBackgroundColor",
        name = "Overlay Color",
        description = "Configures the background color of infoboxes and overlays",
        position = 11,
        section = "Overlay Settings"
    )
    fun overlayBackgroundColor(): Color {
        return ComponentConstants.STANDARD_BACKGROUND_COLOR
    }

    @ConfigItem(
            name = "Mimic Mobile UI",
            keyName = "mimicMobileUI",
            description = "Keep inventory open more than usual",
            position = 12,
    )
    fun mimicMobileUI(): Boolean {
        return false
    }

    enum class ToolbarPosition(val position: String) {
        NORTH(BorderLayout.NORTH), SOUTH(BorderLayout.SOUTH), EAST(BorderLayout.EAST), WEST(BorderLayout.WEST);
    }
    }
