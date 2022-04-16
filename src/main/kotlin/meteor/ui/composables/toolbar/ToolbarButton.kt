package meteor.ui.composables.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import meteor.ui.UI

class ToolbarButton(var name: String, var icon: ImageVector, var iconColor: Color = Color.Cyan,
                    var backgroundColor: Color = UI.darkThemeColors.background,
                    var description: String? = "", var alignment: Alignment = Alignment.TopCenter,
                    var bottom: Boolean = false, var onClick: () -> Unit) {

    @Composable
    fun CreateComponent() {
        val mod = Modifier.defaultMinSize(45.dp).clip(CircleShape).background(backgroundColor)
        MaterialTheme(colors = UI.darkThemeColors) {
            Box(
                modifier = mod, contentAlignment = alignment
            ) {
                IconButton(
                    onClick = onClick,
                    modifier = Modifier.defaultMinSize(minHeight = 45.dp).align(Alignment.Center)){
                    Icon(
                        icon,
                        contentDescription = description,
                        tint = iconColor
                    )
                }
            }
        }
    }
}