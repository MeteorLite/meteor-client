package meteor.plugins

import androidx.compose.runtime.mutableStateListOf
import meteor.Configuration
import meteor.Main.logger
import meteor.Main.pluginsEnabled
import meteor.config.ConfigManager
import meteor.plugins.meteor.Meteor
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.itemnamepatch.ItemNamePatchPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin

import java.io.File
import java.net.URLClassLoader


object PluginManager {
    var plugins = mutableStateListOf<Plugin>()
    val runningMap = HashMap<Plugin, Boolean>()
    init {
        init<Meteor>()
        if (pluginsEnabled) {
            init<ItemNamePatchPlugin>()
            init<StatusBarsPlugin>()
            init<StretchedModePlugin>()
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