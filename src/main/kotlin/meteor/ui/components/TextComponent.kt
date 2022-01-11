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
package meteor.ui.components

import meteor.util.ColorUtil.colorWithAlpha
import net.runelite.api.util.Text
import java.awt.*
import java.util.regex.Pattern

class TextComponent : RenderableEntity {
    var text: String? = null
    var position = Point()
    var color = Color.WHITE
    var outline = false

    /**
     * The text font.
     */
    var font: Font? = null
    override fun render(graphics: Graphics2D): Dimension? {
        var originalFont: Font? = null
        if (font != null) {
            originalFont = graphics.font
            graphics.font = font
        }
        val fontMetrics = graphics.fontMetrics
        if (COL_TAG_PATTERN_W_LOOKAHEAD.matcher(text).find()) {
            val parts = COL_TAG_PATTERN_W_LOOKAHEAD.split(text)
            var x = position.x
            for (textSplitOnCol in parts) {
                val textWithoutCol = Text.removeTags(textSplitOnCol)
                val colColor = textSplitOnCol.substring(textSplitOnCol.indexOf("=") + 1, textSplitOnCol.indexOf(">"))
                graphics.color = Color.BLACK
                if (outline) {
                    graphics.drawString(textWithoutCol, x, position.y + 1)
                    graphics.drawString(textWithoutCol, x, position.y - 1)
                    graphics.drawString(textWithoutCol, x + 1, position.y)
                    graphics.drawString(textWithoutCol, x - 1, position.y)
                } else {
                    // shadow
                    graphics.drawString(textWithoutCol, x + 1, position.y + 1)
                }

                // actual text
                graphics.color = Color.decode("#$colColor")
                graphics.drawString(textWithoutCol, x, position.y)
                x += fontMetrics.stringWidth(textWithoutCol)
            }
        } else {
            graphics.color = Color.BLACK
            if (outline) {
                graphics.drawString(text, position.x, position.y + 1)
                graphics.drawString(text, position.x, position.y - 1)
                graphics.drawString(text, position.x + 1, position.y)
                graphics.drawString(text, position.x - 1, position.y)
            } else {
                // shadow
                graphics.drawString(text, position.x + 1, position.y + 1)
            }

            // actual text
            graphics.color = colorWithAlpha(color, 0xFF)
            graphics.drawString(text, position.x, position.y)
        }
        val width = fontMetrics.stringWidth(text)
        val height = fontMetrics.height
        if (originalFont != null) {
            graphics.font = originalFont
        }
        return Dimension(width, height)
    }

    companion object {
        private const val COL_TAG_REGEX = "(<col=([0-9a-fA-F]){2,6}>)"
        private val COL_TAG_PATTERN_W_LOOKAHEAD = Pattern.compile("(?=" + COL_TAG_REGEX + ")")
    }
}