package meteor.plugins

import eventbus.Events
import eventbus.events.GameStateChanged
import meteor.ui.overlay.Overlay
import net.runelite.api.GameState
import org.rationalityfrontline.kevent.KEVENT as EventBus
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point
import java.awt.Rectangle

@PluginDescriptor("Example")
class ExamplePlugin: Plugin() {
    var exampleOverlay = overlay<ExampleOverlay>(ExampleOverlay)

    override fun onStart() {
        EventBus.subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) {
            when (it.data.new) {
                GameState.LOGGING_IN, GameState.HOPPING -> {
                    //println("Shits pretty slick")
                }
                else -> {}
            }
        }
    }
}

object ExampleOverlay: Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        return null
    }
}