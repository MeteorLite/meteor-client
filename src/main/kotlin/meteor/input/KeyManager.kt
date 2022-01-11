/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.input

import Main.client
import net.runelite.api.GameState
import meteor.Logger
import java.awt.event.KeyEvent
import java.util.concurrent.CopyOnWriteArrayList

object KeyManager {
    private val keyListeners: MutableList<KeyListener> = CopyOnWriteArrayList()
    var log = Logger.getLogger(KeyManager.javaClass)
    fun registerKeyListener(keyListener: KeyListener, source: Class<*>) {
        log.warn("Registering key listener for $source")
        if (!keyListeners.contains(keyListener)) {
            keyListeners.add(keyListener)
        }
    }

    fun unregisterKeyListener(keyListener: KeyListener) {
        val unregistered = keyListeners.remove(keyListener)
        if (unregistered) {
            log.warn("Unregistered key listener: $keyListener")
        }
    }

    fun processKeyPressed(keyEvent: KeyEvent) {
        if (keyEvent.isConsumed) {
            return
        }
        for (keyListener in keyListeners) {
            if (!shouldProcess(keyListener)) {
                continue
            }
            keyListener.keyPressed(keyEvent)
            if (keyEvent.isConsumed) {
                break
            }
        }
    }

    fun processKeyReleased(keyEvent: KeyEvent) {
        if (keyEvent.isConsumed) {
            return
        }
        for (keyListener in keyListeners) {
            if (!shouldProcess(keyListener)) {
                continue
            }
            keyListener.keyReleased(keyEvent)
            if (keyEvent.isConsumed) {
                break
            }
        }
    }

    fun processKeyTyped(keyEvent: KeyEvent) {
        if (keyEvent.isConsumed) {
            return
        }
        for (keyListener in keyListeners) {
            if (!shouldProcess(keyListener)) {
                continue
            }
            keyListener.keyTyped(keyEvent)
            if (keyEvent.isConsumed) {
                break
            }
        }
    }

    private fun shouldProcess(keyListener: KeyListener): Boolean {
        val gameState = client.gameState
        return if (gameState == GameState.LOGIN_SCREEN || gameState == GameState.LOGIN_SCREEN_AUTHENTICATOR) {
            keyListener.isEnabledOnLoginScreen
        } else true
    }
}