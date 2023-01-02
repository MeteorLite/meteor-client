package meteor.plugins.scriptcreator.script.api

import dev.hoot.api.game.Game
import java.awt.event.KeyEvent

object Key {
    /**
     * Types the given number as a string by simulating key press events.
     *
     * @param number the number to type
     */
    infix fun type(number: Int) {
        type(number.toString())
    }

    /**
     * Types the given text by simulating key press events.
     *
     * @param text the text to type
     */
    infix fun type(text: String) {
        val chars = text.toCharArray()
        for (c in chars) {
            type(c)
        }
        sendEnter()
    }

    /**
     * Simulates a key press event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun press(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    /**
     * Simulates a key typed event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun typed(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_UNKNOWN)
        canvas.dispatchEvent(event)
    }

    /**
     * Simulates a key release event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun release(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, KeyEvent.KEY_RELEASED, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    /**
     * Types the given character by simulating key press, type, and release events.
     *
     * @param c the character to type
     */
    infix fun type(c: Char) {
        val canvas = Game.getClient().canvas
        val time = System.currentTimeMillis()
        val keyCode = KeyEvent.getExtendedKeyCodeForChar(c.code)
        val pressed = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, c, KeyEvent.KEY_LOCATION_STANDARD)
        val typed = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, 0, c, KeyEvent.KEY_LOCATION_UNKNOWN)

    }

    /**
     * Simulates pressing the Enter key by typing it.
     */
    fun sendEnter() {
        type(KeyEvent.VK_ENTER.toChar())
    }

    /**
     * Simulates pressing the Space key by typing it.
     */
    fun sendSpace() {
        type(KeyEvent.VK_SPACE.toChar())
    }
}