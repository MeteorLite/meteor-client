package meteor.plugins.keyremapping

import eventbus.events.ScriptCallbackEvent
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.ColorUtil
import net.runelite.api.GameState
import net.runelite.api.VarClientInt
import net.runelite.api.VarClientStr
import net.runelite.api.Varbits
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.chat.JagexColors
import java.awt.Color

@PluginDescriptor(
    name = "Key Remapping",
    description = "Allows use of WASD keys for camera movement with 'Press Enter to Chat', and remapping number keys to F-keys",
    tags = ["enter", "chat", "wasd", "camera"],
    enabledByDefault = false
)
class KeyRemappingPlugin : Plugin() {
    override val config = configuration<KeyRemappingConfig>()

    private val inputListener = KeyRemappingListener

    var typing = false
    override fun onStart() {
        typing = false
        KeyManager.registerKeyListener(inputListener, this.javaClass)

        ClientThread.invoke {
            if (client.gameState == GameState.LOGGED_IN) {
                lockChat()
                client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "")
            }
        }
    }

    override fun onStop() {
        ClientThread.invoke {
            if (client.gameState == GameState.LOGGED_IN) {
                unlockChat()
            }
        }

        KeyManager.unregisterKeyListener(inputListener)

    }


    fun chatboxFocused(): Boolean {
        val chatboxParent: Widget? = client.getWidget(WidgetInfo.CHATBOX_PARENT)
        if (chatboxParent == null || chatboxParent.onKeyListener == null) {
            return false
        }

        val worldMapSearch: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_SEARCH)
        return worldMapSearch == null || client.getVar(VarClientInt.WORLD_MAP_SEARCH_FOCUSED) != 1
    }

    val isDialogOpen: Boolean
        get() = (isHidden(WidgetInfo.CHATBOX_MESSAGES) || isHidden(WidgetInfo.CHATBOX_TRANSPARENT_LINES)
                || !isHidden(WidgetInfo.BANK_PIN_CONTAINER))
    val isOptionsDialogOpen: Boolean
        get() = client.getWidget(WidgetInfo.DIALOG_OPTION) != null

    private fun isHidden(widgetInfo: WidgetInfo): Boolean {
        val w: Widget? = client.getWidget(widgetInfo)
        return w == null || w.isSelfHidden
    }


    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        when (it.eventName) {
            "setChatboxInput" -> {
                val chatboxInput: Widget? = client.getWidget(WidgetInfo.CHATBOX_INPUT)
                if (chatboxInput != null && !typing) {
                    setChatboxWidgetInput(chatboxInput, PRESS_ENTER_TO_CHAT)
                }
            }
            "blockChatInput" -> if (!typing) {
                val intStack = client.intStack
                val intStackSize = client.intStackSize
                intStack[intStackSize - 1] = 1
            }
        }
    }

    fun lockChat() {
        val chatboxInput: Widget? = client.getWidget(WidgetInfo.CHATBOX_INPUT)
        if (chatboxInput != null) {
            setChatboxWidgetInput(chatboxInput, PRESS_ENTER_TO_CHAT)
        }
    }

    fun unlockChat() {
        val chatboxInput: Widget? = client.getWidget(WidgetInfo.CHATBOX_INPUT)
        if (chatboxInput != null) {
            if (client.gameState == GameState.LOGGED_IN) {
                val isChatboxTransparent =
                    client.isResized && client.getVarbitValue(Varbits.TRANSPARENT_CHATBOX.id) == 1
                val textColor: Color =
                    if (isChatboxTransparent) JagexColors.CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND else JagexColors.CHAT_TYPED_TEXT_OPAQUE_BACKGROUND
                setChatboxWidgetInput(
                    chatboxInput,
                    ColorUtil.wrapWithColorTag(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT) + "*", textColor)
                )
            }
        }
    }

    private fun setChatboxWidgetInput(widget: Widget, input: String) {
        val text = widget.text
        val idx = text.indexOf(':')
        if (idx != -1) {
            val newText = text.substring(0, idx) + ": " + input
            widget.text = newText
        }
    }

    companion object {
        private const val PRESS_ENTER_TO_CHAT = "Press Enter to Chat..."
    }
}