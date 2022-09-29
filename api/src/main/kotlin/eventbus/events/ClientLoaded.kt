package eventbus.events

import meteor.Event

class ClientLoaded(val msToStart: Long): Event()