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


    val config = configuration<ContinueClickerConfig>()

    override fun onStart() {}


    override fun onStop() {}


    override fun onGameTick(it: GameTick) {
        if (config.continueChat()) {
            if (Dialog.canContinue()) {
                Dialog.continueSpace()
            }
        }

        if (Dialog.isViewingOptions() && config.customSTR() != "") {
            Dialog.getOptions().forEach{
                Option ->
                val dialogText = Option.text
                val customOption = config.customSTR().split(",")
                customOption.forEach {
                    str ->
                    if (dialogText.contains(str.trim())) {
                        Dialog.chooseOption(str)
                        return
                    }
                }
            }
        }

        if (config.questHelper()) {
            if (Dialog.isViewingOptions()) {
                Dialog.chooseOption("[")
            }
        }

    }
}