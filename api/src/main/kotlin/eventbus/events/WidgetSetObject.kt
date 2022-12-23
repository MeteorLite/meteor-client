package eventbus.events

import meteor.Event

/**
 * @author Kris | 24/10/2021
 */
data class WidgetSetObject(
    val itemId: Int,
    val itemQuantityOrModelZoom: Int,

    // if new type, use item quantity, else model zoom
    val newType: Boolean = false
) : Event()