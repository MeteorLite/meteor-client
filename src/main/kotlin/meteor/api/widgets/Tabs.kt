package meteor.api.widgets

import meteor.api.game.Vars
import net.runelite.api.VarClientInt
import net.runelite.api.widgets.WidgetID
import java.util.*

object Tabs {
    fun open(tab: Tab) {
        val widget = Widgets.get(WidgetID.FIXED_VIEWPORT_GROUP_ID, tab.childId)
        widget?.interact(0)
    }

    fun isOpen(tab: Tab): Boolean {
        return mutableListOf(*Tab.values()).indexOf(tab) === Vars.getVarcInt(VarClientInt.INVENTORY_TAB)
    }
}