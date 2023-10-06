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
package meteor.plugins.statusbars

import meteor.game.SkillIconManager
import meteor.plugins.statusbars.config.BarMode
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.ImageUtil
import net.runelite.api.*
import java.awt.*
import java.util.*

internal class StatusBarsOverlay(var plugin: StatusBarsPlugin, var config: StatusBarsConfig) : Overlay() {

    private val prayerIcon: Image
    private var heartIcon: Image? = null
    private var energyIcon: Image? = null
    private val barRenderers: EnumMap<BarMode, BarRenderer> = EnumMap<BarMode, BarRenderer>(
            BarMode::class.java
    )

    init {
        position = (OverlayPosition.DYNAMIC)
        layer = (OverlayLayer.ALWAYS_ON_TOP)
        prayerIcon = ImageUtil.resizeCanvas(ImageUtil.resizeImage(SkillIconManager.getSkillImage(Skill.PRAYER, true), IMAGE_SIZE, IMAGE_SIZE), ICON_DIMENSIONS.width, ICON_DIMENSIONS.height)
        heartIcon = ImageUtil.resizeCanvas(ImageUtil.resizeImage(SkillIconManager.getSkillImage(Skill.HITPOINTS, true), IMAGE_SIZE, IMAGE_SIZE), ICON_DIMENSIONS.width, ICON_DIMENSIONS.height)
        energyIcon = ImageUtil.resizeCanvas(ImageUtil.resizeImage(SkillIconManager.getSkillImage(Skill.AGILITY, true), IMAGE_SIZE, IMAGE_SIZE), ICON_DIMENSIONS.width, ICON_DIMENSIONS.height)
        initRenderers()
    }

    private fun initRenderers() {
        barRenderers[BarMode.DISABLED] = null
        barRenderers[BarMode.HITPOINTS] = BarRenderer(
            maxValueSupplier = {99},
            currentValueSupplier = {99},
            healSupplier = { 0 },
            colorSupplier = {HEALTH_COLOR},
            healColorSupplier = {HEAL_COLOR},
            iconSupplier = {heartIcon!!})
        barRenderers[BarMode.PRAYER] = BarRenderer(
            maxValueSupplier = {99},
            currentValueSupplier = {99},
            healSupplier = { 0 },
            colorSupplier = {PRAYER_COLOR},
            healColorSupplier = { PRAYER_HEAL_COLOR},
            iconSupplier = {prayerIcon})
        barRenderers[BarMode.FATIGUE] = BarRenderer(
            maxValueSupplier = {100},
            currentValueSupplier = {15},
            healSupplier = { 0 },
            colorSupplier = {Color.YELLOW},
            healColorSupplier = {Color.BLACK},
            iconSupplier = {energyIcon!!})
    }

    override fun render(g: Graphics2D): Dimension? {
        if (!plugin.barsDisplayed) {
            return null
        }

        val width: Int = BarRenderer.DEFAULT_WIDTH
        val height: Int = HEIGHT

        val left = barRenderers[BarMode.HITPOINTS]
        val middle = barRenderers[BarMode.PRAYER]
        val right = barRenderers[BarMode.FATIGUE]
        left?.renderBar(config, g, 5, 30, width, height)
        middle?.renderBar(config, g, 25, 30, width, height)
        right?.renderBar(config, g, 45, 30, width, height)
        return null
    }

    companion object {
        private val PRAYER_COLOR = Color(50, 200, 200, 175)
        private val ACTIVE_PRAYER_COLOR = Color(57, 255, 186, 225)
        private val HEALTH_COLOR = Color(225, 35, 0, 125)
        private val POISONED_COLOR = Color(0, 145, 0, 150)
        private val VENOMED_COLOR = Color(0, 65, 0, 150)
        private val HEAL_COLOR = Color(255, 112, 6, 150)
        private val PRAYER_HEAL_COLOR = Color(57, 255, 186, 75)
        private val ENERGY_HEAL_COLOR = Color(199, 118, 0, 218)
        private val RUN_STAMINA_COLOR = Color(160, 124, 72, 255)
        private val SPECIAL_ATTACK_COLOR = Color(3, 153, 0, 195)
        private val ENERGY_COLOR = Color(199, 174, 0, 220)
        private val DISEASE_COLOR = Color(255, 193, 75, 181)
        private val PARASITE_COLOR = Color(196, 62, 109, 181)
        private const val HEIGHT = 70
        private const val RESIZED_BOTTOM_HEIGHT = 272
        private const val IMAGE_SIZE = 17
        private val ICON_DIMENSIONS = Dimension(26, 25)
        private const val RESIZED_BOTTOM_OFFSET_Y = 12
        private const val RESIZED_BOTTOM_OFFSET_X = 10
        private const val MAX_SPECIAL_ATTACK_VALUE = 100
        private const val MAX_RUN_ENERGY_VALUE = 100
    }
}