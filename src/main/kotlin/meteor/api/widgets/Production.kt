package meteor.api.widgets

import meteor.api.game.GameThread
import meteor.api.input.Keyboard
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Supplier

object Production {
    private val OPTIONS = Supplier { Widgets.get(WidgetID.MULTISKILL_MENU_GROUP_ID, 13) }
    private val OTHER_QUANTITY = Supplier { Widgets.get(WidgetID.MULTISKILL_MENU_GROUP_ID, 11) }
    val isOpen: Boolean
        get() {
            val widget = Widgets[WidgetInfo.MULTI_SKILL_MENU]
            return widget != null && !GameThread.invokeLater { widget.isHidden }
        }

    fun chooseOption(option: String) {
        if (!isOpen) {
            return
        }
        val optionsWidget = OPTIONS.get()
        if (optionsWidget == null || GameThread.invokeLater { optionsWidget.isHidden }) {
            return
        }
        val options = if (optionsWidget.children != null) optionsWidget.children!!.size else 1
        for (i in 0 until options) {
            val currentOption = Widgets.get(WidgetID.MULTISKILL_MENU_GROUP_ID, 14 + i)
            if (currentOption != null && currentOption.name.lowercase(Locale.getDefault()).contains(
                    option.lowercase(
                        Locale.getDefault()
                    )
                )
            ) {
                chooseOption(i + 1)
                return
            }
        }
    }

    fun selectOtherQuantity() {
        val otherQuantity = OTHER_QUANTITY.get()
        if (otherQuantity != null && !GameThread.invokeLater { otherQuantity.isHidden }) {
            otherQuantity.interact(0)
        }
    }

    fun chooseOption(index: Int) {
        if (isOpen) {
            Keyboard.type(index)
        }
    }

    fun choosePreviousOption() {
        if (isOpen) {
            Keyboard.sendSpace()
        }
    }

    val isEnterInputOpen: Boolean
        get() = Dialog.isEnterInputOpen

    fun enterInput(amount: Int) {
        Dialog.enterInput(amount)
    }

    fun enterInput(input: String) {
        Dialog.enterInput(input)
    }
}