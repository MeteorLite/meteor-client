package meteor.ui.composables.items

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.nodes.*
import java.awt.Color

val configStringsMap = HashMap<String, MutableState<String>>()

fun LazyListScope.configItems(descriptor: ConfigDescriptor) {
    items(items = descriptor.items.toTypedArray())
    { config ->
        if (config.item.section.isEmpty()) {
            var hidden = true
            if (!config.item.hidden) {
                hidden = false
            }
            if (config.item.hidden && config.item.unhide.isNotEmpty()) {
                val value = ConfigManager.getConfiguration(
                    meteor.ui.composables.preferences.descriptor.group.value,
                    config.item.unhide
                )
                value?.let {
                    if (it.isNotEmpty())
                        hidden = !it.toBoolean()
                }
            }
            if (!hidden)
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
                    booleanNode(descriptor, config)
                }

                Color::class.java -> colorPickerNode(descriptor, config)
                ModifierlessKeybind::class.java -> hotKeyNode(descriptor, config)
                String::class.java -> {
                    when {
                        config.item.textArea -> stringAreaTextNode(descriptor, config)
                        else -> {
                            val key = "${descriptor.group.value}:${config.key()}"
                            configStringsMap[key]?.let {
                                it.value = ConfigManager.getConfiguration(descriptor.group.value, config.key())!!
                            }
                            if (configStringsMap[key] == null)
                                configStringsMap[key] = mutableStateOf(ConfigManager.getConfiguration(descriptor.group.value, config.key())!!)
                            stringTextNode(descriptor, config, configStringsMap[key]!!)
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
