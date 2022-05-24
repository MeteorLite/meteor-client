package meteor.config

import meteor.Configuration
import net.runelite.client.config.*
import meteor.config.legacy.Keybind
import meteor.config.type.*
import meteor.ui.components.ComponentConstants
import net.runelite.api.Constants
import java.awt.BorderLayout
import java.awt.Button
import java.awt.Color
import java.awt.Dimension
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@ConfigGroup(Configuration.MASTER_GROUP)
interface MeteorConfig : Config {

    @Range(min = 35,max = 100,textInput = false)
    @ConfigItem(
        name = "toolbar width",
        keyName = "toolbar width",
        description = "",
        position = 0,
    )
    fun toolbarWidth():Int{
        return 35
    }
    @ConfigItem(
        keyName = "infoBoxVertical",
        name = "Display infoboxes vertically",
        description = "Toggles the infoboxes to display vertically",
        position = 40,
        section = overlaySettings,
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
        section = overlaySettings
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
        section = overlaySettings
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
        section = overlaySettings
    )
    fun overlayBackgroundColor(): Color {
        return ComponentConstants.STANDARD_BACKGROUND_COLOR
    }

    enum class ToolbarPosition(val position: String) {
        NORTH(BorderLayout.NORTH), SOUTH(BorderLayout.SOUTH), EAST(BorderLayout.EAST), WEST(BorderLayout.WEST);
    }

    companion object {


        @ConfigSection(
            name = "Interaction manager",
            description = "Interaction settings",
            closedByDefault = true,
            position = 3
        )
        const val interactionManager = "Interaction manager"



        @ConfigSection(
            name = "Overlay Settings",
            description = "Settings relating to fonts",
            position = 6,
            closedByDefault = true
        )
        const val overlaySettings = "Overlay Settings"

        @ConfigSection(name = "Other", description = "Other settings", closedByDefault = true, position = 55)
        const val other = "Other"
    }
}