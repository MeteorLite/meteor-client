package eventbus.events

import meteor.Event

/**
 * @author Kris | 24/10/2021
 */
data class IfOpenSubEvent(
    val targetComponent: Int,
    val interfaceId: Int,
    val walkType: Int
) : Event()