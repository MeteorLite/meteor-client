package eventbus.events

import meteor.Event
import net.runelite.api.Player

/**
 * @author Kris | 27/10/2021
 */
data class PlayerMoved(
    val player: Player? = null,
    val x: Int,
    val y: Int,
    val type: Int
) : Event()