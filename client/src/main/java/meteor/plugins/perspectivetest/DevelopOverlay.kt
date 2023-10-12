package meteor.plugins.perspectivetest

import meteor.ui.overlay.Overlay
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class DevelopOverlay : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        graphics.color = Color.red
        val rectangle = Rectangle(client.localPlayer.screenX,client.localPlayer.screenY, client.localPlayer.screenWidth, client.localPlayer.screenHeight)
        val tWidth = graphics.fontMetrics.getStringBounds(client.username, graphics).width
        val padding = client.localPlayer.screenWidth - tWidth.toInt()
        graphics.drawString(client.username, client.localPlayer.screenX + (padding / 2), client.localPlayer.screenY)
        graphics.draw(rectangle)
        return null
    }
}