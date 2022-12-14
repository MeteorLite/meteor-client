package meteor.plugins.alchemicalhydra

import meteor.ui.overlay.*
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.Area

internal class HydraSceneOverlay (
    val plugin: AlchemicalHydraPlugin,
    private val config: HydraConfig
) : Overlay() {

    var poisonBorder: Color? = null

    var poisonFill: Color? = null

    var goodFountain: Color? = null

    var badFountain: Color? = null

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.UNDER_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val poisonProjectiles = plugin.poisonProjectiles
        if (config.counting() && poisonProjectiles.isNotEmpty()) {
            drawPoisonArea(graphics, poisonProjectiles)
        }
        if (config.fountain() && plugin.hydra?.phase?.fountain != null && plugin.hydra != null) {
            drawFountain(graphics, plugin.hydra!!)
        }
        return null
    }

    private fun drawPoisonArea(graphics: Graphics2D, poisonProjectiles: Map<LocalPoint, Projectile>) {
        val poisonTiles = Area()
        for ((point, value) in poisonProjectiles) {
            if (value.endCycle < client.gameCycle) {
                continue
            }
            val poly = Perspective.getCanvasTileAreaPoly(client, point, 3)
            if (poly != null) {
                poisonTiles.add(Area(poly))
            }
        }
        graphics.setPaintMode()
        graphics.color = poisonBorder
        graphics.draw(poisonTiles)
        graphics.color = poisonFill
        graphics.fill(poisonTiles)
    }

    private fun drawFountain(graphics: Graphics2D, hydra: Hydra) {
        val fountainWorldPoint = WorldPoint.toLocalInstance(client, hydra.phase.fountain)
        if (fountainWorldPoint.size > 1) {
            return
        }
        var wp: WorldPoint? = null
        for (p in fountainWorldPoint) {
            wp = p
        }
        val fountainPoint = if (wp == null) null else LocalPoint.fromWorld(client, wp)
        if (fountainPoint != null && !hydra.weakened) {
            val poly = Perspective.getCanvasTileAreaPoly(client, fountainPoint, 3)
            if (poly != null) {
                val color: Color? = if (hydra.npc.worldArea!!.intersectsWith(WorldArea(wp, 1, 1))) {
                    goodFountain
                } else {
                    badFountain
                }
                graphics.color = color
                graphics.stroke = BasicStroke(3F)
                graphics.draw(poly)
            }
        }
    }
}