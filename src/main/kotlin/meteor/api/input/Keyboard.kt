package meteor.api.input

import Main.client
import meteor.api.commons.Time
import java.awt.Canvas
import java.awt.event.KeyEvent

object Keyboard {
    @JvmOverloads
    fun pressed(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas: Canvas = client.canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    @JvmOverloads
    fun typed(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas: Canvas = client.canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_UNKNOWN)
        canvas.dispatchEvent(event)
    }

    @JvmOverloads
    fun released(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas: Canvas = client.canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_RELEASED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    fun type(c: Char) {
        val canvas: Canvas = client.canvas
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

    fun type(number: Int) {
        type(number.toString())
    }

    @JvmOverloads
    fun type(text: String, sendEnter: Boolean = false) {
        val chars = text.toCharArray()
        for (c in chars) {
            type(c)
        }
        if (sendEnter) {
            sendEnter()
        }
    }

    fun sendEnter() {
        type(KeyEvent.VK_ENTER.toChar())
    }

    fun sendSpace() {
        type(KeyEvent.VK_SPACE.toChar())
    }
}