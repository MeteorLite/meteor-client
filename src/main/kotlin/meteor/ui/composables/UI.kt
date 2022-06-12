package meteor.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.FrameWindowScope
import compose.icons.Octicons
import compose.icons.octicons.Plug24
import meteor.plugins.Plugin
import meteor.plugins.notes.NotesPlugin
import meteor.rs.Applet
import meteor.ui.composables.dev.WindowFrame
import meteor.ui.composables.toolbar.Toolbar
import meteor.ui.composables.toolbar.ToolbarButton
import java.awt.Dimension

var pluginsOpen = mutableStateOf(false)
var configOpen = mutableStateOf(false)
var pluginPanelIsOpen = mutableStateOf(false)
var pluginPanel = mutableStateOf<PluginPanel?>(null)
var notePanel = mutableStateOf(false)
lateinit var lastPlugin: Plugin

@Composable
fun FrameWindowScope.Window() {

    MaterialTheme {
        WindowFrame {
            when {
                pluginsOpen.value ||
                        configOpen.value ||
                        notePanel.value -> window.minimumSize = Dimension(Applet().clientWidth, 542)
                else -> window.minimumSize =
                    Dimension(Applet().minimalWidth, 542)
            }

            toolBar {
                pluginListButton()
            }
            content {
                when {
                    pluginPanelIsOpen.value -> pluginPanel.value?.CreateComponent()
                    configOpen.value -> ConfigPanel()
                    pluginsOpen.value -> PluginsPanel()
                    notePanel.value -> NotesPlugin().notesTextNode()
                }
                gameFrame {
                    OSRSPanel()
                }
            }
        }
    }
}

val darkThemeColors = darkColors(
    primary = Color.Cyan,
    primaryVariant = Color(0xFF3E2723),
    secondary = Color.Cyan,
    background = Color(0xFF191919),
    surface = Color(0xFF212121),
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black
)
@Composable
fun pluginListButton()  {


   Toolbar.addButton(ToolbarButton(
        "Plugins",
       Octicons.Plug24,
        iconColor = Color.Cyan,
        description = "Opens Plugins list",
        onClick = {

            when {
                notePanel.value ->{
                    pluginsOpen.value = true
                }
                pluginPanelIsOpen.value -> {

                    pluginPanelIsOpen.value = !pluginPanelIsOpen.value
                    if (!pluginsOpen.value)
                        pluginsOpen.value = true
                }
                configOpen.value -> {

                    configOpen.value = false
                    if (!pluginsOpen.value)
                        pluginsOpen.value = true
                }
                else -> pluginsOpen.value = !pluginsOpen.value
            }
        }))

}
