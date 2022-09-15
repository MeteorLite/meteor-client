package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import compose.icons.Octicons
import compose.icons.octicons.ChevronLeft24
import compose.icons.octicons.Sync24
import eventbus.Events
import eventbus.events.ConfigButtonClicked
import meteor.Main
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.plugins.PluginDescriptor
import meteor.util.ColorUtil
import java.awt.Button
import java.awt.event.KeyEvent
import java.util.stream.Collectors


@Composable
fun ConfigPanel() {

    var mod = Modifier.background(darkThemeColors.surface).fillMaxHeight().width(375.dp)

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = mod
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight()
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    ConfigPanelHeader()
                    Configs()

                }
            }
        }
    }
}

@Composable
fun ConfigPanelHeader() {

    Row {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.85f).height(35.dp)
        ) {
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start) {
                IconButton(modifier = Modifier.padding(top = 10.dp), onClick = {

                    if (configOpen.value) {
                        configOpen.value = false
                    }
                    if (!pluginsOpen.value)
                        pluginsOpen.value = true
                }) {
                    Icon(
                        imageVector = Octicons.ChevronLeft24,
                        contentDescription = "Back to plugin page",
                        tint = Color.Cyan
                    )
                }
            }
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start) {
                Spacer(Modifier.width(20.dp))
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                        lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                        style = TextStyle(color = Color.Cyan, fontSize = 24.sp),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }

        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
        ) {
            val switchState = remember { mutableStateOf(lastPlugin.shouldEnable()) }
/*            IconButton(onClick = {
                lastPlugin.config?.let {
                    println("should reset")
                    ConfigManager.setDefaultConfiguration(it.javaClass, true)
                    configOpen.value = false
                }
            }) {
                Icon(
                    imageVector = Octicons.Sync24,
                    contentDescription = "Reset Configuration",
                    tint = Color.Cyan
                )
            }*/
            Switch(
                switchState.value,
                onPluginToggled(switchState, lastPlugin),
                enabled = true,
                modifier = Modifier.scale(0.75f),
                colors = SwitchDefaults.colors(checkedThumbColor = Color(133, 255, 215))
            )

        }
    }

}


@Composable
fun Configs() {
    Column(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.background)
    ) {
        MaterialTheme(colors = darkThemeColors) {
            var descriptor: ConfigDescriptor? = null
            if (lastPlugin.config != null)
                descriptor = ConfigManager.getConfigDescriptor(lastPlugin.config!!)
            else if (lastPlugin.javaConfig != null)
                descriptor = ConfigManager.getConfigDescriptor(lastPlugin.javaConfig!!)

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
                                } else {
                                    createIntegerTextNode(descriptor, configuration)
                                }
                            }

                            Boolean::class.javaPrimitiveType -> createBooleanNode(descriptor, configuration)
                            Button::class.java -> createButtonNode(descriptor, configuration)
                            java.awt.Color::class.java -> createColorPickerNode(descriptor, configuration)
                            ModifierlessKeybind::class.java -> createHotKeyNode(descriptor, configuration)
                            String::class.java -> {
                                if (configuration.item.textField) {
                                    createStringAreaTextNode(descriptor, configuration)
                                } else {

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
    var toggled by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toBoolean()
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(darkThemeColors.background)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.8f).height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Switch(toggled, onCheckedChange = {
                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                    toggled = it
                }, enabled = true, modifier = Modifier.scale(0.85f))
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
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

    MaterialTheme(colors = darkThemeColors) {


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
        Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
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
        modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(darkThemeColors.background)
    ) {
        MaterialTheme(colors = darkThemeColors) {
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

    var sliderValue by remember { mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!.toFloat()) }
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
            modifier = Modifier.fillMaxWidth(0.5f).height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(
                    text = setConfigValue.toString(),
                    modifier = Modifier.padding(8.dp).width(30.dp),
                    style = TextStyle(color = Color.Cyan, fontSize = 14.sp, textAlign = TextAlign.Center)
                )
                Spacer(Modifier.width(5.dp).background(darkThemeColors.background))
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
                    modifier = Modifier.padding(all = 0.dp).background(darkThemeColors.background)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createIntegerAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            "" +
                    ConfigManager.getConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key()

                    )
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))) {

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(100.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(all = 3.dp),
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
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createIntegerTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            "" + Integer.valueOf(
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    configItemDescriptor.key()
                )
            )
        )
    }

    Row(modifier = Modifier.fillMaxWidth().height(60.dp)) {

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().height(60.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(all = 3.dp),
                    value = text,
                    visualTransformation = if (!configItemDescriptor.secret()) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange = {
                        try {
                            ConfigManager.setConfiguration(
                                descriptor.group.value, configItemDescriptor.key(),
                                it
                            )
                            text = it
                        } catch (_: Exception) {
                        }
                    },
                    maxLines = 30,
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                        )
                    },
                    textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createStringAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            "" +
                    ConfigManager.getConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key()

                    )
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(100.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(all = 3.dp),
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
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createStringTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            "" +
                    ConfigManager.getConfiguration(
                        descriptor.group.value,
                        configItemDescriptor.key()

                    )
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(60.dp).background(darkThemeColors.background)) {

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(60.dp)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    value = text,
                    visualTransformation = if (!configItemDescriptor.secret()) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange = {

                        ConfigManager.setConfiguration(
                            descriptor.group.value, configItemDescriptor.key(),
                            it
                        )
                        text = it

                    },
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.padding(all = 3.dp).fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createEnumNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var expanded by remember { mutableStateOf(false) }
    val type = configItemDescriptor.type
    val currentConfigEnum =
        java.lang.Enum.valueOf(
            type as Class<out Enum<*>>, ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )!!
        )
    val list: MutableList<Enum<*>> = ArrayList()
    var currentToSet: Enum<*>? = null
    for (o in type.enumConstants) {
        if (o == currentConfigEnum) {
            currentToSet = o
        }
        list.add(o)
    }
    var selectedIndex by remember { mutableStateOf(list.indexOf(currentToSet)) }
    Row(modifier = Modifier.fillMaxWidth().height(32.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Box(modifier = Modifier.fillMaxWidth().height(20.dp).wrapContentSize(Alignment.TopStart)) {
                    Text(
                        list[selectedIndex].name,
                        color = Color.Cyan,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true })
                            .background(
                                Color(0xFF242424)
                            )
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(375.dp).padding(horizontal = 5.dp)
                    ) {
                        list.forEachIndexed { index, s ->
                            DropdownMenuItem(onClick = {
                                selectedIndex = index
                                expanded = false
                                ConfigManager.setConfiguration(
                                    descriptor.group.value,
                                    configItemDescriptor.key(),
                                    list[selectedIndex].name
                                )
                            }, content = {
                                Text(text = s.toString(), color = Color.Cyan, fontSize = 14.sp)
                            })
                        }
                    }
                }
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createButtonNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            "" + Integer.valueOf(
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    configItemDescriptor.key()
                )
            )
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = Color.Cyan, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp).background(Color(0xFF242424))
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedButton(onClick = {
                    //TODO fix enum
                    Main.client.callbacks.post(
                        Events.CONFIG_CHANGED,
                        ConfigButtonClicked(descriptor.group.value, configItemDescriptor.key())
                    )
                }
                ) {
                    Text(configItemDescriptor.name())
                }
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

