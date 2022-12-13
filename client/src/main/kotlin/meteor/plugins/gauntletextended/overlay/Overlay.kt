/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package meteor.plugins.gauntletextended.overlay

import meteor.ui.overlay.OverlayLayer
import meteor.plugins.Plugin
import meteor.ui.overlay.Overlay
import java.awt.*

abstract class Overlay protected constructor(plugin: Plugin?) : Overlay(OverlayLayer.ABOVE_SCENE) {
    abstract fun determineLayer()

    companion object {
        fun drawOutlineAndFill(
            graphics2D: Graphics2D,
            outlineColor: Color?,
            fillColor: Color?,
            strokeWidth: Float,
            shape: Shape?
        ) {
            val originalColor = graphics2D.color
            val originalStroke = graphics2D.stroke
            graphics2D.stroke = BasicStroke(strokeWidth)
            graphics2D.color = outlineColor
            graphics2D.draw(shape)
            graphics2D.color = fillColor
            graphics2D.fill(shape)
            graphics2D.color = originalColor
            graphics2D.stroke = originalStroke
        }
    }
}