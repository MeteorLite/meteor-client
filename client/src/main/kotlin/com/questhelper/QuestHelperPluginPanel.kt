package com.questhelper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.questhelper.questhelpers.QuestHelper
import com.questhelper.requirements.Requirement
import com.questhelper.requirements.item.ItemRequirement
import eventbus.events.GameTick
import eventbus.events.ItemContainerChanged
import meteor.Main
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*

class QuestHelperPluginPanel(var questHelper: QuestHelper) : PluginPanel() {
    var quest = questHelper.quest

    //Dynamic data
    val generalRequirements = questHelper.generalRequirements
    val itemRequirements = questHelper.itemRequirements
    val itemRecommends = questHelper.itemRecommended

    //We use mutableStateOf so compose is aware of changes to it, and will redraw
    //Checking requirements met must be done on ClientThread (so not in @Composable function)
    //Which is why we use EventBus to update requirements met
    var generalRequirementsMet = mutableStateOf(ArrayList<RequirementMet>())
    var itemRequirementsMet = mutableStateOf(ArrayList<RequirementMet>())
    var itemRecommendMet = mutableStateOf(ArrayList<RequirementMet>())

    //Static data
    val enemiesToDefeat = questHelper.combatRequirements
    val rewards = questHelper.questRewards

    init {
        generalRequirements?.let { updateRequirements(generalRequirements) }
        itemRequirements?.let { updateRequirements(itemRequirements) }
        itemRecommends?.let { updateRequirements(itemRecommends) }
    }

    override fun onGameTick(it: GameTick) {
        generalRequirements?.let { updateRequirements(generalRequirements) }
    }

    override fun onItemContainerChanged(it: ItemContainerChanged) {
        itemRequirements?.let { updateRequirements(itemRequirements) }
        itemRecommends?.let { updateRequirements(itemRecommends) }
    }

    fun updateRequirements(requirements: List<Requirement>) {
        val requirementsMet = ArrayList<RequirementMet>()
        requirements.forEach {
            requirementsMet.add(RequirementMet(it, it.check(Main.client)))
        }
        when (requirements) {
            generalRequirements -> generalRequirementsMet.value = requirementsMet
            itemRequirements -> itemRequirementsMet.value = requirementsMet
            itemRecommends -> itemRecommendMet.value = requirementsMet
        }
    }

    @Composable override fun Header() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.width(375.dp).fillMaxHeight(0.05f).background(background  )) {
            MaterialTheme(colors = if (darkLightMode.value)darkThemeColors else lightThemeColors ) {
                Text(quest.getName(),style = TextStyle(color = Color.Cyan, fontSize = 20.sp))
            }
        }
    }

    @Composable override fun Content() {
        LazyColumn(modifier = Modifier.width(375.dp).fillMaxHeight().background(surface )) {
            item {
                Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()) {
                    MaterialTheme(colors = if (darkLightMode.value)darkThemeColors else lightThemeColors ) {
                        Requirements(generalRequirementsMet.value, "General requirements")
                        Requirements(itemRequirementsMet.value, "Item requirements")
                        Requirements(itemRecommendMet.value, "Item recommendation")
                        NonUpdatingTextList(enemiesToDefeat, "Enemies to defeat")
                        NonUpdatingTextList(rewards, "Quest rewards")
                    }
                }
            }
        }

    }

    @Composable fun Requirements(requirements: ArrayList<RequirementMet>, text: String) {
        if (requirements.isNotEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 30.dp).background(darkThemeColors.surface)){
                Text(text, style = TextStyle(color = Color.Cyan, fontSize = 14.sp), modifier = Modifier.align(Alignment.Bottom))
            }

            LazyColumn(modifier = Modifier.fillMaxWidth().height((requirements.size * 32).dp).background(darkThemeColors.surface).clip(
                RoundedCornerShape(size = 35.dp)
            ), horizontalAlignment = Alignment.CenterHorizontally, ) {
                items(items = requirements, itemContent = { requirement ->
                    Row(modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(background  )){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(background  )) {

                            if (requirement.requirement is ItemRequirement && requirement.requirement.quantity != -1) {
                                val meetsRequirement = requirement.met
                                Text(
                                    "${requirement.requirement.quantity}",
                                    style = TextStyle(color = Color.White, fontSize = 14.sp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                val color = if (meetsRequirement) Color.Green else Color.Red
                                Text(
                                    requirement.requirement.displayText,
                                    style = TextStyle(color = color, fontSize = 14.sp)
                                )
                            } else {
                                val meetsRequirement = requirement.met
                                val color = if (meetsRequirement) Color.Green else Color.Red
                                Text(
                                    requirement.requirement.displayText,
                                    style = TextStyle(color = color, fontSize = 14.sp)
                                )
                            }
                        }
                    }
                })
            }
        }
    }

    @Composable fun NonUpdatingTextList(list: List<String>?, text: String) {
        if (!list.isNullOrEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 30.dp).background(darkThemeColors.surface)){
                Text(text, style = TextStyle(color = Color.Cyan, fontSize = 14.sp), modifier = Modifier.align(Alignment.Bottom))
            }

            LazyColumn(modifier = Modifier.fillMaxWidth().height((list.size * 32).dp).background(darkThemeColors.surface), horizontalAlignment = Alignment.CenterHorizontally, ) {
                items(items = list, itemContent = { line ->
                    if (line == "</br>") {
                        Spacer(Modifier.height(10.dp).background(background ) )
                    }
                    else {
                        Row(modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(background ) ){
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(background ) .clip(
                                    RoundedCornerShape(size = 30.dp)
                                )) {
                                val color = Color.White
                                Text(line, style = TextStyle(color = color, fontSize = 14.sp))
                            }
                        }
                    }
                })
            }
        }
    }
}