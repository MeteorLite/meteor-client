package meteor.external

import compose.icons.TablerIcons
import compose.icons.tablericons.CodePlus
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton


@PluginDescriptor(name = "External Manager")
class ExternalManager: Plugin() {
    var panel: PluginPanel? = null

    private var externalsButton = ToolbarButton(
        "Externals",
        TablerIcons.CodePlus,
        iconColor = uiColor,
        description = "External",
        position = 1,
        onClick = {
            onClick()
        },
        bottom = false
    )

    fun onClick() {
        pluginPanel.value = panel
        togglePluginPanel(externalsButton)
    }

    override fun onStart() {
        panel = ExternalManagerPanel()
        addButton(externalsButton)
    }

    override fun onStop() {
        removeButton(externalsButton)
        panel = null
    }


}