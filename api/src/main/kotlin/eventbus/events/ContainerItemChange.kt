package eventbus.events

import meteor.Event

/**
 * @author Kris | 23/10/2021
 */
data class ContainerItemChange(
    val inventoryId: Int,
    val slotId: Int,
    val itemId: Int,
    val quantity: Int
) : Event()