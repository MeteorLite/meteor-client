package meteor.rmi

import meteor.Main.rmiHost
import java.rmi.Remote
import java.rmi.registry.LocateRegistry

open class RMIClient<T: Remote>(var host: String = rmiHost, var name: String = "", var port: Int) {
    fun connect(): T {
        return LocateRegistry.getRegistry(host, port).lookup(name) as T
    }
}