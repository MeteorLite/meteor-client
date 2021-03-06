package meteor.api.packets

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dev.hoot.api.InteractionException
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.Game
import dev.hoot.api.packets.*
import dev.hoot.api.widgets.Widgets
import net.runelite.api.MenuAction
import net.runelite.api.packets.PacketBuffer
import net.runelite.api.packets.PacketBufferNode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.widgets.WidgetType
import net.runelite.packets.ObfuscatedBufferStructure
import net.runelite.packets.ObfuscatedClientPacket


object ClientPackets {
    private val clientPackets: ArrayList<ObfuscatedClientPacket>

    init {
        val packetsJson = readResourceAsString("ClientPackets.json")
        clientPackets = Gson().fromJson(
            packetsJson,
            object : TypeToken<ArrayList<ObfuscatedClientPacket?>?>() {}.type
        )
    }

    fun getPacket(name: String): ObfuscatedClientPacket {
        return clientPackets.first { obfuscatedClientPacket -> obfuscatedClientPacket.name == name }
    }

    fun createItemActionPacket(packetName: String, itemId: Int, itemSlot: Int, itemWidgetId: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value = -1
            when (methodCall.paramater) {
                "itemSlot" -> value = itemSlot
                "itemWidgetId" -> value = itemWidgetId
                "id" -> value = itemId
                else -> println(methodCall.paramater)
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnItemPacket(
        packetName: String,
        sourceItemId: Int,
        sourceItemSlot: Int,
        itemId: Int,
        itemSlot: Int
    ): PacketBufferNode {
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
                "itemWidgetId" -> value = WidgetInfo.INVENTORY.id //itemWidgetID
                "id" -> value = itemId
                "selectedSpellWidget" -> value = spellWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnGroundItemPacket(
        packetName: String,
        groundItemID: Int,
        worldX: Int,
        worldY: Int,
        itemSlot: Int,
        itemID: Int,
        itemWidgetID: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createSpellOnGroundItemPacket(
        packetName: String,
        groundItemID: Int,
        worldX: Int,
        worldY: Int,
        spellWidgetId: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createGroundItemActionPacket(
        packetName: String,
        groundItemId: Int,
        worldX: Int,
        worldY: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createItemOnNPCPacket(
        packetName: String,
        npcIndex: Int,
        itemWidgetID: Int,
        itemID: Int,
        itemSlot: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createSpellOnNPCPacket(
        packetName: String,
        npcIndex: Int,
        spellWidgetId: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createObjectActionPacket(
        packetName: String,
        objectID: Int,
        worldX: Int,
        worldY: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createItemOnObjectPacket(
        packetName: String,
        objectID: Int,
        worldX: Int,
        worldY: Int,
        itemSlot: Int,
        itemId: Int,
        itemWidgetID: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createWidgetOnObjectPacket(
        packetName: String,
        objectID: Int,
        worldX: Int,
        worldY: Int,
        itemSlot: Int,
        itemId: Int,
        widgetID: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.paramater) {
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "id" -> value = objectID
                "ctrlPressed" -> value = ctrlPressed
                "selectedItemWidget" -> value = widgetID
                "selectedItemId" -> value = itemId
                "selectedItemSlot" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createItemOnPlayerPacket(
        packetName: String,
        playerIndex: Int,
        itemId: Int,
        itemSlot: Int,
        itemWidgetID: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createSpellOnPlayerPacket(
        packetName: String,
        objectId: Int,
        spellWidgetId: Int,
        ctrlPressed: Boolean
    ): PacketBufferNode {
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

    fun createPlayerActionPacket(packetName: String, playerIndex: Int, ctrlPressed: Boolean): PacketBufferNode {
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

    fun preparePacket(packetName: String): PacketBufferNode {
        val client = Game.getClient()
        val packet = getPacket(packetName)
        return client.preparePacket(
            client.createClientPacket(packet.opcode, packet.size),
            client.packetWriter.isaacCipher
        )
    }

    fun encodeToBuffer(packetBuffer: PacketBuffer, methodCall: ObfuscatedBufferStructure, value: Any) {
        // transform boolean to number
        val finalValue: Any = if (value is Boolean)
            if (value) 1 else 0
        else
            value

        when (methodCall.method) {
            "Byte" -> packetBuffer.writeByte(finalValue as Int)
            "ByteAdd" -> packetBuffer.writeByteAdd(finalValue as Int)
            "ByteNeg" -> packetBuffer.writeByteNeg(finalValue as Int)
            "ByteSub" -> packetBuffer.writeByteSub(finalValue as Int)
            "Int" -> packetBuffer.writeInt(finalValue as Int)
            "IntIME" -> packetBuffer.writeIntIME(finalValue as Int)
            "IntLE" -> packetBuffer.writeIntLE(finalValue as Int)
            "IntME" -> packetBuffer.writeIntME(finalValue as Int)
            "Short" -> packetBuffer.writeShort(finalValue as Int)
            "ShortLE" -> packetBuffer.writeShortLE(finalValue as Int)
            "ShortAdd" -> packetBuffer.writeShortAdd(finalValue as Int)
            "ShortAddLE" -> packetBuffer.writeShortAddLE(finalValue as Int)
            else -> throw RuntimeException("Unmapped ObfuscatedClientPacket methodCall ${methodCall.method}")
        }
    }

    private fun readResourceAsString(filename: String): String? {
        ClassLoader.getSystemClassLoader().getResourceAsStream(filename)?.let { return String(it.readAllBytes()) }
        return null
    }

    fun createClientPacket(menu: AutomatedMenu): PacketBufferNode? {
        val opcode = menu.opcode
        val client = Game.getClient()
        val id = menu.identifier
        val param0 = menu.param0
        val param1 = menu.param1
        var selectedWidgetItemId = client.selectedSpellItemId
        var selectedWidgetSlot = client.selectedSpellChildIndex
        // Yes, keeping both in case of a future fix in naming
        val selectedWidget = client.selectedSpellWidget
        val selectedSpellWidget = client.selectedSpellWidget
        when (opcode) {
            MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT -> return ObjectPackets.createWidgetOnObjectPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GAME_OBJECT_FIRST_OPTION -> return ObjectPackets.createObjectFirstActionPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_SECOND_OPTION -> return ObjectPackets.createObjectSecondActionPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_THIRD_OPTION -> return ObjectPackets.createObjectThirdActionPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FOURTH_OPTION -> return ObjectPackets.createObjectFourthActionPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FIFTH_OPTION -> return ObjectPackets.createObjectFifthActionPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC -> return NPCPackets.createWidgetOnNpc(
                id,
                selectedWidget,
                selectedWidgetItemId,
                selectedWidgetSlot,
                false
            )
            MenuAction.NPC_FIRST_OPTION -> return NPCPackets.createNpcFirstActionPacket(id, false)
            MenuAction.NPC_SECOND_OPTION -> return NPCPackets.createNpcSecondActionPacket(id, false)
            MenuAction.NPC_THIRD_OPTION -> return NPCPackets.createNpcThirdActionPacket(id, false)
            MenuAction.NPC_FOURTH_OPTION -> return NPCPackets.createNpcFourthActionPacket(id, false)
            MenuAction.NPC_FIFTH_OPTION -> return NPCPackets.createNpcFifthActionPacket(id, false)
            MenuAction.ITEM_USE_ON_PLAYER, MenuAction.WIDGET_TARGET_ON_PLAYER -> return PlayerPackets.createWidgetOnPlayer(
                id,
                selectedWidgetItemId,
                selectedWidgetSlot,
                selectedWidget,
                false
            )
            MenuAction.PLAYER_FIRST_OPTION -> return PlayerPackets.createFirstAction(id, false)
            MenuAction.PLAYER_SECOND_OPTION -> return PlayerPackets.createSecondAction(id, false)
            MenuAction.PLAYER_THIRD_OPTION -> return PlayerPackets.createThirdAction(id, false)
            MenuAction.PLAYER_FOURTH_OPTION -> return PlayerPackets.createFourthAction(id, false)
            MenuAction.PLAYER_FIFTH_OPTION -> return PlayerPackets.createFifthAction(id, false)
            MenuAction.PLAYER_SIXTH_OPTION -> return PlayerPackets.createSixthAction(id, false)
            MenuAction.PLAYER_SEVENTH_OPTION -> return PlayerPackets.createSeventhAction(id, false)
            MenuAction.PLAYER_EIGTH_OPTION -> return PlayerPackets.createEighthAction(id, false)
            MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM -> return GroundItemPackets.createWidgetOnGroundItem(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GROUND_ITEM_FIRST_OPTION -> return GroundItemPackets.createFirstAction(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_SECOND_OPTION -> return GroundItemPackets.createSecondAction(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_THIRD_OPTION -> return GroundItemPackets.createThirdAction(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FOURTH_OPTION -> return GroundItemPackets.createFourthAction(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FIFTH_OPTION -> return GroundItemPackets.createFifthAction(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.WIDGET_USE_ON_ITEM, MenuAction.ITEM_USE_ON_ITEM, MenuAction.WIDGET_TARGET_ON_WIDGET -> {
                val targetParent: Widget? = Widgets.fromId(param1)
                val targetChild: Widget? = targetParent?.getChild(param0)
                var childItemId = -1
                if (targetChild != null) {
                    childItemId = targetChild.itemId
                }
                val source: Widget = client.getWidget(selectedWidget)!!
                if (source.type == WidgetType.GRAPHIC) {
                    selectedWidgetSlot = -1
                    selectedWidgetItemId = -1
                }
                return WidgetPackets.createWidgetOnWidget(
                    selectedWidget,
                    selectedWidgetSlot,
                    selectedWidgetItemId,
                    param1,
                    param0,
                    childItemId
                )
            }
            MenuAction.ITEM_FIRST_OPTION -> return ItemPackets.createFirstAction(
                param1,
                id,
                param0
            )
            MenuAction.ITEM_SECOND_OPTION -> return ItemPackets.createSecondAction(
                param1,
                id,
                param0
            )
            MenuAction.ITEM_THIRD_OPTION -> return ItemPackets.createThirdAction(
                param1,
                id,
                param0
            )
            MenuAction.ITEM_FOURTH_OPTION -> return ItemPackets.createFourthAction(
                param1,
                id,
                param0
            )
            MenuAction.ITEM_FIFTH_OPTION -> return ItemPackets.createFifthAction(
                param1,
                id,
                param0
            )
            MenuAction.WIDGET_FIRST_OPTION -> return WidgetPackets.createFirstAction(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_SECOND_OPTION -> return WidgetPackets.createSecondAction(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_THIRD_OPTION -> return WidgetPackets.createThirdAction(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FOURTH_OPTION -> return WidgetPackets.createFourthAction(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FIFTH_OPTION -> return WidgetPackets.createFifthAction(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_TYPE_1 -> return WidgetPackets.createType1Action(param1)
            MenuAction.WIDGET_CONTINUE -> return WidgetPackets.createContinuePacket(param1, param0)
            MenuAction.WALK -> {
                client.destinationX = param0
                client.destinationY = param1
                return MovementPackets.createMovement(
                    param0 + client.baseX,
                    param1 + client.baseY,
                    false
                )
            }
            MenuAction.CC_OP_LOW_PRIORITY,
            MenuAction.CC_OP -> {
                val widget = Widgets.fromId(param1) ?: return null
                val child = (if (param0 == -1) null else widget.getChild(param0))
                    ?: return WidgetPackets.createDefaultAction(id, param1, -1, param0)
                return WidgetPackets.createDefaultAction(id, param1, child.itemId, param0)
            }
            else -> {}
        }
        throw InteractionException("Couldn't parse packet from opcode: $opcode")
    }
}