package meteor.plugins.hiscore

import compose.icons.TablerIcons
import compose.icons.tablericons.Trophy
import eventbus.events.MenuOptionClicked
import meteor.config.ConfigManager
import meteor.hiscore.HiscoreClient
import meteor.menus.MenuManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.preferences.hiscoreOpen
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.pluginsOpen
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
        position = 4,
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
        hiscoreOpen.value = true
        pluginsOpen.value = false
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