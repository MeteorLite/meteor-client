/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package meteor.plugins.barrows

import meteor.Main
import meteor.game.FontManager.defaultFont
import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import net.runelite.api.*
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.text.DecimalFormat
import javax.inject.Inject

internal class BarrowsBrotherSlainOverlay @Inject constructor(plugin: BarrowsPlugin?) : OverlayPanel() {
    init {
        position = OverlayPosition.TOP_LEFT
        priority = OverlayPriority.LOW
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Barrows overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        // Only render the brothers slain overlay if the vanilla interface is loaded
        val barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS) ?: return null
        for (brother in BarrowsBrothers.values()) {
            val brotherSlain = client.getVarbitValue(brother.varbit) > 0
            val slain = if (brotherSlain) "\u2713" else "\u2717"
            panelComponent.children.add(LineComponent.Builder()
                    .left(brother.brotherName)
                    .right(slain)
                    .rightFont(defaultFont!!)
                    .rightColor(if (brotherSlain) Color.GREEN else Color.RED)
                    .build())
        }
        val rewardPotential = rewardPotential()
        panelComponent.children.add(LineComponent.Builder()
                .left("Potential")
                .right(REWARD_POTENTIAL_FORMATTER.format((rewardPotential / 1012f).toDouble()))
                .rightColor(if (rewardPotential >= 756 && rewardPotential < 881) Color.GREEN else if (rewardPotential < 631) Color.WHITE else Color.YELLOW)
                .build())
        return super.render(graphics)
    }

    /**
     * Compute the barrows reward potential. Potential rewards are based off of the amount of
     * potential.
     *
     *
     * The reward potential thresholds are as follows:
     * Mind rune - 381
     * Chaos rune - 506
     * Death rune - 631
     * Blood rune - 756
     * Bolt rack - 881
     * Half key - 1006
     * Dragon med - 1012
     *
     * @return potential, 0-1012 inclusive
     * @see [source](https://twitter.com/jagexkieren/status/705428283509366785?lang=en)
     */
    private fun rewardPotential(): Int {
        // this is from [proc,barrows_overlay_reward]
        val brothers = (client.getVarbitValue(Varbits.BARROWS_KILLED_AHRIM)
                + client.getVarbitValue(Varbits.BARROWS_KILLED_DHAROK)
                + client.getVarbitValue(Varbits.BARROWS_KILLED_GUTHAN)
                + client.getVarbitValue(Varbits.BARROWS_KILLED_KARIL)
                + client.getVarbitValue(Varbits.BARROWS_KILLED_TORAG)
                + client.getVarbitValue(Varbits.BARROWS_KILLED_VERAC))
        return client.getVarbitValue(Varbits.BARROWS_REWARD_POTENTIAL) + brothers * 2
    }

    companion object {
        private val REWARD_POTENTIAL_FORMATTER = DecimalFormat("##0.00%")
    }
}