/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.blastfurnace

import meteor.Main
import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.util.QuantityFormatter.quantityToStackSize
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetInfo
import org.apache.commons.lang3.time.DurationFormatUtils
import java.awt.Dimension
import java.awt.Graphics2D
import javax.inject.Inject

internal class BlastFurnaceCofferOverlay @Inject constructor(plugin: BlastFurnacePlugin, config: BlastFurnaceConfig) : OverlayPanel() {
    private val plugin: BlastFurnacePlugin
    private val config: BlastFurnaceConfig

    init {
        position = OverlayPosition.TOP_LEFT
        this.plugin = plugin
        this.config = config
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Coffer overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (plugin.conveyorBelt == null) {
            return null
        }
        val sack = client.getWidget(WidgetInfo.BLAST_FURNACE_COFFER)
        if (sack != null) {
            val coffer = client.getVarbitValue(Varbits.BLAST_FURNACE_COFFER)
            sack.isHidden = true
            panelComponent.children.add(LineComponent.Builder()
                    .left("Coffer:")
                    .right(quantityToStackSize(coffer.toLong()) + " gp")
                    .build())
            if (config.showCofferTime()) {
                val millis = (coffer / COST_PER_HOUR * 60 * 60 * 1000).toLong()
                panelComponent.children.add(LineComponent.Builder()
                        .left("Time:")
                        .right(DurationFormatUtils.formatDuration(millis, "H'h' m'm' s's'", true))
                        .build())
            }
        }
        return super.render(graphics)
    }

    companion object {
        private const val COST_PER_HOUR = 72000.0f
    }
}