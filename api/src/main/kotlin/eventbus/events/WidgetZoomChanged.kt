package eventbus.events

import meteor.Event

/**
 * @author Kris | 24/10/2021
 */
data class WidgetZoomChanged(
    val zoom: Int,
    val angleX: Int,
    val angleY: Int
) : Event()