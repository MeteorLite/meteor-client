/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.base.MoreObjects
import com.google.common.base.Strings
import net.runelite.api.util.Text
import java.awt.*

class LineComponent : LayoutableRenderableEntity {
    private var preferredLocationp: Point? = Point()
    private var preferredSizep: Dimension? = Dimension(ComponentConstants.STANDARD_WIDTH, 0)
    private var bounds: Rectangle? = Rectangle()

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

    private var left: String? = null
    private var right: String? = null

    private var leftColor = Color.WHITE
    private var rightColor = Color.WHITE
    private val leftFont: Font? = null
    private var rightFont: Font? = null

    override fun render(graphics: Graphics2D): Dimension? {
        // Prevent NPEs
        val left = MoreObjects.firstNonNull(left, "")
        val right = MoreObjects.firstNonNull(right, "")
        val leftFont = MoreObjects.firstNonNull(leftFont, graphics.font)
        val rightFont = MoreObjects.firstNonNull(rightFont, graphics.font)
        val lfm: FontMetrics = graphics.getFontMetrics(leftFont)
        val rfm: FontMetrics = graphics
            .getFontMetrics(rightFont)
        val fmHeight = Math.max(lfm.height, rfm.height)
        val baseX = getPreferredLocation()!!.x
        val baseY = getPreferredLocation()!!.y + fmHeight
        var y = baseY
        val leftFullWidth = getLineWidth(left, lfm)
        val rightFullWidth = getLineWidth(right, rfm)
        val textComponent = TextComponent()
        if (getPreferredSize()!!.width < leftFullWidth + rightFullWidth) {
            var leftSmallWidth = getPreferredSize()!!.width
            var rightSmallWidth = 0
            if (!Strings.isNullOrEmpty(right)) {
                rightSmallWidth = getPreferredSize()!!.width / 3
                leftSmallWidth -= rightSmallWidth
            }
            val leftSplitLines = lineBreakText(left, leftSmallWidth, lfm)
            val rightSplitLines = lineBreakText(right, rightSmallWidth, rfm)
            val lineCount = Math.max(leftSplitLines.size, rightSplitLines.size)
            for (i in 0 until lineCount) {
                if (i < leftSplitLines.size) {
                    val leftText = leftSplitLines[i]
                    textComponent.position = Point(baseX, y)
                    textComponent.text = leftText
                    textComponent.color = leftColor
                    textComponent.font = (leftFont)
                    textComponent.render(graphics)
                }
                if (i < rightSplitLines.size) {
                    val rightText = rightSplitLines[i]
                    textComponent
                        .position = Point(
                        baseX + getPreferredSize()!!.width - getLineWidth(
                            rightText,
                            rfm
                        ), y
                    )
                    textComponent.text = rightText
                    textComponent.color = rightColor
                    textComponent.font = (rightFont)
                    textComponent.render(graphics)
                }
                y += fmHeight
            }
            val dimension = Dimension(getPreferredSize()!!.width, y - baseY)
            bounds!!.location = getPreferredLocation()!!
            bounds!!.size = dimension
            return dimension
        }
        if (!left.isEmpty()) {
            textComponent.position = Point(baseX, y)
            textComponent.text = left
            textComponent.color = leftColor
            textComponent.font = (leftFont)
            textComponent.render(graphics)
        }
        if (!right.isEmpty()) {
            textComponent.position = Point(baseX + getPreferredSize()!!.width - rightFullWidth, y)
            textComponent.text = right
            textComponent.color = rightColor
            textComponent.font = (rightFont)
            textComponent.render(graphics)
        }
        y += fmHeight
        val dimension = Dimension(getPreferredSize()!!.width, y - baseY)
        bounds!!.location = getPreferredLocation()!!
        bounds!!.size = dimension
        return dimension
    }

    class Builder {
        val lineComponent = LineComponent()
        fun left(s: String): Builder {
            lineComponent.left = s
            return this
        }

        fun leftColor(c: Color): Builder {
            lineComponent.leftColor = c
            return this
        }

        fun right(s: String): Builder {
            lineComponent.right = s
            return this
        }

        fun rightColor(c: Color): Builder {
            lineComponent.rightColor = c
            return this
        }

        fun rightFont(f: Font): Builder {
            lineComponent.rightFont = f
            return this
        }

        fun build(): LineComponent {
            return lineComponent
        }
    }

    companion object {
        private fun getLineWidth(line: String?, metrics: FontMetrics): Int {
            return metrics.stringWidth(Text.removeTags(line))
        }

        private fun lineBreakText(text: String, maxWidth: Int, metrics: FontMetrics): Array<String?> {
            val words = text.split(" ").toTypedArray()
            if (words.size == 0) {
                return arrayOfNulls(0)
            }
            val wrapped = StringBuilder(words[0])
            var spaceLeft = maxWidth - metrics.stringWidth(wrapped.toString())
            for (i in 1 until words.size) {
                val word = words[i]
                val wordLen = metrics.stringWidth(word)
                val spaceWidth = metrics.stringWidth(" ")
                if (wordLen + spaceWidth > spaceLeft) {
                    wrapped.append("\n").append(word)
                    spaceLeft = maxWidth - wordLen
                } else {
                    wrapped.append(" ").append(word)
                    spaceLeft -= spaceWidth + wordLen
                }
            }
            return wrapped.toString().split("\n").toTypedArray()
        }


    }
}