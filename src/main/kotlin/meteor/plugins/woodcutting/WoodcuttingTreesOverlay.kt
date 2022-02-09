/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, David <Dava96@github.com>
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

import meteor.game.ItemManager
import meteor.ui.components.ProgressPieComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.time.Instant

class WoodcuttingTreesOverlay(var plugin: WoodcuttingPlugin) : Overlay() {
    private val itemManager = ItemManager
    var config = plugin.configuration<WoodcuttingConfig>()
    init {

        layer = OverlayLayer.ABOVE_SCENE
        position = OverlayPosition.DYNAMIC

    }

    override fun render(graphics: Graphics2D): Dimension? {
        //renderAxes(graphics)
        renderTimers(graphics)
        return null
    }

/*
    private fun renderAxes(graphics: Graphics2D) {
        if (plugin.session == null || !config.showRedwoodTrees()) {
            return
        }
        val axe = plugin.axe ?: return
        for (treeObject in plugin.treeObjects) {
            if (treeObject.worldLocation.distanceTo(client.localPlayer!!.worldLocation) <= 12) {
                OverlayUtil.renderImageLocation(
                    client,
                    graphics,
                    treeObject.localLocation,
                    itemManager.getImage(axe.itemId),
                    120
                )
            }
        }
    }
*/

    private fun renderTimers(graphics: Graphics2D) {
        val respawns = plugin.respawns
        if (respawns.isEmpty() || !config.showRespawnTimers()) {
            return
        }
        val now = Instant.now()
        for (treeRespawn in respawns) {
            val minLocation = LocalPoint.fromWorld(
                client, treeRespawn.worldLocation
            ) ?: continue
            val centeredLocation = LocalPoint(
                minLocation.x + treeRespawn.lenX * Perspective.LOCAL_HALF_TILE_SIZE,
                minLocation.y + treeRespawn.lenY * Perspective.LOCAL_HALF_TILE_SIZE
            )
            val percent =
                (now.toEpochMilli() - treeRespawn.startTime.toEpochMilli()) / treeRespawn.respawnTime.toFloat()
            val point = Perspective.localToCanvas(client, centeredLocation, client.plane)
            if (point == null || percent > 1.0f) {
                continue
            }
            val ppc = ProgressPieComponent()
            ppc.borderColor = (Color.ORANGE)
            ppc.fill = (Color.YELLOW)
            ppc.position =(point)
            ppc.progress =(percent.toDouble())
            ppc.render(graphics)
        }
    }
}