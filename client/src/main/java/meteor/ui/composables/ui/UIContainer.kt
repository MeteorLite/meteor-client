package meteor.ui.composables.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import meteor.Main
import meteor.rs.Applet
import meteor.ui.composables.preferences.background
import meteor.ui.composables.preferences.darkThemeColors
import meteor.ui.composables.toolbar.ToolbarPanel


@DslMarker
annotation class ToolBar

@DslMarker
annotation class WindowPanel

@DslMarker
annotation class GamePanel

class GameWindow {


    @GamePanel
    @Composable
    fun gameFrame(
        backgroundColor: Color = darkThemeColors.background,
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            BoxWithConstraints(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(backgroundColor)

            ) {
                Column {
                    content.invoke()
                }
            }
        }
    }
}


class UI {

    @ToolBar
    @Composable
    fun toolBar(content: @Composable () -> Unit) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxHeight()
                .background(background )
                .width(Main.meteorConfig.toolbarWidth().dp)

        ) {

            ToolbarPanel()
            content.invoke()
        }
    }

    @WindowPanel
    @Composable
    fun content(
        content: @Composable GameWindow.() -> Unit
    ) {
        val gameContent = GameWindow()

        BoxWithConstraints(modifier = Modifier.background(background ) ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                content.invoke(gameContent)
            }
        }

    }

}

@Composable
fun windowFrame(
    modifier: Modifier = Modifier,
    content: @Composable UI.() -> Unit
) {
    val ui = UI()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(background )
        ) {
            content.invoke(ui)
        }
    }

}