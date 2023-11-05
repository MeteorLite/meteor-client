package meteor.plugins.inventorycount

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import net.runelite.api.Constants
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class InventoryCountOverlay : Overlay() {


    init {
        layer = OverlayLayer.ALWAYS_ON_TOP
    }

    override fun render(graphics: Graphics2D): Dimension? {
        graphics.color = Color.white

        val invRect = Rectangle(client.gameWidth - 35, 3, 32, 32)
        var itemsCarried = 0
        if (client.inventoryItems != null)
            itemsCarried = client.inventoryItems.size - 1
        if (itemsCarried == 30)
            graphics.color = Color.red
        else if (itemsCarried >= 27)
            graphics.color = Color.yellow

        val text = "$itemsCarried/30"
        val tWidth = graphics.fontMetrics.getStringBounds(text, graphics).width
        val tHeight = graphics.fontMetrics.getStringBounds(text, graphics).height + 6
        val padding = 32 - tWidth.toInt()
        graphics.drawString(text, invRect.x + (padding / 2) + 2, (invRect.y + 32) - tHeight.toInt())
        return null
    }
}