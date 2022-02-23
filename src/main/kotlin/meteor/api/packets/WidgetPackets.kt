package meteor.api.packets

import net.runelite.api.Item
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo

object WidgetPackets {
    fun widgetFirstOption(widget: Widget) {
        queueWidgetAction1Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetSecondOption(widget: Widget) {
        queueWidgetAction2Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetThirdOption(widget: Widget) {
        queueWidgetAction3Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetFourthOption(widget: Widget) {
        queueWidgetAction4Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetFifthOption(widget: Widget) {
        queueWidgetAction5Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetSixthOption(widget: Widget) {
        queueWidgetAction6Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetSeventhOption(widget: Widget) {
        queueWidgetAction7Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetEighthOption(widget: Widget) {
        queueWidgetAction8Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetNinthOption(widget: Widget) {
        queueWidgetAction9Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetTenthOption(widget: Widget) {
        queueWidgetAction10Packet(widget.id, widget.itemId, widget.index)
    }

    fun widgetItemAction(container: WidgetInfo, item: Item, action: String) {
        val actions = item.actions ?: return
        val index = actions.indexOf(action)
        widgetItemAction(container, item, index)
    }

    fun widgetItemAction(container: WidgetInfo, item: Item, index: Int) {
        val widgetPackedId: Int = container.packedId
        val itemId = item.id
        val itemSlot = item.slot
        when (index) {
            0 -> queueWidgetAction1Packet(widgetPackedId, itemId, itemSlot)
            1 -> queueWidgetAction2Packet(widgetPackedId, itemId, itemSlot)
            2 -> queueWidgetAction3Packet(widgetPackedId, itemId, itemSlot)
            3 -> queueWidgetAction4Packet(widgetPackedId, itemId, itemSlot)
            4 -> queueWidgetAction5Packet(widgetPackedId, itemId, itemSlot)
            5 -> queueWidgetAction6Packet(widgetPackedId, itemId, itemSlot)
            6 -> queueWidgetAction7Packet(widgetPackedId, itemId, itemSlot)
            7 -> queueWidgetAction8Packet(widgetPackedId, itemId, itemSlot)
            8 -> queueWidgetAction9Packet(widgetPackedId, itemId, itemSlot)
            9 -> queueWidgetAction10Packet(widgetPackedId, itemId, itemSlot)
        }
    }

    fun widgetAction(widget: Widget, action: String) {
        val actions = widget.actions ?: return
        val index = actions.indexOf(action)
        when (index) {
            0 -> widgetFirstOption(widget)
            1 -> widgetSecondOption(widget)
            2 -> widgetThirdOption(widget)
            3 -> widgetFourthOption(widget)
            4 -> widgetFifthOption(widget)
            5 -> widgetSixthOption(widget)
            6 -> widgetSeventhOption(widget)
            7 -> widgetEighthOption(widget)
            8 -> widgetNinthOption(widget)
            9 -> widgetTenthOption(widget)
        }
    }

    fun queueWidgetAction1Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON1(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction2Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON2(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction3Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON3(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction4Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON4(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction5Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON5(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction6Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON6(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction7Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON7(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction8Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON8(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction9Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON9(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueWidgetAction10Packet(widgetId: Int, itemId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.IF_BUTTON10(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        packetBufferNode.packetBuffer.writeShort(itemId)
        client.packetWriter.queuePacket(packetBufferNode)
    }

    fun queueResumePauseWidgetPacket(widgetId: Int, childId: Int) {
        val client = Main.client
        val clientPacket = Main.clientPacket
        val packetBufferNode =
            client.preparePacket(clientPacket.RESUME_PAUSEBUTTON(), client.packetWriter.isaacCipher)
        packetBufferNode.packetBuffer.writeInt(widgetId)
        packetBufferNode.packetBuffer.writeShort(childId)
        client.packetWriter.queuePacket(packetBufferNode)
    }
}