package meteor.ui.composables.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import compose.icons.Octicons
import compose.icons.octicons.Gear24
import compose.icons.octicons.Search16
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.ui.composables.preferences.*


@Composable
fun pluginsPanel() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxHeight().width(300.dp)
        ) {
            plugins()
        }
    }
}

@Preview
@Composable
fun searchBar(
    modifier: Modifier = Modifier,
    state: MutableState<String>,
    placeHolder: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            textStyle = TextStyle(
                color = uiColor.value,
                letterSpacing = 4.sp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = uiColor.value, unfocusedBorderColor = uiColor.value, cursorColor = intColor),
            modifier = Modifier.fillMaxWidth().height(60.dp).scale(0.93f),
            shape = RoundedCornerShape(10.dp),
            label = {
                if (state.value.isEmpty()) Text("Search", color = uiColor.value)
            },
            leadingIcon = {
                Icon(
                    Octicons.Search16,
                    contentDescription = "Opens Plugin configuration panel",
                    tint = uiColor.value,

                    )
            }
        )
    }
    Spacer(Modifier.width(75.dp))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun plugins() {
    if (pluginListScrollState == null) {
        pluginListScrollState = rememberLazyListState()
    }
    val textState = remember { searchValue }
    searchBar(state = textState, placeHolder = "", modifier = Modifier.fillMaxWidth())


    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {

        LazyColumn(modifier = Modifier.fillMaxHeight(), state = pluginListScrollState!!) {

            val searchedText = textState.value

            items(items = PluginManager.plugins.filter {
                it.getName()!!.contains(searchedText, ignoreCase = true) ||
                        it.getDescriptor().tags.contains(searchedText)
            }, itemContent = { plugin ->

                Row(modifier = Modifier.fillMaxWidth().height(45.dp).background(background)) {
                    TooltipArea(
                        modifier = Modifier.background(
                            shape = RoundedCornerShape(16.dp), color = surface
                        ), tooltipPlacement = TooltipPlacement.ComponentRect(offset = DpOffset(x = 15.dp, y = 0.dp)), tooltip = {
                            Box(modifier = Modifier.sizeIn(minWidth = 200.dp, minHeight = 10.dp, maxWidth = 200.dp, maxHeight = 200.dp)
                                .background(color = surface, RoundedCornerShape(5.dp)), contentAlignment = Alignment.Center)
                            {
                                Text(
                                    plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).description,
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

                        }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.70f).height(32.dp).background(background)
                        ) {

                            Text(
                                plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                                style = TextStyle(
                                    color = uiColor.value,
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
                            .background(background)
                    ) {
                        if (plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).external) {
                            IconButton(
                                onClick = { PluginManager.reloadExternal(plugin) },
                            ) {
                                Icon(
                                    Icons.Filled.Refresh,
                                    contentDescription = "Reload plugin",
                                    tint = uiColor.value
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
                                    tint = uiColor.value,

                                    )
                            }
                        } else {
                            Spacer(
                                Modifier.width(50.dp)
                                    .background(background)
                            )
                        }
                        val switchState = mutableStateOf(plugin.shouldEnable())
                        Switch(
                            switchState.value,
                            onPluginToggled(switchState, plugin),
                            enabled = true,
                            modifier = Modifier.scale(0.75f).padding(bottom = 2.dp),
                            colors = SwitchDefaults.colors(checkedThumbColor = uiColor.value, uncheckedThumbColor = darkThemeColors.primarySurface)
                        )


                    }


                }
                Spacer(
                    Modifier.width(pluginSpacer.value.dp)
                        .background(background)
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
