package meteor.plugins

import meteor.Configuration
import meteor.Main
import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.apitest.ApiTestPlugin
import meteor.plugins.autobankpin.AutoBankPinPlugin
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRunPlugin
import meteor.plugins.bank.BankPlugin
import meteor.plugins.boosts.BoostsPlugin
import meteor.plugins.combatlevel.CombatLevelPlugin
import meteor.plugins.devtools.DevToolsPlugin
import meteor.plugins.entityhider.EntityHiderPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.grounditems.GroundItemsPlugin
import meteor.plugins.guardiansoftherift.GuardiansOfTheRiftPlugin
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
import net.runelite.client.plugins.herbiboars.HerbiboarPlugin
import net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperPlugin
import net.runelite.client.plugins.slayer.SlayerPlugin
import rs117.hd.HdPlugin
import java.io.File
import java.net.JarURLConnection
import java.net.URL
import java.net.URLClassLoader
import java.util.*
import java.util.jar.Manifest
import kotlin.system.exitProcess


object PluginManager {
    var plugins = ArrayList<Plugin>()
    var loadedExternals = ArrayList<String>()
    init {
        init<ApiTestPlugin>()
        init<AgilityPlugin>()
        init<AutoBankPinPlugin>()
        init<AutoLoginPlugin>()
        init<AutoRunPlugin>()
        init<BankPlugin>()
        init<BoostsPlugin>()
        //init<ChatFilterPlugin>()
        init<CombatLevelPlugin>()
        init<DevToolsPlugin>()
        init<ExamplePlugin>()
        init<EntityHiderPlugin>()
        init<FishingPlugin>()
        init<GroundItemsPlugin>()
        init<HerbiboarPlugin>()
        init<ItemPricesPlugin>()
        init<KeyboardBankPinPlugin>()
        init<MenuEntrySwapperPlugin>()
        init<MinimapPlugin>()
        init<MouseTooltipPlugin>()
        init<NpcAggroLinesPlugin>()
        init<NeverLogoutPlugin>()
        init<RsnHiderPlugin>()
        init<SlayerPlugin>()
        init<SpecBarPlugin>()
        init<StatusBarsPlugin>()
        init<StretchedModePlugin>()
        init<GuardiansOfTheRiftPlugin>()
        init<WorldMapPlugin>()
        init<XpTrackerPlugin>()
        init<HdPlugin>()
    }

    private fun loadExternal(jar: File) {
        val pluginName = jar.name.split(".jar")[0]
        if (!loadedExternals.contains(pluginName)) {
            loadedExternals.add(pluginName)
            val manifest: Manifest? = getManifest(jar)
            manifest?.let {
                initExternalPlugin(jar, manifest)
                Main.logger.debug("Added ${jar.name} to classpath")
            }
        }
    }

    fun loadExternalPlugins() {
        val externalsDir = File(Configuration.METEOR_DIR, "externalplugins")
        if (externalsDir.exists())
            externalsDir.mkdirs()

        val externalJars = externalsDir.listFiles()
        externalJars?.let { jars ->
            for (jar in jars) {
                jar?.let { it ->
                    loadExternal(it)
                }
            }
        }
    }

    fun getManifest(jar: File) : Manifest? {
        val jarConnection = URL("jar:file:${jar.absolutePath}!/").openConnection() as JarURLConnection
        return jarConnection.manifest
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

    fun initExternalPlugin(jar: File, manifest: Manifest) {
        try {
            val classLoader = URLClassLoader(arrayOf(jar.toURI().toURL()))
            val plugin = classLoader.loadClass(manifest.mainAttributes.getValue("Main-Class")).newInstance() as Plugin
            if (plugins.any { p -> p.getName().equals(plugin.getName()) })
                throw RuntimeException("Duplicate plugin (${plugin.getName()}) not allowed")

            plugins.add(plugin)
            plugin.subscribeEvents()
            if (plugin.isEnabled())
                start(plugin)
        } catch (e: Exception) {
            if (e is java.lang.RuntimeException) {
                e.printStackTrace()
                exitProcess(-1)
            }

            Main.logger.error(e.toString())
            Main.logger.error("Failed to load external plugin: (${jar.absolutePath})")
        }

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
