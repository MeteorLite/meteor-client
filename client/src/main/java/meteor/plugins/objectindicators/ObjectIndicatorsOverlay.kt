package meteor.plugins.objectindicators

import com.google.common.base.Strings
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.*

import meteor.outline.ModelOutlineRenderer
import java.awt.*

internal class ObjectIndicatorsOverlay(private val plugin: ObjectIndicatorsPlugin) : Overlay() {
    private val modelOutlineRenderer = ModelOutlineRenderer()
    var config = plugin.configuration<ObjectIndicatorsConfig>()

    init {

        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.LOW
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val stroke: Stroke = BasicStroke(config.borderWidth().toFloat())
        for (colorTileObject in plugin.objects) {
            val obj: TileObject? = colorTileObject.tileObject
            var color = colorTileObject.color
            if (obj?.plane != client.plane) {
                continue
            }
            var composition: ObjectComposition? = colorTileObject.composition
            if (composition!!.impostorIds != null) {
                // This is a multiloc
                composition = composition.impostor
                // Only mark the object if the name still matches
                if (composition == null || Strings.isNullOrEmpty(composition.name) || "null" == composition.name || composition.name != colorTileObject.name) {
                    continue
                }
            }
            if (color == null || !config.rememberObjectColors()) {
                // Fallback to the current config if the object is marked before the addition of multiple colors
                color = config.markerColor()
            }
            if (config.highlightHull()) {
                renderConvexHull(graphics, obj, color, stroke)
            }
            if (config.highlightOutline()) {
                modelOutlineRenderer.drawOutline(obj, config.borderWidth().toInt(), color, config.outlineFeather())
            }
        }
        return null
    }

    private fun renderConvexHull(graphics: Graphics2D, obj: TileObject, color: Color?, stroke: Stroke) {
        val polygon: Shape?
        var polygon2: Shape? = null
        when (obj) {
            is GameObject -> {
                polygon = obj.convexHull
            }
            is WallObject -> {
                polygon = obj.convexHull
                polygon2 = obj.convexHull2
            }
            is DecorativeObject -> {
                polygon = obj.convexHull
                polygon2 = obj.convexHull2
            }
            is GroundObject -> {
                polygon = obj.convexHull
            }
            else -> {
                polygon = obj.canvasTilePoly
            }
        }
        if (polygon != null) {
            OverlayUtil.renderPolygon(graphics, polygon, color!!, stroke)
        }
        if (polygon2 != null) {
            OverlayUtil.renderPolygon(graphics, polygon2, color!!, stroke)
        }
    }
}