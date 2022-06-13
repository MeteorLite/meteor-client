/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package meteor.ui.overlay.tooltips

import com.google.common.annotations.VisibleForTesting
import meteor.ui.components.ComponentConstants
import meteor.ui.components.LayoutableRenderableEntity
import meteor.ui.components.TextComponent
import meteor.ui.overlay.BackgroundComponent
import net.runelite.api.IndexedSprite
import java.awt.*
import java.util.regex.Pattern

class TooltipComponent : LayoutableRenderableEntity {
    var text: String? = null
    var backgroundColor = Color(70, 61, 50, 156)
    var modIcons: Array<IndexedSprite>? = null

    private var preferredLocationp: Point? = Point()
    private var preferredSizep: Dimension? = Dimension(ComponentConstants.STANDARD_WIDTH, 16)
    private var bounds: Rectangle? = Rectangle()

    override fun getBounds(): Rectangle? {
        return bounds
    }

    override fun getPreferredLocation(): Point? {
        return preferredLocationp
    }

    override fun getPreferredSize(): Dimension? {
        return this.preferredSizep
    }

    override fun setPreferredLocation(position: Point?) {
        preferredLocationp = position
    }

    override fun setPreferredSize(position: Dimension?) {
        this.preferredSizep = position
    }

    override fun setBounds(rectangle: Rectangle?) {
        bounds = rectangle
    }

    override fun render(graphics: Graphics2D): Dimension? {
        // Tooltip size
        val metrics = graphics.fontMetrics
        val textDescent = metrics.descent
        val textHeight = metrics.height
        var tooltipWidth = 0
        var tooltipHeight = 0
        val lines = BR.split(text)

        // Calculate tooltip size
        for (line in lines) {
            val textWidth = calculateTextWidth(metrics, line)
            if (textWidth > tooltipWidth) {
                tooltipWidth = textWidth
            }
            tooltipHeight += textHeight
        }

        // Tooltip position
        val x = getPreferredLocation()!!.x
        val y = getPreferredLocation()!!.y

        // Render tooltip - background
        val tooltipBackground = Rectangle(
            x, y,
            tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2
        )
        val backgroundComponent = BackgroundComponent()
        backgroundComponent.backgroundColor = backgroundColor
        backgroundComponent.rectangle = tooltipBackground
        backgroundComponent.render(graphics)
        graphics.color = Color.WHITE

        // Render tooltip - text - line by line
        val textX = x + OFFSET
        val textY = y + OFFSET
        var lineX: Int
        var nextColor = Color.WHITE
        for (i in lines.indices) {
            lineX = textX
            val line = lines[i]
            val chars = line.toCharArray()
            var begin = 0
            var inTag = false
            for (j in chars.indices) {
                if (chars[j] == '<') {
                    val textComponent = TextComponent()
                    textComponent.color = nextColor
                    val text = line.substring(begin, j)
                    textComponent.text = text
                    textComponent.position = Point(lineX, textY + (i + 1) * textHeight - textDescent)
                    textComponent.render(graphics)
                    lineX += metrics.stringWidth(text)
                    begin = j
                    inTag = true
                } else if (chars[j] == '>' && inTag) {
                    val subLine = line.substring(begin + 1, j)
                    if (subLine.startsWith("col=")) {
                        val argument = subLine.substring(4)
                        nextColor = Color.decode("#$argument")
                    } else if (subLine == "/col") {
                        nextColor = Color.WHITE
                    } else if (subLine.startsWith("img=")) {
                        if (modIcons != null) {
                            val argument = subLine.substring(4)
                            val iconId = argument.toInt()
                            val modIcon = modIcons!![iconId]
                            renderModIcon(graphics, lineX, textY + i * textHeight - textDescent, modIcon)
                            lineX += modIcon.width
                        }
                    } else {
                        val textComponent = TextComponent()
                        textComponent.color = nextColor
                        val text = line.substring(begin, j + 1)
                        textComponent.text = text
                        textComponent.position = Point(lineX, textY + (i + 1) * textHeight - textDescent)
                        textComponent.render(graphics)
                        lineX += metrics.stringWidth(text)
                    }
                    begin = j + 1
                    inTag = false
                }
            }

            // Draw trailing text (after last tag)
            val textComponent = TextComponent()
            textComponent.color = nextColor
            textComponent.text = line.substring(begin)
            textComponent.position = Point(lineX, textY + (i + 1) * textHeight - textDescent)
            textComponent.render(graphics)
        }
        return Dimension(tooltipWidth + OFFSET * 2, tooltipHeight + OFFSET * 2)
    }

    private fun renderModIcon(graphics: Graphics2D, x: Int, y: Int, modIcon: IndexedSprite) {
        var sourceOffset = 0
        for (y2 in 0 until modIcon.height) {
            for (x2 in 0 until modIcon.width) {
                val index: Int = modIcon.pixels[sourceOffset++].toInt() and 0xff
                if (index != 0) {
                    graphics.color = Color(modIcon.palette[index])
                    graphics.drawLine(x + x2, y + y2, x + x2, y + y2)
                }
            }
        }
    }

    companion object {
        private val BR = Pattern.compile("</br>")
        private const val OFFSET = 4
        private const val MOD_ICON_WIDTH = 13 // they are generally 13px wide

        @VisibleForTesting
        fun calculateTextWidth(metrics: FontMetrics, line: String): Int {
            val chars = line.toCharArray()
            var textWidth = 0
            var begin = 0
            var inTag = false
            for (j in chars.indices) {
                if (chars[j] == '<') {
                    textWidth += metrics.stringWidth(line.substring(begin, j))
                    begin = j
                    inTag = true
                } else if (chars[j] == '>' && inTag) {
                    val subLine = line.substring(begin + 1, j)
                    if (subLine.startsWith("img=")) {
                        textWidth += MOD_ICON_WIDTH
                    } else if (!subLine.startsWith("col=") && !subLine.startsWith("/col")) {
                        textWidth += metrics.stringWidth(line.substring(begin, j + 1))
                    }
                    begin = j + 1
                    inTag = false
                }
            }

            // Include trailing text (after last tag)
            textWidth += metrics.stringWidth(line.substring(begin))
            return textWidth
        }
    }
}