package meteor.plugins.barrowsdoorhighlighter

import meteor.ui.overlay.Overlay
import net.runelite.api.ObjectComposition
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Shape


class BarrowsDoorHighlighterOverlay(var plugin: BarrowsDoorHighlighter) :
    Overlay() {
    val config = plugin.config

    override fun render(graphics: Graphics2D): Dimension? {
        if (client.plane == 0 && config.highlightDoors() != BarrowsDoorHighlighterConfig.HighlightDoors.NEITHER) {
            renderDoors(graphics)
        }
        return null
    }

    private fun renderDoors(graphics: Graphics2D) {
        for (door in plugin.doors) {
            val objectComp: ObjectComposition = client.getObjectDefinition(door.id)
            val impostor: ObjectComposition? =
                if (objectComp.impostorIds != null) objectComp.impostor else null
            if (impostor != null) {
                val polygon: Shape?
                val isUnlockedDoor = impostor.actions[0] != null
                val color: Color? = if (isUnlockedDoor) config.unlockedDoorColor() else config.lockedDoorColor()
                if (config.highlightDoors() !== BarrowsDoorHighlighterConfig.HighlightDoors.UNLOCKED && !isUnlockedDoor || config.highlightDoors() !== BarrowsDoorHighlighterConfig.HighlightDoors.LOCKED && isUnlockedDoor) {
                    polygon = door.convexHull
                    if (polygon != null) {
                        if (color != null) {
                            renderPolygon(graphics, polygon, color)
                        }
                    }
                }
            }
        }
    }
}