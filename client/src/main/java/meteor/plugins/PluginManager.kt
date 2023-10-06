package meteor.plugins

import androidx.compose.runtime.mutableStateListOf
import meteor.Configuration
import meteor.Main
import meteor.Main.logger
import meteor.Main.pluginsEnabled
import meteor.config.ConfigManager
import meteor.plugins.meteor.Meteor
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin

import org.apache.commons.lang3.time.StopWatch
import java.io.File
import java.net.JarURLConnection
import java.net.URL
import java.net.URLClassLoader
import java.util.concurrent.TimeUnit
import java.util.jar.Manifest
import kotlin.system.exitProcess


object PluginManager {
    var plugins = mutableStateListOf<Plugin>()
    val externalsDir = File(Configuration.METEOR_DIR, "externalplugins")
    val runningMap = HashMap<Plugin, Boolean>()
    val classLoaders = HashMap<String, URLClassLoader>();
    init {
        init<Meteor>()
        if (pluginsEnabled) {
            init<ExamplePlugin>()
            init<InventoryItemsPlugin>()
            init<StretchedModePlugin>()
            init<StatusBarsPlugin>()
        }
    }

    inline fun <reified T : Plugin> init() {
        val plugin = T::class.java.getDeclaredConstructor().newInstance()
        if (plugins.filterIsInstance<T>().isNotEmpty())
            throw RuntimeException("Duplicate plugin ${plugin::class.simpleName} not allowed")

        plugin.configuration?.let {
            ConfigManager.setDefaultConfiguration(it, false)
        }

        if (ConfigManager.getConfiguration(
                plugin.javaClass.simpleName,
                "pluginEnabled"
            ) != null && plugin.javaClass.getAnnotation(PluginDescriptor::class.java)!!.disabledOnStartup
        )
            ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", false)

        runningMap[plugin] = plugin.shouldEnable()
        plugins.add(plugin)

        if (runningMap[plugin]!!)
            start(plugin)
    }

    fun get(p: Class<out Plugin>): Plugin {
        return plugins.first { it.javaClass == p }
    }

    inline fun <reified T : Plugin> get(): T {
        return plugins.filterIsInstance<T>().first()
    }

    inline fun <reified T : Plugin> getOrNull(): T? {
        return plugins.filterIsInstance<T>().firstOrNull()
    }

    inline fun <reified T : Plugin> restart() {
        val it = plugins.filterIsInstance<T>().first()
        stop(it)
        start(it)
    }

    inline fun <reified T : Plugin> toggle() {
        val it = plugins.filterIsInstance<T>().first()
        if (runningMap[it]!!)
            stop(it)
        else
            start(it)
    }

    fun toggle(it: Plugin) {
        if (runningMap[it]!!)
            stop(it)
        else
            start(it)
    }

    fun stop(plugin: Plugin) {
        plugin.stop()
        plugin.onStop()
        runningMap[plugin] = false
    }

    fun start(plugin: Plugin) {
        try
        {
            plugin.start()
            plugin.onStart()
            runningMap[plugin] = true
        }catch (e:Throwable)
        {
            runningMap[plugin] = false
            logger.error("FAILED TO START PLUGIN")
            e.printStackTrace()
        }
    }

    fun shutdown() {
        for (plugin in plugins) {
            stop(plugin)
        }
    }
}