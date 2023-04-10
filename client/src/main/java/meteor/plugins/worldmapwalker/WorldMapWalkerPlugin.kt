package meteor.plugins.worldmapwalker

import dev.hoot.api.game.Game
import dev.hoot.api.movement.Movement
import dev.hoot.api.movement.pathfinder.Walker
import dev.hoot.api.utils.CoordUtils.worldMapToWorldPoint
import dev.hoot.api.widgets.Widgets
import eventbus.events.GameTick
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOptionClicked
import meteor.Logger
import meteor.Main
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.worldmap.WorldMapOverlay
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.coords.WorldPoint
import net.runelite.api.events.MenuOpened
import net.runelite.api.widgets.WidgetInfo


@PluginDescriptor(
    name = "World Map Walker",
    description = "Right click anywhere within the World Map to walk there",
    enabledByDefault = false
)
class WorldMapWalkerPlugin : Plugin(daemon = true) {
    private val worldMapOverlay = overlay(WorldMapOverlay())
    var config: WorldMapWalkerConfig = configuration()
    var log = Logger("World Map Walker")
    private val overlay = overlay(WorldMapWalkerOverlay(this))
    private var lastTarget : String? = null

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
        ClientThread.invoke {
            val menus = client.menuEntries
            val newList = arrayListOf(*menus)
            var nextMenu : MenuEntry? = null
            if (mapPoint != null) {
                nextMenu = client
                    .createMenuEntry(-2)
                    .setOption("<col=00ff00>Clear destination")
                    .setTarget(lastTarget)
                    .setType(MenuAction.RUNELITE)
                newList.add(nextMenu)
            }
            val worldMap = Widgets.get(WidgetInfo.WORLD_MAP_VIEW) ?: return@invoke
            val mouse = Game.getClient().mouseCanvasPosition
            if (!worldMap.bounds.contains(mouse.x, mouse.y)) {
                return@invoke
            }
            nextMenu = client
                .createMenuEntry(-2)
                .setOption("<col=00ff00>Walk to")
                .setTarget(lastTarget)
                .setType(MenuAction.RUNELITE)
            newList.add(nextMenu)
            client.menuEntries = newList.toTypedArray().reversedArray()
            lastMapMenuLocation = worldMapToWorldPoint(
                Game.getClient().mouseCanvasPosition
            )
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        ClientThread.invoke {
            if (it.menuEntry.option == "<col=00ff00>Clear destination")
                mapPoint = null
            else if (it.menuEntry.option == "<col=00ff00>Walk to")
                setWorldMapPoint(
                    lastMapMenuLocation
                )
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        ClientThread.invoke {
            val lastEntry = client.menuEntries.last()
            lastTarget = lastEntry?.target
        }
    }

    private fun setWorldMapPoint(wp: WorldPoint?) {
        mapPoint = Walker.nearestWalkableTile(wp)
        log.debug("Walking to {}", mapPoint.toString())
    }
}