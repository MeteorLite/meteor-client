package meteor.ui.composables.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
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
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import meteor.ui.composables.preferences.*
import meteor.util.FontUtil


@Composable
fun pluginsPanel() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxHeight().width(375.dp)
        ) {
            plugins()
        }
    }
}

@Preview
@Composable
fun searchBar(
    modifier: Modifier = Modifier,
    state: MutableState<TextFieldValue>,
    placeHolder: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        TextField(
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

            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(20.dp),
            label = {
                if (state.value.text.isEmpty())Text("Search", color = uiColor)
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun plugins() {

    val pluginListSize = remember {
        mutableStateOf(Main.meteorConfig!!.pluginListTextSize())
    }
    val pluginSpacer = remember {
        mutableStateOf(Main.meteorConfig!!.pluginSpaceBetween())
    }
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = Modifier.height(50.dp).fillMaxWidth().background(surface, RoundedCornerShape(29.dp)),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        searchBar(state = textState, placeHolder = "", modifier = Modifier.fillMaxWidth())
    }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {

        LazyColumn(modifier = Modifier.fillMaxHeight()) {

            val searchedText = textState.value.text

            items(items = PluginManager.plugins.filter {
                it.getName()!!.contains(searchedText, ignoreCase = true) ||
                        it.getDescriptor().tags.contains(searchedText)
            }, itemContent = { plugin ->

                Row(modifier = Modifier.fillMaxWidth().height(45.dp).background(background ) ) {
                    TooltipArea(
                        modifier = Modifier.background(
                            shape = RoundedCornerShape(3.dp), color = surface
                        ), tooltipPlacement = TooltipPlacement.ComponentRect(), tooltip = {
                            Column(modifier = Modifier.width(200.dp).background(surface, RoundedCornerShape(4.dp))) {
                                Text(
                                    plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).description,
                                    style = TextStyle(
                                        color = uiColor,
                                        letterSpacing = 2.sp,
                                        fontSize = pluginListSize.value.sp,
                                        fontWeight = FontWeight.Medium
                                    ),

                                    )
                            }

                        }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.60f).height(32.dp).background(background )
                        ) {

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

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                            .height(pluginListSize.value.dp)
                            .background(background )
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


                        if (plugin.configuration != null) {
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
                                    .background(background  )
                            )
                        }
                        val switchState = remember { mutableStateOf(plugin.shouldEnable()) }
                        Switch(
                            switchState.value,
                            onPluginToggled(switchState, plugin),
                            enabled = true,
                            modifier = Modifier.scale(0.75f).padding(bottom = 2.dp),
                            colors = SwitchDefaults.colors(checkedThumbColor = uiColor, uncheckedThumbColor = darkThemeColors.primarySurface)
                        )


                    }


                }
                Spacer(
                    Modifier.width(pluginSpacer.value.dp)
                        .background(background )
                )

            })
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
