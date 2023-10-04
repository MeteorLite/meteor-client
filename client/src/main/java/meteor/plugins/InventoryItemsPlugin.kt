package meteor.plugins

import eventbus.events.InventoryUpdated

@PluginDescriptor(name = "Inventory Items Test", enabledByDefault = true)
class InventoryItemsPlugin : Plugin(){
    override fun onInventoryUpdated(it: InventoryUpdated) {
        for (slot in 0..<it.inventoryItems.size) {
            val item = it.inventoryItems[slot]
            println("slot: $slot - ID: ${item.itemID} - quantity: ${item.quantity} - equipped: ${item.isEquipped == 1} - stackable: ${item.isStackable == 0}")
        }
    }
}