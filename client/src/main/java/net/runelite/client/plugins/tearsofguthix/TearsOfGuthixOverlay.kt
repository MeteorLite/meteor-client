/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.tearsofguthix

import meteor.ui.components.ProgressPieComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.ColorUtil.colorWithAlpha
import net.runelite.api.ObjectID
import net.runelite.api.Point
import java.awt.Dimension
import java.awt.Graphics2D
import java.time.Duration
import java.time.Instant
import javax.inject.Inject

internal class TearsOfGuthixOverlay @Inject constructor(
    private val plugin: TearsOfGuthixPlugin,
    private val config: TearsOfGuthixConfig
) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (plugin.streams.isEmpty()) {
            return null
        }
        val blueTearsFill = config.blueTearsColor
        val greenTearsFill = config.greenTearsColor
        val blueTearsBorder = colorWithAlpha(blueTearsFill!!, 255)
        val greenTearsBorder = colorWithAlpha(greenTearsFill!!, 255)
        plugin.streams.forEach { (`object`, timer) ->
            if ((`object`.getId() == ObjectID.GREEN_TEARS || `object`.getId() == ObjectID.GREEN_TEARS_6666)
                && !config.showGreenTearsTimer()
            ) {
                return@forEach
            }
            val position: Point = `object`.getCanvasLocation(100) ?: return@forEach
            val progressPie = ProgressPieComponent()
            progressPie.diameter = 15
            if (`object`.getId() == ObjectID.BLUE_TEARS ||
                `object`.getId() == ObjectID.BLUE_TEARS_6665
            ) {
                progressPie.fill = blueTearsFill
                progressPie.borderColor = blueTearsBorder
            } else if (`object`.getId() == ObjectID.GREEN_TEARS ||
                `object`.getId() == ObjectID.GREEN_TEARS_6666
            ) {
                progressPie.fill = greenTearsFill
                progressPie.borderColor = greenTearsBorder
            }
            progressPie.position = position
            val duration = Duration.between(timer, Instant.now())
            progressPie.progress =
                1.toDouble() - if (duration < MAX_TIME) duration.toMillis().toDouble() / MAX_TIME.toMillis().toDouble() else 1.toDouble()
            progressPie.render(graphics)
        }
        return null
    }

    companion object {
        private val MAX_TIME = Duration.ofSeconds(9)
    }
}