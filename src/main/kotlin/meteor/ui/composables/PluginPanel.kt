package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import meteor.plugins.EventSubscriber
import meteor.ui.UI

open class PluginPanel : EventSubscriber() {
    @Composable
    fun CreateComponent(box: BoxWithConstraintsScope) {
        var mod = Modifier.background(UI.darkThemeColors.background).fillMaxHeight()
        if (box.maxWidth > 1920.dp) {
            mod = mod.fillMaxWidth(.2f)
        } else
            mod = mod.fillMaxWidth(.3f)
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Column(modifier = mod) {
                MaterialTheme(colors = UI.darkThemeColors) {
                    Header()
                    Content()
                }
            }
        }
    }

    @Composable open fun Header() {}
    @Composable open fun Content() {}
}