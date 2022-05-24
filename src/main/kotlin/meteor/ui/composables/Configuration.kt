package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godaddy.android.colorpicker.harmony.ColorHarmonyMode
import com.godaddy.android.colorpicker.harmony.HarmonyColorPicker
import eventbus.Events
import eventbus.events.ConfigButtonClicked
import meteor.Main
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.Keybind
import meteor.config.legacy.ModifierlessKeybind
import meteor.plugins.PluginDescriptor
import meteor.ui.UI
import meteor.util.ColorUtil
import java.awt.Button
import java.awt.event.KeyEvent
import java.util.stream.Collectors

object Configuration {

    @Composable
    fun ConfigPanel(box: BoxWithConstraintsScope) {
        var mod = Modifier.background(UI.darkThemeColors.background).fillMaxHeight()
        if (box.maxWidth > 1920.dp) {
            mod = mod.fillMaxWidth(.2f)
        } else
            mod = mod.fillMaxWidth(.3f)
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = mod) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(.95f)) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                        ConfigPanelHeader()
                        Configs()
                    }
                }
            }
        }
    }

    @Composable
    fun ConfigPanelHeader() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                Text(UI.lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,style = TextStyle(color = Color.Cyan, fontSize = 24.sp))
            }
        }
    }

    @Composable
    fun Configs() {
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.background)
        ) {
            MaterialTheme(colors = UI.darkThemeColors) {
                var descriptor: ConfigDescriptor? = null
                if (UI.lastPlugin.config != null)
                    descriptor = ConfigManager.getConfigDescriptor(UI.lastPlugin.config!!)
                else if (UI.lastPlugin.javaConfig != null)
                    descriptor = ConfigManager.getConfigDescriptor(UI.lastPlugin.javaConfig!!)

                if (descriptor != null) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        items(items = descriptor.items.stream().sorted(
                            Comparator.comparingInt { obj: ConfigItemDescriptor -> obj.position() })
                            .collect(Collectors.toList()), itemContent = { configuration ->
                            when (configuration.type) {
                                Int::class.javaPrimitiveType -> {
                                    if (configuration.range != null) {
                                        if (configuration.range.textInput) {
                                            createIntegerTextNode(descriptor, configuration)
                                        } else {
                                            createSliderIntegerNode(descriptor, configuration)
                                        }
                                    } else if (configuration.item.textField) {
                                        createIntegerAreaTextNode(descriptor, configuration)
                                    }else{
                                        createIntegerTextNode(descriptor, configuration)
                                    }
                                }

                                Boolean::class.javaPrimitiveType -> createBooleanNode(descriptor, configuration)
                                Button::class.java -> createButtonNode(descriptor, configuration)
                                java.awt.Color::class.java -> createColorPickerNode(descriptor, configuration)
                                ModifierlessKeybind::class.java -> createHotKeyNode(descriptor, configuration)
                                String::class.java ->{
                                    if (configuration.item.textField) {
                                        createStringAreaTextNode(descriptor, configuration)
                                    }
                                    else{

                                        createStringTextNode(descriptor, configuration)
                                    }
                                }
                                else -> {
                                    if (configuration.type?.isEnum == true) {
                                        createEnumNode(descriptor, configuration)
                                    }
                                }
                            }
                        })
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
        Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(UI.darkThemeColors.background)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.8f).height(32.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(32.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Switch(toggled, onCheckedChange = {
                        ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                        toggled = it
                    }, enabled = true)
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }
    @Composable
    fun createHotKeyNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        val configStr = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!
        var keybind by remember {
            mutableStateOf(
                ConfigManager.stringToObject(
                    configStr,
                    ModifierlessKeybind::class.java
                ) as ModifierlessKeybind
            )
        }

        MaterialTheme(colors = UI.darkThemeColors) {


            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                OutlinedTextField(

                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                        )
                    },
                    value = keybind.toString(),
                    onValueChange = {
                        keybind.toString()
                        ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), keybind)
                    },
                    modifier = Modifier
                        .onKeyEvent {
                            if (it.type == KeyEventType.KeyDown) {
                                keybind = ModifierlessKeybind(it.key.nativeKeyCode, KeyEvent.KEY_PRESSED)

                            }
                            true
                        }.background(Color(0xFF242424), RoundedCornerShape(4.dp)).width(150.dp)
                )
            }
            Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
        }
    }

    @Composable
    fun createColorPickerNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {

        val getConfigColor by remember {
            mutableStateOf(
                Integer.valueOf(
                    ConfigManager.getConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key()
                    )
                )
            )
        }
        val setConfigColor = remember {
            mutableStateOf(ConfigManager.stringToObject(getConfigColor.toString(), Color::class.java))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(UI.darkThemeColors.background)
        ) {
            MaterialTheme(colors = UI.darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().height(275.dp)
        ) {
            HarmonyColorPicker(
                modifier = Modifier.height(275.dp).width(275.dp),
                color = Color(getConfigColor),
                onColorChanged = {
                    val thisCol = ColorUtil.hsvToRgb(floatArrayOf(it.hue, it.saturation, it.value))
                    val setCol = java.awt.Color(thisCol.component1(), thisCol.component2(), thisCol.component3())
                    setConfigColor.value = setCol
                    ConfigManager.setConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key(),
                        setCol
                    )
                }, harmonyMode = ColorHarmonyMode.SHADES
            )
        }


    }
    @Composable
    fun createSliderIntegerNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {

        var sliderValue by remember { mutableStateOf(0f) }
        val getInt by remember {
            mutableStateOf(
                Integer.valueOf(
                    ConfigManager.getConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key()
                    )
                )
            )
        }

        var setConfigValue by remember {
            mutableStateOf(ConfigManager.stringToObject(getInt.toString(), Int::class.java) as Int)
        }
        Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))) {
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(UI.darkThemeColors.background)
            ) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
                }
                Text(
                    text = setConfigValue.toString(),
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))
            ) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Slider(
                        value = sliderValue,
                        onValueChange = {


                            sliderValue = setConfigValue.toFloat()
                            setConfigValue = it.toInt()
                            ConfigManager.setConfiguration(
                                descriptor.group.value,
                                configItemDescriptor.key(),
                                it.toInt()
                            )
                            println(setConfigValue)
                        },
                        valueRange = configItemDescriptor.range!!.min.toFloat()..configItemDescriptor.range.max.toFloat(),
                        modifier = Modifier.padding(all = 0.dp),

                        )
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }
    @Composable
    fun createIntegerAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" +
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    configItemDescriptor.key()

                )) }
        Row(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))) {

            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))
            ) {
                MaterialTheme(colors = UI.darkThemeColors) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424)),
                        value = text,
                        onValueChange = {
                            text = it
                            ConfigManager.setConfiguration(
                                descriptor.group.value,
                                configItemDescriptor.key(),
                                it
                            )
                        },
                        label = {
                            Text(
                                configItemDescriptor.name(),
                                style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                            )
                        },
                        maxLines = 30,
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }
    @Composable
    fun createIntegerTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" + Integer.valueOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )) }

        Row(modifier = Modifier.fillMaxWidth().height(60.dp)){

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFF242424)),
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
                        maxLines = 30,
                        label = {Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 14.sp))},
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp))
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }
    @Composable
    fun createStringAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" +
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    configItemDescriptor.key()

                )) }
        Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))
            ) {
                MaterialTheme(colors = UI.darkThemeColors) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424)),
                        value = text,
                        onValueChange = {
                            text = it
                            ConfigManager.setConfiguration(
                                descriptor.group.value,
                                configItemDescriptor.key(),
                                it
                            )
                        },
                        label = {
                            Text(
                                configItemDescriptor.name(),
                                style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                            )
                        },
                        maxLines = 30,
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }
    @Composable
    fun createStringTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" +
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    configItemDescriptor.key()

                )) }
        Row(modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFF242424))){

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    OutlinedTextField(
                        value = text,
                        visualTransformation = if (!configItemDescriptor.secret()) VisualTransformation.None else PasswordVisualTransformation(),
                        onValueChange = {

                                ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(),
                                    it
                                )
                                text = it

                        },
                        label = {Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 14.sp))},
                        singleLine = true,
                        modifier = Modifier.padding(all = 0.dp),
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
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
        Row(modifier = Modifier.fillMaxWidth().height(32.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(32.dp)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Box(modifier = Modifier.fillMaxWidth().height(20.dp).wrapContentSize(Alignment.TopStart)) {
                        Text(list[selectedIndex].name, color = Color.Cyan, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true }).background(
                            Color(0xFF242424)
                        ))
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
                                    Text(text = s.toString(), color = Color.Cyan, fontSize = 14.sp)
                                })
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }

    @Composable
    fun createButtonNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
        var text by remember { mutableStateOf ("" + Integer.valueOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )) }
        Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(UI.darkThemeColors.background)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Text(configItemDescriptor.name(),style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    OutlinedButton(onClick = {
                        //TODO fix enum
                        Main.client.callbacks.post(Events.CONFIG_CHANGED, ConfigButtonClicked(descriptor.group.value, configItemDescriptor.key()))}
                    ) {
                        Text(configItemDescriptor.name())
                    }
                }
            }
        }
        Spacer(Modifier.height(4.dp).background(UI.darkThemeColors.background))
    }

}