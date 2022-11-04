package meteor.plugins.exptracker

import compose.icons.Octicons
import compose.icons.octicons.Meter16
import eventbus.events.StatChanged
import meteor.Main
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.GameState
import net.runelite.api.Skill


@PluginDescriptor(name = "ExpTracker", enabledByDefault = true)
open class ExpTrackerPlugin : Plugin() {

        var panel: PluginPanel? = null
        private var expButton = ToolbarButton(
            "Exp",
            Octicons.Meter16,
            iconColor = uiColor,
            description = "Notes",
            onClick = {
                onClick()
            },
            bottom = false
        )

        fun onClick() {
            pluginPanel.value = panel
            togglePluginPanel(expButton)
        }
        override fun onStatChanged(it: StatChanged) {
            if(client.gameState == GameState.LOGGED_IN)
            skill.value = it.skill.toString()
            skillList.add(skill.value)
            xp.value = it.xp
            xpList.add(xp.value.toString())
        }
        override fun onStart() {
            startExp = Skill.values().associateWith { Main.client.getSkillExperience(it) }.toList()
            panel = ExpTrackerPluginPanel()
            addButton(expButton)

        }

        override fun onStop() {
            removeButton(expButton)
            skillList.clear()
            panel = null
        }
    }



