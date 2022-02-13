package meteor.api.game

import meteor.api.entities.NPCs
import meteor.api.entities.Players
import meteor.api.widgets.Widgets
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.api.Skill
import net.runelite.api.VarPlayer
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Predicate
import java.util.function.Supplier

object Combat {
    private const val POISON_VARP = 102
    private const val SPEC_VARP = 301
    private const val SPEC_ENERGY_VARP = 300
    private val SPEC_BUTTON = Supplier<Widget> { Widgets.get(593, 36) }
    val isRetaliating: Boolean
        get() = Vars.getVarp(VarPlayer.AUTO_RETALIATE.id) == 0
    val isPoisoned: Boolean
        get() = Vars.getVarp(POISON_VARP) > 0
    val isSpecEnabled: Boolean
        get() = Vars.getVarp(SPEC_VARP) == 1
    val specEnergy: Int
        get() = Vars.getVarp(SPEC_ENERGY_VARP) / 10

    fun toggleSpec() {
        if (isSpecEnabled) {
            return
        }
        val spec = SPEC_BUTTON.get()
        if (spec != null) {
            spec.interact(0)
        }
    }

    var attackStyle: AttackStyle
        get() = AttackStyle.fromIndex(Vars.getVarp(43))
        set(attackStyle) {
            if (attackStyle.widgetInfo == null) {
                return
            }
            Widgets[attackStyle.widgetInfo]?.interact(0)
        }

    fun getAttackableNPC(vararg ids: Int): NPC? {
        return getAttackableNPC { x: NPC ->
            for (id in ids) {
                if (id == x.id) {
                    return@getAttackableNPC true
                }
            }
            false
        }
    }

    fun getAttackableNPC(vararg names: String): NPC? {
        return getAttackableNPC { x: NPC ->
            if (x.name == null) {
                return@getAttackableNPC false
            }
            for (name in names) {
                if (name == x.name) {
                    return@getAttackableNPC true
                }
            }
            false
        }
    }

    fun getAttackableNPC(filter: Predicate<NPC>): NPC? {
        val local: Player = Players.local
        val attackingMe: NPC? = NPCs.getNearest { x ->
            (x!!.hasAction("Attack") && Players.getNearest { p ->
                (p!!.getInteracting() != null
                        && p.getInteracting().equals(x))
            } == null && x.getInteracting() != null && x.getInteracting().equals(local)
                    && filter.test(x))
        }
        return attackingMe
            ?: NPCs.getNearest { x ->
                x!!.hasAction("Attack") && Players.getNearest { p ->
                    (p!!.getInteracting() != null
                            && p.getInteracting().equals(x))
                } == null && x.getInteracting() == null && filter.test(x)
            }
    }

    val currentHealth: Int
        get() = Skills.getBoostedLevel(Skill.HITPOINTS)
    val missingHealth: Int
        get() = Skills.getLevel(Skill.HITPOINTS) - Skills.getBoostedLevel(Skill.HITPOINTS)
    val healthPercent: Double
        get() = currentHealth.toDouble() / Skills.getLevel(Skill.HITPOINTS) * 100

    enum class AttackStyle(val index: Int, val widgetInfo: WidgetInfo?) {
        FIRST(0, WidgetInfo.COMBAT_STYLE_ONE), SECOND(1, WidgetInfo.COMBAT_STYLE_TWO), THIRD(
            2,
            WidgetInfo.COMBAT_STYLE_THREE
        ),
        FOURTH(3, WidgetInfo.COMBAT_STYLE_FOUR), SPELLS(4, WidgetInfo.COMBAT_SPELL_BOX), SPELLS_DEFENSIVE(
            4,
            WidgetInfo.COMBAT_DEFENSIVE_SPELL_BOX
        ),
        UNKNOWN(-1, null);

        companion object {
            fun fromIndex(index: Int): AttackStyle {
                return Arrays.stream(values()).filter { x: AttackStyle -> x.index == index }
                    .findFirst()
                    .orElse(UNKNOWN)
            }
        }
    }
}