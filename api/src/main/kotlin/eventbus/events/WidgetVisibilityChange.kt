package eventbus.events

import meteor.Event

/**
 * @author Kris | 25/10/2021
 */
data class WidgetVisibilityChange(
    val hidden: Boolean,
) : Event()