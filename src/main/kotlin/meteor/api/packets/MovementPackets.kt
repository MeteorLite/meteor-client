package meteor.api.packets

import net.runelite.api.Client
import net.runelite.api.coords.WorldPoint

object MovementPackets {
    fun sendMovement(worldX: Int, worldY: Int) {
        sendMovement(worldX, worldY, false)
    }

    fun sendMovement(worldPoint: WorldPoint, ctrlDown: Boolean) {
        sendMovement(worldPoint.x, worldPoint.y, ctrlDown)
    }

    fun sendMovement(worldPoint: WorldPoint) {
        sendMovement(worldPoint, false)
    }

    fun sendMovement(worldPointX: Int, worldPointY: Int, ctrlDown: Boolean) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.MOVE_GAMECLICK(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByte(5)
        packetBufferNode.packetBuffer.writeByteAdd(if (ctrlDown) 2 else 0)
        packetBufferNode.packetBuffer.writeShortLE(worldPointX)
        packetBufferNode.packetBuffer.writeShortLE(worldPointY)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}