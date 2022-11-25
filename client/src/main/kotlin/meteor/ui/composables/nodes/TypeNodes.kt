package meteor.ui.composables.nodes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godaddy.android.colorpicker.harmony.ColorHarmonyMode
import com.godaddy.android.colorpicker.harmony.HarmonyColorPicker
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.preferences.background
import meteor.ui.composables.preferences.darkThemeColors
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import meteor.util.ColorUtil
import java.awt.event.KeyEvent

@Composable
fun booleanNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var toggled by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toBoolean()
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(background ) ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.8f).height(32.dp).background(background )
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(32.dp).background(background )
        ) {
            MaterialTheme(colors = darkThemeColors) {

                Checkbox(toggled, onCheckedChange = {
                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                    toggled = it
                }, enabled = true, modifier = Modifier.scale(0.85f), colors = CheckboxDefaults.colors(checkedColor = uiColor.value, uncheckedColor = surface))
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background ) )
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
                        style = TextStyle(color = uiColor.value, fontSize = 14.sp)
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
        Spacer(Modifier.height(4.dp).background(background ) )
    }
}

@Composable
fun colorPickerNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    println(descriptor.group.value + ":" + configItemDescriptor.key())
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
        modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(background )
    ) {
        MaterialTheme(colors = darkThemeColors) {
            Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
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
fun enumNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var expanded by remember { mutableStateOf(false) }
    var configStr = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!
    Row(modifier = Modifier.fillMaxWidth().height(32.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(background )
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
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
                        color = uiColor.value,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true })
                            .background(
                                surface
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
                                Text(text = it.toString(), color = uiColor.value, fontSize = 14.sp)
                            })
                        }
                    }

                }
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background ) )
}