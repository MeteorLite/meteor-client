package meteor.plugins.indicators

import meteor.ui.overlay.Overlay
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point

class IndicatorsOverlay(val config: IndicatorsConfig) : Overlay() {
    val tileItemPiles = HashMap<Point, Int>()

    fun init() {

    }
    override fun render(graphics: Graphics2D): Dimension? {
        if (config.drawPlayerName() || config.drawPlayerBounds())
            for (player in client.players.filterNotNull()) {
                player.bounds?.let {
                    graphics.color = if (player == client.localPlayer) config.localPlayerColor() else config.playerColor()
                    if (config.drawPlayerName() && player != client.localPlayer
                            || config.drawLocalPlayerName() && player == client.localPlayer)
                        player.name?.let { playerName ->
                            player.drawTextAboveBoundsShadowed(graphics, playerName)
                        }
                    if (config.drawPlayerBounds() && player != client.localPlayer
                            || config.drawLocalPlayerBounds() && player == client.localPlayer)
                        graphics.draw(it)
                }
            }
        if (config.drawNpcName() || config.drawNpcBounds())
            for (npc in client.npCs.filterNotNull()) {
                npc.bounds?.let {
                    graphics.color = config.npcColor()
                    if (config.drawNpcName())
                        npc.name?.let { npcName ->
                            npc.drawTextAboveBoundsShadowed(graphics, npcName)
                        }
                    if (config.drawNpcBounds())
                        graphics.draw(it)
                }
            }
        tileItemPiles.clear()
        if (config.drawTileItemName() || config.drawTileItemBounds())
            for (tileItemPoint in client.getTileItemQuantities()) {
                val point = tileItemPoint.key
                val tileItems = tileItemPoint.value
                for (tileItemKey in tileItems.keys.sortedBy { it.id }) {
                    val tileItemValue = tileItems[tileItemKey]!!

                    if (tileItemPiles[point] == null)
                        tileItemPiles[point] = 0
                    else
                        tileItemPiles[point] = tileItemPiles[point]!! + 1

                    tileItemKey.getBounds().let {
                        graphics.color = config.tileItemColor()
                        var text = client.itemNames[tileItemKey.id]
                        if (tileItemValue > 1)
                            text += " ($tileItemValue)"
                        text += " (${getValueText((client.getItemBasePrice(tileItemKey.id) * tileItemValue))}gp)"
                        if (config.drawTileItemName())
                            tileItemKey.drawTextAboveBoundsShadowed(graphics, text, tileItemPiles[point]!!)
                        if (config.drawTileItemBounds())
                            graphics.draw(it)
                    }
                }
            }
        return null
    }

    fun getValueText(value: Int): String {
        return if (value < 10000)
            "$value"
        else
            "%.2f".format(value)
    }
}