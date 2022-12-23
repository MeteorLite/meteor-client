package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class CameraMoveToEvent(
    val cameraMoveToX: Int,
    val cameraMoveToY: Int,
    val cameraMoveToHeight: Int,
    val cameraMoveToSpeed: Int,
    val cameraMoveToAcceleration: Int,
): Event()