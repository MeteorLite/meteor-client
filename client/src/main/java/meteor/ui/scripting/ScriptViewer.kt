package meteor.ui.scripting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import meteor.ui.composables.preferences.background

import meteor.ui.composables.preferences.darkThemeColors
import javax.swing.WindowConstants

object ScriptViewer {

    @JvmStatic
    fun main(args: Array<String>) = application {
        Window(
            onCloseRequest = this::exitApplication,
            title = "Meteor",
            icon = painterResource("Meteor_icon.png"),
            state = rememberWindowState(placement = WindowPlacement.Floating, size = DpSize(1920.dp, 1080.dp)),
            content = content()
        )
    }

    fun content(): (@Composable FrameWindowScope.() -> Unit) {
        return {
            window.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            MaterialTheme(colors = darkThemeColors) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize().background(background ) ) {
                    Row {
                        Column(modifier = Modifier.fillMaxWidth(.8f)) {
                            Row {
                                Box(Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp)).background(color = Color.Magenta)) {

                                }
                            }
                        }
                        Column(Modifier.fillMaxWidth()) {

                        }
                    }
                }
            }
        }
    }
}