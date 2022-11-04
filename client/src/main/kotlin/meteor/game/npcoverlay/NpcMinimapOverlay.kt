/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
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
package meteor.game.npcoverlay

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.OverlayUtil
import meteor.util.OverlayUtil.renderMinimapLocation
import net.runelite.api.NPC
import net.runelite.api.util.Text
import java.awt.Dimension
import java.awt.Graphics2D
import java.util.function.Predicate

internal class NpcMinimapOverlay(private val highlightedNpcs: Map<NPC, HighlightedNpc>) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        for (highlightedNpc in highlightedNpcs.values) {
            renderNpcOverlay(graphics, highlightedNpc)
        }
        return null
    }

    private fun renderNpcOverlay(graphics: Graphics2D, highlightedNpc: HighlightedNpc) {
        val actor = highlightedNpc.npc
        val npcComposition = actor!!.transformedComposition
        if (npcComposition == null || !npcComposition.isInteractible) {
            return
        }
        val render: Predicate<NPC>? = highlightedNpc.render
        if (render != null && !render.test(actor)) {
            return
        }
        val minimapLocation = actor.minimapLocation
        if (minimapLocation != null) {
            val color = highlightedNpc.highlightColor
            renderMinimapLocation(graphics, minimapLocation, color!!)
            if (highlightedNpc.nameOnMinimap && actor.name != null) {
                val name = Text.removeTags(actor.name)
                OverlayUtil.renderTextLocation(graphics, minimapLocation, name, color)
            }
        }
    }
}