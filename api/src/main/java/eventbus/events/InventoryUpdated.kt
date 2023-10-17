package eventbus.events

import net.runelite.api.Item

class InventoryUpdated(val inventoryItems: ArrayList<Item>) {
}