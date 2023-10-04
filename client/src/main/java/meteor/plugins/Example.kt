package meteor.plugins

import eventbus.events.GameStateChanged
import meteor.ui.overlay.Overlay
import net.runelite.api.GameState
import java.awt.Dimension
import java.awt.Graphics2D
import org.rationalityfrontline.kevent.KEVENT as EventBus

@PluginDescriptor("example-kotlin")
class ExamplePlugin : Plugin() {
    var exampleOverlay = overlay<ExampleOverlay>(ExampleOverlay)

    override fun onStart() {
        EventBus.subscribe<GameStateChanged> {
            when (it.data.gameState) {
                GameState.LOGGING_IN, GameState.HOPPING -> {
                    //println("Shits pretty slick")
                }
                else -> {}
            }
        }
    }
}

object ExampleOverlay : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        return null
    }
}