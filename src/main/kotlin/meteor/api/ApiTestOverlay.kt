package meteor.api

import meteor.api.entities.Loot
import meteor.api.entities.NPCs
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.ui.overlay.Overlay
import net.runelite.api.Perspective
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class ApiTestOverlay(var plugin: ApiTestPlugin) : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        graphics.color = Color.BLACK
        for (npc in NPCs.getAll("Captain Kalt")) {
            val hull = npc.convexHull
            hull?.let { graphics.draw(hull) }
        }
        graphics.color = Color.BLUE
        for (obj in Objects.getAll("Bank Deposit Box")) {
            val clickbox = obj.clickbox
            clickbox?.let { graphics.draw(clickbox) }
        }
        graphics.color = Color.CYAN
        for (loot in Loot.getAll("Manta ray")) {
            val tilePoly = Perspective.getCanvasTilePoly(client, loot.localLocation)
            tilePoly?.let { graphics.draw(tilePoly) }
        }
        graphics.color = Color.GREEN
        for (player in Players.getAll { it.localLocation != null }) {
            val hull = player.convexHull
            hull?.let { graphics.draw(hull) }
        }

        return null
    }
}