/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
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
package meteor.plugins.cooking

import meteor.Main
import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.plugins.xptracker.XpTrackerService
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.ui.table.TitleComponent.Companion.builder
import net.runelite.api.AnimationID
import net.runelite.api.MenuAction
import net.runelite.api.Skill
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.text.DecimalFormat
import java.time.Duration
import java.time.Instant
import javax.inject.Inject

internal class CookingOverlay @Inject constructor(plugin: CookingPlugin) : OverlayPanel() {
    private val plugin: CookingPlugin
    private var xpTrackerService: XpTrackerService? = null

    init {
        position = OverlayPosition.TOP_LEFT
        this.plugin = plugin
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Cooking overlay"))
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, COOKING_RESET, "Cooking overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (xpTrackerService == null) {
            if (!Main.xpTrackerService::class.isAbstract)
                xpTrackerService = Main.xpTrackerService
            else
                return null
        }
        val session = plugin.session ?: return null
        if (isCooking || Duration.between(session.lastCookingAction, Instant.now()).seconds < COOK_TIMEOUT) {
            panelComponent.children.add(builder()
                    .text("Cooking")
                    .color(Color.GREEN))
        } else {
            panelComponent.children.add(builder()
                    .text("NOT cooking")
                    .color(Color.RED))
        }
        panelComponent.children.add(LineComponent.Builder()
                .left("Cooked:")
                .right(session.cookAmount.toString() + if (session.cookAmount >= 1) " (" + xpTrackerService!!.getActionsHr(Skill.COOKING) + "/hr)" else "")
                .build())
        panelComponent.children.add(LineComponent.Builder()
                .left("Burnt:")
                .right(session.burnAmount.toString() + if (session.burnAmount >= 1) " (" + FORMAT.format(session.burntPercentage) + "%)" else "")
                .build())
        return super.render(graphics)
    }

    private val isCooking: Boolean
        private get() = when (client.localPlayer!!.animation) {
            AnimationID.COOKING_FIRE, AnimationID.COOKING_RANGE -> true
            else -> false
        }

    companion object {
        private const val COOK_TIMEOUT = 3
        private val FORMAT = DecimalFormat("#.#")
        const val COOKING_RESET = "Reset"
    }
}