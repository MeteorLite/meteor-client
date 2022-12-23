package meteor.ui.composables.hiscore

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import net.runelite.http.api.hiscore.HiscoreSkill
import net.runelite.http.api.hiscore.HiscoreSkillType
import kotlin.math.max

@OptIn(ExperimentalFoundationApi::class)

fun LazyGridScope.hiscoreActivityGrid() {
    items(HiscoreSkill.values().filter { it.type == HiscoreSkillType.ACTIVITY }) { item ->

        Card(backgroundColor = surface, modifier = Modifier.padding(5.dp).size(25.dp)) {

            TooltipArea(
                modifier = Modifier.background(
                    shape = RoundedCornerShape(3.dp), color = surface
                ), tooltipPlacement = TooltipPlacement.ComponentRect(), tooltip = {
                    Column(modifier = Modifier.background(surface)) {
                        Text(
                            text = "Rank:" + max(0, result.getSkill(item).rank).toString(),
                            style = TextStyle(fontSize = 10.sp, color = uiColor.value)
                        )
                        Text(
                            text = "Activity:" + item.name.lowercase().replace('_', ' '),
                            style = TextStyle(fontSize = 10.sp, color = uiColor.value)
                        )
                    }

                }, delayMillis = 500
            ) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.offset(y = 5.dp)) {
                    Spacer(Modifier.width(15.dp))
                    Image(
                        painter = painterResource("skill_icons_small/activities/${item.name}.png".lowercase()),
                        contentDescription = item.name,
                        modifier = Modifier.size(12.dp)
                    )
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = max(0, result.getSkill(item).level).toString(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                color = uiColor.value
                            )
                        )
                    }
                }
            }
        }
    }
}