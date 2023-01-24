package meteor.plugins.winemaker

import dev.hoot.api.items.Bank
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Widgets
import eventbus.events.GameTick
import meteor.api.Items
import meteor.api.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.InventoryID
import net.runelite.api.ItemID
import net.runelite.api.MenuAction

@PluginDescriptor(name = "Winemaker", description = "Makes wines at the bank", enabledByDefault = false)
class WineMakerPlugin: Plugin() {
    private var ticktimer = 0

    override fun onGameTick(tick: GameTick) {
        val local = client.localPlayer!!

        if (ticktimer > 0) {
            ticktimer--
            return
        }


        if (local.isMoving || local.isAnimating) {
            ticktimer = 1
            return
        }

        val unneeded = Items.getAll()?.filter { it.id != ItemID.GRAPES && it.id != ItemID.JUG_OF_WATER }
        if (unneeded != null) {
            if (!Bank.isOpen()) {
                openBank()
            }
            unneeded.forEach { Items.deposit(it, 9999) }
        }

        if (!Items.inventoryContains(ItemID.GRAPES)) {
            if (!Bank.isOpen()) {
                openBank()
                ticktimer = 1
                return
            }
            if (Bank.contains(ItemID.GRAPES)) {
                val grapes = Items.getFirst(ItemID.GRAPES, container = InventoryID.BANK)
                if (grapes != null) {
                    Items.withdraw(grapes, 14, Bank.WithdrawMode.ITEM)
                }
            }
        }

        if (!Items.inventoryContains(ItemID.JUG_OF_WATER)) {
            if (!Bank.isOpen()) {
                openBank()
                ticktimer = 1
                return
            }
            if (Bank.contains(ItemID.JUG_OF_WATER)) {
                val jugOfWater = Items.getFirst(ItemID.JUG_OF_WATER, container = InventoryID.BANK)
                if (jugOfWater != null) {
                    Items.withdraw(jugOfWater, 14, Bank.WithdrawMode.ITEM)
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

        if (!Items.inventoryContains(ItemID.GRAPES) || !Items.inventoryContains(ItemID.JUG_OF_WATER)) {
            ticktimer = 1
            return
        }


        val grapes = Items.getFirst(ItemID.GRAPES)
        Items.getFirst(ItemID.JUG_OF_WATER)!!.useOn(grapes!!)


        val wineProduction = Widgets.get(270, 14)
        if (wineProduction != null) {
            WidgetPackets.widgetAction(wineProduction, "<col=ff9040>Unfermented wine</col>");
            client.invokeMenuAction(
                "Make",
                "<col=ff9040>Unfermented wine</col>",
                1,
                57,
                -1,
                17694734
            )
            ticktimer = 5
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