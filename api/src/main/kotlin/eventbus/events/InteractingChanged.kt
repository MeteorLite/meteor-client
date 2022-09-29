package eventbus.events

import meteor.Event
import net.runelite.api.Actor

/**
 * An event called when the actor an actor is interacting with changes
 */
class InteractingChanged(val source: Actor?, val target: Actor?) : Event()