package meteor.api.packets

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dev.hoot.api.game.Game
import net.runelite.api.packets.PacketBufferNode
import net.runelite.packets.ObfuscatedBufferStructure
import net.runelite.packets.ObfuscatedClientPacket
import java.io.IOException
import java.net.URISyntaxException


object ClientPackets {
    private val clientPackets: ArrayList<ObfuscatedClientPacket>
    init {
        val packetsJson = readResourceAsString("ClientPackets.json")
        clientPackets  = Gson().fromJson(
            packetsJson,
            object : TypeToken<ArrayList<ObfuscatedClientPacket?>?>() {}.type
        )
    }

    fun get(name: String) : ObfuscatedClientPacket? {
        for (clientPacket in clientPackets) {
            if (clientPacket.name == name)
                return clientPacket
        }
        return null
    }

    fun createItemPacket(packet: ObfuscatedClientPacket, itemId: Int, itemSlot: Int, itemWidgetId: Int): PacketBufferNode {
        val client = Game.getClient()
        val packetBufferNode = client.preparePacket(client.createClientPacket(packet.opcode, packet.size), client.packetWriter.isaacCipher)
        for (methodCall in packet.structure) {
            var value = -1
            when (methodCall.paramater) {
                "param0" -> value = itemSlot
                "param1" -> value = itemWidgetId
                "id" -> value = itemId
            }
            addMethodCall(packetBufferNode, methodCall, value)
        }
        return packetBufferNode
    }

    fun addMethodCall(packetBufferNode: PacketBufferNode, methodCall: ObfuscatedBufferStructure, value: Any) {
        when (methodCall.method) {
            "Byte" -> packetBufferNode.packetBuffer.writeByte(value as Int)
            "ByteAdd" -> packetBufferNode.packetBuffer.writeByteAdd(value as Int)
            "ByteNeg" -> packetBufferNode.packetBuffer.writeByteNeg(value as Int)
            "ByteSub" -> packetBufferNode.packetBuffer.writeByteSub(value as Int)
            "Int" -> packetBufferNode.packetBuffer.writeInt(value as Int)
            "IntIME" -> packetBufferNode.packetBuffer.writeIntIME(value as Int)
            "IntLE" -> packetBufferNode.packetBuffer.writeIntLE(value as Int)
            "IntME" -> packetBufferNode.packetBuffer.writeIntME(value as Int)
            "Short" -> packetBufferNode.packetBuffer.writeShort(value as Int)
            "ShortLE" -> packetBufferNode.packetBuffer.writeShortLE(value as Int)
            "ShortAdd" -> packetBufferNode.packetBuffer.writeShortAdd(value as Int)
            "ShortAddLE" -> packetBufferNode.packetBuffer.writeShortAddLE(value as Int)
            else -> throw java.lang.RuntimeException("Unmapped ObfuscatedClientPacket methodCall ${methodCall.method}")
        }
    }

    @Throws(URISyntaxException::class, IOException::class)
    fun readResourceAsString(filename: String): String? {
        val resource = ClassLoader.getSystemClassLoader().getResourceAsStream(filename)
        resource?.let {
            val bytes: ByteArray = resource.readAllBytes()
            return String(bytes)
        }
        return null
    }
}