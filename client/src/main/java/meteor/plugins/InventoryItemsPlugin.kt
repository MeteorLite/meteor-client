package meteor.plugins

import eventbus.events.InventoryUpdated

@PluginDescriptor(name = "Inventory Items Test", enabledByDefault = true)
class InventoryItemsPlugin : Plugin(){
    override fun onInventoryUpdated(it: InventoryUpdated) {
        for (item in it.inventoryItems) {
            //println("slot: ${item.slot} - ID: ${item.itemID} - quantity: ${item.quantity} - equipped: ${item.isEquipped == 1} - stackable: ${item.isStackable == 0}")
        }
    }
}