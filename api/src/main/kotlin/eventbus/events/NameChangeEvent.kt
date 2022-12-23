package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 07/01/2022
 */
data class NameChangeEvent(
    val actor: Actor?,
    val oldName: String?,
    val newName: String?,
) : Event()