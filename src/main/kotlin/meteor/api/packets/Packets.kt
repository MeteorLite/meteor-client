package meteor.api.packets

import net.runelite.api.packets.ClientPacket

object Packets {
    fun queuePacket(clientPacket: ClientPacket, vararg data: Any) {
        val writer = Main.client.packetWriter
        val packet = Main.client.preparePacket(clientPacket, writer.isaacCipher)
        for (o in data) {
            if (o is Byte) {
                packet.packetBuffer.writeByte(o as Int)
                continue
            }
            if (o is Short) {
                packet.packetBuffer.writeShort(o as Int)
                continue
            }
            if (o is Int) {
                packet.packetBuffer.writeInt(o)
                continue
            }
            if (o is Long) {
                packet.packetBuffer.writeLong(o)
                continue
            }
            if (o is String) {
                packet.packetBuffer.writeStringCp1252NullTerminated(o as String?)
                continue
            }
            // invalid data
            return
        }
        writer.queuePacket(packet)
    }
}