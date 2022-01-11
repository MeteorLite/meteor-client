/*
 * Copyright (c) 2018, Cameron <moberg@tuta.io>
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

import com.google.common.base.Strings
import java.awt.*
import java.text.DecimalFormat

class ProgressBarComponent : LayoutableRenderableEntity {
    enum class LabelDisplayMode {
        PERCENTAGE, FULL, TEXT_ONLY, BOTH
    }

    private val minimum: Long = 0
    private val maximum: Long = 100
    var value = 0.0
    private val labelDisplayMode = LabelDisplayMode.PERCENTAGE
    private val centerLabel: String? = null
    var leftLabel: String? = null
    var rightLabel: String? = null
    var foregroundColor = Color(82, 161, 82)
    var backgroundColor = Color(255, 255, 255, 127)
    private val fontColor = Color.WHITE
    override var preferredLocation: Point?  = Point()
    override var preferredSize: Dimension? = Dimension(ComponentConstants.STANDARD_WIDTH, 16)
    override val bounds = Rectangle()
    override fun render(graphics: Graphics2D): Dimension {
        val metrics = graphics.fontMetrics
        val barX = preferredLocation!!.x
        val barY = preferredLocation!!.y
        val span = maximum - minimum
        val currentValue = value - minimum
        val pc = currentValue / span
        var textToWrite: String?
        textToWrite = when (labelDisplayMode) {
            LabelDisplayMode.TEXT_ONLY -> ""
            LabelDisplayMode.PERCENTAGE -> formatPercentageProgress(
                pc
            )
            LabelDisplayMode.BOTH -> formatFullProgress(
                currentValue,
                maximum
            ) + " (" + formatPercentageProgress(pc) + ")"
            LabelDisplayMode.FULL -> formatFullProgress(
                currentValue,
                maximum
            )
            else -> formatFullProgress(currentValue, maximum)
        }
        if (!Strings.isNullOrEmpty(centerLabel)) {
            if (!textToWrite.isEmpty()) {
                textToWrite += " "
            }
            textToWrite += centerLabel
        }
        val width = preferredSize!!.width
        val height = Math.max(preferredSize!!.height, 16)
        val progressTextX = barX + (width - metrics.stringWidth(textToWrite)) / 2
        val progressTextY = barY + (height - metrics.height) / 2 + metrics.height
        val progressFill = (width * Math.min(1.0, pc)).toInt()

        // Draw bar
        graphics.color = backgroundColor
        graphics.fillRect(barX + progressFill, barY, width - progressFill, height)
        graphics.color = foregroundColor
        graphics.fillRect(barX, barY, progressFill, height)
        val textComponent = TextComponent()
        textComponent.position = Point(progressTextX, progressTextY)
        textComponent.color = fontColor
        textComponent.text = textToWrite
        textComponent.render(graphics)
        if (leftLabel != null) {
            val leftTextComponent = TextComponent()
            leftTextComponent.position = Point(barX + SIDE_LABEL_OFFSET, progressTextY)
            leftTextComponent.color = fontColor
            leftTextComponent.text = leftLabel
            leftTextComponent.render(graphics)
        }
        if (rightLabel != null) {
            val leftTextComponent = TextComponent()
            leftTextComponent.position =
                Point(barX + width - metrics.stringWidth(rightLabel) - SIDE_LABEL_OFFSET, progressTextY)
            leftTextComponent.color = fontColor
            leftTextComponent.text = rightLabel
            leftTextComponent.render(graphics)
        }
        val dimension = Dimension(width, height)
        bounds.location = preferredLocation
        bounds.size = dimension
        return dimension
    }

    companion object {
        private val DECIMAL_FORMAT = DecimalFormat("0.0")
        private val DECIMAL_FORMAT_ABS = DecimalFormat("#0")
        private const val SIDE_LABEL_OFFSET = 4
        private fun formatFullProgress(current: Double, maximum: Long): String {
            return DECIMAL_FORMAT_ABS.format(Math.floor(current)) + "/" + maximum
        }

        private fun formatPercentageProgress(ratio: Double): String {
            return DECIMAL_FORMAT.format(ratio * 100.0) + "%"
        }
    }
}