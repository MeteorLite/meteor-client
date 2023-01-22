package meteor.plugins.keyboardbankpin

import eventbus.events.ScriptCallbackEvent
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ScriptEvent
import net.runelite.api.VarClientInt
import net.runelite.api.VarClientStr
import net.runelite.api.widgets.JavaScriptCallback

@PluginDescriptor("KeyboardBankPin", configGroup = "keyboardBankPin")
class KeyboardBankPinPlugin : Plugin() {
    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        val intStack = client.intStack
        val intStackSize = client.intStackSize
        when (it.eventName) {
            "bankpinButtonSetup" -> {
                val compId = intStack[intStackSize - 2]
                val buttonId = intStack[intStackSize - 1]
                val button = client.getWidget(compId)
                val buttonRect = button!!.getChild(0)
                val onOpListener = buttonRect.onOpListener
                buttonRect.setOnKeyListener(JavaScriptCallback { e: ScriptEvent ->
                    val typedChar = e.typedKeyChar - '0'.code
                    if (typedChar == buttonId) {
                        client.runScript(*onOpListener)
                        // Block the key press this tick in keypress_permit so it doesn't enter the chatbox
                        client.setVarcIntValue(VarClientInt.BLOCK_KEYPRESS.index, client.gameCycle + 1)
                    }
                })
            }
        }
    }
}