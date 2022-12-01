package meteor.plugins.worldmapwalker

import dev.hoot.api.game.Game
import dev.hoot.api.movement.Movement
import dev.hoot.api.movement.pathfinder.Walker
import dev.hoot.api.utils.CoordUtils.worldMapToWorldPoint
import dev.hoot.api.widgets.Widgets
import eventbus.events.GameTick
import eventbus.events.MenuEntryAdded
import meteor.Logger
import meteor.Main
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.worldmap.WorldMapOverlay
import net.runelite.api.MenuAction
import net.runelite.api.coords.WorldPoint
import net.runelite.api.events.MenuOpened
import net.runelite.api.widgets.WidgetInfo


@PluginDescriptor(
    name = "World Map Walker",
    description = "Right click anywhere within the World Map to walk there",
    enabledByDefault = false
)
class WorldMapWalkerPlugin : Plugin() {
    private val worldMapOverlay = overlay(WorldMapOverlay())
    var config: WorldMapWalkerConfig = configuration()
    var log = Logger("World Map Walker")
    private val overlay = overlay(WorldMapWalkerOverlay(this))

    var mapPoint: WorldPoint? = null
    var lastMapMenuLocation: WorldPoint? = null
    override fun onStop() {
        mapPoint = null

    }

    override fun onGameTick(it: GameTick) {
        this.walk()
    }

    private fun walk() {
        if (Movement.isWalking()) {
            return
        }
        if (mapPoint == null || mapPoint!!.distanceTo(Main.client.localPlayer!!.worldLocation) <= 2) {
            mapPoint = null
            return
        }
        Movement.walkTo(mapPoint)
    }

    override fun onMenuOpened(it: MenuOpened) {
        lastMapMenuLocation = worldMapToWorldPoint(
            Game.getClient().mouseCanvasPosition
        )
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (mapPoint != null) {
            Game.getClient()
                .createMenuEntry(-2)
                .setOption("<col=00ff00>Clear destination")
                .setTarget(it.target)
                .setType(MenuAction.RUNELITE)
                .onClick {
                    mapPoint = null
                    log.debug("Cleared destination")
                }
        }
        val worldMap = Widgets.get(WidgetInfo.WORLD_MAP_VIEW) ?: return
        val mouse = Game.getClient().mouseCanvasPosition
        if (!worldMap.bounds.contains(mouse.x, mouse.y)) {
            return
        }
        Game.getClient()
            .createMenuEntry(-2)
            .setOption("<col=00ff00>Walk to")
            .setTarget(it.target)
            .setType(MenuAction.RUNELITE)
            .onClick {
                setWorldMapPoint(
                    lastMapMenuLocation
                )
            }
    }

    private fun setWorldMapPoint(wp: WorldPoint?) {
        mapPoint = Walker.nearestWalkableTile(wp)
        log.debug("Walking to {}", mapPoint.toString())
    }
}