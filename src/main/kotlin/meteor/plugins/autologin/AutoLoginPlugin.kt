package meteor.plugins.autologin

import Main
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import org.rationalityfrontline.kevent.Event
import java.awt.Canvas
import java.awt.event.KeyEvent
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

@PluginDescriptor(
    name = "Auto Login",
    description = "Automatically fills in your saved details and logs in",
    enabledByDefault = false
)
class AutoLoginPlugin : Plugin() {
   override val config = configuration<AutoLoginConfig>()
    private val executor: ScheduledExecutorService = Main.executor

    override fun onGameStateChanged(): ((Event<eventbus.events.GameStateChanged>) -> Unit) = {
        if (it.data.new == GameState.LOGIN_SCREEN && client.loginIndex === 0) {
            executor.schedule(Runnable { client.loginIndex = 2 }, 2000, TimeUnit.MILLISECONDS)
            executor.schedule(Runnable { login() }, 2000, TimeUnit.MILLISECONDS)
        }
    }

    override fun onLoginStateChanged(): ((Event<eventbus.events.LoginStateChanged>) -> Unit) = {
        if (it.data.index == 2) {
            login()
        }
    }


    private fun login() {
        client.username = config.username()
        client.setPassword(config.password())
        sendEnter()
        Thread.sleep(600L)
        sendEnter()
    }
    fun type(text: String, sendEnter: Boolean = false) {
        val chars = text.toCharArray()
        for (c in chars) {
            type(c)
        }
        if (sendEnter) {
            sendEnter()
        }
    }
    fun type(c: Char) {
        val canvas: Canvas = client.canvas
        val time = System.currentTimeMillis()
        val keyCode = KeyEvent.getExtendedKeyCodeForChar(c.code)
        val pressed = KeyEvent(canvas, KeyEvent.KEY_PRESSED, time, 0, keyCode, c, KeyEvent.KEY_LOCATION_STANDARD)
        val typed = KeyEvent(canvas, KeyEvent.KEY_TYPED, time, 0, 0, c, KeyEvent.KEY_LOCATION_UNKNOWN)
        canvas.dispatchEvent(pressed)
        canvas.dispatchEvent(typed)
        val released = KeyEvent(
            canvas,
            KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(),
            0,
            keyCode,
            c,
            KeyEvent.KEY_LOCATION_STANDARD
        )
        canvas.dispatchEvent(released)
    }

    fun sendEnter() {
        type(KeyEvent.VK_ENTER.toChar())
    }
}