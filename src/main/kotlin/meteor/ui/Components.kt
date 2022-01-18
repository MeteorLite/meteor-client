package meteor.ui

import Main
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.ConfigManager.getConfiguration
import meteor.config.ConfigManager.setConfiguration
import meteor.config.legacy.ConfigDescriptor
import meteor.config.legacy.ConfigItemDescriptor
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.rs.Applet
import meteor.ui.Components.Toolbar.Position.*
import meteor.ui.UI.pluginConfigurationIsOpen
import meteor.ui.UI.pluginsPanelIsOpen
import meteor.ui.UI.toolbarPosition
import java.awt.BorderLayout
import java.util.stream.Collectors
import javax.swing.JPanel

object Components {
    var jpanel: JPanel? = null
    var toolbarWidth: Float = 0.05f
    lateinit var lastPlugin: Plugin
    @Composable
    fun BrandBadge() {
        val bitmap: ImageBitmap = useResource("brand/badge.png") { loadImageBitmap(it) }
        Image(bitmap = bitmap, contentDescription = "Brand Badge", filterQuality = FilterQuality.High)
    }
    @Composable
    fun PluginConfigPanelToggleButton() {
        MaterialTheme(colors = UI.darkThemeColors) {
            IconButton(
                onClick =
                {
                    if (pluginConfigurationIsOpen.value)
                        pluginConfigurationIsOpen.value = !pluginConfigurationIsOpen.value
                    else
                        pluginsPanelIsOpen.value = !pluginsPanelIsOpen.value
                },
            ){
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Opens Plugins list",
                    tint = Color.Cyan
                )
            }
        }
    }

    @Composable
    fun PluginsPanel() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                PluginsPanelHeader()
                Plugins()
            }
        }
    }

    @Composable
    fun ConfigPanel() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                ConfigPanelHeader()
                Configs()
            }
        }
    }

    @Composable
    fun ConfigPanelHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                Text(lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = Color.Cyan, fontSize = 24.sp))
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
    fun Configs() {
        val scrollState = rememberScrollState()
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background).verticalScroll(scrollState)
        ) {
            MaterialTheme(colors = UI.darkThemeColors) {
                val descriptor = ConfigManager.getConfigDescriptor(lastPlugin.config!!)
                    if (descriptor != null)
                        for (configItemDescriptor in descriptor.items.stream().sorted(
                            Comparator.comparingInt { obj: ConfigItemDescriptor -> obj.position() }).collect(Collectors.toList())) {
                            if (configItemDescriptor.type == Int::class.javaPrimitiveType) {
                                if (configItemDescriptor.range != null) {
                                    if (configItemDescriptor.range.textInput) {
                                        createIntegerTextNode(descriptor, configItemDescriptor)
                                    } else {
                                        createIntegerTextNode(descriptor, configItemDescriptor)
                                    }
                                } else {
                                    createIntegerTextNode(descriptor, configItemDescriptor)
                                }
                                continue
                            }
                            if (configItemDescriptor.type == Boolean::class.javaPrimitiveType) {
                                createBooleanNode(descriptor, configItemDescriptor)
                                continue
                            }
                            if (configItemDescriptor.type?.isEnum == true) {
                                createEnumNode(descriptor, configItemDescriptor)
                                continue
                            }
                }
            }
        }
    }

    @Composable
    fun createBooleanNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var toggled by remember { mutableStateOf (getConfiguration(descriptor.group.value, configItemDescriptor.key()).toBoolean()) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF121212))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.8f).height(40.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF121212))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Switch(toggled, onCheckedChange = {
                        setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                        toggled = it
                    }, enabled = true)
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(Color(0xFF121212)))
    }

    @Composable
    fun createIntegerTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" + Integer.valueOf(getConfiguration(descriptor.group.value, configItemDescriptor.key()))) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    BasicTextField(
                        value = text,
                        onValueChange = {
                            try {
                                setConfiguration(descriptor.group.value, configItemDescriptor.key(), "${Integer.valueOf(it)}")
                                text = it
                            } catch (e: Exception) { }
                        },
                        singleLine = true,
                        modifier = Modifier.padding(all = 0.dp),
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 16.sp)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(Color(0xFF121212)))
    }

    @Composable
    fun createEnumNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var expanded by remember { mutableStateOf(false) }
        val type = configItemDescriptor.type
        val currentConfigEnum =
            java.lang.Enum.valueOf(type as Class<out Enum<*>>, getConfiguration(descriptor.group.value, configItemDescriptor.key())!!)
        val list: MutableList<Enum<*>> = ArrayList()
        var currentToSet: Enum<*>? = null
        for (o in type.enumConstants) {
            if (o == currentConfigEnum) {
                currentToSet = o
            }
            list.add(o)
        }
        var selectedIndex by remember { mutableStateOf(list.indexOf(currentToSet)) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Box(modifier = Modifier.fillMaxWidth().height(20.dp).wrapContentSize(Alignment.TopStart)) {
                        Text(list[selectedIndex].name, color = Color.Cyan, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true }).background(
                            Color(0xFF242424)))
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth(.2f)
                        ) {
                            list.forEachIndexed { index, s ->
                                DropdownMenuItem(onClick = {
                                    selectedIndex = index
                                    expanded = false
                                    setConfiguration(descriptor.group.value, configItemDescriptor.key(), list[selectedIndex].name)
                                }, content = {
                                        Text(text = s.name, color = Color.Cyan, fontSize = 16.sp)
                                })
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(Color(0xFF121212)))
    }

    @Composable
    fun Plugins() {
        val scrollState = rememberScrollState()
        Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background).verticalScroll(scrollState)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                for (plugin in PluginManager.plugins) {
                    Row(modifier = Modifier.fillMaxWidth().height(28.dp).background(UI.darkThemeColors.background)){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.75f).height(28.dp).background(UI.darkThemeColors.background)) {
                            MaterialTheme(colors = UI.darkThemeColors) {
                                val switchState = remember { mutableStateOf(plugin.enabled) }
                                Switch(switchState.value, onPluginToggled(switchState, plugin), enabled = true)
                                Text(plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth().height(28.dp).background(UI.darkThemeColors.background)) {
                            MaterialTheme(colors = UI.darkThemeColors) {
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
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun onPluginToggled(switchState: MutableState<Boolean>, plugin: Plugin): ((Boolean) -> Unit) = {
        when (plugin.enabled) {
            false -> PluginManager.startPlugin(plugin)
            true -> PluginManager.stopPlugin(plugin)
        }
        setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", plugin.enabled)
        switchState.value = plugin.enabled
    }

    private fun onPluginConfigurationOpened(plugin: Plugin) {
        lastPlugin = plugin
        pluginConfigurationIsOpen.value = true
    }

    @Composable
    fun OSRSApplet(constraints: Constraints) {
        val mod: Modifier
        when (toolbarPosition.value) {
            RIGHT, LEFT -> {
                mod = if (pluginsPanelIsOpen.value)
                    Modifier.width((((constraints.maxWidth / 5) * 4) - toolbarWidth).dp).fillMaxHeight()
                else
                    Modifier.width((constraints.maxWidth - toolbarWidth).dp).fillMaxHeight()
            }
            TOP, BOTTOM -> {
                mod = if (pluginsPanelIsOpen.value)
                    Modifier.fillMaxWidth(0.8f).fillMaxHeight()
                else
                    Modifier.fillMaxWidth().fillMaxHeight()
            }
        }
            SwingPanel(Color.Black,
                modifier = mod,
                factory = {
                    JPanel().apply {
                        jpanel = this
                        layout = BorderLayout()
                        add(Applet.applet)
                        if (!UI.loaded) {
                            Applet.applet.init()
                            Applet.applet.start()
                            UI.loaded = true
                            Main.finishStartup()
                        }
                    }
                })
    }

    object Toolbar {
        @Composable
        fun LeftRightToolbar(position: MutableState<Position>) {
            return Column(verticalArrangement = Arrangement.Top, modifier = Modifier.background(UI.darkThemeColors.background)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                        modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxHeight(.5f).background(UI.darkThemeColors.background)) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxHeight().background(UI.darkThemeColors.background)) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                        PluginConfigPanelToggleButton()
                    }
                }
            }
        }

        @Composable
        fun TopBottomToolbar(position: MutableState<Position>) {
            return Row(horizontalArrangement = Arrangement.Center) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxWidth(.5f).background(UI.darkThemeColors.background)) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxWidth().background(UI.darkThemeColors.background)) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                        PluginConfigPanelToggleButton()
                    }
                }
            }
        }

        enum class Position(position: String) {
            TOP("Top"),
            RIGHT("Right"),
            LEFT("Left"),
            BOTTOM("Bottom")
        }
    }
}