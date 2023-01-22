/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package meteor.plugins.coxhelper

import com.google.common.collect.ImmutableSet
import meteor.plugins.coxhelper.Olm.PhaseType
import meteor.ui.overlay.*
import meteor.util.OverlayUtil
import net.runelite.api.*
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import meteor.outline.ModelOutlineRenderer
import java.awt.*
import java.util.function.Consumer

class CoxOverlay(private val plugin: CoxPlugin) : Overlay() {
    var outliner = ModelOutlineRenderer()
    var config = plugin.config
    init {

        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        priority = OverlayPriority.HIGH
    }

    override fun render(graphics: Graphics2D): Dimension? {
        for (point in Olm.healPools) {
            drawTile(graphics, point, config.tpColor(), 2, 150)
        }
        for (point in Olm.portals) {
            client.setHintArrow(point)
            drawTile(graphics, point, config.tpColor(), 2, 150)
        }
        if (plugin.inRaid()) {
            plugin.npcContainers.values.forEach {
                val color: Color?
                val hitSquares: List<WorldPoint>
                val ticksLeft: Int
                when (it?.npc?.id) {
                    NpcID.TEKTON, NpcID.TEKTON_7541, NpcID.TEKTON_7542, NpcID.TEKTON_7545, NpcID.TEKTON_ENRAGED, NpcID.TEKTON_ENRAGED_7544 -> if (config.tekton()) {
                        hitSquares = getHitSquares(it.npc.worldLocation, it.npcSize, 1, false)
                        for (p in hitSquares) {
                            drawTile(graphics, p, config.tektonColor(), 0, 0)
                        }
                        if (config.tektonTickCounter()) {
                            ticksLeft = it.ticksUntilAttack
                            val attackTicksleft = plugin.tektonAttackTicks
                            val attacksLeftStr: String
                            val attackcolor: Color
                            if (ticksLeft > 0) {
                                color = if (ticksLeft == 1) {
                                    it.attackStyle.color
                                } else {
                                    Color.WHITE
                                }
                                val ticksLeftStr = ticksLeft.toString()
                                val canvasPoint: Point? = it.npc.getCanvasTextLocation(graphics, ticksLeftStr, 0)
                                this.renderTextLocation(
                                    graphics,
                                    ticksLeftStr,
                                    config.textSize(),
                                    config.fontStyle().font,
                                    color,
                                    canvasPoint
                                )
                            }
                            if (attackTicksleft >= 0 && plugin.tektonActive) {
                                if (attackTicksleft <= 1) {
                                    attackcolor = Color(255, 0, 0, 255)
                                    attacksLeftStr = "Phase Over"
                                } else {
                                    attackcolor = Color(255, 255, 255, 255)
                                    attacksLeftStr = attackTicksleft.toString()
                                }
                                val canvasPoint: Point? = it.npc.getCanvasTextLocation(graphics, attacksLeftStr, 0)
                                renderTextLocationAbove(
                                    graphics,
                                    attacksLeftStr,
                                    config.textSize(),
                                    config.fontStyle().font,
                                    attackcolor,
                                    canvasPoint
                                )
                            }
                        }
                    }
                    NpcID.MUTTADILE, NpcID.MUTTADILE_7562, NpcID.MUTTADILE_7563 -> if (config.muttadile()) {
                        hitSquares = getHitSquares(it.npc.worldLocation, it.npcSize, 1, false)
                        for (p in hitSquares) {
                            drawTile(graphics, p, config.muttaColor(), 0, 0)
                        }
                    }
                    NpcID.GUARDIAN, NpcID.GUARDIAN_7570, NpcID.GUARDIAN_7571, NpcID.GUARDIAN_7572 -> {
                        if (config.guardians()) {
                            hitSquares = getHitSquares(it.npc.worldLocation, it.npcSize, 2, true)
                            for (p in hitSquares) {
                                drawTile(graphics, p, config.guardColor(), 0, 0)
                            }
                        }
                        if (config.guardinTickCounter()) {
                            ticksLeft = it.ticksUntilAttack
                            if (ticksLeft > 0) {
                                color = if (ticksLeft == 1) {
                                    it.attackStyle.color
                                } else {
                                    Color.WHITE
                                }
                                val ticksLeftStr = ticksLeft.toString()
                                val canvasPoint: Point? = it.npc.getCanvasTextLocation(graphics, ticksLeftStr, 0)
                                this.renderTextLocation(
                                    graphics,
                                    ticksLeftStr,
                                    config.textSize(),
                                    config.fontStyle().font,
                                    color,
                                    canvasPoint
                                )
                            }
                        }
                    }
                    NpcID.VANGUARD_7526, NpcID.VANGUARD_7527, NpcID.VANGUARD_7528, NpcID.VANGUARD_7529 -> if (config.vangHighlight()) {
                        OverlayUtil.renderPolygon(graphics, it.npc.convexHull, it.attackStyle.color!!)
                    }
                }
            }
            if (Olm.crippled) {
                val tick = Olm.crippleTicks
                val tickStr = tick.toString()
                val canvasPoint = Olm.hand?.getCanvasTextLocation(graphics, tickStr, 50)
                this.renderTextLocation(
                    graphics,
                    tickStr,
                    config.textSize(),
                    config.fontStyle().font,
                    Color.GRAY,
                    canvasPoint
                )
            }
            if (config.timers()) {
                if (Olm.victims.size > 0) {
                    Olm.victims.forEach(Consumer { victim: Victim ->
                        val ticksLeft = victim.ticks
                        var ticksLeftStr = ticksLeft.toString()
                        val tickcolor: Color
                        when (victim.type) {
                            Victim.Type.ACID -> if (ticksLeft > 0) {
                                tickcolor = if (ticksLeft > 1) {
                                    Color(69, 241, 44, 255)
                                } else {
                                    Color(255, 255, 255, 255)
                                }
                                val canvasPoint: Point? = victim.player.getCanvasTextLocation(graphics, ticksLeftStr, 0)
                                this.renderTextLocation(
                                    graphics,
                                    ticksLeftStr,
                                    config.textSize(),
                                    config.fontStyle().font,
                                    tickcolor,
                                    canvasPoint
                                )
                            }
                            Victim.Type.BURN -> if (ticksLeft > 0) {
                                if (GAP.contains(ticksLeft)) {
                                    tickcolor = Color(255, 0, 0, 255)
                                    ticksLeftStr = "GAP"
                                } else {
                                    tickcolor = Color(255, 255, 255, 255)
                                }
                                val canvasPoint: Point? = victim.player.getCanvasTextLocation(graphics, ticksLeftStr, 0)
                                this.renderTextLocation(
                                    graphics,
                                    ticksLeftStr,
                                    config.textSize(),
                                    config.fontStyle().font,
                                    tickcolor,
                                    canvasPoint
                                )
                            }
                            Victim.Type.TELEPORT -> if (config.tpOverlay()) {
                                if (ticksLeft > 0) {
                                    tickcolor = if (ticksLeft > 1) {
                                        Color(193, 255, 245, 255)
                                    } else {
                                        Color(255, 255, 255, 255)
                                    }
                                    val canvasPoint: Point? =
                                        victim.player.getCanvasTextLocation(graphics, ticksLeftStr, 0)
                                    this.renderTextLocation(
                                        graphics,
                                        ticksLeftStr,
                                        config.textSize(),
                                        config.fontStyle().font,
                                        tickcolor,
                                        canvasPoint
                                    )
                                }
                                renderActorOverlay(graphics, victim.player, Color(193, 255, 245, 255))
                            }
                        }
                    })
                }
            }
            if (Olm.active) {
                val head = Olm.head
                if (config.olmPShowPhase()) {
                    if (head != null) {
                        val color: Color = when (Olm.phaseType) {
                            PhaseType.ACID -> Color.GREEN
                            PhaseType.CRYSTAL -> Color.MAGENTA
                            PhaseType.FLAME -> Color.RED
                            PhaseType.UNKNOWN -> Color.BLACK
                        }
                        outliner.drawOutline(head, 2, color,3)
                    }
                }
                if (config.olmTick()) {
                    if (head != null) {
                        val tick = Olm.ticksUntilNextAttack
                        val cycle = Olm.attackCycle
                        val tickStr = tick.toString()
                        var cycleStr = "?"
                        when (cycle) {
                            4 -> when (Olm.specialCycle) {
                                1 -> cycleStr = "Crystals"
                                2 -> cycleStr = "Lightning"
                                3 -> cycleStr = "Portals"
                                4 -> cycleStr = "Heal"
                            }
                            3 -> cycleStr = "Sauto"
                            2 -> cycleStr = "Null"
                            1 -> cycleStr = "Nauto"
                            -1 -> cycleStr = "??"
                        }
                        val combinedStr = if (Olm.ticksUntilNextAttack >= 1) "$cycleStr:$tickStr" else "??:?"
                        val canvasPoint = head.getCanvasTextLocation(graphics, combinedStr, 130)
                        val color = if (cycle == 4) config.olmSpecialColor() else Color.WHITE
                        this.renderTextLocation(
                            graphics,
                            combinedStr,
                            config.textSize(),
                            config.fontStyle().font,
                            color,
                            canvasPoint
                        )
                    }
                }
            }
        }
        return null
    }

    private fun drawTile(graphics: Graphics2D, point: WorldPoint, color: Color?, strokeWidth: Int, outlineAlpha: Int) {
        val playerLocation = client.localPlayer!!.worldLocation
        if (point.distanceTo(playerLocation) >= 32) {
            return
        }
        val lp = LocalPoint.fromWorld(client, point) ?: return
        val poly = Perspective.getCanvasTilePoly(client, lp) ?: return
        //OverlayUtil.renderPolygon(graphics, poly, color);
        graphics.color = Color(color!!.red, color.green, color.blue, outlineAlpha)
        graphics.stroke = BasicStroke(strokeWidth.toFloat())
        graphics.draw(poly)
        graphics.color = Color(color.red, color.green, color.blue, 50)
        graphics.fill(poly)
    }

    private fun renderActorOverlay(graphics: Graphics2D, actor: Actor, color: Color) {
        val size = 1
        val lp = actor.localLocation
        val tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size)
        if (tilePoly != null) {
            graphics.color = Color(color.red, color.green, color.blue, 100)
            graphics.stroke = BasicStroke(2f)
            graphics.draw(tilePoly)
            graphics.color = Color(color.red, color.green, color.blue, 10)
            graphics.fill(tilePoly)
        }
    }

    private fun renderTextLocation(
        graphics: Graphics2D,
        txtString: String,
        fontSize: Int,
        fontStyle: Int,
        fontColor: Color?,
        canvasPoint: Point?
    ) {
        graphics.font = Font("Arial", fontStyle, fontSize)
        if (canvasPoint != null) {
            val canvasCenterPoint = Point(
                canvasPoint.x,
                canvasPoint.y
            )
            val canvasCenterPointInc = Point(
                canvasPoint.x + 1,
                canvasPoint.y + 1
            )
            if (config.shadows()) {
                OverlayUtil.renderTextLocation(graphics, canvasCenterPointInc, txtString, Color.BLACK)
            }
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor!!)
        }
    }

    private fun renderTextLocationAbove(
        graphics: Graphics2D,
        txtString: String,
        fontSize: Int,
        fontStyle: Int,
        fontColor: Color,
        canvasPoint: Point?
    ) {
        graphics.font = Font("Arial", fontStyle, fontSize)
        if (canvasPoint != null) {
            val canvasCenterPoint = Point(
                canvasPoint.x,
                canvasPoint.y + 20
            )
            val canvasCenterPointInc = Point(
                canvasPoint.x + 1,
                canvasPoint.y + 21
            )
            if (config.shadows()) {
                OverlayUtil.renderTextLocation(graphics, canvasCenterPointInc, txtString, Color.BLACK)
            }
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor)
        }
    }

    private fun getHitSquares(
        npcLoc: WorldPoint,
        npcSize: Int,
        thickness: Int,
        includeUnder: Boolean
    ): List<WorldPoint> {
        val little = WorldArea(npcLoc, npcSize, npcSize).toWorldPointList()
        val big = WorldArea(
            npcLoc.x - thickness,
            npcLoc.y - thickness,
            npcSize + thickness * 2,
            npcSize + thickness * 2,
            npcLoc.plane
        ).toWorldPointList()
        if (!includeUnder) {
            big.removeIf { o: WorldPoint -> little.contains(o) }
        }
        return big
    }

    companion object {
        private val GAP: Set<Int> = ImmutableSet.of(34, 33, 26, 25, 18, 17, 10, 9, 2, 1)
    }
}