/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.plugins.corp

import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.ui.components.ComponentConstants
import meteor.ui.components.LineComponent
import meteor.ui.overlay.*
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetID
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import javax.inject.Inject

internal class CorpDamageOverlay @Inject constructor(corpPlugin: CorpPlugin, config: CorpConfig) : OverlayPanel() {
    private val corpPlugin: CorpPlugin
    private val config: CorpConfig

    init {
        position = OverlayPosition.TOP_LEFT
        layer = OverlayLayer.UNDER_WIDGETS
        priority = OverlayPriority.LOW
        this.corpPlugin = corpPlugin
        this.config = config
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Corp overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val damageWidget = client.getWidget(WidgetID.CORP_DAMAGE, 0)
        if (damageWidget != null) {
            damageWidget.isHidden = true
        }
        val corp = corpPlugin.corp ?: return null
        val myDamage = client.getVarbitValue(Varbits.CORP_DAMAGE)
        val totalDamage = corpPlugin.totalDamage
        val players = corpPlugin.players.size

        // estimate how much damage is required for kill based on number of players
        val damageForKill = if (players != 0) totalDamage / players else 0
        val core = corpPlugin.core
        if (core != null) {
            val corePoint = core.worldLocation
            val myPoint = client.localPlayer!!.worldLocation
            var text: String? = null
            if (core.interacting === client.localPlayer) {
                text = "The core is targeting you!"
            } else if (corePoint.distanceTo(myPoint) <= 1) {
                text = "Stay away from the core!"
            }
            if (text != null) {
                val fontMetrics = graphics.fontMetrics
                val textWidth = Math.max(ComponentConstants.STANDARD_WIDTH, fontMetrics.stringWidth(text))
                panelComponent.setPreferredSize(Dimension(textWidth, 0))
                panelComponent.children.add(LineComponent.Builder()
                        .left(text)
                        .leftColor(Color.RED)
                        .build())
            }
        }
        if (config.showDamage()) {
            panelComponent.children.add(LineComponent.Builder()
                    .left("Your damage")
                    .right(Integer.toString(myDamage))
                    .rightColor(if (damageForKill > 0 && myDamage >= damageForKill) Color.GREEN else Color.RED)
                    .build())
            panelComponent.children.add(LineComponent.Builder()
                    .left("Total damage")
                    .right(Integer.toString(totalDamage))
                    .build())
        }
        return super.render(graphics)
    }
}