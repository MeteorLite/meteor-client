package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class JinglePlayed(
    val jingleId: Int
) : Event()