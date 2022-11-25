package meteor.plugins.fighter

import dev.hoot.api.game.Skills
import dev.hoot.api.magic.Regular
import dev.hoot.api.magic.Rune
import dev.hoot.api.movement.pathfinder.RuneRequirement


import net.runelite.api.Skill
import java.util.*

enum class AlchSpell(val spell: Regular, vararg requirements: RuneRequirement) {
    HIGH(
        Regular.HIGH_LEVEL_ALCHEMY,
        RuneRequirement(1, Rune.NATURE),
        RuneRequirement(5, Rune.FIRE)
    ),
    LOW(Regular.LOW_LEVEL_ALCHEMY, RuneRequirement(1, Rune.NATURE), RuneRequirement(1, Rune.FIRE));

    private val requirements: Array<RuneRequirement>

    init {
        this.requirements = requirements as Array<RuneRequirement>
    }

    fun canCast(): Boolean {
        return (Skills.getLevel(Skill.MAGIC) >= spell.getLevel()
                && Arrays.stream(requirements).allMatch { obj: RuneRequirement -> obj.meetsRequirements() })
    }
}
