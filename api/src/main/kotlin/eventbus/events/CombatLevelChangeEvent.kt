package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 07/01/2022
 */
data class CombatLevelChangeEvent(
    val actor: Actor? = null,
    val oldCombatLevel: Int,
    val newCombatLevel: Int,
) : Event()