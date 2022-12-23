package eventbus.events

import meteor.Event

/**
 * @author Kris | 26/10/2021
 */
data class PlayerMenuOptionsChanged(
    val index: Int,
    val option: String? = null,
    val priority: Boolean = false,
) : Event()