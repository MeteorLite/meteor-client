package eventbus.events

import meteor.Event
import net.runelite.api.Actor

class GrandExchangeSearched(var consumed: Boolean = false) : Event() {
    fun consume() {
        consumed = true
    }
}