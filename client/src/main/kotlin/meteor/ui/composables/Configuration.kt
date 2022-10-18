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
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.toolbar.sectionItem
import meteor.util.ColorUtil
import java.awt.event.KeyEvent

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
                    configs()

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
                    when {
                        configOpen.value -> configOpen.value = false
                        !pluginsOpen.value -> pluginsOpen.value = true
                    }
                }) {
                    Icon(
                        imageVector = Octicons.ChevronLeft24,
                        contentDescription = "Back to plugin page",
                        tint = uiColor,
                    )
                }
            }
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start) {
                Spacer(Modifier.width(20.dp))
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                        lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                        style = TextStyle(color = uiColor, fontSize = 24.sp),
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

            Switch(
                switchState.value,
                onPluginToggled(switchState, lastPlugin),
                enabled = true,
                modifier = Modifier.scale(0.75f),
                colors = SwitchDefaults.colors(checkedThumbColor = uiColor)
            )

        }
    }

}


@Composable
fun configs() {
    Column(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.background)
    ) {
        MaterialTheme(colors = darkThemeColors) {
            var descriptor: ConfigDescriptor? = null
            var toggledEnum = mutableStateOf(false)
            when {
                lastPlugin.config != null -> descriptor = ConfigManager.getConfigDescriptor(lastPlugin.config!!)
                lastPlugin.javaConfig != null -> descriptor = ConfigManager.getConfigDescriptor(lastPlugin.javaConfig!!)
            }

            if (descriptor != null) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    val sectList = descriptor.sections.sortedBy { it.section.name }.toMutableList()
                    val title = descriptor.titles.sortedBy { it.title.position }.toMutableList()
                    items(items = sectList) { sect ->
                        sectionItem(title = sect.name()) {
                            val sections =
                                descriptor.items.filter { it.item.section == sect.name() || sect.type == it.item.section }
                            sections.forEach { config ->
                                if (config.item.unhide.isBlank()) {
                                    when (config.type) {
                                        Int::class.javaPrimitiveType, Int::class.java -> {
                                            when {
                                                config.range != null -> sliderIntNode(descriptor, config)
                                                config.item.textArea -> intAreaTextNode(
                                                    descriptor,
                                                    config
                                                )
                                                else -> intTextNode(descriptor, config)
                                            }
                                        }
                                        Boolean::class.java -> {
                                            if (config.item.unhideKey == "")
                                                createBooleanNode(descriptor, config)
                                            else
                                                descriptor.items.filter { config.item.keyName == it.item.keyName }
                                                    .forEach { hidden ->
                                                        val toggled = remember { mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, hidden.key())!!.toBoolean()) }

                                                        Row(
                                                            modifier = Modifier.fillMaxWidth().height(32.dp)
                                                                .background(darkThemeColors.background)
                                                        ) {
                                                            Row(
                                                                verticalAlignment = Alignment.CenterVertically,
                                                                horizontalArrangement = Arrangement.Start,
                                                                modifier = Modifier.fillMaxWidth(0.8f).height(32.dp)
                                                                    .background(darkThemeColors.background)
                                                            ) {
                                                                Text(hidden.name(), style = TextStyle(uiColor, 14.sp))
                                                            }
                                                            Row(
                                                                verticalAlignment = Alignment.CenterVertically,
                                                                horizontalArrangement = Arrangement.End,
                                                                modifier = Modifier.fillMaxWidth().height(32.dp)
                                                                    .background(darkThemeColors.background)
                                                            ) {
                                                                Switch(toggled.value, onCheckedChange = {
                                                                    ConfigManager.setConfiguration(descriptor.group.value, hidden.key(), it)
                                                                    toggled.value = it
                                                                }, enabled = true, modifier = Modifier.scale(0.85f))
                                                            }
                                                        }

                                                        when {
                                                            toggled.value ->
                                                                descriptor.items.filter { it.item.unhide == hidden.item.unhideKey }
                                                                    .forEach { hiddenItem ->
                                                                        when (hiddenItem.type) {
                                                                            Int::class.javaPrimitiveType, Int::class.java -> {
                                                                                when {
                                                                                    hiddenItem.range != null -> sliderIntNode(descriptor, hiddenItem)
                                                                                    hiddenItem.item.textArea -> intAreaTextNode(descriptor, hiddenItem)
                                                                                    else -> intTextNode(descriptor, hiddenItem
                                                                                    )
                                                                                }
                                                                            }
                                                                            Boolean::class.javaPrimitiveType -> createBooleanNode(descriptor,hiddenItem)
                                                                            java.awt.Color::class.java -> colorPickerNode(descriptor, hiddenItem)
                                                                            ModifierlessKeybind::class.java -> hotKeyNode(descriptor, hiddenItem)
                                                                            String::class.java -> {
                                                                                when {
                                                                                    hiddenItem.item.textArea -> stringAreaTextNode(descriptor, hiddenItem)
                                                                                    else -> stringTextNode(descriptor, hiddenItem)
                                                                                }
                                                                            }

                                                                            else -> if (hiddenItem.type?.isEnum == true) createEnumNode(descriptor, hiddenItem)

                                                                        }
                                                                    }
                                                        }
                                                    }
                                        }

                                        java.awt.Color::class.java -> colorPickerNode(descriptor, config)
                                        ModifierlessKeybind::class.java -> hotKeyNode(descriptor, config)
                                        String::class.java -> {
                                            when {
                                                config.item.textArea -> stringAreaTextNode(descriptor, config)
                                                else -> stringTextNode(descriptor, config)
                                            }
                                        }
                                        else -> if (config.type?.isEnum == true) {
                                            createEnumNode(descriptor, config)
                                        }
                                    }

                                }

                            }
                        }

                    }

                    items(items = title) {

                        BoxWithConstraints(
                            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth().padding(it.title.padding.dp),
                                text = it.name(),
                                style = TextStyle(
                                    color = uiColor,
                                    fontSize = it.title.size.sp,
                                    textAlign = TextAlign.Center,
                                )

                            )
                        }

                    }

                    items(items = descriptor.items.filter { it.item.section.isEmpty() })
                    { config ->

                            when (config.type) {
                                Int::class.javaPrimitiveType, Int::class.java -> {
                                    when {
                                        config.range != null -> sliderIntNode(descriptor, config)
                                        config.item.textArea -> intAreaTextNode(
                                            descriptor,
                                            config
                                        )
                                        else -> intTextNode(descriptor, config)
                                    }
                                }
                                Boolean::class.java -> {
                                    if (config.item.unhideKey == "")
                                        createBooleanNode(descriptor, config)
                                    else
                                        descriptor.items.filter { config.item.keyName == it.item.keyName }
                                            .forEach { hidden ->
                                                val toggled = remember { mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, hidden.key())!!.toBoolean()) }

                                                Row(
                                                    modifier = Modifier.fillMaxWidth().height(32.dp)
                                                        .background(darkThemeColors.background)
                                                ) {
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.Start,
                                                        modifier = Modifier.fillMaxWidth(0.8f).height(32.dp)
                                                            .background(darkThemeColors.background)
                                                    ) {
                                                        Text(hidden.name(), style = TextStyle(uiColor, 14.sp))
                                                    }
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.End,
                                                        modifier = Modifier.fillMaxWidth().height(32.dp)
                                                            .background(darkThemeColors.background)
                                                    ) {
                                                        Switch(toggled.value, onCheckedChange = {
                                                            ConfigManager.setConfiguration(descriptor.group.value, hidden.key(), it)
                                                            toggled.value = it
                                                        }, enabled = true, modifier = Modifier.scale(0.85f))
                                                    }
                                                }

                                                when {
                                                    toggled.value ->
                                                        descriptor.items.filter { it.item.unhide == hidden.item.unhideKey }
                                                            .forEach { hiddenItem ->
                                                                when (hiddenItem.type) {
                                                                    Int::class.javaPrimitiveType, Int::class.java -> {
                                                                        when {
                                                                            hiddenItem.range != null -> sliderIntNode(descriptor, hiddenItem)
                                                                            hiddenItem.item.textArea -> intAreaTextNode(descriptor, hiddenItem)
                                                                            else -> intTextNode(descriptor, hiddenItem
                                                                            )
                                                                        }
                                                                    }
                                                                    Boolean::class.javaPrimitiveType -> createBooleanNode(descriptor,hiddenItem)
                                                                    java.awt.Color::class.java -> colorPickerNode(descriptor, hiddenItem)
                                                                    ModifierlessKeybind::class.java -> hotKeyNode(descriptor, hiddenItem)
                                                                    String::class.java -> {
                                                                        when {
                                                                            hiddenItem.item.textArea -> stringAreaTextNode(descriptor, hiddenItem)
                                                                            else -> stringTextNode(descriptor, hiddenItem)
                                                                        }
                                                                    }
                                                                    else -> if (hiddenItem.type?.isEnum == true) createEnumNode(descriptor, hiddenItem)
                                                                }
                                                            }
                                                }
                                            }
                                }

                                java.awt.Color::class.java -> colorPickerNode(descriptor, config)
                                ModifierlessKeybind::class.java -> hotKeyNode(descriptor, config)
                                String::class.java -> {
                                    when {
                                        config.item.textArea -> stringAreaTextNode(descriptor, config)
                                        else -> stringTextNode(descriptor, config)
                                    }
                                }
                                else -> if (config.type?.isEnum == true) {
                                    createEnumNode(descriptor, config)
                                }
                            }



                    }

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
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor, fontSize = 14.sp))
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
fun hotKeyNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    val configStr = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!
    var keyBind by remember {
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
                        style = TextStyle(color = uiColor, fontSize = 14.sp)
                    )
                },
                value = keyBind.toString(),
                onValueChange = {
                    keyBind.toString()
                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), keyBind)
                },
                modifier = Modifier
                    .onKeyEvent {
                        if (it.type == KeyEventType.KeyDown) {
                            keyBind = ModifierlessKeybind(it.key.nativeKeyCode, KeyEvent.KEY_PRESSED)

                        }
                        true
                    }.background(darkThemeColors.background, RoundedCornerShape(4.dp)).width(150.dp)
            )
        }
        Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
    }
}

@Composable
fun colorPickerNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    val getConfigColor by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )?.toInt()
        )
    }
    val setConfigColor =
        remember { mutableStateOf(ConfigManager.stringToObject(getConfigColor.toString(), Color::class.java)) }
    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(darkThemeColors.background)
    ) {
        MaterialTheme(colors = darkThemeColors) {
            Text(configItemDescriptor.name(), style = TextStyle(color = uiColor, fontSize = 14.sp))
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().height(275.dp)
    ) {
        HarmonyColorPicker(
            modifier = Modifier.height(275.dp).width(275.dp),
            color = Color(getConfigColor!!),
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
fun sliderIntNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {

    var sliderValue by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            )
        )
    }
    var setConfigValue by remember {
        mutableStateOf(
            ConfigManager.stringToObject(
                sliderValue.toString(),
                Int::class.java
            ) as Int
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(46.dp).background(Color(0xFF242424))) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.5f).height(46.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor, fontSize = 14.sp))
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(46.dp).background(Color(0xFF242424))
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(
                    text = setConfigValue.toString(),
                    modifier = Modifier.padding(8.dp).width(46.dp),
                    style = TextStyle(color = uiColor, fontSize = 14.sp, textAlign = TextAlign.Center)
                )
                Spacer(Modifier.width(5.dp).background(darkThemeColors.background))
                Slider(
                    value = sliderValue!!.toFloat(),
                    onValueChange = {
                        sliderValue = setConfigValue.toString()
                        setConfigValue = it.toInt()
                        ConfigManager.setConfiguration(
                            descriptor.group.value,
                            configItemDescriptor.key(),
                            it.toInt()
                        )
                    },
                    valueRange = configItemDescriptor.range!!.min.toFloat()..configItemDescriptor.range.max.toFloat(),
                    modifier = Modifier.height(12.dp).background(darkThemeColors.background)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun intAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
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
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    maxLines = 30,
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun intTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
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
                    visualTransformation = if (configItemDescriptor.secret()) PasswordVisualTransformation() else VisualTransformation.None,
                    onValueChange = {
                        text = it
                        ConfigManager.setConfiguration(
                            descriptor.group.value, configItemDescriptor.key(),
                            it
                        )

                    },
                    maxLines = 30,
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun stringAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
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
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    maxLines = 30,
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun stringTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
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
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.padding(all = 3.dp).fillMaxWidth(),
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun createEnumNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var expanded by remember { mutableStateOf(false) }
    var configStr = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!
    Row(modifier = Modifier.fillMaxWidth().height(32.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp)
        ) {

            MaterialTheme(colors = darkThemeColors) {
                Box(modifier = Modifier.fillMaxWidth().height(20.dp).wrapContentSize(Alignment.TopStart)) {

                    Text(
                        configStr,
                        color = uiColor,
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
                        configItemDescriptor.type?.enumConstants?.forEach {
                            DropdownMenuItem(onClick = {
                                expanded = false
                                configStr = it.toString()
                                ConfigManager.setConfiguration(
                                    descriptor.group.value,
                                    configItemDescriptor.key(),
                                    it
                                )
                                //println(it.toString())
                            }, content = {
                                Text(text = it.toString(), color = uiColor, fontSize = 14.sp)
                            })
                        }
                    }

                }
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}


