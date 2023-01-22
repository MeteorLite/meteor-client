package meteor.plugins.infopanel

import compose.icons.TablerIcons
import compose.icons.tablericons.InfoCircle
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton

@PluginDescriptor(name = "Info Panel plugin", enabledByDefault = true)
class InfoPanelPlugin : Plugin() {


    var panel: PluginPanel? = null

    private val infoPanelButton = ToolbarButton(
        "Info Panel",
        TablerIcons.InfoCircle,
        iconColor = uiColor.value,
        description = "Info",
        onClick = {
            onClick()
        },
        bottom = false,
        position = 99
    )

    fun onClick() {
        pluginPanel.value = panel
        infoPanelOpen.value = true
        pluginsOpen.value = false
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
