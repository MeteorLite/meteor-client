package meteor.api.statistics

import meteor.api.game.Skills
import net.runelite.api.Skill


class ExperienceTracker {
    var skill: Skill? = null
    var startExp = 0
    var startLevel = 0
    val experienceGained: Int
        get() = Skills.getExperience(skill) - startExp
    val levelsGained: Int
        get() = Skills.getLevel(skill) - startLevel
}