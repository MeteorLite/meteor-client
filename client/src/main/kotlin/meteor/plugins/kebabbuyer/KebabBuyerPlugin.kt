package meteor.plugins.kebabbuyer

import dev.hoot.api.items.Bank
import dev.hoot.api.movement.Movement
import dev.hoot.api.widgets.Dialog
import dev.hoot.api.widgets.DialogOption
import eventbus.events.GameTick
import meteor.api.items.Items
import meteor.plugins.Plugin
import meteor.api.npcs.NPCs
import meteor.plugins.PluginDescriptor
import net.runelite.api.ChatMessageType
import net.runelite.api.InventoryID
import net.runelite.api.ItemID
import net.runelite.api.coords.WorldArea

@PluginDescriptor(
    name = "Kebab buyer",
    description = "Buys kebabs very quickly. Start plugin in Al-Kharid bank, make sure your inventory is empty before starting the plugin.",
    enabledByDefault = false
)
class KebabBuyerPlugin : Plugin() {
    private val bankArea = WorldArea(3269, 3164, 2, 6, 0)
    private val kebabShopArea = WorldArea(3271, 3179, 4, 4, 0)
    private val minCoins = 2500

    private var ticktimer = 0
    override fun onGameTick(it: GameTick) {
        if (ticktimer > 0) {
            ticktimer--
            return
        }

        val coinsInInv = Items.getFirst(ItemID.COINS_995)?.quantity ?: 0
        if (!Items.inventoryContains(ItemID.COINS_995) || coinsInInv < minCoins) {
            withdrawMoney()
            return
        }

        if (Items.isFull()) {
            bankKebabs()
        } else {
            buyKebabs()
        }
    }

    private fun withdrawMoney() {
        if (!Bank.isOpen()) {
            openBank()
            ticktimer = 2
            return
        }
        if (Bank.isOpen()) {
            val coins = Items.getFirst(ItemID.COINS_995, container = InventoryID.BANK)
            if (coins == null || coins.quantity < minCoins) {
                client.addChatMessage(
                    ChatMessageType.GAMEMESSAGE,
                    "",
                    "Coins not found, make sure you have at least 5000gp",
                    null
                )
                stop()
                return
            }

            Items.withdraw(coins, 5000)
            ticktimer = 3
            return
        }
    }

    private fun buyKebabs() {
        if (!Movement.isRunEnabled() && Movement.isWalking()) {
            Movement.toggleRun()
        }

        if (Movement.isWalking()) {
            ticktimer = 1
            return
        }

        if (!kebabShopArea.contains(client.localPlayer)) {
            Movement.walkTo(kebabShopArea)
            ticktimer = 2
            return
        }

        val karim = NPCs.getFirst("Karim")

        if (karim != null) {
            Dialog.invokeDialog(DialogOption.NPC_CONTINUE, DialogOption.CHAT_OPTION_TWO, DialogOption.PLAYER_CONTINUE)
            karim.interact("Talk-to")
        }

        ticktimer = 1
    }

    private fun openBank() {
        val banker = NPCs.getFirst("Banker")
        if (Movement.isWalking()) {
            ticktimer = 1
            return
        }
        if (!bankArea.contains(client.localPlayer)) {
            Movement.walkTo(bankArea)
            ticktimer = 2
        } else {
            banker?.interact("Bank")
            ticktimer = 2
        }
    }

    private fun bankKebabs() {
        if (!Bank.isOpen()) {
            if (!Movement.isRunEnabled()) {
                Movement.toggleRun()
            }
            openBank()
        }


        if (Items.inventoryContains(ItemID.KEBAB)) {
            val kebab = Items.getFirst(ItemID.KEBAB)
            Items.deposit(kebab!!, 9999)
            ticktimer = 2
            return
        }
        ticktimer = 2
    }
}