package meteor.api.items

import dev.hoot.api.commons.Time
import dev.hoot.api.game.GameThread
import dev.hoot.api.items.Bank
import dev.hoot.api.items.Bank.WithdrawMode
import dev.hoot.api.items.Bank.WithdrawOption
import dev.hoot.api.widgets.Dialog
import meteor.Logger
import meteor.api.packets.ClientPackets.createClientPacket
import net.runelite.api.*
import net.runelite.api.Item
import net.runelite.api.widgets.WidgetInfo
import java.util.*

class Item(client: Client, id: Int, quantity: Int) : Item(client, id, quantity) {
    val log = Logger("[$name]")

    fun use() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Use]")
        client!!.selectedSpellWidget = widgetId
        client!!.selectedSpellChildIndex = slot
        client!!.selectedSpellItemId = id
    }

    fun useOn(item: meteor.api.items.Item) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        GameThread.invoke {
            log.info("[Use-on Item] [${item.name}]")
            item.getMenu(0, MenuAction.WIDGET_TARGET_ON_WIDGET.id)?.let { createClientPacket(it) }!!.send()
        }
    }

    fun useOn(npc: meteor.api.npcs.NPC) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        GameThread.invoke {
            log.info("[Use-on NPC] [${npc.npc.name}]")
            createClientPacket(npc.npc.getMenu(0, MenuAction.WIDGET_TARGET_ON_NPC.id))!!.send()
        }
    }

    fun useOn(player: Player) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        GameThread.invoke {
            log.info("[Use-on Player] [${player.name}]")
            createClientPacket(player.getMenu(0, MenuAction.WIDGET_TARGET_ON_PLAYER.id))!!.send()
        }
    }

    fun useOn(loot: TileItem) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        GameThread.invoke {
            log.info("[Use-on Loot] [${loot.getName()}]")
            createClientPacket(loot.getMenu(0, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM.id))!!.send()
        }
    }

    fun useOn(obj: meteor.api.objects.Object) {
        widgetId = WidgetInfo.INVENTORY.packedId
        use()
        GameThread.invoke {
            log.info("[Use-on Object] [${obj.obj.name}]")
            createClientPacket(obj.obj.getMenu(0, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT.id))!!.send()
        }
    }

    fun spellUseOn() {
        widgetId = WidgetInfo.INVENTORY.packedId
        GameThread.invoke {
            log.info("[Spell Use-on]")
            slot = Items.getSlot(id)
            getMenu(0, MenuAction.WIDGET_USE_ON_ITEM.id)?.let { createClientPacket(it) }!!.send()
        }
    }

    fun wield() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Wield]")
        interact("Wield")
    }

    fun eat() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Eat]")
        interact("Eat")
    }

    fun drop() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Drop]")
        interact("Drop")
    }

    fun rub() {
        widgetId = WidgetInfo.INVENTORY.packedId
        log.info("[Rub]")
        interact("Rub")
    }

    fun deposit(amount: Int) {
        if (Bank.isOpen()) {
            widgetId = calculateWidgetId(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)

            val withdrawOption = WithdrawOption.ofAmount(this, amount)

            if (withdrawOption == WithdrawOption.X && hasAction("Deposit-$amount")) {
                interact(WithdrawOption.LAST_QUANTITY.menuIndex + 1)
            } else {
                val menu = getMenu(withdrawOption.menuIndex + 1)
                menu?.let {
                    createClientPacket(it)!!.send()
                    if (withdrawOption == WithdrawOption.X) {
                        Dialog.enterInput(amount)
                    }
                }
            }
        }
    }

    fun withdraw(amount: Int, withdrawMode: WithdrawMode? = WithdrawMode.DEFAULT) {
        if (Bank.isOpen()) {
            widgetId = calculateWidgetId(WidgetInfo.BANK_ITEM_CONTAINER)

            val withdrawOption = WithdrawOption.ofAmount(this, amount)
            if (withdrawMode == WithdrawMode.NOTED && !Bank.isNotedWithdrawMode()) {
                Bank.setWithdrawMode(true)
                Time.sleepUntil({ Bank.isNotedWithdrawMode() }, 1200)
            }

            if (withdrawMode == WithdrawMode.ITEM && Bank.isNotedWithdrawMode()) {
                Bank.setWithdrawMode(false)
                Time.sleepUntil({ !Bank.isNotedWithdrawMode() }, 1200)
            }

            if (withdrawOption == WithdrawOption.X && hasAction("Withdraw-$amount")) {
                interact(WithdrawOption.LAST_QUANTITY.menuIndex)
            } else {
                interact(withdrawOption.menuIndex)
                if (withdrawOption == WithdrawOption.X) {
                    Time.sleepUntil({ Dialog.isEnterInputOpen() }, 1200)
                    Dialog.enterInput(amount)
                }
            }
        }
    }

    fun offer(quantity: Int) {
        when (quantity) {
            1 -> interact("Offer")
            5 -> interact("Offer-5")
            10 -> interact("Offer-10")
            else -> if (quantity > this.quantity) {
                interact("Offer-All")
            } else {
                interact("Offer-X")
                Dialog.enterInput(quantity)
            }
        }
    }

    fun withdrawLastQuantity(withdrawMode: WithdrawMode = WithdrawMode.DEFAULT) {
        val withdrawOption = WithdrawOption.LAST_QUANTITY
        if (withdrawMode == WithdrawMode.NOTED && !Bank.isNotedWithdrawMode()) {
            Bank.setWithdrawMode(true)
        }

        if (withdrawMode == WithdrawMode.ITEM && Bank.isNotedWithdrawMode()) {
            Bank.setWithdrawMode(false)
        }

        interact(withdrawOption.menuIndex)
    }

    fun hasAction(vararg actions: String): Boolean {
        return Arrays.stream(actions).anyMatch { x -> actions.contains(x) }
    }

    fun interact(action: String) {
        if (actions == null) {
            return
        }
        val index = rawActions?.indexOf(action)
        if (index == -1) {
            log.warn("Action idx not found for $action")
            return
        }
        if (index != null) {
            invoke(index)
        }
    }

    fun interact(idx: Int) {
        invoke(idx)
    }

    fun invoke(index: Int) {
        GameThread.invoke { getMenu(index)?.let { createClientPacket(it) }!!.send() }
    }
}