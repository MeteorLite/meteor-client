package meteor.api.widgets

import meteor.api.game.Skills
import meteor.api.game.Vars
import net.runelite.api.Prayer
import net.runelite.api.Skill
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetInfo

object Prayers {
    fun isEnabled(prayer: Prayer): Boolean {
        return Vars.getBit(prayer.varbit) === 1
    }

    fun toggle(prayer: Prayer) {
        val widget = Widgets.get(prayer.widgetInfo)
        widget?.interact(0)
    }

    val points: Int
        get() = Skills.getBoostedLevel(Skill.PRAYER)

    fun toggleQuickPrayer(enabled: Boolean) {
        val widget = Widgets.get(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB)
        widget?.interact(if (enabled) "Activate" else "Deactivate")
    }

    val isQuickPrayerEnabled: Boolean
        get() = Vars.getBit(Varbits.QUICK_PRAYER) === 1
}