package meteor.plugins

import androidx.compose.runtime.mutableStateListOf
import com.questhelper.QuestHelperPlugin
import com.questhelper.questhelpers.QuestHelper
import com.tileman.TilemanModePlugin
import meteor.Configuration
import meteor.Main
import meteor.plugins.agility.AgilityPlugin
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
import meteor.plugins.rsnhider.RsnHiderPlugin
import meteor.plugins.specbar.SpecBarPlugin
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import net.runelite.client.plugins.defaultworld.DefaultWorldPlugin
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin
import net.runelite.client.plugins.herbiboars.HerbiboarPlugin
import net.runelite.client.plugins.interfacestyles.InterfaceStylesPlugin
import net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperPlugin
import net.runelite.client.plugins.npcunaggroarea.NpcAggroAreaPlugin
import net.runelite.client.plugins.slayer.SlayerPlugin
import net.runelite.client.plugins.timers.TimersPlugin
import org.apache.commons.lang3.time.StopWatch
import rs117.hd.HdPlugin
import java.io.File
import java.net.JarURLConnection
import java.net.URL
import java.net.URLClassLoader
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.jar.Manifest
import kotlin.system.exitProcess


object PluginManager {
    var plugins = mutableStateListOf<Plugin>()
    val externalsDir = File(Configuration.METEOR_DIR, "externalplugins")

    init {
        init<AgilityPlugin>()
        init<AutoBankPinPlugin>()
        init<AutoLoginPlugin>()
        init<AutoRunPlugin>()
        init<BankPlugin>()
        init<BoostsPlugin>()
        //init<ChatFilterPlugin>()
        init<CombatLevelPlugin>()
        init<DefaultWorldPlugin>()
        init<DevToolsPlugin>()
        init<ExamplePlugin>()
        init<EntityHiderPlugin>()
        init<FishingPlugin>()
        init<GauntletExtendedPlugin>()
        init<GroundItemsPlugin>()
        init<HerbiboarPlugin>()
        init<InterfaceStylesPlugin>()
        init<ItemPricesPlugin>()
        init<KeyboardBankPinPlugin>()
        init<MenuEntrySwapperPlugin>()
        init<MinimapPlugin>()
        init<MouseTooltipPlugin>()
        init<NpcAggroAreaPlugin>()
        init<NeverLogoutPlugin>()
        init<QuestHelperPlugin>()
        init<RsnHiderPlugin>()
        init<SlayerPlugin>()
        init<SpecBarPlugin>()
        init<StatusBarsPlugin>()
        init<StretchedModePlugin>()
        init<TilemanModePlugin>()
        init<TimersPlugin>()
        init<GuardiansOfTheRiftPlugin>()
        init<WorldMapPlugin>()
        init<XpTrackerPlugin>()
        init<HdPlugin>()
    }

    private fun loadExternal(jar: File) {
        val manifest: Manifest? = getManifest(jar)
        manifest?.let { initExternalPlugin(jar, manifest) }
    }

    fun loadExternalPlugins() {
        val timer = StopWatch()

        if (externalsDir.exists())
            externalsDir.mkdirs()

        val externalJars = externalsDir.listFiles()
        externalJars?.let { jars ->
            timer.start()
            for (jar in jars) {
                jar?.let { it ->
                    loadExternal(it)
                }
            }
            timer.stop()
            Main.logger.info("Loaded ${externalJars.size} external plugins in ${timer.getTime(TimeUnit.MILLISECONDS)}ms")
        }
    }

    fun reloadExternal(plugin: Plugin) {
        val externalJars = externalsDir.listFiles()
        externalJars?.let { jars ->
            for (jar in jars) {
                jar?.let { it ->
                    val manifest: Manifest? = getManifest(it)
                    manifest?.let { manifest ->
                        if (manifest.mainAttributes.getValue("Main-Class") == plugin.javaClass.name)
                        {
                            stop(plugin)
                            plugins.remove(plugin)
                            initExternalPlugin(it, manifest)
                            return
                        }
                    }
                    Main.logger.error("Could not find matching Plugin class, did you change the Main-Class?")
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
            e.printStackTrace()
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
