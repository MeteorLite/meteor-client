package meteor

import Main.client
import Main.overlayRenderer
import eventbus.Events
import eventbus.events.BeforeMenuRender
import eventbus.events.BeforeRender
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.input.KeyManager
import meteor.input.MouseManager
import meteor.rs.ClientThread
import meteor.ui.overlay.OverlayLayer
import meteor.util.RSTimeUnit
import net.runelite.api.BufferProvider
import net.runelite.api.GameState
import net.runelite.api.MainBufferProvider
import net.runelite.api.Renderable
import net.runelite.api.hooks.Callbacks
import net.runelite.api.hooks.DrawCallbacks
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetItem
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.awt.image.BufferedImage
import java.awt.image.VolatileImage
import org.rationalityfrontline.kevent.KEVENT as EventBus

@Suppress("UNCHECKED_CAST")
class Hooks : Callbacks {
    private var lastCheck: Long = 0
    private val CHECK: Long = RSTimeUnit.GAME_TICKS.duration
            .toNanos()
    private val GAME_TICK = GameTick()
    private var shouldProcessGameTick = false
    private var ignoreNextNpcUpdate = false
    private var lastMainBufferProvider: MainBufferProvider? = null
    private var lastGraphics: Graphics2D? = null
    private var drawManager = meteor.ui.DrawManager
    private var lastStretchedDimensions: Dimension? = null
    private var stretchedImage: VolatileImage? = null
    private var stretchedGraphics: Graphics2D? = null
    private var clientThread = ClientThread

    class PendingEvent(val type: Enum<*>, val event: Any)
    private var pendingEvents = ArrayList<PendingEvent>()

    init {
        EventBus.subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { event ->
            when (event.data.new ) {
                GameState.LOGGING_IN, GameState.HOPPING -> {
                    ignoreNextNpcUpdate = true
                }
                else -> {}
            }
        }
    }

    override fun post(type: Enum<*>, event: Any) {
        EventBus.post(type, event)
    }


    override fun postDeferred(type: Enum<*>, event: Any) {
        pendingEvents.add(PendingEvent(type, event))
    }

    override fun tick() {
        if (shouldProcessGameTick) {
            shouldProcessGameTick = false
            EventBus.post(Events.GAME_TICK, GAME_TICK)
            val tick: Int = client.tickCount
            client.tickCount = tick + 1
        }

        clientThread.invoke()

        val now = System.nanoTime()

        if (now - lastCheck < CHECK) {
            return
        }

        lastCheck = now
    }

    override fun frame() {
        EventBus.post(Events.BEFORE_RENDER, BeforeRender)
    }

    override fun updateNpcs() {
        if (ignoreNextNpcUpdate) {
            ignoreNextNpcUpdate = false
        } else {
            shouldProcessGameTick = true
        }

        pendingEvents.forEach{ post(it.type, it.event) }
        pendingEvents.clear()
    }

    override fun drawScene() {
        val graphics2d: Graphics2D = getGraphics(client.bufferProvider as MainBufferProvider)
        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ABOVE_SCENE)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

    override fun drawAboveOverheads() {
        val bufferProvider = client.bufferProvider as MainBufferProvider
        val graphics2d: Graphics2D = getGraphics(bufferProvider)

        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.UNDER_WIDGETS)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

    override fun draw(mainBufferProvider: MainBufferProvider, graphics: Graphics?, x: Int, y: Int) {
        if (graphics == null) {
            return
        }

        val graphics2d: Graphics2D = getGraphics(mainBufferProvider)

        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }

        if (client.isGpu) {
            // processDrawComplete gets called on GPU by the gpu plugin at the end of its
            // drawing cycle, which is later on.
            return
        }

        // Stretch the game image if the user has that enabled

        // Stretch the game image if the user has that enabled
        val image = mainBufferProvider.image
        val finalImage: Image
        if (client.isStretchedEnabled) {
            val gc: GraphicsConfiguration = client.canvas.graphicsConfiguration
            val stretchedDimensions: Dimension = client.stretchedDimensions
            if (lastStretchedDimensions == null || lastStretchedDimensions != stretchedDimensions
                    || (stretchedImage != null
                            && stretchedImage!!.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE)) {
                /*
					Reuse the resulting image instance to avoid creating an extreme amount of objects
				 */
                stretchedImage = gc
                        .createCompatibleVolatileImage(stretchedDimensions.width, stretchedDimensions.height)
                stretchedGraphics?.dispose()
                stretchedGraphics = stretchedImage!!.graphics as Graphics2D
                lastStretchedDimensions = stretchedDimensions

                /*
					Fill Canvas before drawing stretched image to prevent artifacts.
				*/graphics.color = Color.BLACK
                graphics.fillRect(0, 0, client.canvas.width, client.canvas.height)
            }
            stretchedGraphics!!.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    if (client.isStretchedFast) RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR else RenderingHints.VALUE_INTERPOLATION_BILINEAR)
            stretchedGraphics!!
                    .drawImage(image, 0, 0, stretchedDimensions.width, stretchedDimensions.height, null)
            finalImage = stretchedImage!!
        } else {
            finalImage = image
        }

        // Draw the image onto the game canvas
        graphics.drawImage(finalImage, 0, 0, client.canvas)

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.
        drawManager.processDrawComplete { copy(finalImage) }
    }

    private fun copy(src: Image): Image {
        val width = src.getWidth(null)
        val height = src.getHeight(null)
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val graphics = image.graphics
        graphics.drawImage(src, 0, 0, width, height, null)
        graphics.dispose()
        return image
    }

    override fun drawInterface(interfaceId: Int, widgetItems: MutableList<WidgetItem>) {
        val graphics2d: Graphics2D = getGraphics(client.bufferProvider as MainBufferProvider)

        try {
            overlayRenderer.renderAfterInterface(graphics2d, interfaceId, widgetItems)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }

    override fun drawLayer(layer: Widget, widgetItems: MutableList<WidgetItem>) {
        val bufferProvider = client.bufferProvider as MainBufferProvider
        val graphics2d: Graphics2D = getGraphics(bufferProvider)

        try {
            overlayRenderer.renderAfterLayer(graphics2d, layer, widgetItems)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private fun getGraphics(mainBufferProvider: MainBufferProvider): Graphics2D {
        if (lastGraphics == null || lastMainBufferProvider != mainBufferProvider) {
            lastGraphics?.dispose()
            lastMainBufferProvider = mainBufferProvider
            lastGraphics = mainBufferProvider.image.graphics as Graphics2D
        }
        return lastGraphics as Graphics2D
    }

    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMousePressed(mouseEvent)
    }

    override fun mouseReleased(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseReleased(mouseEvent)
    }

    override fun mouseClicked(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseClicked(mouseEvent)
    }

    override fun mouseEntered(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseEntered(mouseEvent)
    }

    override fun mouseExited(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseExited(mouseEvent)
    }

    override fun mouseDragged(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseDragged(mouseEvent)
    }

    override fun mouseMoved(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseMoved(mouseEvent)
    }

    override fun mouseWheelMoved(mouseEvent: MouseWheelEvent): MouseWheelEvent {
        return MouseManager.processMouseWheelMoved(mouseEvent)
    }

    override fun keyPressed(keyEvent: KeyEvent) {
        return KeyManager.processKeyPressed(keyEvent)
    }

    override fun keyReleased(keyEvent: KeyEvent) {
        return KeyManager.processKeyReleased(keyEvent)
    }

    override fun keyTyped(keyEvent: KeyEvent) {
        return KeyManager.processKeyTyped(keyEvent)
    }

    companion object {
        @JvmStatic
        fun clearColorBuffer(x: Int, y: Int, width: Int, height: Int, color: Int) {
            val bp: BufferProvider = client.bufferProvider
            val canvasWidth = bp.width
            val pixels = bp.pixels

            var pixelPos = y * canvasWidth + x
            val pixelJump = canvasWidth - width

            for (cy in y until y + height) {
                for (cx in x until x + width) {
                    pixels[pixelPos++] = 0
                }
                pixelPos += pixelJump
            }
        }

        @JvmStatic
        fun renderDraw(renderable: Renderable, orientation: Int, pitchSin: Int, pitchCos: Int,
                       yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int, hash: Long) {
            val drawCallbacks: DrawCallbacks? = client.drawCallbacks
            if (drawCallbacks != null) {
                drawCallbacks
                        .draw(renderable, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)
            } else {
                renderable.`draw$api`(orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)
            }
        }

        @JvmStatic
        fun drawMenu(): Boolean {
            val event = BeforeMenuRender()
            client.callbacks.post(Events.BEFORE_MENU_RENDER, event)
            return event.consumed
        }
    }
}