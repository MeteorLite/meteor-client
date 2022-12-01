package meteor.plugins.autobankpin

import eventbus.events.GameTick
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo.BANK_PIN_INSTRUCTION_TEXT
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import java.sql.Time
import java.time.Instant
import java.util.concurrent.TimeUnit
import javax.management.timer.Timer
import kotlin.time.Duration.Companion.seconds

@PluginDescriptor(name = "Auto Bank Pin", description = "Automatically enters your bank pin", enabledByDefault = false)
class AutoBankPinPlugin : Plugin() {

    val config = configuration<AutoBankPinConfig>()

    private var first = false
    private var second = false
    private var third = false
    private var fourth = false

    override fun onStart() {
        ConfigManager.setConfiguration("bank", "bankPinKeyboard", true)
    }

    private fun EnterBankPin() {
        if (client.getWidget(WidgetID.BANK_PIN_GROUP_ID, BANK_PIN_INSTRUCTION_TEXT.childId) == null
            || (client.getWidget(BANK_PIN_INSTRUCTION_TEXT)!!.text != "First click the FIRST digit."
                    && client.getWidget(BANK_PIN_INSTRUCTION_TEXT)!!.text != "Now click the SECOND digit."
                    && client.getWidget(BANK_PIN_INSTRUCTION_TEXT)!!.text != "Time for the THIRD digit."
                    && client.getWidget(BANK_PIN_INSTRUCTION_TEXT)!!.text != "Finally, the FOURTH digit.")
        ) {
            return
        }

        if (config.bankpin().length != 4) {
            return
        }

        val number: String = config.bankpin()

        val digits = number.toCharArray()
        var charCode = -1

        when (client.getWidget(BANK_PIN_INSTRUCTION_TEXT)!!.text) {
            "First click the FIRST digit." -> {
                if (first) {
                    return
                }
                charCode = getExtendedKeyCodeForChar(digits[0].code)
                first = true
            }
            "Now click the SECOND digit." -> {
                if (second) {
                    return
                }
                charCode = getExtendedKeyCodeForChar(digits[1].code)
                second = true
            }
            "Time for the THIRD digit." -> {
                if (third) {
                    return
                }
                charCode = getExtendedKeyCodeForChar(digits[2].code)
                third = true
            }
            "Finally, the FOURTH digit." -> {
                if (!first && !fourth) {
                    return
                }
                charCode = getExtendedKeyCodeForChar(digits[3].code)
                fourth = true
            }
        }

        if (charCode != -1) {
            sendKey(charCode)

            if (fourth) {
                first = false
                second = false
                third = false
                fourth = false
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        EnterBankPin()

    }

    private fun sendKey(char: Int) {
        val kvPressed = KeyEvent(client.canvas, KEY_PRESSED, System.currentTimeMillis(), 0, char, CHAR_UNDEFINED)
        val kvTyped = KeyEvent(client.canvas, KEY_TYPED, System.currentTimeMillis(), 0, VK_UNDEFINED, char.toChar())
        val kvReleased = KeyEvent(client.canvas, KEY_RELEASED, System.currentTimeMillis(), 0, char, CHAR_UNDEFINED)

        client.canvas.dispatchEvent(kvPressed)
        client.canvas.dispatchEvent(kvTyped)
        client.canvas.dispatchEvent(kvReleased)
    }


}