package meteor.ui.composables.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.nodes.*
import meteor.ui.composables.preferences.*


@Composable
fun unhideEnum(config : ConfigItemDescriptor){
            val toggledEnum = remember { mutableStateOf(false) }
    descriptor.items.filter { config.item.keyName == it.item.keyName }
        .forEach { hiddenEnum ->

            var expanded by remember { mutableStateOf(false) }
            var configStr = ConfigManager.getConfiguration(descriptor.group.value, hiddenEnum.key())!!
            Row(modifier = Modifier.fillMaxWidth().height(32.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(0.6f).height(32.dp).background(background )
                ) {
                    MaterialTheme(colors = darkThemeColors) {
                        Text(hiddenEnum.name(), style = TextStyle(color = uiColor.value, fontSize = 14.sp))
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
                                        Color(0xFF242424)
                                    )
                            )

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier.width(300.dp).padding(horizontal = 5.dp)
                            ) {
                                hiddenEnum.type?.enumConstants?.forEach { ec->
                                    DropdownMenuItem(onClick = {
                                        expanded = false
                                        configStr = ec.toString().split("_").joinToString(" ") { it.capitalize() }
                                        ConfigManager.setConfiguration(
                                            descriptor.group.value,
                                            hiddenEnum.key(),
                                            ec.toString()

                                        )
                                        for (it in descriptor.items.filter {ec.toString() != it.item.unhideValue}) {
                                            toggledEnum.value = false
                                        }
                                        for (it in descriptor.items.filter {ec.toString() == it.item.unhideValue}) {
                                            toggledEnum.value = true
                                        }

                                    }, content = {
                                        Text(text = ec.toString().split("_").joinToString(" ") { it.capitalize() }, color = uiColor.value, fontSize = 14.sp)
                                    })
                                }
                            }

                        }
                    }
                }
            }
            Spacer(Modifier.height(4.dp).background(background ) )
            when {
                toggledEnum.value ->
                    descriptor.items.filter { it.item.unhide == hiddenEnum.key() }
                        .forEach { hiddenItem ->
                            when (hiddenItem.type) {
                                Int::class.javaPrimitiveType, Int::class.java -> {
                                    when {
                                        hiddenItem.range != null -> sliderIntNode(
                                            descriptor,
                                            hiddenItem
                                        )
                                        hiddenItem.item.textArea -> intAreaTextNode(
                                            descriptor,
                                            hiddenItem
                                        )
                                        else -> intTextNode(
                                            descriptor, hiddenItem
                                        )
                                    }
                                }
                                Boolean::class.javaPrimitiveType -> booleanNode(
                                    descriptor,
                                    hiddenItem
                                )
                                java.awt.Color::class.java -> colorPickerNode(
                                    descriptor,
                                    hiddenItem
                                )
                                ModifierlessKeybind::class.java -> hotKeyNode(
                                    descriptor,
                                    hiddenItem
                                )
                                String::class.java -> {
                                    when {
                                        hiddenItem.item.textArea -> stringAreaTextNode(
                                            descriptor,
                                            hiddenItem
                                        )
                                        else -> stringTextNode(
                                            descriptor,
                                            hiddenItem,
                                            mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, hiddenItem.key())!!)
                                        )
                                    }
                                }

                                else -> if (hiddenItem.type?.isEnum == true) enumNode(
                                    descriptor,
                                    hiddenItem
                                )

                            }
                        }
            }


        }
}
@Composable
fun hiddenItems(config : ConfigItemDescriptor){
    descriptor.items.filter { config.item.keyName == it.item.keyName }.forEach { hidden ->
        val toggled = remember {
            mutableStateOf(
                ConfigManager.getConfiguration(
                    descriptor.group.value,
                    hidden.key()
                )!!.toBoolean()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().height(32.dp)
                .background(background )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(0.8f).height(32.dp)
                    .background(background )
            ) {
                Text(hidden.name(), style = TextStyle(uiColor.value, 14.sp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth().height(32.dp)
                    .background(background )
            ) {
                Checkbox(toggled.value, onCheckedChange = {
                    ConfigManager.setConfiguration(
                        descriptor.group.value,
                        hidden.key(),
                        it
                    )
                    toggled.value = it
                }, enabled = true, modifier = Modifier.scale(0.85f), colors =CheckboxDefaults.colors(checkedColor = uiColor.value, uncheckedColor = surface,checkmarkColor = background))
            }
        }

        when {
            toggled.value ->
                descriptor.items.filter { it.item.unhide == hidden.item.unhideKey }
                    .forEach { hiddenItem ->
                        when (hiddenItem.type) {
                            Int::class.javaPrimitiveType, Int::class.java -> {
                                when {
                                    hiddenItem.range != null -> sliderIntNode(
                                        descriptor,
                                        hiddenItem
                                    )
                                    hiddenItem.item.textArea -> intAreaTextNode(
                                        descriptor,
                                        hiddenItem
                                    )
                                    else -> intTextNode(
                                        descriptor, hiddenItem
                                    )
                                }
                            }
                            Boolean::class.javaPrimitiveType -> booleanNode(
                                descriptor,
                                hiddenItem
                            )
                            java.awt.Color::class.java -> colorPickerNode(
                                descriptor,
                                hiddenItem
                            )
                            ModifierlessKeybind::class.java -> hotKeyNode(
                                descriptor,
                                hiddenItem
                            )
                            String::class.java -> {
                                when {
                                    hiddenItem.item.textArea -> stringAreaTextNode(
                                        descriptor,
                                        hiddenItem
                                    )
                                    else -> stringTextNode(
                                        descriptor,
                                        hiddenItem,
                                        mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, hiddenItem.key())!!)
                                    )
                                }
                            }

                            else -> if (hiddenItem.type?.isEnum == true) enumNode(
                                descriptor,
                                hiddenItem
                            )

                        }
                    }
        }
    }

}
