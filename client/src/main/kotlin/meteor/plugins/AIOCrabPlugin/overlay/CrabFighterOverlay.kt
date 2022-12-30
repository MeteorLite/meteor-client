package meteor.plugins.AIOCrabPlugin.overlay

import meteor.plugins.AIOCrabPlugin.CrabFighterPlugin
import meteor.ui.overlay.Overlay
import java.awt.Dimension
import java.awt.Graphics2D

class CrabFighterOverlay(var plugin: CrabFighterPlugin) : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        client.localPlayer?.let { graphics.drawString(it.name, 0, 0) }
        graphics.drawString("", 10,0)
        return null
    }
}