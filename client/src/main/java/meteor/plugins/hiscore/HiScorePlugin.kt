package meteor.plugins.hiscore

import compose.icons.TablerIcons
import compose.icons.tablericons.Trophy
import eventbus.events.MenuOptionClicked
import meteor.config.ConfigManager
import meteor.hiscore.HiscoreClient
import meteor.hiscore.HiscoreEndpoint
import meteor.menus.MenuManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.preferences.*
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.MenuAction
import net.runelite.api.WorldType


@PluginDescriptor(name = "Hiscore", enabledByDefault = true, disabledOnStartup = false)
class HiScorePlugin : Plugin() {
    private val hiscoreClient = HiscoreClient()
    var panel: HiscorePanel? = null
    var config = configuration<HiscoreConfig>()


    private var hiscoreButton = ToolbarButton(
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

    fun getWorldEndpoint(): HiscoreEndpoint {
        if (client.worldType.contains(WorldType.FRESH_START_WORLD)) {
            return HiscoreEndpoint.FRESH_START_WORLD
        }
        if (client.worldType.contains(WorldType.DEADMAN)) {
            return HiscoreEndpoint.DEADMAN
        }
        return HiscoreEndpoint.NORMAL
    }

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
            HiscorePanel.result.value = hiscoreClient.lookup(config.username(), endpoint = getWorldEndpoint())
            if (!pluginPanelIsOpen.value) {
                togglePluginPanel(hiscoreButton)
                pluginPanel.value = panel
                hiscoreOpen.value = true
                pluginsOpen.value = false
            }
            panel!!.username.value = config.username()
        }
    }

    fun onClick() {
        if (panel!!.username.value != config.username()) {
            panel!!.username.value = config.username()
            HiscorePanel.result.value = hiscoreClient.lookup(config.username(), endpoint = getWorldEndpoint())
        }
        togglePluginPanel(hiscoreButton)
        pluginPanel.value = panel
        hiscoreOpen.value = true
        pluginsOpen.value = false
    }

    override fun onStart() {
        MenuManager.addPlayerMenuItem("Lookup")
        panel = HiscorePanel()
        addButton(hiscoreButton)
    }

    override fun onStop() {
        removeButton(hiscoreButton)
        panel = null
    }
}