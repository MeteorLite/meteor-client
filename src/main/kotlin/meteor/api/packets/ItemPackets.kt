package meteor.api.packets

import meteor.api.widgets.Widgets
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.widgets.WidgetInfo

object ItemPackets {
    fun itemAction(item: Item, action: String) {
        val actions = item.actions
        val index = actions.indexOf(action)
        when (index) {
            0 -> itemFirstOption(item)
            1 -> itemSecondOption(item)
            2 -> itemThirdOption(item)
            3 -> itemFourthOption(item)
            4 -> itemFifthOption(item)
            else -> WidgetPackets.widgetAction(Widgets.fromId(item.widgetId)!!, action)
        }
    }

    fun itemFirstOption(item: Item) {
        queueItemAction1Packet(item.widgetId, item.id, item.slot)
    }

    fun itemSecondOption(item: Item) {
        queueItemAction2Packet(item.widgetId, item.id, item.slot)
    }

    fun itemThirdOption(item: Item) {
        queueItemAction3Packet(item.widgetId, item.id, item.slot)
    }

    fun itemFourthOption(item: Item) {
        queueItemAction4Packet(item.widgetId, item.id, item.slot)
    }

    fun itemFifthOption(item: Item) {
        queueItemAction5Packet(item.widgetId, item.id, item.slot)
    }

    fun useItemOnItem(item: Item, item2: Item) {
        if (item.type.inventoryID != InventoryID.INVENTORY || item2.type.inventoryID != InventoryID.INVENTORY) {
            return
        }
        queueItemOnItemPacket(item.id, item.slot, item2.id, item2.slot)
    }

    fun queueItemOnItemPacket(sourceItemId: Int, sourceItemSlot: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELDU(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeIntLE(WidgetInfo.INVENTORY.id)
        packetBufferNode.packetBuffer.writeInt(WidgetInfo.INVENTORY.id)
        packetBufferNode.packetBuffer.writeShortLE(sourceItemSlot)
        packetBufferNode.packetBuffer.writeShortLE(sourceItemId)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        packetBufferNode.packetBuffer.writeShortAddLE(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueSpellOnItemPacket(itemId: Int, itemSlot: Int, spellWidgetId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELDT(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(itemId)
        packetBufferNode.packetBuffer.writeShort(-1)
        packetBufferNode.packetBuffer.writeInt(spellWidgetId)
        packetBufferNode.packetBuffer.writeIntIME(WidgetInfo.INVENTORY.id)
        packetBufferNode.packetBuffer.writeShortLE(itemSlot)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueItemAction1Packet(itemWidgetId: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELD1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(itemSlot)
        packetBufferNode.packetBuffer.writeShortLE(itemId)
        packetBufferNode.packetBuffer.writeInt(itemWidgetId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueItemAction2Packet(itemWidgetId: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELD2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(itemSlot)
        packetBufferNode.packetBuffer.writeIntME(itemWidgetId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueItemAction3Packet(itemWidgetId: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELD3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeIntIME(itemWidgetId)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        packetBufferNode.packetBuffer.writeShortAddLE(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueItemAction4Packet(itemWidgetId: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELD4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(itemWidgetId)
        packetBufferNode.packetBuffer.writeShortLE(itemId)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueItemAction5Packet(itemWidgetId: Int, itemId: Int, itemSlot: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPHELD5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        packetBufferNode.packetBuffer.writeShortLE(itemId)
        packetBufferNode.packetBuffer.writeInt(itemWidgetId)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}