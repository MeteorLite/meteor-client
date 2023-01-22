/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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

import meteor.Main
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.Projectile
import net.runelite.api.coords.LocalPoint
import net.runelite.api.model.Jarvis
import net.runelite.api.model.Vertex
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import meteor.plugins.gauntletextended.entity.Hunllef
import meteor.outline.ModelOutlineRenderer
import java.awt.*

class OverlayHunllef(
    private val plugin: GauntletExtendedPlugin,
    private val config: GauntletExtendedConfig,
    private val modelOutlineRenderer: ModelOutlineRenderer
) : Overlay(
    plugin
) {
    private var hunllef: Hunllef? = null
    private var timeout = 0
    private var idx = 0

    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGH
        determineLayer()
    }

    override fun render(graphics2D: Graphics2D): Dimension? {
        hunllef = plugin.hunllef
        if (hunllef == null) {
            return null
        }
        val npc = hunllef!!.npc ?: return null
        if (npc.isDead) {
            renderDiscoMode()
            return null
        }
        renderTornadoes(graphics2D)
        renderProjectile(graphics2D)
        renderHunllefWrongPrayerOutline()
        renderHunllefAttackCounter(graphics2D)
        renderHunllefAttackStyleIcon(graphics2D)
        renderHunllefTile(graphics2D)
        renderFlashOnWrongAttack(graphics2D)
        renderFlashOn51Method(graphics2D)
        return null
    }

    override fun determineLayer() {
        layer = OverlayLayer.UNDER_WIDGETS
    }

    private fun renderTornadoes(graphics2D: Graphics2D) {
        if (!config.tornadoTickCounter() && !config.tornadoTileOutline() || plugin.tornadoes.isEmpty()) {
            return
        }
        for (tornado in plugin.tornadoes) {
            val timeLeft = tornado.timeLeft
            if (timeLeft < 0) {
                continue
            }
            val npc = tornado.npc
            if (config.tornadoTileOutline()) {
                val polygon = Perspective.getCanvasTilePoly(client, npc!!.localLocation) ?: continue
                drawOutlineAndFill(
                    graphics2D, config.tornadoOutlineColor(), config.tornadoFillColor(),
                    config.tornadoTileOutlineWidth().toFloat(), polygon
                )
            }
            if (config.tornadoTickCounter()) {
                val ticksLeftStr = timeLeft.toString()
                val point = npc!!.getCanvasTextLocation(graphics2D, ticksLeftStr, 0) ?: return
                OverlayUtil.renderTextLocation(
                    graphics2D, ticksLeftStr, config.tornadoFontSize(),
                    config.tornadoFontStyle().font, config.tornadoFontColor()!!, point,
                    config.tornadoFontShadow(), 0
                )
            }
        }
    }

    private fun renderProjectile(graphics2D: Graphics2D) {
        if (!config.outlineProjectile() && !config.overlayProjectileIcon() || plugin.missile == null) {
            return
        }
        val missile = plugin.missile
        val polygon = getProjectilePolygon(missile!!.projectile) ?: return
        if (config.outlineProjectile()) {
            val originalColor = graphics2D.color
            graphics2D.color = missile.outlineColor
            graphics2D.draw(polygon)
            graphics2D.color = missile.fillColor
            graphics2D.fill(polygon)
            graphics2D.color = originalColor
        }
        if (config.overlayProjectileIcon()) {
            val icon = missile.icon
            val bounds = polygon.bounds
            val x = bounds.centerX.toInt() - icon!!.width / 2
            val y = bounds.centerY.toInt() - icon.height / 2
            graphics2D.drawImage(icon, x, y, null)
        }
    }

    private fun renderHunllefWrongPrayerOutline() {
        if (!config.hunllefOverlayWrongPrayerOutline()) {
            return
        }
        val phase = hunllef!!.attackPhase
        if (client.isPrayerActive(phase.prayer)) {
            return
        }
        modelOutlineRenderer.drawOutline(
            hunllef!!.npc, config.hunllefWrongPrayerOutlineWidth(), phase.color,
            0
        )
    }

    private fun renderHunllefAttackCounter(graphics2D: Graphics2D) {
        if (!config.hunllefOverlayAttackCounter()) {
            return
        }
        val npc = hunllef!!.npc
        val text = String.format(
            "%d | %d", hunllef!!.attackCount,
            hunllef!!.playerAttackCount
        )
        val point = npc.getCanvasTextLocation(graphics2D, text, 0) ?: return
        val originalFont = graphics2D.font
        graphics2D.font = Font(
            Font.SANS_SERIF,
            config.hunllefAttackCounterFontStyle().font, config.hunllefAttackCounterFontSize()
        )
        OverlayUtil.renderTextLocation(graphics2D, point, text, hunllef!!.attackPhase.color!!)
        graphics2D.font = originalFont
    }

    private fun renderHunllefAttackStyleIcon(graphics2D: Graphics2D) {
        if (!config.hunllefOverlayAttackStyleIcon()) {
            return
        }
        val npc = hunllef!!.npc
        val icon = hunllef!!.icon
        val point = Perspective.getCanvasImageLocation(
            client, npc.localLocation, icon,
            npc.logicalHeight - 100
        ) ?: return
        graphics2D.drawImage(icon, point.x, point.y, null)
    }

    private fun renderHunllefTile(graphics2D: Graphics2D) {
        if (!config.hunllefOutlineTile()) {
            return
        }
        val npc = hunllef!!.npc
        val npcComposition = npc.composition ?: return
        val polygon = Perspective.getCanvasTileAreaPoly(
            client, npc.localLocation,
            npcComposition.size
        ) ?: return
        drawOutlineAndFill(
            graphics2D, config.hunllefOutlineColor(), config.hunllefFillColor(),
            config.hunllefTileOutlineWidth().toFloat(), polygon
        )
    }

    private fun renderFlashOnWrongAttack(graphics2D: Graphics2D) {
        if (!config.flashOnWrongAttack() || !plugin.wrongAttackStyle) {
            return
        }
        val originalColor = graphics2D.color
        graphics2D.color = config.flashOnWrongAttackColor()
        graphics2D.fill(client.canvas.bounds)
        graphics2D.color = originalColor
        if (++timeout >= config.flashOnWrongAttackDuration()) {
            timeout = 0
            plugin.wrongAttackStyle = false
        }
    }

    private fun renderFlashOn51Method(graphics2D: Graphics2D) {
        if (!config.flashOn51Method() || !plugin.switchWeapon) {
            return
        }
        val originalColor = graphics2D.color
        graphics2D.color = config.flashOn51MethodColor()
        graphics2D.fill(client.canvas.bounds)
        graphics2D.color = originalColor
        if (++timeout >= config.flashOn51MethodDuration()) {
            timeout = 0
            plugin.switchWeapon = false
        }
    }

    private fun renderDiscoMode() {
        if (!config.discoMode()) {
            return
        }
        if (++timeout > COLOR_DURATION) {
            timeout = 0
            idx = if (idx >= COLORS.size - 1) 0 else idx + 1
        }
        modelOutlineRenderer.drawOutline(hunllef!!.npc, 6, COLORS[idx], 4)
    }

    companion object {
        private val COLORS = arrayOf(
            Color.BLUE,
            Color.RED,
            Color.GREEN,
            Color.ORANGE,
            Color.WHITE,
            Color.CYAN,
            Color.MAGENTA,
            Color.PINK,
            Color.YELLOW,
            Color.DARK_GRAY,
            Color.LIGHT_GRAY
        )
        private const val COLOR_DURATION = 10
        private fun getProjectilePolygon(projectile: Projectile?): Polygon? {
            if (projectile == null || projectile.model == null) {
                return null
            }
            val model = projectile.model
            val localPoint = LocalPoint(projectile.x.toInt(), projectile.y.toInt())
            val tileHeight = Perspective.getTileHeight(Main.client, localPoint, Main.client.plane)
            var angle = Math.atan(projectile.velocityY / projectile.velocityX)
            angle = Math.toDegrees(angle) + if (projectile.velocityX < 0) 180 else 0
            angle = if (angle < 0) angle + 360 else angle
            angle = 360 - angle - 90
            var ori = angle * (512.0 / 90.0)
            ori = if (ori < 0) ori + 2048 else ori
            val orientation = Math.round(ori).toInt()
            val vertices: MutableList<Vertex?> = model.vertices as MutableList<Vertex?>
            for (i in vertices.indices) {
                vertices[i] = vertices[i]!!.rotate(orientation)
            }
            val list: MutableList<Point> = ArrayList()
            for (vertex in vertices) {
                val point = Perspective.localToCanvas(
                    Main.client, localPoint.x - vertex!!.x,
                    localPoint.y - vertex.z, tileHeight + vertex.y + projectile.z.toInt()
                ) ?: continue
                list.add(point)
            }
            val convexHull = Jarvis.convexHull(list) ?: return null
            val polygon = Polygon()
            for (point in convexHull) {
                polygon.addPoint(point.x, point.y)
            }
            return polygon
        }
    }
}