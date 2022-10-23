package meteor.ui.composables.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.darkThemeColors
import meteor.ui.composables.descriptor
import meteor.ui.composables.nodes.*
import meteor.ui.composables.uiColor


@Composable
fun unhideEnum(config : ConfigItemDescriptor){
    descriptor?.items?.filter { config.item.keyName == it.item.keyName }
        ?.forEach { hiddenEnum ->
            var toggledEnum = remember { mutableStateOf(false) }
            var cfg = ConfigManager.getConfiguration(
                descriptor.group.value,
                hiddenEnum.key()
            )
            descriptor.items.filter { it.item.unhideValue.isNotEmpty() }.forEach { uv ->
                hiddenEnum.type?.enumConstants?.forEach {
                    if (it.toString() == cfg && it.toString() == uv.item.unhideValue) toggledEnum.value =
                        true
                }

            }
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
                                            hiddenItem
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
    descriptor?.items?.filter { config.item.keyName == it.item.keyName }?.forEach { hidden ->
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
                    ConfigManager.setConfiguration(
                        descriptor.group.value,
                        hidden.key(),
                        it
                    )
                    toggled.value = it
                }, enabled = true, modifier = Modifier.scale(0.85f), colors =SwitchDefaults.colors(checkedThumbColor = uiColor, uncheckedThumbColor = Color.Gray))
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
                                        hiddenItem
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
