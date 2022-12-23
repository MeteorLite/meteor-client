package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 22/10/2021
 */
data class FacedDirectionChanged(
    val source: Actor? = null,
    val direction: Int,
    val instant: Boolean = false
) : Event()