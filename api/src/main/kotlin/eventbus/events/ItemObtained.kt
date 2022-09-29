package eventbus.events

import meteor.Event

class ItemObtained(var itemId: Int, var amount: Int) : Event()