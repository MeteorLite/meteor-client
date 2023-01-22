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

import meteor.Configuration
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.util.concurrent.CopyOnWriteArrayList

object MouseManager {
    private const val MOUSE_BUTTON_4 = 4
    private val mouseListeners: MutableList<MouseListener> = CopyOnWriteArrayList()
    private val mouseWheelListeners: MutableList<MouseWheelListener> = CopyOnWriteArrayList()
    fun registerMouseListener(mouseListener: MouseListener) {
        if (!mouseListeners.contains(mouseListener)) {
            mouseListeners.add(mouseListener)
        }
    }

    fun registerMouseListener(position: Int, mouseListener: MouseListener) {
        mouseListeners.add(position, mouseListener)
    }

    fun unregisterMouseListener(mouseListener: MouseListener) {
        mouseListeners.remove(mouseListener)
    }

    fun registerMouseWheelListener(mouseWheelListener: MouseWheelListener) {
        if (!mouseWheelListeners.contains(mouseWheelListener)) {
            mouseWheelListeners.add(mouseWheelListener)
        }
    }

    fun registerMouseWheelListener(position: Int, mouseWheelListener: MouseWheelListener) {
        mouseWheelListeners.add(position, mouseWheelListener)
    }

    fun unregisterMouseWheelListener(mouseWheelListener: MouseWheelListener) {
        mouseWheelListeners.remove(mouseWheelListener)
    }

    private fun checkExtraMouseButtons(mouseEvent: MouseEvent) {
        // Prevent extra mouse buttons from being passed into the client,
        // as it treats them all as left click
        val button = mouseEvent.button
        if (button >= MOUSE_BUTTON_4 && Configuration.BLOCK_MOUSE_4_PLUS) {
            mouseEvent.consume()
        }
    }

    fun processMousePressed(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        checkExtraMouseButtons(mouseEvent)
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mousePressed(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseReleased(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        checkExtraMouseButtons(mouseEvent)
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseReleased(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseClicked(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        checkExtraMouseButtons(mouseEvent)
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseClicked(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseEntered(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseEntered(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseExited(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseExited(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseDragged(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseDragged(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseMoved(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (mouseEvent.isConsumed) {
            return mouseEvent
        }
        for (mouseListener in mouseListeners) {
            mouseEvent = mouseListener.mouseMoved(mouseEvent)
            if (mouseEvent.isConsumed) {
                break
            }
        }
        return mouseEvent
    }

    fun processMouseWheelMoved(mouseWheelEvent: MouseWheelEvent): MouseWheelEvent {
        var mouseWheelEvent: MouseWheelEvent = mouseWheelEvent
        if (mouseWheelEvent.isConsumed) {
            return mouseWheelEvent
        }
        for (mouseWheelListener in mouseWheelListeners) {
            mouseWheelEvent = mouseWheelListener.mouseWheelMoved(mouseWheelEvent)
            if (mouseWheelEvent.isConsumed) {
                break
            }
        }
        return mouseWheelEvent
    }
}