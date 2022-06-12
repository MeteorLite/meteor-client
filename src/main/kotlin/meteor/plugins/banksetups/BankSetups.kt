package meteor.plugins.banksetups

import com.google.gson.reflect.TypeToken
import dev.hoot.api.commons.FileUtil
import dev.hoot.api.game.GameThread
import dev.hoot.api.items.Bank
import dev.hoot.api.items.Equipment
import dev.hoot.api.packets.DialogPackets
import dev.hoot.api.packets.ItemPackets
import dev.hoot.api.packets.MousePackets
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Dialog
import eventbus.events.ClientTick
import eventbus.events.MenuOptionClicked
import meteor.api.items.Bank.getBankItemWidget
import meteor.api.items.Items
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.KeyCode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.awt.Point


@PluginDescriptor(
    name = "Bank Setups",
    description = "Allows saving and loading bank setups. Hold shift to remove setups. Not yet working with noted items :("
)

class BankSetups : Plugin() {
    override var config = configuration<BankSetupConfig>()
    var overlay = overlay(BankSetupsOverlay())
    var state: Int = -1
    var itemManager: ItemManager? = null
    var bankSetups: MutableList<BankSetupObject> = mutableListOf()
    var wait = 0
    var dialogClose = 0

    override fun onStart() {
        state = -1
        when {
            !FileUtil.exists(this, "bankSetups.json") -> {
                FileUtil.writeJson(this, "bankSetups.json", bankSetups)
            }
            else -> {
                bankSetups = FileUtil.readJson(
                    this,
                    "bankSetups.json",
                    object : TypeToken<MutableList<BankSetupObject>>() {})
            }
        }
    }

    override fun onStop() {
        state = -1
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        when {
            "save-current" in it.getMenuOption()!! -> {
                it.consume()
                val invent: List<IntArray> = invent
                val equipment: List<IntArray> = equipment
                nameInput(invent, equipment)
            }
        }

        when {
            "<col=00FFFF>Inventory:</col>" in it.getMenuOption()!! -> {
                it.consume()

                bankSetups[0] = bankSetups[it.getId()]
                state = 1
            }
        }

        when {
            "<col=00FFFF>Remove:</col>" in it.getMenuOption()!! -> {
                it.consume()
                bankSetups.removeAt(it.getId())
                FileUtil.writeJson(this, "bankSetups.json", bankSetups)
            }
        }
    }

    private fun nameInput(invent: List<IntArray>, equipment: List<IntArray>?) {
        bankSetups.add(BankSetupObject(config.setupName(), invent, equipment))
        FileUtil.writeJson(this, "bankSetups.json", bankSetups)
    }

    override fun onClientTick(it: ClientTick) {
        if (wait > 0) {
            if (Dialog.isEnterInputOpen()) {
                GameThread.invoke { client.runScript(138) }
            }
        }

        val firstFree: Int = Items.getFirstEmptySlot()
        when (state) {
            1 -> {
                if (Items.getAllGear() != null) {
                    Bank.depositEquipment()
                }
                if (Items.getAll() != null) {
                    Bank.depositInventory()
                }
                state = 2
            }

            2 -> {
                if (Items.getAllGear() == null && Items.getAll() == null) {
                    bankSetups[0].equipment!!.forEach {
                        var item = getBankItemWidget(it[0])
                        if (item == null) {
                            val y = itemManager!!.canonicalize(it[0])
                            item = getBankItemWidget(y)
                            if (item == null) {
                                return@forEach
                            }

                        }

                        if (it[1] != 1) {
                            WidgetPackets.widgetAction(item, "Withdraw-X")
                            DialogPackets.sendNumberInput(it[1])
                            MousePackets.queueClickPacket(0, 0)
                            ItemPackets.queueItemAction1Packet(
                                WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId,
                                item.itemId,
                                firstFree
                            )
                            return@forEach
                        }

                        WidgetPackets.widgetAction(item, "Withdraw-1")
                        MousePackets.queueClickPacket(0, 0)
                        ItemPackets.queueItemAction1Packet(
                            WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId,
                            item.itemId,
                            firstFree
                        )
                        state = 3
                    }
                }
            }
            3 -> {
                bankSetups[0].equipment!!.forEach {
                    val items = Items.getFirst(*it) ?: return@forEach
                    if (Bank.isOpen()) {
                        MousePackets.queueClickPacket(0, 0)
                        ItemPackets.queueItemAction9Packet(
                            WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId,
                            items.id,
                            items.slot
                        )
                    }
                    state = 4
                }
            }
            4 -> {
                bankSetups[0].inventory.forEach {
                    val item = getBankItemWidget(it[0]) ?: return@forEach
                    MousePackets.queueClickPacket(0, 0)
                    if (it[1] != 1) {
                        WidgetPackets.widgetAction(item, "Withdraw-X")
                        DialogPackets.sendNumberInput(it[1])
                        ItemPackets.queueItemAction1Packet(
                            WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId,
                            item.itemId,
                            firstFree
                        )
                    }
                    wait = 10
                    state = -1
                }
            }

        }
        val incinerator: Widget? = client.getWidget(WidgetInfo.BANK_INCINERATOR)
        if (incinerator != null && Bank.isOpen()) {
            if (!incinerator.isHidden) {
                val p = incinerator.canvasLocation
                val x = p.x
                val y = p.y
                overlay.setPreferredLocation(Point(x, y - (incinerator.height + 5)))
            }
        }
        val mousePoint = client.mouseCanvasPosition
        if (overlay.getBounds()!!.contains(mousePoint.x, mousePoint.y)) {
            client.insertMenuItem("save-current", "", 10000000, 10000, 0, 0, false)

            bankSetups.indices.forEach {
                if (client.isKeyPressed(KeyCode.KC_SHIFT)) {
                    client.insertMenuItem(
                        "<col=00FFFF>Remove:</col><col=93DFB8>${bankSetups[it].name}</col>",
                        "",
                        10000000,
                        it,
                        0,
                        0,
                        false
                    )
                    return@forEach
                }
                client.insertMenuItem(
                    "<col=00FFFF>Inventory:</col><col=93DFB8>${bankSetups[it].name}</col>",
                    "",
                    10000000,
                    it,
                    0,
                    0,
                    false
                )
            }
        }
    }

    val invent: List<IntArray>
        get() {
            val items = Items.getAll()
            return Items.getItems(items!!)
        }

    val equipment: List<IntArray>
        get() {
            val items = Equipment.getAll()
            return Items.getItems(items)
        }

}