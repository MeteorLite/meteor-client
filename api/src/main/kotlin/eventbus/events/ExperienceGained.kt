package eventbus.events

import meteor.Event
import net.runelite.api.Skill

class ExperienceGained(var skill: Skill, var xpGained: Int, var xp: Int, var level: Int) : Event()