package meteor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toAwtImage
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import eventbus.events.ConfigChanged
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import meteor.Configuration.EXTERNALS_DIR
import meteor.config.ConfigManager
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import meteor.plugins.meteor.MeteorConfig
import meteor.rs.Applet
import meteor.rs.AppletConfiguration
import meteor.ui.composables.ui.windowContent
import meteor.ui.overlay.OverlayManager
import meteor.ui.overlay.TooltipManager
import meteor.ui.themes.MeteorliteTheme
import meteor.util.ExecutorServiceExceptionLogger
import meteor.util.Proxy
import meteor.util.RuntimeConfigLoader
import net.runelite.api.*
import net.runelite.api.hooks.Callbacks
import meteor.ui.composables.preferences.uiColor
import meteor.ui.overlay.OverlayRenderer
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
    var meteorConfig: MeteorConfig
    init {
        // load configs immediately
        ConfigManager.loadSavedProperties()
        ConfigManager.setDefaultConfiguration(MeteorConfig::class, false)
        ConfigManager.saveProperties()

        // init meteor config
        meteorConfig = ConfigManager.getConfig(MeteorConfig::class.java)!!
    }

    private val startupTimer = StopWatch()

    // api
    lateinit var client: Client
    lateinit var callbacks: Callbacks

    var logger = Logger("Main")
    val eventBus = EventBus
    val httpClient = OkHttpClient()
    val overlayManager = OverlayManager
    val overlayRenderer = OverlayRenderer()
    val tooltipManager = TooltipManager
    val executor = ExecutorServiceExceptionLogger(Executors.newSingleThreadScheduledExecutor())
    lateinit var applet: Applet

/*
    // onClick listeners
    var onClicks = HashMap<MenuEntry, Consumer<MenuEntry>>()
    var onClicksWidget = HashMap<WidgetMenuOption, Consumer<MenuEntry>>()
*/

    // host properties
    val macOS = if ( System.getProperty("os.name").lowercase().contains("mac")) OS.MacOS else null
    val winOS = if ( System.getProperty("os.name").lowercase().contains("win")) OS.Windows else null
    var shouldExit = true;

    // plugin properties
    var pluginsEnabled = true
    var gpuNeedsReenabled = false
    var gpuHDNeedsReenabled = false
    var lastGPUPluginName = ""

    // window properties
    val windowPlacement = mutableStateOf(WindowPlacement.Maximized)
    val windowSize = mutableStateOf(DpSize.Unspecified)
    val windowState = mutableStateOf<WindowState?>(null)
    val defaultWindowState = mutableStateOf<WindowState?>(null)
    val windowChangeRequired = mutableStateOf(false)
    val shouldRender = mutableStateOf(true)
    var window: FrameWindowScope? = null

    @JvmStatic
    fun main(args: Array<String>) = application {
        EXTERNALS_DIR.mkdirs()
        Proxy.handle(args)
        if (winOS != null || macOS != null) {
            MeteorliteTheme.installDark()
        }
        startupTimer.start()
        AppletConfiguration.init()
        applet = Applet()
        applet.init()
        initWindow()
        // finishStartup is ran here after windowContent()
    }

    @Composable
    fun initWindow() {
        //We do this to redraw the window
        when (windowChangeRequired.value) {
            else -> createWindow()
        }
    }

    /**
     * This is all some neat trickery to get window state toggling to work with Jetbrains Compose
     * P.S. FIX YOUR SHITTY FRAME / SWING RENDERING CODE <3
     */
    @Composable
    fun createWindow() {
        window?.let {
            if (!shouldRender.value)
                if (it.window.isDisplayable) {
                    while (it.window.isDisplayable) {
                        it.window.dispose()
                        Thread.sleep(100)
                    }
                }
        }

        //Set absolute min size
        windowSize.value = DpSize(1.dp, 1.dp)
        windowState.value = WindowState(size = windowSize.value)

        if (meteorConfig.lockWindowSize()) {
            val sizeString = meteorConfig.lockedWindowSize()

            windowSize.value = DpSize(
                sizeString.split(":")[0].toInt().dp,
                sizeString.split(":")[1].toInt().dp)

            windowState.value = WindowState(size = windowSize.value)
        }

        if (meteorConfig.fullscreen()) {
            windowPlacement.value = WindowPlacement.Maximized
            windowSize.value = DpSize.Unspecified
            windowState.value = WindowState(placement = windowPlacement.value, size = windowSize.value)
        }

        if (shouldRender.value)
            createNewWindow()
        else {
            while (window!!.window.isDisplayable) {
                Thread.sleep(100)
            }
            createNewWindow()
        }
        shouldExit = true
        shouldRender.value = true
    }

    @Composable
    fun createNewWindow() {
        Window(
            onCloseRequest = {
                if (shouldExit)
                    exitApplication()
                window!!.window.dispose()
            },
            title = "Meteor: OpenRSC",
            undecorated = meteorConfig.fullscreen(),
            alwaysOnTop = meteorConfig.alwaysOnTop(),
            resizable = !meteorConfig.lockWindowSize(),
            state = windowState.value!!,
            content = {
                val icon = painterResource("Meteor.ico")
                SideEffect {
                    window.iconImage = icon.toAwtImage(Density(1f), LayoutDirection.Ltr, Size(128f, 128f))
                }
                windowContent()
            }
        )
    }

    fun finishStartup() {
        initApi()
        //initOverlays()
        initManagers()
        RuntimeConfigLoader.get()
        if (pluginsEnabled) {
            //xpTrackerService = XpTrackerService(PluginManager.get())
        }
        //SessionManager.start()
        startupTimer.stop()

        logger.debug("Meteor started in ${startupTimer.getTime(TimeUnit.MILLISECONDS)}ms")
    }

    private fun initManagers() {
        PluginManager
    }

    fun initApi() {
/*        KEVENT.subscribe<Interact> {
            ClientThread.invoke { ClientPackets.createClientPacket(it.data.menu)!!.send() }
        }
        KEVENT.subscribe<ClickPacket> {
            ClientThread.invoke { ClientPackets.queueClickPacket(it.data.clickPoint) }
        }
        KEVENT.subscribe<MenuOptionClicked>{
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
        }*/
        KEVENT.subscribe<ConfigChanged> {
            if (it.data.group == Configuration.MASTER_GROUP)
                if (it.data.key == "fullscreen") {
                    shouldExit = false
                    shouldRender.value = false
                }
            else if (it.data.key == "MeteorColor") {
                    uiColor.value = Color(meteorConfig.uiColor().rgb)
                }
        }
    }

/*    fun initOverlays() {
        WidgetOverlay.createOverlays().forEach{ overlay: WidgetOverlay -> overlayManager.add(overlay) }
        overlayManager.add(TooltipOverlay())
        overlayManager.add(WorldMapOverlay())
    }

    fun initManagers() {
        GameEventManager
    }*/

    override fun exitApplication() {
        try {
            PluginManager.shutdown()
        } catch (_: Exception) {}
        ConfigManager.saveProperties()
        exitProcess(0)
    }
}