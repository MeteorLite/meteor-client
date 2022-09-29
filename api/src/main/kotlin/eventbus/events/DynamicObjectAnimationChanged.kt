package eventbus.events

import meteor.Event

class DynamicObjectAnimationChanged(var objectId: Int, var animation: Int) : Event()