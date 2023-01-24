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

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.GameObject
import net.runelite.api.InventoryID
import net.runelite.api.ItemID
import net.runelite.api.Varbits
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import javax.inject.Inject

internal class BlastFurnaceClickBoxOverlay @Inject constructor(plugin: BlastFurnacePlugin, config: BlastFurnaceConfig) : Overlay() {
    private val plugin: BlastFurnacePlugin
    private val config: BlastFurnaceConfig

    init {
        position = OverlayPosition.DYNAMIC
        this.plugin = plugin
        this.config = config
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val dispenserState = client.getVarbitValue(Varbits.BAR_DISPENSER)
        if (config.showConveyorBelt() && plugin.conveyorBelt != null) {
            val color = if (dispenserState == 1) Color.RED else Color.GREEN
            renderObject(plugin.conveyorBelt!!, graphics, color)
        }
        if (config.showBarDispenser() && plugin.barDispenser != null) {
            val hasIceGloves = hasIceGloves()
            val color = if (dispenserState == 2 && hasIceGloves) Color.GREEN else if (dispenserState == 3) Color.GREEN else Color.RED
            renderObject(plugin.barDispenser!!, graphics, color)
        }
        return null
    }

    private fun hasIceGloves(): Boolean {
        val equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT) ?: return false
        return equipmentContainer.contains(ItemID.ICE_GLOVES) || equipmentContainer.contains(ItemID.SMITHS_GLOVES_I)
    }

    private fun renderObject(`object`: GameObject, graphics: Graphics2D, color: Color) {
        val localLocation = client.localPlayer!!.localLocation
        val mousePosition = client.mouseCanvasPosition
        val location = `object`.localLocation
        if (localLocation.distanceTo(location) <= MAX_DISTANCE) {
            val objectClickbox = `object`.clickbox
            if (objectClickbox != null) {
                if (objectClickbox.contains(mousePosition.x.toDouble(), mousePosition.y.toDouble())) {
                    graphics.color = color.darker()
                } else {
                    graphics.color = color
                }
                graphics.draw(objectClickbox)
                graphics.color = Color(color.red, color.green, color.blue, 20)
                graphics.fill(objectClickbox)
            }
        }
    }

    companion object {
        private const val MAX_DISTANCE = 2350
    }
}