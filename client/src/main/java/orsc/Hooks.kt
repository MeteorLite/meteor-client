package orsc;

import meteor.input.KeyManager
import meteor.input.MouseManager
import meteor.ui.overlay.OverlayLayer
import net.runelite.api.Constants
import net.runelite.api.hooks.Callbacks
import orsc.Main.overlayRenderer
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.awt.image.*
import org.rationalityfrontline.kevent.KEVENT as EventBus


class Hooks : Callbacks {
    private var lastStretchedDimensions: Dimension? = null
    private var stretchedImage: VolatileImage? = null
    private var stretchedGraphics: Graphics2D? = null

    class PendingEvent(val event: Any)

    private var pendingEvents = ArrayList<PendingEvent>()

    override fun post(event: Any) {
        EventBus.post(event)
    }


    override fun postDeferred(event: Any) {
        pendingEvents.add(PendingEvent(event))
    }

    override fun tick() {

    }

    override fun frame() {

    }

    override fun updateNpcs() {

    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun drawScene(pixels: IntArray) {
        val sceneOverlay = BufferedImage(Constants.GAME_FIXED_WIDTH, Constants.GAME_FIXED_HEIGHT, BufferedImage.TYPE_INT_ARGB)
        val graphics2d = sceneOverlay.graphics as Graphics2D
        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ABOVE_SCENE)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }

        for (y in 0..<sceneOverlay.height) {
            for (x in 0..<sceneOverlay.width) {
                val color = sceneOverlay.getRGB(x, y)
                if (color != 0) {
                    setPixel(pixels, sceneOverlay.width+1, sceneOverlay.height+1, x, y, color)
                }
            }
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun drawOnTop(pixels: IntArray) {
        val onTopOverlay = BufferedImage(Constants.GAME_FIXED_WIDTH, Constants.GAME_FIXED_HEIGHT, BufferedImage.TYPE_INT_ARGB)
        val graphics2d = onTopOverlay.graphics as Graphics2D
        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }

        for (y in 0..<onTopOverlay.height) {
            for (x in 0..<onTopOverlay.width) {
                val color = onTopOverlay.getRGB(x, y)
                if (color != 0)
                    setPixel(pixels, onTopOverlay.width+1, onTopOverlay.height+1, x, y, color)
            }
        }
    }

    private fun createRSBufferedImage(width: Int, height: Int): BufferedImage {
        val colorModel = DirectColorModel(32, 0xff0000, 65280, 255, 1);
        val raster: WritableRaster = colorModel.createCompatibleWritableRaster(width, height)
        return BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied, null)
    }

    fun setPixel(
            pixels: IntArray,
            rw: Int, rh: Int,
            x: Int, y: Int, colour: Int
    ) {
        if (x >= 0 && y >= 0 && x < rw && y < rh) {
            pixels[x + y * rw] = colour
        }
    }


    override fun drawAboveOverheads() {

    }

    private lateinit var gameImage: Image
    lateinit var finalImage: Image

    override fun draw(mainBufferProvider: Image, x: Int, y: Int) {
/*        if (mainBufferProvider == null) {
            return
        }
        //TODO: Do this in a better place, we shouldn't be calling it every frame
        client.invalidateStretching(true)

        gameImage = copy(mainBufferProvider)

        val graphics2d: Graphics2D = gameImage.graphics as Graphics2D

        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }

        finalImage = gameImage*/


        // Draw the image onto the game canvas
        //canvas.graphics.drawImage(finalImage, 0, 0, null)

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.
        //drawManager.processDrawComplete { copy(finalImage) }
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

    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        val newEvent = MouseManager.processMousePressed(mouseEvent)
        return newEvent
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
/*        val newScale = client.scale + mouseEvent.wheelRotation * 40
        if (newScale > 4000 || newScale < 300)
            return MouseManager.processMouseWheelMoved(mouseEvent)
        client.scale = newScale
        println("zoom change: ${client.scale}")*/
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
}