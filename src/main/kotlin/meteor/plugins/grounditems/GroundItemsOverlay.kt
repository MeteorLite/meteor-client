/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.grounditems

import meteor.plugins.grounditems.config.DespawnTimerMode
import meteor.plugins.grounditems.config.ItemHighlightMode
import meteor.plugins.grounditems.config.PriceDisplayMode
import meteor.ui.components.ProgressPieComponent
import meteor.ui.components.TextComponent
import meteor.ui.overlay.BackgroundComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.OverlayUtil
import meteor.util.QuantityFormatter.quantityToStackSize
import net.runelite.api.Client
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.*
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.AbstractMap.SimpleEntry

class GroundItemsOverlay(var plugin: GroundItemsPlugin, var config: GroundItemsConfig) : Overlay() {
    private val itemStringBuilder = StringBuilder()
    private val backgroundComponent = BackgroundComponent()
    private val textComponent = TextComponent()
    private val progressPieComponent = ProgressPieComponent()
    private val offsetMap: MutableMap<WorldPoint?, Int> = HashMap()
    override fun render(graphics: Graphics2D): Dimension? {
        val dontShowOverlay =
            (config.itemHighlightMode() == ItemHighlightMode.MENU || config.itemHighlightMode() == ItemHighlightMode.NONE || plugin.hideAll) && !plugin.hotKeyPressed
        if (dontShowOverlay && !config.highlightTiles()) {
            return null
        }
        val fm = graphics.fontMetrics
        val player = client.localPlayer ?: return null
        offsetMap.clear()
        val localLocation = player.localLocation
        val mousePos = Point(client.mouseCanvasPosition.x - 5, client.mouseCanvasPosition.y)
        var groundItemList = GroundItemsPlugin.collectedGroundItems.values()
        var topGroundItem: GroundItem? = null
        if (plugin.hotKeyPressed) {
            // Make copy of ground items because we are going to modify them here, and the array list supports our
            // desired behaviour here
            groundItemList = ArrayList(groundItemList)
            val awtMousePos = java.awt.Point(mousePos.x, mousePos.y)
            var groundItem: GroundItem? = null
            for (item in groundItemList) {
                item.offset =
                    offsetMap.compute(item.location) { k: WorldPoint?, v: Int? -> if (v != null) v + 1 else 0 }!!
                if (groundItem != null) {
                    continue
                }
                if (plugin.textBoxBounds != null && item == plugin.textBoxBounds!!.value && plugin.textBoxBounds!!.key.contains(
                        awtMousePos
                    )
                ) {
                    groundItem = item
                    continue
                }
                if (plugin.hiddenBoxBounds != null && item == plugin.hiddenBoxBounds!!.value && plugin.hiddenBoxBounds!!.key.contains(
                        awtMousePos
                    )
                ) {
                    groundItem = item
                    continue
                }
                if (plugin.highlightBoxBounds != null && item == plugin.highlightBoxBounds!!.value && plugin.highlightBoxBounds!!.key.contains(
                        awtMousePos
                    )
                ) {
                    groundItem = item
                }
            }
            if (groundItem != null) {
                groundItemList.remove(groundItem)
                groundItemList.add(groundItem)
                topGroundItem = groundItem
            }
        }
        plugin.textBoxBounds = null
        plugin.hiddenBoxBounds = null
        plugin.highlightBoxBounds = null
        val onlyShowLoot = config.onlyShowLoot()
        val groundItemTimers = config.groundItemTimers()
        val outline = config.textOutline()
        for (item in groundItemList) {
            val groundPoint = LocalPoint.fromWorld(client, item.location)
            if (groundPoint == null || localLocation.distanceTo(groundPoint) > MAX_DISTANCE || onlyShowLoot && !item.isMine) {
                continue
            }
            val highlighted = plugin.getHighlighted(NamedQuantity(item.name!!), item.gePrice, item.haPrice)
            val hidden = plugin.getHidden(NamedQuantity(item.name!!), item.gePrice, item.haPrice, item.tradeable)
            if (highlighted == null && !plugin.hotKeyPressed) {
                // Do not display hidden items
                if (hidden != null) {
                    continue
                }

                // Do not display non-highlighted items
                if (config.showHighlightedOnly()) {
                    continue
                }
            }
            val color = plugin.getItemColor(highlighted, hidden)
            if (config.highlightTiles()) {
                val poly = Perspective.getCanvasTilePoly(client, groundPoint, item.height)
                if (poly != null) {
                    OverlayUtil.renderPolygon(graphics, poly, color!!)
                }
            }
            if (dontShowOverlay) {
                continue
            }
            itemStringBuilder.append(item.name)
            if (item.quantity > 1) {
                if (item.quantity >= GroundItemsPlugin.MAX_QUANTITY) {
                    itemStringBuilder.append(" (Lots!)")
                } else {
                    itemStringBuilder.append(" (")
                        .append(quantityToStackSize(item.quantity.toLong()))
                        .append(")")
                }
            }
            if (config.priceDisplayMode() == PriceDisplayMode.BOTH) {
                if (item.gePrice > 0) {
                    itemStringBuilder.append(" (GE: ")
                        .append(quantityToStackSize(item.gePrice.toLong()))
                        .append(" gp)")
                }
                if (item.haPrice > 0) {
                    itemStringBuilder.append(" (HA: ")
                        .append(quantityToStackSize(item.haPrice.toLong()))
                        .append(" gp)")
                }
            } else if (config.priceDisplayMode() != PriceDisplayMode.OFF) {
                val price = if (config.priceDisplayMode() == PriceDisplayMode.GE) item.gePrice else item.haPrice
                if (price > 0) {
                    itemStringBuilder
                        .append(" (")
                        .append(quantityToStackSize(price.toLong()))
                        .append(" gp)")
                }
            }
            val itemString = itemStringBuilder.toString()
            itemStringBuilder.setLength(0)
            val textPoint = Perspective.getCanvasTextLocation(
                client,
                graphics,
                groundPoint,
                itemString,
                item.height + OFFSET_Z
            ) ?: continue
            val offset =
                if (plugin.hotKeyPressed) item.offset else offsetMap.compute(item.location) { k: WorldPoint?, v: Int? -> if (v != null) v + 1 else 0 }!!
            val textX = textPoint.x
            val textY = textPoint.y - STRING_GAP * offset
            if (plugin.hotKeyPressed) {
                val stringWidth = fm.stringWidth(itemString)
                val stringHeight = fm.height

                // Item bounds
                var x = textX - 2
                var y = textY - stringHeight - 2
                var width = stringWidth + 4
                var height = stringHeight + 4
                val itemBounds = Rectangle(x, y, width, height)

                // Hidden box
                x += width + 2
                y = textY - (RECTANGLE_SIZE + stringHeight) / 2
                height = RECTANGLE_SIZE
                width = height
                val itemHiddenBox = Rectangle(x, y, width, height)

                // Highlight box
                x += width + 2
                val itemHighlightBox = Rectangle(x, y, width, height)
                val mouseInBox = itemBounds.contains(mousePos.x, mousePos.y)
                val mouseInHiddenBox = itemHiddenBox.contains(mousePos.x, mousePos.y)
                val mouseInHighlightBox = itemHighlightBox.contains(mousePos.x, mousePos.y)
                if (mouseInBox) {
                    plugin.textBoxBounds = SimpleEntry(itemBounds, item)
                } else if (mouseInHiddenBox) {
                    plugin.hiddenBoxBounds = SimpleEntry(itemHiddenBox, item)
                } else if (mouseInHighlightBox) {
                    plugin.highlightBoxBounds = SimpleEntry(itemHighlightBox, item)
                }
                val topItem = topGroundItem == item

                // Draw background if hovering
                if (topItem && (mouseInBox || mouseInHiddenBox || mouseInHighlightBox)) {
                    backgroundComponent.rectangle = itemBounds
                    backgroundComponent.render(graphics)
                }

                // Draw hidden box
                (if (topItem && mouseInHiddenBox) Color.RED else color)?.let {
                    drawRectangle(
                        graphics,
                        itemHiddenBox,
                        it,
                        hidden != null,
                        true
                    )
                }

                // Draw highlight box
                (if (topItem && mouseInHighlightBox) Color.GREEN else color)?.let {
                    drawRectangle(
                        graphics,
                        itemHighlightBox,
                        it,
                        highlighted != null,
                        false
                    )
                }
            }

            // When the hotkey is pressed the hidden/highlight boxes are drawn to the right of the text,
            // so always draw the pie since it is on the left hand side.
            if (groundItemTimers == DespawnTimerMode.PIE || plugin.hotKeyPressed) {
                drawTimerPieOverlay(graphics, textX, textY, item)
            } else if (groundItemTimers == DespawnTimerMode.SECONDS || groundItemTimers == DespawnTimerMode.TICKS) {
                val despawnTime = calculateDespawnTime(item)
                val timerColor = getItemTimerColor(item)
                if (despawnTime != null && timerColor != null) {
                    val despawnTimeMillis = despawnTime.toEpochMilli() - Instant.now().toEpochMilli()
                    val timerText: String
                    timerText = if (groundItemTimers == DespawnTimerMode.SECONDS) {
                        String.format(" - %.1f", despawnTimeMillis / 1000f)
                    } else  // TICKS
                    {
                        String.format(" - %d", despawnTimeMillis / 600)
                    }

                    // The timer text is drawn separately to have its own color, and is intentionally not included
                    // in the getCanvasTextLocation() call because the timer text can change per frame and we do not
                    // use a monospaced font, which causes the text location on screen to jump around slightly each frame.
                    textComponent.text = timerText
                    textComponent.color = timerColor
                    textComponent.outline = outline
                    textComponent.position = java.awt.Point(textX + fm.stringWidth(itemString), textY)
                    textComponent.render(graphics)
                }
            }
            textComponent.text = itemString
            textComponent.color = color
            textComponent.outline = outline
            textComponent.position = java.awt.Point(textX, textY)
            textComponent.render(graphics)
        }
        return null
    }

    private fun calculateDespawnTime(groundItem: GroundItem): Instant? {
        // We can only accurately guess despawn times for our own pvm loot, dropped items,
        // and items we placed on tables
        if (groundItem.lootType !== LootType.PVM && groundItem.lootType !== LootType.DROPPED && groundItem.lootType !== LootType.TABLE) {
            return null
        }

        // Loot appears to others after 1 minute, and despawns after 2 minutes
        // Dropped items appear to others after 1 minute, and despawns after 3 minutes
        // Items in instances never appear to anyone and despawn after 30 minutes
        val spawnTime = groundItem.spawnTime ?: return null
        val despawnTime: Instant
        val now = Instant.now()
        despawnTime = if (client.isInInstancedRegion) {
            val playerRegionID = WorldPoint.fromLocalInstance(client, client.localPlayer!!.localLocation).regionID
            if (playerRegionID == KRAKEN_REGION) {
                // Items in the Kraken instance never despawn
                return null
            } else if (playerRegionID == KBD_NMZ_REGION) {
                // NMZ and the KBD lair uses the same region ID but NMZ uses planes 1-3 and KBD uses plane 0
                if (client.localPlayer!!.worldLocation.plane == 0) {
                    // Items in the KBD instance use the standard despawn timer
                    spawnTime.plus(if (groundItem.lootType === LootType.DROPPED) DESPAWN_TIME_DROP else DESPAWN_TIME_LOOT)
                } else {
                    if (groundItem.lootType === LootType.DROPPED) {
                        // Dropped items in the NMZ instance never despawn
                        return null
                    } else {
                        spawnTime.plus(DESPAWN_TIME_LOOT)
                    }
                }
            } else if (playerRegionID == ZILYANA_REGION || playerRegionID == GRAARDOR_REGION || playerRegionID == KRIL_TSUTSAROTH_REGION || playerRegionID == KREEARRA_REGION || playerRegionID == NIGHTMARE_REGION || playerRegionID == TEMPOROSS_REGION) {
                // GWD, Nightmare, and Tempoross instances use the normal despawn timers
                spawnTime.plus(if (groundItem.lootType === LootType.DROPPED) DESPAWN_TIME_DROP else DESPAWN_TIME_LOOT)
            } else {
                spawnTime.plus(DESPAWN_TIME_INSTANCE)
            }
        } else {
            when (groundItem.lootType) {
                LootType.DROPPED -> spawnTime.plus(DESPAWN_TIME_DROP)
                LootType.TABLE -> spawnTime.plus(DESPAWN_TIME_TABLE)
                else -> spawnTime.plus(DESPAWN_TIME_LOOT)
            }
        }
        return if (now.isBefore(spawnTime) || now.isAfter(despawnTime)) {
            // that's weird
            null
        } else despawnTime
    }

    private fun getItemTimerColor(groundItem: GroundItem): Color? {
        // We can only accurately guess despawn times for our own pvm loot, dropped items,
        // and items we placed on tables
        if (groundItem.lootType !== LootType.PVM && groundItem.lootType !== LootType.DROPPED && groundItem.lootType !== LootType.TABLE) {
            return null
        }
        val spawnTime = groundItem.spawnTime ?: return null
        val now = Instant.now()

        // If it has not yet been a minute, the item is private
        return if (client.isInInstancedRegion || spawnTime.plus(1, ChronoUnit.MINUTES).isAfter(now)) {
            PRIVATE_TIMER_COLOR
        } else {
            PUBLIC_TIMER_COLOR
        }
    }

    private fun drawTimerPieOverlay(graphics: Graphics2D, textX: Int, textY: Int, groundItem: GroundItem) {
        val now = Instant.now()
        val spawnTime = groundItem.spawnTime
        val despawnTime = calculateDespawnTime(groundItem)
        val fillColor = getItemTimerColor(groundItem)
        if (spawnTime == null || despawnTime == null || fillColor == null) {
            return
        }
        val percent =
            (now.toEpochMilli() - spawnTime.toEpochMilli()).toFloat() / (despawnTime.toEpochMilli() - spawnTime.toEpochMilli())
        progressPieComponent.diameter = TIMER_OVERLAY_DIAMETER
        // Shift over to not be on top of the text
        val x = textX - TIMER_OVERLAY_DIAMETER
        val y = textY - TIMER_OVERLAY_DIAMETER / 2
        progressPieComponent.position = Point(x, y)
        progressPieComponent.fill = fillColor
        progressPieComponent.borderColor = fillColor
        progressPieComponent.progress = (1 - percent).toDouble() // inverse so pie drains over time
        progressPieComponent.render(graphics)
    }

    private fun drawRectangle(
        graphics: Graphics2D,
        rect: Rectangle,
        color: Color,
        inList: Boolean,
        hiddenBox: Boolean
    ) {
        graphics.color = Color.BLACK
        graphics.drawRect(rect.x + 1, rect.y + 1, rect.width, rect.height)
        graphics.color = color
        graphics.draw(rect)
        if (inList) {
            graphics.fill(rect)
        }
        graphics.color = Color.WHITE
        // Minus symbol
        graphics.drawLine(
            rect.x + 2,
            rect.y + rect.height / 2,
            rect.x + rect.width - 2,
            rect.y + rect.height / 2
        )
        if (!hiddenBox) {
            // Plus symbol
            graphics.drawLine(
                rect.x + rect.width / 2,
                rect.y + 2,
                rect.x + rect.width / 2,
                rect.y + rect.height - 2
            )
        }
    }

    companion object {
        private const val MAX_DISTANCE = 2500

        // We must offset the text on the z-axis such that
        // it doesn't obscure the ground items below it.
        private const val OFFSET_Z = 20

        // The 15 pixel gap between each drawn ground item.
        private const val STRING_GAP = 15

        // Size of the hidden/highlight boxes
        private const val RECTANGLE_SIZE = 8
        private val PUBLIC_TIMER_COLOR = Color.YELLOW
        private val PRIVATE_TIMER_COLOR = Color.GREEN
        private const val TIMER_OVERLAY_DIAMETER = 10
        private val DESPAWN_TIME_INSTANCE = Duration.ofMinutes(30)
        private val DESPAWN_TIME_LOOT = Duration.ofMinutes(2)
        private val DESPAWN_TIME_DROP = Duration.ofMinutes(3)
        private val DESPAWN_TIME_TABLE = Duration.ofMinutes(10)
        private const val KRAKEN_REGION = 9116
        private const val KBD_NMZ_REGION = 9033
        private const val ZILYANA_REGION = 11602
        private const val GRAARDOR_REGION = 11347
        private const val KRIL_TSUTSAROTH_REGION = 11603
        private const val KREEARRA_REGION = 11346
        private const val NIGHTMARE_REGION = 15515
        private const val TEMPOROSS_REGION = 12078
    }

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        this.plugin = plugin
        this.config = config
    }
}