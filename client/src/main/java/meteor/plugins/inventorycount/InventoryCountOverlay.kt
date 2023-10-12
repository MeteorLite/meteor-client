package meteor.plugins.inventorycount

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import net.runelite.api.Constants
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class InventoryCountOverlay : Overlay() {
    val invRect = Rectangle(Constants.GAME_FIXED_WIDTH - 35, 3, 32, 32)

    init {
        layer = OverlayLayer.ALWAYS_ON_TOP
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (client.isLoggedIn) {
            graphics.color = Color.red
            graphics.color = Color.white
            val itemsCarried = if (client.inventoryItems == null) 0 else client.inventoryItems.size
            val text = "$itemsCarried/30"
            val tWidth = graphics.fontMetrics.getStringBounds(text, graphics).width
            val tHeight = graphics.fontMetrics.getStringBounds(text, graphics).height + 6
            val padding = 32 - tWidth.toInt()
            graphics.drawString(text, invRect.x + (padding / 2) + 2, (invRect.y + 32) - tHeight.toInt())
        }
        return null
    }
}