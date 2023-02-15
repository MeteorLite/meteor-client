package meteor.plugins.banksetups

import com.google.gson.reflect.TypeToken
import dev.hoot.api.commons.FileUtil
import dev.hoot.api.items.Bank
import dev.hoot.api.items.Equipment
import dev.hoot.api.packets.ItemPackets
import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.api.ClientPackets
import meteor.api.Items
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.InventoryID
import net.runelite.api.KeyCode
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.awt.Point


@PluginDescriptor(
    name = "Bank Setups",
    description = "Allows saving and loading bank setups. Hold shift to remove setups. Not yet working with noted items :("
)

class BankSetups : Plugin() {
    var config = configuration<BankSetupConfig>()
    var overlay = overlay(BankSetupsOverlay())
    var state: Int = -1
    var itemManager: ItemManager? = null
    var bankSetups: MutableList<BankSetupObject> = mutableListOf()
    var wait = 0

    override fun onStart() {
        state = -1
        itemManager = ItemManager
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
        if (overlay.bounds!!.contains(mousePoint.x, mousePoint.y)) {
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

    override fun onGameTick(it: GameTick) {
        if(wait > 0){
            wait--
            return
        }
        when (state) {
            1 -> {
                if (Items.getAll(InventoryID.EQUIPMENT) != null) {
                    Bank.depositEquipment()
                }
                if (Items.getAll() != null) {
                    Bank.depositInventory()
                }
                state = 2
            }

            2 -> {
                if (Items.getAll(InventoryID.EQUIPMENT).isNullOrEmpty() && Items.getAll().isNullOrEmpty()) {
                    bankSetups[0].equipment!!.forEach {
                        val itemToWithdraw = Items.getFirst(it[0], InventoryID.BANK)

                        if (itemToWithdraw != null) {
                            if(it[1] > 28){
                                Items.withdrawAll(itemToWithdraw, Bank.WithdrawMode.ITEM)
                            } else {
                                Items.withdraw(itemToWithdraw, it[1], Bank.WithdrawMode.ITEM)
                            }
                        }
                        return@forEach
                    }
                    state = 3
                    wait = 2
                }
            }

            3 -> {
                bankSetups[0].equipment!!.forEach {
                    val item = Items.getFirst(*it) ?: return@forEach
                    if (Bank.isOpen()) {
                        ItemPackets.queueItemAction9Packet(
                            WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.packedId,
                            item.id,
                            item.slot
                        )
                        ClientPackets.queueClickPacket(item.clickPoint)
                    }
                }
                state = 4
            }

            4 -> {
                bankSetups[0].inventory.forEach {
                    val itemToWithdraw = Items.getFirst(it[0], InventoryID.BANK)
                    if (itemToWithdraw != null) {
                        if(it[1] > 28){
                            Items.withdrawAll(itemToWithdraw, Bank.WithdrawMode.ITEM)
                        } else {
                            Items.withdraw(itemToWithdraw, it[1], Bank.WithdrawMode.ITEM)
                        }
                    }
                    return@forEach
                }
                state = -1
            }

        }
    }

    val invent: List<IntArray>
        get() {
            Items.getAll()?.let {
                return Items.getItems(it)
            }
            return emptyList()
        }

    val equipment: List<IntArray>
        get() {
            Equipment.getAll()?.let {
                return Items.getItems(it)
            }
            return emptyList()
        }

}