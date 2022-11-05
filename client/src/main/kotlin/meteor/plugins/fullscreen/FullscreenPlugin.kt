package meteor.plugins.fullscreen

import androidx.compose.ui.graphics.Color
import compose.icons.Octicons
import compose.icons.octicons.XCircle24
import meteor.Main
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import kotlin.system.exitProcess

@PluginDescriptor(name = "Notes", enabledByDefault = true, disabledOnStartup = false)
class FullscreenPlugin : Plugin() {
    private var notesButton = ToolbarButton(
            "Notes",
            Octicons.XCircle24,
            iconColor = Color.Red,
            description = "Notes",
            onClick = {
                onClick()
            },
            bottom = true
    )

    fun onClick() {
        exitProcess(0)
    }

    override fun onStart() {
        if (Main.meteorConfig.fullscreen())
            addButton(notesButton)
    }

    override fun onStop() {
        if (Main.meteorConfig.fullscreen())
            removeButton(notesButton)
    }
}