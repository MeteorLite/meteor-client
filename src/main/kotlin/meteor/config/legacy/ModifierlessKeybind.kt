package meteor.config.legacy


import java.awt.event.KeyEvent


class ModifierlessKeybind(keyCode: Int, modifiers: Int) : Keybind(keyCode, modifiers, true) {
    /**
     * Constructs a keybind with that matches the passed KeyEvent
     */
    constructor(e: KeyEvent) : this(e.extendedKeyCode, e.modifiersEx) {
        assert(matches(e))
    }

    /**
     * If the KeyEvent is from a KeyPressed event this returns if the Event is this hotkey being
     * pressed. If the KeyEvent is a KeyReleased event this returns if the event is this hotkey being
     * released
     */
    override fun matches(e: KeyEvent): Boolean {
        return matches(e, true)
    }
}