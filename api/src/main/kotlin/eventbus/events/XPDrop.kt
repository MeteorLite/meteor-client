package eventbus.events

import meteor.Event
import net.runelite.api.Skill

/**
 * @author Kris | 24/10/2021
 */
data class XPDrop(
    val skill: Skill,
    val exp: Int
) : Event()