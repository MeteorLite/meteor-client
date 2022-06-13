package meteor.plugins.keyremapping

import com.google.common.base.Strings
import meteor.Main.client
import meteor.input.KeyListener
import meteor.rs.ClientThread
import net.runelite.api.VarClientStr

import java.awt.event.KeyEvent


object KeyRemappingListener : KeyListener {

    private val plugin = KeyRemappingPlugin()

    private val config = plugin.configuration<KeyRemappingConfig>()

    private val modified: MutableMap<Int, Int> = HashMap()
    private val blockedChars: MutableSet<Char> = HashSet()
    override fun keyTyped(e: KeyEvent) {
        val keyChar = e.keyChar
        if (keyChar != KeyEvent.CHAR_UNDEFINED && blockedChars.contains(keyChar) && plugin.chatboxFocused()) {
            e.consume()
        }
    }

    override fun keyPressed(e: KeyEvent) {
        if (!plugin.chatboxFocused()) {
            return
        }
        if (!plugin.typing) {
            var mappedKeyCode = KeyEvent.VK_UNDEFINED
            when {
                config.cameraRemap() -> {
                    when {
                        config.up().matches(e) -> {
                            mappedKeyCode = KeyEvent.VK_UP
                        }
                        config.down().matches(e) -> {
                            mappedKeyCode = KeyEvent.VK_DOWN
                        }
                        config.left().matches(e) -> {
                            mappedKeyCode = KeyEvent.VK_LEFT
                        }
                        config.right().matches(e) -> {
                            mappedKeyCode = KeyEvent.VK_RIGHT
                        }
                    }
                }
            }


            if (config.fkeyRemap() && !plugin.isDialogOpen) {
                when {
                    config.f1().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F1
                    }
                    config.f2().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F2
                    }
                    config.f3().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F3
                    }
                    config.f4().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F4
                    }
                    config.f5().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F5
                    }
                    config.f6().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F6
                    }
                    config.f7().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F7
                    }
                    config.f8().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F8
                    }
                    config.f9().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F9
                    }
                    config.f10().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F10
                    }
                    config.f11().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F11
                    }
                    config.f12().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_F12
                    }
                    config.esc().matches(e) -> {
                        mappedKeyCode = KeyEvent.VK_ESCAPE
                    }
                }
            }

            if (plugin.isDialogOpen && !plugin.isOptionsDialogOpen && config.space().matches(e)) {
                mappedKeyCode = KeyEvent.VK_SPACE
            }
            if (config.control().matches(e)) {
                mappedKeyCode = KeyEvent.VK_CONTROL
            }
            if (mappedKeyCode != KeyEvent.VK_UNDEFINED && mappedKeyCode != e.keyCode) {
                val keyChar = e.keyChar
                modified[e.keyCode] = mappedKeyCode
                e.keyCode = mappedKeyCode

                e.keyChar = KeyEvent.CHAR_UNDEFINED
                if (keyChar != KeyEvent.CHAR_UNDEFINED) {

                    blockedChars.add(keyChar)
                }
            }
            when (e.keyCode) {
                KeyEvent.VK_ENTER, KeyEvent.VK_SLASH, KeyEvent.VK_COLON -> {
                    // refocus chatbox
                    plugin.typing = true
                    ClientThread.invoke { plugin.unlockChat() }
                }
            }
        } else {
            when (e.keyCode) {
                KeyEvent.VK_ESCAPE -> {

                    e.consume()
                    plugin.typing = false
                    ClientThread.invoke {
                        client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "")
                        plugin.lockChat()
                    }
                }
                KeyEvent.VK_ENTER -> {
                    plugin.typing = false
                    ClientThread.invoke { plugin.lockChat() }
                }
                KeyEvent.VK_BACK_SPACE ->
                    if (Strings.isNullOrEmpty(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT))) {
                        plugin.typing = false
                        ClientThread.invoke { plugin.lockChat() }
                    }
            }
        }
    }

    override fun keyReleased(e: KeyEvent) {
        val keyCode = e.keyCode
        val keyChar = e.keyChar
        if (keyChar != KeyEvent.CHAR_UNDEFINED) {
            blockedChars.remove(keyChar)
        }
        val mappedKeyCode = modified.remove(keyCode)
        if (mappedKeyCode != null) {
            e.keyCode = mappedKeyCode
            e.keyChar = KeyEvent.CHAR_UNDEFINED
        }
    }
}