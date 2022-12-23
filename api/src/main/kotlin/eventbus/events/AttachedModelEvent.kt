package eventbus.events

import meteor.Event
import net.runelite.api.Model
import net.runelite.api.Player

/**
 * @author Kris | 22/10/2021
 */
data class AttachedModelEvent(
    val player: Player? = null,
    val minX: Int,
    val minY: Int,
    val maxX: Int,
    val maxY: Int,
    val animationCycleStart: Int,
    val animationCycleEnd: Int,
    val attachedModel: Model? = null,
) : Event()