package eventbus.events

import meteor.Event

class DynamicObjectAnimationChanged(
    var `object`: Int = 0,
    var animation: Int = 0,
    var x: Int = 0,
    var y: Int = 0
) : Event()