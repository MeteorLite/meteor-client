/*
 * Copyright (c) 2018 kulers
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
package meteor.plugins.inventorytags

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import meteor.game.ItemManager
import meteor.ui.overlay.WidgetItemOverlay
import meteor.util.ColorUtil.colorWithAlpha
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetItem
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage

class InventoryTagsOverlay(
    private val plugin: InventoryTagsPlugin,
) : WidgetItemOverlay() {
    private val config = plugin.configuration<InventoryTagsConfig>()
    private val fillCache: Cache<Long, Image?>

    init {
        showOnEquipment()
        showOnItems()
        showOnInterfaces(
            WidgetID.CHAMBERS_OF_XERIC_STORAGE_UNIT_INVENTORY_GROUP_ID,
            WidgetID.CHAMBERS_OF_XERIC_STORAGE_UNIT_PRIVATE_GROUP_ID,
            WidgetID.CHAMBERS_OF_XERIC_STORAGE_UNIT_SHARED_GROUP_ID,
            WidgetID.GRAVESTONE_GROUP_ID
        )
        fillCache = CacheBuilder.newBuilder()
            .concurrencyLevel(1)
            .maximumSize(32)
            .build()
    }

    override fun renderItemOverlay(graphics: Graphics2D, itemId: Int, widgetItem: WidgetItem) {
        val group = plugin.getTag(itemId)
        if (group != null) {
            val color = plugin.getGroupNameColor(group)
            if (color != null) {
                val bounds = widgetItem.canvasBounds
                if (config.showTagOutline()) {
                    val outline = ItemManager.getItemOutline(itemId, widgetItem.quantity, color)
                    graphics.drawImage(outline, bounds.getX().toInt(), bounds.getY().toInt(), null)
                }
                if (config.showTagFill()) {
                    val image = getFillImage(color, widgetItem.id, widgetItem.quantity)
                    graphics.drawImage(image, bounds.getX().toInt(), bounds.getY().toInt(), null)
                }
                if (config.showTagUnderline()) {
                    val heightOffSet = bounds.getY().toInt() + bounds.getHeight().toInt() + 2
                    graphics.color = color
                    graphics.drawLine(
                        bounds.getX().toInt(),
                        heightOffSet,
                        bounds.getX().toInt() + bounds.getWidth().toInt(),
                        heightOffSet
                    )
                }
            }
        }
    }

    override fun fillImage(image: BufferedImage, color: Color): BufferedImage {
        val filledImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_ARGB)
        for (x in 0 until filledImage.width) {
            for (y in 0 until filledImage.height) {
                val pixel = image.getRGB(x, y)
                val a = pixel ushr 24
                if (a == 0) {
                    continue
                }
                filledImage.setRGB(x, y, color.rgb)
            }
        }
        return filledImage
    }

    private fun getFillImage(color: Color, itemId: Int, qty: Int): Image? {
        val key = itemId.toLong() shl 32 or qty.toLong()
        var image = fillCache.getIfPresent(key)
        if (image == null) {
            val fillColor = colorWithAlpha(color, config.fillOpacity())
            image = fillImage(ItemManager.getImage(itemId, qty, false)!!, fillColor)
            fillCache.put(key, image)
        }
        return image
    }

    fun invalidateCache() {
        fillCache.invalidateAll()
    }
}