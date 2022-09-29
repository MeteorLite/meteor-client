package eventbus.events

import net.runelite.api.Actor

class OverheadTextChanged(val actor: Actor, val overheadText: String)