/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package meteor.plugins.gauntletextended.overlay

import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil.renderImageLocation
import net.runelite.api.Perspective
import net.runelite.api.Player
import net.runelite.api.coords.LocalPoint
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import ui.overlay.outline.ModelOutlineRenderer
import java.awt.Dimension
import java.awt.Graphics2D

class OverlayGauntlet(
    private val plugin: GauntletExtendedPlugin,
    private val config: GauntletExtendedConfig,
    private val modelOutlineRenderer: ModelOutlineRenderer
) : Overlay(
    plugin
) {
    private var player: Player? = null

    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGH
        determineLayer()
    }

    override fun determineLayer() {
        layer = OverlayLayer.UNDER_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        player = client.localPlayer
        if (player == null) {
            return null
        }
        renderResources(graphics)
        renderUtilities()
        renderDemibosses()
        renderStrongNpcs()
        renderWeakNpcs()
        return null
    }

    private fun renderResources(graphics2D: Graphics2D) {
        if (!config.resourceOverlay() && !config.resourceOutline() || plugin.resources.isEmpty()) {
            return
        }
        val localPointPlayer = player!!.localLocation
        for (resource in plugin.resources) {
            val gameObject = resource.gameObject
            val localPointGameObject = gameObject.localLocation
            if (isOutsideRenderDistance(localPointGameObject, localPointPlayer)) {
                continue
            }
            if (config.resourceOverlay()) {
                val polygon = Perspective.getCanvasTilePoly(client, localPointGameObject) ?: continue
                drawOutlineAndFill(
                    graphics2D, config.resourceTileOutlineColor(), config.resourceTileFillColor(),
                    config.resourceTileOutlineWidth().toFloat(), polygon
                )
                resource.icon?.let { renderImageLocation(graphics2D, localPointGameObject, it) }
            }
            if (config.resourceOutline()) {
                val shape = gameObject.convexHull ?: continue
                modelOutlineRenderer.drawOutline(
                    gameObject, config.resourceOutlineWidth(),
                    config.resourceOutlineColor(), 0
                )
            }
        }
    }

    private fun renderUtilities() {
        if (!config.utilitiesOutline() || plugin.utilities.isEmpty()) {
            return
        }
        val localPointPlayer = player!!.localLocation
        for (gameObject in plugin.utilities) {
            if (isOutsideRenderDistance(gameObject.localLocation, localPointPlayer)) {
                continue
            }
            val shape = gameObject.convexHull ?: continue
            modelOutlineRenderer.drawOutline(
                gameObject, config.utilitiesOutlineWidth(),
                config.utilitiesOutlineColor(), 0
            )
        }
    }

    private fun renderDemibosses() {
        if (!config.demibossOutline() || plugin.demibosses.isEmpty()) {
            return
        }
        val localPointPlayer = player!!.localLocation
        for (demiboss in plugin.demibosses) {
            val npc = demiboss.npc
            val localPointNpc = npc.localLocation
            if (localPointNpc == null || npc.isDead || isOutsideRenderDistance(localPointNpc, localPointPlayer)) {
                continue
            }
            modelOutlineRenderer.drawOutline(
                npc, config.demibossOutlineWidth(),
                demiboss.type?.outlineColor, 0
            )
        }
    }

    private fun renderStrongNpcs() {
        if (!config.strongNpcOutline() || plugin.strongNpcs.isEmpty()) {
            return
        }
        val localPointPLayer = player!!.localLocation
        for (npc in plugin.strongNpcs) {
            val localPointNpc = npc.localLocation
            if (localPointNpc == null || npc.isDead || isOutsideRenderDistance(localPointNpc, localPointPLayer)) {
                continue
            }
            modelOutlineRenderer.drawOutline(
                npc, config.strongNpcOutlineWidth(), config.strongNpcOutlineColor(),
                0
            )
        }
    }

    private fun renderWeakNpcs() {
        if (!config.weakNpcOutline() || plugin.weakNpcs.isEmpty()) {
            return
        }
        val localPointPlayer = player!!.localLocation
        for (npc in plugin.weakNpcs) {
            val localPointNpc = npc.localLocation
            if (localPointNpc == null || npc.isDead || isOutsideRenderDistance(localPointNpc, localPointPlayer)) {
                continue
            }
            modelOutlineRenderer.drawOutline(
                npc, config.weakNpcOutlineWidth(), config.weakNpcOutlineColor(),
                0
            )
        }
    }

    private fun isOutsideRenderDistance(localPoint: LocalPoint, playerLocation: LocalPoint): Boolean {
        val maxDistance = config.resourceRenderDistance().distance
        return if (maxDistance == 0) {
            false
        } else localPoint.distanceTo(playerLocation) >= maxDistance
    }
}