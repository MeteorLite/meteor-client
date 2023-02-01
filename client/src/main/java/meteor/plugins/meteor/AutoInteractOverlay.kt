package meteor.plugins.meteor

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point
import java.awt.Rectangle

class AutoInteractOverlay(val config: MeteorConfig) : Overlay() {
    companion object {
        var lastInteractPoint : Point? = null
    }

    init {
        layer = OverlayLayer.ALWAYS_ON_TOP
    }
    override fun render(graphics: Graphics2D): Dimension? {
        if (config.drawAutoClicks())
        lastInteractPoint?.let {
            graphics.color = Color.RED
            graphics.draw(Rectangle(it.x-1, it.y-1, 2, 2))
        }
        return null
    }
}