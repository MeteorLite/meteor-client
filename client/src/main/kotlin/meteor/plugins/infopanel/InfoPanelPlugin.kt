package meteor.plugins.infopanel

import androidx.compose.ui.Alignment
import compose.icons.Octicons
import compose.icons.octicons.Info16
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton

@PluginDescriptor(name = "Info Panel plugin", enabledByDefault = true)
class InfoPanelPlugin : Plugin() {


    var panel: PluginPanel? = null

    private val infoPanelButton = ToolbarButton(
        "Info Panel",
        imageResource = "/plugins/info/info_icon.png",
        description = "Info",
        onClick = {
            onClick()
        },
        bottom = false,
        alignment = Alignment.Center,
    )

    fun onClick() {
        pluginPanel.value = panel
        togglePluginPanel(infoPanelButton)
    }

    override fun onStart() {
        panel = InfoPanel()
        addButton(infoPanelButton)
    }

    override fun onStop() {
        removeButton(infoPanelButton)
        panel = null
    }

}
