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
import androidx.compose.ui.unit.dp

import meteor.Main
import meteor.ui.composables.darkThemeColors


val topToolbar: SnapshotStateList<ToolbarButton> by lazy { topButtons }
val bottomToolbar: SnapshotStateList<ToolbarButton> by lazy { bottomButtons }

private val topButtons = mutableStateListOf<ToolbarButton>()
private val bottomButtons = mutableStateListOf<ToolbarButton>()
val width = mutableStateOf(Main.meteorConfig?.toolbarWidth())


@Composable
fun ToolbarPanel() {
    return Column(modifier = Modifier.width(width.value!!.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(.5f).background(darkThemeColors.surface).scale(0.90F)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                for (button in topToolbar)
                    button.CreateComponent()

            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(darkThemeColors.surface).scale(0.75F)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                for (button in bottomToolbar)
                    button.CreateComponent()
            }
        }
    }
}

fun addButton(button: ToolbarButton) {
    if (!button.bottom) {
        if (!containsButton(topButtons, button))
            topButtons.add(button)
    } else {
        if (!containsButton(bottomButtons, button))
            bottomButtons.add(button)
    }
}

fun removeButton(button: ToolbarButton) {
    if (!button.bottom)
        topButtons.remove(button)
    else
        bottomButtons.remove(button)
}

fun containsButton(list: SnapshotStateList<ToolbarButton>, button: ToolbarButton): Boolean {
    for (b in list) {
        if (b.name == button.name)
            return true
    }
    return false
}
