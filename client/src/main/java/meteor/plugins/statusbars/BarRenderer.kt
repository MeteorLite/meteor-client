/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
 * Copyright (c) 2019, Rheon <https://github.com/Rheon-D>
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
package meteor.plugins.statusbars

import meteor.Main
import meteor.game.FontManager
import meteor.ui.overlay.components.TextComponent
import net.runelite.api.Skill
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Image
import java.awt.Point
import java.util.function.Supplier


internal class BarRenderer(var maxValueSupplier: Supplier<Int>? = null,
                           val currentValueSupplier: Supplier<Int>? = null,
                           val healSupplier: Supplier<Int>? = null,
                           val colorSupplier: Supplier<Color>? = null,
                           val healColorSupplier: Supplier<Color>? = null,
                           val iconSupplier: Supplier<Image>? = null,
                           val skillSupplier: Supplier<Skill>? = null,) {
    private var maxValue = 0
    private var currentValue = 0
    private fun refreshSkills() {
        maxValue = maxValueSupplier!!.get()
        currentValue = currentValueSupplier!!.get()
    }

    /**
     * Renders a status bar along with its restoration bar(s), icons and counters as appropriate
     * @param config Plugin configuration which dictates certain settings, such as whether to show restoration bars and
     * whether or not to draw icons.
     * @param graphics Graphics.
     * @param x The location on the client where it will draw the bar on the x axis starting on the left side.
     * @param y The location on the client where it will draw the bar on the y axis starting on the bottom side.
     * @param height The height of the bar.
     */
    fun renderBar(config: StatusBarsConfig, graphics: Graphics2D, x: Int, y: Int, width: Int, height: Int) {
        val filledHeight = getBarHeight(maxValue, currentValue, height)
        val fill = colorSupplier!!.get()
        refreshSkills()
        graphics.color = BACKGROUND
        graphics.drawRect(x, y, width - BORDER_SIZE, height - BORDER_SIZE)
        graphics.fillRect(x, y, width, height)
        graphics.color = fill
        graphics.fillRect(x + BORDER_SIZE,
                y + BORDER_SIZE + (height - filledHeight),
                width - BORDER_SIZE * 2,
                filledHeight - BORDER_SIZE * 2)
        if (config.enableRestorationBars()) {
            renderRestore(graphics, x, y, width, height)
        }
        if (config.enableSkillIcon() || config.enableCounter()) {
            renderIconsAndCounters(config, graphics, x, y, width)
        }
    }

    private fun renderIconsAndCounters(config: StatusBarsConfig, graphics: Graphics2D, x: Int, y: Int, width: Int) {
        // Icons and counters overlap the bar at small widths, so they are not drawn when the bars are too small
        if (width < MIN_ICON_AND_COUNTER_WIDTH) {
            return
        }
        val skillIconEnabled = config.enableSkillIcon()
        if (skillIconEnabled) {
            iconSupplier?.let {
                val icon = iconSupplier!!.get()
                val xDraw = x + width / 2 - icon.getWidth(null) / 2
                graphics.drawImage(icon, xDraw, y, null)
            }
        }
        if (config.enableCounter()) {
            graphics.font = FontManager.runescapeSmallFont
            var counterText = currentValue.toString()
            if (skillSupplier != null)
                counterText = ("${Main.client.getRealLevel(skillSupplier.get())}")
            val widthOfCounter = graphics.fontMetrics.stringWidth(counterText)
            val centerText = width / 2 - widthOfCounter / 2
            val yOffset = if (skillIconEnabled) SKILL_ICON_HEIGHT else COUNTER_ICON_HEIGHT
            val textComponent = TextComponent()
            textComponent.text = (counterText)
            textComponent.position = (Point(x + centerText, y + yOffset))
            textComponent.render(graphics)
        }
    }

    private fun renderRestore(graphics: Graphics2D, x: Int, y: Int, width: Int, height: Int) {
        val color = healColorSupplier!!.get()
        val heal = healSupplier!!.get()
        if (heal <= 0) {
            return
        }
        val filledCurrentHeight = getBarHeight(maxValue, currentValue, height)
        val filledHealHeight = getBarHeight(maxValue, heal, height)
        val fillY: Int
        val fillHeight: Int
        graphics.color = color
        if (filledHealHeight + filledCurrentHeight > height) {
            graphics.color = OVERHEAL_COLOR
            fillY = y + BORDER_SIZE
            fillHeight = height - filledCurrentHeight - BORDER_SIZE
        } else {
            fillY = y + BORDER_SIZE + height - (filledCurrentHeight + filledHealHeight)
            fillHeight = filledHealHeight
        }
        graphics.fillRect(x + BORDER_SIZE,
                fillY,
                width - BORDER_SIZE * 2,
                fillHeight)
    }

    companion object {
        private val BACKGROUND = Color(0, 0, 0, 150)
        private val OVERHEAL_COLOR = Color(216, 255, 139, 150)
        private const val SKILL_ICON_HEIGHT = 35
        private const val COUNTER_ICON_HEIGHT = 18
        private const val BORDER_SIZE = 1
        private const val MIN_ICON_AND_COUNTER_WIDTH = 16
        const val DEFAULT_WIDTH = 20
        const val MIN_WIDTH = 3
        const val MAX_WIDTH = 40
        private fun getBarHeight(base: Int, current: Int, size: Int): Int {
            val ratio = current.toDouble() / base
            return if (ratio >= 1) {
                size
            } else Math.round(ratio * size).toInt()
        }
    }
}