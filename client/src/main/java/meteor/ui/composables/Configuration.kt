package meteor.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.TooltipPlacement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.ChevronLeft24
import meteor.config.ConfigManager
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.items.configItems
import meteor.ui.composables.items.sectionItems
import meteor.ui.composables.items.titleItems
import meteor.ui.composables.preferences.*
import meteor.ui.composables.ui.onPluginToggled

@Composable
fun configPanel() {
    val mod = Modifier.background(if (darkLightMode.value) darkThemeColors.background else lightThemeColors.background
    ).fillMaxHeight().width(300.dp)
    Column {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                modifier = mod
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    configPanelHeader()
                    configs()
                }

            }
        }

    }
}

@Composable
fun configs(){
    LazyColumn(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top,
        modifier = Modifier.width(300.dp).fillMaxHeight().background(background ).padding(start = 4.dp)
    ) {
        titleItems(descriptor)
        sectionItems(descriptor)
        configItems(descriptor)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun configPanelHeader() {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().height(42.dp).background(surface,
                RoundedCornerShape(10.dp))
        ) {
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(40.dp)) {
                IconButton( onClick = {
                    when {
                        configOpen.value -> configOpen.value = false
                    }
                    pluginsOpen.value = true
                }) {
                    Icon(
                        imageVector = Octicons.ChevronLeft24,
                        contentDescription = "Back to plugin page",
                        tint = uiColor.value,
                    )
                }
            }
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(180.dp)) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                        lastPlugin.javaClass.getDeclaredAnnotation(PluginDescriptor::class.java).name,
                        style = TextStyle(color = uiColor.value, fontSize = 18.sp, textAlign = TextAlign.Left),
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.width(50.dp)
            ) {
                TooltipArea(
                    modifier = Modifier.background(
                        shape = RoundedCornerShape(16.dp), color = surface
                    ), tooltipPlacement = TooltipPlacement.ComponentRect(offset = DpOffset(x = 15.dp, y = 0.dp)), tooltip = {
                        val descriptionText = "Reset plugin configuration"
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
                    IconButton(
                        onClick = {
                            ConfigManager.setDefaultConfiguration(lastPlugin.configuration as Any, true)
                            lastPlugin.resetConfiguration()

                            //I'm lazy af so we just close the panel. FUCKING SUE ME
                            configOpen.value = false
                            pluginsOpen.value = true
                        },

                        ) {
                        Icon(
                            Icons.Outlined.Refresh,
                            contentDescription = "Reset plugin configuration",
                            tint = uiColor.value
                        )
                    }
                }

                val switchState = remember { mutableStateOf(lastPlugin.shouldEnable()) }
                Switch(
                    switchState.value,
                    onPluginToggled(switchState, lastPlugin, true),
                    enabled = true,
                    modifier = Modifier.scale(0.75f),
                    colors = SwitchDefaults.colors(checkedThumbColor = uiColor.value, uncheckedThumbColor = Color.DarkGray, uncheckedTrackColor = Color.LightGray)
                )
            }
    }
}










