package meteor.api.packets

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dev.hoot.api.game.Game
import net.runelite.api.packets.PacketBuffer
import net.runelite.api.packets.PacketBufferNode
import net.runelite.api.widgets.WidgetInfo
import net.runelite.packets.ObfuscatedBufferStructure
import net.runelite.packets.ObfuscatedClientPacket


object ClientPackets {
    private val clientPackets: ArrayList<ObfuscatedClientPacket>
    init {
        val packetsJson = readResourceAsString("ClientPackets.json")
        clientPackets  = Gson().fromJson(
            packetsJson,
            object : TypeToken<ArrayList<ObfuscatedClientPacket?>?>() {}.type
        )
    }

    fun getPacket(name: String) : ObfuscatedClientPacket {
        return clientPackets.first { obfuscatedClientPacket ->  obfuscatedClientPacket.name == name}
    }

    fun createItemActionPacket(packetName: String, itemId: Int, itemSlot: Int, itemWidgetId: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value = -1
            when (methodCall.paramater) {
                "itemSlot" -> value = itemSlot
                "itemWidgetId" -> value = itemWidgetId
                "id" -> value = itemId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnItemPacket(packetName: String, sourceItemId: Int, sourceItemSlot: Int, itemId: Int, itemSlot: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value = -1
            when (methodCall.paramater) {
                "itemSlot" -> value = itemSlot
                "itemWidgetId" -> value = WidgetInfo.INVENTORY.id //itemWidgetID
                "id" -> value = itemId
                "selectedItemWidget" -> WidgetInfo.INVENTORY.id //selectedItemWidgetID
                "selectedItemSlot" -> value = sourceItemSlot
                "selectedItemId" -> value = sourceItemId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createSpellOnItemPacket(packetName: String, itemId: Int, itemSlot: Int, spellWidgetId: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value = -1
            when (methodCall.paramater) {
                "itemSlot" -> value = itemSlot
                "itemWidgetId" -> value =  WidgetInfo.INVENTORY.id //itemWidgetID
                "id" -> value = itemId
                "selectedSpellWidget" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnGroundItemPacket(packetName: String, groundItemID: Int, worldX: Int, worldY: Int, itemSlot: Int, itemID: Int, itemWidgetID: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = groundItemID
                "ctrlPressed" -> value = ctrlPressed
                "selectedItemWidget" -> value = itemWidgetID
                "selectedItemId" -> value = itemID
                "selectedItemSlot" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createSpellOnGroundItemPacket(packetName: String, groundItemID: Int, worldX: Int, worldY: Int, spellWidgetId: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = groundItemID
                "ctrlPressed" -> value = ctrlPressed
                "spellWidgetId" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createGroundItemActionPacket(packetName: String, groundItemId: Int, worldX: Int, worldY: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = groundItemId
                "ctrlPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnNPCPacket(packetName: String, npcIndex: Int, itemWidgetID: Int, itemID: Int, itemSlot: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "id" -> value = npcIndex
                "ctrlPressed" -> value = ctrlPressed
                "selectedItemWidget" -> value = itemWidgetID
                "selectedItemId" -> value = itemID
                "selectedItemSlot" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createSpellOnNPCPacket(packetName: String, npcIndex: Int, spellWidgetId: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "ctrlPressed" -> value = ctrlPressed
                "id" -> value = npcIndex
                "selectedSpellWidget" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createNPCActionPacket(packetName: String, npcIndex: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "id" -> value = npcIndex
                "ctrlPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createObjectActionPacket(packetName: String, objectID: Int, worldX: Int, worldY: Int, ctrlPressed: Boolean) : PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = objectID
                "ctrlPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnObjectPacket(packetName: String, objectID: Int, worldX: Int, worldY: Int, itemSlot: Int, itemId: Int, itemWidgetID: Int, ctrlPressed: Boolean) : PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = objectID
                "ctrlPressed" -> value = ctrlPressed
                "selectedItemWidget" -> value = itemWidgetID
                "selectedItemId" -> value = itemId
                "selectedItemSlot" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createSpellOnObjectPacket(packetName: String, objectId: Int, worldX: Int, worldY: Int, spellWidgetId: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = objectId
                "ctrlPressed" -> value = ctrlPressed
                "spellWidgetId" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnPlayerPacket(packetName: String, playerIndex: Int, itemId: Int, itemSlot: Int, itemWidgetID: Int, ctrlPressed: Boolean) : PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "id" -> value = playerIndex
                "ctrlPressed" -> value = ctrlPressed
                "selectedItemWidget" -> value = itemWidgetID
                "selectedItemId" -> value = itemId
                "selectedItemSlot" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createSpellOnPlayerPacket(packetName: String, objectId: Int, spellWidgetId: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "id" -> value = objectId
                "ctrlPressed" -> value = ctrlPressed
                "spellWidgetId" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createPlayerActionPacket(packetName: String, playerIndex: Int, ctrlPressed: Boolean) : PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "id" -> value = playerIndex
                "ctrlPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun preparePacket(packetName: String) : PacketBufferNode {
        val client = Game.getClient()
        val packet = getPacket(packetName)!!
        return client.preparePacket(client.createClientPacket(packet.opcode, packet.size), client.packetWriter.isaacCipher)
    }

    fun encodeToBuffer(packetBuffer: PacketBuffer, methodCall: ObfuscatedBufferStructure, value: Any) {
        when (methodCall.method) {
            "Byte" -> packetBuffer.writeByte(value as Int)
            "ByteAdd" -> packetBuffer.writeByteAdd(value as Int)
            "ByteNeg" -> packetBuffer.writeByteNeg(value as Int)
            "ByteSub" -> packetBuffer.writeByteSub(value as Int)
            "Int" -> packetBuffer.writeInt(value as Int)
            "IntIME" -> packetBuffer.writeIntIME(value as Int)
            "IntLE" -> packetBuffer.writeIntLE(value as Int)
            "IntME" -> packetBuffer.writeIntME(value as Int)
            "Short" -> packetBuffer.writeShort(value as Int)
            "ShortLE" -> packetBuffer.writeShortLE(value as Int)
            "ShortAdd" -> packetBuffer.writeShortAdd(value as Int)
            "ShortAddLE" -> packetBuffer.writeShortAddLE(value as Int)
            else -> throw RuntimeException("Unmapped ObfuscatedClientPacket methodCall ${methodCall.method}")
        }
    }

    private fun readResourceAsString(filename: String): String? {
        ClassLoader.getSystemClassLoader().getResourceAsStream(filename)?.let { return String(it.readAllBytes()) }
        return null
    }
}