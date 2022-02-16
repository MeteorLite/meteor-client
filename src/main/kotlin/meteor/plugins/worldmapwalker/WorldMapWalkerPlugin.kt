package meteor.plugins.worldmapwalker


import eventbus.events.ClientTick
import eventbus.events.FocusChanged
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOpened
import eventbus.events.MenuOptionClicked
import meteor.Logger
import meteor.api.entities.Players
import meteor.api.movement.Movement
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.worldmap.WorldMapOverlay
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import net.runelite.api.events.*
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.awt.event.KeyEvent
import java.util.*

@PluginDescriptor(
    name = "World Map Walker",
    description = "Right click anywhere within the World Map to walk there",
    enabledByDefault = false
)

class WorldMapWalkerPlugin : Plugin() {

    private var overlay = overlay(WorldMapOverlay())
    private val overlay2 = overlay(WorldMapWalkerOverlay(this))
    private val logger: Logger = Logger("World Map Walker")

    override var config = configuration<WorldMapWalkerConfig>()


    private var hotKeyPressed = false
    private var lastMenuOpenedPoint: Point? = null
    var mapPoint: WorldPoint? = null
    override fun onStart() {
        KeyManager.registerKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent) {}
            override fun keyPressed(e: KeyEvent) {
                hotKeyPressed = e.isShiftDown
            }

            override fun keyReleased(e: KeyEvent) {
                hotKeyPressed = e.isShiftDown
            }
        }, WorldMapWalkerPlugin::class.java)

    }




    override fun onGameTick(it: GameTick) {
        if (Movement.isWalking) {
            return
        }
        if (mapPoint == null || mapPoint == Players.local.worldLocation) {
            mapPoint = null
            return
        }
        logger.debug("Destination is {} {}", mapPoint!!.x, mapPoint!!.y)
        Movement.walkTo(mapPoint!!)
    }

    override fun onMenuOpened(it: MenuOpened) { //TODO: Event doesn't work
        lastMenuOpenedPoint = client.mouseCanvasPosition
    }

    //Check if menu options have already been added
    private fun menuContainsEntries(): Boolean {
        val entries: Array<MenuEntry>? = client.menuEntries
        if (entries != null) {
            for (entry in entries) {
                if (entry.getTarget() == DESTINATION_MENU_TARGET) {
                    return true
                }
            }
        }
        return false
    }

    private val isUserShiftClicking: Boolean
        private get() = config!!.shiftClickToWalk() && hotKeyPressed


    override fun onClientTick(it: ClientTick) {
        val map: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_VIEW)

        // If user clicks on map
        if (map != null && map.bounds.contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)) {
            if (!menuContainsEntries()) {
                if (isUserShiftClicking) {
                    addMenuEntryFront("Walk to")
                    addMenuEntry("Clear", 0)
                }
            }
        }
        // If user clicks on globe icon on minimap
        for (menuEntry in client.menuEntries) {
            if (menuEntry.getActionParam1() == WidgetInfo.MINIMAP_WORLDMAP_OPTIONS.id) {
                if (!menuContainsEntries()) {
                    addMenuEntry("Clear", 1)
                    return
                }
            }
            if (mapPoint != null && menuEntry.getOption() == "Walk here") {
                if (!menuContainsEntries()) {
                    addMenuEntry("Clear", 1)
                    return
                }
            }
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        val map: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_VIEW)

        // If user clicks on map
        if (map != null && map.bounds.contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)) {
            if (!menuContainsEntries()) {
                if (!isUserShiftClicking) {
                    addMenuEntry("Walk to", 0)
                    addMenuEntry("Clear", 0)
                }
            }
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.menuTarget == DESTINATION_MENU_TARGET) {
            if (it.menuOption == "Walk to") {
                mapPoint = calculateMapPoint(if (client.isMenuOpen) lastMenuOpenedPoint else client.mouseCanvasPosition)
                logger.debug("Walking to: {}", mapPoint.toString())
            }
            if (it.menuOption == "Clear") {
                logger.info("Stopping walking")
                mapPoint = null
            }
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.new == GameState.LOGIN_SCREEN) {
            client.username = ""
            client.setPassword("")
        }
    }

    private fun calculateMapPoint(point: Point?): WorldPoint {
        val zoom = client.renderOverview.worldMapZoom
        val renderOverview: RenderOverview = client.renderOverview
        val mapPoint =
            WorldPoint(renderOverview.worldMapPosition.x, renderOverview.worldMapPosition.y, 0)
        val middle: Point? = overlay.mapWorldPointToGraphicsPoint(mapPoint)
        val dx = ((point!!.x - middle!!.x) / zoom).toInt()
        val dy = (-(point.y - middle.y) / zoom).toInt()
        return mapPoint.dx(dx).dy(dy)
    }

    private fun addMenuEntry(option: String, index: Int) {
        val entries: MutableList<MenuEntry> = mutableListOf(*client.menuEntries)
        val entry = MenuEntry()
        entry.setOption(option)
        entry.setTarget(DESTINATION_MENU_TARGET)
        entry.setOpcode(MenuAction.RUNELITE.id)
        entries.add(index, entry)
        client.menuEntries = entries.toTypedArray()
    }

    private fun addMenuEntryFront(option: String) {
        client.insertMenuItem(option, DESTINATION_MENU_TARGET, MenuAction.UNKNOWN.id, 0, 0, 0, false)
    }


    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused) {
            hotKeyPressed = false
        }
    }

    companion object {
        private const val DESTINATION_MENU_TARGET = "<col=00ff00>Destination"
    }
}