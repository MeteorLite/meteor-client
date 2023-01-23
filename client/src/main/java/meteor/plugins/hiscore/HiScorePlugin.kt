package meteor.plugins.hiscore

import compose.icons.TablerIcons
import compose.icons.tablericons.Trophy
import eventbus.events.MenuOptionClicked
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

    var panel: HiscorePanel? = null

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



    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuAction() == MenuAction.RUNELITE_PLAYER && it.getMenuOption()
                .equals("Lookup")
        ) {
            val player = it.menuEntry.player?.name
            if (player != null) {
                username.value =  player
            }

            hiscoreresult.value = hiscoreClient.lookup(username.value, endpoint = getWorldEndpoint())
            if (!pluginPanelIsOpen.value) {
                togglePluginPanel(hiscoreButton)
                pluginPanel.value = panel
                hiscoreOpen.value = true
                pluginsOpen.value = false
            }

        }
    }

    fun onClick() {

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