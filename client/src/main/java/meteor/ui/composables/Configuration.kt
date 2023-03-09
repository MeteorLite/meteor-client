package meteor.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.TooltipPlacement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.ChevronLeft24
import meteor.config.ConfigManager
import meteor.config.legacy.ModifierlessKeybind
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.items.*
import meteor.ui.composables.nodes.*
import meteor.ui.composables.preferences.*
import meteor.ui.composables.ui.onPluginToggled

@Composable
fun configPanel() {
    val mod = Modifier.background(if (darkLightMode.value) darkThemeColors.background else lightThemeColors.background
    ).fillMaxHeight().width(300.dp)
    Column {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = mod
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    configPanelHeader()
                    configs()
                }
            }
        }
    }
}

val stringValues = HashMap<String, MutableState<String?>>()

val intValues = HashMap<String, MutableState<Int?>>()

val booleanValues = HashMap<String, MutableState<Boolean?>>()

fun updateStringValue(group: String, key: String, stringValue: String) {
    stringValues["$group:$key"]?.value = stringValue
}

fun updateIntValue(group: String, key: String, intValue: Int) {
    intValues["$group:$key"]?.value = intValue
}

fun updateBooleanValue(group: String, key: String, booleanValue: Boolean) {
    booleanValues["$group:$key"]?.value = booleanValue
}

val composePanelMap = HashMap<String, @Composable () -> Unit?>()

@Composable
fun configs(){
    LazyColumn(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
        modifier = Modifier.width(300.dp).fillMaxHeight().background(background ).padding(start = 4.dp)
    ) {
        val composePanelItems = descriptor.items.filter { it.item.composePanel && it.item.section.isEmpty() }.toMutableList()
        items(items = composePanelItems) { composePanel ->
            composePanelItems.forEach {
                val key = "${descriptor.group.value}:${it.key()}"
                if (composePanel.position() == 0) {
                    composePanelMap[key]!!.invoke()
                }
            }
        }
        val title = descriptor.titles.sortedBy { it.title.position }.toMutableList()
        items(items = title) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(it.title.padding.dp),
                    text = it.name(),
                    style = TextStyle(
                        color = uiColor.value,
                        fontSize = it.title.size.sp,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
        items(items = descriptor.sections.sortedBy { it.section.name }.toMutableList()) { sect ->
            sectionItem(title = sect.name()) {
                val sections =
                    descriptor.items.filter { it.item.section == sect.name() || sect.type == it.item.section }
                sections.forEach { config ->
                    val key = "${descriptor.group.value}:${config.key()}"
                    if (config.item.composePanel) {
                        if (config.item.position != 0)
                            composePanelMap[key]!!.invoke()
                    }
                    else if (config.item.unhide.isBlank()) {
                        when (config.type) {
                            Int::class.javaPrimitiveType, Int::class.java -> {
                                intValues[key]?.let {
                                    it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toInt()
                                }
                                if (intValues[key] == null)
                                    intValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toInt())

                                when {
                                    config.item.textArea -> intAreaTextNode(
                                        descriptor,
                                        config,
                                        intValues[key]!!
                                    )
                                    else -> intTextNode(descriptor, config, intValues[key]!!)
                                }
                            }
                            Boolean::class.java -> {
                                booleanValues[key]?.let {
                                    it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toBoolean()
                                }
                                if (booleanValues[key] == null)
                                    booleanValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toBoolean())

                                if (config.item.unhideKey == "")
                                    booleanNode(descriptor, config, booleanValues[key]!!)
                                else hiddenItems(config)
                            }
                            java.awt.Color::class.java -> colorPickerNode(descriptor, config)
                            ModifierlessKeybind::class.java -> hotKeyNode(descriptor, config)
                            String::class.java -> {
                                when {
                                    config.item.textArea -> stringAreaTextNode(descriptor, config)
                                    else -> {
                                        val key = "${descriptor.group.value}:${config.key()}"
                                        stringValues[key]?.let {
                                            it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())
                                        }
                                        if (stringValues[key] == null)
                                            stringValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key()))
                                        stringTextNode(descriptor, config, stringValues[key]!!)
                                    }
                                }
                            }
                            else -> if (config.type?.isEnum == true) {

                                if(config.item.unhideKey.isEmpty()) {
                                    enumNode(descriptor, config)
                                }else
                                    unhideEnum(config)
                            }
                        }

                    }

                }
            }
        }
        items(items = descriptor.items.toTypedArray())
        { config ->
            val key = "${descriptor.group.value}:${config.key()}"

            if (config.item.section.isEmpty()) {
                var hidden = true
                if (!config.item.hidden) {
                    hidden = false
                }
                if (config.item.hidden && config.item.unhide.isNotEmpty()) {
                    val value = ConfigManager.getConfiguration(
                        descriptor.group.value,
                        config.item.unhide
                    )
                    value?.let {
                        if (it.isNotEmpty())
                            hidden = !it.toBoolean()
                    }
                }
                if (config.item.composePanel && config.item.position != 0) {
                    composePanelMap[key]!!.invoke()
                }
                else if (!hidden)
                    when (config.type) {
                        Int::class.javaPrimitiveType, Int::class.java -> {
                            intValues[key]?.let {
                                it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toInt()
                            }
                            if (intValues[key] == null)
                                intValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toInt())
                            when {
                                config.item.textArea -> intAreaTextNode(
                                    descriptor,
                                    config, intValues[key]!!
                                )
                                else -> intTextNode(descriptor, config, intValues[key]!!)
                            }
                        }
                        Boolean::class.java -> {
                            booleanValues[key]?.let {
                                it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toBoolean()
                            }
                            if (booleanValues[key] == null)
                                booleanValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key())?.toBoolean())

                            booleanNode(descriptor, config, booleanValues[key]!!)
                        }

                        java.awt.Color::class.java -> colorPickerNode(descriptor, config)
                        ModifierlessKeybind::class.java -> hotKeyNode(descriptor, config)
                        String::class.java -> {
                            stringValues[key]?.let {
                                it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())
                            }
                            if (stringValues[key] == null)
                                stringValues[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key()))

                            when {
                                config.item.textArea -> stringAreaTextNode(descriptor, config)
                                else -> {
                                    stringTextNode(descriptor, config, stringValues[key]!!)
                                }
                            }
                        }
                        else -> if (config.type?.isEnum == true) {
                            enumNode(descriptor, config)
                        }
                    }
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun configPanelHeader() {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().height(42.dp).background(surface)
        ) {
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(40.dp)) {
                IconButton( onClick = {
                    when {
                        configOpen.value -> configOpen.value = false
                    }
                    pluginsOpen.value = true
                }) {
                    Icon(
                        imageVector = Octicons.ChevronLeft24,
                        contentDescription = "Back to plugin page",
                        tint = uiColor.value,
                    )
                }
            }
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(180.dp)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                        lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                        style = TextStyle(color = uiColor.value, fontSize = 18.sp, textAlign = TextAlign.Left),
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                TooltipArea(
                    modifier = Modifier.background(
                        shape = RoundedCornerShape(16.dp), color = surface
                    ), tooltipPlacement = TooltipPlacement.ComponentRect(offset = DpOffset(x = 15.dp, y = 0.dp)), tooltip = {
                        val descriptionText = "Reset plugin configuration"
                        if (descriptionText.isNotEmpty()) {
                            Box(modifier = Modifier.sizeIn(minWidth = 200.dp, minHeight = 10.dp, maxWidth = 200.dp, maxHeight = 200.dp)
                                .background(color = surface, RoundedCornerShape(5.dp)), contentAlignment = Alignment.Center)
                            {
                                Text(
                                    descriptionText,
                                    style = TextStyle(
                                        color = uiColor.value,
                                        textAlign = TextAlign.Center,
                                        letterSpacing = 2.sp,
                                        fontSize = pluginListSize.value.sp,
                                        fontWeight = FontWeight.Medium
                                    ),
                                    modifier = Modifier.padding(vertical = 5.dp)
                                )
                            }
                        }
                    }) {
                    IconButton(
                        onClick = {
                            ConfigManager.setDefaultConfiguration(lastPlugin.configuration as Any, true)
                            lastPlugin.resetConfiguration()

                            //I'm lazy af so we just close the panel. FUCKING SUE ME
                            configOpen.value = false
                            pluginsOpen.value = true
                        },

                        ) {
                        Icon(
                            Icons.Outlined.Refresh,
                            contentDescription = "Reset plugin configuration",
                            tint = uiColor.value
                        )
                    }
                }

                val switchState = remember { mutableStateOf(lastPlugin.shouldEnable()) }
                Switch(
                    switchState.value,
                    onPluginToggled(switchState, lastPlugin,true),
                    enabled = true,
                    modifier = Modifier.scale(0.75f),
                    colors = SwitchDefaults.colors(checkedThumbColor = uiColor.value, uncheckedThumbColor = Color.DarkGray, uncheckedTrackColor = Color.LightGray)
                )
            }
    }
}










