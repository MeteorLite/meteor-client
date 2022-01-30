package meteor.plugins

import meteor.Configuration
import meteor.config.ConfigManager
import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRun
import meteor.plugins.devtools.DevToolsPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.grounditems.GroundItemsPlugin
import meteor.plugins.itemprices.ItemPricesPlugin
import meteor.plugins.keyboardbankpin.KeyboardBankPinPlugin
import meteor.plugins.mousetooltips.MouseTooltipPlugin
import meteor.plugins.neverlog.NeverLogoutPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.woodcutting.WoodcuttingPlugin
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import org.rationalityfrontline.kevent.unsubscribeAll
import rs117.hd.GpuHDPlugin
import java.lang.RuntimeException

object PluginManager {
    var plugins = ArrayList<Plugin>()
    init {
        initPlugin(AgilityPlugin())
        initPlugin(AutoLoginPlugin())
        initPlugin(AutoRun())
        initPlugin(DevToolsPlugin())
        initPlugin(ExamplePlugin())
        initPlugin(FishingPlugin())
        initPlugin(GroundItemsPlugin())
        initPlugin(ItemPricesPlugin())
        initPlugin(KeyboardBankPinPlugin())
        if (Configuration.allowGPU) {
            initPlugin(GpuHDPlugin())
        }
        initPlugin(MouseTooltipPlugin())
        initPlugin(NeverLogoutPlugin())
        initPlugin(StretchedModePlugin())
        initPlugin(WoodcuttingPlugin())
        initPlugin(WorldMapPlugin())
        initPlugin(XpTrackerPlugin())
    }

    fun initPlugin(plugin: Plugin) {
        for (p in plugins)
            if (p::class == plugin::class)
                throw RuntimeException("Duplicate plugin ${p::class.simpleName} not allowed")
        val enabledConfig: String? = ConfigManager.getConfiguration(plugin.javaClass.simpleName, "pluginEnabled")
        val descriptor: PluginDescriptor? = plugin.javaClass.getAnnotation(PluginDescriptor::class.java)
        if (enabledConfig == null) {
            if (descriptor != null) {
                val enabledByDefault = descriptor.enabledByDefault || descriptor.cantDisable
                ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", enabledByDefault)
            }
        }

        if (enabledConfig != null && descriptor!!.disabledOnStartup) {
            ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", false)
        }

        plugins.add(plugin)

        var shouldEnable = false

        if (ConfigManager.getConfiguration(plugin.javaClass.simpleName, "pluginEnabled").toBoolean())
            shouldEnable = true else if (plugin.javaClass.getAnnotation(PluginDescriptor::class.java).cantDisable) shouldEnable = true

        if (shouldEnable)
            startPlugin(plugin)
    }

    inline fun <reified T : Plugin> getPlugin(): T? {
        for (plugin in plugins) {
            if (plugin is T)
                return plugin
        }
        return null
    }

    inline fun <reified T : Plugin> restartPlugin(): T? {
        for (plugin in plugins) {
            if (plugin is T) {
                plugin.stop()
                plugin.onStop()
                plugin.onStart()
                plugin.start()
            }
        }
        return null
    }

    fun stopPlugin(plugin: Plugin) {
        plugin.unsubscribe()
        plugin.stop()
        plugin.onStop()
        plugin.enabled = false
    }

     fun startPlugin(plugin: Plugin) {
         plugin.onStart()
         plugin.start()
         plugin.subscribe()
         plugin.enabled = true
    }

    fun shutdown() {
        for (plugin in plugins) {
            if (plugin.enabled) {
                plugin.unsubscribeAll()
                plugin.onStop()
                plugin.stop()
                plugin.enabled = false
            }
        }
    }
}