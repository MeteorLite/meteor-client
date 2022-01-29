package meteor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.FrameWindowScope
import meteor.Logger
import meteor.ui.Components.OSRSApplet
import meteor.ui.Components.ConfigPanel
import meteor.ui.Components.PluginsPanel
import meteor.ui.Components.Toolbar.Toolbar
import java.awt.Dimension

object UI {
    var loaded = false
    lateinit var contentSize: Dimension
    var window: FrameWindowScope? = null
    var log = Logger(UI::class.java.name)
    lateinit var pluginsPanelIsOpen: MutableState<Boolean>
    lateinit var pluginConfigurationIsOpen: MutableState<Boolean>
    fun Window(): (@Composable FrameWindowScope.() -> Unit) {
        return {
            pluginsPanelIsOpen = remember { mutableStateOf(false) }
            pluginConfigurationIsOpen = remember { mutableStateOf(false) }
            log.info("Creating ${window.renderApi} Compose window")
            MaterialTheme(colors = darkThemeColors) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize().background(darkThemeColors.background)) {
                    contentSize = Dimension(this.constraints.maxWidth, this.constraints.maxHeight)
                    Row(modifier = Modifier.background(darkThemeColors.background)) {
                        OSRSApplet(this@BoxWithConstraints.constraints)
                        if (pluginConfigurationIsOpen.value)
                            ConfigPanel()
                        else if (pluginsPanelIsOpen.value)
                            PluginsPanel()
                        Toolbar()
                    }
                }
            }
            this@UI.window = this
        }
    }

    val darkThemeColors = darkColors(
            primary = Color.Cyan,
            primaryVariant = Color(0xFF3E2723),
            secondary = Color.Cyan,
            background = Color(0xFF121212),
            surface = Color.Black,
            error = Color.Red,
            onPrimary = Color.White,
            onSecondary = Color.White,
            onBackground = Color.White,
            onSurface = Color.White,
            onError = Color.Black
    )
}