package meteor.api.packets

import net.runelite.api.Client

object PlayerPackets {
    fun queueItemUseOnPlayerPacket(playerIndex: Int, itemId: Int, itemSlot: Int, itemWidgetId: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYERU(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeIntLE(itemWidgetId)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        packetBufferNode.packetBuffer.writeShortLE(playerIndex)
        packetBufferNode.packetBuffer.writeShortLE(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueSpellOnPlayerPacket(playerIndex: Int, spellWidgetId: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYERT(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeIntLE(spellWidgetId)
        packetBufferNode.packetBuffer.writeShort(-1)
        packetBufferNode.packetBuffer.writeShortAddLE(-1)
        packetBufferNode.packetBuffer.writeShortAddLE(playerIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction1Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAddLE(playerIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction2Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAddLE(playerIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction3Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(playerIndex)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction4Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(playerIndex)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction5Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(playerIndex)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction6Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER6(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortLE(playerIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction7Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER7(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShort(playerIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queuePlayerAction8Packet(playerIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPPLAYER8(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(playerIndex)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}