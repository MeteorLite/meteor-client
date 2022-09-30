package meteor.ui.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.Gear24
import compose.icons.octicons.Search16
import meteor.Main
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.util.FontUtil


@Composable
fun PluginsPanel() {


    val mod = Modifier.background(darkThemeColors.background).fillMaxHeight().width(375.dp)

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = mod
        ) {
            MaterialTheme(colors = darkThemeColors) {
                Plugins()
            }
        }

    }
}

@Preview
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>,
    placeHolder: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            textStyle = TextStyle(
                color = uiColor,
                letterSpacing = 4.sp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontUtil.crimson
            ),

            modifier = Modifier.scale(scaleX = 0.95f, scaleY = 0.80f).fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            label = {
                Text("Search", color = uiColor)
            },
            leadingIcon = {
                Icon(
                    Octicons.Search16,
                    contentDescription = "Opens Plugin configuration panel",
                    tint = uiColor,

                    )
            }
        )
    }
    Spacer(Modifier.width(75.dp))
}


@Composable
fun Plugins() {


    val pluginListSize = remember {
        mutableStateOf(Main.meteorConfig!!.pluginListTextSize())
    }
    val pluginSpacer = remember {
        mutableStateOf(Main.meteorConfig!!.pluginSpaceBetween())
    }
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
    ) {
        SearchBar(state = textState, placeHolder = "", modifier = Modifier.fillMaxWidth())
    }
    Spacer(
        Modifier.height(pluginSpacer.value.dp)
            .background(darkThemeColors.background)
    )
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(darkThemeColors.background)
    ) {
        MaterialTheme(colors = darkThemeColors) {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {

                val searchedText = textState.value.text
                items(items = PluginManager.plugins.filter {
                    it.getName()!!.contains(searchedText, ignoreCase = true) ||
                            it.getDescriptor().tags.contains(searchedText)
                }, itemContent = { plugin ->
                    Row(modifier = Modifier.fillMaxWidth().height(45.dp).background(darkThemeColors.background)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.60f).height(32.dp).background(darkThemeColors.background)
                        ) {
                            val external = plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java)
                            val color = if (external?.external == true) Color.Magenta else uiColor
                            Text(
                                plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                                style = TextStyle(
                                    color = uiColor,
                                    letterSpacing = 2.sp,
                                    fontSize = pluginListSize.value.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
                            )

                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                                .height(pluginListSize.value.dp)
                                .background(darkThemeColors.background)
                        ) {
                            if (plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).external) {
                                IconButton(
                                    onClick = { PluginManager.reloadExternal(plugin) },
                                ) {
                                    Icon(
                                        Icons.Filled.Refresh,
                                        contentDescription = "Reload plugin",
                                        tint = uiColor
                                    )
                                }
                            }


                            if (plugin.config != null) {
                                Spacer(Modifier.height(20.dp))
                                IconButton(
                                    onClick = { onPluginConfigurationOpened(plugin) },

                                    ) {
                                    Icon(
                                        Octicons.Gear24,
                                        contentDescription = "Opens Plugin configuration panel",
                                        tint = uiColor,

                                        )
                                }

                            } else if (plugin.javaConfig != null) {
                                Spacer(Modifier.height(20.dp))
                                IconButton(
                                    onClick = { onPluginConfigurationOpened(plugin) },
                                ) {
                                    Icon(
                                        Octicons.Gear24,
                                        contentDescription = "Opens Plugin configuration panel",
                                        tint = uiColor,

                                        )
                                }

                            } else {
                                Spacer(
                                    Modifier.width(50.dp)
                                        .background(darkThemeColors.background)
                                )
                            }
                            val switchState = remember { mutableStateOf(plugin.shouldEnable()) }
                            Switch(
                                switchState.value,
                                onPluginToggled(switchState, plugin),
                                enabled = true,
                                modifier = Modifier.scale(0.75f).padding(bottom = 2.dp),
                                colors = SwitchDefaults.colors(checkedThumbColor = uiColor)
                            )


                        }


                    }
                    Spacer(
                        Modifier.width(pluginSpacer.value.dp)
                            .background(darkThemeColors.background)
                    )

                })
            }
        }
    }
}

fun onPluginToggled(switchState: MutableState<Boolean>, plugin: Plugin): ((Boolean) -> Unit) = {
    PluginManager.toggle(plugin)
    ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", it)
    switchState.value = it
    ConfigManager.saveProperties()
}

private fun onPluginConfigurationOpened(plugin: Plugin) {
    lastPlugin = plugin
    configOpen.value = true
}
