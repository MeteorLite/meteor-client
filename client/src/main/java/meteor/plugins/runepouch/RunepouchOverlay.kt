/*
 * Copyright (c) 2017, Tyler <http://github.com/tylerthardy>
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package meteor.plugins.runepouch

import meteor.game.FontManager
import meteor.game.ItemManager
import meteor.ui.overlay.Tooltip
import meteor.ui.overlay.TooltipManager
import meteor.ui.overlay.WidgetItemOverlay
import meteor.util.ColorUtil
import meteor.util.OverlayUtil
import net.runelite.api.*
import net.runelite.api.annotations.Varbit
import net.runelite.api.widgets.WidgetItem
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.util.*

    class RunepouchOverlay(plugin:RunepouchPlugin) : WidgetItemOverlay() {
        private val config = plugin.configuration<RunepouchConfig>()
        private val tooltipManager = TooltipManager
        private val itemManager = ItemManager
        private var runeIcons: Array<BufferedImage?> = arrayOfNulls<BufferedImage>(0)

        init {
            showOnInventory()
            showOnBank()
        }

        override fun renderItemOverlay(graphics: Graphics2D, itemId: Int, widgetItem: WidgetItem) {
            if (itemId != ItemID.RUNE_POUCH && itemId != ItemID.RUNE_POUCH_L && itemId != ItemID.DIVINE_RUNE_POUCH && itemId != ItemID.DIVINE_RUNE_POUCH_L) {
                return
            }
            val runeIds = IntArray(NUM_SLOTS)
            val amounts = IntArray(NUM_SLOTS)
            val runepouchEnum = client.getEnum(EnumID.RUNEPOUCH_RUNE)
            var num = 0
            for (i in 0 until NUM_SLOTS) {
                @Varbit val amountVarbit = AMOUNT_VARBITS[i]
                val amount = client.getVarbitValue(amountVarbit)
                amounts[i] = amount
                @Varbit val runeVarbit = RUNE_VARBITS[i]
                val runeId = client.getVarbitValue(runeVarbit)
                runeIds[i] = runeId
                if (runeId != 0 && amount > 0) {
                    ++num
                }
            }
            if (num == 0) {
                return
            }
            val overlayMode: RunepouchConfig.RunepouchOverlayMode? = config.runePouchOverlayMode()
            if (overlayMode != RunepouchConfig.RunepouchOverlayMode.MOUSE_HOVER) {
                if (num < 4) {
                    renderList(graphics, widgetItem, runepouchEnum, runeIds, amounts)
                } else {
                    renderGrid(graphics, widgetItem, runepouchEnum, runeIds, amounts)
                }
            }
            val mousePos = client.mouseCanvasPosition
            if (widgetItem.getCanvasBounds().contains(mousePos.x, mousePos.y)
                && (overlayMode == RunepouchConfig.RunepouchOverlayMode.MOUSE_HOVER || overlayMode == RunepouchConfig.RunepouchOverlayMode.BOTH)
            ) {
                val tooltipBuilder = StringBuilder()
                for (i in 0 until NUM_SLOTS) {
                    val runeId = runeIds[i]
                    val amount = amounts[i]
                    if (runeId != 0 && amount > 0) {
                        val rune: ItemComposition? = itemManager.getItemComposition(runepouchEnum.getIntValue(runeId))
                        tooltipBuilder
                            .append(amount)
                            .append(' ')
                            .append(ColorUtil.wrapWithColorTag(rune!!.name, Color.YELLOW))
                            .append("</br>")
                    }
                }
                val tooltip = tooltipBuilder.toString()
                tooltipManager.add(Tooltip(tooltip))
            }
        }

        private fun renderList(
            graphics: Graphics2D,
            widgetItem: WidgetItem,
            runepouchEnum: EnumComposition,
            runeIds: IntArray,
            amounts: IntArray
        ) {
            graphics.font = FontManager.runescapeSmallFont
            val location: Point = widgetItem.canvasLocation
            var runeNum = -1
            for (i in 0 until NUM_SLOTS) {
                val runeId = runeIds[i]
                val amount = amounts[i]
                if (runeId == 0 || amount <= 0) {
                    continue
                }
                ++runeNum
                val text = formatNumber(amount)
                val textX = location.x + 11
                val textY: Int = location.y + 12 + (graphics.getFontMetrics().getHeight() - 1) * runeNum
                graphics.setColor(Color.BLACK)
                graphics.drawString(text, textX + 1, textY + 1)
                graphics.setColor(config.fontColor())
                graphics.drawString(text, textX, textY)
                val image: BufferedImage? = getRuneImage(runepouchEnum, runeId)
                if (image != null) {
                    OverlayUtil.renderImageLocation(
                        graphics,
                        Point(
                            location.x - 1,
                            location.y + graphics.getFontMetrics().getHeight() * runeNum - 1
                        ),
                        image
                    )
                }
            }
        }

        private fun renderGrid(
            graphics: Graphics2D,
            widgetItem: WidgetItem,
            runepouchEnum: EnumComposition,
            runeIds: IntArray,
            amounts: IntArray
        ) {
            val location: Point = widgetItem.getCanvasLocation()
            for (i in 0 until NUM_SLOTS) {
                val runeId = runeIds[i]
                val amount = amounts[i]
                if (runeId == -1 || amount <= 0) {
                    continue
                }
                val iconX: Int =
                    location.x + 2 + if (i == 1 || i == 3) IMAGE_SIZE.width + 2 /* pad */ + 2 /* bar offset */ else 0
                val iconY: Int = location.y + 5 + if (i >= 2) IMAGE_SIZE.height + 2 /* pad */ else 0
                val image: BufferedImage? = getRuneImage(runepouchEnum, runeId)
                if (image != null) {
                    OverlayUtil.renderImageLocation(
                        graphics,
                        Point(iconX, iconY),
                        image
                    )
                }
                val height: Int
                val color: Color
                if (amount < 1000) {
                    // with <1k runes, the bar is shown in red with 100 increments
                    height = amount / 100
                    color = Color.RED
                } else {
                    // with >=1k runes, the bar is shown in 1000 increments capped at 10k
                    height = Math.min(10, amount / 1000)
                    color = Color.GREEN
                }
                graphics.color = color
                graphics.fillRect(iconX + IMAGE_SIZE.width, iconY + 1 + (10 - height), 2, height)
            }
        }

        private fun getRuneImage(runepouchEnum: EnumComposition, runeId: Int): BufferedImage? {
            if (runeId < runeIcons.size && runeIcons[runeId] != null) {
                return runeIcons[runeId]
            }
            val runeImg: BufferedImage = itemManager.getImage(runepouchEnum.getIntValue(runeId)) ?: return null
            val resizedImg = BufferedImage(IMAGE_SIZE.width, IMAGE_SIZE.height, BufferedImage.TYPE_INT_ARGB)
            val g: Graphics2D = resizedImg.createGraphics()
            g.drawImage(runeImg, 0, 0, IMAGE_SIZE.width, IMAGE_SIZE.height, null)
            g.dispose()
            if (runeId >= runeIcons.size) {
                runeIcons = Arrays.copyOf<BufferedImage>(runeIcons, runeId + 1)
            }
            runeIcons[runeId] = resizedImg
            return resizedImg
        }

        companion object {
            private const val NUM_SLOTS = 4
            private val AMOUNT_VARBITS = intArrayOf(
                Varbits.RUNE_POUCH_AMOUNT1,
                Varbits.RUNE_POUCH_AMOUNT2,
                Varbits.RUNE_POUCH_AMOUNT3,
                Varbits.RUNE_POUCH_AMOUNT4
            )
            private val RUNE_VARBITS = intArrayOf(
                Varbits.RUNE_POUCH_RUNE1, Varbits.RUNE_POUCH_RUNE2, Varbits.RUNE_POUCH_RUNE3, Varbits.RUNE_POUCH_RUNE4
            )
            private val IMAGE_SIZE: Dimension = Dimension(11, 11)
            private fun formatNumber(amount: Int): String {
                return if (amount < 1000) amount.toString() else (amount / 1000).toString() + "K"
            }
        }
    }