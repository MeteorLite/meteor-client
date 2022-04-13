package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.ui.UI

object PluginList {
    @Composable
    fun PluginsPanel(box: BoxWithConstraintsScope) {
        var mod = Modifier.background(Color(0xFF080808)).fillMaxHeight()
        if (box.maxWidth > 1920.dp) {
            mod = mod.fillMaxWidth(.2f)
        } else
            mod = mod.fillMaxWidth(.3f)
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = mod) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    PluginsPanelHeader()
                    Plugins()
                }
            }
        }
    }

    @Composable
    fun PluginsPanelHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                Text("Plugins",style = TextStyle(color = Color.Cyan, fontSize = 24.sp))
            }
        }
    }

    @Composable
    fun Plugins() {
        Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    items(items = PluginManager.plugins, itemContent = { plugin ->
                        val switchState = remember { mutableStateOf(plugin.enabled) }
                        Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(UI.darkThemeColors.background)){
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.fillMaxWidth(0.75f).height(32.dp).background(UI.darkThemeColors.background)) {
                                Switch(switchState.value, onPluginToggled(switchState, plugin), enabled = true)
                                val external = plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java)
                                val color = if (external?.external == true) Color.Magenta else Color.Cyan
                                Text(plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = color, fontSize = 14.sp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth().height(32.dp).background(UI.darkThemeColors.background)) {
                                if (plugin.config != null) {
                                    IconButton(
                                        onClick = { onPluginConfigurationOpened(plugin) },
                                    ){
                                        Icon(
                                            Icons.Filled.Settings,
                                            contentDescription = "Opens Plugin configuration panel",
                                            tint = Color.Cyan
                                        )
                                    }
                                } else if (plugin.javaConfig != null) {
                                    IconButton(
                                        onClick = { onPluginConfigurationOpened(plugin) },
                                    ){
                                        Icon(
                                            Icons.Filled.Settings,
                                            contentDescription = "Opens Plugin configuration panel",
                                            tint = Color.Cyan
                                        )
                                    }
                                }
                            }
                        }
                    })
                }
            }
        }
    }

    private fun onPluginToggled(switchState: MutableState<Boolean>, plugin: Plugin): ((Boolean) -> Unit) = {
        when (plugin.enabled) {
            false -> PluginManager.start(plugin)
            true -> PluginManager.stop(plugin)
        }
        ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", plugin.enabled)
        switchState.value = plugin.enabled
    }

    private fun onPluginConfigurationOpened(plugin: Plugin) {
        UI.lastPlugin = plugin
        UI.pluginConfigurationIsOpen.value = true
    }
}