package meteor.ui.composables.items

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.nodes.*
import meteor.ui.composables.preferences.descriptor
import java.awt.Color


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
                        else -> stringTextNode(descriptor, config)
                    }
                }
                else -> if (config.type?.isEnum == true) {
                    enumNode(descriptor, config)
                }
            }
        }

    }
}
