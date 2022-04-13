package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import meteor.ui.UI

object Toolbar {
    @Composable
    fun ToolbarPanel(box: BoxWithConstraintsScope) {
        var mod = Modifier.background(Color(0xFF080808)).fillMaxHeight()
        if (box.maxWidth > 1920.dp) {
            mod = mod.fillMaxWidth(UI.toolbarWidth)
        } else
            mod = mod.fillMaxWidth(.06f)
        return Column(verticalArrangement = Arrangement.Top, modifier = mod) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color(0xFF080808))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Spacer(modifier = Modifier.height(5.dp))
                    PluginsListToolbarButton()
                }
            }
        }
    }

    @Composable
    fun PluginsListToolbarButton() {
        MaterialTheme(colors = UI.darkThemeColors) {
            IconButton(
                onClick =
                {
                    if (UI.pluginConfigurationIsOpen.value)
                        UI.pluginConfigurationIsOpen.value = !UI.pluginConfigurationIsOpen.value
                    else
                        UI.pluginsPanelIsOpen.value = !UI.pluginsPanelIsOpen.value
                },
                modifier = Modifier.defaultMinSize(minHeight = 35.dp).fillMaxWidth()){
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Opens Plugins list",
                    tint = Color.Cyan,
                )
            }
        }
    }
}