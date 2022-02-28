package meteor.api.commons

import meteor.Logger

import Main.client

import meteor.api.game.GameThread
import meteor.api.input.Mouse
import meteor.api.widgets.Dialog
import meteor.api.widgets.Dialog.chooseOption
import meteor.api.widgets.Dialog.isViewingOptions
import meteor.api.widgets.Tab
import meteor.api.widgets.Tabs
import meteor.api.widgets.Widgets
import meteor.game.WorldService
import meteor.util.WorldUtil
import net.runelite.api.GameState
import net.runelite.api.World
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.http.api.worlds.WorldResult

import java.awt.Point
import java.lang.Exception
import java.util.*
import java.util.function.Consumer
import java.util.function.Predicate

object Worlds {
    private val LOBBY_WORLD_SELECTOR = Point(20, 475)
    private val CLOSE_LOBBY_SELECTOR = Point(715, 10)
    private val logger: Logger = Logger("Worlds")

    private val worldService: WorldService? = null
    private fun lookup(): List<World> {
        val out: MutableList<World> = ArrayList()
        val lookup: WorldResult = worldService?.getWorlds() ?: return emptyList()
        lookup.worlds.forEach(Consumer { w: net.runelite.http.api.worlds.World ->
            val world = client.createWorld()
            world.activity = w.activity
            world.address = w.address
            world.id = w.id
            world.playerCount = w.players
            world.location = w.location
            world.types = WorldUtil.toWorldTypes(w.types)
            out.add(world)
        })
        return out
    }

    fun getAll(filter: Predicate<World>): List<World?> {
        val out: MutableList<World?> = ArrayList()
        val loadedWorlds: List<World>
        loadedWorlds = try {
            val worlds: Array<World>? = client.worldList
            if (worlds == null) {
                loadWorlds()
                return out
            }
            Arrays.asList(*worlds)
        } catch (e: Exception) {
            logger.warn("Game couldn't load worlds, falling back to RuneLite API.")
            lookup()
        }
        for (world in loadedWorlds) {
            if (filter.test(world)) {
                out.add(world)
            }
        }
        return out
    }

    fun getFirst(filter: Predicate<World>): World? {
        return getAll(filter)
            .stream()
            .findFirst()
            .orElse(null)
    }

    fun getFirst(id: Int): World? {
        return getFirst { x: World -> x.id == id }
    }

    fun getRandom(filter: Predicate<World>): World? {
        val all = getAll(filter)
        return all[Rand.nextInt(0, all.size)]
    }

    val currentId: Int
        get() = client.world

    @JvmOverloads
    fun hopTo(world: World?, spam: Boolean = false) {
        if (!isHopperOpen) {
            openHopper()
            Time.sleepUntil({ isHopperOpen }, 3000)
        }
        val rememberOption: Widget = Dialog.options.stream()
            .filter { x -> x.text.contains("Yes. In future, only warn about") }
            .findFirst()
            .orElse(null)
        if (!GameThread.invokeLater { rememberOption.isHidden }!!) {
            chooseOption(2)
            Time.sleepUntil({ client.gameState ===GameState.HOPPING }, 3000)
            return
        }
        client.hopToWorld(world)
        if (!spam) {
            Time.sleepUntil({ client.gameState === GameState.HOPPING }, 3000)
        }
        if (isViewingOptions) {
            chooseOption(2)
            Time.sleepUntil({ client.gameState === GameState.HOPPING }, 3000)
        }
    }

    val currentWorld: World?
        get() = getFirst(client.world)

    fun inMembersWorld(): Boolean {
        return true
    }

    fun loadWorlds() {
        if (client.gameState === GameState.LOGIN_SCREEN) {
            client.loadWorlds()
            Time.sleep(200)
            closeLobbyWorlds()
            return
        }
        if (client.gameState === GameState.LOGGED_IN) {
            openHopper()
        }
    }

    fun openHopper() {
        if (!Tabs.isOpen(Tab.LOG_OUT)) {
            Tabs.open(Tab.LOG_OUT)
        }
        client.openWorldHopper()
    }

    fun openLobbyWorlds() {
        Mouse.click(LOBBY_WORLD_SELECTOR, true)
    }

    fun closeLobbyWorlds() {
        Mouse.click(CLOSE_LOBBY_SELECTOR, true)
    }

    val isHopperOpen: Boolean
        get() {
            val hopper: Widget? = Widgets.get(WidgetInfo.WORLD_SWITCHER_LIST)
            return hopper != null && !GameThread.invokeLater { hopper.isHidden }!!
        }
}