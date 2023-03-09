@file:Suppress("DEPRECATION")
package meteor.api

import dev.hoot.api.InteractionException
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Widgets
import meteor.Main
import meteor.plugins.meteor.AutoInteractOverlay
import meteor.rs.ClientThread.invoke
import net.runelite.api.MenuAction
import net.runelite.api.packets.PacketBufferNode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetType
import java.awt.Point

/**
 * an object for calling various Client Packets
 * @author Null
 */
object ClientPackets {

    // OPLOC1
    // param0: worldX
    // param1: worldY
    fun createGroundItemAction1Packet(groundItemId: Int, worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(18, 7)
        bufferNode.packetBuffer.`writeShortLE$api`(worldX)
        bufferNode.packetBuffer.`writeShort$api`(worldY)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortLE$api`(groundItemId)
        return bufferNode
    }

    // OPLOC2
    // param0: worldX
    // param1: worldY
    fun createGroundItemAction2Packet(groundItemId: Int, worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(22, 7)
        bufferNode.packetBuffer.`writeShortAddLE$api`(groundItemId)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
        bufferNode.packetBuffer.`writeShortLE$api`(worldX)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // OPLOC3
    // param0: worldX
    // param1: worldY
    fun createGroundItemAction3Packet(groundItemId: Int, worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(67, 7)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortAdd$api`(groundItemId)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
        return bufferNode
    }

    // OPLOC4
    // param0: worldX
    // param1: worldY
    fun createGroundItemAction4Packet(groundItemId: Int, worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(11, 7)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
        bufferNode.packetBuffer.`writeShortLE$api`(groundItemId)
        bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // OPLOC5
    // param0: worldX
    // param1: worldY
    fun createGroundItemAction5Packet(groundItemId: Int, worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(70, 7)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(worldY)
        bufferNode.packetBuffer.`writeShortLE$api`(worldX)
        bufferNode.packetBuffer.`writeShortAdd$api`(groundItemId)
        return bufferNode
    }

    // OPOBJ1
    // param0: worldX
    // param1: worldY
    fun createObjectAction1Packet(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(78, 7)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortAddLE$api`(objectID)
        bufferNode.packetBuffer.`writeShort$api`(worldX)
        bufferNode.packetBuffer.`writeShortLE$api`(worldY)
        return bufferNode
    }

    // OPOBJ2
    // param0: worldX
    // param1: worldY
    fun createObjectAction2Packet(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(43, 7)
        bufferNode.packetBuffer.`writeShort$api`(worldY)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldX)
        bufferNode.packetBuffer.`writeShortLE$api`(objectID)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // OPOBJ3
    // param0: worldX
    // param1: worldY
    fun createObjectAction3Packet(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(40, 7)
        bufferNode.packetBuffer.`writeShortAddLE$api`(worldY)
        bufferNode.packetBuffer.`writeShortAddLE$api`(objectID)
        bufferNode.packetBuffer.`writeShortLE$api`(worldX)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // OPOBJ4
    // param0: worldX
    // param1: worldY
    fun createObjectAction4Packet(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(32, 7)
        bufferNode.packetBuffer.`writeShort$api`(objectID)
        bufferNode.packetBuffer.`writeShortAddLE$api`(worldX)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // OPOBJ5
    // param0: worldX
    // param1: worldY
    fun createObjectAction5Packet(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(42, 7)
        bufferNode.packetBuffer.`writeShortAddLE$api`(objectID)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(worldY)
        bufferNode.packetBuffer.`writeShort$api`(worldX)
        return bufferNode
    }

    // OPOBJT
    // param0: worldX
    // param1: worldY
    fun createItemWidgetOnGameObjectPacket(
        objectID: Int,
        worldX: Int,
        worldY: Int,
        itemSlot: Int,
        itemId: Int,
        itemWidgetID: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(7, 15)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        bufferNode.packetBuffer.`writeIntIME$api`(itemWidgetID)
        bufferNode.packetBuffer.`writeShort$api`(worldX)
        bufferNode.packetBuffer.`writeShort$api`(objectID)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
        bufferNode.packetBuffer.`writeShort$api`(itemSlot)
        return bufferNode
    }

    //OPNPCT
    fun createItemWidgetOnNPCPacket(
        npcIdx: Int,
        itemWidgetID: Int,
        itemID: Int,
        itemSlot: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(48, 11)
        bufferNode.packetBuffer.`writeShortLE$api`(itemSlot)
        bufferNode.packetBuffer.`writeShortAdd$api`(npcIdx)
        bufferNode.packetBuffer.`writeShort$api`(itemID)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeIntIME$api`(itemWidgetID)
        return bufferNode
    }

    //OPNPC1
    fun createNPCAction1Packet(npcIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(86, 3)
        bufferNode.packetBuffer.`writeShort$api`(npcIdx)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    //OPNPC2
    fun createNPCAction2Packet(npcIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(20, 3)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortLE$api`(npcIdx)
        return bufferNode
    }

    //OPNPC3
    fun createNPCAction3Packet(npcIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(80, 3)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(npcIdx)
        return bufferNode
    }

    //OPNPC4
    fun createNPCAction4Packet(npcIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(68, 3)
        bufferNode.packetBuffer.`writeShort$api`(npcIdx)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    //OPNPC5
    fun createNPCAction5Packet(npcIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(92, 3)
        bufferNode.packetBuffer.`writeShortAdd$api`(npcIdx)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    //OPPLAYERT
    fun createItemWidgetOnPlayerPacket(
        playerIdx: Int,
        itemId: Int,
        itemSlot: Int,
        itemWidgetID: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(69, 11)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortAddLE$api`(itemSlot)
        bufferNode.packetBuffer.`writeShortLE$api`(itemId)
        bufferNode.packetBuffer.`writeIntME$api`(itemWidgetID)
        bufferNode.packetBuffer.`writeShortAddLE$api`(playerIdx)
        return bufferNode
    }

    ///OPPLAYER1
    fun createPlayerAction1Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(13, 3)
        bufferNode.packetBuffer.`writeShort$api`(playerIdx)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    ///OPPLAYER2
    fun createPlayerAction2Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(45, 3)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(playerIdx)
        return bufferNode
    }

    ///OPPLAYER3
    fun createPlayerAction3Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(1, 3)
        bufferNode.packetBuffer.`writeShortAddLE$api`(playerIdx)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    ///OPPLAYER4
    fun createPlayerAction4Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(31, 3)
        bufferNode.packetBuffer.`writeShortAddLE$api`(playerIdx)
        bufferNode.packetBuffer.`writeByteNeg$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    ///OPPLAYER5
    fun createPlayerAction5Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(35, 3)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShort$api`(playerIdx)
        return bufferNode
    }

    ///OPPLAYER6
    fun createPlayerAction6Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(30, 3)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        bufferNode.packetBuffer.`writeShortAdd$api`(playerIdx)
        return bufferNode
    }

    ///OPPLAYER7
    fun createPlayerAction7Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(73, 3)
        bufferNode.packetBuffer.`writeShort$api`(playerIdx)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    ///OPPLAYER8
    fun createPlayerAction8Packet(playerIdx: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(49, 3)
        bufferNode.packetBuffer.`writeShortAdd$api`(playerIdx)
        bufferNode.packetBuffer.`writeByte$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    //OPLOCT
    fun createItemWidgetOnGroundItemPacket(
        groundItemID: Int,
        worldX: Int,
        worldY: Int,
        itemSlot: Int,
        itemID: Int,
        itemWidgetID: Int,
        shiftPressed: Boolean
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(44, 15)
        bufferNode.packetBuffer.`writeShortLE$api`(worldX)
        bufferNode.packetBuffer.`writeInt$api`(itemWidgetID)
        bufferNode.packetBuffer.`writeShortLE$api`(itemSlot)
        bufferNode.packetBuffer.`writeShortLE$api`(itemID)
        bufferNode.packetBuffer.`writeShortAddLE$api`(groundItemID)
        bufferNode.packetBuffer.`writeShort$api`(worldY)
        bufferNode.packetBuffer.`writeByteSigned$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    //IF_BUTTONT
    // param0: destinationSlot
    // param1: destinationWidgetId
    fun createItemWidgetOnItemWidgetPacket(
        sourceWidgetId: Int,
        sourceSlot: Int,
        sourceItemId: Int,
        destinationWidgetId: Int,
        destinationSlot: Int,
        destinationItemId: Int
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(57, 16)
        bufferNode.packetBuffer.`writeShort$api`(sourceItemId)
        bufferNode.packetBuffer.`writeShortAdd$api`(destinationItemId)
        bufferNode.packetBuffer.`writeShortAddLE$api`(sourceSlot)
        bufferNode.packetBuffer.`writeShort$api`(destinationSlot)
        bufferNode.packetBuffer.`writeIntLE$api`(destinationWidgetId)
        bufferNode.packetBuffer.`writeIntME$api`(sourceWidgetId)
        return bufferNode
    }

    // IF_BUTTON1
    // param0: childId
    // param1: widgetId
    fun createWidgetAction1Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(58, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON2
    // param0: childId
    // param1: widgetId
    fun createWidgetAction2Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(2, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON3
    // param0: childId
    // param1: widgetId
    fun createWidgetAction3Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(75, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON4
    // param0: childId
    // param1: widgetId
    fun createWidgetAction4Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(50, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON5
    // param0: childId
    // param1: widgetId
    fun createWidgetAction5Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(60, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON6
    // param0: childId
    // param1: widgetId
    fun createWidgetAction6Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(23, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON7
    // param0: childId
    // param1: widgetId
    fun createWidgetAction7Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(17, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON8
    // param0: childId
    // param1: widgetId
    fun createWidgetAction8Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(21, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON9
    // param0: childId
    // param1: widgetId
    fun createWidgetAction9Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(24, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // IF_BUTTON10
    // param0: childId
    // param1: widgetId
    fun createWidgetAction10Packet(
        widgetId: Int,
        itemId: Int,
        childId: Int,
    ): PacketBufferNode {
        val bufferNode = preparePacketBuffer(52, 8)
        bufferNode.packetBuffer.`writeInt$api`(widgetId)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeShort$api`(itemId)
        return bufferNode
    }

    // CLICK
    fun createClickPacket(mouseInfo: Int, x: Int, y: Int): PacketBufferNode {
        val bufferNode = preparePacketBuffer(83, 6)
        bufferNode.packetBuffer.`writeShort$api`(mouseInfo)
        bufferNode.packetBuffer.`writeShort$api`(x)
        bufferNode.packetBuffer.`writeShort$api`(y)
        return bufferNode
    }

    // WALK
    fun createMovementPacket(worldX: Int, worldY: Int, shiftPressed: Boolean): PacketBufferNode {
        val bufferNode = preparePacketBuffer(34, -1)
        bufferNode.packetBuffer.`writeByte$api`(5)
        bufferNode.packetBuffer.`writeShortAdd$api`(worldY)
        bufferNode.packetBuffer.`writeShort$api`(worldX)
        bufferNode.packetBuffer.`writeByteAdd$api`(if (shiftPressed) 1 else 0)
        return bufferNode
    }

    // CONTINUE
    fun createContinuePacket(widgetId: Int, childId: Int): PacketBufferNode {
        val bufferNode = preparePacketBuffer(10, 6)
        bufferNode.packetBuffer.`writeShort$api`(childId)
        bufferNode.packetBuffer.`writeIntME$api`(widgetId)
        return bufferNode
    }

    /**
     * creates a new packetBuffer with the provided [opcode] and [size]
     */
    fun preparePacketBuffer(opcode: Int, size: Int): PacketBufferNode {
        val clientPacket = Main.client.createClientPacket(opcode, size)
        return Main.client.preparePacket(
            clientPacket,
            Main.client.packetWriter.isaacCipher
        )
    }

    fun queueClickPacket(clickPoint: Point) {
        AutoInteractOverlay.interactPoint = clickPoint
        queueClickPacket(clickPoint.x, clickPoint.y)
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
        Main.logger.error("--Click-Packet-- $x.$y")
    }

    fun createClickPacket(x: Int, y: Int, override: Boolean = false): PacketBufferNode {
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
        return createClickPacket(mouseInfo.toInt(), x, y)
    }

    /**
     * attempts to create a client packet from the provided [menu]
     * @param menu the menu we extract the information that we need to create the packet
     */
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
        var result : PacketBufferNode? = null
        result = when (opcode) {
            MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT -> createItemWidgetOnGameObjectPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GAME_OBJECT_FIRST_OPTION -> createObjectAction1Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_SECOND_OPTION -> createObjectAction2Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_THIRD_OPTION -> createObjectAction3Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FOURTH_OPTION -> createObjectAction4Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GAME_OBJECT_FIFTH_OPTION -> createObjectAction5Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC -> createItemWidgetOnNPCPacket(
                id,
                selectedWidget,
                selectedWidgetItemId,
                selectedWidgetSlot,
                false)
            MenuAction.NPC_FIRST_OPTION -> createNPCAction1Packet(id, false)
            MenuAction.NPC_SECOND_OPTION -> createNPCAction2Packet(id, false)
            MenuAction.NPC_THIRD_OPTION -> createNPCAction3Packet(id, false)
            MenuAction.NPC_FOURTH_OPTION -> createNPCAction4Packet(id, false)
            MenuAction.NPC_FIFTH_OPTION -> createNPCAction5Packet(id, false)
            MenuAction.ITEM_USE_ON_PLAYER, MenuAction.WIDGET_TARGET_ON_PLAYER -> createItemWidgetOnPlayerPacket(
                id,
                selectedWidgetItemId,
                selectedWidgetSlot,
                selectedWidget,
                false)
            MenuAction.PLAYER_FIRST_OPTION -> createPlayerAction1Packet(id, false)
            MenuAction.PLAYER_SECOND_OPTION -> createPlayerAction2Packet(id, false)
            MenuAction.PLAYER_THIRD_OPTION -> createPlayerAction3Packet(id, false)
            MenuAction.PLAYER_FOURTH_OPTION -> createPlayerAction4Packet(id, false)
            MenuAction.PLAYER_FIFTH_OPTION -> createPlayerAction5Packet(id, false)
            MenuAction.PLAYER_SIXTH_OPTION -> createPlayerAction6Packet(id, false)
            MenuAction.PLAYER_SEVENTH_OPTION -> createPlayerAction7Packet(id, false)
            MenuAction.PLAYER_EIGTH_OPTION -> createPlayerAction8Packet(id, false)
            MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM -> createItemWidgetOnGroundItemPacket(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                selectedWidgetSlot,
                selectedWidgetItemId,
                selectedWidget,
                false
            )
            MenuAction.GROUND_ITEM_FIRST_OPTION -> createGroundItemAction1Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_SECOND_OPTION -> createGroundItemAction2Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_THIRD_OPTION -> createGroundItemAction3Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FOURTH_OPTION -> createGroundItemAction4Packet(
                id,
                param0 + client.baseX,
                param1 + client.baseY,
                false
            )
            MenuAction.GROUND_ITEM_FIFTH_OPTION -> createGroundItemAction5Packet(
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
                createItemWidgetOnItemWidgetPacket(
                    selectedWidget,
                    selectedWidgetSlot,
                    selectedWidgetItemId,
                    param1,
                    param0,
                    childItemId)
            }
            MenuAction.WIDGET_FIRST_OPTION -> createWidgetAction1Packet(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_SECOND_OPTION -> createWidgetAction2Packet(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_THIRD_OPTION -> createWidgetAction3Packet(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FOURTH_OPTION -> createWidgetAction4Packet(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_FIFTH_OPTION -> createWidgetAction5Packet(
                param1,
                -1,
                param0
            )
            MenuAction.WIDGET_TYPE_1 -> WidgetPackets.createType1Action(param1)
            MenuAction.WIDGET_CONTINUE -> WidgetPackets.createContinuePacket(param1, param0)
            MenuAction.WALK -> {
                client.destinationX = param0
                client.destinationY = param1
                createMovementPacket(
                    param0 + client.baseX,
                    param1 + client.baseY,
                    false
                )
            }
            MenuAction.CC_OP_LOW_PRIORITY,
            MenuAction.CC_OP -> {
                val widget = Widgets.fromId(param1) ?: null
                var child: Widget? = null
                if (param0 != -1)
                    child = widget!!.getChild(param0)

                if (child == null)
                    WidgetPackets.createDefaultAction(id, param1, -1, param0)
                else
                    WidgetPackets.createDefaultAction(id, param1, child.itemId, param0)
            }
            else -> null
        }
        result?.let {
            val packetType = opcode
            Main.logger.warn("--Auto-Packet-- ${packetType.name} id:$id :param0:$param0 param1: $param1")
            return it
        }
        throw InteractionException("Couldn't parse packet from opcode: $opcode")
    }
}