package meteor.plugins.scriptcreator.script.api

import dev.hoot.api.commons.Time
import meteor.Main.client
import java.awt.event.KeyEvent

object Key {

    private val canvas = client.canvas

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
     * Simulates a key press, type, and release events for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     * @param eventType the type of event to simulate
     */
    private fun simulateEvent(keyCode: Int, keyChar: Char, eventType: Int) {
        val time = System.currentTimeMillis()
        val event = KeyEvent(canvas, eventType, time, 0, keyCode, keyChar, KeyEvent.KEY_LOCATION_STANDARD)
        canvas.dispatchEvent(event)
    }

    /**
     * Simulates a key press event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun press(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        simulateEvent(keyCode, keyChar, KeyEvent.KEY_PRESSED)
    }

    /**
     * Simulates a key typed event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun typed(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        simulateEvent(keyCode, keyChar, KeyEvent.KEY_TYPED)
    }

    /**
     * Simulates a key release event for the given key code and character.
     *
     * @param keyCode the key code for the event
     * @param keyChar the character for the event
     */
    fun release(keyCode: Int, keyChar: Char = KeyEvent.CHAR_UNDEFINED) {
        simulateEvent(keyCode, keyChar, KeyEvent.KEY_RELEASED)
    }

    /**
     * Types the given character by simulating key press, type, and release events.
     *
     * @param c the character to type
     */
    infix fun type(c: Char) {
        val keyCode = KeyEvent.getExtendedKeyCodeForChar(c.code)
        press(keyCode, c)
        typed(keyCode, c)
        Time.sleep(10)
        release(keyCode, c)
    }
    /**
     * Simulates pressing the Enter key.
     */
    fun sendEnter() {
        type(KeyEvent.VK_ENTER.toChar())
    }

    /**
     * Simulates pressing the Space key.
     */
    fun sendSpace() {
        type(KeyEvent.VK_SPACE.toChar())
    }
}