package meteor

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.*
import dev.hoot.api.InteractionManager
import meteor.api.packets.ClientPackets
import meteor.config.ConfigManager
import meteor.config.MeteorConfig
import meteor.dev.widgetinspector.WidgetInspector
import meteor.game.FontManager
import meteor.game.ItemManager
import meteor.game.WorldService
import meteor.menus.MenuManager
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import meteor.plugins.xptracker.XpTrackerService
import meteor.rs.Applet
import meteor.rs.AppletConfiguration

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
import net.runelite.api.Client
import net.runelite.api.hooks.Callbacks
import net.runelite.client.chat.ChatCommandManager
import net.runelite.client.chat.ChatMessageManager
import meteor.game.npcoverlay.NpcOverlayService
import meteor.session.SessionManager
import net.runelite.http.api.chat.ChatClient
import net.runelite.http.api.xp.XpClient
import okhttp3.OkHttpClient
import org.apache.commons.lang3.time.StopWatch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
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
    val chatClient = ChatClient(httpClient);
    val overlayManager = OverlayManager
    val overlayRenderer = OverlayRenderer()
    val fontManager = FontManager
    val itemManager = ItemManager
    val tooltipManager = TooltipManager
    val executor = ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor())
    val worldService = WorldService

    @JvmStatic
    fun main(args: Array<String>) = application {
        Proxy.handle(args)
        ClientPackets
        MeteorliteTheme.installDark()
        timer.start()
        startKoin { modules(Module.CLIENT_MODULE) }
        callbacks = get()
        AppletConfiguration.init()
        Applet().init()

        Window(
                onCloseRequest = Main::shutdown,
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

        initOverlays()
        initManagers()
        RuntimeConfigLoader.get()
        npcOverlayService = NpcOverlayService()
        PluginManager.loadExternalPlugins()
        xpTrackerService = XpTrackerService(PluginManager.get())
        SessionManager.start()
        timer.stop()
        logger.debug("Meteor started in ${timer.getTime(TimeUnit.MILLISECONDS)}ms")

    }

    fun initOverlays() {
        WidgetOverlay.createOverlays().forEach(Consumer { overlay: WidgetOverlay -> overlayManager.add(overlay) })
        overlayManager.add(TooltipOverlay())
        overlayManager.add(WorldMapOverlay())
    }

    fun initManagers() {
        MenuManager
        interactionManager = InteractionManager()
        chatMessageManager = ChatMessageManager()
        chatCommandManager = ChatCommandManager()
        GameEventManager
    }

    fun shutdown() {
        PluginManager.shutdown()
        exitApplication()
    }

    override fun exitApplication() {
        PluginManager.shutdown()
        ConfigManager.saveProperties()
        exitProcess(0)
    }
}