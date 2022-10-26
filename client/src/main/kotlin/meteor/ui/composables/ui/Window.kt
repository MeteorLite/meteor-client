package meteor.ui.composables.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import meteor.Main
import meteor.rs.Applet
import meteor.ui.composables.configPanel
import meteor.ui.composables.nodes.sectionItem
import meteor.ui.composables.preferences.*
import java.awt.Dimension


@Composable
fun FrameWindowScope.window() {

            windowFrame {
                when {
                    pluginsOpen.value ||
                            configOpen.value ||
                            pluginPanelIsOpen.value -> window.minimumSize =
                        Dimension(Applet().clientWidth + Main.meteorConfig.toolbarWidth(), 542)
                    else -> window.minimumSize =
                        Dimension(Applet().minimalWidth + Main.meteorConfig.toolbarWidth(), 542)
                }
                when {
                    toolBarOpen.value -> toolBar {
                        pluginListButton
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight().width(15.dp).background(background )
                ) {
                    Spacer(modifier = Modifier.width(15.dp))


                    sectionItem(modifier = Modifier.background(background ).size(25.dp)) {
                        when {
                            !toolBarOpen.value -> {

                                toolBarOpen.value = true
                            }
                            toolBarOpen.value -> {

                                toolBarOpen.value = false
                            }
                        }
                    }
                }
                content {
                    when {
                        pluginPanelIsOpen.value -> pluginPanel.value?.CreateComponent()
                        configOpen.value -> configPanel()
                        pluginsOpen.value -> pluginsPanel()
                    }
                    gameFrame {
                        OSRSPanel()
                    }
                }
            }



}





