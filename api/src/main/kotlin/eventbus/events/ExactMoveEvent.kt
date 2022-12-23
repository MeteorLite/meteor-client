package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 22/10/2021
 */
data class ExactMoveEvent(
    val actor: Actor? = null,
    val exactMoveDeltaX1: Int,
    val exactMoveDeltaX2: Int,
    val exactMoveDeltaY1: Int,
    val exactMoveDeltaY2: Int,
    val exactMoveArrive1Cycle: Int,
    val exactMoveArrive2Cycle: Int,
    val exactMoveDirection: Int,
    val cycle: Int,
) : Event()