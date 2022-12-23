package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class CameraLookAtEvent(
    val cameraLookAtX: Int,
    val cameraLookAtY: Int,
    val cameraLookAtHeight: Int,
    val cameraLookAtSpeed: Int,
    val cameraLookAtAcceleration: Int,
): Event()