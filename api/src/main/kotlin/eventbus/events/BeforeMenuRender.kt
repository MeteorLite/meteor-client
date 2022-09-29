package eventbus.events

import meteor.Event

class BeforeMenuRender: Event() {
    var consumed = false
    fun consume() {
        consumed = true
    }
}