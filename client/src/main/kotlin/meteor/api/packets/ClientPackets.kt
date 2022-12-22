@file:Suppress("DEPRECATION")

package meteor.api.packets

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dev.hoot.api.InteractionException
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Widgets
import meteor.Main
import meteor.model.BufferMethod
import meteor.model.ObfuscatedBufferStructure
import meteor.model.ObfuscatedClientPacket
import meteor.rs.ClientThread.invoke
import net.runelite.api.MenuAction
import net.runelite.api.packets.PacketBuffer
import net.runelite.api.packets.PacketBufferNode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetType


object ClientPackets {
    private val clientPackets: HashMap<Int, ObfuscatedClientPacket>
    private val bufferMethods: ArrayList<BufferMethod>
    init {
        val packetsJson = readResourceAsString("clientPackets.json")
        val bufferMethodsJson = readResourceAsString("buffer.json")
        clientPackets = Gson().fromJson(
            packetsJson,
            object : TypeToken<HashMap<Int, ObfuscatedClientPacket>>() {}.type
        )
        bufferMethods = Gson().fromJson(
            bufferMethodsJson,
            object : TypeToken<ArrayList<BufferMethod>>() {}.type
        )
    }

    fun getPacket(name: String): ObfuscatedClientPacket {
        return clientPackets.values.first { obfuscatedClientPacket -> obfuscatedClientPacket.name == name }
    }

    fun getOpcode(clientPacket: ObfuscatedClientPacket): Int {
        for (key in clientPackets.keys) {
            if (clientPackets[key] == clientPacket)
                return key
        }
        return -1
    }

    fun createItemActionPacket(packetName: String, itemId: Int, itemSlot: Int, itemWidgetId: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value = -1
            when (methodCall.argument) {
                "param1" -> value = itemSlot
                "param0" -> value = itemWidgetId
                "id" -> value = itemId
                else -> println(methodCall.argument)
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
            when (methodCall.argument) {
                "param0" -> value = worldX
                "param1" -> value = worldY
                "id" -> value = groundItemID
                "shiftPressed" -> value = ctrlPressed
                "selectedSpellWidget" -> value = itemWidgetID
                "selectedSpellItemId" -> value = itemID
                "selectedSpellChildIndex" -> value = itemSlot
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
            when (methodCall.argument) {
                "param0" -> value = worldX
                "param1" -> value = worldY
                "id" -> value = groundItemId
                "shiftPressed" -> value = ctrlPressed
                else -> println(methodCall.argument)
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
            when (methodCall.argument) {
                "id" -> value = npcIndex
                "shiftPressed" -> value = ctrlPressed
                "selectedSpellWidget" -> value = itemWidgetID
                "selectedSpellItemId" -> value = itemID
                "selectedSpellChildIndex" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createNPCActionPacket(packetName: String, npcIndex: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "id" -> value = npcIndex
                "shiftPressed" -> value = ctrlPressed
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
            when (methodCall.argument) {
                "param0" -> value = worldX
                "param1" -> value = worldY
                "id" -> value = objectID
                "shiftPressed" -> value = ctrlPressed
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
            when (methodCall.argument) {
                "param0" -> value = worldX
                "param1" -> value = worldY
                "id" -> value = objectID
                "shiftPressed" -> value = ctrlPressed
                "selectedSpellWidget" -> value = itemWidgetID
                "selectedSpellItemId" -> value = itemId
                "selectedSpellChildIndex" -> value = itemSlot
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
            when (methodCall.argument) {
                "param0" -> value = worldX
                "param1" -> value = worldY
                "id" -> value = objectID
                "shiftPressed" -> value = ctrlPressed
                "selectedSpellWidget" -> value = widgetID
                "selectedSpellItemId" -> value = itemId
                "selectedSpellChildIndex" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createWidgetOnPlayerPacket(
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
            when (methodCall.argument) {
                "id" -> value = playerIndex
                "shiftPressed" -> value = ctrlPressed
                "selectedSpellWidget" -> value = itemWidgetID
                "selectedSpellItemId" -> value = itemId
                "selectedSpellChildIndex" -> value = itemSlot
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createWidgetActionPacket(
        packetName: String,
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "param1" -> value = childId
                "param0" -> value = widgetId
                "itemId" -> value = itemId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createPlayerActionPacket(packetName: String, playerIndex: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "id" -> value = playerIndex
                "shiftPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createWidgetOnWidgetPacket(packetName: String, sourceWidgetId: Int, sourceSlot: Int, sourceItemId: Int, destinationWidgetId: Int, destinationSlot: Int, destinationItemId: Int): PacketBufferNode {
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "selectedSpellWidget" -> value = sourceWidgetId
                "selectedSpellChildIndex" -> value = sourceSlot
                "selectedSpellItemId" -> value = sourceItemId
                "itemId" -> value = destinationItemId
                "slot" -> value = destinationSlot
                "widgetId" -> value = destinationWidgetId
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun queueClickPacket(mouseInfo: Int, x: Int, y: Int) {
        invoke { createClickPacket(mouseInfo, x, y).send() }
    }

    fun queueClickPacket(x: Int, y: Int) {
        Main.client.mouseLastPressedMillis = System.currentTimeMillis()
        var mousePressedTime =
            Main.client.mouseLastPressedMillis - Main.client.clientMouseLastPressedMillis
        if (mousePressedTime < 0) {
            mousePressedTime = 0
        }
        if (mousePressedTime > 32767) {
            mousePressedTime = 32767
        }
        Main.client.clientMouseLastPressedMillis = Main.client.mouseLastPressedMillis
        val mouseInfo = (mousePressedTime shl 1) + 1
        queueClickPacket(mouseInfo.toInt(), x, y)
    }

    fun createClickPacket(mouseInfo: Int, x: Int, y: Int): PacketBufferNode {
        val packetName = "EVENT_MOUSE_CLICK"
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "mouseInfo" -> value = mouseInfo
                "x" -> value = x
                "y" -> value = y
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun createMovementPacket(worldX: Int, worldY: Int, ctrlPressed: Boolean): PacketBufferNode {
        val packetName = "MOVE_GAMECLICK"
        val packetBuffer = preparePacket(packetName)
        for (methodCall in getPacket(packetName).structure) {
            var value: Any = -1
            when (methodCall.argument) {
                "_five_" -> value = 5
                "worldX" -> value = worldX
                "worldY" -> value = worldY
                "ctrlPressed" -> value = ctrlPressed
            }
            encodeToBuffer(packetBuffer.packetBuffer, methodCall, value)
        }
        return packetBuffer
    }

    fun preparePacket(packetName: String): PacketBufferNode {
        val client = Main.client
        Main.logger.debug("Preparing packet: $packetName")
        val packet = getPacket(packetName)
        return client.preparePacket(
            client.createClientPacket(getOpcode(packet), packet.size),
            client.packetWriter.isaacCipher
        )
    }

    fun encodeToBuffer(packetBuffer: PacketBuffer, methodCall: ObfuscatedBufferStructure, value: Any) {
        // transform boolean to number
        val finalValue: Any = if (value is Boolean)
            if (value) 1 else 0
        else
            value

        when (getBufferEncoderName(methodCall.method)) {
            "writeByte" -> packetBuffer.writeByte(finalValue as Int)
            "writeByteAdd" -> packetBuffer.writeByteAdd(finalValue as Int)
            "writeByteNeg" -> packetBuffer.writeByteNeg(finalValue as Int)
            "writeByteSub" -> packetBuffer.writeByteSub(finalValue as Int)
            "writeInt" -> packetBuffer.writeInt(finalValue as Int)
            "writeIntIME" -> packetBuffer.writeIntIME(finalValue as Int)
            "writeIntLE" -> packetBuffer.writeIntLE(finalValue as Int)
            "writeIntME" -> packetBuffer.writeIntME(finalValue as Int)
            "writeShort" -> packetBuffer.writeShort(finalValue as Int)
            "writeShortLE" -> packetBuffer.writeShortLE(finalValue as Int)
            "writeShortAdd" -> packetBuffer.writeShortAdd(finalValue as Int)
            "writeShortAddLE" -> packetBuffer.writeShortAddLE(finalValue as Int)
            else -> throw RuntimeException("Unmapped ObfuscatedClientPacket methodCall ${methodCall.method}")
        }
    }

    private fun readResourceAsString(filename: String): String? {
        ClassLoader.getSystemClassLoader().getResourceAsStream(filename)?.let { return String(it.readAllBytes()) }
        return null
    }

    fun getBufferEncoderName(deobName: String) : String {
        for (bufferMethod in bufferMethods) {
            if (deobName == bufferMethod.deobName)
                return bufferMethod.method
        }
        return ""
    }

    fun createClientPacket(menu: AutomatedMenu): PacketBufferNode? {
        val opcode = menu.opcode
        val client = Main.client
        val id = menu.identifier
        val param0 = menu.param0
        val param1 = menu.param1
        var selectedWidgetItemId = client.selectedSpellItemId
        var selectedWidgetSlot = client.selectedSpellChildIndex
        // Yes, keeping both in case of a future fix in naming
        val selectedWidget = client.selectedSpellWidget

        when (opcode) {
            MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT -> return createItemOnObjectPacket(
                "OPOBJT",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GAME_OBJECT_FIRST_OPTION -> return createObjectActionPacket(
                "OPOBJ1",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_SECOND_OPTION -> return createObjectActionPacket(
                "OPOBJ2",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_THIRD_OPTION -> return createObjectActionPacket(
                "OPOBJ3",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FOURTH_OPTION -> return createObjectActionPacket(
                "OPOBJ4",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FIFTH_OPTION -> return createObjectActionPacket(
                "OPOBJ5",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC -> return createItemOnNPCPacket(
                "OPNPCT",
                id,
                selectedWidget,
                selectedWidgetItemId,
                selectedWidgetSlot,
                false)
            MenuAction.NPC_FIRST_OPTION -> return createNPCActionPacket("OPNPC1", id, false)
            MenuAction.NPC_SECOND_OPTION -> return createNPCActionPacket("OPNPC2", id, false)
            MenuAction.NPC_THIRD_OPTION -> return createNPCActionPacket("OPNPC3", id, false)
            MenuAction.NPC_FOURTH_OPTION -> return createNPCActionPacket("OPNPC4", id, false)
            MenuAction.NPC_FIFTH_OPTION -> return createNPCActionPacket("OPNPC5", id, false)
            MenuAction.ITEM_USE_ON_PLAYER, MenuAction.WIDGET_TARGET_ON_PLAYER -> return createWidgetOnPlayerPacket(
                "OPPLAYERT",
                id,
                selectedWidgetItemId,
                selectedWidgetSlot,
                selectedWidget,
                false)
            MenuAction.PLAYER_FIRST_OPTION -> return createPlayerActionPacket("OPPLAYER1", id, false)
            MenuAction.PLAYER_SECOND_OPTION -> return createPlayerActionPacket("OPPLAYER2", id, false)
            MenuAction.PLAYER_THIRD_OPTION -> return createPlayerActionPacket("OPPLAYER3", id, false)
            MenuAction.PLAYER_FOURTH_OPTION -> return createPlayerActionPacket("OPPLAYER4", id, false)
            MenuAction.PLAYER_FIFTH_OPTION -> return createPlayerActionPacket("OPPLAYER5", id, false)
            MenuAction.PLAYER_SIXTH_OPTION -> return createPlayerActionPacket("OPPLAYER6", id, false)
            MenuAction.PLAYER_SEVENTH_OPTION -> return createPlayerActionPacket("OPPLAYER7", id, false)
            MenuAction.PLAYER_EIGTH_OPTION -> return createPlayerActionPacket("OPPLAYER8", id, false)
            MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM -> return createItemOnGroundItemPacket("OPLOCT",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GROUND_ITEM_FIRST_OPTION -> return createGroundItemActionPacket("OPLOC1",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_SECOND_OPTION -> return createGroundItemActionPacket("OPLOC2",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_THIRD_OPTION -> return createGroundItemActionPacket("OPLOC3",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FOURTH_OPTION -> return createGroundItemActionPacket("OPLOC4",
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FIFTH_OPTION -> return createGroundItemActionPacket("OPLOC5",
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
                return createWidgetOnWidgetPacket("IF_BUTTONT",
                    selectedWidget,
                    selectedWidgetSlot,
                    selectedWidgetItemId,
                    param1,
                    param0,
                    childItemId)
            }
            MenuAction.ITEM_FIRST_OPTION -> return createItemActionPacket("OPHELD1",
                param1,
                id,
                param0
            )
            MenuAction.ITEM_SECOND_OPTION -> return createItemActionPacket("OPHELD2",
                param1,
                id,
                param0
            )
            MenuAction.ITEM_THIRD_OPTION -> return createItemActionPacket("OPHELD3",
                param1,
                id,
                param0
            )
            MenuAction.ITEM_FOURTH_OPTION -> return createItemActionPacket("OPHELD4",
                param1,
                id,
                param0
            )
            MenuAction.ITEM_FIFTH_OPTION -> return createItemActionPacket("OPHELD5",
                param1,
                id,
                param0
            )
            MenuAction.WIDGET_FIRST_OPTION -> return createWidgetActionPacket("IF_BUTTON1",
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_SECOND_OPTION -> return createWidgetActionPacket("IF_BUTTON2",
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_THIRD_OPTION -> return createWidgetActionPacket("IF_BUTTON3",
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FOURTH_OPTION -> return createWidgetActionPacket("IF_BUTTON4",
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FIFTH_OPTION -> return createWidgetActionPacket("IF_BUTTON5",
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_TYPE_1 -> return WidgetPackets.createType1Action(param1)
            MenuAction.WIDGET_CONTINUE -> return WidgetPackets.createContinuePacket(param1, param0)
            MenuAction.WALK -> {
                client.destinationX = param0
                client.destinationY = param1
                return createMovementPacket(
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