/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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
package meteor.plugins.driftnet

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import meteor.util.OverlayUtil.renderActorOverlay
import java.awt.Dimension
import java.awt.Graphics2D
import javax.inject.Inject

internal class DriftNetOverlay @Inject constructor(private val plugin: DriftNetPlugin, private val config: DriftNetConfig) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.LOW
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!plugin.inDriftNetArea) {
            return null
        }
        if (config.highlightUntaggedFish()) {
            renderFish(graphics)
        }
        if (config.showNetStatus()) {
            renderNets(graphics)
        }
        if (config.tagAnnetteWhenNoNets()) {
            renderAnnette(graphics)
        }
        return null
    }

    private fun renderFish(graphics: Graphics2D) {
        for (fish in plugin.fish) {
            if (!plugin.taggedFish.containsKey(fish)) {
                renderActorOverlay(graphics, fish, "", config.untaggedFishColor()!!)
            }
        }
    }

    private fun renderNets(graphics: Graphics2D) {
        for (net in plugin.NETS) {
            val polygon = net.net!!.convexHull
            if (polygon != null) {
                OverlayUtil.renderPolygon(graphics, polygon, net.status!!.color!!)
            }
            val text = net.formattedCountText
            val textLocation = net.net!!.getCanvasTextLocation(graphics, text, 0)
            if (textLocation != null) {
                OverlayUtil.renderTextLocation(graphics, textLocation, text!!, config.countColor()!!)
            }
        }
    }

    private fun renderAnnette(graphics: Graphics2D) {
        val annette = plugin.annette
        if (annette != null && !plugin.driftNetsInInventory) {
            OverlayUtil.renderPolygon(graphics, annette.convexHull, config.annetteTagColor()!!)
        }
    }
}