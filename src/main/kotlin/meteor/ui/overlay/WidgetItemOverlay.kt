/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package meteor.ui.overlay

import Main.overlayManager
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.widgets.WidgetItem
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle
import java.util.*

abstract class WidgetItemOverlay protected constructor() : Overlay() {

    abstract fun renderItemOverlay(graphics: Graphics2D?, itemId: Int, widgetItem: WidgetItem?)

    override fun render(graphics: Graphics2D): Dimension? {
        val widgetItems: Collection<WidgetItem> = overlayManager.widgetItems
        val originalClipBounds: Rectangle = graphics.clipBounds
        var curClipParent: Widget? = null
        for (widgetItem in widgetItems) {
            val widget: Widget = widgetItem.widget
            val parent = widget.parent
            val parentBounds = parent.bounds
            val itemCanvasBounds: Rectangle = widgetItem.canvasBounds
            val dragging = widgetItem.draggingCanvasBounds != null
            var shouldClip: Boolean
            if (dragging) {
                // If dragging, clip if the dragged item is outside of the parent bounds
                shouldClip = itemCanvasBounds.x < parentBounds.x
                shouldClip = shouldClip or (itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x + parentBounds.width)
                shouldClip = shouldClip or (itemCanvasBounds.y < parentBounds.y)
                shouldClip = shouldClip or (itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y + parentBounds.height)
            } else {
                // Otherwise, we only need to clip the overlay if it intersects the parent bounds,
                // since items completely outside of the parent bounds are not drawn
                shouldClip = (itemCanvasBounds.y < parentBounds.y
                        && itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y)
                shouldClip = shouldClip or (itemCanvasBounds.y < parentBounds.y + parentBounds.height
                        && itemCanvasBounds.y + itemCanvasBounds.height >= parentBounds.y + parentBounds.height)
                shouldClip = shouldClip or (itemCanvasBounds.x < parentBounds.x
                        && itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x)
                shouldClip = shouldClip or (itemCanvasBounds.x < parentBounds.x + parentBounds.width
                        && itemCanvasBounds.x + itemCanvasBounds.width >= parentBounds.x + parentBounds.width)
            }
            if (shouldClip) {
                if (curClipParent != parent) {
                    graphics.clip = parentBounds
                    curClipParent = parent
                }
            } else if (curClipParent != null && curClipParent != parent) {
                graphics.clip = originalClipBounds
                curClipParent = null
            }
            renderItemOverlay(graphics, widgetItem.id, widgetItem)
        }
        return null
    }

    protected fun showOnInventory() {
        showOnInterfaces(
                WidgetID.DEPOSIT_BOX_GROUP_ID,
                WidgetID.BANK_INVENTORY_GROUP_ID,
                WidgetID.SHOP_INVENTORY_GROUP_ID,
                WidgetID.GRAND_EXCHANGE_INVENTORY_GROUP_ID,
                WidgetID.GUIDE_PRICES_INVENTORY_GROUP_ID,
                WidgetID.EQUIPMENT_INVENTORY_GROUP_ID,
                WidgetID.INVENTORY_GROUP_ID,
                WidgetID.SEED_VAULT_INVENTORY_GROUP_ID,
                WidgetID.DUEL_INVENTORY_GROUP_ID,
                WidgetID.DUEL_INVENTORY_OTHER_GROUP_ID,
                WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID,
                WidgetID.PLAYER_TRADE_INVENTORY_GROUP_ID)
    }

    protected fun showOnBank() {
        drawAfterLayer(WidgetInfo.BANK_ITEM_CONTAINER)
    }

    protected fun showOnEquipment() {
        showOnInterfaces(WidgetID.EQUIPMENT_GROUP_ID)
    }

    protected fun showOnInterfaces(vararg ids: Int) {
        Arrays.stream(ids).forEach { interfaceId: Int -> drawAfterInterface(interfaceId) }
    }

    init {
        super.position = OverlayPosition.DYNAMIC
        super.priority = OverlayPriority.LOW
        super.layer = OverlayLayer.MANUAL
    }
}