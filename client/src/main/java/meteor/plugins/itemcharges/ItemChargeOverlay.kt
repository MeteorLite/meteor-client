/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
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
package meteor.plugins.itemcharges

import meteor.game.FontManager.runescapeSmallFont
import meteor.ui.components.TextComponent
import meteor.ui.overlay.WidgetItemOverlay
import net.runelite.api.widgets.WidgetItem
import java.awt.Graphics2D
import java.awt.Point

internal class ItemChargeOverlay(private val itemChargePlugin: ItemChargePlugin, private val config: ItemChargeConfig) :
    WidgetItemOverlay() {
    init {
        showOnInventory()
        showOnEquipment()
    }

    override fun renderItemOverlay(graphics: Graphics2D, itemId: Int, widgetItem: WidgetItem) {
        val charges: Int
        val itemWithConfig: ItemWithConfig? = ItemWithConfig.findItem(itemId)
        charges = if (itemWithConfig != null) {
            if (!itemWithConfig.type?.enabled!!.test(config)) {
                return
            }
            itemChargePlugin.getItemCharges(itemWithConfig.configKey)
        } else {
            val chargeItem: ItemWithCharge = ItemWithCharge.findItem(itemId) ?: return
            val type = chargeItem.type
            if (!type?.enabled!!.test(config)) {
                return
            }
            chargeItem.charges
        }
        graphics.font = runescapeSmallFont
        val bounds = widgetItem.canvasBounds
        val textComponent = TextComponent()
        textComponent.position = Point(bounds.x - 1, bounds.y + 15)
        textComponent.text = if (charges < 0) "?" else charges.toString()
        textComponent.color = itemChargePlugin.getColor(charges)
        textComponent.render(graphics)
    }
}