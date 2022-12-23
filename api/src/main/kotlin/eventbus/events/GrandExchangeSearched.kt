package eventbus.events

import meteor.Event

class GrandExchangeSearched(var consumed: Boolean = false) : Event() {
    fun consume() {
        consumed = true
    }
}