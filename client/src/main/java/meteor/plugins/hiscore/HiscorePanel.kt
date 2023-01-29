package meteor.plugins.hiscore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.Search16
import compose.icons.octicons.Search24
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.hiscore.hiscoreActivityGrid
import meteor.ui.composables.hiscore.hiscoreBossGrid
import meteor.ui.composables.hiscore.hiscoreSkillGrid
import meteor.ui.composables.hiscore.overallSkillItem
import meteor.ui.composables.preferences.*
import meteor.ui.composables.ui.searchText

class HiscorePanel : PluginPanel() {


    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    override fun Content() {
        Column(modifier = Modifier.height(1000.dp).verticalScroll(rememberScrollState())) {
            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.height(60.dp).width(300.dp).background(background)
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    OutlinedTextField(
                        modifier = Modifier.width(IntrinsicSize.Max).height(60.dp).scale(0.95f).onKeyEvent { keyEvent ->
                            if (keyEvent.key != Key.Enter) return@onKeyEvent false
                            if (keyEvent.type == KeyEventType.KeyUp) {
                                hiscoreresult.value = hiscoreClient.lookup(username.value, endpoint = getWorldEndpoint())
                            }
                            true },
                        value = username.value,
                        onValueChange = { username.value = it },
                        label = { if (username.value.isEmpty()) Text("Username", color = uiColor.value)},
                        singleLine = true,
                        textStyle = TextStyle(fontSize = 20.sp, color = uiColor.value),
                        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = uiColor.value, unfocusedBorderColor = uiColor.value, cursorColor = uiColor.value),
                    )
                }
                    Icon(modifier = Modifier.height(60.dp).width(30.dp).clickable {  hiscoreresult.value = hiscoreClient.lookup(username.value, endpoint = getWorldEndpoint()) },
                        imageVector = Octicons.Search24,
                        contentDescription = "",
                        tint = uiColor.value)
                KeyboardActions { ImeAction.Send }
            }

            val mod = Modifier.width(300.dp).background(background)

            LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 60.dp),
                    modifier = mod.height(400.dp),
                    contentPadding = PaddingValues(35.dp),
                    userScrollEnabled = false,
                    ) {
                hiscoreSkillGrid()
                overallSkillItem()
            }
            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(20.dp).width(300.dp).background(background)
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                            text = "Activities Completed",
                            style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center, color = uiColor.value),
                            textAlign = TextAlign.Center
                    )
                }
            }
            LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 60.dp),
                    modifier = mod.height(200.dp),
                    contentPadding = PaddingValues(15.dp),
                    userScrollEnabled = false
            ) {
                hiscoreActivityGrid()
            }

            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(20.dp).width(300.dp).background(background)
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                            text = "Boss kills",
                            style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center, color = uiColor.value),
                            textAlign = TextAlign.Center
                    )
                }
            }
            LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 65.dp),
                    modifier = mod.height(500.dp),
                    userScrollEnabled = false
            ) {
                hiscoreBossGrid()
            }
        }
    }
}
