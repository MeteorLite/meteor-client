package meteor.config.legacy


import com.google.common.collect.BiMap
import com.google.common.collect.ImmutableBiMap
import java.awt.event.InputEvent
import java.awt.event.KeyEvent


/**
 * A combination of zero or more modifier keys (Ctrl, alt, shift, meta) and an optional non-modifier
 * key
 */

open class Keybind @JvmOverloads constructor(keyCode: Int, modifiers: Int, ignoreModifiers: Boolean = false) {
    var keyCode = 0
    var modifiers = 0

    /**
     * Constructs a keybind with that matches the passed KeyEvent
     */
    constructor(e: KeyEvent) : this(e.extendedKeyCode, e.modifiersEx) {
        assert(this.matches(e))
    }

    /**
     * If the KeyEvent is from a KeyPressed event this returns if the Event is this hotkey being
     * pressed. If the KeyEvent is a KeyReleased event this returns if the event is this hotkey being
     * released
     */
    open fun matches(e: KeyEvent): Boolean {
        return matches(e, false)
    }

    protected fun matches(e: KeyEvent, ignoreModifiers: Boolean): Boolean {
        if (NOT_SET == this) {
            return false
        }
        var keyCode = e.extendedKeyCode
        var modifiers = e.modifiersEx and KEYBOARD_MODIFIER_MASK
        val mf = getModifierForKeyCode(keyCode)
        if (mf != null) {
            modifiers = modifiers or mf
            keyCode = KeyEvent.VK_UNDEFINED
        }
        if (e.id == KeyEvent.KEY_RELEASED && keyCode != KeyEvent.VK_UNDEFINED) {
            return this.keyCode == keyCode
        }
        return if (ignoreModifiers && keyCode != KeyEvent.VK_UNDEFINED) {
            this.keyCode == keyCode
        } else this.keyCode == keyCode && this.modifiers == modifiers
    }

    override fun toString(): String {
        if (keyCode == KeyEvent.VK_UNDEFINED && modifiers == 0) {
            return "Not set"
        }
        val key: String = if (keyCode == KeyEvent.VK_UNDEFINED) {
            ""
        } else {
            KeyEvent.getKeyText(keyCode)
        }
        var mod = ""
        if (modifiers != 0) {
            mod = InputEvent.getModifiersExText(modifiers)
        }
        if (mod.isEmpty() && key.isEmpty()) {
            return "Not set"
        }
        if (mod.isNotEmpty() && key.isNotEmpty()) {
            return "$mod+$key"
        }
        return mod.ifEmpty {
            key
        }
    }

    companion object {
        val NOT_SET = Keybind(KeyEvent.VK_UNDEFINED, 0)
        val CTRL = Keybind(KeyEvent.VK_UNDEFINED, InputEvent.CTRL_DOWN_MASK)
        val ALT = Keybind(KeyEvent.VK_UNDEFINED, InputEvent.ALT_DOWN_MASK)
        val SHIFT = Keybind(KeyEvent.VK_UNDEFINED,
                InputEvent.SHIFT_DOWN_MASK)
        private val MODIFIER_TO_KEY_CODE: BiMap<Int, Int>? = ImmutableBiMap.Builder<Int, Int>()
                .put(InputEvent.CTRL_DOWN_MASK, KeyEvent.VK_CONTROL)
                .put(InputEvent.ALT_DOWN_MASK, KeyEvent.VK_ALT)
                .put(InputEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT)
                .put(InputEvent.META_DOWN_MASK, KeyEvent.VK_META)
                .build()

        // Bitmask of all supported modifiers
        private val KEYBOARD_MODIFIER_MASK = MODIFIER_TO_KEY_CODE!!.keys.stream()
                .reduce { a: Int, b: Int -> a or b }.get()

        fun getModifierForKeyCode(keyCode: Int): Int? {
            return if (MODIFIER_TO_KEY_CODE != null) {
                MODIFIER_TO_KEY_CODE.inverse()[keyCode]
            } else {
                -1
            }
        }
    }

    init {
        var keyCode = keyCode
        var modifiers = modifiers
        try {
            modifiers = modifiers and KEYBOARD_MODIFIER_MASK

            // If the keybind is just modifiers we don't want the keyCode to contain the modifier too,
            // because this breaks if you do the keycode backwards
            val mf = getModifierForKeyCode(keyCode)
            if (mf != null) {
                keyCode = KeyEvent.VK_UNDEFINED
            }
            if (ignoreModifiers && keyCode != KeyEvent.VK_UNDEFINED) {
                modifiers = 0
            }
            this.keyCode = keyCode
            this.modifiers = modifiers
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}