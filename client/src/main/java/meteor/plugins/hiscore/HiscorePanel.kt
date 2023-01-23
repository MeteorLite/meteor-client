package meteor.plugins.hiscore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
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

class HiscorePanel : PluginPanel() {


    @Composable
    override fun Content() {
        Column(modifier = Modifier.height(1000.dp).verticalScroll(rememberScrollState())) {
            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.height(60.dp).width(300.dp).background(background)
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    OutlinedTextField(
                            modifier = Modifier.width(IntrinsicSize.Max).height(60.dp
                            ).scale(0.95f),
                            value = username.value,
                            onValueChange = {
                                            username.value = it
                            },
                            label = {Text("Username")},
                            textStyle = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center, color = uiColor.value)
                    )
                }
                    Icon(modifier = Modifier.height(60.dp).width(30.dp).clickable {  hiscoreresult.value = hiscoreClient.lookup(username.value, endpoint = getWorldEndpoint()) },
                        imageVector = Octicons.Search24,
                        contentDescription = "",
                        tint = uiColor.value)
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
