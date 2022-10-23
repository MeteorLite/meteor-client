package meteor.ui.composables.nodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.ui.composables.darkThemeColors
import meteor.ui.composables.uiColor


@Composable
fun stringAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
        )
    }
    Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(100.dp).background(darkThemeColors.background)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(all = 3.dp),
                    value = text,
                    onValueChange = {
                        text = it
                        ConfigManager.setConfiguration(
                            descriptor.group.value,
                            configItemDescriptor.key(),
                            it
                        )
                    },
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    maxLines = 30,
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}

@Composable
fun stringTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor) {
    var text by remember {
        mutableStateOf(
            ConfigManager.getConfiguration(
                descriptor.group.value,
                configItemDescriptor.key()
            ).toString()
        )
    }

    Row(modifier = Modifier.fillMaxWidth().height(60.dp).background(darkThemeColors.background)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(60.dp)
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    value = text,
                    visualTransformation = if (!configItemDescriptor.secret()) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange = {

                        ConfigManager.setConfiguration(
                            descriptor.group.value, configItemDescriptor.key(),
                            it
                        )
                        text = it

                    },
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor, fontSize = 14.sp)
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.padding(all = 3.dp).fillMaxWidth(),
                    textStyle = TextStyle(color = uiColor, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(darkThemeColors.background))
}
