package meteor.plugins.muspahassist

import meteor.api.NPCs
import meteor.api.Objects
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.ObjectID
import net.runelite.api.Point
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics2D

class MuspahAssistOverlay (
    val plugin:MuspahAssist,
    private val config: MuspahAssistConfig,
) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGH
        layer = OverlayLayer.ABOVE_SCENE
    }
    override fun render(graphics: Graphics2D): Dimension? {
        if (config.showOverlay()) {
            renderMuspahTile(graphics)
        }
        return null
    }

    private fun renderMuspahTile(graphics: Graphics2D) {
        val currentFont: Font = graphics.font
        val newFont: Font = currentFont.deriveFont(currentFont.size * 2f)
        var sb = StringBuilder()
        sb = sb.append(if (plugin.getTicks() >= 0) plugin.getTicks() else "")
        if (config.showOverlay() && Objects.getFirst(ObjectID.CREVICE_46599) != null) {
            val npcs = client.npcs
            for (npc in npcs) {
                var composition = npc.composition
                var color = if (composition!!.combatLevel > 1) config.overlayColor() else Color.RED
                if (composition.configs != null) {
                    val transformedComposition = composition.transform()
                    if (transformedComposition == null) {
                        color = config.overlayColor()
                    } else {
                        composition = transformedComposition
                    }
                }
                val text = ""
                graphics.font = newFont
                val textLoc = npc.getCanvasTextLocation(graphics, text, npc.logicalHeight - 130)
                OverlayUtil.renderActorOverlay(graphics, npc, text, color)
                if (textLoc != null) {
                    OverlayUtil.renderTextLocation(graphics, textLoc, sb.toString(), config.overlayColor() )
                }
            }
        }
    }
}