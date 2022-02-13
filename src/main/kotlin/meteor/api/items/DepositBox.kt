package meteor.api.items

import meteor.api.widgets.Widgets
import net.runelite.api.widgets.Widget
import java.util.function.Supplier

object DepositBox {
    private val DEPOSIT_INV = Supplier<Widget> { Widgets[192, 4] }
    private val DEPOSIT_EQUIPS = Supplier<Widget> { Widgets[192, 6] }
    private val DEPOSIT_LOOTINGBAG = Supplier<Widget> { Widgets[192, 8] }
    private val ROOT = Supplier<Widget> { Widgets[192, 1] }
    private val EXIT = Supplier<Widget> { Widgets[192, 1, 11] }
    fun depositInventory() {
        val depositInventory = DEPOSIT_INV.get()
        if (!Widgets.isVisible(depositInventory)) {
            return
        }
        depositInventory.interact(0)
    }

    fun depositEquipment() {
        val depositEquipment = DEPOSIT_EQUIPS.get()
        if (!Widgets.isVisible(depositEquipment)) {
            return
        }
        depositEquipment.interact(0)
    }

    fun depositLootingBag() {
        val depositLootingbag = DEPOSIT_LOOTINGBAG.get()
        if (!Widgets.isVisible(depositLootingbag)) {
            return
        }
        depositLootingbag.interact(0)
    }

    val isOpen: Boolean
        get() {
            val depositBox = ROOT.get()
            return Widgets.isVisible(depositBox)
        }

    fun close() {
        val exitDepositBox = EXIT.get()
        if (!Widgets.isVisible(exitDepositBox)) {
            return
        }
        exitDepositBox.interact(0)
    }
}