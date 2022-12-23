package eventbus.events

import meteor.Event

/**
 * @author Kris | 03/02/2022
 */
data class SoundEffectReceived(
    val id: Int,
    val repetitions: Int,
    val delay: Int
) : Event()