package meteor.plugins.bowfletcher

import dev.hoot.api.input.Keyboard
import dev.hoot.api.items.Bank
import dev.hoot.api.widgets.Dialog
import dev.hoot.api.widgets.Widgets
import eventbus.events.GameTick
import eventbus.events.WidgetLoaded
import meteor.api.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.bowfletcher.BowFletcherConfig.FletchingType
import net.runelite.api.InventoryID
import net.runelite.api.ItemID
import net.runelite.api.MenuAction
import net.runelite.api.widgets.WidgetID

@PluginDescriptor(name = "Bow Fletcher", description = "", enabledByDefault = false)
class BowFletcher : Plugin()   {
    val objects = meteor.api.Objects
    val config = configuration<BowFletcherConfig>()
    var tickTimer = 0

    override fun onGameTick(it: GameTick) {
        when {
            config.type() == FletchingType.Cut_Logs -> handleCuttingLogs()
            config.type() == FletchingType.String_Bow -> handleStringingBows()
        }
    }

    private fun handleCuttingLogs() {
        val logs = Items.getCount(config.bows().logID)
        val knife = Items.getCount(ItemID.KNIFE)
        val shortbows = Items.getCount(config.bows().shortbowID)
        val longbows = Items.getCount(config.bows().longbowID)
        return when {
            logs == 0 && !bankOpen() -> useBank()
            knife == 0 && bankOpen() -> withdrawKnife()
            config.style() == BowFletcherConfig.BowStyle.Longbow && logs == 0 && longbows == 0 && knife == 1 && bankOpen() && !Dialog.isEnterInputOpen() -> withdrawLogs()
            config.style() == BowFletcherConfig.BowStyle.Shortbow && logs == 0 && shortbows == 0 && knife == 1 && bankOpen() && !Dialog.isEnterInputOpen() -> withdrawLogs()
            Dialog.isEnterInputOpen() -> Keyboard.type("27", true)
            logs > 1 && knife == 1 && bankOpen() -> closeBank()
            logs > 1 && !bankOpen() && Widgets.get(270, 13) == null && client.localPlayer?.isIdle == true -> fletchLog()
            config.style() == BowFletcherConfig.BowStyle.Longbow && Widgets.get(270, 13) != null -> Keyboard.type(3)
            config.style() == BowFletcherConfig.BowStyle.Shortbow && Widgets.get(270, 13) != null -> Keyboard.type(2)
            Dialog.canLevelUpContinue() -> fletchLog()
            config.style() == BowFletcherConfig.BowStyle.Longbow && longbows > 1 && bankOpen() -> depositBows()
            config.style() == BowFletcherConfig.BowStyle.Shortbow && shortbows > 1 && bankOpen() -> depositBows()
            else -> return
        }
    }

    private fun handleStringingBows() {
        val shortbows = Items.getCount(config.bows().shortbowID)
        val longbows = Items.getCount(config.bows().longbowID)
        val finishedShortbows = Items.getCount(config.bows().finishedShortbowID)
        val finishedLongbows = Items.getCount(config.bows().finishedLongbowID)
        val bowstring = Items.getCount(ItemID.BOW_STRING)
        return when {
            tickTimer > 0 -> {
                tickTimer--
                return
            }
            bowstring == 0 && !bankOpen() -> useBank()
            config.style() == BowFletcherConfig.BowStyle.Longbow && finishedLongbows == 0 && longbows == 0 && bankOpen() && !Dialog.isEnterInputOpen() -> { withdrawBows().also { withdrawBowstring()} }
            config.style() == BowFletcherConfig.BowStyle.Shortbow && finishedLongbows == 0 && shortbows == 0 && bankOpen() && !Dialog.isEnterInputOpen() -> { withdrawBows().also { withdrawBowstring()} }
            Dialog.isEnterInputOpen() -> Keyboard.type("14", true)
            config.style() == BowFletcherConfig.BowStyle.Longbow && bowstring > 1 && longbows > 1 && bankOpen() -> closeBank()
            config.style() == BowFletcherConfig.BowStyle.Shortbow && bowstring > 1 && shortbows > 1 && bankOpen() -> closeBank()
            Dialog.canLevelUpContinue() -> stringBow()
            config.style() == BowFletcherConfig.BowStyle.Longbow && longbows == 14 && !bankOpen() && bowstring == 14 -> stringBow().also { tickTimer = 3 }
            config.style() == BowFletcherConfig.BowStyle.Shortbow && shortbows == 14 && !bankOpen() && bowstring == 14 -> stringBow().also { tickTimer = 3 }
            config.style() == BowFletcherConfig.BowStyle.Longbow && finishedLongbows > 1 && bankOpen() -> depositFinishedBows()
            config.style() == BowFletcherConfig.BowStyle.Shortbow && finishedShortbows > 1 && bankOpen() -> depositFinishedBows()
            else -> return
        }

    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        val groupId: Int = it.groupId
        val bowstring = Items.getCount(ItemID.BOW_STRING)
        if (groupId == WidgetID.MULTISKILL_MENU_GROUP_ID && bowstring >= 1){
            Keyboard.type(1)
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
    private fun withdrawKnife() {
        Items.getFirst(ItemID.KNIFE, container = InventoryID.BANK)?.let {
            Items.withdraw(it, 1)
        }
    }
    private fun withdrawLogs() {
        Items.getFirst(config.bows().logID, container = InventoryID.BANK)?.let {
            Items.withdraw(it, 27)
        }
    }
    private fun withdrawBows() {
        if (config.style() == BowFletcherConfig.BowStyle.Longbow)
            Items.getFirst(config.bows().longbowID, container = InventoryID.BANK)?.let {
                Items.withdraw(it, 14)
            }
        if (config.style() == BowFletcherConfig.BowStyle.Shortbow)
            Items.getFirst(config.bows().shortbowID, container = InventoryID.BANK)?.let {
                Items.withdraw(it, 14)
            }
    }
    fun withdrawBowstring() {
        Items.getFirst(ItemID.BOW_STRING, container = InventoryID.BANK)?.let {
            Items.withdraw(it, 14)
        }
    }
    fun stringBow(){
        if (config.style() == BowFletcherConfig.BowStyle.Longbow)
            Items.getFirst(ItemID.BOW_STRING)?.useOn(Items.getFirst(config.bows().longbowID)!!)
        if (config.style() == BowFletcherConfig.BowStyle.Shortbow)
            Items.getFirst(ItemID.BOW_STRING)?.useOn(Items.getFirst(config.bows().shortbowID)!!)
    }
    fun fletchLog() {
        Items.getFirst(ItemID.KNIFE)?.useOn(Items.getFirst(config.bows().logID)!!)
    }
    fun useBank() {
        if (!Bank.bankPinIsOpen()) {
            objects.getFirst("Bank chest")?.interact("Use")
            objects.getFirst("Bank booth")?.interact("Bank")
            objects.getFirst("Grand Exchange booth")?.interact("Bank")
        }
    }
    private fun bankOpen(): Boolean {
        return client.getItemContainer(InventoryID.BANK) != null
    }
    fun depositBows() {
        if (config.style() == BowFletcherConfig.BowStyle.Longbow)
            Items.getFirst(config.bows().longbowID)?.let {
                Items.deposit(it, 27)
            }
        if (config.style() == BowFletcherConfig.BowStyle.Shortbow)
            Items.getFirst(config.bows().shortbowID)?.let {
                Items.deposit(it, 27)
            }
    }
    fun depositFinishedBows() {
        if (config.style() == BowFletcherConfig.BowStyle.Longbow)
            Items.getFirst(config.bows().finishedLongbowID)?.let {
                Items.deposit(it, 14)
            }
        if (config.style() == BowFletcherConfig.BowStyle.Shortbow)
            Items.getFirst(config.bows().finishedShortbowID)?.let {
                Items.deposit(it, 14)
            }
    }
}