import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import eventbus.Events
import meteor.*
import meteor.config.ConfigManager
import eventbus.events.GameTick
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import meteor.rs.Applet
import meteor.rs.AppletConfiguration
import meteor.ui.OverlayManager
import meteor.ui.OverlayRenderer
import meteor.ui.UI
import meteor.ui.themes.MeteorliteTheme
import meteor.util.ExecutorServiceExceptionLogger
import net.runelite.api.Client
import net.runelite.api.hooks.Callbacks
import net.runelite.http.api.xp.XpClient
import okhttp3.OkHttpClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.rationalityfrontline.kevent.KEVENT as EventBus
import java.util.concurrent.Executors

object Main: KoinComponent, EventSubscriber() {
    lateinit var client: Client
    lateinit var callbacks: Callbacks
    val httpClient = OkHttpClient()
    val xpClient = XpClient(httpClient)
    val overlayManager = OverlayManager
    val overlayRenderer = OverlayRenderer()
    val fontManager = FontManager
    val itemManager = ItemManager
    val executor = ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor())

    @JvmStatic
    fun main(args: Array<String>) = application {
        processArguments(args)
        startKoin { modules(Module.CLIENT_MODULE) }
        callbacks = get()
        MeteorliteTheme.install()
        suppressEventWarnings()
        EventBus.subscribe<GameTick>(Events.GAME_TICK) {
            if (client.gameDrawingMode != 2)
                client.gameDrawingMode = 2
        }
        AppletConfiguration.init()
        Applet().init()
        Window(
            onCloseRequest = {shutdown(this)},
            title = "Meteor",
            icon = painterResource("Meteor_icon.png"),
            state = rememberWindowState(width = 1280.dp, height = 720.dp),
            content = UI.Window()
        )
    }

    private fun suppressEventWarnings() {
        // These temporarily prevent flooding warning logs until they are used
        EventBus.subscribe<Unit>(Events.SCRIPT_PRE_FIRED) {}
        EventBus.subscribe<Unit>(Events.SCRIPT_POST_FIRED) {}
        EventBus.subscribe<Unit>(Events.ANIMATION_CHANGED) {}
        EventBus.subscribe<Unit>(Events.AREA_SOUND_EFFECT_PLAYED) {}
        EventBus.subscribe<Unit>(Events.PACKET_SENT) {}
        EventBus.subscribe<Unit>(Events.BEFORE_MENU_RENDER) {}
        EventBus.subscribe<Unit>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) {}
        EventBus.subscribe<Unit>(Events.NPC_ACTION_CHANGED) {}
        EventBus.subscribe<Unit>(Events.VARBIT_CHANGED) {}
        EventBus.subscribe<Unit>(Events.CONFIG_CHANGED) {}
        EventBus.subscribe<Unit>(Events.CANVAS_SIZE_CHANGED) {}
        EventBus.subscribe<Unit>(Events.APPLET_LOADED) {}
        EventBus.subscribe<Unit>(Events.PLAYER_MENU_OPTIONS_CHANGED) {}
        EventBus.subscribe<Unit>(Events.CLAN_CHANNEL_CHANGED) {}
        EventBus.subscribe<Unit>(Events.GRAND_EXCHANGE_OFFER_CHANGED) {}
        EventBus.subscribe<Unit>(Events.PLAYER_SKULL_CHANGED) {}
        EventBus.subscribe<Unit>(Events.OVERHEAD_PRAYER_CHANGED) {}
        EventBus.subscribe<Unit>(Events.PLANE_CHANGED) {}
        EventBus.subscribe<Unit>(Events.CHAT_MESSAGE) {}
        EventBus.subscribe<Unit>(Events.LOGIN_STATE_CHANGED) {}
        EventBus.subscribe<Unit>(Events.GRAPHICS_OBJECT_CREATED) {}
        EventBus.subscribe<Unit>(Events.PLAYER_DESPAWNED) {}
        EventBus.subscribe<Unit>(Events.SOUND_EFFECT_PLAYED) {}
        EventBus.subscribe<Unit>(Events.EXPERIENCE_GAINED) {}
        EventBus.subscribe<Unit>(Events.MENU_OPENED) {}
    }

    fun shutdown(a: ApplicationScope) {
        PluginManager.shutdown()
        a.exitApplication()
    }

    fun finishStartup() {
        client = Applet.asClient(Applet.applet)
        client.callbacks = callbacks
        ConfigManager.loadSavedProperties()
        PluginManager
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
}