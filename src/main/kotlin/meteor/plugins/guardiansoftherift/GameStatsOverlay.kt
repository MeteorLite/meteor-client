/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.guardiansoftherift

import meteor.plugins.xptracker.XpTrackerService
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import java.awt.Dimension
import java.awt.Graphics2D

class GameStatsOverlay(val plugin: GuardiansOfTheRiftPlugin) : OverlayPanel() {
    lateinit var xpTrackerService: XpTrackerService

    init {
        position = OverlayPosition.TOP_CENTER
    }

    override fun render(graphics: Graphics2D): Dimension? {

        if (plugin.gameLength != 0) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Game Time Elapsed")
                    .right("${(plugin.gameLength * 600) / 1000}")
                    .build()
            )
        }
        if (plugin.countDownCount) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Game Starts in")
                    .right("${(plugin.countDownLength * 600) / 1000}")
                    .build()
            )
        }
        if (plugin.collectionCount) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Collection Time Left")
                    .right("${(120 - (plugin.collectionLength * 600) / 1000)}")
                    .build()
            )
        }

        if (plugin.catalyticPoints > 0 || plugin.elementalPoints > 0) {
            if (plugin.elementalPriority) {
                panelComponent.children.add(
                    LineComponent.Builder()
                        .left("Target Runes")
                        .right("Elemental")
                        .build()
                )
            } else {
                panelComponent.children.add(
                    LineComponent.Builder()
                        .left("Target Runes")
                        .right("Catalytic")
                        .build()
                )
            }
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Elemental Points")
                    .right("${plugin.elementalPoints}")
                    .build()
            )
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Catalytic Points")
                    .right("${plugin.catalyticPoints}")
                    .build()
            )
        }

        return super.render(graphics)
    }
}