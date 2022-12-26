package meteor.plugins.hiscore

import compose.icons.Octicons
import compose.icons.TablerIcons
import compose.icons.octicons.Graph16
import compose.icons.octicons.People16
import compose.icons.octicons.People24
import compose.icons.tablericons.Trophy
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.config.ConfigManager
import meteor.hiscore.HiscoreClient
import meteor.menus.MenuManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.MenuAction


@PluginDescriptor(name = "Hiscore", enabledByDefault = true, disabledOnStartup = false)
class HiScorePlugin : Plugin() {
    private val hiscoreClient = HiscoreClient()
    var panel: HiscorePanel? = null
    var config = configuration<HiscoreConfig>()


    private var notesButton = ToolbarButton(
        "HiScore",
        TablerIcons.Trophy,
        iconColor = uiColor.value,
        description = "Player Hiscores",
        position = 3,
        onClick = {
            onClick()
        },
        bottom = false
    )



    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuAction() == MenuAction.RUNELITE_PLAYER && it.getMenuOption()
                .equals("Lookup")
        ) {

            val player = it.menuEntry.player?.name
            ConfigManager.setConfiguration(
                "hiscore",
                "username",
                player!!
            )
        }
    }

    fun onClick() {
        if (panel!!.username != config.username()) {
            panel!!.username = config.username()
            HiscorePanel.result = hiscoreClient.lookup(config.username())
        }
        pluginPanel.value = panel
        togglePluginPanel(notesButton)
    }

    override fun onStart() {
        MenuManager.addPlayerMenuItem("Lookup")
        panel = HiscorePanel()
        addButton(notesButton)
    }

    override fun onStop() {
        removeButton(notesButton)
        panel = null
    }
}