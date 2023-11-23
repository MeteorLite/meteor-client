package meteor.api

import ClientPacket
import net.runelite.api.packets.PacketBufferNode


object ClientPackets {
// OPNPC2
// Size: 3
// Deobfuscated Name: OPNPC2
fun createNPCAction2Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPC2)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    return bufferNode
}


// OPNPC3
// Size: 3
// Deobfuscated Name: OPNPC3
fun createNPCAction3Packet(id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPC3)
    bufferNode.packetBuffer.`writeShortAddLE$api`(id)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// IF_BUTTON10
// Size: 8
// Deobfuscated Name: IF_BUTTON10
fun createWidgetAction10Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON10)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPPLAYERT
// Size: 11
// Deobfuscated Name: OPPLAYERT
fun createItemWidgetOnPlayerPacket(shiftPressed: Boolean, selectedSpellItemId: Int, id: Int, selectedSpellChildIndex: Int, selectedSpellWidget: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYERT)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAddLE$api`(selectedSpellItemId)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    bufferNode.packetBuffer.`writeShortAdd$api`(selectedSpellChildIndex)
    bufferNode.packetBuffer.`writeIntME$api`(selectedSpellWidget)
    return bufferNode
}


// MOVE_GAMECLICK
// Size: -1
// Deobfuscated Name: MOVE_GAMECLICK
fun createMovementPacket(five: Int, y: Int, x: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.MOVE_GAMECLICK)
    bufferNode.packetBuffer.`writeByte$api`(five)
    bufferNode.packetBuffer.`writeShort$api`(x)
    bufferNode.packetBuffer.`writeShortAdd$api`(y)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPPLAYER1
// Size: 3
// Deobfuscated Name: OPPLAYER1
fun createPlayerAction1Packet(id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER1)
    bufferNode.packetBuffer.`writeShort$api`(id)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// IF_BUTTONT
// Size: 16
// Deobfuscated Name: IF_BUTTONT
fun createItemWidgetOnItemWidgetPacket(id: Int, slot: Int, selectedSpellChildIndex: Int, widgetID: Int, itemId: Int, selectedSpellItemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTONT)
    bufferNode.packetBuffer.`writeIntIME$api`(id)
    bufferNode.packetBuffer.`writeShortAdd$api`(slot)
    bufferNode.packetBuffer.`writeShortAdd$api`(selectedSpellChildIndex)
    bufferNode.packetBuffer.`writeIntME$api`(widgetID)
    bufferNode.packetBuffer.`writeShortAdd$api`(itemId)
    bufferNode.packetBuffer.`writeShortAddLE$api`(selectedSpellItemId)
    return bufferNode
}


// OPNPC1
// Size: 3
// Deobfuscated Name: OPNPC1
fun createNPCAction1Packet(id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPC1)
    bufferNode.packetBuffer.`writeShort$api`(id)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPNPCT
// Size: 11
// Deobfuscated Name: OPNPCT
fun createItemWidgetOnNPCPacket(selectedSpellWidget: Int, id: Int, shiftPressed: Boolean, selectedSpellChildIndex: Int, selectedSpellItemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPCT)
    bufferNode.packetBuffer.`writeInt$api`(selectedSpellWidget)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(selectedSpellChildIndex)
    bufferNode.packetBuffer.`writeShortAdd$api`(selectedSpellItemId)
    return bufferNode
}


// IF_BUTTON2
// Size: 8
// Deobfuscated Name: IF_BUTTON2
fun createWidgetAction2Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON2)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// IF_BUTTON4
// Size: 8
// Deobfuscated Name: IF_BUTTON4
fun createWidgetAction4Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON4)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// IF_BUTTON5
// Size: 8
// Deobfuscated Name: IF_BUTTON5
fun createWidgetAction5Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON5)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// IF_BUTTON9
// Size: 8
// Deobfuscated Name: IF_BUTTON9
fun createWidgetAction9Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON9)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPOBJ2
// Size: 7
// Deobfuscated Name: OPOBJ2
fun createGroundItemAction2Packet(shiftPressed: Boolean, worldX: Int, worldY: Int, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPOBJ2)
    bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    return bufferNode
}


// OPPLAYER2
// Size: 3
// Deobfuscated Name: OPPLAYER2
fun createPlayerAction2Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER2)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAdd$api`(id)
    return bufferNode
}


// IF_BUTTON8
// Size: 8
// Deobfuscated Name: IF_BUTTON8
fun createWidgetAction8Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON8)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPNPC5
// Size: 3
// Deobfuscated Name: OPNPC5
fun createNPCAction5Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPC5)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// OPOBJ3
// Size: 7
// Deobfuscated Name: OPOBJ3
fun createGroundItemAction3Packet(worldX: Int, worldY: Int, shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPOBJ3)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeShort$api`(worldY)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// IF_BUTTON3
// Size: 8
// Deobfuscated Name: IF_BUTTON3
fun createWidgetAction3Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON3)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPPLAYER5
// Size: 3
// Deobfuscated Name: OPPLAYER5
fun createPlayerAction5Packet(id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER5)
    bufferNode.packetBuffer.`writeShortAddLE$api`(id)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPOBJ4
// Size: 7
// Deobfuscated Name: OPOBJ4
fun createGroundItemAction4Packet(worldY: Int, id: Int, shiftPressed: Boolean, worldX: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPOBJ4)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
    bufferNode.packetBuffer.`writeShort$api`(id)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldX)
    return bufferNode
}


// EVENT_MOUSE_CLICK
// Size: 6
// Deobfuscated Name: EVENT_MOUSE_CLICK
fun createClickPacket(mouseData: Int, y: Int, x: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.EVENT_MOUSE_CLICK)
    bufferNode.packetBuffer.`writeShort$api`(mouseData)
    bufferNode.packetBuffer.`writeShort$api`(x)
    bufferNode.packetBuffer.`writeShort$api`(y)
    return bufferNode
}


// OPLOC3
// Size: 7
// Deobfuscated Name: OPLOC3
fun createObjectAction3Packet(shiftPressed: Boolean, worldY: Int, worldX: Int, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOC3)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeShortAdd$api`(id)
    return bufferNode
}


// OPPLAYER4
// Size: 3
// Deobfuscated Name: OPPLAYER4
fun createPlayerAction4Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER4)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAddLE$api`(id)
    return bufferNode
}


// IF_BUTTON7
// Size: 8
// Deobfuscated Name: IF_BUTTON7
fun createWidgetAction7Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON7)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPOBJ1
// Size: 7
// Deobfuscated Name: OPOBJ1
fun createGroundItemAction1Packet(worldY: Int, worldX: Int, id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPOBJ1)
    bufferNode.packetBuffer.`writeShort$api`(worldY)
    bufferNode.packetBuffer.`writeShort$api`(worldX)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPPLAYER7
// Size: 3
// Deobfuscated Name: OPPLAYER7
fun createPlayerAction7Packet(id: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER7)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPNPC4
// Size: 3
// Deobfuscated Name: OPNPC4
fun createNPCAction4Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPNPC4)
    bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// OPLOCT
// Size: 15
// Deobfuscated Name: OPLOCT
fun createItemWidgetOnGameObjectPacket(id: Int, selectedSpellItemId: Int, selectedSpellChildIndex: Int, worldY: Int, worldX: Int, selectedSpellWidget: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOCT)
    bufferNode.packetBuffer.`writeShortAdd$api`(id)
    bufferNode.packetBuffer.`writeShortAddLE$api`(selectedSpellItemId)
    bufferNode.packetBuffer.`writeShort$api`(selectedSpellChildIndex)
    bufferNode.packetBuffer.`writeShortLE$api`(worldY)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeIntLE$api`(selectedSpellWidget)
    bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}


// OPLOC1
// Size: 7
// Deobfuscated Name: OPLOC1
fun createObjectAction1Packet(shiftPressed: Boolean, worldY: Int, worldX: Int, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOC1)
    bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortLE$api`(worldY)
    bufferNode.packetBuffer.`writeShort$api`(worldX)
    bufferNode.packetBuffer.`writeShortAdd$api`(id)
    return bufferNode
}


// OPPLAYER6
// Size: 3
// Deobfuscated Name: OPPLAYER6
fun createPlayerAction6Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER6)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// IF_BUTTON1
// Size: 8
// Deobfuscated Name: IF_BUTTON1
fun createWidgetAction1Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON1)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// IF_BUTTON6
// Size: 8
// Deobfuscated Name: IF_BUTTON6
fun createWidgetAction6Packet(param1: Int, param0: Int, itemId: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.IF_BUTTON6)
    bufferNode.packetBuffer.`writeInt$api`(param1)
    bufferNode.packetBuffer.`writeShort$api`(param0)
    bufferNode.packetBuffer.`writeShort$api`(itemId)
    return bufferNode
}


// OPLOC2
// Size: 7
// Deobfuscated Name: OPLOC2
fun createObjectAction2Packet(worldY: Int, worldX: Int, shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOC2)
    bufferNode.packetBuffer.`writeShort$api`(worldY)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// OPPLAYER3
// Size: 3
// Deobfuscated Name: OPPLAYER3
fun createPlayerAction3Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER3)
    bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShort$api`(id)
    return bufferNode
}


// OPLOC5
// Size: 7
// Deobfuscated Name: OPLOC5
fun createObjectAction5Packet(worldX: Int, worldY: Int, shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOC5)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAdd$api`(id)
    return bufferNode
}


// OPLOC4
// Size: 7
// Deobfuscated Name: OPLOC4
fun createObjectAction4Packet(shiftPressed: Boolean, worldY: Int, id: Int, worldX: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPLOC4)
    bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
    bufferNode.packetBuffer.`writeShort$api`(id)
    bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
    return bufferNode
}


// OPPLAYER8
// Size: 3
// Deobfuscated Name: OPPLAYER8
fun createPlayerAction8Packet(shiftPressed: Boolean, id: Int): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPPLAYER8)
    bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
    bufferNode.packetBuffer.`writeShortLE$api`(id)
    return bufferNode
}


// OPOBJ5
// Size: 7
// Deobfuscated Name: OPOBJ5
fun createGroundItemAction5Packet(worldY: Int, id: Int, worldX: Int, shiftPressed: Boolean): PacketBufferNode {
    val bufferNode = preparePacketBuffer(ClientPacket.OPOBJ5)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
    bufferNode.packetBuffer.`writeShortAddLE$api`(id)
    bufferNode.packetBuffer.`writeShortAddLE$api`(worldX)
    bufferNode.packetBuffer.`writeByteSub$api`(if (shiftPressed) 1 else 0)
    return bufferNode
}

}
