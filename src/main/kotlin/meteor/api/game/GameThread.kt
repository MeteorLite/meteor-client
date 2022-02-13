package meteor.api.game

import Main.client
import meteor.rs.ClientThread
import java.util.concurrent.*

object GameThread {

 var clientThread = ClientThread

    private const val timeout = 500L

    fun <T> invoke(func: () -> T) {
        try {
            if (client.isClientThread) {
                func()
            } else {
                clientThread.invokeLater(Runnable { func() })
            }
        } catch (e: Exception) {

        }
    }

    fun <T> invokeLater(func: () -> T): T? {
        if (client.isClientThread) {
            return try {
                func()
            } catch (e: Exception) {
                null
            }
        }

        return try {
            val futureTask = FutureTask(Callable(func))
            clientThread.invokeLater(futureTask)
            futureTask.get(timeout, TimeUnit.MILLISECONDS)
        } catch (e: Exception) {
            null
        }
    }
}