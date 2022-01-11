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
import meteor.plugins.PluginManager
import meteor.ui.Components.OSRSApplet
import meteor.ui.Components.ConfigPanel
import meteor.ui.Components.PluginsPanel
import meteor.ui.Components.Toolbar.LeftRightToolbar
import meteor.ui.Components.Toolbar.TopBottomToolbar
import meteor.ui.Modifiers.toolbarDragListener
import java.awt.Dimension
import rs117.hd.GpuHDPlugin

object UI {
    val toolbarPosition = mutableStateOf(Components.Toolbar.Position.TOP)
    var loaded = false
    const val TOOLBAR_WIDTH = 40
    lateinit var contentSize: Dimension
    var window: FrameWindowScope? = null
    var log = Logger(UI::class.java.name)
    var lastPosition: Components.Toolbar.Position? = null
    lateinit var pluginsPanelIsOpen: MutableState<Boolean>
    lateinit var pluginConfigurationIsOpen: MutableState<Boolean>
    fun Window(): (@Composable FrameWindowScope.() -> Unit) {
        return {
            pluginsPanelIsOpen = remember { mutableStateOf(false) }
            pluginConfigurationIsOpen = remember { mutableStateOf(false) }
            log.info("Creating ${window.renderApi} Compose window")
            MaterialTheme(colors = darkThemeColors) {
                content()
            }
            this@UI.window = this
        }
    }

    @Composable
    fun content() {
        BoxWithConstraints(modifier = Modifier.fillMaxSize().then(toolbarDragListener())) {
            contentSize = Dimension(this.constraints.maxWidth, this.constraints.maxHeight)

            if (lastPosition != null && lastPosition != toolbarPosition.value) {
                PluginManager.restartPlugin<GpuHDPlugin>()
            }
            when (val position = toolbarPosition.value) {
                Components.Toolbar.Position.LEFT -> {
                    Row(modifier = Modifier.background(darkThemeColors.background)) {
                        LeftRightToolbar(toolbarPosition)
                        if (pluginsPanelIsOpen.value)
                            PluginsPanel()
                        OSRSApplet(this@BoxWithConstraints.constraints)
                        lastPosition = toolbarPosition.value
                    }
                }
                Components.Toolbar.Position.RIGHT -> {
                    Row(modifier = Modifier.background(darkThemeColors.background)) {
                        OSRSApplet(this@BoxWithConstraints.constraints)
                        if (pluginsPanelIsOpen.value)
                            PluginsPanel()
                        LeftRightToolbar(toolbarPosition)
                        lastPosition = toolbarPosition.value
                    }
                }
                else -> {
                    Column {
                        if (position == Components.Toolbar.Position.TOP)
                            TopBottomToolbar(toolbarPosition)

                        Row(modifier = Modifier.fillMaxHeight((window!!.window.height - TOOLBAR_WIDTH).toFloat()).fillMaxWidth().background(darkThemeColors.background)) {
                            if (position == Components.Toolbar.Position.TOP || position == Components.Toolbar.Position.BOTTOM)
                                OSRSApplet(this@BoxWithConstraints.constraints)
                            if (pluginConfigurationIsOpen.value)
                                ConfigPanel()
                            else if (pluginsPanelIsOpen.value)
                                PluginsPanel()
                        }
                        if (position == Components.Toolbar.Position.BOTTOM) {
                            TopBottomToolbar(toolbarPosition)
                        }
                        lastPosition = toolbarPosition.value
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