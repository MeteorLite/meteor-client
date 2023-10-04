package meteor

import eventbus.events.InventoryUpdated
import events.UpdateInventoryPacket
import meteor.Main.client
import meteor.input.KeyManager
import meteor.input.MouseManager
import meteor.ui.composables.ui.canvas
import meteor.ui.composables.ui.gamePanel
import net.runelite.api.InventoryItem
import net.runelite.api.hooks.Callbacks
import org.rationalityfrontline.kevent.KEVENT
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.awt.image.BufferedImage
import java.awt.image.VolatileImage
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
                    client.inventoryItemsQuantities[slot]))
            }
            client.inventoryItems = inventoryItems
            KEVENT.post(InventoryUpdated(inventoryItems))
        }
    }

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

    override fun drawScene() {

    }

    override fun drawAboveOverheads() {

    }

    private lateinit var gameImage: Image
    lateinit var finalImage: Image

    override fun draw(mainBufferProvider: Image, x: Int, y: Int) {
        if (canvas.graphics == null) {
            return
        }
        //TODO: Do this in a better place, we shouldn't be calling it every frame
        client.invalidateStretching(true)
        val graphics2d: Graphics2D = canvas.graphics as Graphics2D

/*        try {
            overlayRenderer.renderOverlayLayer(graphics2d, OverlayLayer.ALWAYS_ON_TOP)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }*/

        // Stretch the game image if the user has that enabled
        gameImage = mainBufferProvider
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


        // Draw the image onto the game canvas
        canvas.graphics.drawImage(finalImage, 0, 0, null)

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
}