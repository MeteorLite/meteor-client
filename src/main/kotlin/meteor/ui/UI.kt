package meteor.ui

import meteor.Main
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement
import eventbus.Events
import eventbus.events.ConfigButtonClicked
import meteor.Logger
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.rs.Applet
import java.awt.BorderLayout
import java.awt.Dimension
import java.util.stream.Collectors
import javax.swing.JPanel
import javax.swing.WindowConstants.EXIT_ON_CLOSE

object UI {
    lateinit var lastPlugin: Plugin
    var loaded = false
    lateinit var contentSize: Dimension
    var window: FrameWindowScope? = null
    var log = Logger(UI::class.java.name)
    lateinit var pluginsPanelIsOpen: MutableState<Boolean>
    lateinit var pluginConfigurationIsOpen: MutableState<Boolean>
    lateinit var jpanel: JPanel
    var toolbarWidth: Float = 0.020f


    fun Window(placement: WindowPlacement): (@Composable FrameWindowScope.() -> Unit) {
        return {
            this.window.defaultCloseOperation = EXIT_ON_CLOSE
            this.window.placement = Main.placement
            pluginsPanelIsOpen = remember { mutableStateOf(false) }
            pluginConfigurationIsOpen = remember { mutableStateOf(false) }
            log.info("Creating ${window.renderApi} Compose window")
            MaterialTheme(colors = darkThemeColors) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize().background(darkThemeColors.background)) {
                    contentSize = Dimension(this.constraints.maxWidth, this.constraints.maxHeight)
                    Row(modifier = Modifier.background(darkThemeColors.background)) {
                        OSRSApplet()
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


    @Composable
    fun PluginConfigPanelToggleButton() {
        MaterialTheme(colors = darkThemeColors) {
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
            modifier = Modifier.fillMaxWidth(.9f).fillMaxHeight().background(darkThemeColors.background)) {
            MaterialTheme(colors = darkThemeColors) {
                PluginsPanelHeader()
                Plugins()
            }
        }
    }

    @Composable
    fun ConfigPanel() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth(.9f).fillMaxHeight().background(darkThemeColors.background)) {
            MaterialTheme(colors = darkThemeColors) {
                ConfigPanelHeader()
                Configs()
            }
        }
    }

    @Composable
    fun ConfigPanelHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(darkThemeColors.background)) {
            MaterialTheme(colors = darkThemeColors) {
                Text(lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = Color.Cyan, fontSize = 24.sp))
            }
        }
    }

    @Composable
    fun PluginsPanelHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(darkThemeColors.background)) {
            MaterialTheme(colors = darkThemeColors) {
                Text("Plugins",style = TextStyle(color = Color.Cyan, fontSize = 24.sp))
            }
        }
    }

    @Composable
    fun Configs() {
        val scrollState = rememberScrollState()
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.background).verticalScroll(scrollState)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                var descriptor: ConfigDescriptor? = null
                if (lastPlugin.config != null)
                    descriptor = ConfigManager.getConfigDescriptor(lastPlugin.config!!)
                else if (lastPlugin.javaConfig != null)
                    descriptor = ConfigManager.getConfigDescriptor(lastPlugin.javaConfig!!)

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
                        if (configItemDescriptor.type == java.awt.Button::class.java) {
                            createBooleanNode(descriptor, configItemDescriptor)
                            continue
                        }
                        if (configItemDescriptor.type?.isEnum == true) {
                            createEnumNode(descriptor, configItemDescriptor)
                            continue
                        }
                        if (configItemDescriptor.type == String::class.java) {
                            if (configItemDescriptor.item.textField) {
                                createStringTextNode(descriptor, configItemDescriptor)
                                continue
                            }
                        }
                    }
            }
        }
    }

    @Composable
    fun createBooleanNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var toggled by remember { mutableStateOf (
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toBoolean()) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF121212))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.8f).height(40.dp).background(darkThemeColors.background)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF121212))) {
                MaterialTheme(colors = darkThemeColors) {
                    Switch(toggled, onCheckedChange = {
                        ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                        toggled = it
                    }, enabled = true)
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(Color(0xFF121212)))
    }

    @Composable
    fun createIntegerTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" + Integer.valueOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(darkThemeColors.background)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = darkThemeColors) {
                    BasicTextField(
                        value = text,
                        onValueChange = {
                            try {
                                ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), "${Integer.valueOf(it)}")
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
    fun createStringTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" +
                ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()

        )) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(darkThemeColors.background)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = darkThemeColors) {
                    BasicTextField(
                        value = text,
                        visualTransformation = if (!configItemDescriptor.secret()) VisualTransformation.None else PasswordVisualTransformation(),
                        onValueChange = {
                            try {
                                ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(),
                                    it
                                )
                                text = it
                            } catch (_: Exception) { }
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
            java.lang.Enum.valueOf(type as Class<out Enum<*>>, ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )!!)
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
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(darkThemeColors.background)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp)) {
                MaterialTheme(colors = darkThemeColors) {
                    Box(modifier = Modifier.fillMaxWidth().height(20.dp).wrapContentSize(Alignment.TopStart)) {
                        Text(list[selectedIndex].name, color = Color.Cyan, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true }).background(
                            Color(0xFF242424)))
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth(.19f)
                        ) {
                            list.forEachIndexed { index, s ->
                                DropdownMenuItem(onClick = {
                                    selectedIndex = index
                                    expanded = false
                                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), list[selectedIndex].name)
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
    fun createButtonNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" + Integer.valueOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )) }
        Row(modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(40.dp).background(darkThemeColors.background)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(40.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = darkThemeColors) {
                    OutlinedButton(onClick = {
                        //TODO fix enum
                        Main.client.callbacks.post(Events.CONFIG_CHANGED, ConfigButtonClicked(descriptor.group.value, configItemDescriptor.key()))}
                    ) {
                        Text(configItemDescriptor.name())
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
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.background).verticalScroll(scrollState)) {
            MaterialTheme(colors = darkThemeColors) {
                for (plugin in PluginManager.plugins) {
                    Row(modifier = Modifier.fillMaxWidth().height(28.dp).background(darkThemeColors.background)){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.75f).height(28.dp).background(darkThemeColors.background)) {
                            MaterialTheme(colors = darkThemeColors) {
                                val switchState = remember { mutableStateOf(plugin.enabled) }
                                Switch(switchState.value, onPluginToggled(switchState, plugin), enabled = true)
                                Text(plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = Color.Cyan, fontSize = 16.sp))
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth().height(28.dp).background(darkThemeColors.background)) {
                            MaterialTheme(colors = darkThemeColors) {
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
                    }
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
        lastPlugin = plugin
        pluginConfigurationIsOpen.value = true
    }

    @Composable
    fun OSRSApplet() {
        val mod: Modifier = if (pluginsPanelIsOpen.value)
            Modifier.fillMaxWidth(((.01f) * 80) - toolbarWidth).fillMaxHeight()
        else
            Modifier.fillMaxWidth(1f - toolbarWidth).fillMaxHeight()

        SwingPanel(Color.Black,
            modifier = mod,
            factory = {
                if (!this::jpanel.isInitialized) {
                    jpanel = JPanel()
                    jpanel.layout = BorderLayout()
                    jpanel.add(Applet.applet)
                    Applet.applet.init()
                    Applet.applet.start()
                    loaded = true
                    Main.finishStartup()
                }
                jpanel
            })
    }

    @Composable
    fun Toolbar() {
        return Column(verticalArrangement = Arrangement.Top, modifier = Modifier.background(Color(0xFF080808)).fillMaxWidth().fillMaxHeight()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxHeight(.5f).background(Color(0xFF080808)).fillMaxWidth()) {
                MaterialTheme(colors = darkThemeColors) {
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxHeight(toolbarWidth).fillMaxHeight(.5f).background(Color(0xFF080808)).fillMaxWidth()) {
                MaterialTheme(colors = darkThemeColors) {
                    PluginConfigPanelToggleButton()
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