package eventbus.events

import meteor.Event

/**
 * @author Kris | 25/10/2021
 */
data class WidgetSetNpcHead(
    val npcId: Int
) : Event()