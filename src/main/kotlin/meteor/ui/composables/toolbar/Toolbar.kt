package meteor.ui.composables.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import meteor.Main
import meteor.ui.composables.darkThemeColors


object Toolbar {
    private val topToolbarButtons = mutableStateListOf<ToolbarButton>()
    private val bottomToolbarButtons = mutableStateListOf<ToolbarButton>()


    @Composable
    fun ToolbarPanel(
        topToolbarButtons: SnapshotStateList<ToolbarButton> = this.topToolbarButtons,
        bottomToolbarButtons: SnapshotStateList<ToolbarButton> = this.bottomToolbarButtons) {
        val width =  mutableStateOf(Main.meteorConfig!!.toolbarWidth().dp)

        val mod = Modifier.background(Color(0x212121)).width(width.value)

        return Column(modifier = mod) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(.5f).background(darkThemeColors.surface).scale(0.90F)) {
                MaterialTheme(colors = darkThemeColors) {
                    for (button in topToolbarButtons)
                        button.CreateComponent()

                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.surface).scale(0.75F)) {
                MaterialTheme(colors = darkThemeColors) {
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