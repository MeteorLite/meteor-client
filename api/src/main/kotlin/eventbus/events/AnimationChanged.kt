package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * An event where the [Actor] has changed animations.
 *
 *
 * In order to get the new animation ID, use [Actor.getAnimation].
 *
 *
 * Examples of when this event may trigger include:
 *
 *  * A player starts or stops gathering a resource (ie. woodcut, fishing)
 *  * A player starts or stops dancing
 *
 *
 * @see net.runelite.api.AnimationID
 */
class AnimationChanged(var actor: Actor) : Event()