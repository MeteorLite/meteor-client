/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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

import meteor.ui.components.ComponentConstants
import meteor.ui.components.RenderableEntity
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle


class BackgroundComponent : RenderableEntity {
    var backgroundColor: Color = ComponentConstants.STANDARD_BACKGROUND_COLOR
    var rectangle = Rectangle()
    private val fill = true
    override fun render(graphics: Graphics2D): Dimension {
        val outsideStrokeColor = Color((backgroundColor.red * OUTER_COLOR_OFFSET).toInt(),
                (backgroundColor.green * OUTER_COLOR_OFFSET).toInt(), (backgroundColor.blue * OUTER_COLOR_OFFSET).toInt(),
                    255.coerceAtMost((backgroundColor.alpha * ALPHA_COLOR_OFFSET).toInt())
        )
        val insideStrokeColor = Color(
                255.coerceAtMost((backgroundColor.red * INNER_COLOR_OFFSET).toInt()),
                255.coerceAtMost((backgroundColor.green * INNER_COLOR_OFFSET).toInt()),
                255.coerceAtMost((backgroundColor.blue * INNER_COLOR_OFFSET).toInt()),
                255.coerceAtMost((backgroundColor.alpha * ALPHA_COLOR_OFFSET).toInt())
        )

        // Render background
        if (fill) {
            graphics.color = backgroundColor
            graphics.fill(rectangle)
        }

        // Render outside stroke
        val outsideStroke = Rectangle()
        outsideStroke.setLocation(rectangle.x, rectangle.y)
        outsideStroke
                .setSize(rectangle.width - BORDER_OFFSET / 2, rectangle.height - BORDER_OFFSET / 2)
        graphics.color = outsideStrokeColor
        graphics.draw(outsideStroke)

        // Render inside stroke
        val insideStroke = Rectangle()
        insideStroke.setLocation(rectangle.x + BORDER_OFFSET / 2, rectangle.y + BORDER_OFFSET / 2)
        insideStroke.setSize(rectangle.width - BORDER_OFFSET - BORDER_OFFSET / 2,
                rectangle.height - BORDER_OFFSET - BORDER_OFFSET / 2)
        graphics.color = insideStrokeColor
        graphics.draw(insideStroke)
        return Dimension(rectangle.size)
    }

    companion object {
        private const val BORDER_OFFSET = 2
        private const val COLOR_OFFSET = 0.2f
        private const val OUTER_COLOR_OFFSET = 1 - COLOR_OFFSET
        private const val INNER_COLOR_OFFSET = 1 + COLOR_OFFSET
        private const val ALPHA_COLOR_OFFSET = 1 + 2 * COLOR_OFFSET
    }
}