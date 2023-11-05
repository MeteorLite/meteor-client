package meteor

import eventbus.events.InventoryUpdated
import events.UpdateInventoryPacket
import meteor.Main.client
import meteor.Main.overlayRenderer
import meteor.input.KeyManager
import meteor.input.MouseManager
import meteor.plugins.PluginManager
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.ui.composables.ui.canvas
import meteor.ui.composables.ui.gamePanel
import meteor.ui.overlay.OverlayLayer
import net.runelite.api.Constants
import net.runelite.api.InventoryItem
import net.runelite.api.hooks.Callbacks
import org.rationalityfrontline.kevent.KEVENT
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.awt.image.*
import org.rationalityfrontline.kevent.KEVENT as EventBus


class Hooks : Callbacks {

    init {
        KEVENT.subscribe<UpdateInventoryPacket> {
            val inventoryItems = ArrayList<InventoryItem>()
            for (slot in 0..client.inventorySize) {
                inventoryItems.add(
                    InventoryItem(
                    client.inventoryItemsIDs[slot],
                    client.inventoryItemsQuantities[slot],
                    client.inventoryItemsEquipped[slot],
                    client.inventoryItemsQuantities[slot],
                    slot))
            }
            client.inventoryItems = inventoryItems
            KEVENT.post(InventoryUpdated(inventoryItems))
        }
    }

    private var lastStretchedDimensions: Dimension? = null
    private var lastRealDimensions: Dimension? = null
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

    val transparent = 0

    override fun drawScene(pixels: IntArray) {
        try {
            val overlayImage = BufferedImage(client.gameWidth, client.gameHeight, BufferedImage.TYPE_INT_ARGB)
            val graphics2d = overlayImage.graphics as Graphics2D

            if (!Main.meteorConfig.disableOverlayAlpha()) {
                val gameImage = createRSBufferedImage(client.gameWidth, client.gameHeight)
                for (y in 0..<client.gameHeight) {
                    for (x in 0..<client.gameWidth)
                        gameImage.setRGB(x, y, getPixel(pixels, client.gameWidth, client.gameHeight, x, y))
                }

                graphics2d.drawImage(gameImage, 0, 0, null)
            }

            try {
                overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ABOVE_SCENE)
            } catch (ex: java.lang.Exception) {
                ex.printStackTrace()
            }

            for (y in 0..<client.gameHeight) {
                for (x in 0..<client.gameWidth) {
                    val color = overlayImage.getRGB(x, y)
                    if (color != 0)
                    setPixel(pixels, client.gameWidth, client.gameHeight, x, y, color)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun createRSBufferedImage(width: Int, height: Int): BufferedImage {
        val colorModel = DirectColorModel(32, 0xff0000, 65280, 255);
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

    fun getPixel(
            pixels: IntArray,
            rw: Int, rh: Int,
            x: Int, y: Int
    ): Int {
        if (x >= 0 && y >= 0 && x < rw && y < rh) {
            return pixels[x + y * rw]
        }
        return 0
    }


    override fun drawAboveOverheads() {

    }

    private lateinit var gameImage: Image
    lateinit var finalImage: Image
    var lastWidth = -1
    var lastHeight = -1
    var skipNextFrame = false

    override fun draw(mainBufferProvider: Image, x: Int, y: Int) {
        if (canvas.graphics == null) {
            return
        }

        client.invalidateStretching(true)

        gameImage = if (client.isStretchedEnabled || client.isSleeping)
            copy(mainBufferProvider).getSubimage(0, 0, Constants.GAME_FIXED_WIDTH, Constants.GAME_FIXED_HEIGHT)
        else
            copy(mainBufferProvider)
        val graphics2d: Graphics2D = gameImage.graphics as Graphics2D

        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }

        // Stretch the game image if the user has that enabled
        if (client.isStretchedEnabled) {
            val gc: GraphicsConfiguration = gamePanel.graphicsConfiguration
            val stretchedDimensions: Dimension = client.stretchedDimensions
            var status = -1
            if (stretchedDimensions != lastStretchedDimensions || stretchedImage == null || stretchedImage!!.validate(
                    gc
                ).also { status = it } != VolatileImage.IMAGE_OK
            ) {
                // if IMAGE_INCOMPATIBLE the image and g2d need to be rebuilt, otherwise
                // if IMAGE_RESTORED only the g2d needs to be rebuilt
                stretchedGraphics?.dispose()

                if (stretchedDimensions != lastStretchedDimensions || stretchedImage == null || status == VolatileImage.IMAGE_INCOMPATIBLE) {
                    // VolatileImage javadocs says this proactively releases the resources used by the VolatileImage
                    stretchedImage?.flush()

                    if (stretchedDimensions.width <= 0 || stretchedDimensions.height <= 0)
                        return
                    stretchedImage =
                        gc.createCompatibleVolatileImage(stretchedDimensions.width, stretchedDimensions.height)
                    lastStretchedDimensions = stretchedDimensions
                }
                stretchedGraphics = stretchedImage!!.graphics as Graphics2D
            }

            stretchedGraphics!!.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                if (client.isStretchedFast) RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR else RenderingHints.VALUE_INTERPOLATION_BILINEAR
            )
            stretchedGraphics!!.drawImage(gameImage, 0, 0, stretchedDimensions.width, stretchedDimensions.height, null)

            finalImage = stretchedImage!!
        } else {
            finalImage = gameImage
        }

        if (!skipNextFrame)
        // Draw the image onto the game canvas
            canvas.graphics.drawImage(finalImage, 0, 0, null)
        else
            skipNextFrame = false

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.

        // finalImage is backed by the client buffer which will change soon. make a copy
        // so that callbacks can safely use it later from threads.
        //drawManager.processDrawComplete { copy(finalImage) }

        if (!client.isStretchedEnabled) {
            client.gameWidth = canvas.width
            client.gameHeight = canvas.height - 12
            client.`setBounds$api`()
        } else {
            client.gameWidth = Constants.GAME_FIXED_WIDTH
            client.gameHeight = Constants.GAME_FIXED_HEIGHT - 12
            client.`setBounds$api`()
        }

        if (!client.isStretchedEnabled) {
            if (client.gameWidth != lastWidth || client.gameHeight != lastHeight - 12) {
                client.`createMessageTabPanel$api`()
                lastWidth = client.gameWidth
                lastHeight = client.gameHeight + 12
                skipNextFrame = true
            }
        } else {
            if (client.gameWidth != Constants.GAME_FIXED_WIDTH || client.gameHeight != Constants.GAME_FIXED_HEIGHT - 12) {
                client.`createMessageTabPanel$api`()
                skipNextFrame = true
            }
        }
    }

    private fun copy(src: Image): BufferedImage {
        val width = src.getWidth(null)
        val height = src.getHeight(null)
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val graphics = image.graphics
        graphics.drawImage(src, 0, 0, width, height, null)
        graphics.dispose()
        return image
    }

    var mouseWheelPressed = false

    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        val newEvent = MouseManager.processMousePressed(mouseEvent)
        if (mouseEvent.button == MouseEvent.BUTTON2)
            mouseWheelPressed = true
        return newEvent
    }

    fun checkInventoryClicked(click: MouseEvent): Boolean {
        return click.x >= Constants.GAME_FIXED_WIDTH - 35
                && click.y >= 3
                && click.x < Constants.GAME_FIXED_WIDTH - 3
                && click.y < 35
    }

    override fun mouseReleased(mouseEvent: MouseEvent): MouseEvent {
        if (mouseEvent.button == MouseEvent.BUTTON2)
            mouseWheelPressed = false
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
        val xGain = mouseEvent.x - lastMouseX
        lastMouseX = mouseEvent.x
        if (mouseWheelPressed) {
            if (xGain > 0)
                client.cameraRotation += 1
            if (xGain < 0)
                client.cameraRotation -= 1
        }
        return MouseManager.processMouseDragged(mouseEvent)
    }

    var lastMouseX = 0

    override fun mouseMoved(mouseEvent: MouseEvent): MouseEvent {
        return MouseManager.processMouseMoved(mouseEvent)
    }

    override fun mouseWheelMoved(mouseEvent: MouseWheelEvent): MouseWheelEvent {
        val newScale = client.scale + mouseEvent.wheelRotation * 40
        if (newScale > 4000 || newScale < 100)
            return MouseManager.processMouseWheelMoved(mouseEvent)
        client.scale = newScale
        return MouseManager.processMouseWheelMoved(mouseEvent)
    }

    override fun keyPressed(keyEvent: KeyEvent) {
        if (client.showOptionsMenu)
        if (keyEvent.keyCode == KeyEvent.VK_1) {
            client.`chooseOption$api`(0)
            keyEvent.consume()
        }
        if (client.showOptionsMenu)
            if (keyEvent.keyCode == KeyEvent.VK_2) {
                client.`chooseOption$api`(1)
                keyEvent.consume()
            }
        if (client.showOptionsMenu)
            if (keyEvent.keyCode == KeyEvent.VK_3) {
                client.`chooseOption$api`(2)
                keyEvent.consume()
            }
        if (client.showOptionsMenu)
            if (keyEvent.keyCode == KeyEvent.VK_4) {
                client.`chooseOption$api`(3)
                keyEvent.consume()
            }
        if (client.showOptionsMenu)
            if (keyEvent.keyCode == KeyEvent.VK_5) {
                client.`chooseOption$api`(4)
                keyEvent.consume()
            }
        if (client.showOptionsMenu)
            if (keyEvent.keyCode == KeyEvent.VK_6) {
                client.`chooseOption$api`(5)
                keyEvent.consume()
            }
        if (keyEvent.keyCode == KeyEvent.VK_ESCAPE)
            client.setShowUITab(0)
        return KeyManager.processKeyPressed(keyEvent)
    }

    override fun keyReleased(keyEvent: KeyEvent) {
        return KeyManager.processKeyReleased(keyEvent)
    }

    override fun keyTyped(keyEvent: KeyEvent) {
        return KeyManager.processKeyTyped(keyEvent)
    }
}