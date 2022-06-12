package meteor.plugins.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import compose.icons.Octicons
import compose.icons.octicons.Note24
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.darkThemeColors
import meteor.ui.composables.notePanel
import meteor.ui.composables.toolbar.Toolbar.addButton
import meteor.ui.composables.toolbar.Toolbar.removeButton
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.util.FontUtil


@PluginDescriptor(name = "Notes")
class NotesPlugin: Plugin() {


    private var notesButton = ToolbarButton(
        "Notes",
        Octicons.Note24,
        iconColor = Color.Cyan,
        description = "Notes",
        onClick = {
            // togglePluginPanel()
            if (!notePanel.value) notePanel.value = true else if (notePanel.value) notePanel.value = false

        },
        bottom = false
    )

    override fun onStart() {

        addButton(notesButton)
    }

    override fun onStop() {
        removeButton(notesButton)
    }

    @Composable
    fun notesTextNode() {


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
                modifier = Modifier.fillMaxHeight().width(375.dp).background(Color(0xFF242424))
            ) {
                MaterialTheme(colors = darkThemeColors) {

                    OutlinedTextField(
                        modifier = Modifier.width(375.dp).fillMaxHeight().background(Color(0xFF242424)),
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
                        textStyle = TextStyle(color = Color.Cyan, fontSize = 14.sp, textDirection = TextDirection.Ltr, fontFamily = FontUtil.righteous)
                    )
                }
            }
        }
    }


}