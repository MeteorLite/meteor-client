package meteor.plugins

import androidx.compose.runtime.mutableStateListOf
import com.questhelper.QuestHelperPlugin
import com.tileman.TilemanModePlugin
import meteor.Configuration
import meteor.Main
import meteor.config.ConfigManager
import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.autoalch.AutoAlchPlugin
import meteor.plugins.autobankpin.AutoBankPinPlugin
import meteor.plugins.autoclicker.AutoClickerPlugin
import meteor.plugins.autologhop.AutoLogHop
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRunPlugin
import meteor.plugins.bank.BankPlugin
import meteor.plugins.banksetups.BankSetups
import meteor.plugins.boosts.BoostsPlugin
import meteor.plugins.combatlevel.CombatLevelPlugin
import meteor.plugins.commands.CommandsPlugin
import meteor.plugins.continueclicker.ContinueClickerPlugin
import meteor.plugins.devtools.DevToolsPlugin
import meteor.plugins.entityhider.EntityHiderPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.grounditems.GroundItemsPlugin
import meteor.plugins.guardiansoftherift.GuardiansOfTheRiftPlugin
import meteor.plugins.interacthighlight.InteractHighlightPlugin
import meteor.plugins.inventorytags.InventoryTagsPlugin
import meteor.plugins.itemprices.ItemPricesPlugin
import meteor.plugins.jadautoprayer.JadAutoPrayerPlugin
import meteor.plugins.keyboardbankpin.KeyboardBankPinPlugin
import meteor.plugins.meteor.Meteor
import meteor.plugins.minimap.MinimapPlugin
import meteor.plugins.mousetooltips.MouseTooltipPlugin
import meteor.plugins.neverlog.NeverLogoutPlugin
import meteor.plugins.nightmareHelper.NightmareHelper
import meteor.plugins.notes.NotesPlugin
import meteor.plugins.objecthider.ObjectHiderPlugin
import meteor.plugins.prayerflicker.PrayerFlickerPlugin
import meteor.plugins.pvpkeys.PvPKeys
import meteor.plugins.rsnhider.RsnHiderPlugin
import meteor.plugins.specbar.SpecBarPlugin
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.tileindicators.TileIndicatorsPlugin
import meteor.plugins.ctrlplayeroptions.CtrlPlayerOptions
import meteor.plugins.wintertodtfletcher.WintertodtHelper
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.worldmapwalker.WorldMapWalkerPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import net.runelite.client.plugins.ammo.AmmoPlugin
import net.runelite.client.plugins.aoewarnings.AoeWarningPlugin
import net.runelite.client.plugins.camera.CameraPlugin
import net.runelite.client.plugins.chatcommands.ChatCommandsPlugin
import net.runelite.client.plugins.defaultworld.DefaultWorldPlugin
import net.runelite.client.plugins.fps.FpsPlugin
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin
import net.runelite.client.plugins.herbiboars.HerbiboarPlugin
import net.runelite.client.plugins.interfacestyles.InterfaceStylesPlugin
import net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperPlugin
import net.runelite.client.plugins.mining.MiningPlugin
import net.runelite.client.plugins.motherlode.MotherlodePlugin
import net.runelite.client.plugins.npcunaggroarea.NpcAggroAreaPlugin
import net.runelite.client.plugins.oneclick3t4g.OneClick3t4g
import net.runelite.client.plugins.oneclickagility.OneClickAgilityPlugin
import net.runelite.client.plugins.slayer.SlayerPlugin
import net.runelite.client.plugins.timers.TimersPlugin
import org.apache.commons.lang3.time.StopWatch
import rs117.hd.HdPlugin
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

    init {

        init<Meteor>()
        init<AgilityPlugin>()
        init<AmmoPlugin>()
        init<AoeWarningPlugin>()
        init<AutoAlchPlugin>()
        init<AutoBankPinPlugin>()
        init<AutoClickerPlugin>()
        init<AutoLoginPlugin>()
        init<AutoLogHop>()
        init<AutoRunPlugin>()
        init<BankPlugin>()
        init<BankSetups>()
        init<BoostsPlugin>()
        init<CameraPlugin>()
        init<ChatCommandsPlugin>()
        //init<ChatFilterPlugin>()
        init<CombatLevelPlugin>()
        init<CommandsPlugin>()
        init<ContinueClickerPlugin>()
        init<CtrlPlayerOptions>()
        init<DefaultWorldPlugin>()
        init<DevToolsPlugin>()
        init<ExamplePlugin>()
        init<EntityHiderPlugin>()
        init<FishingPlugin>()
        init<FpsPlugin>()
        init<GauntletExtendedPlugin>()
        init<HdPlugin>()
        init<GroundItemsPlugin>()
        init<GuardiansOfTheRiftPlugin>()
        init<HerbiboarPlugin>()
        init<InterfaceStylesPlugin>()
        init<InteractHighlightPlugin>()
        init<InventoryTagsPlugin>()
        init<ItemPricesPlugin>()
        init<JadAutoPrayerPlugin>()
        init<KeyboardBankPinPlugin>()
        init<MenuEntrySwapperPlugin>()
        init<MinimapPlugin>()
        init<MiningPlugin>()
        init<MotherlodePlugin>()
        init<MouseTooltipPlugin>()
        init<NotesPlugin>()
        init<NpcAggroAreaPlugin>()
        init<NeverLogoutPlugin>()
        init<NightmareHelper>()
        init<ObjectHiderPlugin>()
        init<OneClick3t4g>()
        init<OneClickAgilityPlugin>()
        init<PvPKeys>()
        init<PrayerFlickerPlugin>()
        init<QuestHelperPlugin>()
        init<RsnHiderPlugin>()
        init<SlayerPlugin>()
        init<SpecBarPlugin>()
        init<StatusBarsPlugin>()
        init<StretchedModePlugin>()
        init<TileIndicatorsPlugin>()
        init<TilemanModePlugin>()
        init<TimersPlugin>()
        init<WorldMapPlugin>()
        init<WorldMapWalkerPlugin>()
        init<WintertodtHelper>()
        init<XpTrackerPlugin>()
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
                        if (manifest.mainAttributes.getValue("Main-Class") == plugin.javaClass.name) {
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

    fun getManifest(jar: File): Manifest? {
        val jarConnection = URL("jar:file:${jar.absolutePath}!/").openConnection() as JarURLConnection
        return jarConnection.manifest
    }

    inline fun <reified T : Plugin> init() {
        val plugin = T::class.java.newInstance()
        if (plugins.filterIsInstance<T>().isNotEmpty())
            throw RuntimeException("Duplicate plugin ${plugin::class.simpleName} not allowed")

        plugin.config?.let {
            ConfigManager.setDefaultConfiguration(it, false)
        }

        if (ConfigManager.getConfiguration(plugin.javaClass.simpleName, "pluginEnabled") != null && plugin.javaClass.getAnnotation(PluginDescriptor::class.java)!!.disabledOnStartup)
            ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", false)

        runningMap[plugin] = plugin.shouldEnable()
        plugins.add(plugin)

        if (runningMap[plugin]!!)
            start(plugin)
    }

    fun initExternalPlugin(jar: File, manifest: Manifest) {
        try {
            val classLoader = URLClassLoader(arrayOf(jar.toURI().toURL()))
            val plugin = classLoader.loadClass(manifest.mainAttributes.getValue("Main-Class")).newInstance() as Plugin
            if (plugins.any { p -> p.getName().equals(plugin.getName()) })
                throw RuntimeException("Duplicate plugin (${plugin.getName()}) not allowed")

            if (ConfigManager.getConfiguration(plugin.javaClass.simpleName, "pluginEnabled") != null && plugin.javaClass.getAnnotation(PluginDescriptor::class.java)!!.disabledOnStartup)
                ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", false)

            plugins.add(plugin)
            runningMap[plugin] = plugin.shouldEnable()
            if (runningMap[plugin]!!)
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
        plugin.start()
        plugin.onStart()
        runningMap[plugin] = true
    }

    fun shutdown() {
        for (plugin in plugins) {
            stop(plugin)
        }
    }
}
