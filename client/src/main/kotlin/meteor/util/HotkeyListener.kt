/*
 * Copyright (c) 2018 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.util

import kotlinx.coroutines.runBlocking
import meteor.config.legacy.Keybind
import meteor.config.legacy.Keybind.Companion.getModifierForKeyCode
import meteor.input.KeyListener
import java.awt.event.KeyEvent

open class HotkeyListener(private val keybind: () -> Keybind) : KeyListener {
    private var isPressed = false
    private var isConsumingTyped = false

    override val isEnabledOnLoginScreen = false
    override fun keyTyped(e: KeyEvent) {
        if (isConsumingTyped) {
            e.consume()
        }
    }

    override fun keyPressed(e: KeyEvent) {
        if (keybind().matches(e)) {
            val wasPressed = isPressed
            isPressed = true
            if (!wasPressed) {

                hotkeyPressed()
            }
            if (getModifierForKeyCode(e.keyCode) == null) {
                isConsumingTyped = true
                // Only consume non modifier keys
                e.consume()
            }
        }
    }

    override fun keyReleased(e: KeyEvent) {
        runBlocking {
            if (keybind().matches(e)) {
                if (isPressed) {
                    hotkeyReleased()
                }
                isPressed = false
                isConsumingTyped = false
            }
        }

    }

    protected open fun hotkeyPressed() {


    }

    protected open fun hotkeyReleased() {}
}