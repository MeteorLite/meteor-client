package meteor

import androidx.compose.ui.res.painterResource
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
import meteor.rs.Applet
import meteor.rs.AppletConfiguration
import meteor.ui.overlay.OverlayManager
import meteor.ui.overlay.OverlayRenderer
import meteor.ui.UI
import meteor.ui.overlay.TooltipManager
import meteor.ui.overlay.WidgetOverlay
import meteor.ui.overlay.tooltips.TooltipOverlay
import meteor.ui.themes.MeteorliteTheme
import meteor.ui.worldmap.WorldMapOverlay
import meteor.util.ExecutorServiceExceptionLogger
import net.runelite.api.Client
import net.runelite.api.hooks.Callbacks
import net.runelite.client.chat.ChatMessageManager
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

object Main: ApplicationScope, KoinComponent, EventSubscriber() {
    lateinit var client: Client
    lateinit var callbacks: Callbacks
    val httpClient = OkHttpClient()
    val xpClient = XpClient(httpClient)
    val overlayManager = OverlayManager
    val overlayRenderer = OverlayRenderer()
    val fontManager = FontManager
    val itemManager = ItemManager
    val tooltipManager = TooltipManager
    val executor = ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor())
    val worldService = WorldService
    var meteorConfig: MeteorConfig? = null
    var logger = Logger("meteor.Main")
    val eventBus = EventBus
    var placement: WindowPlacement = WindowPlacement.Maximized
    var interactionManager: InteractionManager? = null
    var chatMessageManager: ChatMessageManager? = null

    private val timer = StopWatch()

    @JvmStatic
    fun main(args: Array<String>) = application {
        ClientPackets
        timer.start()
        processArguments(args)
        startKoin { modules(Module.CLIENT_MODULE) }
        callbacks = get()
        MeteorliteTheme.install()
        AppletConfiguration.init()
        Applet().init()
        Window(
            onCloseRequest = this::exitApplication,
            title = "Meteor",
            icon = painterResource("Meteor_icon.png"),
            state = rememberWindowState(placement = WindowPlacement.Maximized),
            content = UI.Window() //::finishStartup is called at the end of this function
        )
    }
    fun finishStartup() {
        client = Applet.asClient(Applet.applet)
        client.callbacks = callbacks
        ConfigManager.loadSavedProperties()
        val meteorConfig = ConfigManager.getConfig(MeteorConfig::class.java) as MeteorConfig
        ConfigManager.setDefaultConfiguration(meteorConfig, false)
        Main.meteorConfig = meteorConfig
        WidgetInspector
        MenuManager
        interactionManager = InteractionManager()
        interactionManager!!.subscribe()
        initOverlays()
        PluginManager.loadExternalPlugins()
        chatMessageManager = ChatMessageManager()
        timer.stop()
        logger.info("Meteor started in ${timer.getTime(TimeUnit.MILLISECONDS)}ms")
    }

    fun initOverlays() {
        WidgetOverlay.createOverlays().forEach(Consumer { overlay: WidgetOverlay -> overlayManager.add(overlay) })
        overlayManager.add(TooltipOverlay())
        overlayManager.add(WorldMapOverlay())
    }

    fun processArguments(args: Array<String>) {
        for(arg in args) {
            when (arg.lowercase()) {
                "disableGPU".lowercase() -> {
                    Configuration.allowGPU = false
                }
            }
        }
    }

    /**
     * Save and exit
     */
    override fun exitApplication() {
        PluginManager.shutdown()
        ConfigManager.saveProperties()
        exitProcess(0)
    }
}