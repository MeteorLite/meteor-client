package meteor.plugins.scriptcreator.script.api

import dev.hoot.api.commons.Time
import dev.hoot.api.game.Game
import java.awt.event.KeyEvent

object Key {
    infix fun type(number: Int) {
        type(number.toString())
    }

    infix fun type(text: String) {
        val chars = text.toCharArray()
        for (c in chars) {
            type(c)
        }
            sendEnter()
    }
     fun press(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    fun typed(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_UNKNOWN)
        canvas.dispatchEvent(event)
    }

    fun release(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_RELEASED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    fun type(c: Char) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val keyCode = KeyEvent.getExtendedKeyCodeForChar(c.code)
        val pressed = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, c, KeyEvent.KEY_LOCATION_STANDARD)
        val typed = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, 0, c, KeyEvent.KEY_LOCATION_UNKNOWN)
        canvas.dispatchEvent(pressed)
        canvas.dispatchEvent(typed)
        Time.sleep(10)
        val released = KeyEvent(
            canvas,
            KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(),
            0,
            keyCode,
            c,
            KeyEvent.KEY_LOCATION_STANDARD
        )
        canvas.dispatchEvent(released)
    }



    fun sendEnter() {
        type(KeyEvent.VK_ENTER.toChar())
    }

    fun sendSpace() {
        type(KeyEvent.VK_SPACE.toChar())
    }
}