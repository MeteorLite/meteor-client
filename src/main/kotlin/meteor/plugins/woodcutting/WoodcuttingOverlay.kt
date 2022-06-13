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
package meteor.plugins.woodcutting

import meteor.plugins.xptracker.XpInfoBoxOverlay.Companion.OPTION_CONFIGURE
import meteor.plugins.xptracker.XpTrackerService
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.MenuAction
import net.runelite.api.Skill
import java.awt.Dimension
import java.awt.Graphics2D

class WoodcuttingOverlay(val plugin: WoodcuttingPlugin) : OverlayPanel() {
    var config = plugin.configuration<WoodcuttingConfig>()

    lateinit var xpTrackerService: XpTrackerService

    init {
        position = OverlayPosition.DYNAMIC


        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Woodcutting overlay"))
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, WOODCUTTING_RESET, "Woodcutting overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {

        plugin.session ?: return null
        val axe = plugin.axe
        if (axe.matchesChoppingAnimation(client.localPlayer)) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Woodcutting").build()

            )
        } else {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("NOT woodcutting")
                    .build()
            )
        }
        val actions = xpTrackerService.getActions(Skill.WOODCUTTING)
        if (actions > 0) {
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Logs cut:")
                    .right(actions.toString())
                    .build()
            )
            if (actions > 2) {
                panelComponent.children.add(
                    LineComponent.Builder()
                        .left("Logs/hr:")
                        .right(xpTrackerService.getActionsHr(Skill.WOODCUTTING).toString())
                        .build()
                )
            }
        }
        return super.render(graphics)
    }

    companion object {
        const val WOODCUTTING_RESET = "Reset"
    }
}