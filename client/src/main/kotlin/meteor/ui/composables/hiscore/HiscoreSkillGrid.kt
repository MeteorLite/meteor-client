package meteor.ui.composables.hiscore

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.hiscore.HiscoreSkill
import meteor.hiscore.HiscoreSkillType
import meteor.plugins.hiscore.HiscorePanel
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import kotlin.math.max

var result = HiscorePanel.result!!

@OptIn(ExperimentalFoundationApi::class)

fun LazyGridScope.hiscoreSkillGrid() {
    items(items = HiscoreSkill.values().filter { it.type == HiscoreSkillType.SKILL }) { item ->
        Card(backgroundColor = surface, modifier = Modifier.size(40.dp).padding(4.dp)) {

            TooltipArea(tooltipPlacement = TooltipPlacement.ComponentRect(), tooltip = {
                Column(modifier = Modifier.background(surface)) {
                    Text(
                            text = mutableStateOf(
                                    "Rank:" + max(
                                            0,
                                            result.getSkill(item)!!.rank
                                    ).toString()
                            ).value,
                            style = TextStyle(fontSize = 10.sp, color = uiColor.value)
                    )
                    Text(
                            text = mutableStateOf(
                                    "Total Exp:" + max(
                                            0,
                                            result.getSkill(item)!!.experience
                                    ).toString()
                            ).value,
                            style = TextStyle(fontSize = 10.sp, color = uiColor.value)
                    )
                }

            }, delayMillis = 500) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(horizontalArrangement = Arrangement.Center) {


                        Spacer(modifier = Modifier.width(15.dp))
                        Image(
                                painter = painterResource("skill_icons/${item.name}.png".lowercase()),
                                contentDescription = item.name,
                                modifier = Modifier.size(18.dp).offset(y = 5.dp),
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                                text = mutableStateOf(result.getSkill(item)?.level.toString()).value,
                                style = TextStyle(fontSize = 15.sp, color = uiColor.value),
                                modifier = Modifier.offset(x = -5.dp, y = 5.dp)
                        )
                    }
                }


            }

        }

    }
}

fun LazyGridScope.overallSkillItem() {
    items(items = HiscoreSkill.values().filter { it.type == HiscoreSkillType.OVERALL }) { overall ->
        Card(backgroundColor = surface, modifier = Modifier.size(40.dp).padding(4.dp)) {
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.offset(x = 5.dp, y = -2.dp)) {
                Image(
                        painter = painterResource("skill_icons/${overall.name}.png".lowercase()),
                        contentDescription = overall.name,
                        modifier = Modifier.size(18.dp),
                        alignment = Alignment.Center
                )
                    Text(
                            text = mutableStateOf(result.getSkill(overall)?.level.toString()).value,
                            style = TextStyle(fontSize = 15.sp, color = uiColor.value),
                    )
                }
        }
    }
}