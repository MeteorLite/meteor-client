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
import net.runelite.api.NPC
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import net.runelite.api.util.Text
import ui.overlay.outline.ModelOutlineRenderer
import java.awt.*
import java.util.function.Predicate

internal class NpcOverlay(private val modelOutlineRenderer: ModelOutlineRenderer, private val highlightedNpcs: Map<NPC, HighlightedNpc>) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
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
        val borderColor = highlightedNpc.highlightColor
        val borderWidth = highlightedNpc.borderWidth
        val fillColor = highlightedNpc.fillColor
        if (highlightedNpc.hull) {
            val objectClickbox = actor.convexHull
            renderPoly(graphics, borderColor, borderWidth, fillColor, objectClickbox)
        }
        if (highlightedNpc.tile) {
            val tilePoly = actor.canvasTilePoly
            renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly)
        }
        if (highlightedNpc.trueTile) {
            val lp = LocalPoint.fromWorld(client, actor.worldLocation) // centered on sw tile
            if (lp != null) {
                val size = npcComposition.size
                val centerLp = LocalPoint(
                        lp.x + Perspective.LOCAL_TILE_SIZE * (size - 1) / 2,
                        lp.y + Perspective.LOCAL_TILE_SIZE * (size - 1) / 2)
                val tilePoly = Perspective.getCanvasTileAreaPoly(client, centerLp, size)
                renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly)
            }
        }
        if (highlightedNpc.swTile) {
            val size = npcComposition.size
            val lp = actor.localLocation
            val x = lp.x - (size - 1) * Perspective.LOCAL_TILE_SIZE / 2
            val y = lp.y - (size - 1) * Perspective.LOCAL_TILE_SIZE / 2
            val southWestTilePoly = Perspective.getCanvasTilePoly(client, LocalPoint(x, y))
            renderPoly(graphics, borderColor, borderWidth, fillColor, southWestTilePoly)
        }
        if (highlightedNpc.swTrueTile) {
            val lp = LocalPoint.fromWorld(client, actor.worldLocation)
            if (lp != null) {
                val tilePoly = Perspective.getCanvasTilePoly(client, lp)
                renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly)
            }
        }
        if (highlightedNpc.outline) {
            modelOutlineRenderer.drawOutline(actor, highlightedNpc.borderWidth.toInt(), borderColor, highlightedNpc.outlineFeather)
        }
        if (highlightedNpc.name && actor.name != null) {
            val npcName = Text.removeTags(actor.name)
            val textLocation = actor.getCanvasTextLocation(graphics, npcName, actor.logicalHeight + 40)
            if (textLocation != null) {
                OverlayUtil.renderTextLocation(graphics, textLocation, npcName, borderColor!!)
            }
        }
    }

    private fun renderPoly(graphics: Graphics2D, borderColor: Color?, borderWidth: Float, fillColor: Color, polygon: Shape?) {
        if (polygon != null) {
            graphics.color = borderColor
            graphics.stroke = BasicStroke(borderWidth)
            graphics.draw(polygon)
            graphics.color = fillColor
            graphics.fill(polygon)
        }
    }
}