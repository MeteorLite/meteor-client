package meteor.api.packets

import net.runelite.api.Client
import net.runelite.api.NPC

object NPCPackets {
    fun npcFirstOption(npc: NPC, ctrlDown: Boolean) {
        queueNPCAction1Packet(npc.index, ctrlDown)
    }

    fun npcSecondOption(npc: NPC, ctrlDown: Boolean) {
        queueNPCAction2Packet(npc.index, ctrlDown)
    }

    fun npcThirdOption(npc: NPC, ctrlDown: Boolean) {
        queueNPCAction3Packet(npc.index, ctrlDown)
    }

    fun npcFourthOption(npc: NPC, ctrlDown: Boolean) {
        queueNPCAction4Packet(npc.index, ctrlDown)
    }

    fun npcFifthOption(npc: NPC, ctrlDown: Boolean) {
        queueNPCAction5Packet(npc.index, ctrlDown)
    }

    fun npcAction(npc: NPC, action: String, ctrlDown: Boolean) {
        val actions: List<String> = npc.actions
        val index = actions.indexOf(action)
        when (index) {
            0 -> npcFirstOption(npc, ctrlDown)
            1 -> npcSecondOption(npc, ctrlDown)
            2 -> npcThirdOption(npc, ctrlDown)
            3 -> npcFourthOption(npc, ctrlDown)
            4 -> npcFifthOption(npc, ctrlDown)
        }
    }

    fun spellOnNpc(widgetId: Int, npc: NPC, b: Boolean) {
        queueSpellOnNpcPacket(npc.index, widgetId, b)
    }

    fun queueItemOnNpcPacket(npcIndex: Int, itemWidgetId: Int, itemId: Int, itemSlot: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPCU(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAdd(npcIndex)
        packetBufferNode.packetBuffer.writeShortAdd(itemSlot)
        packetBufferNode.packetBuffer.writeShortAdd(itemId)
        packetBufferNode.packetBuffer.writeIntIME(itemWidgetId)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueSpellOnNpcPacket(npcIndex: Int, spellWidgetId: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPCT(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(-1)
        packetBufferNode.packetBuffer.writeShortAdd(npcIndex)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeIntIME(spellWidgetId)
        packetBufferNode.packetBuffer.writeShortAddLE(-1)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueNPCAction1Packet(npcIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPC1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortLE(npcIndex)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueNPCAction2Packet(npcIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPC2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByteSub(if (ctrlDown) 1 else 0)
        packetBufferNode.packetBuffer.writeShortAddLE(npcIndex)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueNPCAction3Packet(npcIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPC3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAddLE(npcIndex)
        packetBufferNode.packetBuffer.writeByte(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueNPCAction4Packet(npcIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPC4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShortAddLE(npcIndex)
        packetBufferNode.packetBuffer.writeByteNeg(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueNPCAction5Packet(npcIndex: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.OPNPC5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(npcIndex)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 1 else 0)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}