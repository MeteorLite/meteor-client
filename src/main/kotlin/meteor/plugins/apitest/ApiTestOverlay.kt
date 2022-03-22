package meteor.plugins.apitest

import meteor.ui.overlay.Overlay
import java.awt.Dimension
import java.awt.Graphics2D

class ApiTestOverlay(var plugin: ApiTestPlugin) : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        plugin.nearestTarget?.let { target -> target.convexHull?.let { graphics.draw(it) } }
        return null
    }
}