package meteor.ui.composables.items

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import meteor.config.legacy.ModifierlessKeybind
import meteor.ui.composables.descriptor
import meteor.ui.composables.nodes.*
import java.awt.Color


fun LazyListScope.configItems() {
                items(items = descriptor.items.filter { it.item.section.isEmpty() })
                { config ->
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
                                booleanNode(descriptor, config)
                            else
                                hiddenItems(config)
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
                            if (config.item.unhideKey == "") {
                                enumNode(descriptor, config)
                            }else
                            unhideEnum(config)
                        }
                    } }
                }
            }
