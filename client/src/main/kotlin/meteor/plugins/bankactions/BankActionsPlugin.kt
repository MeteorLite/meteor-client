package meteor.plugins.bankactions

import dev.hoot.api.items.Bank
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Widgets
import eventbus.events.GameTick
import meteor.api.items.Items
import meteor.api.npcs.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.InventoryID
import net.runelite.api.MenuAction


//Credits Enjoythements for winemaker code.
@PluginDescriptor(name = "Bank actions", description = "Does skills near bank.", enabledByDefault = false)
class BankActionsPlugin: Plugin() {

    private var config = configuration<BankActionsConfig>()

    private var ticktimer = 0

    override fun onGameTick(tick: GameTick) {
        val local = client.localPlayer!!

        val ingredientName = config.ingredient()
        val containerName = config.container()

        if (ticktimer > 0) {
            ticktimer--
            return
        }


        if (local.isMoving || local.isAnimating) {
            ticktimer = 1
            return
        }

        val unneeded = Items.getAll()?.filter { !it.name?.contains(ingredientName)!! && !it.name?.contains(containerName)!! }
        if (unneeded != null) {
            if (!Bank.isOpen()) {
                openBank()
            }
            unneeded.forEach { Items.deposit(it, 9999) }
        }

        if (!Items.inventoryContains(ingredientName)) {
            if (!Bank.isOpen()) {
                openBank()
                ticktimer = 1
                return
            }
            if (Bank.contains(ingredientName)) {
                val ingredient = Items.getFirst(ingredientName, container = InventoryID.BANK)
                if (ingredient != null) {
                    Items.withdraw(ingredient, 14, Bank.WithdrawMode.ITEM)
                }
            }
        }

        if (!Items.inventoryContains(containerName)) {
            if (!Bank.isOpen()) {
                openBank()
                ticktimer = 1
                return
            }
            if (Bank.contains(containerName)) {
                val container = Items.getFirst(containerName, container = InventoryID.BANK)
                if (container != null) {
                    Items.withdraw(container, 14, Bank.WithdrawMode.ITEM)
                    ticktimer = 1
                    return
                }
            }
        }

        if (Bank.isOpen()) {
            closeBank()
            ticktimer = 1
            return
        }

        if (!Items.inventoryContains(ingredientName) || !Items.inventoryContains(containerName)) {
            ticktimer = 1
            return
        }


        val ingredient = Items.getFirst(ingredientName)
        Items.getFirst(containerName)!!.useOn(ingredient!!)


        val bankAction = Widgets.get(270, 14)
        if (bankAction != null) {
            WidgetPackets.widgetAction(bankAction, "<col=ff9040>" + config.produceditem() + "</col>")
            client.invokeMenuAction(
                config.useoption(),
                "<col=ff9040>" + config.produceditem() + "</col>",
                1,
                57,
                -1,
                17694734
            )
            ticktimer = 5.toInt()
            return
        }
    }

    private fun closeBank() {
        client.invokeMenuAction(
            "Close",
            null,
            1,
            MenuAction.WIDGET_CLOSE.id,
            11,
            786434
        )
    }

    private fun openBank() {
        if (!Bank.isOpen()) {
            val banker = NPCs.getFirst("Banker")
            banker?.interact("Bank")
        }
    }
}