package meteor.rmi.handshake

import meteor.rmi.RMIClient
import java.rmi.Remote

class HandshakeClient<T : Remote> : RMIClient<T>(name = "handshake", port = 4000)