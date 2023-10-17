package meteor.ui.composables.nodes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.DpOffset
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
import meteor.util.FontUtil
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.util.*

@Composable
fun booleanNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor, booleanValue: MutableState<Boolean?>) {
    Row(modifier = Modifier.fillMaxWidth().height(32.dp).background(background)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth(0.8f).height(32.dp).background(background)) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth().height(32.dp).background(background)) {
            MaterialTheme(colors = darkThemeColors) {
                Checkbox(booleanValue.value!!, onCheckedChange = {
                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                    booleanValue.value = it
                }, enabled = true, modifier = Modifier.scale(0.85f), colors = CheckboxDefaults.colors(checkedColor = uiColor.value, uncheckedColor = surface))
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background))
}

var ctrlPressed = false
var altPressed = false

@Composable
fun hotKeyNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    val configStr = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())!!
    var keyBind by remember {
        mutableStateOf(ConfigManager.stringToObject(configStr, ModifierlessKeybind::class.java) as ModifierlessKeybind)
    }
    MaterialTheme(colors = darkThemeColors) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth().height(60.dp)) {
            OutlinedTextField(textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp, textDirection = TextDirection.Ltr/*, fontFamily = FontUtil.righteous*/), label = {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
            }, value = keyBind.toString(), onValueChange = {
                keyBind.toString()
            }, modifier = Modifier.onKeyEvent {
                if (it.type == KeyEventType.KeyDown) {
                    if (it.key.nativeKeyCode == KeyEvent.VK_ALT) {
                        altPressed = true
                    }
                    if (it.key.nativeKeyCode == KeyEvent.VK_CONTROL) {
                        ctrlPressed = true
                    }
                }
                if (it.type == KeyEventType.KeyUp) {
                    if (it.key.nativeKeyCode == KeyEvent.VK_ALT) {
                        altPressed = false
                    }
                    if (it.key.nativeKeyCode == KeyEvent.VK_CONTROL) {
                        ctrlPressed = false
                    }
                }

                if (it.type == KeyEventType.KeyDown) {
                    var modifier = 0

                    if (altPressed) {
                        modifier = InputEvent.ALT_DOWN_MASK
                    }
                    else if (ctrlPressed)
                        modifier = InputEvent.CTRL_DOWN_MASK

                    keyBind = ModifierlessKeybind(it.key.nativeKeyCode, modifier)
                    ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), keyBind)
                }
                true
            }.background(darkThemeColors.background, RoundedCornerShape(4.dp)).width(150.dp))
        }
        Spacer(Modifier.height(4.dp).background(background))
    }
}

@Composable
fun colorPickerNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    val getConfigColor by remember {
        mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())?.toInt())
    }
    val setConfigColor = remember { mutableStateOf(ConfigManager.stringToObject(getConfigColor.toString(), Color::class.java)) }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(background)) {
        MaterialTheme(colors = darkThemeColors) {
            Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().height(275.dp)) {
        HarmonyColorPicker(modifier = Modifier.height(275.dp).width(275.dp), color = Color(getConfigColor!!), onColorChanged = {
            val thisCol = ColorUtil.hsvToRgb(floatArrayOf(it.hue, it.saturation, it.value))
            val setCol = java.awt.Color(thisCol.component1(), thisCol.component2(), thisCol.component3())
            setConfigColor.value = setCol
            ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), setCol)
        }, harmonyMode = ColorHarmonyMode.SHADES)
    }
}


@Composable
fun enumNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText = ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())

    configItemDescriptor.type?.enumConstants?.let {
        var foundMatch = false
        for (enum in it) {
            if (selectedText?.equals(enum.toString()) == true) {
                selectedText = enum.toString().split("_").joinToString(" ") { it.capitalize() }
                foundMatch = true
                break
            }
            if (enum.toString().equals(selectedText?.split("_")?.joinToString(" "), ignoreCase = true)) {
                selectedText = enum.toString().split("_").joinToString(" ") { it.capitalize() }
                foundMatch = true
                break
            }
        }

        if (!foundMatch) {
            println("Mismatching enum member/name")
            println("expected: $selectedText")
            for (enum in it) {
                println("found: $enum")
            }
        }
    }

    val selectedDropDownText = mutableStateOf(selectedText)

    Row(modifier = Modifier.fillMaxWidth().height(32.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(background)) {
            MaterialTheme(colors = darkThemeColors) {
                Text(configItemDescriptor.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth().height(32.dp)) {

            MaterialTheme(colors = darkThemeColors) {
                Box(modifier = Modifier.fillMaxWidth().height(30.dp).wrapContentSize(Alignment.TopStart).border(border = BorderStroke(2.dp, surface), shape = RoundedCornerShape(4.dp))) {

                    Text(selectedDropDownText.value ?: "", color = uiColor.value, textAlign = TextAlign.Center, fontSize = 12.sp, modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable(onClick = { expanded = true }).background(
                        background).wrapContentHeight())

                    DropdownMenu(offset = DpOffset(x = -2.dp, y = 1.dp), expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.width(122.dp).background(
                        surface).border(border = BorderStroke(4.dp, surface))) {
                        configItemDescriptor.type?.enumConstants?.forEach {
                            DropdownMenuItem(modifier = Modifier.background(surface), onClick = {
                                expanded = false
                                ConfigManager.setConfiguration(descriptor.group.value, configItemDescriptor.key(), it)
                                selectedDropDownText.value = it.toString().split("_").joinToString { it.capitalize() }
                            }) {
                                Text(text = it.toString().split("_").joinToString(" ") { it.capitalize() }, color = uiColor.value, textAlign = TextAlign.Center, fontSize = 12.sp, maxLines = 1, modifier = Modifier.fillMaxWidth().fillMaxHeight().wrapContentWidth())
                            }
                        }
                    }
                }
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background))
}