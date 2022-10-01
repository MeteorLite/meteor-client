package meteor.config


import androidx.compose.ui.unit.LayoutDirection
import meteor.Configuration
import meteor.ui.components.ComponentConstants
import net.runelite.client.config.*
import java.awt.BorderLayout
import java.awt.Color

@ConfigGroup(Configuration.MASTER_GROUP)
interface MeteorConfig : Config {
    @ConfigItem(
        name = "MeteorColor",
        keyName = "MeteorColor",
        description = "",
        position = 0,
    )
    fun uiColor(): Color {
        return Color.CYAN
    }

    @Range(min = 35, max = 100, textInput = false)
    @ConfigItem(
        name = "toolbar width",
        keyName = "toolbar width",
        description = "",
        position = 0,
    )
    fun toolbarWidth(): Int {
        return 35
    }

    @ConfigItem(
        name = "toolbar placement",
        keyName = "toolbar placement",
        description = "",
        position = 2
    )
    fun toolbarPlacement(): LayoutDirection {
        return LayoutDirection.Rtl
    }

    @Range(min = 8, max = 45, textInput = false)
    @ConfigItem(
        name = "Plugin list Text Size",
        keyName = "Plugin list Text Size",
        description = "Slide this to change the plugin list text size",
        position = 0,
    )
    fun pluginListTextSize(): Int {
        return 15
    }

    @Range(min = 1, max = 19, textInput = false)
    @ConfigItem(
        name = "Plugin List Spacer",
        keyName = "Plugin list Spacer",
        description = "",
        position = 0,
    )
    fun pluginSpaceBetween(): Int {
        return 7
    }

    @ConfigItem(
        keyName = "infoBoxVertical",
        name = "Display infoboxes vertically",
        description = "Toggles the infoboxes to display vertically",
        position = 40,
        section = "Overlay Settings",
        hidden = true
    )
    fun infoBoxVertical(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "infoBoxSize",
        name = "Infobox size",
        description = "Configures the size of each infobox in pixels",
        position = 42,
        section = "Overlay Settings"
    )
    @Units(Units.PIXELS)
    fun infoBoxSize(): Int {
        return 35
    }

    @ConfigItem(
        keyName = "infoBoxTextOutline",
        name = "Outline infobox text",
        description = "Draw a full outline instead of a simple shadow for infobox text",
        position = 43,
        section = "Overlay Settings"
    )
    fun infoBoxTextOutline(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(
        keyName = "overlayBackgroundColor",
        name = "Overlay Color",
        description = "Configures the background color of infoboxes and overlays",
        position = 44,
        section = "Overlay Settings"
    )
    fun overlayBackgroundColor(): Color {
        return ComponentConstants.STANDARD_BACKGROUND_COLOR
    }

    enum class ToolbarPosition(val position: String) {
        NORTH(BorderLayout.NORTH), SOUTH(BorderLayout.SOUTH), EAST(BorderLayout.EAST), WEST(BorderLayout.WEST);
    }



        @ConfigSection(
            name = "Interaction manager",
            description = "Interaction settings",
            closedByDefault = true,
            position = 3
        )
         val interactionManager:String


        @ConfigSection(
            name = "Overlay Settings",
            description = "Settings relating to fonts",
            position = 6,
            closedByDefault = true
        )
        val OverlaySettings:String

    }
