package net.runelite.client.plugins.zulrah

import com.google.common.base.Preconditions
import eventbus.events.*
import meteor.Logger
import meteor.Main
import meteor.api.Items
import meteor.api.Items.getFirst
import meteor.game.SkillIconManager
import meteor.game.SpriteManager
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.rs.ClientThread.invoke
import meteor.rs.ClientThread.invokeLater
import meteor.ui.overlay.OverlayManager
import meteor.ui.overlay.infobox.Counter
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.util.ImageUtil.loadImageResource
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.plugins.zulrah.overlays.*
import net.runelite.client.plugins.zulrah.rotationutils.RotationType
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahData
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahPhase
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.*
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.stream.Collectors

@PluginDescriptor(
    name = "Zulrah Assist",
    description = "All-in-One tool to help during the Zulrah fight",
    tags = ["zulrah", "zul", "andra", "snakeling", "zhuri/nicole", "girls rule boys drool"],
    enabledByDefault = false
)
class ZulrahPlugin : Plugin(), KeyListener {
    private val config = configuration<ZulrahConfig>(ZulrahConfig::class.java)
    private val keyManager = KeyManager
    private val infoBoxManager = InfoBoxManager
    private val clientThread = ClientThread
    private val instanceTimerOverlay = InstanceTimerOverlay(this, config)
    private val phaseOverlay = PhaseOverlay(this, config)
    private val prayerHelperOverlay = PrayerHelperOverlay(client, this, config, SpriteManager)
    private val prayerMarkerOverlay = PrayerMarkerOverlay(client, this, config)
    private val sceneOverlay = SceneOverlay(client, this, config, SkillIconManager)
    val mageGear: List<String>
        get() {
            val mageIDs = config.MageIDs().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return Arrays.asList(*mageIDs)
        }
    val rangeGear: List<String>
        get() {
            val rangeIDs = config.RangeIDs().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return Arrays.asList(*rangeIDs)
        }
    var zulrahNpc: NPC? = null
        private set
    private var stage = 0
    var phaseTicks = -1
        private set
    var attackTicks = -1
        private set
    private var totalTicks = 0
    var currentRotation: RotationType? = null
        private set
    private var potentialRotations: MutableList<RotationType> = ArrayList<RotationType>()
    private val projectilesMap: MutableMap<LocalPoint?, Int> = HashMap<LocalPoint?, Int>()
    private val toxicCloudsMap: MutableMap<GameObject?, Int> = HashMap<GameObject?, Int>()
    private val snakelings: MutableCollection<Renderable> = ArrayList<Renderable>()
    private var holdingSnakelingHotkey = false
    private var zulrahTotalTicksInfoBox: Counter? = null
    private var needsRecoil = false
    private val phaseTicksHandler = BiConsumer { current: RotationType?, potential: RotationType? ->
        phaseTicks = if (isZulrahReset) {
            38
        } else {
            val p = current?.let { getCurrentPhase(it) } ?: getCurrentPhase(potential)
            Preconditions.checkNotNull(
                p,
                "Attempted to set phase ticks but current Zulrah phase was somehow null. Stage: $stage"
            )
            p!!.attributes.phaseTicks
        }
    }

    override fun onStart() {
        log.info("Startup")
        overlayManager.add(instanceTimerOverlay)
        overlayManager.add(phaseOverlay)
        overlayManager.add(prayerHelperOverlay)
        overlayManager.add(prayerMarkerOverlay)
        overlayManager.add(sceneOverlay)
        keyManager.registerKeyListener(this, javaClass)
    }

    override fun onStop() {
        reset()
        overlayManager.remove(instanceTimerOverlay)
        overlayManager.remove(phaseOverlay)
        overlayManager.remove(prayerHelperOverlay)
        overlayManager.remove(prayerMarkerOverlay)
        overlayManager.remove(sceneOverlay)
        keyManager.unregisterKeyListener(this)
    }

    fun reset() {
        zulrahNpc = null
        stage = 0
        phaseTicks = -1
        attackTicks = -1
        totalTicks = 0
        currentRotation = null
        potentialRotations.clear()
        projectilesMap.clear()
        toxicCloudsMap.clear()
        isFlipStandLocation = false
        isFlipPhasePrayer = false
        instanceTimerOverlay.resetTimer()
        isZulrahReset = false
        clearSnakelingCollection()
        holdingSnakelingHotkey = false
        handleTotalTicksInfoBox(true)
        //log.info("Zulrah Reset!");
    }

    override fun keyTyped(e: KeyEvent) {}
    override fun keyPressed(e: KeyEvent) {
        if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) {
            holdingSnakelingHotkey = true
        }
    }

    override fun keyReleased(e: KeyEvent) {
        if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) {
            holdingSnakelingHotkey = false
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group.equals("znzulrah", ignoreCase = true)) {
            when (it.key) {
                "snakelingSetting" -> {
                    if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.ENTITY) {
                        clearSnakelingCollection()
                    }
                    if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES)
                        holdingSnakelingHotkey = false
                }

                "totalTickCounter" -> {
                    if (config.totalTickCounter())
                        handleTotalTicksInfoBox(true)
                }
            }
        }
    }

    private fun clearSnakelingCollection() {
        snakelings.forEach(Consumer { npc: Renderable? -> setHidden(npc, false) })
        snakelings.clear()
    }

    override fun onClientTick(event: ClientTick) {
        val gear = client.getWidget(WidgetInfo.EQUIPMENT.id)
        val mousePoint = client.mouseCanvasPosition
        if (gear != null && gear.isVisible) {
            val bounds = gear.bounds
            if (bounds.contains(mousePoint.x, mousePoint.y)) {
                client.insertMenuItem(
                    "<col=00FFFF>Copy Gear</col>",
                    "",
                    MenuAction.RUNELITE.id,
                    InventoryID.EQUIPMENT.id,
                    0,
                    0,
                    false
                )
            }
        }
        if (client.gameState != GameState.LOGGED_IN || zulrahNpc == null) {
            return
        }
        if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.ENTITY) {
            snakelings.addAll(
                client.npcs.stream().filter { npc: NPC? ->
                    npc != null && npc.name != null && npc.name.equals(
                        "snakeling",
                        ignoreCase = true
                    ) && npc.combatLevel == 90
                }
                    .collect(Collectors.toList()))
            snakelings.forEach(Consumer { npc: Renderable? -> setHidden(npc, true) })
        }
    }

    private var firstJadAttack = false
    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN || zulrahNpc == null) {
            return
        }
        ++totalTicks
        if (attackTicks >= 0) {
            --attackTicks
        }
        if (phaseTicks >= 0) {
            --phaseTicks
        }
        if (projectilesMap.size > 0) {
            projectilesMap.values.removeIf { v: Int? -> v!! <= 0 }
            projectilesMap.replaceAll { k: LocalPoint?, v: Int? -> v!! - 1 }
        }
        if (toxicCloudsMap.size > 0) {
            toxicCloudsMap.values.removeIf { v: Int? -> v!! <= 0 }
            toxicCloudsMap.replaceAll { k: GameObject?, v: Int? -> v!! - 1 }
        }
        handleTotalTicksInfoBox(false)
        if (zulrahNpc != null && config.autoPray()) {
            var jad = false
            var prayer: Prayer? = null
            for (data in zulrahData) {
                if (!data.currentPhasePrayer.isPresent) {
                    continue
                }
                prayer = data.currentPhasePrayer.get()
                jad = data.isJad
            }
            if (prayer != null && !jad) {
                activatePrayer(prayer)
            }
            if (jad && !firstJadAttack) {
                firstJadAttack = true
                activatePrayer(prayer)
            }
        }
        if (config.autoRingOfRecoil()) {
            val invRecoil = getFirst("Ring of recoil", InventoryID.INVENTORY)
            if (needsRecoil && invRecoil != null) {
                invRecoil.interact("Wear")
                needsRecoil = false
            }
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.message.contains("Your Ring of Recoil has shattered.")) {
            needsRecoil = true
        }
    }

    override fun onNpcChanged(npcCompositionChanged: NpcChanged) {
        val npc = npcCompositionChanged.npc
        if (config.offensivePrayerToggle()) {
            if (npc.id == NpcID.ZULRAH_2044) {
                activatePrayer(config.offensiveRangePrayer().prayer)
                equipRangeGear()
            } else {
                activatePrayer(config.offensiveMagePrayer().prayer)
                equipMageGear()
            }
        }
    }

    override fun onNpcSpawned(npcSpawned: NpcSpawned) {
        val npc = npcSpawned.npc
        if (npc.id == NpcID.ZULRAH) {
            if (npc.id == NpcID.ZULRAH) {
                activatePrayer(config.offensiveMagePrayer().prayer)
                equipMageGear()
            }
        }
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        if (it.actor !is NPC) {
            return
        }
        val npc = it.actor as NPC
        if (npc.name != null && !npc.name.equals("zulrah", ignoreCase = true)) {
            return
        }
        when (npc.animation) {
            5071 -> {
                zulrahNpc = npc
                instanceTimerOverlay.setTimer()
                potentialRotations = RotationType.findPotentialRotations(npc, stage)
                phaseTicksHandler.accept(currentRotation, potentialRotations[0])
                log.debug("New Zulrah Encounter Started")
            }

            5073 -> {
                ++stage
                if (currentRotation == null) {
                    potentialRotations = RotationType.findPotentialRotations(npc, stage)
                    currentRotation = if (potentialRotations.size == 1) potentialRotations[0] else null
                }
                phaseTicksHandler.accept(currentRotation, potentialRotations[0])
            }

            5072 -> {
                if (isZulrahReset) {
                    isZulrahReset = false
                }
                if (currentRotation == null || !isLastPhase(currentRotation))
                    return
                stage = -1
                currentRotation = null
                potentialRotations.clear()
                snakelings.clear()
                isFlipStandLocation = false
                isFlipPhasePrayer = false
                isZulrahReset = true
                firstJadAttack = false
                log.debug("Resetting Zulrah")
            }

            5069 -> {
                attackTicks = 4
                if (currentRotation == null || !getCurrentPhase(currentRotation)!!.zulrahNpc.isJad || zulrahNpc!!.interacting !== client.localPlayer)
                    return
                isFlipPhasePrayer = !isFlipPhasePrayer
            }

            5806, 5807 -> {
                attackTicks = 8
                isFlipStandLocation = !isFlipStandLocation
            }

            5804 -> {
                reset()
            }
        }
    }

    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused) {
            holdingSnakelingHotkey = false
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        val menuOption = it.getMenuOption()
        if (menuOption != null && menuOption.contains("<col=00FFFF>Copy Gear</col>")) {
            val i = client.getItemContainer(InventoryID.EQUIPMENT) ?: return
            val sb = StringBuilder()
            for (item in i.items) {
                if (item.id == -1 || item.id == 0) {
                    continue
                }
                sb.append(item.name)
                sb.append(",")
            }
            Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(sb.toString()), null)
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.MES || zulrahNpc == null || zulrahNpc!!.isDead) {
            return
        }
        if (!holdingSnakelingHotkey && it.target!!.contains("Snakeling") && it.option.equals(
                "attack",
                ignoreCase = true
            )
        ) {
            val npc = client.cachedNPCs[it.identifier] ?: return
            client.menuEntries = Arrays.copyOf(client.menuEntries, client.menuEntries.size - 1)
        }
    }

    override fun onProjectileMoved(it: ProjectileMoved) {
        if (zulrahNpc == null) {
            return
        }
        val p = it.projectile
        when (p.id) {
            1045, 1047 -> {
                projectilesMap[it.position] = p.remainingCycles / 30
            }
        }
        if (it.projectile.id == 1046 && currentRotation != null && getCurrentPhase(currentRotation)!!
                .zulrahNpc.isJad
        ) { //Mage attack and Jad
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (it.projectile.id == 1044 && currentRotation != null && getCurrentPhase(currentRotation)!!
                .zulrahNpc.isJad
        ) { //Range attack and Jad
            activatePrayer(Prayer.PROTECT_FROM_MAGIC)
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        if (zulrahNpc == null) {
            return
        }
        val obj = it.gameObject
        if (obj.id == 11700) {
            toxicCloudsMap[obj] = 30
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (zulrahNpc == null) {
            return
        }
        when (it.gameState) {
            GameState.LOADING, GameState.CONNECTION_LOST, GameState.HOPPING -> {
                reset()
            }
            else -> {}
        }
    }

    private fun getCurrentPhase(type: RotationType?): ZulrahPhase? {
        return if (type != null) if (stage >= type.zulrahPhases.size) null else type.zulrahPhases[stage] else null
    }

    private fun getNextPhase(type: RotationType?): ZulrahPhase? {
        return if (isLastPhase(type)) null else type!!.zulrahPhases[stage + 1]
    }

    private fun isLastPhase(type: RotationType?): Boolean {
        return stage == type!!.zulrahPhases.size - 1
    }

    val zulrahData: Set<ZulrahData>
        get() {
            val zulrahDataSet = LinkedHashSet<ZulrahData>()
            if (currentRotation == null) {
                potentialRotations.forEach(Consumer { type: RotationType? ->
                    zulrahDataSet.add(
                        ZulrahData(
                            getCurrentPhase(
                                type as RotationType?
                            ), getNextPhase(type as RotationType?)
                        )
                    )
                })
            } else {
                zulrahDataSet.add(ZulrahData(getCurrentPhase(currentRotation), getNextPhase(currentRotation)))
            }
            return if (zulrahDataSet.size > 0) zulrahDataSet else emptySet()
        }

    private fun handleTotalTicksInfoBox(remove: Boolean) {
        if (remove) {
            infoBoxManager.removeInfoBox(zulrahTotalTicksInfoBox)
            zulrahTotalTicksInfoBox = null
        } else if (config.totalTickCounter()) {
            if (zulrahTotalTicksInfoBox == null) {
                zulrahTotalTicksInfoBox = Counter(CLOCK_ICON, this, totalTicks)
                zulrahTotalTicksInfoBox!!.tooltip = "Total Ticks Alive"
                infoBoxManager.addInfoBox(zulrahTotalTicksInfoBox!!)
            } else {
                zulrahTotalTicksInfoBox!!.setCount(totalTicks)
            }
        }
    }

    fun getProjectilesMap(): Map<LocalPoint?, Int?> {
        return projectilesMap
    }

    fun getToxicCloudsMap(): Map<GameObject?, Int?> {
        return toxicCloudsMap
    }

    private fun equipMageGear() {
        invokeLater {
            mageGear.forEach {
                getFirst(it)?.interact(2)
            }
        }
    }

    private fun equipRangeGear() {
        invokeLater {
            for (id in rangeGear) {
                getFirst(id)?.interact(2)
            }
        }
    }

    fun activatePrayer(prayer: Prayer?) {
        if (prayer == null) {
            return
        }

        //check if prayer is already active this tick
        if (client.isPrayerActive(prayer)) {
            return
        }
        val widgetInfo = prayer.widgetInfo ?: return
        val prayer_widget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        clientThread.invoke {
            client.invokeMenuAction(
                "Activate",
                prayer_widget.name,
                1,
                MenuAction.CC_OP.id,
                prayer_widget.itemId,
                prayer_widget.id
            )
        }
    }

    companion object {
        var log = Logger("Zulrah")
        var isFlipStandLocation = false
            private set
        var isFlipPhasePrayer = false
            private set
        var isZulrahReset = false
            private set
        val ZULRAH_IMAGES = arrayOfNulls<BufferedImage>(3)
        private val CLOCK_ICON = loadImageResource(ZulrahPlugin::class.java, "clock.png")
        private fun setHidden(renderable: Renderable?, hidden: Boolean) {
            var setHidden: Method? = null
            setHidden = try {
                renderable!!.javaClass.getMethod("setHidden", java.lang.Boolean.TYPE)
            } catch (e: NoSuchMethodException) {
                log.debug("Couldn't find method setHidden for class {}", renderable!!.javaClass)
                return
            }
            try {
                setHidden?.invoke(renderable, hidden)
            } catch (e: IllegalAccessException) {
                log.debug("Couldn't call method setHidden for class {}", renderable.javaClass)
            } catch (e: InvocationTargetException) {
                log.debug("Couldn't call method setHidden for class {}", renderable.javaClass)
            }
        }

        init {
            ZULRAH_IMAGES[0] = loadImageResource(ZulrahPlugin::class.java, "zulrah_range.png")
            ZULRAH_IMAGES[1] = loadImageResource(ZulrahPlugin::class.java, "zulrah_melee.png")
            ZULRAH_IMAGES[2] = loadImageResource(ZulrahPlugin::class.java, "zulrah_magic.png")
        }
    }
}