package meteor.plugins.meteor

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point

class AutoInteractOverlay(val config: MeteorConfig) : Overlay() {
    companion object {
        var interactPoint : Point? = null
        var lastInteractPoint : Point? = null
    }

    var lastInteractTime = 0L

    init {
        layer = OverlayLayer.ALWAYS_ON_TOP
    }
    override fun render(graphics: Graphics2D): Dimension? {
        if (lastInteractPoint != interactPoint) {
            lastInteractTime = System.currentTimeMillis()
            lastInteractPoint = interactPoint
        }
        if (config.drawAutoClicks())
            if (System.currentTimeMillis() < (lastInteractTime + 2000)) {
                interactPoint?.let {
                    graphics.color = Color.RED
                    graphics.drawLine(0, interactPoint!!.y-1, client.stretchedDimensions.width, interactPoint!!.y+1)
                    graphics.drawLine(interactPoint!!.x-1, 0, interactPoint!!.x+1, client.stretchedDimensions.height)
                }
            }
        return null
    }
}