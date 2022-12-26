package meteor

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.*
import dev.hoot.api.InteractionManager
import dev.hoot.api.game.GameThread
import eventbus.Events
import meteor.api.loot.Interact
import meteor.api.packets.ClientPackets
import meteor.config.ConfigManager
import meteor.config.MeteorConfig
import meteor.dev.widgetinspector.WidgetInspector
import meteor.game.FontManager
import meteor.game.ItemManager
import meteor.game.LootManager
import meteor.game.WorldService
import meteor.game.chatbox.ChatboxPanelManager
import meteor.game.npcoverlay.NpcOverlayService
import meteor.hiscore.HiscoreManager
import meteor.menus.MenuManager
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import meteor.plugins.xptracker.XpTrackerService
import meteor.rs.Applet
import meteor.rs.AppletConfiguration
import meteor.session.SessionManager
import meteor.ui.composables.preferences.outPut
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
import net.runelite.client.chat.ChatCommandManager
import net.runelite.client.chat.ChatMessageManager
import net.runelite.http.api.chat.ChatClient
import net.runelite.http.api.xp.XpClient
import okhttp3.OkHttpClient
import org.apache.commons.lang3.time.StopWatch
import org.jetbrains.skiko.OS
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.rationalityfrontline.kevent.KEVENT
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.Charset
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess
import org.rationalityfrontline.kevent.KEVENT as EventBus


object Main : ApplicationScope, KoinComponent, EventSubscriber() {
    init {
        ConfigManager.loadSavedProperties()
        ConfigManager.setDefaultConfiguration(MeteorConfig::class, false)
        ConfigManager.saveProperties()
    }
    var meteorConfig: MeteorConfig = ConfigManager.getConfig(MeteorConfig::class.java)!!

    var window: FrameWindowScope? = null
    val eventBus = EventBus
    var logger = Logger("Main")
    private val timer = StopWatch()

    lateinit var client: Client
    lateinit var callbacks: Callbacks
    lateinit var npcOverlayService: NpcOverlayService
    lateinit var xpTrackerService: XpTrackerService
    lateinit var interactionManager: InteractionManager
    lateinit var chatMessageManager: ChatMessageManager
    lateinit var chatCommandManager: ChatCommandManager
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
        Proxy.handle(args)
        ClientPackets
        if (winOS != null || macOS != null) {
            MeteorliteTheme.installDark()
        }
        timer.start()
        startKoin { modules(Module.CLIENT_MODULE) }
        callbacks = get()
        AppletConfiguration.init()
        Applet().init()

        Window(
            onCloseRequest = Main::exitApplication,
            title = "Meteor",
            icon = painterResource("Meteor_icon.png"),
            undecorated = meteorConfig.fullscreen(),
            state = rememberWindowState(placement = WindowPlacement.Maximized, size = DpSize.Unspecified),
            content = {
                windowContent()
                // finishStartup is ran here
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
        PluginManager.loadExternalPlugins()
        xpTrackerService = XpTrackerService(PluginManager.get())
        SessionManager.start()
        timer.stop()
        System.setOut(PrintStream(object : ByteArrayOutputStream() {
            override fun flush() {
                val decodedString = String(buf, 0, count, Charset.defaultCharset())
                val strippedString = decodedString.replace(Regex("\u001B\\[[;\\d]*m"), "")
                outPut.value = strippedString
            }

        }, true))
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
    }

    fun initOverlays() {
        WidgetOverlay.createOverlays().forEach{ overlay: WidgetOverlay -> overlayManager.add(overlay) }
        overlayManager.add(TooltipOverlay())
        overlayManager.add(WorldMapOverlay())
    }

    fun initManagers() {
        MenuManager
        LootManager
        ChatboxPanelManager
        interactionManager = InteractionManager()
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