package meteor.ui.composables.nodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.ConfigManager
import meteor.config.descriptor.ConfigDescriptor
import meteor.config.descriptor.ConfigItemDescriptor
import meteor.ui.composables.preferences.*
import java.lang.Exception

@Composable
fun intAreaTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor, intValue: MutableState<Int?>) {
    Row(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF242424))) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().height(100.dp).background(background )
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(all = 3.dp),
                    value = "${ConfigManager.getConfiguration(descriptor.group.value, configItemDescriptor.key())?.toInt()}",
                    onValueChange = {
                        intValue.value = it.toInt()
                        ConfigManager.setConfiguration(
                            descriptor.group.value,
                            configItemDescriptor.key(),
                            it
                        )
                    },
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor.value, fontSize = 14.sp)
                        )
                    },
                    maxLines = 30,
                    textStyle = TextStyle(color = uiColor.value, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background ) )
}

@Composable
fun intTextNode(descriptor: ConfigDescriptor, configItemDescriptor: ConfigItemDescriptor, intValue: MutableState<Int?>) {
    Row(modifier = Modifier.fillMaxWidth().height(60.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().height(60.dp).background(background )
        ) {
            MaterialTheme(colors = darkThemeColors) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(all = 3.dp),
                    value = "${intValue.value}",
                    visualTransformation = if (configItemDescriptor.secret()) PasswordVisualTransformation() else VisualTransformation.None,
                    onValueChange = { valueChanged ->
                        var newValue = try {
                            valueChanged.toInt()
                        } catch (e: Exception) {
                            // Return previous value
                            intValue.value ?: -1
                        }

                        configItemDescriptor.range?.let {
                            if (newValue > it.max)
                                newValue = it.max
                            if (newValue < it.min)
                                newValue = it.min
                        }

                        intValue.value = newValue
                        ConfigManager.setConfiguration(
                            descriptor.group.value, configItemDescriptor.key(),
                            "${intValue.value}"
                        )
                    },
                    maxLines = 30,
                    label = {
                        Text(
                            configItemDescriptor.name(),
                            style = TextStyle(color = uiColor.value, fontSize = 14.sp)
                        )
                    },
                    textStyle = TextStyle(color = uiColor.value, fontSize = 14.sp)
                )
            }
        }
    }
    Spacer(Modifier.height(4.dp).background(background ) )
}