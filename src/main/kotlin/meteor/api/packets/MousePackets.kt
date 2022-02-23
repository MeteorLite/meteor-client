package meteor.api.packets

import net.runelite.api.Client

object MousePackets {
    fun queueClickPacket() {
        queueClickPacket(0, 0)
    }

    fun queueClickPacket(x: Int, y: Int) {
        val client = Main.client
        client.mouseLastPressedMillis = System.currentTimeMillis()
        var mousePressedTime =
            (client.mouseLastPressedMillis - client.clientMouseLastPressedMillis).toInt()
        if (mousePressedTime < 0) {
            mousePressedTime = 0
        }
        if (mousePressedTime > 32767) {
            mousePressedTime = 32767
        }
        client.clientMouseLastPressedMillis = client.mouseLastPressedMillis
        val mouseInfo = (mousePressedTime shl 1) + 1
        queueClickPacket(mouseInfo, x, y)
    }

    fun queueClickPacket(mouseInfo: Int, x: Int, y: Int) {
        val client: Client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.EVENT_MOUSE_CLICK(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeShort(mouseInfo)
        packetBufferNode.packetBuffer.writeShort(x)
        packetBufferNode.packetBuffer.writeShort(y)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}