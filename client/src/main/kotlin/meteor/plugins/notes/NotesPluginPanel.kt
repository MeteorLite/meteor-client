package meteor.plugins.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.darkThemeColors

import meteor.util.FontUtil

class NotesPluginPanel : PluginPanel() {
    @Composable
    override fun Header() {
    }

    @Composable
    override fun Content() {
        val text = remember {
            mutableStateOf(
                ConfigManager.getConfiguration(
                    "notes",
                    "notes"
                )
            )
        }

        Row(modifier = Modifier.fillMaxHeight()) {

            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxHeight().width(300.dp).background(Color(0xFF242424))
            ) {
                MaterialTheme(colors = darkThemeColors) {

                    OutlinedTextField(
                        modifier = Modifier.width(300.dp).fillMaxHeight().background(Color(0xFF242424)),
                        value = text.value.toString(),
                        onValueChange = {
                            text.value = it
                            ConfigManager.setConfiguration(
                                "notes",
                                "notes",
                                it
                            )
                        },
                        label = {
                            Text(
                                "Notes",
                                style = TextStyle(color = Color.Cyan, fontSize = 14.sp)
                            )
                        },
                        maxLines = 120,
                        textStyle = TextStyle(
                            color = Color.Cyan,
                            fontSize = 14.sp,
                            textDirection = TextDirection.Ltr,
                            fontFamily = FontUtil.righteous
                        )
                    )
                }
            }
        }
    }
}