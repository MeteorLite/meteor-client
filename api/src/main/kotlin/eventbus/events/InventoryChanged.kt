package eventbus.events

import meteor.Event

class InventoryChanged(var changeType: ChangeType, var itemId: Int, var amount: Int) : Event() {
    enum class ChangeType {
        ITEM_ADDED, ITEM_REMOVED
    }
}