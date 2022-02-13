package meteor.api.magic

import meteor.api.magic.RunePouch
import meteor.api.magic.Rune
import meteor.api.magic.Magic
import meteor.api.magic.Spell
import meteor.api.magic.RunePouch.RuneSlot
import net.runelite.api.widgets.WidgetInfo

enum class Necromancy(override val level: Int, override val widget: WidgetInfo) : Spell {
    ARCEUUS_HOME_TELEPORT(1, WidgetInfo.SPELL_ARCEUUS_HOME_TELEPORT), BATTLEFRONT_TELEPORT(
        23,
        WidgetInfo.SPELL_BATTLEFRONT_TELEPORT
    );

}