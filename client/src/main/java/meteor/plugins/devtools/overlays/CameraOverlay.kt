/*
 * Copyright (c) 2018, Matthew Steglinski <https://github.com/sainttx>
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
package meteor.plugins.devtools.overlays

import meteor.Main
import meteor.plugins.devtools.DevToolsConfig
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.ui.table.TitleComponent
import net.runelite.api.Client
import java.awt.Dimension
import java.awt.Graphics2D

class CameraOverlay(private val config: DevToolsConfig) : OverlayPanel() {
    init {
        position = OverlayPosition.TOP_LEFT
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!client.isLoggedIn() || !config.camera()) return null
        panelComponent.children.add(TitleComponent()
                .text("Camera"))

        panelComponent.children.add(LineComponent.Builder()
                .left("X")
                .right("" + client.getCameraX())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Y")
                .right("" + client.getCameraY())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Z")
                .right("" + client.getCameraZ())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Pitch")
                .right("" + client.getCameraPitch())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Yaw")
                .right("" + client.getCameraYaw())
                .build())

        panelComponent.children.add(LineComponent.Builder()
                .left("Scale")
                .right("" + client.getScale())
                .build())

        return super.render(graphics)
    }
}
