package meteor.plugins.fullscreen

import androidx.compose.ui.graphics.Color
import compose.icons.Octicons
import compose.icons.octicons.ScreenFull24
import compose.icons.octicons.ScreenNormal24
import compose.icons.octicons.XCircle24
import meteor.Configuration
import meteor.Main
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton

@PluginDescriptor(name = "Notes", enabledByDefault = true, disabledOnStartup = false)
class FullscreenPlugin : Plugin() {
    private var exitApplicationButton = ToolbarButton(
        "exitMeteor",
        Octicons.XCircle24,
        iconColor = Color.Red,
        description = "Exit Meteor",
        onClick = {
            closeMeteor()
        },
        bottom = true
    )

    var enableFullscreenButton = ToolbarButton(
        "enableFullscreen",
        Octicons.ScreenFull24,
        iconColor = Color.Cyan,
        description = "Toggle Fullscreen",
        onClick = {
            toggleFullscreen()
        },
        bottom = true
    )

    var disableFullscreenButton = ToolbarButton(
        "disableFullscreen",
        Octicons.ScreenNormal24,
        iconColor = Color.Cyan,
        description = "Toggle Fullscreen",
        onClick = {
            toggleFullscreen()
        },
        bottom = true
    )

    fun closeMeteor() {
        Main.exitApplication()
    }

    fun toggleFullscreen() {
        val isFullscreen = ConfigManager.getConfiguration(Configuration.MASTER_GROUP, "fullscreen")!!.toBoolean()
        if (isFullscreen) {
            ConfigManager.setConfiguration(Configuration.MASTER_GROUP, "fullscreen", false)
            removeButton(disableFullscreenButton)
            addButton(enableFullscreenButton)
            removeButton(exitApplicationButton)
        }
        else {
            ConfigManager.setConfiguration(Configuration.MASTER_GROUP, "fullscreen", true)
            removeButton(enableFullscreenButton)
            addButton(disableFullscreenButton)
            addButton(exitApplicationButton)
        }
    }

    override fun onStart() {
        if (Main.meteorConfig.fullscreen())
            addButton(disableFullscreenButton)
        else
            addButton(enableFullscreenButton)

        disableFullscreenButton.position = 998
        enableFullscreenButton.position = 998
        if (Main.meteorConfig.fullscreen())
            addButton(exitApplicationButton)
    }

    override fun onStop() {
        if (Main.meteorConfig.fullscreen())
            removeButton(disableFullscreenButton)
        else
            removeButton(enableFullscreenButton)
    }
}