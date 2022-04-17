package com.questhelper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.questhelper.questhelpers.QuestHelper
import com.questhelper.requirements.Requirement
import eventbus.events.GameTick
import eventbus.events.InventoryChanged
import meteor.Main
import meteor.ui.UI
import meteor.ui.composables.PluginPanel

class QuestHelperPluginPanel(var questHelper: QuestHelper) : PluginPanel() {
    var quest = questHelper.quest
    val generalRequirements = HashMap<Requirement, Boolean>()
    val itemRequirements = HashMap<Requirement, Boolean>()
    val itemRecommend = HashMap<Requirement, Boolean>()
    val enemiesToDefeat = questHelper.combatRequirements
    val rewards = questHelper.questRewards

    init {
        updateGenRequirements()
        updateItemRequirements()
    }

    override fun onGameTick(it: GameTick) {
        updateGenRequirements()
    }

    override fun onInventoryChanged(it: InventoryChanged) {
        updateItemRequirements()
    }

    private fun updateGenRequirements() {
        questHelper.generalRequirements?.let {
            for (requirement in it) {
                generalRequirements[requirement] = requirement.check(Main.client)
            }
        }
    }

    private fun updateItemRequirements() {
        questHelper.itemRequirements?.let {
            for (requirement in it) {
                itemRequirements[requirement] = requirement.check(Main.client)
            }
        }
        questHelper.itemRecommended?.let {
            for (requirement in it) {
                itemRecommend[requirement] = requirement.check(Main.client)
            }
        }
    }

    @Composable override fun Header() {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(UI.darkThemeColors.background)) {
            MaterialTheme(colors = UI.darkThemeColors) {
                Text(quest.getName(),style = TextStyle(color = Color.Cyan, fontSize = 20.sp))
            }
        }
    }

    @Composable override fun Content() {
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(UI.darkThemeColors.surface)) {
            item {
                Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()) {
                    MaterialTheme(colors = UI.darkThemeColors) {
                        Requirements(generalRequirements, "General requirements")
                        Requirements(itemRequirements, "Item requirements")
                        Requirements(itemRecommend, "Item recommendation")
                        NonUpdatingTextList(enemiesToDefeat, "Enemies to defeat")
                        NonUpdatingTextList(rewards, "Quest rewards")
                    }
                }
            }
        }

    }

    @Composable fun Requirements(requirements: HashMap<Requirement, Boolean>, text: String) {
        if (requirements.isNotEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 30.dp).background(UI.darkThemeColors.surface)){
                Text(text, style = TextStyle(color = Color.Cyan, fontSize = 14.sp), modifier = Modifier.align(Alignment.Bottom))
            }

            LazyColumn(modifier = Modifier.fillMaxWidth().height((requirements.size * 32).dp).background(UI.darkThemeColors.surface).clip(
                RoundedCornerShape(size = 30.dp)
            ), horizontalAlignment = Alignment.CenterHorizontally, ) {
                items(items = requirements.keys.toList(), itemContent = { requirement ->
                    Row(modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(UI.darkThemeColors.background)){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(UI.darkThemeColors.background)) {
                            val meetsRequirement = requirements[requirement]!!
                            val color = if (meetsRequirement) Color.Green else Color.Red
                            Text(requirement.displayText,style = TextStyle(color = color, fontSize = 14.sp))
                        }
                    }
                })
            }
        }
    }

    @Composable fun NonUpdatingTextList(list: List<String>?, text: String) {
        if (!list.isNullOrEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 30.dp).background(UI.darkThemeColors.surface)){
                Text(text, style = TextStyle(color = Color.Cyan, fontSize = 14.sp), modifier = Modifier.align(Alignment.Bottom))
            }

            LazyColumn(modifier = Modifier.fillMaxWidth().height((list.size * 32).dp).background(UI.darkThemeColors.surface), horizontalAlignment = Alignment.CenterHorizontally, ) {
                items(items = list, itemContent = { line ->
                    if (line == "</br>") {
                        Spacer(Modifier.height(10.dp).background(UI.darkThemeColors.background))
                    }
                    else {
                        Row(modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(UI.darkThemeColors.background)){
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.fillMaxWidth(0.9f).height(32.dp).background(UI.darkThemeColors.background).clip(
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