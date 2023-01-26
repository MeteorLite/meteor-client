package meteor

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.GameThread
import eventbus.Events
import eventbus.events.ClickPacket
import eventbus.events.MenuOptionClicked
import meteor.Configuration.EXTERNALS_DIR
import meteor.api.loot.Interact
import meteor.api.ClientPackets
import meteor.config.ConfigManager
import meteor.dev.widgetinspector.WidgetInspector
import meteor.game.*
import meteor.game.chatbox.ChatboxPanelManager
import meteor.game.npcoverlay.NpcOverlayService
import meteor.hiscore.HiscoreManager
import meteor.menus.MenuManager
import meteor.menus.WidgetMenuOption
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import meteor.plugins.meteor.MeteorConfig
import meteor.plugins.xptracker.XpTrackerService
import meteor.rs.Applet
import meteor.rs.AppletConfiguration
import meteor.session.SessionManager
import meteor.ui.composables.ui.windowContent
import meteor.ui.overlay.OverlayManager
import meteor.ui.overlay.OverlayRenderer
import meteor.ui.overlay.TooltipManager
import meteor.ui.overlay.WidgetOverlay
import meteor.ui.overlay.tooltips.TooltipOverlay
import meteor.ui.themes.MeteorliteTheme
import meteor.ui.worldmap.WorldMapOverlay
import meteor.util.ExecutorServiceExceptionLogger
import meteor.util.GameEventManager
import meteor.util.Proxy
import meteor.util.RuntimeConfigLoader
import net.runelite.api.*
import net.runelite.api.hooks.Callbacks
import meteor.chat.ChatCommandManager
import meteor.chat.ChatMessageManager
import net.runelite.http.api.chat.ChatClient
import net.runelite.http.api.xp.XpClient
import okhttp3.OkHttpClient
import org.apache.commons.lang3.time.StopWatch
import org.jetbrains.skiko.OS
import org.rationalityfrontline.kevent.KEVENT
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import kotlin.system.exitProcess
import org.rationalityfrontline.kevent.KEVENT as EventBus


object Main : ApplicationScope, EventSubscriber() {
    var onClicks = HashMap<MenuEntry, Consumer<MenuEntry>>()
    var onClicksWidget = HashMap<WidgetMenuOption, Consumer<MenuEntry>>()
    var pluginsEnabled = true
    var meteorConfig: MeteorConfig
    init {
        ConfigManager.loadSavedProperties()
        ConfigManager.setDefaultConfiguration(MeteorConfig::class, false)
        ConfigManager.saveProperties()
        meteorConfig = ConfigManager.getConfig(MeteorConfig::class.java)!!
    }


    var window: FrameWindowScope? = null
    val eventBus = EventBus
    var logger = Logger("Main")
    private val timer = StopWatch()

    lateinit var client: Client
    lateinit var callbacks: Callbacks
    lateinit var npcOverlayService: NpcOverlayService
    lateinit var xpTrackerService: XpTrackerService
    lateinit var chatMessageManager: ChatMessageManager
    lateinit var chatCommandManager: ChatCommandManager
    lateinit var xpDropManager: XpDropManager
    val httpClient = OkHttpClient()
    val xpClient = XpClient(httpClient)
    val chatClient = ChatClient(httpClient)
    val overlayManager = OverlayManager
    val overlayRenderer = OverlayRenderer()
    val fontManager = FontManager
    val itemManager = ItemManager
    val tooltipManager = TooltipManager
    val executor = ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor())
    val worldService = WorldService
    val hiscoreManager = HiscoreManager
    val macOS = if ( System.getProperty("os.name").lowercase().contains("mac")) OS.MacOS else null
    val winOS = if ( System.getProperty("os.name").lowercase().contains("win")) OS.Windows else null

    @JvmStatic
    fun main(args: Array<String>) = application {
        EXTERNALS_DIR.mkdirs()
        Proxy.handle(args)
        ClientPackets
        if (winOS != null || macOS != null) {
            MeteorliteTheme.installDark()
        }
        timer.start()
        callbacks = Hooks()
        AppletConfiguration.init()
        Applet().init()
        initWindow()
        // finishStartup is ran here after windowContent()
    }

    @Composable
    fun initWindow() {
        var windowState: WindowState? = rememberWindowState()

        if (meteorConfig.lockWindowSize()) {
            val sizeString = meteorConfig.lockedWindowSize()

            val windowSize = DpSize(
                sizeString.split(":")[0].toInt().dp,
                sizeString.split(":")[1].toInt().dp)

            windowState = rememberWindowState(size = windowSize)
        }

        Window(
            onCloseRequest = Main::exitApplication,
            title = "Meteor",
            icon = painterResource("Meteor_icon.svg"),
            undecorated = meteorConfig.fullscreen(),
            alwaysOnTop = meteorConfig.alwaysOnTop(),
            resizable = !meteorConfig.lockWindowSize(),
            state = windowState!!,
            content = {
                windowContent()
            }
        )
    }


    fun finishStartup() {
        client = Applet.asClient(Applet.applet)
        client.callbacks = callbacks
        WidgetInspector
        initApi()
        initOverlays()
        initManagers()
        RuntimeConfigLoader.get()
        npcOverlayService = NpcOverlayService()
        if (pluginsEnabled) {
            PluginManager.loadExternalPlugins()
            xpTrackerService = XpTrackerService(PluginManager.get())
        }

        xpDropManager = XpDropManager()
        SessionManager.start()
        timer.stop()


/*       val outStream = PrintStream(object : ByteArrayOutputStream() {
            override fun flush() {
                val decodedString = String(buf, 0, count, Charset.defaultCharset())
                val strippedString = decodedString.replace(Regex("\u001B\\[[;\\d]*m"), "")
                outPut.value = strippedString
            }

        }, true)
        val teeStream = TeeOutputStream(System.out, outStream)
        System.setOut(PrintStream(teeStream, true))*/
        logger.debug("Meteor started in ${timer.getTime(TimeUnit.MILLISECONDS)}ms")
    }

    fun initApi() {
        TileItem.client = client
        Item.client = client
        NPC.client = client
        Player.client = client
        KEVENT.subscribe<Interact>(Events.INTERACT) {
            GameThread.invoke { ClientPackets.createClientPacket(it.data.menu)!!.send() }
        }
        KEVENT.subscribe<ClickPacket>(Events.CLICK_PACKET) {
            GameThread.invoke { ClientPackets.queueClickPacket(it.data.clickPoint) }
        }
        KEVENT.subscribe<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) {
            //These are api onClicks (before client code is usable)
            for (menuEntry in AutomatedMenu.onClicks.keys) {
                if (it.data.menuEntry == menuEntry) {
                    AutomatedMenu.onClicks[menuEntry]?.accept(menuEntry)
                }
            }
            // These are regular menu onClick()
            for (menuEntry in onClicks.keys) {
                if (it.data.menuEntry == menuEntry) {
                    onClicks[menuEntry]?.accept(menuEntry)
                }
            }
            //These are from MenuManager's managed menus
            //For whatever reason, this fails a concurrency modification check, so we clone it.
            val copy: HashMap<WidgetMenuOption, Consumer<MenuEntry>> = onClicksWidget.clone() as HashMap<WidgetMenuOption, Consumer<MenuEntry>>
            for (menuEntry in copy.keys) {
                if (it.data.menuEntry.option == menuEntry.menuOption) {
                    onClicksWidget[menuEntry]?.accept(it.data.menuEntry)
                }
            }
        }
    }

    fun initOverlays() {
        WidgetOverlay.createOverlays().forEach{ overlay: WidgetOverlay -> overlayManager.add(overlay) }
        overlayManager.add(TooltipOverlay())
        overlayManager.add(WorldMapOverlay())
    }

    fun initManagers() {
        MenuManager
        LootManager
        chatMessageManager = ChatMessageManager()
        chatCommandManager = ChatCommandManager()
        GameEventManager
    }

    override fun exitApplication() {
        try {
            PluginManager.shutdown()
        } catch (_: Exception) {}
        ConfigManager.saveProperties()
        exitProcess(0)
    }
}