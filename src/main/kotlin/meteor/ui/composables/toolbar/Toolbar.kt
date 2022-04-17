package meteor.ui.composables.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import meteor.ui.UI

object Toolbar {
    private val topToolbarButtons = mutableStateListOf<ToolbarButton>()
    private val bottomToolbarButtons = mutableStateListOf<ToolbarButton>()

    init {
        addButton(ToolbarButton("Plugins", Icons.Filled.Menu, description = "Opens Plugins list", onClick = {
            if (UI.pluginConfigurationIsOpen.value)
                UI.pluginConfigurationIsOpen.value = !UI.pluginConfigurationIsOpen.value
            else
                UI.pluginsPanelIsOpen.value = !UI.pluginsPanelIsOpen.value
        }))

        addButton(ToolbarButton("Settings", Icons.Filled.Settings, description = "Settings", bottom = true) {
        })
    }

    @Composable
    fun ToolbarPanel(
        box: BoxWithConstraintsScope,
        topToolbarButtons: SnapshotStateList<ToolbarButton> = this.topToolbarButtons,
        bottomToolbarButtons: SnapshotStateList<ToolbarButton> = this.bottomToolbarButtons) {
        var mod = Modifier.background(Color(0x212121)).fillMaxHeight()
        if (box.maxWidth > 1920.dp) {
            mod = mod.fillMaxWidth(UI.toolbarWidth)
        } else
            mod = mod.fillMaxWidth(.06f)
        return Column(modifier = mod) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(.5f).background(UI.darkThemeColors.surface)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    for (button in topToolbarButtons)
                        button.CreateComponent()
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.surface)) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    for (button in bottomToolbarButtons)
                        button.CreateComponent()
                }
            }
        }
    }

    fun addButton(button: ToolbarButton) {
        if (!button.bottom)
        {
            if (!containsButton(topToolbarButtons, button))
                topToolbarButtons.add(button)
        }
        else
        {
            if (!containsButton(bottomToolbarButtons, button))
                bottomToolbarButtons.add(button)
        }
    }

    fun removeButton(button: ToolbarButton) {
        if (!button.bottom)
            topToolbarButtons.remove(button)
        else
            bottomToolbarButtons.remove(button)
    }

    fun containsButton(list: SnapshotStateList<ToolbarButton>, button: ToolbarButton) : Boolean {
        for (b in list) {
            if (b.name == button.name)
                return true;
        }
        return false
    }
}