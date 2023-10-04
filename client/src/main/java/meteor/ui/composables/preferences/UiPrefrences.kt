package meteor.ui.composables.preferences


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.WindowState
import compose.icons.LineAwesomeIcons
import compose.icons.Octicons
import compose.icons.lineawesomeicons.PlugSolid
import compose.icons.octicons.Alert24
import meteor.Main
import meteor.config.descriptor.ConfigDescriptor
import meteor.plugins.Plugin
import meteor.rs.Applet
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton


var pluginsOpen = mutableStateOf(false)
var configOpen = mutableStateOf(false)
var hiscoreOpen = mutableStateOf( false)
var xpTrackerOpen = mutableStateOf(false)
var lootTrackerOpen = mutableStateOf(false)
var externalsOpen = mutableStateOf(false)
var notesOpen = mutableStateOf(false)
var infoPanelOpen = mutableStateOf(false)
var pluginPanelIsOpen = mutableStateOf(false)
var error = mutableStateOf(false)
var errorText = mutableStateOf("")
var toolBarOpen = mutableStateOf(Main.meteorConfig.toolbarExpanded())
const val consoleHeight = 500
val minimumHeight = Applet().minimalHeight
val totalClientWidth = Applet().clientWidth + Main.meteorConfig.toolbarWidth()
val totalMinimalWidth = Applet().minimalWidth
var pluginPanel = mutableStateOf<PluginPanel?>(null)
var searchValue = mutableStateOf("")
var lastButtonClicked : ToolbarButton? = null
lateinit var descriptor: ConfigDescriptor
lateinit var lastPlugin: Plugin
val pluginListSize = mutableStateOf(Main.meteorConfig.pluginListTextSize())
val pluginSpacer = mutableStateOf(Main.meteorConfig.pluginSpaceBetween())
val darkLightMode = mutableStateOf(Main.meteorConfig.theme())
val uiColor = mutableStateOf(Color(Main.meteorConfig.uiColor().rgb))
val secondColor = mutableStateOf(Color(Main.meteorConfig.secondColor().rgb))
val surface: Color
    get() = if (darkLightMode.value) darkThemeColors.surface
    else lightThemeColors.surface
val background: Color
    get() = if (darkLightMode.value) darkThemeColors.background
    else lightThemeColors.background

val darkThemeColors = darkColors(
    primary = uiColor.value,
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

fun setErrorState(errorMessage: String) {
    error.value = true
    errorText.value = errorMessage
}

@Composable
fun ErrorDialog(){
    if(error.value) {
        Popup(onDismissRequest = { error.value = false}, alignment = Alignment.Center, focusable = true) {
            Card(shape = RoundedCornerShape(5.dp), backgroundColor = surface) {
                Row(Modifier.width(200.dp)) {
                    Icon(imageVector = Octicons.Alert24,contentDescription = null, tint = uiColor.value)
                    Text(errorText.value, color = secondColor.value)
                }
            }
        }
    }
}
fun setOpenValues(pluginListShowing: Boolean) {
    pluginPanelIsOpen.value = false
    configOpen.value = false
    pluginsOpen.value = pluginListShowing
}

var lastNormalWindowSize: DpSize? = null

val pluginListButton = addButton(
    ToolbarButton(
        "Plugins",
        LineAwesomeIcons.PlugSolid,
        iconColor = uiColor,
        description = "Opens Plugins list",
        onClick = {
            if (configOpen.value) {
                configOpen.value = false
                pluginsOpen.value = true
                return@ToolbarButton
            }
            if (pluginPanelIsOpen.value) {
                pluginPanelIsOpen.value = false
                pluginsOpen.value = true
                return@ToolbarButton
            }

            setOpenValues(!pluginsOpen.value)
        },
        position = 0)
)