/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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

import meteor.FontManager
import meteor.ui.DimmableJPanel
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.GridLayout
import javax.swing.JLabel
import javax.swing.SwingConstants
import javax.swing.border.EmptyBorder

/**
 * A progress bar to be displayed underneath the GE offer item panels
 */
class ProgressBar : DimmableJPanel() {
    private var maximumValue = 0
    private var value = 0
    private var positions = emptyList<Int>()
    private val leftLabel: JLabel = JShadowedLabel()
    private val rightLabel: JLabel = JShadowedLabel()
    private val centerLabel: JLabel = JShadowedLabel()
    private var centerLabelText = ""
    private var dimmedText = ""
    override fun paint(g: Graphics) {
        val percentage = percentage
        val topWidth = (size.width * (percentage / 100f)).toInt()
        super.paint(g)
        g.color = foreground
        g.fillRect(0, 0, topWidth, 16)
        for (position in positions) {
            val xCord = size.width * position / maximumValue
            if (xCord > topWidth) {
                g.fillRect(xCord, 0, 1, 16)
            }
        }
        super.paintComponents(g)
    }

    override var dimmed: Boolean
        get() = super.dimmed
        set(dimmed) {
            super.dimmed = dimmed
            if (dimmed) {
                leftLabel.setForeground(Color.GRAY)
                rightLabel.setForeground(Color.GRAY)
                centerLabel.setText(dimmedText)
            } else {
                leftLabel.setForeground(Color.WHITE)
                rightLabel.setForeground(Color.WHITE)
                centerLabel.setText(centerLabelText)
            }
        }

    fun setLeftLabel(txt: String?) {
        leftLabel.setText(txt)
    }

    fun setRightLabel(txt: String?) {
        rightLabel.setText(txt)
    }

    fun setCenterLabel(txt: String) {
        centerLabelText = txt
        centerLabel.setText(if (super.dimmed) dimmedText else txt)
    }

    fun setDimmedText(txt: String) {
        dimmedText = txt
        centerLabel.setText(if (super.dimmed) txt else centerLabelText)
    }

    val percentage: Int
        get() = if (value == 0) {
            0
        } else value * 100 / maximumValue

    fun setMaximumValue(maximumValue: Int) {
        this.maximumValue = maximumValue
        repaint()
    }

    fun setValue(value: Int) {
        this.value = value
        repaint()
    }

    fun setPositions(positions: List<Int>) {
        this.positions = positions
        repaint()
    }

    init {
        layout = GridLayout(1, 3)
        // The background color should be overridden
        background = Color.GREEN.darker()
        foreground = Color.GREEN.brighter()
        preferredSize = Dimension(100, 16)
        leftLabel.setFont(FontManager.runescapeSmallFont)
        leftLabel.setForeground(Color.WHITE)
        leftLabel.setBorder(EmptyBorder(2, 5, 0, 0))
        rightLabel.setFont(FontManager.runescapeSmallFont)
        rightLabel.setForeground(Color.WHITE)
        rightLabel.setHorizontalAlignment(SwingConstants.RIGHT)
        rightLabel.setBorder(EmptyBorder(2, 0, 0, 5))
        centerLabel.setFont(FontManager.runescapeSmallFont)
        centerLabel.setForeground(Color.WHITE)
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER)
        centerLabel.setBorder(EmptyBorder(2, 0, 0, 0))

        // Adds components to be automatically redrawn when paintComponents is called
        add(leftLabel)
        add(centerLabel)
        add(rightLabel)
    }
}