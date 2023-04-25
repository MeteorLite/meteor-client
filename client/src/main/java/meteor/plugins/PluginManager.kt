package meteor.plugins

import androidx.compose.runtime.mutableStateListOf
import net.runelite.client.plugins.questhelper.QuestHelperPlugin
import net.runelite.client.plugins.tileman.TilemanModePlugin
import meteor.Configuration
import meteor.Main
import meteor.Main.logger
import meteor.Main.pluginsEnabled
import meteor.config.ConfigManager
import meteor.external.ExternalManager
import meteor.plugins.crabfighter.CrabFighterPlugin
import meteor.plugins.agility.AgilityPlugin
import meteor.plugins.alchemicalhydra.AlchemicalHydraPlugin
import meteor.plugins.autokraken.AutoKrakenPlugin
import meteor.plugins.ammo.AmmoPlugin
import meteor.plugins.antidrag.AntiDragPlugin
import meteor.plugins.attackstyles.AttackStylesPlugin
import meteor.plugins.autoalch.AutoAlchPlugin
import meteor.plugins.autobankpin.AutoBankPinPlugin
import meteor.plugins.autoclicker.AutoClickerPlugin
import meteor.plugins.autoeater.AutoEaterPlugin
import meteor.plugins.autologhop.AutoLogHop
import meteor.plugins.autologin.AutoLoginPlugin
import meteor.plugins.autorun.AutoRunPlugin
import meteor.plugins.bank.BankPlugin
import meteor.plugins.banksetups.BankSetups
import meteor.plugins.bankactions.BankActionsPlugin
import meteor.plugins.banktags.BankTagsPlugin
import meteor.plugins.barrows.BarrowsPlugin
import meteor.plugins.barrowsdoorhighlighter.BarrowsDoorHighlighter
import meteor.plugins.blastfurnace.BlastFurnacePlugin
import meteor.plugins.blastmine.BlastMinePlugin
import meteor.plugins.boosts.BoostsPlugin
import meteor.plugins.bosstimer.BossTimersPlugin
import meteor.plugins.bowfletcher.BowFletcher
import meteor.plugins.camera.CameraPlugin
import meteor.plugins.cannonreloader.CannonReloaderPlugin
import meteor.plugins.cerbprayers.CerbAutoPrayersPlugin
import meteor.plugins.chathistory.ChatHistoryPlugin
import meteor.plugins.combatlevel.CombatLevelPlugin
import meteor.plugins.commands.CommandsPlugin
import meteor.plugins.continueclicker.ContinueClickerPlugin
import meteor.plugins.cooking.CookingPlugin
import meteor.plugins.corp.CorpPlugin
import meteor.plugins.coxhelper.CoxPlugin
import meteor.plugins.ctrlplayeroptions.CtrlPlayerOptions
import meteor.plugins.defaultworld.DefaultWorldPlugin
import meteor.plugins.demonicgorilla.DemonicGorillaPlugin
import meteor.plugins.driftnet.DriftNetPlugin
import meteor.plugins.emojis.EmojiPlugin
import meteor.plugins.entityhider.EntityHiderPlugin
import meteor.plugins.examine.ExaminePlugin
import meteor.plugins.fairyring.FairyRingPlugin
import meteor.plugins.fighter.FighterPlugin
import meteor.plugins.fishing.FishingPlugin
import meteor.plugins.fps.FpsPlugin
import meteor.plugins.fullscreen.FullscreenPlugin
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import meteor.plugins.groundmarkers.GroundMarkerPlugin
import meteor.plugins.guardiansoftherift.GuardiansOfTheRiftPlugin
import meteor.plugins.hiscore.HiScorePlugin
import meteor.plugins.hunter.HunterPlugin
import meteor.plugins.infopanel.InfoPanelPlugin
import meteor.plugins.interacthighlight.InteractHighlightPlugin
import meteor.plugins.inventorytags.InventoryTagsPlugin
import meteor.plugins.itemcharges.ItemChargePlugin
import meteor.plugins.itemprices.ItemPricesPlugin
import meteor.plugins.jadautoprayer.JadAutoPrayerPlugin
import meteor.plugins.kebabbuyer.KebabBuyerPlugin
import meteor.plugins.logchopper.LogChopper
import meteor.plugins.loottracker.LootTrackerPlugin
import meteor.plugins.lowdetail.LowDetailPlugin
import meteor.plugins.meteor.Meteor
import meteor.plugins.minimap.MinimapPlugin
import meteor.plugins.mousetooltips.MouseTooltipPlugin
import meteor.plugins.muspahassist.MuspahAssist
import meteor.plugins.neverlog.NeverLogoutPlugin
import meteor.plugins.nightmareHelper.NightmareHelper
import meteor.plugins.nmzguzzle.NightmareZoneAFKPlugin
import meteor.plugins.notes.NotesPlugin
import meteor.plugins.objecthider.ObjectHiderPlugin
import meteor.plugins.objectindicators.ObjectIndicatorsPlugin
import meteor.plugins.olmswapper.OlmSwapperPlugin
import meteor.plugins.oneclick3tfish.OneClick3TFishPlugin
import meteor.plugins.oneclickaerialfishing.OneClickAerialFishingPlugin
import meteor.plugins.oneclickagility.OneClickAgilityPlugin
import meteor.plugins.oneclickblackjack.OneClickBlackjackPlugin
import meteor.plugins.oneclickchins.Oneclickchinsplugin
import meteor.plugins.oneclickfurnace.OneClickFurnacePlugin
import meteor.plugins.oneclickglassblowing.OneClickGlassblowingPlugin
import meteor.plugins.oneclickkarambwans.OneClickKarambwansPlugin
import meteor.plugins.oneclicksandstone.OneClickSandstonePlugin
import meteor.plugins.opponentinfo.OpponentInfoPlugin
import meteor.plugins.pestcontrol.PestControlPlugin
import meteor.plugins.playeroutline.PlayerOutlinePlugin
import meteor.plugins.poison.PoisonPlugin
import meteor.plugins.prayerflicker.PrayerFlickerPlugin
import meteor.plugins.prayerpotdrinker.PrayerPotDrinker
import meteor.plugins.privateserver.PrivateServerPlugin
import meteor.plugins.pvpkeys.PvPKeys
import meteor.plugins.reportbutton.ReportButtonPlugin
import meteor.plugins.rsnhider.RsnHiderPlugin
import meteor.plugins.runepouch.RunepouchPlugin
import meteor.plugins.specbar.SpecBarPlugin
import meteor.plugins.statusbars.StatusBarsPlugin
import meteor.plugins.stretchedmode.StretchedModePlugin
import meteor.plugins.thralls.ThrallsPlugin
import meteor.plugins.tileindicators.TileIndicatorsPlugin
import meteor.plugins.virtuallevels.VirtualLevelsPlugin
import meteor.plugins.winemaker.WineMakerPlugin
import meteor.plugins.wintertodtfletcher.WintertodtHelper
import meteor.plugins.worldmap.WorldMapPlugin
import meteor.plugins.worldmapwalker.WorldMapWalkerPlugin
import meteor.plugins.xptracker.XpTrackerPlugin
import net.runelite.client.plugins.aoewarnings.AoeWarningPlugin
import net.runelite.client.plugins.cannon.CannonPlugin
import net.runelite.client.plugins.chatcommands.ChatCommandsPlugin
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin
import net.runelite.client.plugins.devtools.DevToolsPlugin
//import net.runelite.client.plugins.externals.leftclickcast.LeftClickCast
//import net.runelite.client.plugins.externals.oneclick.OneClick
import net.runelite.client.plugins.gpu.GpuPlugin
import net.runelite.client.plugins.grounditems.GroundItemsPlugin
import net.runelite.client.plugins.herbiboars.HerbiboarPlugin
import net.runelite.client.plugins.interfacestyles.InterfaceStylesPlugin
import net.runelite.client.plugins.itemstats.ItemStatPlugin
import net.runelite.client.plugins.keyremapping.KeyRemappingPlugin
import net.runelite.client.plugins.menuentryswapper.MenuEntrySwapperPlugin
import net.runelite.client.plugins.mining.MiningPlugin
import net.runelite.client.plugins.motherlode.MotherlodePlugin
import net.runelite.client.plugins.npchighlight.NpcIndicatorsPlugin
import net.runelite.client.plugins.npcunaggroarea.NpcAggroAreaPlugin
import net.runelite.client.plugins.oneclick3t4g.OneClick3t4g
import net.runelite.client.plugins.puzzlesolver.PuzzleSolverPlugin
import net.runelite.client.plugins.slayer.SlayerPlugin
import net.runelite.client.plugins.timers.TimersPlugin
import net.runelite.client.plugins.timestamp.TimestampPlugin
import net.runelite.client.plugins.zulrah.ZulrahPlugin
import org.apache.commons.lang3.time.StopWatch
import net.runelite.client.plugins.kourendlibrary.KourendLibraryPlugin
import net.runelite.client.plugins.npcstatus.NpcAttackTimersPlugin
import net.runelite.client.plugins.raids.RaidsPlugin
import net.runelite.client.plugins.titheextended.TithePlugin
import meteor.plugins.disablerenderer.DisableRenderingPlugin
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
    val classLoaders = HashMap<String, URLClassLoader>();
    init {
        init<Meteor>()
        if (pluginsEnabled) {
            init<AgilityPlugin>()
            init<AlchemicalHydraPlugin>()
            init<AutoKrakenPlugin>()
            init<AmmoPlugin>()
            init<AoeWarningPlugin>()
            init<AttackStylesPlugin>()
            init<AntiDragPlugin>()
            init<AutoAlchPlugin>()
            init<AutoBankPinPlugin>()
            init<AutoClickerPlugin>()
            init<AutoEaterPlugin>()
            init<AutoLoginPlugin>()
            init<AutoLogHop>()
            init<AutoRunPlugin>()
            init<BankActionsPlugin>()
            init<BankPlugin>()
            init<BankSetups>()
            init<BankTagsPlugin>()
            init<BarrowsPlugin>()
            init<BarrowsDoorHighlighter>()
            init<BlastFurnacePlugin>()
            init<BlastMinePlugin>()
            init<BoostsPlugin>()
            init<BossTimersPlugin>()
            init<BowFletcher>()
            init<CameraPlugin>()
            init<CannonPlugin>()
            init<CannonReloaderPlugin>()
            init<CerbAutoPrayersPlugin>()
            init<RaidsPlugin>()
            init<ChatCommandsPlugin>()
            init<ChatHistoryPlugin>()
            init<ClueScrollPlugin>()
            init<CombatLevelPlugin>()
            init<CommandsPlugin>()
            init<ContinueClickerPlugin>()
            init<CookingPlugin>()
            init<CorpPlugin>()
            init<CoxPlugin>()
            init<CrabFighterPlugin>()
            init<CtrlPlayerOptions>()
            init<DefaultWorldPlugin>()
            init<DemonicGorillaPlugin>()
            init<DevToolsPlugin>()
            init<DisableRenderingPlugin>()
            init<DriftNetPlugin>()
            init<ExamplePlugin>()
            init<EmojiPlugin>()
            init<EntityHiderPlugin>()
            init<ExaminePlugin>()
            init<ExternalManager>()
            init<FairyRingPlugin>()
            init<FishingPlugin>()
            init<FighterPlugin>()
            init<FpsPlugin>()
            init<FullscreenPlugin>()
            init<GauntletExtendedPlugin>()
            //init<HdPlugin>()
            init<GpuPlugin>()
            init<GroundItemsPlugin>()
            init<GroundMarkerPlugin>()
            init<GuardiansOfTheRiftPlugin>()
            init<HerbiboarPlugin>()
            init<HiScorePlugin>()
            init<HunterPlugin>()
            init<InfoPanelPlugin>()
            init<InterfaceStylesPlugin>()
            init<InteractHighlightPlugin>()
            init<InventoryTagsPlugin>()
            init<ItemChargePlugin>()
            init<ItemPricesPlugin>()
            init<ItemStatPlugin>()
            init<JadAutoPrayerPlugin>()
            init<KebabBuyerPlugin>()
            init<KeyRemappingPlugin>()
            init<KourendLibraryPlugin>()
            //init<LeftClickCast>()
            init<LogChopper>()
            init<LootTrackerPlugin>()
            init<LowDetailPlugin>()
            init<MenuEntrySwapperPlugin>()
            init<MinimapPlugin>()
            init<MiningPlugin>()
            init<MotherlodePlugin>()
            init<MouseTooltipPlugin>()
            init<MuspahAssist>()
            init<NightmareZoneAFKPlugin>()
            init<NotesPlugin>()
            init<NpcAggroAreaPlugin>()
            init<NpcAttackTimersPlugin>()
            init<NpcIndicatorsPlugin>()
            init<NeverLogoutPlugin>()
            init<NightmareHelper>()
            init<ObjectHiderPlugin>()
            init<ObjectIndicatorsPlugin>()
            //init<OneClick>()
            init<OneClick3t4g>()
            init<OneClick3TFishPlugin>()
            init<OneClickAerialFishingPlugin>()
            init<OneClickAgilityPlugin>()
            init<OneClickBlackjackPlugin>()
            init<Oneclickchinsplugin>()
            init<OneClickGlassblowingPlugin>()
            init<OneClickFurnacePlugin>()
            init<OneClickKarambwansPlugin>()
            init<OneClickSandstonePlugin>()
            init<OpponentInfoPlugin>()
            init<OlmSwapperPlugin>()
            init<PestControlPlugin>()
            init<PlayerOutlinePlugin>()
            init<PoisonPlugin>()
            init<PrivateServerPlugin>()
            init<PuzzleSolverPlugin>()
            init<PvPKeys>()
            init<PrayerFlickerPlugin>()
            init<PrayerPotDrinker>()
            init<QuestHelperPlugin>()
            init<ReportButtonPlugin>()
            init<RunepouchPlugin>()
            init<RsnHiderPlugin>()
            init<SlayerPlugin>()
            init<SpecBarPlugin>()
            init<StatusBarsPlugin>()
            init<StretchedModePlugin>()
            init<TileIndicatorsPlugin>()
            init<TilemanModePlugin>()
            init<ThrallsPlugin>()
            init<TimersPlugin>()
            init<TimestampPlugin>()
            init<TithePlugin>()
            init<VirtualLevelsPlugin>()
            init<WineMakerPlugin>()
            init<WorldMapPlugin>()
            init<WorldMapWalkerPlugin>()
            init<WintertodtHelper>()
            init<XpTrackerPlugin>()
            init<ZulrahPlugin>()
        }
    }

    private fun loadExternal(jar: File) {
        val manifest: Manifest? = getManifest(jar)
        manifest?.let { initExternalPlugin(jar, manifest) }
    }

    fun loadExternalPlugins() {
        val timer = StopWatch()

        if (!externalsDir.exists())
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

                            try
                            {
                                var cl = classLoaders.remove(plugin.getName());
                                cl?.close();

                            }catch (e: Exception)
                            {
                                logger.error("Failed to close class loader for " + plugin.getName())
                                e.printStackTrace();
                            }

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

    private fun initExternalPlugin(jar: File, manifest: Manifest) {
        try {
            var cl = URLClassLoader(arrayOf(jar.toURI().toURL()));
            val plugin =
                    cl.loadClass(manifest.mainAttributes.getValue("Main-Class")).getDeclaredConstructor()
                        .newInstance() as Plugin
                if (plugins.any { p -> p.getName().equals(plugin.getName()) })
                    throw RuntimeException("Duplicate plugin (${plugin.getName()}) not allowed")

                if (ConfigManager.getConfiguration(
                        plugin.javaClass.simpleName,
                        "pluginEnabled"
                    ) != null && plugin.javaClass.getAnnotation(PluginDescriptor::class.java)!!.disabledOnStartup
                )
                    ConfigManager.setConfiguration(plugin.javaClass.simpleName, "pluginEnabled", false)

                plugins.add(plugin)
                classLoaders[plugin.getName()] = cl;
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