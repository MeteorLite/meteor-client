package meteor.plugins.keyboardbankpin

import eventbus.events.ScriptCallbackEvent
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.ScriptEvent
import net.runelite.api.ScriptID
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
                        val chatboxTypedText = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT)
                        val inputText = client.getVar(VarClientStr.INPUT_TEXT)
                        ClientThread.invokeLater {
                            // reset chatbox input to avoid pin going to chatbox..
                            client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, chatboxTypedText)
                            client.runScript(ScriptID.CHAT_PROMPT_INIT)
                            client.setVar(VarClientStr.INPUT_TEXT, inputText)
                            client.runScript(ScriptID.CHAT_TEXT_INPUT_REBUILD, "")
                            client.runScript(*onOpListener)
                        }
                    }
                })
            }
        }
    }
}