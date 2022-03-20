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
package meteor.plugins.questrunner.overlay

import meteor.plugins.questrunner.QuestRunnerPlugin
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class StatusOverlay(val plugin: QuestRunnerPlugin ) : OverlayPanel() {
    init {
        position = OverlayPosition.DYNAMIC
        setPreferredSize(Dimension(200, 30))
        preferredPosition = OverlayPosition.TOP_LEFT
    }

    override fun render(graphics: Graphics2D): Dimension? {
        panelComponent.children.add(
            LineComponent.Builder()
                .left("Quest")
                .right("Cooks Assistant")
                .build()
        )
        panelComponent.children.add(
            if (QuestRunnerPlugin.questComplete) {
                LineComponent.Builder()
                    .left("Status")
                    .right("Quest Complete!")
                    .rightColor(Color.GREEN)
                    .build()
            }
            else {
                LineComponent.Builder()
                    .left("Status")
                    .right(QuestRunnerPlugin.lastPluginState.toString())
                    .build()
            }
        )
        QuestRunnerPlugin.info?.let {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Info")
                    .right(QuestRunnerPlugin.info!!)
                    .build()
            )
        }

        return super.render(graphics)
    }
}