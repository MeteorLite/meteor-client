/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package meteor.plugins.blastmine

import meteor.Main
import meteor.game.ItemManager
import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.ui.components.ImageComponent
import meteor.ui.overlay.ComponentOrientation
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.ItemID
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetInfo
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.inject.Inject

internal class BlastMineOreCountOverlay @Inject constructor(config: BlastMinePluginConfig) : OverlayPanel() {
    private val config: BlastMinePluginConfig
    private val itemManager = ItemManager

    init {
        position = OverlayPosition.TOP_LEFT
        this.config = config
        panelComponent.orientation = ComponentOrientation.HORIZONTAL
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Blast mine overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE) ?: return null
        if (config.showOreOverlay()) {
            blastMineWidget.isHidden = true
            panelComponent.children.add(ImageComponent(getImage(ItemID.COAL, client.getVarbitValue(Varbits.BLAST_MINE_COAL))))
            panelComponent.children.add(ImageComponent(getImage(ItemID.GOLD_ORE, client.getVarbitValue(Varbits.BLAST_MINE_GOLD))))
            panelComponent.children.add(ImageComponent(getImage(ItemID.MITHRIL_ORE, client.getVarbitValue(Varbits.BLAST_MINE_MITHRIL))))
            panelComponent.children.add(ImageComponent(getImage(ItemID.ADAMANTITE_ORE, client.getVarbitValue(Varbits.BLAST_MINE_ADAMANTITE))))
            panelComponent.children.add(ImageComponent(getImage(ItemID.RUNITE_ORE, client.getVarbitValue(Varbits.BLAST_MINE_RUNITE))))
        } else {
            blastMineWidget.isHidden = false
        }
        return super.render(graphics)
    }

    private fun getImage(itemID: Int, amount: Int): BufferedImage? {
        return itemManager.getImage(itemID, amount, true)
    }
}