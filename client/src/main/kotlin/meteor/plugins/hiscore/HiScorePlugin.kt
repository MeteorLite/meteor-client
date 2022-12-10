package meteor.plugins.hiscore

import androidx.compose.ui.Alignment
import eventbus.events.MenuOptionClicked
import meteor.config.ConfigManager
import meteor.menus.MenuManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.MenuAction
import net.runelite.http.api.hiscore.HiscoreClient
import okhttp3.OkHttpClient


@PluginDescriptor(name = "Hiscore", enabledByDefault = true, disabledOnStartup = false)
class HiScorePlugin : Plugin() {
    private val hiscoreClient = HiscoreClient(OkHttpClient())
    var panel: HiscorePanel? = null
    var config = configuration<HiscoreConfig>()


    private var hiScoreButton = ToolbarButton(
        "HiScore",
        imageResource = "/plugins/hiscore/normal.png",
        description = "Player Hiscores",
        onClick = {
            onClick()
        },
        bottom = false,
        alignment = Alignment.Center
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
        togglePluginPanel(hiScoreButton)
    }

    override fun onStart() {
        MenuManager.addPlayerMenuItem("Lookup")
        panel = HiscorePanel()
        addButton(hiScoreButton)
    }

    override fun onStop() {
        removeButton(hiScoreButton)
        panel = null
    }
}