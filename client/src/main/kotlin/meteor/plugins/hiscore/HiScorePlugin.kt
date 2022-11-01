package meteor.plugins.hiscore

import compose.icons.Octicons
import compose.icons.octicons.Graph16
import eventbus.events.MenuOptionClicked
import meteor.config.ConfigManager
import meteor.menus.MenuManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.IconID
import net.runelite.api.MenuAction
import net.runelite.http.api.hiscore.HiscoreClient
import net.runelite.http.api.hiscore.HiscoreEndpoint
import net.runelite.http.api.hiscore.HiscoreResult
import okhttp3.OkHttpClient


@PluginDescriptor(name = "Hiscore", enabledByDefault = true, disabledOnStartup = false)
class HiScorePlugin : Plugin() {
    private val hiscoreClient = HiscoreClient(OkHttpClient())
    var panel: HiscorePanel? = null
    var config = configuration<HiscoreConfig>()
     var lookupResult:HiscoreResult = hiscoreClient.lookup(config.username())
    var icon:HiscoreEndpoint = HiscoreEndpoint.NORMAL

    private var notesButton = ToolbarButton(
        "HiScore",
        Octicons.Graph16,
        iconColor = uiColor,
        description = "Notes",
        onClick = {
            onClick()
        },
        bottom = false
    )



    override fun onMenuOptionClicked(event: MenuOptionClicked) {
        if (event.getMenuAction() == MenuAction.RUNELITE_PLAYER && event.getMenuOption()
                .equals("Lookup")
        ) {
            val player = event.menuEntry.player?.name
            ConfigManager.setConfiguration(
                "hiscore",
                "username",
                player!!
            )
            lookupResult = hiscoreClient.lookup(config.username())
            icon = findHiscoreEndpointFromPlayerName(event.menuEntry.player.toString())
            println(icon)
            println(event.getMenuTarget())
        }
    }
    private fun findHiscoreEndpointFromPlayerName(name: String): HiscoreEndpoint {
        return when {
            IconID.IRONMAN.toString() in name -> {
                HiscoreEndpoint.IRONMAN
            }
            IconID.ULTIMATE_IRONMAN.toString() in name -> {
                HiscoreEndpoint.ULTIMATE_IRONMAN
            }
            IconID.HARDCORE_IRONMAN.toString() in name -> {
                HiscoreEndpoint.HARDCORE_IRONMAN
            }
            else -> if (IconID.LEAGUE.toString() in name) {
                HiscoreEndpoint.LEAGUE
            } else HiscoreEndpoint.NORMAL
        }
    }
    private fun iconFromPlayerName(name: String): IconID? {
        return when {
            IconID.IRONMAN.toString() in name -> {
                IconID.IRONMAN
            }
            IconID.ULTIMATE_IRONMAN.toString() in name -> {
                IconID.ULTIMATE_IRONMAN
            }
            IconID.HARDCORE_IRONMAN.toString() in name -> {
                IconID.HARDCORE_IRONMAN
            }
            else -> if (IconID.LEAGUE.toString() in name) {
                IconID.LEAGUE
            } else IconID.IRONMAN
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