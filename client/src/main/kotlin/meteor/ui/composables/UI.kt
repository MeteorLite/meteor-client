package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import compose.icons.Octicons
import compose.icons.octicons.Plug24
import meteor.Main
import meteor.plugins.Plugin
import meteor.rs.Applet
import meteor.ui.composables.dev.WindowFrame
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.sectionItem
import java.awt.Dimension

var pluginsOpen = mutableStateOf(false)
var configOpen = mutableStateOf(false)
var pluginPanelIsOpen = mutableStateOf(false)
var toolBarOpen = mutableStateOf(false)
var pluginPanel = mutableStateOf<PluginPanel?>(null)
var lastButtonClicked : ToolbarButton? = null
lateinit var lastPlugin: Plugin
val uiColor
    get() = Color(Main.meteorConfig.uiColor().rgb)

@Composable
fun FrameWindowScope.window() {

    MaterialTheme {
        WindowFrame {
            when {
                pluginsOpen.value ||
                        configOpen.value ||
                        pluginPanelIsOpen.value -> window.minimumSize = Dimension(Applet().clientWidth + Main.meteorConfig.toolbarWidth(), 542)
                else -> window.minimumSize =
                    Dimension(Applet().minimalWidth + Main.meteorConfig.toolbarWidth(), 542)
            }
            when {
                toolBarOpen.value ->   toolBar {
                    pluginListButton
                }
            }
            Column(verticalArrangement = Arrangement.Center, modifier =  Modifier.fillMaxHeight(0.50f).width(15.dp)) {
                Spacer(modifier = Modifier.fillMaxHeight(0.50f).width(15.dp))


                sectionItem(modifier = Modifier.background(Color.Transparent).size(25.dp)) {
                    when {
                        !toolBarOpen.value -> {

                            toolBarOpen.value = true
                        }
                        toolBarOpen.value -> {

                            toolBarOpen.value = false
                        }
                    }
                }
            }
            content {
                when {
                    pluginPanelIsOpen.value -> pluginPanel.value?.CreateComponent()
                    configOpen.value -> ConfigPanel()
                    pluginsOpen.value -> PluginsPanel()
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

val pluginListButton = addButton(
        ToolbarButton(
            "Plugins",
            Octicons.Plug24,
            iconColor = uiColor,
            description = "Opens Plugins list",
            onClick = {
                when {
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
            })
    )


