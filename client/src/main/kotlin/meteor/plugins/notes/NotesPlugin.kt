package meteor.plugins.notes

import androidx.compose.ui.Alignment
import compose.icons.Octicons
import compose.icons.octicons.Note24
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton


@PluginDescriptor(name = "Notes", enabledByDefault = true)
class NotesPlugin : Plugin() {

    var panel: PluginPanel? = null

    private var notesButton = ToolbarButton(
        "Notes",
        imageResource = "/plugins/notes/notes_icon.png",
        description = "Notes",
        onClick = {
            onClick()
        },
        bottom = false,
        alignment = Alignment.Center
    )

    fun onClick() {
        pluginPanel.value = panel
        togglePluginPanel(notesButton)
    }

    override fun onStart() {
        panel = NotesPluginPanel()
        addButton(notesButton)
    }

    override fun onStop() {
        removeButton(notesButton)
        panel = null
    }
}