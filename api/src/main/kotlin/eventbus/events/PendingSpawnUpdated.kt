package eventbus.events

import meteor.Event

/**
 * @author Kris | 22/10/2021
 */
data class PendingSpawnUpdated(
    val plane: Int,
    val x: Int,
    val y: Int,
    val type: Int,
    val id: Int,
    val var5: Int,
    val orientation: Int,
    val opflags: Int,
    val delay: Int,
    val hitpoints: Int
) : Event()