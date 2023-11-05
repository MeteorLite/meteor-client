package meteor.plugins.indicators

import meteor.ui.overlay.Overlay
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


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
                            if (npc.message.isNullOrEmpty())
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
                            text += " x$tileItemValue"
                        val itemStackValue = (client.getItemBasePrice(tileItemKey.id) * tileItemValue).toDouble()
                        if (itemStackValue >= lowValuePrice())
                            graphics.color = lowValueColor()
                        if (itemStackValue >= mediumValuePrice())
                            graphics.color = mediumValueColor()
                        if (itemStackValue >= highValuePrice())
                            graphics.color = highValueColor()
                        if (itemStackValue >= insaneValuePrice())
                            graphics.color = insaneValueColor()
                        text += " (${prettyCount(itemStackValue)})"
                        if (config.drawTileItemName())
                            tileItemKey.drawTextAboveBoundsShadowed(graphics, text, tileItemPiles[point]!!)
                        if (config.drawTileItemBounds())
                            graphics.draw(it)
                    }
                }
            }
        if (config.drawLocalPlayerTile()) {
            graphics.color = Color.cyan
            Perspective.getCanvasTilePoly(client, client.localPlayer.localLocation).let {
                graphics.draw(it)
            }
        }
        return null
    }

    fun prettyCount(number: Number): String {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue = number.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.0").format(numValue / 10.toDouble().pow((base * 3).toDouble())) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(numValue)
        }
    }
    fun lowValuePrice(): Int {
        return 10000
    }

    fun lowValueColor(): Color {
        return Color.decode("#66B2FF")
    }

    fun mediumValuePrice(): Int {
        return 50000
    }

    fun mediumValueColor(): Color {
        return Color.decode("#99FF99")
    }

    fun highValuePrice(): Int {
        return 350000
    }

    fun highValueColor(): Color {
        return Color.decode("#FF9600")
    }

    fun insaneValuePrice(): Int {
        return 2000000
    }

    fun insaneValueColor(): Color {
        return Color.decode("#FF66B2")
    }
}