/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package meteor.plugins.grounditems

import meteor.input.KeyListener
import meteor.input.MouseAdapter
import java.awt.Point
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.time.Duration
import java.time.Instant
import javax.swing.SwingUtilities

class GroundItemInputListener(var plugin: GroundItemsPlugin, var config: GroundItemsConfig) : MouseAdapter(), KeyListener {
    private var lastPress: Instant? = null

    override fun keyTyped(e: KeyEvent) {}
    override fun keyPressed(e: KeyEvent) {
        if (e.keyCode == HOTKEY) {
            if (plugin.hideAll) {
                plugin.hideAll = false
                plugin.hotKeyPressed = true
                lastPress = null
            } else if (lastPress != null && !plugin.hotKeyPressed && config!!.doubleTapDelay() > 0 && Duration.between(
                    lastPress,
                    Instant.now()
                ).compareTo(
                    Duration.ofMillis(
                        config.doubleTapDelay().toLong()
                    )
                ) < 0
            ) {
                plugin.hideAll = true
                lastPress = null
            } else {
                plugin.hotKeyPressed = true
                lastPress = Instant.now()
            }
        }
    }

    override fun keyReleased(e: KeyEvent) {
        if (e.keyCode == HOTKEY) {
            plugin!!.hotKeyPressed = false
            plugin.textBoxBounds = null
            plugin.hiddenBoxBounds = null
            plugin.highlightBoxBounds = null
        }
    }

    override fun mousePressed(e: MouseEvent): MouseEvent {
        val mousePos = Point(e.x - 5, e.y)
        if (plugin!!.hotKeyPressed) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                // Process both click boxes for hidden and highlighted items
                if (plugin.hiddenBoxBounds != null && plugin.hiddenBoxBounds!!.key.contains(mousePos)) {
                    println(plugin.hiddenBoxBounds!!.value.name!!)
                    plugin.updateList(plugin.hiddenBoxBounds!!.value.name!!, true)
                    e.consume()
                    return e
                }
                if (plugin.highlightBoxBounds != null && plugin.highlightBoxBounds!!.key.contains(mousePos)) {
                    plugin.updateList(plugin.highlightBoxBounds!!.value.name!!, false)
                    e.consume()
                    return e
                }

                // There is one name click box for left click and one for right click
                if (plugin.textBoxBounds != null && plugin.textBoxBounds!!.key.contains(mousePos)) {
                    plugin.updateList(plugin.textBoxBounds!!.value.name!!, false)
                    e.consume()
                    return e
                }
            } else if (SwingUtilities.isRightMouseButton(e)) {
                if (plugin.textBoxBounds != null && plugin.textBoxBounds!!.key.contains(mousePos)) {
                    plugin.updateList(plugin.textBoxBounds!!.value.name!!, true)
                    e.consume()
                    return e
                }
            }
        }
        return e
    }

    companion object {
        private const val HOTKEY = KeyEvent.VK_ALT
    }
}