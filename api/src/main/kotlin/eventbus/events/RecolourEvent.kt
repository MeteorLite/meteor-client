package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 07/01/2022
 */
data class RecolourEvent(
    val actor: Actor? = null,
    val recolourStartCycle: Int,
    val recolourEndCycle: Int,
    val recolourHue: Int,
    val recolourSaturation: Int,
    val recolourLuminance: Int,
    val recolourAmount: Int,
    val currentCycle: Int
) : Event()