package meteor.ui.composables.hiscore

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.plugins.hiscore.HiScorePlugin
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import net.runelite.http.api.hiscore.HiscoreSkill
import net.runelite.http.api.hiscore.HiscoreSkillType
import kotlin.math.max
var result = HiScorePlugin().lookupResult
@OptIn(ExperimentalFoundationApi::class)

fun LazyGridScope.hiscoreSkillGrid(){
    items(items = HiscoreSkill.values().filter { it.type == HiscoreSkillType.SKILL }) { item ->
        Card(backgroundColor = surface, modifier = Modifier.padding(4.dp)) {

            TooltipArea(tooltipPlacement = TooltipPlacement.ComponentRect(), tooltip = {
                Column(modifier = Modifier.background(surface)) {
                    Text(
                        text = mutableStateOf(
                            "Rank:" + max(
                                0,
                                result.getSkill(item).rank
                            ).toString()
                        ).value,
                        style = TextStyle(fontSize = 10.sp, color = uiColor)
                    )
                    Text(
                        text = mutableStateOf(
                            "Total Exp:" + max(
                                0,
                                result.getSkill(item).experience
                            ).toString()
                        ).value,
                        style = TextStyle(fontSize = 10.sp, color = uiColor)
                    )
                }

            }, delayMillis = 500) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(horizontalArrangement = Arrangement.Center) {


                        Spacer(modifier = Modifier.width(15.dp))
                        Image(
                            painter = painterResource("skill_icons_small/${item.name}.png".lowercase()),
                            contentDescription = item.name
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            text = mutableStateOf(result.getSkill(item)?.level.toString()).value,
                            style = TextStyle(fontSize = 15.sp, color = uiColor)
                        )
                    }
                }


            }

        }

    }
}

fun LazyGridScope.overallSkillItem(){
    items(items = HiscoreSkill.values().filter { it.type == HiscoreSkillType.OVERALL }) { overall ->
        Card(backgroundColor = surface, modifier = Modifier.padding(4.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource("skill_icons_small/${overall.name}.png".lowercase()),
                    contentDescription = overall.name
                )
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = mutableStateOf(result.getSkill(overall)?.level.toString()).value,
                        style = TextStyle(fontSize = 10.sp, color = uiColor)
                    )
                }
            }
        }
    }
}