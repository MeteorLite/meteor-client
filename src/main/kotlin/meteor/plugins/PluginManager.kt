package meteor.plugins

import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.autobankpin.AutoBankPinPlugin
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRunPlugin
import meteor.plugins.bank.BankPlugin
import meteor.plugins.boosts.BoostsPlugin
import meteor.plugins.chatfilter.ChatFilterPlugin
import meteor.plugins.combatlevel.CombatLevelPlugin
import meteor.plugins.devtools.DevToolsPlugin
import meteor.plugins.entityhider.EntityHiderPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.grounditems.GroundItemsPlugin
import meteor.plugins.itemprices.ItemPricesPlugin
import meteor.plugins.keyboardbankpin.KeyboardBankPinPlugin
import meteor.plugins.minimap.MinimapPlugin
import meteor.plugins.mousetooltips.MouseTooltipPlugin
import meteor.plugins.neverlog.NeverLogoutPlugin
import meteor.plugins.npcaggrolines.NpcAggroLinesPlugin
import meteor.plugins.rsnhider.RsnHiderPlugin
import meteor.plugins.specbar.SpecBarPlugin
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import rs117.hd.HdPlugin
import java.lang.RuntimeException

object PluginManager {
    var plugins = ArrayList<Plugin>()
    init {
        init<HdPlugin>()
        init<AgilityPlugin>()
        init<AutoBankPinPlugin>()
        init<AutoLoginPlugin>()
        init<AutoRunPlugin>()
        init<BankPlugin>()
        init<BoostsPlugin>()
        init<ChatFilterPlugin>()
        init<CombatLevelPlugin>()
        init<DevToolsPlugin>()
        init<ExamplePlugin>()
        init<EntityHiderPlugin>()
        init<FishingPlugin>()
        init<GroundItemsPlugin>()
        init<ItemPricesPlugin>()
        init<KeyboardBankPinPlugin>()
        init<MinimapPlugin>()
        init<MouseTooltipPlugin>()
        init<NpcAggroLinesPlugin>()
        init<NeverLogoutPlugin>()
        init<RsnHiderPlugin>()
        init<SpecBarPlugin>()
        init<StatusBarsPlugin>()
        init<StretchedModePlugin>()
        init<WorldMapPlugin>()
        init<XpTrackerPlugin>()
    }

    inline fun <reified T : Plugin> init() {
        val plugin = T::class.java.newInstance()
        if (plugins.filterIsInstance<T>().isNotEmpty())
                throw RuntimeException("Duplicate plugin ${plugin::class.simpleName} not allowed")

            plugins.add(plugin)
            plugin.subscribeEvents()
            if (plugin.isEnabled())
                start(plugin)
    }

    inline fun <reified T : Plugin> get(): T {
        return plugins.filterIsInstance<T>().first()
    }

    inline fun <reified T : Plugin> restart() {
        val it = plugins.filterIsInstance<T>().first()
        stop(it)
        start(it)
    }

    fun stop(plugin: Plugin) {
        plugin.stop()
        plugin.onStop()
    }

     fun start(plugin: Plugin) {
         plugin.onStart()
         plugin.start()
    }

    fun shutdown() {
        for (plugin in plugins) {
            stop(plugin)
        }
    }
}