package meteor.rmi.handshake

import java.rmi.Remote
import java.rmi.RemoteException

interface HandshakeService : Remote {
    @Throws(RemoteException::class)
    fun handshake(uuid: String): String
}