package meteor.ui.composables.items

import androidx.compose.runtime.Composable
import meteor.plugins.Plugin

@Composable
fun instructions(lastPlugin: Plugin) {
    lastPlugin.instructions()?.invoke()
}