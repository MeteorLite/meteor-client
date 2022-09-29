package eventbus.events

import meteor.Event
import net.runelite.api.Actor

class DraggingWidgetChanged(var draggingWidget: Boolean) : Event()