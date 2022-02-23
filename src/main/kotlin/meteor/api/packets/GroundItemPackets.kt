package meteor.api.packets

import net.runelite.api.TileItem
import net.runelite.api.packets.PacketBufferNode

object GroundItemPackets {
    fun groundItemFirstOption(item: TileItem, ctrlDown: Boolean) {
        queueGroundItemAction1Packet(
            item.id,
            item.worldLocation.x,
            item.worldLocation.y,
            ctrlDown
        )
    }

    fun groundItemSecondOption(item: TileItem, ctrlDown: Boolean) {
        queueGroundItemAction2Packet(
            item.id,
            item.worldLocation.x,
            item.worldLocation.y,
            ctrlDown
        )
    }

    fun groundItemThirdOption(item: TileItem, ctrlDown: Boolean) {
        queueGroundItemAction3Packet(
            item.id,
            item.worldLocation.x,
            item.worldLocation.y,
            ctrlDown
        )
    }

    fun groundItemFourthOption(item: TileItem, ctrlDown: Boolean) {
        queueGroundItemAction4Packet(
            item.id,
            item.worldLocation.x,
            item.worldLocation.y,
            ctrlDown
        )
    }

    fun groundItemFifthOption(item: TileItem, ctrlDown: Boolean) {
        queueGroundItemAction5Packet(
            item.id,
            item.worldLocation.x,
            item.worldLocation.y,
            ctrlDown
        )
    }

    fun groundItemAction(item: TileItem, action: String, ctrlDown: Boolean) {
        val actions: List<String> = item.actions
        val index = actions.indexOf(action)
        when (index) {
            0 -> groundItemFirstOption(item, ctrlDown)
            1 -> groundItemSecondOption(item, ctrlDown)
            2 -> groundItemThirdOption(item, ctrlDown)
            3 -> groundItemFourthOption(item, ctrlDown)
            4 -> groundItemFifthOption(item, ctrlDown)
        }
    }

    fun queueItemUseOnGroundObjectPacket(
        groundItemId: Int,
        worldPointX: Int,
        worldPointY: Int,
        itemSlot: Int,
        itemId: Int,
        itemWidgetId: Int,
        ctrlDown: Boolean
    ) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJU(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShortAddLE(itemSlot)
        packetBufferNode.packetBuffer.writeShortAddLE(groundItemId)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeIntLE(itemWidgetId)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAddLE(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueSpellOnGroundObjectPacket(
        groundItemId: Int,
        worldPointX: Int,
        worldPointY: Int,
        spellWidgetId: Int,
        ctrlDown: Boolean
    ) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJT(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(spellWidgetId)
        packetBufferNode.packetBuffer.writeShortAddLE(worldPointY)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAddLE(-1)
        packetBufferNode.packetBuffer.writeShortAddLE(groundItemId)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeShortAdd(-1)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueGroundItemAction1Packet(groundItemId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJ1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShortLE(groundItemId)
        packetBufferNode.packetBuffer.writeShort(worldPointX)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueGroundItemAction2Packet(groundItemId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJ2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(worldPointY)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeShortAdd(groundItemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueGroundItemAction3Packet(groundItemId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJ3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShort(groundItemId)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueGroundItemAction4Packet(groundItemId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJ4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAddLE(groundItemId)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeShortAddLE(worldPointY)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueGroundItemAction5Packet(groundItemId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.OPOBJ5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShortLE(groundItemId)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}