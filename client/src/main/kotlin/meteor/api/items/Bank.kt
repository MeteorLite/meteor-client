package meteor.api.items

import meteor.Main
import net.runelite.api.queries.BankItemQuery
import net.runelite.api.widgets.Widget

object Bank {
    fun getBankItemWidget(id: Int): Widget? {
        return BankItemQuery().idEquals(id).result(Main.client).first()!!.widget
    }
}