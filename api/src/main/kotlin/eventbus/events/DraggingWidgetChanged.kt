package eventbus.events

import meteor.Event

class DraggingWidgetChanged(var draggingWidget: Boolean) : Event()