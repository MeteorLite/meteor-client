package meteor.plugins

import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRunPlugin
import meteor.plugins.bank.BankPlugin
import meteor.plugins.devtools.DevToolsPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.grounditems.GroundItemsPlugin
import meteor.plugins.itemprices.ItemPricesPlugin
import meteor.plugins.keyboardbankpin.KeyboardBankPinPlugin
import meteor.plugins.mousetooltips.MouseTooltipPlugin
import meteor.plugins.neverlog.NeverLogoutPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import rs117.hd.GpuHDPlugin
import java.lang.RuntimeException

object PluginManager {
    var plugins = ArrayList<Plugin>()
    init {
        init<AgilityPlugin>()
        init<AutoLoginPlugin>()
        init<AutoRunPlugin>()
        init<BankPlugin>()
        init<DevToolsPlugin>()
        init<ExamplePlugin>()
        init<FishingPlugin>()
        init<GroundItemsPlugin>()
        init<ItemPricesPlugin>()
        init<KeyboardBankPinPlugin>()
        init<GpuHDPlugin>()
        init<MouseTooltipPlugin>()
        init<NeverLogoutPlugin>()
        init<StretchedModePlugin>()
        init<WorldMapPlugin>()
        init<XpTrackerPlugin>()
    }

    inline fun <reified T : Plugin> init() {
        val plugin = T::class.java.newInstance()
        for (p in plugins)
            if (p::class == plugin::class)
                throw RuntimeException("Duplicate plugin ${p::class.simpleName} not allowed")

            plugins.add(plugin)
            if (plugin.isEnabled())
                start(plugin)
    }

    inline fun <reified T : Plugin> get(): T? {
        for (plugin in plugins) {
            if (plugin is T)
                return plugin
        }
        return null
    }

    inline fun <reified T : Plugin> restart(): T? {
        for (plugin in plugins) {
            if (plugin is T) {
                stop(plugin)
                start(plugin)
            }
        }
        return null
    }

    fun stop(plugin: Plugin) {
        plugin.unsubscribe()
        plugin.stop()
        plugin.onStop()
        plugin.enabled = false
    }

     fun start(plugin: Plugin) {
         plugin.onStart()
         plugin.start()
         plugin.subscribe()
         plugin.enabled = true
    }

    fun shutdown() {
        for (plugin in plugins) {
            stop(plugin)
        }
    }
}