package meteor.plugins.infopanel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import meteor.Main.client
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor

class InfoPanel: PluginPanel() {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.width(300.dp).padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
                    Text("OldSchool revision  ${client.revision}", color = uiColor.value)
                    Spacer(Modifier.height(10.dp))
                    discordButton()
                    Spacer(Modifier.height(10.dp))
                    gitHubButton()
        }
    }
    @Composable
    fun discordButton() {
        val uriHandler = LocalUriHandler.current
        Button(colors = ButtonDefaults.buttonColors(backgroundColor = surface),onClick = {     uriHandler.openUri("https://discord.gg/Y85d6NH6z3") }, modifier = Modifier.height(45.dp).width(350.dp)) {
            Text("Join our Discord Server", color = uiColor.value)
            Image(painter = painterResource("images/ui/discord.svg"), contentDescription = "", colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                uiColor.value), modifier = Modifier.scale(0.7f) )
        }
    }
    @Composable
    fun gitHubButton() {
        val uriHandler = LocalUriHandler.current
        Button(colors = ButtonDefaults.buttonColors(backgroundColor = surface),onClick = {     uriHandler.openUri("https://github.com/MeteorLite/meteor-client/issues") }, modifier = Modifier.height(45.dp).width(350.dp)) {
            Text("Report a bug or make a request", color = uiColor.value)
            Spacer(Modifier.width(10.dp))
            Image(painter = painterResource("images/ui/github-mark.svg"), contentDescription = "",colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                uiColor.value), modifier = Modifier.scale(2f))
        }
    }
}