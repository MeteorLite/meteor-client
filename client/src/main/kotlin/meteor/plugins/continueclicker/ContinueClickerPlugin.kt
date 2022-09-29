package meteor.plugins.continueclicker

import dev.hoot.api.widgets.Dialog
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread


@PluginDescriptor(
    name = "Continue Clicker",
    description = "Presses continue on dialogue when available",
    tags = ["continue", "chat", "dialogue", "clicker"],
    enabledByDefault = false
)
class ContinueClickerPlugin : Plugin() {

    var clientThread: ClientThread? = null


    override val config = configuration<ContinueClickerConfig>()

    override fun onStart() {}


    override fun onStop() {}


    override fun onGameTick(it: GameTick) {
        if (config.continueChat()) {
            if (Dialog.canContinue()) {
                Dialog.continueSpace()
            }
        }
        if (config.questHelper()) {
            if (Dialog.isViewingOptions()) {
                Dialog.chooseOption("[")
            }
        }
    }
}