package meteor.plugins.xptracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.Main.client
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*
import net.runelite.api.Experience.*
import kotlin.math.roundToInt

class XpTrackerPluginPanel : PluginPanel() {

    @Composable
    override fun Header() {
    }


    @Composable
    override fun Content() {

        LazyColumn {
            items(items = expMap.keys.toList()) { skill ->

                Spacer(Modifier.height(10.dp))
                Row(
                    Modifier.background(color = surface, shape = RoundedCornerShape(3.dp)),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = skill.name.lowercase().replaceFirstChar { it.uppercase() },
                        style = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            color = uiColor,
                            letterSpacing = 2.sp
                        ),
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(Modifier.height(8.dp))
                Row(
                    Modifier.background(surface, RoundedCornerShape(8.dp)).height(125.dp).width(350.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier.width(32.dp).height(70.dp),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource("skill_icons/${skill}.png".lowercase()),
                            contentDescription = skill.name,
                            modifier = Modifier.scale(1.5f),
                        )
                        Text(
                            text = client.getRealSkillLevel(skill).toString(),
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Left,
                                color = intColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Left,
                        )
                    }
                    Column(Modifier.width(130.dp)) {

                        Text(
                            text = "Start XP:",
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                color = uiColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Left,
                        )
                        Text(
                            text = "Current XP:",
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                color = uiColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Left,
                        )
                        Text(
                            text = "XP Gained:",
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                color = uiColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Right,
                        )

                        Row {
                            Text(
                                text = "XP Until ",
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center,
                                    color = uiColor,
                                    letterSpacing = 2.sp
                                ),
                                textAlign = TextAlign.Left,
                            )
                            Text(
                                text = ("${(client.getRealSkillLevel(skill) + 1)}:").toString(),
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center,
                                    color = intColor,
                                    letterSpacing = 2.sp
                                ),
                                textAlign = TextAlign.Right,
                            )
                        }
                        Text(
                            text = "XP per hour:",
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                color = uiColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Left,
                        )
                    }
                    Column{

                        startExp.forEach {
                            if (it.first == skill)
                                Text(
                                    text = it.second.toString(),
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        textAlign = TextAlign.Center,
                                        color = intColor,
                                        letterSpacing = 2.sp
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                        }

                        expMap.forEach {
                           if(it.value == client.getSkillExperience(skill))
                                Text(
                                    text = it.value.toString(),
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        textAlign = TextAlign.Center,
                                        color = intColor,
                                        letterSpacing = 2.sp
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        startExp.forEach {
                            if (it.first == skill)
                                Text(
                                    text = (client.getSkillExperience(skill) - it.second).toString(),
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        textAlign = TextAlign.Center,
                                        color = intColor,
                                        letterSpacing = 2.sp
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                        }
                        Text(
                            text = (getXpForLevel((client.getRealSkillLevel(skill) + 1)) - client.getSkillExperience(
                                skill
                            )).toString(),
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                color = intColor,
                                letterSpacing = 2.sp
                            ),
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = if(xpHr.value > 0)xpHr.value.toString()else "-/-",
                            style = TextStyle(
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center,
                                letterSpacing = 2.sp,
                                color = intColor
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(2.dp)) {

                    val start = getXpForLevel(client.getRealSkillLevel(skill))
                    val curr = client.getSkillExperience(skill)
                    val xpGained = (curr - start).toDouble()
                    val end = getXpForLevel(client.getRealSkillLevel(skill) + 1)
                    val startFloat = (start / end).toDouble().toFloat()
                    val endFloat = (end / start).toDouble().toFloat()

                    val xpGoal = (end - start).toDouble()
                    val skillProgress = (xpGained / xpGoal).toFloat()
                    val progress = ((xpGained / xpGoal) * 100).roundToInt()
                    BoxWithConstraints(contentAlignment = Alignment.Center) {
                        Box {
                            LinearProgressIndicator(
                                modifier = Modifier.width(345.dp).height(20.dp).progressSemantics(
                                    value = skillProgress,
                                    valueRange = startFloat..endFloat
                                ).background(shape = RoundedCornerShape(3.dp), color = surface),
                                color = uiColor,
                                backgroundColor = surface,
                                progress = skillProgress
                            )
                        }
                        Box {
                            Text(
                                text = "$progress%",
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center,
                                    color = if (progress >= 50) Color.Black else intColor,
                                    letterSpacing = 2.sp
                                ),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }

            }
        }
    }
}