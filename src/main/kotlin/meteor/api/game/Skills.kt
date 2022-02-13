package meteor.api.game

import Main.client
import net.runelite.api.Skill

object Skills {
    fun getBoostedLevel(skill: Skill?): Int {
        return client.getBoostedSkillLevel(skill)
    }

    fun getLevel(skill: Skill?): Int {
        return client.getRealSkillLevel(skill)
    }

    fun getExperience(skill: Skill?): Int {
        return client.getSkillExperience(skill)
    }
}