package events

class UpdateInventoryPacket {
    var inventorySize = -1
    var inventoryItemsIDs: IntArray? = null
    var inventoryItemsEquipped: IntArray? = null
    var inventoryItemsStackable: IntArray? = null
    var inventoryItemsQuantities: IntArray? = null
}
