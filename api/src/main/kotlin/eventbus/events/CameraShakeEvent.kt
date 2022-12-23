package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class CameraShakeEvent(
    val type: Int,
    val shakeIntensity: Int,
    val movementIntensity: Int,
    val speed: Int,
) : Event()