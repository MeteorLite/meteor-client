package meteor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.FrameWindowScope
import meteor.Main
import meteor.plugins.Plugin
import meteor.ui.composables.Configuration.ConfigPanel
import meteor.ui.composables.OSRS.OSRSPanel
import meteor.ui.composables.PluginList.PluginsPanel
import meteor.ui.composables.Toolbar.ToolbarPanel
import java.awt.Dimension
import javax.swing.WindowConstants.EXIT_ON_CLOSE

object UI {
    lateinit var lastPlugin: Plugin
    var loaded = false
    lateinit var pluginsPanelIsOpen: MutableState<Boolean>
    lateinit var pluginConfigurationIsOpen: MutableState<Boolean>
    var toolbarWidth: Float = 0.025f

    fun Window(): (@Composable FrameWindowScope.() -> Unit) {
        return {
            this.window.defaultCloseOperation = EXIT_ON_CLOSE
            this.window.placement = Main.placement
            pluginsPanelIsOpen = remember { mutableStateOf(false) }
            pluginConfigurationIsOpen = remember { mutableStateOf(false) }
            MaterialTheme(colors = darkThemeColors) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize().background(darkThemeColors.background)) {

                    // This allows us to provide constraints for composables
                    val container = this

                    // We render from right to left, so we can calculate compose ui sizing before giving the applet it's size
                    // It's important to note that because of this, child composables need to specify left to right
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Row(modifier = Modifier.background(darkThemeColors.background), horizontalArrangement = Arrangement.End) {
                            if (pluginsPanelIsOpen.value || pluginConfigurationIsOpen.value)
                                window.minimumSize = Dimension(1181, 541)
                            else
                                window.minimumSize = Dimension(831, 541)

                            ToolbarPanel(container)
                            if (pluginConfigurationIsOpen.value)
                                ConfigPanel(container)
                            else if (pluginsPanelIsOpen.value)
                                PluginsPanel(container)
                            OSRSPanel()
                        }
                    }
                }
            }
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