/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.ui

import meteor.input.MouseWheelListener
import java.awt.Component
import java.awt.event.MouseWheelEvent

object TranslateMouseWheelListener : MouseWheelListener {
    val client = Main.client
    override fun mouseWheelMoved(event: MouseWheelEvent): MouseWheelEvent {
        return translateEvent(event)
    }

    private fun translateEvent(e: MouseWheelEvent): MouseWheelEvent {
        val stretchedDimensions = client.stretchedDimensions
        val realDimensions = client.realDimensions
        val newX = (e.x / (stretchedDimensions.width / realDimensions.getWidth())).toInt()
        val newY = (e.y / (stretchedDimensions.height / realDimensions.getHeight())).toInt()
        return MouseWheelEvent(e.source as Component, e.id, e.getWhen(), e.modifiers,
                newX, newY,
                e.clickCount, e.isPopupTrigger, e.scrollType, e.scrollAmount,
                e.wheelRotation)
    }
}