package eventbus.events

import meteor.Event
import net.runelite.api.GameState

class SleepingChanged(val isSleeping: Boolean): Event()
