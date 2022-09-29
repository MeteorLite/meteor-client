package eventbus.events

import meteor.Event
import net.runelite.api.Actor

class FriendsChatChanged(var joined: Boolean) : Event()