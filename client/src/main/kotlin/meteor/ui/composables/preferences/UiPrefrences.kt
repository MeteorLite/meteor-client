package meteor.ui.composables.preferences

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import compose.icons.Octicons
import compose.icons.octicons.Plug24
import meteor.Main
import meteor.config.descriptor.ConfigDescriptor
import meteor.plugins.Plugin
import meteor.plugins.loottracker.LootTrackerItem
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.util.MultiMap
import net.runelite.api.Skill
import net.runelite.http.api.hiscore.HiscoreResult


var pluginsOpen = mutableStateOf(false)
var configOpen = mutableStateOf(false)
var pluginPanelIsOpen = mutableStateOf(false)
var toolBarOpen = mutableStateOf(Main.meteorConfig.toolbarExpanded())
const val consoleHeight = 717
const val minimumHeight = 542
var result: HiscoreResult? = HiscoreResult()
var consoleOpen = mutableStateOf(Main.meteorConfig.console())
var pluginPanel = mutableStateOf<PluginPanel?>(null)
var searchValue = mutableStateOf("")
var intColor = Color(156, 217, 209)
var lastButtonClicked : ToolbarButton? = null
lateinit var descriptor: ConfigDescriptor
lateinit var lastPlugin: Plugin
val pluginListSize = mutableStateOf(Main.meteorConfig.pluginListTextSize())
val pluginSpacer = mutableStateOf(Main.meteorConfig.pluginSpaceBetween())
val darkLightMode
    get() = mutableStateOf(Main.meteorConfig.theme())
val uiColor
    get() = mutableStateOf(Color(Main.meteorConfig.uiColor().rgb))
val surface: Color
    get() = if (darkLightMode.value) darkThemeColors.surface
    else lightThemeColors.surface
val background: Color
    get() = if (darkLightMode.value) darkThemeColors.background
    else lightThemeColors.background

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
val lightThemeColors = lightColors(
    primary = Color(0xFF0070D8),
    primaryVariant = Color(0xFF0070D8),
    onPrimary = Color(0xFFFFFFFFF),
    secondary = Color(0xFF9c27b0),
    onBackground = Color(0xFF212934),
    onSecondary = Color(0xFF595858),
    error = Color(0xFFc93838),
    onError = Color(0xFFFFFFFF),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFf3f5f7),
)

val pluginListButton = addButton(
    ToolbarButton(
        "Plugins",
        Octicons.Plug24,
        iconColor = uiColor.value,
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
