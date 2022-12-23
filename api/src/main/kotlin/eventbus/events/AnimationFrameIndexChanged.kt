package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * @author Kris | 22/10/2021
 */
class AnimationFrameIndexChanged(
    val actor: Actor? = null
) : Event()