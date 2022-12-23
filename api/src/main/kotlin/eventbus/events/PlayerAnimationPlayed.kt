package eventbus.events

import meteor.Event
import net.runelite.api.Player

/**
 * @author Kris | 23/10/2021
 */
data class PlayerAnimationPlayed(
    val player: Player? = null,
    val id: Int,
    val delay: Int
) : Event()