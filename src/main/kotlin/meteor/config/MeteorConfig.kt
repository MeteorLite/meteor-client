package meteor.config

import com.jogamp.common.os.Platform
import meteor.Configuration
import meteor.config.ConfigAnnotations.*
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

@ConfigAnnotations.ConfigGroup(Configuration.MASTER_GROUP)
interface MeteorConfig : Config {
    /*
      Client settings
     */
    @ConfigItem(
        keyName = "toolbarPosition",
        name = "Toolbar Position",
        description = "Where the toolbar is located.",
        section = clientSettings,
        position = 0
    )
    fun toolbarPosition(): ToolbarPosition? {
        return ToolbarPosition.EAST
    }

    @ConfigItem(
        keyName = "pluginPanelResize",
        name = "Plugin Panel Resizes Game",
        description = "Whether toggling the plugin panel resizes the game client.",
        section = clientSettings,
        position = 0
    )
    fun resizeGame(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "debugEnabled",
        name = "Enable debug logs",
        description = "Enables printing of debug logs",
        section = debugLogger,
        position = 0
    )
    fun debugEnabled(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "externalsLoadOnStartup",
        name = "Load on startup",
        description = "Load externals on startup",
        section = externalManager,
        position = 0
    )
    fun externalsLoadOnStartup(): Boolean {
        return false
    }

    @Icon
    @ConfigItem(
        keyName = "reloadExternals",
        name = "(Re-)Load Externals",
        description = "Reload external plugins from externals folder",
        section = externalManager,
        position = 1
    )
    fun reloadExternals(): Button? {
        return Button()
    }

    @ConfigItem(
        keyName = "mouseEvents",
        name = "Mouse events",
        description = "Sends mouse events before interaction",
        section = interactionManager,
        position = 0
    )
    fun mouseEvents(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "interactType",
        name = "Interact click type",
        description = "Type of clicks to send to the server",
        section = interactionManager,
        position = 0
    )
    fun interactType(): InteractType? {
        return InteractType.CLICKBOXES
    }

    @ConfigItem(
        keyName = "drawMouse",
        name = "Draw mouse events",
        description = "Draws the sent mouse events on screen",
        section = interactionManager,
        position = 1
    )
    fun drawMouse(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "debugInteractions",
        name = "Debug interactions",
        description = "Prints interactions to console",
        section = interactionManager,
        position = 2
    )
    fun debugInteractions(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "debugDialogs",
        name = "Debug dialogs",
        description = "Prints dialog actions to console",
        section = interactionManager,
        position = 3
    )
    fun debugDialogs(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "meteorLoginScreen",
        name = "MeteorLite Login screen",
        description = "Sets the custom MeteorLite Login screen",
        section = visualSettings,
        position = 0
    )
    fun meteorLoginScreen(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "gameSize",
        name = "Game size",
        description = "The game will resize to this resolution upon starting the client",
        position = 10,
        section = windowSettings
    )
    fun gameSize(): Dimension? {
        return Constants.GAME_FIXED_SIZE
    }

    @ConfigItem(
        keyName = "automaticResizeType",
        name = "Resize type",
        description = "Choose how the window should resize when opening and closing panels",
        position = 11,
        section = windowSettings
    )
    fun automaticResizeType(): ExpandResizeType? {
        return ExpandResizeType.KEEP_GAME_SIZE
    }

    @ConfigItem(
        keyName = "lockWindowSize",
        name = "Lock window size",
        description = "Determines if the window resizing is allowed or not",
        position = 12,
        section = windowSettings
    )
    fun lockWindowSize(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "containInScreen2",
        name = "Contain in screen",
        description = "Makes the client stay contained in the screen when attempted to move out of it.<br>Note: 'Always' only works if custom chrome is enabled.",
        position = 13,
        section = windowSettings
    )
    fun containInScreen(): ResizingType {
        return ResizingType.RESIZING
    }

    @ConfigItem(
        keyName = "rememberScreenBounds",
        name = "Remember client position",
        description = "Save the position and size of the client after exiting",
        position = 14,
        section = windowSettings
    )
    fun rememberScreenBounds(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "uiEnableCustomChrome",
        name = "Enable custom window chrome",
        description = "Use RuneLite's custom window title and borders.",
        warning = "Please restart your client after changing this setting",
        position = 15,
        section = windowSettings
    )
    fun enableCustomChrome(): Boolean {
        return Platform.getOSType() == Platform.OSType.WINDOWS
    }

    @Range(min = 10, max = 100)
    @ConfigItem(
        keyName = "uiWindowOpacity",
        name = "Window opacity",
        description = "Set the windows opacity. Requires \"Enable custom window chrome\" to be enabled.",
        position = 16,
        section = windowSettings
    )
    fun windowOpacity(): Int {
        return 100
    }

    @ConfigItem(
        keyName = "gameAlwaysOnTop",
        name = "Always on top",
        description = "The game will always be on the top of the screen",
        position = 17,
        section = windowSettings
    )
    fun gameAlwaysOnTop(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "warningOnExit",
        name = "Exit warning",
        description = "Shows a warning popup when trying to exit the client",
        position = 18,
        section = windowSettings
    )
    fun warningOnExit(): WarningOnExit? {
        return WarningOnExit.LOGGED_IN
    }

    @ConfigItem(
        keyName = "usernameInTitle",
        name = "Show display name in title",
        description = "Toggles displaying of local player's display name in client title",
        position = 19,
        section = windowSettings
    )
    fun usernameInTitle(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "notificationTray",
        name = "Enable tray notifications",
        description = "Enables tray notifications",
        position = 20,
        section = notificationSettings
    )
    fun enableTrayNotifications(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "notificationRequestFocus",
        name = "Request focus",
        description = "Configures the window focus request type on notification",
        position = 21,
        section = notificationSettings
    )
    fun notificationRequestFocus(): RequestFocusType? {
        return RequestFocusType.OFF
    }

    @ConfigItem(
        keyName = "notificationGameMessage",
        name = "Game message notifications",
        description = "Adds a notification message to the chatbox",
        position = 23,
        section = notificationSettings
    )
    fun enableGameMessageNotification(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "flashNotification",
        name = "Flash",
        description = "Flashes the game frame as a notification",
        position = 24,
        section = notificationSettings
    )
    fun flashNotification(): FlashNotification? {
        return FlashNotification.DISABLED
    }

    @ConfigItem(
        keyName = "notificationFocused",
        name = "Send notifications when focused",
        description = "Toggles all notifications for when the client is focused",
        position = 25,
        section = notificationSettings
    )
    fun sendNotificationsWhenFocused(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(
        keyName = "notificationFlashColor",
        name = "Notification Flash",
        description = "Sets the color of the notification flashes.",
        position = 26,
        section = notificationSettings
    )
    fun notificationFlashColor(): Color? {
        return Color(255, 0, 0, 70)
    }

    @ConfigItem(
        keyName = "fontType",
        name = "Dynamic Overlay Font",
        description = "Configures what font type is used for in-game overlays such as player name, ground items, etc.",
        position = 30,
        section = overlaySettings
    )
    fun fontType(): FontType? {
        return FontType.SMALL
    }

    @ConfigItem(
        keyName = "tooltipFontType",
        name = "Tooltip Font",
        description = "Configures what font type is used for in-game tooltips such as food stats, NPC names, etc.",
        position = 31,
        section = overlaySettings
    )
    fun tooltipFontType(): FontType? {
        return FontType.SMALL
    }

    @ConfigItem(
        keyName = "interfaceFontType",
        name = "Interface Font",
        description = "Configures what font type is used for in-game interface overlays such as panels, opponent info, clue scrolls etc.",
        position = 32,
        section = overlaySettings
    )
    fun interfaceFontType(): FontType? {
        return FontType.REGULAR
    }

    @ConfigItem(
        keyName = "menuEntryShift",
        name = "Require Shift for overlay menu",
        description = "Overlay right-click menu will require shift to be added",
        position = 33,
        section = overlaySettings
    )
    fun menuEntryShift(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "tooltipPosition",
        name = "Tooltip Position",
        description = "Configures whether to show the tooltip above or under the cursor",
        position = 35,
        section = overlaySettings
    )
    fun tooltipPosition(): TooltipPositionType? {
        return TooltipPositionType.UNDER_CURSOR
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

    @ConfigItem(
        keyName = "sidebarToggleKey",
        name = "Sidebar Toggle Key",
        description = "The key that will toggle the sidebar (accepts modifiers)",
        position = 45,
        section = windowSettings
    )
    fun sidebarToggleKey(): Keybind? {
        return Keybind(KeyEvent.VK_F11, InputEvent.CTRL_DOWN_MASK)
    }

    @ConfigItem(
        keyName = "panelToggleKey",
        name = "Plugin Panel Toggle Key",
        description = "The key that will toggle the current or last opened plugin panel (accepts modifiers)",
        position = 46,
        section = windowSettings
    )
    fun panelToggleKey(): Keybind? {
        return Keybind(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK)
    }

    @ConfigItem(
        keyName = "blockExtraMouseButtons",
        name = "Block extra mouse buttons",
        description = "Blocks extra mouse buttons (4 and above)",
        position = 50,
        section = other
    )
    fun blockExtraMouseButtons(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "useWikiItemPrices",
        name = "Use actively traded price",
        description = "Use actively traded prices, sourced from the RuneScape wiki, for item prices",
        position = 51,
        section = other
    )
    fun useWikiItemPrices(): Boolean {
        return true
    }

    enum class ToolbarPosition(val position: String) {
        NORTH(BorderLayout.NORTH), SOUTH(BorderLayout.SOUTH), EAST(BorderLayout.EAST), WEST(BorderLayout.WEST);
    }

    companion object {
        const val GROUP_NAME = "MeteorLite"

        @ConfigSection(name = "Client settings", description = "Client settings", closedByDefault = true, position = 0)
        const val clientSettings = "Client settings"

        /*
      Debugging/Logger
     */
        @ConfigSection(name = "Debug/Logger", description = "Debugging settings", closedByDefault = true, position = 1)
        const val debugLogger = "Debug/Logger"

        /*
      Externals
     */
        @ConfigSection(
            name = "External manager",
            description = "External plugins",
            closedByDefault = true,
            position = 2
        )
        const val externalManager = "External manager"

        @ConfigSection(
            name = "Interaction manager",
            description = "Interaction settings",
            closedByDefault = true,
            position = 3
        )
        const val interactionManager = "Interaction manager"

        @ConfigSection(name = "Visuals", description = "Client visual settings", closedByDefault = true, position = 4)
        const val visualSettings = "Visuals"

        @ConfigSection(
            name = "Window Settings",
            description = "Settings relating to the client's window and frame",
            position = 4,
            closedByDefault = true
        )
        const val windowSettings = "Window Settings"

        @ConfigSection(
            name = "Notification Settings",
            description = "Settings relating to notifications",
            position = 5,
            closedByDefault = true
        )
        const val notificationSettings = "Notification Settings"

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