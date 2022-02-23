package meteor.api.packets
import meteor.rs.ClientThread
import net.runelite.api.packets.ClientPacket
import net.runelite.api.packets.PacketBufferNode

object DialogPackets {
    fun sendNumberInput(number: Int, closeDialog: Boolean) {
        val client = Main.client
        val clientPacket: ClientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.RESUME_P_COUNTDIALOG(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(number)
        client.packetWriter.queuePacket(packetBufferNode)
        if (closeDialog) ClientThread.invoke { client.runScript(138) }

        // closes the input dialog
    }

    fun sendNumberInput(number: Int) {
        val client = Main.client
        val clientPacket: ClientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.RESUME_P_COUNTDIALOG(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(number)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun sendNameInput(name: String) {
        val client = Main.client
        val clientPacket: ClientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.RESUME_P_NAMEDIALOG(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByte(name.length + 1)
        packetBufferNode.packetBuffer.writeStringCp1252NullTerminated(name)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun sendTextInput(text: String) {
        val client = Main.client
        val clientPacket: ClientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.RESUME_P_STRINGDIALOG(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeByte(text.length + 1)
        packetBufferNode.packetBuffer.writeStringCp1252NullTerminated(text)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun closeInterface() {
        val client = Main.client
        val clientPacket: ClientPacket = Main.clientPacket
        val packetBufferNode: PacketBufferNode =
            client.preparePacket(clientPacket.CLOSE_MODAL(), client.packetWriter.isaacCipher)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}