package meteor.ui.composables.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import meteor.ui.composables.preferences.*
import orsc.Main


val topToolbar: SnapshotStateList<ToolbarButton> by lazy { topButtons }
val bottomToolbar: SnapshotStateList<ToolbarButton> by lazy { bottomButtons }

private val topButtons = mutableStateListOf<ToolbarButton>()
private val bottomButtons = mutableStateListOf<ToolbarButton>()
val width = mutableStateOf(Main.meteorConfig.toolbarWidth())


@Composable
fun ToolbarPanel() {
    return Column(modifier = Modifier.width(width.value.dp).background(surface), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(modifier = Modifier.fillMaxHeight(.8f)) {
            items(items = topToolbar.sortedBy { it.position }, itemContent = { toolbarButton ->
                toolbarButton.CreateComponent()
            })
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(surface)
        ) {
            MaterialTheme(colors = if (darkLightMode.value)darkThemeColors else lightThemeColors) {
                for (button in bottomToolbar.sortedBy { it.position })
                    button.CreateComponent()
            }
        }
    }
}

fun addButton(button: ToolbarButton) : ToolbarButton {
    if (!button.bottom) {
        if (!containsButton(topButtons, button))
            topButtons.add(button)
    } else {
        if (!containsButton(bottomButtons, button))
            bottomButtons.add(button)
    }
    return button
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
