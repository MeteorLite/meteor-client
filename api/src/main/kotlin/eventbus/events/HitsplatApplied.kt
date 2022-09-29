package eventbus.events

import meteor.Event
import net.runelite.api.Actor
import net.runelite.api.Hitsplat

class HitsplatApplied(var actor: Actor, var hitsplat: Hitsplat) : Event()