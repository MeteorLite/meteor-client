package meteor.api.packets

import net.runelite.api.Client
import net.runelite.api.Item
import net.runelite.api.Point
import net.runelite.api.TileObject
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import net.runelite.api.packets.PacketBufferNode

object TileObjectPackets {
    fun tileObjectFirstOption(`object`: TileObject, ctrlDown: Boolean) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueTileObjectAction1Packet(`object`.id, wp.x, wp.y, ctrlDown)
    }

    fun tileObjectSecondOption(`object`: TileObject, ctrlDown: Boolean) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueTileObjectAction2Packet(`object`.id, wp.x, wp.y, ctrlDown)
    }

    fun tileObjectThirdOption(`object`: TileObject, ctrlDown: Boolean) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueTileObjectAction3Packet(`object`.id, wp.x, wp.y, ctrlDown)
    }

    fun tileObjectFourthOption(`object`: TileObject, ctrlDown: Boolean) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueTileObjectAction4Packet(`object`.id, wp.x, wp.y, ctrlDown)
    }

    fun tileObjectFifthOption(`object`: TileObject, ctrlDown: Boolean) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueTileObjectAction5Packet(`object`.id, wp.x, wp.y, ctrlDown)
    }

    fun tileObjectAction(`object`: TileObject, action: String, ctrlDown: Boolean) {
        val actions: List<String> = `object`.actions
        val index = actions.indexOf(action)
        when (index) {
            0 -> tileObjectFirstOption(`object`, ctrlDown)
            1 -> tileObjectSecondOption(`object`, ctrlDown)
            2 -> tileObjectThirdOption(`object`, ctrlDown)
            3 -> tileObjectFourthOption(`object`, ctrlDown)
            4 -> tileObjectFifthOption(`object`, ctrlDown)
        }
    }

    fun useItemOnTileObject(item: Item, `object`: TileObject) {
        val p: Point = `object`.menuPoint()
        val lp = LocalPoint(p.x, p.y)
        val wp: WorldPoint = WorldPoint.fromScene(Main.client, lp.x, lp.y, `object`.plane)
        queueItemUseOnTileObjectPacket(`object`.id, wp.x, wp.y, item.slot, item.id, item.widgetId, false)
    }

    fun queueItemUseOnTileObjectPacket(
        objectId: Int,
        worldPointX: Int,
        worldPointY: Int,
        itemSlot: Int,
        itemId: Int,
        itemWidgetId: Int,
        ctrlDown: Boolean
    ) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOCU(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(objectId)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeShortLE(itemSlot)
        packetBufferNode.packetBuffer.writeShort(itemId)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointY)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeIntME(itemWidgetId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueSpellOnTileObjectPacket(
        objectId: Int,
        worldPointX: Int,
        worldPointY: Int,
        spellWidgetId: Int,
        ctrlDown: Boolean
    ) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOCT(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeInt(spellWidgetId)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeShortLE(-1)
        packetBufferNode.packetBuffer.writeShortAddLE(-1)
        packetBufferNode.packetBuffer.writeShort(objectId)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueTileObjectAction1Packet(objectId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOC1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeShortLE(worldPointY)
        packetBufferNode.packetBuffer.writeShort(objectId)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueTileObjectAction2Packet(objectId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOC2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeShortAdd(objectId)
        packetBufferNode.packetBuffer.writeShortLE(worldPointY)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueTileObjectAction3Packet(objectId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOC3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(worldPointY)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortLE(objectId)
        packetBufferNode.packetBuffer.writeShort(worldPointX)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueTileObjectAction4Packet(objectId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOC4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShortLE(objectId)
        packetBufferNode.packetBuffer.writeShortAdd(worldPointX)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueTileObjectAction5Packet(objectId: Int, worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            Main.client.preparePacket(clientPacket.OPLOC5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeShort(worldPointY)
        packetBufferNode.packetBuffer.writeShort(objectId)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}