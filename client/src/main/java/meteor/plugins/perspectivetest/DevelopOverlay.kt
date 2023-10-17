package meteor.plugins.perspectivetest

import meteor.ui.overlay.Overlay
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class DevelopOverlay : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        for (player in client.players.filterNotNull()) {
            player.bounds?.let {
                graphics.color = if (player == client.localPlayer) Color.blue else Color.red
                player.name?.let { playerName ->
                    player.drawTextAboveBoundsShadowed(graphics, playerName)
                }
                graphics.draw(it)
            }
        }
        for (npc in client.npCs.filterNotNull()) {
            npc.bounds?.let {
                graphics.color = Color.yellow
                npc.name?.let { npcName ->
                    npc.drawTextAboveBoundsShadowed(graphics, npcName)
                }
                graphics.draw(it)
            }
        }
        return null
    }
}