package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class HintArrowEvent(
    val playerIndex: Int,
    val npcIndex: Int,
    val hintArrowX: Int,
    val hintArrowY: Int,
    val hintArrowHeight: Int
) : Event()