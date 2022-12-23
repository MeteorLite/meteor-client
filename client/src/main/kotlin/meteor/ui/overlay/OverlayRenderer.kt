package meteor.ui.overlay

import com.google.common.base.MoreObjects
import com.google.common.primitives.Ints
import eventbus.Events
import eventbus.events.BeforeRender
import eventbus.events.ClientTick
import meteor.Main.client
import meteor.Main.fontManager
import meteor.Main.overlayManager
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.input.MouseAdapter
import meteor.input.MouseManager
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.widgets.WidgetItem
import java.awt.*
import java.awt.Point
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import javax.swing.SwingUtilities
import org.rationalityfrontline.kevent.KEVENT as EventBus

class OverlayRenderer : KeyListener, MouseAdapter() {

    init {
        KeyManager.registerKeyListener(this, javaClass)
        MouseManager.registerMouseListener(this)
        EventBus.subscribe<BeforeRender>(Events.BEFORE_RENDER, onBeforeRender())
        EventBus.subscribe<ClientTick>(Events.CLIENT_TICK, onClientTick())
        EventBus.subscribe<Unit>(Events.FOCUS_CHANGED) {
            inOverlayDraggingMode = false
            inOverlayManagingMode = false
            inOverlayResizingMode = false
        }
    }

    fun onClientTick(): (Any) -> Unit = {
        if (menuEntries != null) {
            val shift = client.isKeyPressed(KeyCode.KC_SHIFT)

            if (!client.isMenuOpen) {
                val clientMenuEntries = client.menuEntries
                val newEntries = arrayOfNulls<MenuEntry>(clientMenuEntries.size + menuEntries!!.size)
                newEntries[0] = clientMenuEntries[0] // Keep cancel at 0
                System.arraycopy(menuEntries, 0, newEntries, 1, menuEntries!!.size) // Add overlay menu entries
                System.arraycopy(
                    clientMenuEntries, 1, newEntries, menuEntries!!.size + 1,
                    clientMenuEntries.size - 1
                ) // Add remaining menu entries
                client.menuEntries = newEntries
            }
        }

    }

    fun onBeforeRender(): (Any) -> Unit = {
        ClientThread.invoke {
            menuEntries = null
            if (focusedOverlay == null && prevFocusedOverlay != null) {
                prevFocusedOverlay!!.onMouseExit()
            }
            prevFocusedOverlay = focusedOverlay
            focusedOverlay = null
            if (client.gameState == GameState.LOGGED_IN) {
                if (shouldInvalidateBounds()) {
                    emptySnapCorners = buildSnapCorners()
                }
                if (emptySnapCorners == null)
                    emptySnapCorners = buildSnapCorners()
                // Create copy of snap corners because overlays will modify them
                snapCorners = OverlayBounds(other = emptySnapCorners!!)
            }
        }
    }


    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e!!.isAltDown) {
            inOverlayManagingMode = true
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        if (!e!!.isAltDown && inOverlayManagingMode) {
            inOverlayManagingMode = false
            resetOverlayManagementMode()
        }
    }


    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        if (!inOverlayManagingMode) {
            return mouseEvent
        }
        val mousePoint = mouseEvent.point
        mousePosition.location = mousePoint

        // See if we've clicked on an overlay
        currentManagedOverlay = findMangedOverlay(mousePoint)
        if (currentManagedOverlay == null) {
            return mouseEvent
        }
        if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            if (currentManagedOverlay!!.resettable) {
                OverlayManager.resetOverlay(currentManagedOverlay!!)
            }
        } else if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            val offset = Point(mousePoint.x, mousePoint.y)
            offset.translate(-currentManagedOverlay!!.bounds!!.x, -currentManagedOverlay!!.bounds!!.y)
            overlayOffset.location = offset
            inOverlayResizingMode = (currentManagedOverlay != null && currentManagedOverlay!!.resizable)
            inOverlayDraggingMode = !inOverlayResizingMode
            startedMovingOverlay = true
            currentManagedBounds = Rectangle(currentManagedOverlay!!.bounds!!)
        } else {
            return mouseEvent
        }
        mouseEvent.consume()
        return mouseEvent
    }

    override fun mouseDragged(mouseEvent: MouseEvent): MouseEvent {
        if (!inOverlayManagingMode) {
            return mouseEvent
        }
        val p = mouseEvent.point
        mousePosition.location = p
        if (currentManagedOverlay == null) {
            return mouseEvent
        }
        if (dragTargetOverlay != null && !currentManagedOverlay!!.bounds!!
                .intersects(dragTargetOverlay!!.bounds!!)
        ) {
            // No longer over drag target
            dragTargetOverlay = null
        }
        val canvasRect = Rectangle(client.realDimensions)
        if (!canvasRect.contains(p)) {
            return mouseEvent
        }
        if (inOverlayResizingMode) {
            val left = p.x - currentManagedBounds!!.x // Distance (in pixels) from the left edge of the bounds
            val top = p.y - currentManagedBounds!!.y // Distance (in pixels) from the top edge of the bounds
            val originalX = currentManagedBounds!!.x
            val originalY = currentManagedBounds!!.y
            var x = originalX
            var y = originalY
            var width = currentManagedBounds!!.width
            var height = currentManagedBounds!!.height
            /*            when (meteorUI.getCurrentCursor().getType()) {
                            Cursor.N_RESIZE_CURSOR -> {
                                y += top
                                height -= top
                            }
                            Cursor.NW_RESIZE_CURSOR -> {
                                x += left
                                y += top
                                width -= left
                                height -= top
                            }
                            Cursor.W_RESIZE_CURSOR -> {
                                x += left
                                width -= left
                            }
                            Cursor.SW_RESIZE_CURSOR -> {
                                x += left
                                width -= left
                                height = top
                            }
                            Cursor.S_RESIZE_CURSOR -> height = top
                            Cursor.SE_RESIZE_CURSOR -> {
                                width = left
                                height = top
                            }
                            Cursor.E_RESIZE_CURSOR -> width = left
                            Cursor.NE_RESIZE_CURSOR -> {
                                y += top
                                width = left
                                height -= top
                            }
                            else -> {}
                        }*/
            val minOverlaySize: Int = currentManagedOverlay!!.minimumSize
            val widthOverflow = Math.max(0, minOverlaySize - width)
            val heightOverflow = Math.max(0, minOverlaySize - height)
            val dx = x - originalX
            val dy = y - originalY

            // If this resize operation would cause the dimensions to go below the minimum width/height, reset the
            // dimensions and adjust the x/y position accordingly as needed
            if (widthOverflow > 0) {
                width = minOverlaySize
                if (dx > 0) {
                    x -= widthOverflow
                }
            }
            if (heightOverflow > 0) {
                height = minOverlaySize
                if (dy > 0) {
                    y -= heightOverflow
                }
            }
            currentManagedBounds!!.setRect(x.toDouble(), y.toDouble(), width.toDouble(), height.toDouble())
            currentManagedOverlay!!.setPreferredSize(
                Dimension(currentManagedBounds!!.width, currentManagedBounds!!.height)
            )
            if (currentManagedOverlay!!.getPreferredLocation() != null) {
                currentManagedOverlay!!.setPreferredLocation(currentManagedBounds!!.location)
            }
        } else if (inOverlayDraggingMode) {
            var overlayPosition = Point(p)
            overlayPosition.translate(
                -overlayOffset.x,
                -overlayOffset.y
            ) // adjust by mouse offset to get overlay position

            // Clamp drag to parent component
            val overlayBounds = currentManagedOverlay!!.bounds
            overlayPosition = clampOverlayLocation(
                overlayPosition.x, overlayPosition.y,
                overlayBounds!!.width, overlayBounds.height, currentManagedOverlay!!
            )
            currentManagedOverlay!!.preferredPosition = null
            currentManagedOverlay!!.setPreferredLocation(overlayPosition)
        } else {
            return mouseEvent
        }
        if (startedMovingOverlay) {
            // Move currently moved overlay to correct layer
            OverlayManager.rebuildOverlayLayers()
            startedMovingOverlay = false
        }
        mouseEvent.consume()
        return mouseEvent
    }

    override fun mouseMoved(mouseEvent: MouseEvent): MouseEvent {
        if (!inOverlayManagingMode) {
            return mouseEvent
        }
        val mousePoint = mouseEvent.point
        mousePosition.location = mousePoint
        if (!inOverlayResizingMode && !inOverlayDraggingMode) {
            currentManagedOverlay = findMangedOverlay(mousePoint)
        }
        if (currentManagedOverlay == null || !currentManagedOverlay!!.resizable) {
            return mouseEvent
        }
        val toleranceRect: Rectangle = Rectangle(currentManagedOverlay!!.bounds)
        toleranceRect.grow(
            -OVERLAY_RESIZE_TOLERANCE,
            -OVERLAY_RESIZE_TOLERANCE
        )
        val outcode = toleranceRect.outcode(mouseEvent.point)
        /*            when (outcode) {
                        Rectangle.OUT_TOP -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR))
                        Rectangle.OUT_TOP or Rectangle.OUT_LEFT -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR))
                        Rectangle.OUT_LEFT -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR))
                        Rectangle.OUT_LEFT or Rectangle.OUT_BOTTOM -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR))
                        Rectangle.OUT_BOTTOM -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR))
                        Rectangle.OUT_BOTTOM or Rectangle.OUT_RIGHT -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR))
                        Rectangle.OUT_RIGHT -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR))
                        Rectangle.OUT_RIGHT or Rectangle.OUT_TOP -> meteorUI.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR))
                        else ->         // center
                            meteorUI.setCursor(meteorUI.getDefaultCursor())
                    }*/
        return mouseEvent
    }

    override fun mouseReleased(mouseEvent: MouseEvent): MouseEvent {
        if (!inOverlayManagingMode || currentManagedOverlay == null || (!inOverlayDraggingMode
                    && !inOverlayResizingMode)
        ) {
            return mouseEvent
        }
        mousePosition.setLocation(-1, -1)
        if (dragTargetOverlay != null) {
            if (dragTargetOverlay!!.onDrag(currentManagedOverlay)) {
                mouseEvent.consume()
                resetOverlayManagementMode()
                return mouseEvent
            }
        }

        // Check if the overlay is over a snapcorner and move it if so, unless it is a detached overlay
        if (currentManagedOverlay!!.position != OverlayPosition.DETACHED && inOverlayDraggingMode) {
            val snapCorners = emptySnapCorners!!.translated(
                -SNAP_CORNER_SIZE.width,
                -SNAP_CORNER_SIZE.height
            )
            for (snapCorner in snapCorners.bounds) {
                if (snapCorner!!.contains(mouseEvent.point)) {
                    var position: OverlayPosition? = snapCorners.fromBounds(snapCorner)
                    if (position == currentManagedOverlay!!.position) {
                        // overlay moves back to default position
                        //position = null
                    }
                    currentManagedOverlay!!.preferredPosition = (position)
                    currentManagedOverlay!!.setPreferredLocation(null) // from dragging
                    break
                }
            }
        }
        //overlayManager.saveOverlay(currentManagedOverlay)
        resetOverlayManagementMode()
        mouseEvent.consume()
        return mouseEvent
    }


    private val BORDER = 5
    private val BORDER_TOP = 25
    private val PADDING = 2
    private val OVERLAY_RESIZE_TOLERANCE = 5
    private val SNAP_CORNER_SIZE = Dimension(80, 80)
    private val SNAP_CORNER_COLOR = Color(0, 255, 255, 50)
    private val SNAP_CORNER_ACTIVE_COLOR = Color(0, 255, 0, 100)
    private val MOVING_OVERLAY_COLOR = Color(255, 255, 0, 100)
    private val MOVING_OVERLAY_ACTIVE_COLOR = Color(255, 255, 0, 200)
    private val MOVING_OVERLAY_TARGET_COLOR = Color.RED
    private val MOVING_OVERLAY_RESIZING_COLOR = Color(255, 0, 255, 200)

    // Overlay movement variables
    private val overlayOffset = Point()
    private val mousePosition = Point()
    private var currentManagedOverlay: Overlay? = null
    private var dragTargetOverlay: Overlay? = null
    private var currentManagedBounds: Rectangle? = null
    private var inOverlayManagingMode = false
    private var inOverlayResizingMode = false
    private var inOverlayDraggingMode = false
    private var startedMovingOverlay = false
    private var menuEntries: Array<MenuEntry>? = null

    // Overlay state validation
    private var viewportBounds: Rectangle? = null
    private var chatboxBounds: Rectangle? = null
    private var chatboxHidden = false
    private var isResizeable = false
    private var emptySnapCorners: OverlayBounds? = null
    private var snapCorners: OverlayBounds? = null

    // focused overlay
    private var focusedOverlay: Overlay? = null
    private var prevFocusedOverlay: Overlay? = null


    private fun getViewportLayer(): Widget? {
        return if (client.isResized) {
            if (client.getVarbitValue(Varbits.SIDE_PANELS) == 1) {
                client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE)
            } else {
                client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX)
            }
        } else client.getWidget(WidgetInfo.FIXED_VIEWPORT)
    }

    private fun shouldInvalidateBounds(): Boolean {
        val chatbox = client.getWidget(WidgetInfo.CHATBOX)
        val resizeableChanged = isResizeable != client.isResized
        var changed = false
        if (resizeableChanged) {
            isResizeable = client.isResized
            changed = true
        }
        val chatboxBoundsChanged = chatbox == null || chatbox.bounds != chatboxBounds
        if (chatboxBoundsChanged) {
            chatboxBounds = if (chatbox != null) chatbox.bounds else Rectangle()
            changed = true
        }
        val chatboxHiddenChanged = chatboxHidden != (chatbox == null || chatbox.isHidden)
        if (chatboxHiddenChanged) {
            chatboxHidden = chatbox == null || chatbox.isHidden
            changed = true
        }
        val viewportWidget: Widget? = getViewportLayer()
        val viewport = if (viewportWidget != null) viewportWidget.bounds else Rectangle()
        val viewportChanged = viewport != viewportBounds
        if (viewportChanged) {
            viewportBounds = viewport
            changed = true
        }
        return changed
    }

    private fun buildSnapCorners(): OverlayBounds {
        val viewportWidget: Widget? = getViewportLayer()
        val viewport = if (viewportWidget != null) viewportWidget.bounds else Rectangle()
        val topLeftPoint = Point(
            viewport!!.x + BORDER,
            viewport.y + BORDER_TOP
        )
        val topCenterPoint = Point(
            viewport.x + viewport.width / 2,
            viewport.y + BORDER
        )
        val topRightPoint = Point(
            viewport.x + viewport.width - BORDER,
            topCenterPoint.y
        )
        val bottomLeftPoint = Point(
            topLeftPoint.x,
            viewport.y + viewport.height - BORDER
        )
        val bottomRightPoint = Point(
            topRightPoint.x,
            bottomLeftPoint.y
        )

        // Check to see if chat box is minimized
        if (isResizeable && chatboxHidden) {
            bottomLeftPoint.y += chatboxBounds!!.height
        }
        val rightChatboxPoint = if (isResizeable) Point(
            viewport.x + chatboxBounds!!.width - BORDER,
            bottomLeftPoint.y
        ) else bottomRightPoint
        val canvasTopRightPoint = if (isResizeable) Point(
            client.realDimensions.getWidth().toInt(),
            0
        ) else topRightPoint
        return OverlayBounds(
            Rectangle(topLeftPoint, SNAP_CORNER_SIZE),
            Rectangle(topCenterPoint, SNAP_CORNER_SIZE),
            Rectangle(topRightPoint, SNAP_CORNER_SIZE),
            Rectangle(bottomLeftPoint, SNAP_CORNER_SIZE),
            Rectangle(bottomRightPoint, SNAP_CORNER_SIZE),
            Rectangle(rightChatboxPoint, SNAP_CORNER_SIZE),
            Rectangle(canvasTopRightPoint, SNAP_CORNER_SIZE)
        )
    }


    fun renderOverlayLayer(graphics: Graphics2D, layer: OverlayLayer) {
        val overlays: Collection<Overlay> = OverlayManager.getLayer(layer)
        renderOverlays(graphics, overlays, layer)
    }

    fun renderAfterLayer(
        graphics: Graphics2D, layer: Widget,
        widgetItems: Collection<WidgetItem>
    ) {
        val overlays = OverlayManager.getForLayer(layer.id)
        OverlayManager.widgetItems = widgetItems
        renderOverlays(graphics, overlays, OverlayLayer.ABOVE_WIDGETS)
        OverlayManager.widgetItems = emptyList()
    }

    fun setGraphicProperties(graphics: Graphics2D) {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    }

    private fun getCorrectedOverlayPosition(overlay: Overlay): OverlayPosition? {
        var overlayPosition: OverlayPosition?
        overlayPosition = if (overlay.preferredPosition != null)
            overlay.preferredPosition
        else
            overlay.position
        if (!isResizeable) {
            // On fixed mode, ABOVE_CHATBOX_RIGHT is in the same location as
            // BOTTOM_RIGHT and CANVAS_TOP_RIGHT is same as TOP_RIGHT.
            // Just use BOTTOM_RIGHT and TOP_RIGHT to prevent overlays from
            // drawing over each other.
            when (overlayPosition) {
                OverlayPosition.CANVAS_TOP_RIGHT -> overlayPosition = OverlayPosition.TOP_RIGHT
                OverlayPosition.ABOVE_CHATBOX_RIGHT -> overlayPosition = OverlayPosition.BOTTOM_RIGHT
                else -> {}
            }
        }
        return overlayPosition
    }

    fun transformPosition(position: OverlayPosition?, dimension: Dimension): Point {
        val result = Point()
        when (position) {
            OverlayPosition.DYNAMIC, OverlayPosition.TOOLTIP, OverlayPosition.TOP_LEFT -> {}
            OverlayPosition.TOP_CENTER -> result.x = -dimension.width / 2
            OverlayPosition.BOTTOM_LEFT -> result.y = -dimension.height
            OverlayPosition.BOTTOM_RIGHT, OverlayPosition.ABOVE_CHATBOX_RIGHT -> {
                result.y = -dimension.height
                result.x = -dimension.width
            }
            OverlayPosition.CANVAS_TOP_RIGHT, OverlayPosition.TOP_RIGHT -> result.x = -dimension.width
            else -> {}
        }
        return result
    }

    fun padPosition(
        position: OverlayPosition, dimension: Dimension,
        padding: Int
    ): Point {
        val result = Point()
        when (position) {
            OverlayPosition.DYNAMIC, OverlayPosition.TOOLTIP -> {}
            OverlayPosition.BOTTOM_LEFT -> result.y -= dimension.height + (if (dimension.height == 0) 0 else padding)
            OverlayPosition.BOTTOM_RIGHT -> result.x -= dimension.width + (if (dimension.width == 0) 0 else padding)
            OverlayPosition.TOP_LEFT, OverlayPosition.TOP_CENTER, OverlayPosition.CANVAS_TOP_RIGHT, OverlayPosition.TOP_RIGHT -> result.y += dimension.height + (if (dimension.height == 0) 0 else padding)
            OverlayPosition.ABOVE_CHATBOX_RIGHT -> result.y -= dimension.height + (if (dimension.height == 0) 0 else padding)
            else -> {}
        }
        return result
    }

    private fun clampOverlayLocation(
        overlayX: Int, overlayY: Int, overlayWidth: Int,
        overlayHeight: Int, overlay: Overlay
    ): Point {
        var parentBounds: Rectangle? = overlay.parentBounds
        if (parentBounds == null || parentBounds.isEmpty) {
            // If no bounds are set, use the full client bounds
            val dim = client.realDimensions
            parentBounds = Rectangle(0, 0, dim.width, dim.height)
        }

        // Constrain overlay position to be within the parent bounds
        return Point(
            Ints.constrainToRange(
                overlayX, parentBounds.x,
                parentBounds.x.coerceAtLeast(parentBounds.width - overlayWidth)
            ),
            Ints.constrainToRange(
                overlayY, parentBounds.y,
                parentBounds.y.coerceAtLeast(parentBounds.height - overlayHeight)
            )
        )
    }

    /*    private fun createRightClickMenuEntries(overlay: Overlay): Array<MenuEntry>? {
            val menuEntries: List<OverlayMenuEntry> = overlay.menuEntries
            if (menuEntries.isEmpty()) {
                return null
            }
            val entries = ArrayList<MenuEntry>()

            // Add in reverse order so they display correctly in the right-click menu
            for (i in menuEntries.indices.reversed()) {
                val overlayMenuEntry = menuEntries[i]
                val entry = MenuEntry()
                entry.option = overlayMenuEntry.option
                entry.target = meteor.util.ColorUtil.wrapWithColorTag(overlayMenuEntry.target, JagexColors.MENU_TARGET)
                entry.type = overlayMenuEntry.menuAction!!.id
                entry.identifier = OverlayManager.overlays.indexOf(overlay) // overlay id
                entries.add(entry)
            }
            return entries.toArray(arrayOf(MenuEntry()))
        }*/

    fun renderAfterInterface(
        graphics: Graphics2D, interfaceId: Int,
        widgetItems: Collection<WidgetItem>
    ) {
        val overlays = OverlayManager.getForInterface(interfaceId)
        OverlayManager.widgetItems = widgetItems
        renderOverlays(graphics, overlays, OverlayLayer.ABOVE_WIDGETS)
        OverlayManager.widgetItems = emptyList()
    }

    private fun renderOverlays(
        graphics: Graphics2D, overlays: Collection<Overlay>?,
        layer: OverlayLayer
    ) {
        if ((overlays == null) || overlays.isEmpty()
            || (client.gameState != GameState.LOGGED_IN)
        ) {
            return
        }
        setGraphicProperties(graphics)

        // Draw snap corners
        if (inOverlayDraggingMode && layer == OverlayLayer.UNDER_WIDGETS && currentManagedOverlay != null && currentManagedOverlay!!.position != OverlayPosition.DETACHED) {
            val translatedSnapCorners: OverlayBounds = snapCorners!!.translated(
                -SNAP_CORNER_SIZE.width,
                -SNAP_CORNER_SIZE.height
            )
            val previous = graphics.color
            for (corner in translatedSnapCorners.bounds) {
                corner?.also {
                    graphics.color = if (corner.contains(mousePosition)) SNAP_CORNER_ACTIVE_COLOR else SNAP_CORNER_COLOR
                    graphics.fill(corner)
                }
            }
            graphics.color = previous
        }

        // Get mouse position
        val mouseCanvasPosition: net.runelite.api.Point = client.mouseCanvasPosition
        val mouse = Point(mouseCanvasPosition.x, mouseCanvasPosition.y)

        // Save graphics2d properties so we can restore them later
        val transform = graphics.transform
        val stroke = graphics.stroke
        val composite = graphics.composite
        val paint = graphics.paint
        val renderingHints = graphics.renderingHints
        val background = graphics.background
        for (overlay in overlays) {
            val overlayPosition: OverlayPosition? = getCorrectedOverlayPosition(overlay)
            if (overlayPosition == OverlayPosition.DYNAMIC
                || overlayPosition == OverlayPosition.TOOLTIP
            ) {
                safeRender(overlay, layer, graphics, Point())

                // Restore graphics2d properties
                graphics.transform = transform
                graphics.stroke = stroke
                graphics.composite = composite
                graphics.paint = paint
                graphics.setRenderingHints(renderingHints)
                graphics.background = background
            } else {
                val bounds: Rectangle = overlay.bounds!!
                val dimension = bounds.size
                val preferredLocation: Point? = overlay.getPreferredLocation()
                var location: Point

                // If the final position is not modified, layout it
                if (overlayPosition != OverlayPosition.DETACHED && snapCorners != null) {
                    val snapCorner: Rectangle = snapCorners!!.forPosition(overlayPosition)
                    val translation: Point = transformPosition(
                        overlayPosition,
                        dimension
                    ) // offset from corner
                    // Target x/y to draw the overlay
                    val destX = snapCorner.getX().toInt() + translation.x
                    val destY = snapCorner.getY().toInt() + translation.y
                    // Clamp the target position to ensure it is on screen or within parent bounds
                    location = clampOverlayLocation(destX, destY, dimension.width, dimension.height, overlay)
                    // Diff final position to target position in order to add it to the snap corner padding. The
                    // overlay effectively takes up the difference of (clamped location - target location) in
                    // addition to its normal dimensions.
                    val dX = location.x - destX
                    val dY = location.y - destY
                    val padding: Point = padPosition(
                        overlayPosition!!, dimension,
                        PADDING
                    ) // overlay size + fixed padding
                    // translate corner for padding and any difference due to the position clamping
                    snapCorner.translate(padding.x + dX, padding.y + dY)
                } else {
                    location = preferredLocation!!

                    // Clamp the overlay position to ensure it is on screen or within parent bounds
                    location = clampOverlayLocation(
                        location.x, location.y, dimension.width, dimension.height,
                        overlay
                    )
                }
                if (overlay.getPreferredSize() != null)
                    bounds.size = overlay.getPreferredSize()!!
                safeRender(overlay, layer, graphics, location)

                // Restore graphics2d properties prior to drawing bounds
                graphics.transform = transform
                graphics.stroke = stroke
                graphics.composite = composite
                graphics.paint = paint
                graphics.setRenderingHints(renderingHints)
                graphics.background = background
                if (!bounds.isEmpty) {
                    if (inOverlayManagingMode) {
                        var boundsColor: Color
                        if (inOverlayResizingMode && currentManagedOverlay === overlay) {
                            boundsColor = MOVING_OVERLAY_RESIZING_COLOR
                        } else if (inOverlayDraggingMode && currentManagedOverlay === overlay) {
                            boundsColor = MOVING_OVERLAY_ACTIVE_COLOR
                        } else if (inOverlayDraggingMode && overlay.dragTargetable
                            && currentManagedOverlay!!.dragTargetable
                            && currentManagedOverlay!!.bounds!!.intersects(bounds)
                        ) {
                            boundsColor = MOVING_OVERLAY_TARGET_COLOR
                            assert(currentManagedOverlay != overlay)
                            dragTargetOverlay = overlay
                        } else {
                            boundsColor = MOVING_OVERLAY_COLOR
                        }
                        graphics.color = boundsColor
                        graphics.draw(bounds)
                        graphics.paint = paint
                    }
                    if (!client.isMenuOpen && !client.spellSelected && bounds.contains(mouse)) {
                        if (menuEntries == null) {
                            //menuEntries = createRightClickMenuEntries(overlay)
                        }
                        if (focusedOverlay == null) {
                            focusedOverlay = overlay
                            if (focusedOverlay != prevFocusedOverlay) {
                                prevFocusedOverlay?.onMouseExit()
                                overlay.onMouseEnter()
                            }
                        }
                        overlay.onMouseOver()
                    }
                }
            }
        }
    }

    private fun safeRender(
        overlay: Overlay, layer: OverlayLayer, graphics: Graphics2D, point: Point
    ) {
        if (!isResizeable && (layer == OverlayLayer.ABOVE_SCENE
                    || layer == OverlayLayer.UNDER_WIDGETS)
        ) {
            graphics.setClip(
                client.viewportXOffset,
                client.viewportYOffset,
                client.viewportWidth,
                client.viewportHeight
            )
        } else {
            graphics.setClip(0, 0, client.canvasWidth, client.canvasHeight)
        }
        val position: OverlayPosition = overlay.position

        // FIXME
        // Set font based on configuration
        graphics.font = fontManager.runescapeSmallFont
        graphics.translate(point.x, point.y)
        overlay.bounds?.location = point
        val overlayDimension: Dimension? = try {
            overlay.render(graphics)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return
        }
        val dimension = MoreObjects.firstNonNull(overlayDimension, Dimension())
        overlay.bounds?.size = dimension
    }

    private fun resetOverlayManagementMode() {
        inOverlayResizingMode = false
        inOverlayDraggingMode = false
        currentManagedOverlay = null
        dragTargetOverlay = null
        currentManagedBounds = null
    }

    private fun findMangedOverlay(mousePoint: Point): Overlay? {
        synchronized(overlayManager) {
            for (overlay in OverlayManager.overlays) {
                if (overlay.position == OverlayPosition.DYNAMIC
                    || overlay.position == OverlayPosition.TOOLTIP
                ) {
                    // never allow moving dynamic or tooltip overlays
                    continue
                }
                val bounds: Rectangle = overlay.bounds!!
                if (bounds.contains(mousePoint)) {
                    return overlay
                }
            }
        }
        return null
    }
}