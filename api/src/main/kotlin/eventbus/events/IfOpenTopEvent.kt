package eventbus.events

import meteor.Event

/**
 * @author Kris | 24/10/2021
 */
data class IfOpenTopEvent(
    val rootInterface: Int
) : Event()