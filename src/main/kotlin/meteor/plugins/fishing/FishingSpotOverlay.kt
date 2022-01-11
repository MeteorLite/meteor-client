package meteor.plugins.fishing

import meteor.ItemManager
import meteor.ui.components.ProgressPieComponent
import meteor.ui.overlay.Overlay
import net.runelite.api.GraphicID
import net.runelite.api.NpcID
import net.runelite.api.Perspective
import net.runelite.api.coords.WorldPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.Instant

class FishingSpotOverlay(val plugin: FishingPlugin, var config: FishingConfig): Overlay() {
    private val ONE_TICK_AERIAL_FISHING = 3
    private val MINNOW_MOVE = Duration.ofSeconds(15)
    private val MINNOW_WARN = Duration.ofSeconds(3)

    override fun render(graphics: Graphics2D): Dimension? {
        var previousSpot: FishingSpot? = null
        var previousLocation: WorldPoint? = null
        for (npc in plugin.fishingSpots) {
            val spot: FishingSpot = FishingSpot.findSpot(npc.id) ?: continue
            if (config.onlyCurrentSpot() && plugin.currentSpot != null && plugin.currentSpot != spot) {
                continue
            }

            // This relies on the sort order to keep identical npcs on the same tile adjacent to each other
            if (previousSpot == spot && previousLocation == npc.worldLocation) {
                continue
            }
            var color: Color?
            color = if (npc.graphic == GraphicID.FLYING_FISH) {
                config.getMinnowsOverlayColor()
            } else if (spot == FishingSpot.COMMON_TENCH
                    && npc.worldLocation.distanceTo2D(client.localPlayer!!.worldLocation)
                    <= ONE_TICK_AERIAL_FISHING) {
                config.getAerialOverlayColor()
            } else if (spot == FishingSpot.HARPOONFISH && npc.id == NpcID.FISHING_SPOT_10569) {
                config.getHarpoonfishOverlayColor()
            } else {
                config.getOverlayColor()
            }
            if (spot == FishingSpot.MINNOW && config.showMinnowOverlay()) {
                val minnowSpot: MinnowSpot? = plugin.minnowSpots[npc.index]
                if (minnowSpot != null) {
                    val millisLeft: Long = MINNOW_MOVE.toMillis() - Duration.between(minnowSpot.time, Instant.now())
                            .toMillis()
                    if (millisLeft < MINNOW_WARN.toMillis()) {
                        color = Color.ORANGE
                    }
                    val localPoint = npc.localLocation
                    val location = Perspective.localToCanvas(client, localPoint, client.plane)
                    if (location != null) {
                        val pie = ProgressPieComponent()
                        pie.fill = color
                        pie.borderColor = color
                        pie.position = location
                        pie.progress = (millisLeft.toFloat() / MINNOW_MOVE.toMillis()).toDouble()
                        pie.render(graphics)
                    }
                }
            }
            if (config.showSpotTiles()) {
                val poly = npc.canvasTilePoly
                if (poly != null) {
                    renderPolygon(graphics, poly, color!!.darker())
                }
            }
            if (config.showSpotIcons()) {
                var fishImage: BufferedImage? = ItemManager.getImage(spot.fishSpriteId)
                if (spot == FishingSpot.COMMON_TENCH
                        && npc.worldLocation.distanceTo2D(client.localPlayer!!.worldLocation)
                        <= ONE_TICK_AERIAL_FISHING) {
                    fishImage = ItemManager.getImage(spot.fishSpriteId)?.let { outlineImage(it, color!!) }
                }
                if (fishImage != null) {
                    val imageLocation = npc.getCanvasImageLocation(fishImage, npc.logicalHeight)
                    if (imageLocation != null) {
                        renderImageLocation(graphics, imageLocation, fishImage)
                    }
                }
            }
            if (config.showSpotNames()) {
                val text: String = spot.spotName
                val textLocation = npc.getCanvasTextLocation(graphics, text, npc.logicalHeight + 40)
                if (textLocation != null) {
                    renderTextLocation(graphics, textLocation, text, color!!.darker())
                }
            }
            previousSpot = spot
            previousLocation = npc.worldLocation
        }
        return null
    }

}