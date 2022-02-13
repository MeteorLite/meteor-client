package meteor.api.magic

import Main.client
import meteor.api.game.Vars
import meteor.api.widgets.Widgets
import net.runelite.api.*
import net.runelite.api.widgets.Widget
import java.util.*

object Magic {
    private const val SPELLBOOK_VARBIT = 4070
    private const val AUTOCAST_VARP = 108
    val isAutoCasting: Boolean
        get() = Vars.getVarp(AUTOCAST_VARP) !== 0

    fun isSpellSelected(spell: Spell): Boolean {
        val widget: Widget? = Widgets.get(spell.widget)
        return if (widget != null) {
            widget.borderType == 2
        } else false
    }

    fun cast(spell: Spell, target: Item) {
        selectSpell(spell)
        target.interact(0, MenuAction.ITEM_USE_ON_WIDGET.id)
    }

    fun cast(spell: Spell, target: NPC) {
        selectSpell(spell)
        target.interact(0, MenuAction.SPELL_CAST_ON_NPC.id)
    }

    fun cast(spell: Spell, target: Player) {
        selectSpell(spell)
        target.interact(0, MenuAction.SPELL_CAST_ON_PLAYER.id)
    }

    fun cast(spell: Spell, target: TileItem) {
        selectSpell(spell)
        target.interact(0, MenuAction.SPELL_CAST_ON_GROUND_ITEM.id)
    }

    fun cast(spell: Spell, target: TileObject) {
        selectSpell(spell)
        target.interact(0, MenuAction.SPELL_CAST_ON_GAME_OBJECT.id)
    }

    fun selectSpell(spell: Spell) {
        val widget: Widget? = Widgets.get(spell.widget)
        if (widget != null) {
            client.setSelectedSpellWidget(widget.id)
        }
    }

    fun cast(spell: Spell) {
        val widget: Widget? = Widgets.get(spell.widget)
        if (widget != null) {
            widget.interact(0)
        }
    }

    enum class SpellBook(private val varbitValue: Int) {
        REGULAR(0), ANCIENT(1), LUNAR(2), NECROMANCY(3);

        companion object {
            val current: SpellBook?
                get() = Arrays.stream(values())
                    .filter { x: SpellBook? -> Vars.getBit(SPELLBOOK_VARBIT) === x!!.varbitValue }
                    .findFirst().orElse(null)
        }
    }
}