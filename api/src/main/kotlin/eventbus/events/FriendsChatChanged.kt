package eventbus.events

import meteor.Event

class FriendsChatChanged(var joined: Boolean) : Event()