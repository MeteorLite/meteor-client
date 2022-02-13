package meteor.api

import Main.itemManager
import meteor.ui.overlay.ItemOverlayMode.*
import meteor.api.entities.Loot
import meteor.api.entities.NPCs
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.ui.overlay.ItemOverlayMode
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.WidgetItemOverlay
import net.runelite.api.Perspective
import net.runelite.api.widgets.WidgetItem
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class ApiTestOverlay(var plugin: ApiTestPlugin) : Overlay() {
    class ItemTestOverlay : WidgetItemOverlay(ITEMS, EQUIPMENT, BANK) {
        override fun renderItemOverlay(graphics: Graphics2D, itemId: Int, widgetItem: WidgetItem) {
            val bounds = widgetItem.canvasBounds!!
            bounds.let {
                val outline = itemManager.getItemOutline(itemId, widgetItem.quantity, Color.MAGENTA)
                outline.let {
                    graphics.drawImage(outline, bounds.getX().toInt(), bounds.getY().toInt(), null)
                }
            }
        }
    }

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