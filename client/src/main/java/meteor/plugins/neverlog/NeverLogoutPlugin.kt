package meteor.plugins.neverlog

import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import java.util.*

@PluginDescriptor(
    name = "Never Logout",
    description = "Prevents automatic session logout",
    tags = ["actions", "overlay"],
    enabledByDefault = false
)
class NeverLogoutPlugin : Plugin() {

    private var randomTick = 0
    private val random = Random()

    override fun onGameTick(it: GameTick) {
        if (randomTick == -1) {
            if (client.keyboardIdleTicks > randomTick) {
                generateRandomTick()
                client.keyboardIdleTicks = 0
            }
        }
        if (client.mouseIdleTicks > randomTick) {
            generateRandomTick()
            client.mouseIdleTicks = 0
        }
    }

    private fun generateRandomTick() {
        randomTick = 11900 + random.nextInt(3000)
    }
}