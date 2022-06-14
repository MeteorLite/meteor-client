package meteor.plugins.ctrlplayeroptions

import meteor.input.KeyListener
import java.awt.event.KeyEvent

object CtrlKeyListener : KeyListener {
    var ctrlPressed = false

    override fun keyTyped(e: KeyEvent) {}

    override fun keyPressed(e: KeyEvent) {
        ctrlPressed = e.isControlDown
    }

    override fun keyReleased(e: KeyEvent) {
        ctrlPressed = e.isControlDown
    }
}