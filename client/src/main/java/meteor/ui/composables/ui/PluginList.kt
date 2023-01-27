package meteor.ui.composables.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import compose.icons.Octicons
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

val searchText = mutableStateOf("")

fun getFavoritePlugins(): List<Plugin> {
    return PluginManager.plugins.filter {
        it.isFavorite()
    }
}

fun getNonFavoritePlugins(): List<Plugin> {
    return PluginManager.plugins.filter {
        !it.isFavorite()
    }
}

val favoritePlugins = mutableStateOf(getFavoritePlugins())

val nonFavoritePlugins = mutableStateOf(getNonFavoritePlugins())

fun updatePluginsList() {
    favoritePlugins.value = getFavoritePlugins()
    nonFavoritePlugins.value = getNonFavoritePlugins()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun plugins() {
    val pluginListScrollState = rememberForeverLazyListState()

    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchText.value,
            onValueChange = { value ->
                searchText.value = value
            },
            textStyle = TextStyle(
                color = uiColor.value,
                letterSpacing = 4.sp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = uiColor.value, unfocusedBorderColor = uiColor.value, cursorColor = uiColor.value),
            modifier = Modifier.fillMaxWidth().height(60.dp).scale(0.93f),
            shape = RoundedCornerShape(10.dp),
            label = {
                if (searchText.value.isEmpty()) Text("Search", color = uiColor.value)
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


    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {

        LazyColumn(modifier = Modifier.fillMaxHeight(), state = pluginListScrollState) {

            val searchedText = searchText.value
            val plugins = ArrayList<Plugin>()
            plugins.addAll(favoritePlugins.value.filter {
                it.getName()!!.contains(searchedText, ignoreCase = true) ||
                        it.getDescriptor().tags.contains(searchedText)
            })
            plugins.addAll(nonFavoritePlugins.value.filter {
                it.getName()!!.contains(searchedText, ignoreCase = true) ||
                        it.getDescriptor().tags.contains(searchedText)
            })

            items(items = plugins, itemContent = { plugin ->
                Row(modifier = Modifier.fillMaxWidth().height(45.dp).background(background)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth(0.50f).height(32.dp).background(background)
                    ) {
                        IconButton(
                            onClick = {
                                plugin.setFavorite(!plugin.isFavorite())
                                updatePluginsList()
                            },
                        ) {
                            if (plugin.isFavorite()) {
                                Spacer(Modifier.height(20.dp))
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Favorite",
                                    tint = uiColor.value,
                                    modifier = Modifier.width(20.dp)
                                )
                            } else {
                                Spacer(Modifier.height(20.dp))
                                Icon(
                                    Icons.Filled.FavoriteBorder,
                                    contentDescription = "Favorite",
                                    tint = uiColor.value,
                                    modifier = Modifier.width(20.dp)
                                )
                            }
                        }
                        TooltipArea(
                            modifier = Modifier.background(
                                shape = RoundedCornerShape(16.dp), color = background
                            ), tooltipPlacement = TooltipPlacement.ComponentRect(offset = DpOffset(x = 15.dp, y = 0.dp)), tooltip = {
                                val descriptionText = plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).description
                                if (descriptionText.isNotEmpty()) {
                                    Box(modifier = Modifier.sizeIn(minWidth = 200.dp, minHeight = 10.dp, maxWidth = 200.dp, maxHeight = 200.dp)
                                        .background(color = surface, RoundedCornerShape(5.dp)), contentAlignment = Alignment.Center)
                                    {
                                        Text(
                                            descriptionText,
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
                                }
                            }) {
                            Text(
                                plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                                style = TextStyle(
                                    color = uiColor.value,
                                    letterSpacing = 2.sp,
                                    fontSize = pluginListSize.value.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                            .height(32.dp)
                            .background(background)
                    ) {
                        if (plugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).external) {
                            IconButton(
                                onClick = {
                                    PluginManager.reloadExternal(plugin)
                                    updatePluginsList()
                                },
                            ) {
                                Icon(
                                    Icons.Filled.Refresh,
                                    contentDescription = "Reload plugin",
                                    tint = uiColor.value
                                )
                            }
                        }

                        if (plugin.configuration != null) {
                            IconButton(
                                onClick = {
                                    lastPlugin = plugin
                                    descriptor = ConfigManager.getConfigDescriptor(plugin.configuration!!)
                                    configOpen.value = true
                                    pluginsOpen.value = false
                                          },

                                ) {
                                Icon(
                                    Icons.Outlined.Settings,
                                    contentDescription = "Opens Plugin configuration panel",
                                    tint = uiColor.value
                                )
                            }
                        } else {
                            Spacer(
                                Modifier.width(50.dp)
                                    .background(background)
                            )
                        }

                        //ensure we only care about actual clicks, not recomposition changes
                        val interactionSource = remember { MutableInteractionSource() }
                        val isPressed by interactionSource.collectIsPressedAsState()

                        val switchState = mutableStateOf(plugin.shouldEnable())
                        Switch(
                            switchState.value,
                            onPluginToggled(switchState, plugin, isPressed),
                            enabled = true,
                            colors = SwitchDefaults.colors(checkedThumbColor = uiColor.value, uncheckedThumbColor = darkThemeColors.primarySurface),
                            interactionSource = interactionSource
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


private var scrollStateRemembered = ScrollState(0,0)

private data class ScrollState(
    val index: Int,
    val scrollOffset: Int
)

@Composable
fun rememberForeverLazyListState(): LazyListState {
    val scrollState = rememberSaveable(saver = LazyListState.Saver) {
        val savedValue = scrollStateRemembered
        val savedIndex = savedValue.index
        val savedOffset = savedValue.scrollOffset
        LazyListState(
            savedIndex,
            savedOffset
        )
    }
    DisposableEffect(Unit) {
        onDispose {
            val lastIndex = scrollState.firstVisibleItemIndex
            val lastOffset = scrollState.firstVisibleItemScrollOffset
            scrollStateRemembered = ScrollState(lastIndex, lastOffset)
        }
    }
    return scrollState
}

@Composable
fun onPluginToggled(switchState: MutableState<Boolean>, plugin: Plugin, isPressed: Boolean): ((Boolean) -> Unit) = {
    if (isPressed) {
        PluginManager.toggle(plugin)
        ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", it)
        switchState.value = it
        ConfigManager.saveProperties()
    }
}
