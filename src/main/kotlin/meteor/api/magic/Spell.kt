package meteor.api.magic

import net.runelite.api.widgets.WidgetInfo

interface Spell {
    val level: Int
    val widget: WidgetInfo
}