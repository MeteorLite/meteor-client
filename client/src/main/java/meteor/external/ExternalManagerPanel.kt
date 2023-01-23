package meteor.external

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.Plug16
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.ErrorDialog
import meteor.ui.composables.preferences.secondColor
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import okhttp3.Request
import org.json.JSONArray
import java.io.File


class ExternalManagerPanel : PluginPanel() {

    @Composable
    override fun Content() {

        val textfieldColors = TextFieldDefaults.textFieldColors(textColor = secondColor.value,
            unfocusedLabelColor = secondColor.value,
            unfocusedIndicatorColor = secondColor.value,
            focusedIndicatorColor = uiColor.value,
            focusedLabelColor = uiColor.value,
            cursorColor = uiColor.value)

        ErrorDialog()

        LazyColumn( modifier = Modifier.width(300.dp).fillMaxHeight(),
            horizontalAlignment =  Alignment.CenterHorizontally,
            verticalArrangement =  Arrangement.spacedBy(5.dp)) {
            item{
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("External manager", color = uiColor.value, letterSpacing = 3.sp, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                OutlinedTextField(
                    colors = textfieldColors,
                    label = { Text("Repository Owner") },
                    value = repositoryOwner.value,
                    onValueChange = { repositoryOwner.value = it })

                OutlinedTextField(
                    colors = textfieldColors,
                    label = { Text("Repository") },
                    value = repository.value,
                    onValueChange = { repository.value = it })

                Row(horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = surface),
                        onClick = {
                            try {
                                val request = Request.Builder()
                                    .url("https://raw.github.com/${repositoryOwner.value}/${repository.value}/main/plugins.json")
                                    .build()

                                val response = http.newCall(request).execute()
                                body = response.body
                                jsonString = body?.string()
                                jsonArray = JSONArray(jsonString)
                                for (i in 0 until jsonArray!!.length()) {
                                    val plugin = jsonArray?.getJSONObject(i)
                                    plugin?.getString("name")?.let {
                                        if (!pluginNames.contains(it)) {
                                            pluginNames.add(it)
                                            pluginNamesState.value = pluginNames
                                        }
                                    }
                                }
                                val firstPlugin = jsonArray?.getJSONObject(0)
                                val url = firstPlugin?.getString("projectUrl")
                                if (url != null) {
                                    projectUrl.value = url
                                }
                            } catch (e: Exception) {
                                projectUrl.value = ""
                                pluginNamesState.value.clear()

                            }
                        }
                    ) {
                        Icon(imageVector = Octicons.Plug16, contentDescription = "", tint = uiColor.value)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Find Plugins", color = secondColor.value, fontSize = 20.sp)
                    }
                }
                Spacer(Modifier.height(4.dp))
                Divider(color = uiColor.value, modifier = Modifier.fillMaxWidth(0.95f), thickness = 5.dp, startIndent = 5.dp)
                Spacer(Modifier.height(4.dp))
                if (projectUrl.value != "") {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                        openSupport(projectUrl.value)
                    }
                }

            }
            items(items = pluginNamesState.value) { pluginName ->
                val plugin = findJsonValue(pluginName)
                val fileName = "${plugin?.getString("name")}.jar"
                val jarFile = File("$savePath/$fileName")
                val releases = plugin?.getJSONArray("releases")
                val release = releases?.getJSONObject(0)
                val url = release?.getString("url")
                val hash = release?.getString("sha512sum")
                val version = release?.getString("version")

                Column(modifier = Modifier.background(surface, RoundedCornerShape(5.dp)).fillParentMaxWidth(0.9f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row {
                        Text(text = "Name:", color = uiColor.value)
                        Text(text = pluginName, color = secondColor.value)
                    }
                    Row {
                        Text(text = "Version:", color = uiColor.value)
                        if (version != null) {
                            Text(text = version, color = secondColor.value)
                        }
                    }
                    Row {
                        if (plugin != null) {
                            Text(text = "Details:", color = uiColor.value)
                            Text(text = plugin.getString("description"), color = secondColor.value)
                        }
                    }

                    if (jarFile.exists()) {
                        Row {
                            Text(text = "(installed)", color = secondColor.value)
                        }
                    } else {
                        Button(colors = ButtonDefaults.buttonColors(backgroundColor = surface),
                            onClick = {

                                if (hash != null && url != null) {
                                    downloadFile(url, savePath, fileName, hash)
                                }
                                loadAndInitJar(jarFile)
                            }) {
                            Text(text = "Download", color = secondColor.value)
                        }
                    }
                }
            }

        }
    }
}
