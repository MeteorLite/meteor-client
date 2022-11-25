package meteor.plugins.hiscore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.hiscore.hiscoreActivityGrid
import meteor.ui.composables.hiscore.hiscoreBossGrid
import meteor.ui.composables.hiscore.hiscoreSkillGrid
import meteor.ui.composables.hiscore.overallSkillItem
import meteor.ui.composables.preferences.background
import meteor.ui.composables.preferences.darkThemeColors
import meteor.ui.composables.preferences.uiColor
import net.runelite.http.api.hiscore.HiscoreResult

class HiscorePanel : PluginPanel() {
    companion object {
        var result: HiscoreResult? = null
    }

    var username = ""

    @Composable
    override fun Header() {
    }

    @Composable
    override fun Content() {
        Column(modifier = Modifier.height(1000.dp).verticalScroll(rememberScrollState())) {
            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(25.dp).width(250.dp).background(background)
            ) {
                MaterialTheme(colors = darkThemeColors) {
                    Text(
                            text = username,
                            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center, color = uiColor.value),
                            textAlign = TextAlign.Center
                    )
                }
            }

            val mod = Modifier.width(375.dp).background(background)

            LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 75.dp),
                    modifier = mod.height(350.dp),
                    contentPadding = PaddingValues(40.dp),
                    userScrollEnabled = false,


                    ) {
                hiscoreSkillGrid()
                overallSkillItem()
            }
            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                    modifier = Modifier.height(20.dp).background(background)
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
                    columns = GridCells.Adaptive(minSize = 50.dp),
                    modifier = mod.height(150.dp),
                    contentPadding = PaddingValues(15.dp),
                    userScrollEnabled = false
            ) {
                hiscoreActivityGrid()
            }

            Row(
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End,
                    modifier = Modifier.height(20.dp).background(background)
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
                    columns = GridCells.Adaptive(minSize = 50.dp),
                    modifier = mod.height(500.dp),
                    userScrollEnabled = false
            ) {
                hiscoreBossGrid()
            }

        }
    }
}
