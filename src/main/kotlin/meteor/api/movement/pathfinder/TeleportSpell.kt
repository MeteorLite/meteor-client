package meteor.api.movement.pathfinder

import meteor.api.game.Skills
import meteor.api.game.Vars
import meteor.api.magic.Magic
import meteor.api.magic.Regular
import meteor.api.magic.Rune
import meteor.api.magic.Spell
import net.runelite.api.Skill
import net.runelite.api.coords.WorldPoint

enum class TeleportSpell(
    spellBook: Magic.SpellBook,
    spell: Spell,
    level: Int,
    point: WorldPoint,
    members: Boolean,
    spellName: String,
    vararg requirements: RuneRequirement
) {
    VARROCK_TELEPORT(
        Magic.SpellBook.REGULAR,
        Regular.VARROCK_TELEPORT,
        25,
        WorldPoint(3212, 3424, 0),
        false,
        "Varrock Teleport",
        RuneRequirement(1, Rune.LAW),
        RuneRequirement(3, Rune.AIR),
        RuneRequirement(1, Rune.FIRE)
    ),
    LUMBRIDGE_TELEPORT(
        Magic.SpellBook.REGULAR,
        Regular.LUMBRIDGE_TELEPORT,
        31,
        WorldPoint(3225, 3219, 0),
        false,
        "Lumbridge Teleport",
        RuneRequirement(1, Rune.LAW),
        RuneRequirement(3, Rune.AIR),
        RuneRequirement(1, Rune.EARTH)
    ),
    FALADOR_TELEPORT(
        Magic.SpellBook.REGULAR,
        Regular.FALADOR_TELEPORT,
        37,
        WorldPoint(2966, 3379, 0),
        false,
        "Falador Teleport",
        RuneRequirement(1, Rune.LAW),
        RuneRequirement(3, Rune.AIR),
        RuneRequirement(1, Rune.WATER)
    ),
    CAMELOT_TELEPORT(
        Magic.SpellBook.REGULAR,
        Regular.CAMELOT_TELEPORT,
        45,
        WorldPoint(2757, 3479, 0),
        true,
        "Camelot Teleport",
        RuneRequirement(1, Rune.LAW),
        RuneRequirement(5, Rune.AIR)
    ),
    ARDOUGNE_TELEPORT(
        Magic.SpellBook.REGULAR,
        Regular.ARDOUGNE_TELEPORT,
        51,
        WorldPoint(2661, 3300, 0),
        true,
        "Ardougne Teleport",
        RuneRequirement(2, Rune.LAW),
        RuneRequirement(2, Rune.WATER)
    );

    private val spellBook: Magic.SpellBook
    private val spell: Spell
    val requiredLevel: Int
    private val point: WorldPoint
    val isMembers: Boolean
    val spellName: String
    val requirements: Array<RuneRequirement>

    init {
        this.spellBook = spellBook
        this.spell = spell
        requiredLevel = level
        this.point = point
        isMembers = members
        this.spellName = spellName
        this.requirements = requirements as Array<RuneRequirement>
    }

    fun getSpellBook(): Magic.SpellBook {
        return spellBook
    }

    fun getSpell(): Spell {
        return spell
    }

    fun getPoint(): WorldPoint {
        return point
    }

    fun canCast(): Boolean {
        if (Magic.SpellBook.current !== spellBook) {
            return false
        }

        if (requiredLevel > Skills.getLevel(Skill.MAGIC)) {
            return false
        }
        return if (this == ARDOUGNE_TELEPORT && Vars.getVarp(165) < 30) {
            false
        } else haveRunesAvailable()
    }

    fun haveRunesAvailable(): Boolean {
        for (req in requirements) {
            if (!req.meetsRequirements()) {
                return false
            }
        }
        return true
    }
}