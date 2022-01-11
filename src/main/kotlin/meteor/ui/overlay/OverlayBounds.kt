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
package meteor.ui.overlay

import java.awt.Rectangle
import java.util.*

internal class OverlayBounds(private var topLeft: Rectangle? = null, private var topCenter: Rectangle? = null,
                             private var topRight: Rectangle? = null, private var bottomLeft: Rectangle? = null,
                             private var bottomRight: Rectangle? = null, private var aboveChatboxRight: Rectangle? = null,
                             private var canvasTopRight: Rectangle? = null, other: OverlayBounds? = null) {





    init {
        if (other != null) {
            topLeft = Rectangle(other.topLeft)
            topCenter = Rectangle(other.topCenter)
            topRight = Rectangle(other.topRight)
            bottomLeft = Rectangle(other.bottomLeft)
            bottomRight = Rectangle(other.bottomRight)
            aboveChatboxRight = Rectangle(other.aboveChatboxRight)
            canvasTopRight = Rectangle(other.canvasTopRight)
        }
    }

    fun translated(x: Int, y: Int): OverlayBounds {
        val translated = OverlayBounds(other = this)
        translated.topRight!!.translate(x, 0)
        translated.topCenter!!.translate(x / 2, 0)
        translated.bottomLeft!!.translate(0, y)
        translated.bottomRight!!.translate(x, y)
        translated.aboveChatboxRight!!.translate(x, y)
        translated.canvasTopRight!!.translate(x, 0)
        return translated
    }

    fun forPosition(overlayPosition: OverlayPosition?): Rectangle {
        return when (overlayPosition) {
            OverlayPosition.TOP_LEFT -> topLeft!!
            OverlayPosition.TOP_CENTER -> topCenter!!
            OverlayPosition.TOP_RIGHT -> topRight!!
            OverlayPosition.BOTTOM_LEFT -> bottomLeft!!
            OverlayPosition.BOTTOM_RIGHT -> bottomRight!!
            OverlayPosition.ABOVE_CHATBOX_RIGHT -> aboveChatboxRight!!
            OverlayPosition.CANVAS_TOP_RIGHT -> canvasTopRight!!
            else -> throw IllegalArgumentException()
        }
    }

    fun fromBounds(bounds: Rectangle): OverlayPosition {
        return if (bounds === topLeft) {
            OverlayPosition.TOP_LEFT
        } else if (bounds === topCenter) {
            OverlayPosition.TOP_CENTER
        } else if (bounds === topRight) {
            OverlayPosition.TOP_RIGHT
        } else if (bounds === bottomLeft) {
            OverlayPosition.BOTTOM_LEFT
        } else if (bounds === bottomRight) {
            OverlayPosition.BOTTOM_RIGHT
        } else if (bounds === aboveChatboxRight) {
            OverlayPosition.ABOVE_CHATBOX_RIGHT
        } else if (bounds === canvasTopRight) {
            OverlayPosition.CANVAS_TOP_RIGHT
        } else {
            throw IllegalArgumentException()
        }
    }

    val bounds = listOf(topLeft!!, topCenter, topRight, bottomLeft, bottomRight, aboveChatboxRight,
        canvasTopRight)
}