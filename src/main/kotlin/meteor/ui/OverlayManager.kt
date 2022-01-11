package meteor.ui

import com.google.common.base.MoreObjects
import com.google.common.collect.ArrayListMultimap
import meteor.ui.overlay.*
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetItem
import java.awt.Dimension
import java.awt.Point
import java.util.*
import java.util.function.Predicate

object OverlayManager {
    private const val OVERLAY_CONFIG_PREFERRED_LOCATION = "_preferredLocation"
    private const val OVERLAY_CONFIG_PREFERRED_POSITION = "_preferredPosition"
    private const val OVERLAY_CONFIG_PREFERRED_SIZE = "_preferredSize"
    val OVERLAY_COMPARATOR: Comparator<Overlay> = Comparator label@ { a: Overlay, b: Overlay ->
        val aPos: OverlayPosition = MoreObjects
                .firstNonNull(a.preferredPosition, a.position)
        val bPos: OverlayPosition = MoreObjects
                .firstNonNull(b.preferredPosition, b.position)
        if (aPos != bPos) {
            // This is so non-dynamic overlays render after dynamic
            // overlays, which are generally in the scene
            return@label aPos.compareTo(bPos)
        }
        if (aPos == OverlayPosition.DYNAMIC)
            return@label a.priority.compareTo(b.priority)
        else
            return@label b.priority.compareTo(a.priority)
    }

    val overlays: ArrayList<Overlay> = ArrayList()
    var widgetItems: Collection<WidgetItem> = emptyList()
    private var overlayMap = ArrayListMultimap.create<Any, Overlay>()

    fun getLayer(layer: OverlayLayer): Collection<Overlay> {
        return Collections.unmodifiableCollection(overlayMap[layer])
    }

    fun getForInterface(interfaceId: Int): Collection<Overlay> {
        return Collections.unmodifiableCollection(overlayMap[interfaceId shl 16 or 0xffff])
    }

    fun getForLayer(layerId: Int): Collection<Overlay> {
        return Collections.unmodifiableCollection(overlayMap[layerId])
    }

    @Synchronized
    fun add(overlay: Overlay): Boolean {
        if (overlays.contains(overlay)) {
            return false
        }

        // Add is always true
        overlays.add(overlay)
        loadOverlay(overlay)
        updateOverlayConfig(overlay)
        rebuildOverlayLayers()
        return true
    }

    private fun loadOverlay(overlay: Overlay) {
        val location: Point? = loadOverlayLocation(overlay)
        overlay.preferredLocation = location
        val size: Dimension? = loadOverlaySize(overlay)
        overlay.preferredSize = size
        val position: OverlayPosition = loadOverlayPosition(overlay)
        overlay.preferredPosition = position
    }

    private fun updateOverlayConfig(overlay: Overlay) {
        if (overlay is OverlayPanel) {
            // Update preferred color for overlay panels based on configuration
            overlay.preferredColor = overlay.preferredColor
        }
    }

    private fun saveOverlayLocation(overlay: Overlay) {
        val key: String = overlay.name + OVERLAY_CONFIG_PREFERRED_LOCATION
    }

    private fun saveOverlaySize(overlay: Overlay) {
        val key: String = overlay.name + OVERLAY_CONFIG_PREFERRED_SIZE
    }

    private fun saveOverlayPosition(overlay: Overlay) {
        val key: String = overlay.name + OVERLAY_CONFIG_PREFERRED_POSITION
    }

    private fun loadOverlayLocation(overlay: Overlay): Point? {
        val key: String = overlay.name + OVERLAY_CONFIG_PREFERRED_LOCATION
        return overlay.preferredLocation
    }

    private fun loadOverlaySize(overlay: Overlay): Dimension? {
        val key: String = overlay.name + OVERLAY_CONFIG_PREFERRED_SIZE
        return overlay.preferredSize
    }

    private fun loadOverlayPosition(overlay: Overlay): OverlayPosition {
        val locationKey: String = overlay.name + OVERLAY_CONFIG_PREFERRED_POSITION
        return overlay.preferredPosition!!
    }

    @Synchronized
    fun add(vararg overlays: Overlay) {
        for (overlay in overlays) add(overlay)
    }

    @Synchronized
    fun remove(overlay: Overlay?): Boolean {
        val remove: Boolean = overlays.remove(overlay)
        if (remove) {
            rebuildOverlayLayers()
        }
        return remove
    }

    @Synchronized
    fun remove(vararg overlays: Overlay?) {
        for (overlay in overlays) remove(overlay)
    }

    @Synchronized
    fun removeIf(filter: Predicate<Overlay?>?): Boolean {
        val removeIf = overlays.removeIf(filter!!)
        if (removeIf) {
            rebuildOverlayLayers()
        }
        return removeIf
    }

    /**
     * Returns whether an overlay exists which matches the given predicate.
     *
     * @param filter Filter predicate function
     * @return `true` if any overlays match the given filter, `false` otherwise
     */
    @Synchronized
    fun anyMatch(filter: Predicate<Overlay?>?): Boolean {
        return overlays.stream().anyMatch(filter)
    }


    @Synchronized
    fun clear() {
        overlays.clear()
        rebuildOverlayLayers()
    }

    @Synchronized
    fun rebuildOverlayLayers() {
        val overlayMap = ArrayListMultimap.create<Any, Overlay>()
        for (overlay in overlays) {
            var layer: OverlayLayer = overlay.layer
            if (overlay.preferredLocation != null && overlay.preferredPosition == null) {
                // When UNDER_WIDGET overlays are in preferred locations, move to
                // ABOVE_WIDGETS so that it can draw over interfaces
                if (layer == OverlayLayer.UNDER_WIDGETS && overlay !is WidgetOverlay) {
                    layer = OverlayLayer.ABOVE_WIDGETS
                }
            }
            when (layer) {
                OverlayLayer.ABOVE_SCENE, OverlayLayer.UNDER_WIDGETS, OverlayLayer.ALWAYS_ON_TOP -> overlayMap.put(layer, overlay)
                OverlayLayer.ABOVE_WIDGETS -> {
                    // draw after each of the top level interfaces
                    overlayMap.put(WidgetID.FIXED_VIEWPORT_GROUP_ID shl 16 or 0xffff, overlay)
                    overlayMap
                            .put(WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID shl 16 or 0xffff, overlay)
                    overlayMap.put(WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID shl 16 or 0xffff, overlay)
                }
            }
            for (drawHook in overlay.drawHooks) {
                overlayMap.put(drawHook, overlay)
            }
        }
        for (key in overlayMap.keys()) {
            overlayMap[key].sortWith(OVERLAY_COMPARATOR)
        }
        this.overlayMap = overlayMap
    }

    @Synchronized
    fun resetOverlay(overlay: Overlay) {
        overlay.preferredSize = (null)
    }
}