package meteor.ui.composables.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import meteor.Main
import meteor.Main.shouldRender
import meteor.ui.composables.configPanel
import meteor.ui.composables.nodes.sectionItem
import meteor.ui.composables.preferences.*
import java.awt.Dimension


@Composable
fun FrameWindowScope.windowContent() {
    windowFrame {
        Main.window = this@windowContent

        val width = when {

            pluginsOpen.value || configOpen.value || infoPanelOpen.value || hiscoreOpen.value || xpTrackerOpen.value || lootTrackerOpen.value || externalsOpen.value || notesOpen.value -> totalClientWidth
            else -> totalMinimalWidth
        }
        val height = when{
            consoleOpen.value -> consoleHeight else -> minimumHeight

        }
        window.minimumSize = Dimension(width,height)
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
                    !toolBarOpen.value -> toolBarOpen.value = true
                    toolBarOpen.value -> toolBarOpen.value = false
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





