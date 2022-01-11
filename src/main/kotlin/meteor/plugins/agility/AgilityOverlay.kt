package meteor.plugins.agility

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.*
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Shape

class AgilityOverlay(val plugin: AgilityPlugin) : Overlay() {
    private val MARK_OF_GRACE = "Mark of Grace"
    private val OFFSET_Z = 20
    private lateinit var overlayFillColor: Color
    private lateinit var activeColor: Color
    private lateinit var prevColor: Color
    private lateinit var prevOverlayFillColor: Color
    private var agilityShortcut: AgilityShortcut? = null

    init {
        position = OverlayPosition.DYNAMIC
    }

    override fun render(graphics: Graphics2D): Dimension? {
        activeColor = if (plugin.marks.size > 0) {
            Color.red
        } else {
            Color.cyan
        }
        overlayFillColor = Color(
            activeColor.darker().red, activeColor.darker().green,
            activeColor.darker().blue, 125
        )
        graphics.color = activeColor
        for (o in plugin.obstacles.keys) {
            prevColor = activeColor
            prevOverlayFillColor = overlayFillColor
            agilityShortcut = plugin.obstacles[o]?.shortcut
            if (agilityShortcut != null) {
                activeColor = if (agilityShortcut!!.level > client.getBoostedSkillLevel(Skill.AGILITY)) {
                    Color.red
                } else {
                    Color.green
                }
                prevOverlayFillColor = overlayFillColor
                overlayFillColor = Color(
                    activeColor.darker().red, activeColor.darker().green,
                    activeColor.darker().blue, 125
                )
            }
            paintClickBox(graphics, o.plane, o.clickbox)
            activeColor = prevColor
            overlayFillColor = prevOverlayFillColor
        }
        var p: Point?
        for (tile in plugin.marks) {
            if (tile.plane != client.plane) {
                continue
            }
            graphics.color = activeColor
            val poly = Perspective.getCanvasTileAreaPoly(client, tile.localLocation, 1)
            poly?.let { graphics.draw(poly) }
            graphics.color = Color.white
            p = Perspective
                .getCanvasTextLocation(
                    client, graphics, tile.localLocation, MARK_OF_GRACE,
                    OFFSET_Z
                )
            if (p != null) {
                drawShadowText(graphics, MARK_OF_GRACE, p.x, p.y)
            }
        }
        return null
    }

    private fun paintClickBox(graphics2D: Graphics2D, plane: Int, clickbox: Shape?) {
        if (plane == client.plane) {
            if (clickbox != null) {
                graphics2D.color = activeColor
                graphics2D.draw(clickbox)
                graphics2D.color = overlayFillColor
                graphics2D.fill(clickbox)
            }
        }
    }

    private fun drawShadowText(graphics: Graphics2D, s: String, x: Int, y: Int) {
        graphics.color = Color.black
        graphics.drawString(s, x, y + 1)
        graphics.drawString(s, x, y - 1)
        graphics.drawString(s, x + 1, y)
        graphics.drawString(s, x - 1, y)
        graphics.color = Color.white
        graphics.drawString(s, x, y)
        graphics.color = activeColor
    }
}