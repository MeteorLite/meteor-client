package eventbus.events

import net.runelite.api.InventoryItem

class InventoryUpdated(val inventoryItems: ArrayList<InventoryItem>) {
}