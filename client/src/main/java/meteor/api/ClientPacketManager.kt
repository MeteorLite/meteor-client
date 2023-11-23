package meteor.api

import ClientPacket
import dev.hoot.api.InteractionException
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Widgets
import meteor.Main
import meteor.api.ClientPackets.createClickPacket
import meteor.api.ClientPackets.createGroundItemAction1Packet
import meteor.api.ClientPackets.createGroundItemAction2Packet
import meteor.api.ClientPackets.createGroundItemAction3Packet
import meteor.api.ClientPackets.createGroundItemAction4Packet
import meteor.api.ClientPackets.createGroundItemAction5Packet
import meteor.api.ClientPackets.createItemWidgetOnGameObjectPacket
import meteor.api.ClientPackets.createItemWidgetOnNPCPacket
import meteor.api.ClientPackets.createItemWidgetOnPlayerPacket
import meteor.api.ClientPackets.createNPCAction1Packet
import meteor.api.ClientPackets.createNPCAction2Packet
import meteor.api.ClientPackets.createNPCAction3Packet
import meteor.api.ClientPackets.createNPCAction4Packet
import meteor.api.ClientPackets.createNPCAction5Packet
import meteor.api.ClientPackets.createObjectAction1Packet
import meteor.api.ClientPackets.createObjectAction2Packet
import meteor.api.ClientPackets.createObjectAction3Packet
import meteor.api.ClientPackets.createObjectAction4Packet
import meteor.api.ClientPackets.createObjectAction5Packet
import meteor.api.ClientPackets.createPlayerAction1Packet
import meteor.api.ClientPackets.createPlayerAction2Packet
import meteor.api.ClientPackets.createPlayerAction3Packet
import meteor.api.ClientPackets.createPlayerAction4Packet
import meteor.api.ClientPackets.createPlayerAction5Packet
import meteor.api.ClientPackets.createPlayerAction6Packet
import meteor.api.ClientPackets.createPlayerAction7Packet
import meteor.api.ClientPackets.createPlayerAction8Packet
import meteor.plugins.meteor.AutoInteractOverlay
import meteor.rs.ClientThread
import net.runelite.api.MenuAction
import net.runelite.api.packets.PacketBufferNode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetType
import java.awt.Point

fun preparePacketBuffer(opcode: Int, size: Int): PacketBufferNode {

    val clientPacket = Main.client.createClientPacket(opcode, size)
    return Main.client.preparePacket(
        clientPacket,
        Main.client.packetWriter.isaacCipher
    )
}
fun preparePacketBuffer(clientPacket: ClientPacket): PacketBufferNode {
    val clientPacket = Main.client.createClientPacket(clientPacket.id, clientPacket.length)
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
    ClientThread.invoke { createClickPacket(mouseInfo, x, y).send() }
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

//remake this function with named arguments

fun createClientPacket(menu: AutomatedMenu): PacketBufferNode? {
    val opcode = menu.opcode
    val client = Main.client
    val id = menu.identifier
    val param0 = menu.param0
    val param1 = menu.param1
    var selectedWidgetItemId = client.selectedSpellItemId
    var selectedWidgetSlot = client.selectedSpellChildIndex
    val selectedWidget = client.selectedSpellWidget
    var result: PacketBufferNode? = null
    result = when (opcode) {
        MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT -> createItemWidgetOnGameObjectPacket(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            selectedSpellChildIndex = selectedWidgetSlot,
            selectedSpellItemId = selectedWidgetItemId,
            selectedSpellWidget = selectedWidget,
            shiftPressed = false
        )
        MenuAction.GAME_OBJECT_FIRST_OPTION -> createObjectAction1Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GAME_OBJECT_SECOND_OPTION -> createObjectAction2Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GAME_OBJECT_THIRD_OPTION -> createObjectAction3Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GAME_OBJECT_FOURTH_OPTION -> createObjectAction4Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GAME_OBJECT_FIFTH_OPTION -> createObjectAction5Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC -> createItemWidgetOnNPCPacket(
            id = id,
            selectedSpellWidget = selectedWidget,
            selectedSpellItemId = selectedWidgetItemId,
            selectedSpellChildIndex = selectedWidgetSlot,
            shiftPressed = false
        )
        MenuAction.NPC_FIRST_OPTION -> createNPCAction1Packet(id = id, shiftPressed = false)
        MenuAction.NPC_SECOND_OPTION -> createNPCAction2Packet(id = id, shiftPressed = false)
        MenuAction.NPC_THIRD_OPTION -> createNPCAction3Packet(id = id, shiftPressed = false)
        MenuAction.NPC_FOURTH_OPTION -> createNPCAction4Packet(id = id, shiftPressed = false)
        MenuAction.NPC_FIFTH_OPTION -> createNPCAction5Packet(id = id, shiftPressed = false)
        MenuAction.ITEM_USE_ON_PLAYER, MenuAction.WIDGET_TARGET_ON_PLAYER -> createItemWidgetOnPlayerPacket(
            id = id,
            selectedSpellItemId = selectedWidgetItemId,
            selectedSpellChildIndex = selectedWidgetSlot,
            selectedSpellWidget = selectedWidget,
            shiftPressed = false
        )
        MenuAction.PLAYER_FIRST_OPTION -> createPlayerAction1Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_SECOND_OPTION -> createPlayerAction2Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_THIRD_OPTION -> createPlayerAction3Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_FOURTH_OPTION -> createPlayerAction4Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_FIFTH_OPTION -> createPlayerAction5Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_SIXTH_OPTION -> createPlayerAction6Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_SEVENTH_OPTION -> createPlayerAction7Packet(id = id, shiftPressed = false)
        MenuAction.PLAYER_EIGTH_OPTION -> createPlayerAction8Packet(id = id, shiftPressed = false)
/*        MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM -> createItemWidgetOnGroundItemPacket(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            selectedSpellChildIndex = selectedWidgetSlot,
            selectedWidgetItemId = selectedWidgetItemId,
            selectedSpellWidget = selectedWidget,
            shiftPressed = false
        )*/
        MenuAction.GROUND_ITEM_FIRST_OPTION -> createGroundItemAction1Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GROUND_ITEM_SECOND_OPTION -> createGroundItemAction2Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GROUND_ITEM_THIRD_OPTION -> createGroundItemAction3Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GROUND_ITEM_FOURTH_OPTION -> createGroundItemAction4Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
        )
        MenuAction.GROUND_ITEM_FIFTH_OPTION -> createGroundItemAction5Packet(
            id = id,
            worldX = param0 + client.baseX,
            worldY = param1 + client.baseY,
            shiftPressed = false
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
            ClientPackets.createItemWidgetOnItemWidgetPacket(
                widgetID = selectedWidget,
                slot = selectedWidgetSlot,
                selectedSpellItemId = selectedWidgetItemId,
                id = param1,
                itemId = param0,
                selectedSpellChildIndex = childItemId
            )
        }
        MenuAction.WIDGET_FIRST_OPTION -> ClientPackets.createWidgetAction1Packet(
            param1 = param1,
            itemId = -1,
            param0 = param0
        )
        MenuAction.WIDGET_SECOND_OPTION -> ClientPackets.createWidgetAction2Packet(
            param1 = param1,
            itemId = -1,
            param0 = param0
        )
        MenuAction.WIDGET_THIRD_OPTION -> ClientPackets.createWidgetAction3Packet(
            param1 = param1,
            itemId = -1,
            param0 = param0
        )
        MenuAction.WIDGET_FOURTH_OPTION -> ClientPackets.createWidgetAction4Packet(
            param1 = param1,
            itemId = -1,
            param0 = param0
        )
        MenuAction.WIDGET_FIFTH_OPTION -> ClientPackets.createWidgetAction5Packet(
            param1 = param1,
            itemId = -1,
            param0 = param0
        )
        MenuAction.WIDGET_TYPE_1 -> WidgetPackets.createType1Action(param1)
        //MenuAction.WIDGET_CONTINUE -> WidgetPackets.createContinuePacket(parentId = param1, slotId = param0)
        MenuAction.WALK -> {

            client.destinationX = param0
            client.destinationY = param1
            ClientPackets.createMovementPacket(
                five = 5,
                x = param0 + client.baseX,
                y = param1 + client.baseY,
                shiftPressed = false
            )
        }
        MenuAction.CC_OP_LOW_PRIORITY,
        MenuAction.CC_OP -> {

            val widget = Widgets.fromId(param1)
            var child: Widget? = null
            if (param0 != -1)
                child = widget?.getChild(param0)
                createDefaultAction(id, param1, child?.itemId ?: -1, param0)

        }
        else -> null
    }
    result?.let {
        Main.logger.warn("--Auto-Packet-- ${opcode.name} id:$id :param0:$param0 param1: $param1")
        return it
    }
    throw InteractionException("Couldn't parse packet from opcode: $opcode")




}
fun createDefaultAction(type: Int, widgetPackedId: Int, itemId: Int, itemSlot: Int): PacketBufferNode {
   return when(type){
        1 -> ClientPackets.createWidgetAction1Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        2 -> ClientPackets.createWidgetAction2Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        3 -> ClientPackets.createWidgetAction3Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        4 -> ClientPackets.createWidgetAction4Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        5 -> ClientPackets.createWidgetAction5Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        6 -> ClientPackets.createWidgetAction6Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        7 -> ClientPackets.createWidgetAction7Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        8 -> ClientPackets.createWidgetAction8Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        9 -> ClientPackets.createWidgetAction9Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )
        10 -> ClientPackets.createWidgetAction10Packet(
            param1 = widgetPackedId,
            itemId = itemId,
            param0 = itemSlot
        )

       else -> {
           Main.logger.warn("Couldn't parse packet from type: $type")
           throw InteractionException("Couldn't parse packet from type: $type")
       }
   }
}