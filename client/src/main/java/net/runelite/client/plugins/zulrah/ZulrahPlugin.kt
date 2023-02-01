package net.runelite.client.plugins.zulrah

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.common.base.Preconditions
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.GameThread
import dev.hoot.api.widgets.Prayers
import eventbus.events.*
import meteor.Logger
import meteor.api.ClientPackets
import meteor.api.Items.getFirst
import meteor.api.Objects
import meteor.config.ConfigManager
import meteor.game.ItemVariationMapping
import meteor.game.SkillIconManager
import meteor.game.SpriteManager
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.rs.ClientThread.invokeLater
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.updateStringValue
import meteor.ui.overlay.infobox.Counter
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.util.ImageUtil.loadImageResource
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.client.plugins.zulrah.overlays.*
import net.runelite.client.plugins.zulrah.rotationutils.RotationType
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahData
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahPhase
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
    init {
        setConfigComposable("znzulrah", "copyRangeGearPanel", copyRangeGearButton())
        setConfigComposable("znzulrah", "copyMageGearPanel", copyMageGearButton())
    }

    private val config = configuration<ZulrahConfig>(ZulrahConfig::class.java)
    private val keyManager = KeyManager
    private val infoBoxManager = InfoBoxManager
    private val clientThread = ClientThread
    private val instanceTimerOverlay = InstanceTimerOverlay(this, config)
    private val phaseOverlay = PhaseOverlay(this, config)
    private val prayerHelperOverlay = PrayerHelperOverlay(client, this, config, SpriteManager)
    private val prayerMarkerOverlay = PrayerMarkerOverlay(client, this, config)
    private val sceneOverlay = SceneOverlay(client, this, config, SkillIconManager)
    private val mageGear: List<String>
        get() {
            val mageIDs = config.MageIDs().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return listOf(*mageIDs)
        }
    private val rangeGear: List<String>
        get() {
            val rangeIDs = config.RangeIDs().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return listOf(*rangeIDs)
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

    fun appendVariations(item: Item, sb: StringBuilder) {
        val mainID = ItemVariationMapping.map(item.id)
        val variations = ItemVariationMapping.getVariations(item.id)
        if (mainID != -1) {
            for (itemId in ItemVariationMapping.getVariations(mainID)) {
                val itemName = GameThread.invokeLater { client.getItemDefinition(itemId).name }
                if (itemName != null) {
                    sb.append(itemName)
                    sb.append(",")
                }
            }
        }
        else if (variations.isNotEmpty()) {
            for (itemId in variations) {
                val itemName = GameThread.invokeLater { client.getItemDefinition(itemId).name }
                if (itemName != null) {
                    sb.append(itemName)
                    sb.append(",")
                }
            }
        } else {
            sb.append(item.name)
            sb.append(",")
        }
    }

    fun copyMageGearButton() : @Composable () -> Unit? {
        return {
            Spacer(Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    modifier = Modifier.size(165.dp, 40.dp),
                    onClick = {
                        val i: ItemContainer? = client.getItemContainer(InventoryID.EQUIPMENT)
                        val sb = StringBuilder()

                        clientThread.invoke {
                            i?.items?.forEach {
                                if (it.id == -1 || it.id == 0) {
                                    return@forEach
                                }
                                appendVariations(it, sb)
                            }
                            ConfigManager.setConfiguration("znzulrah", "MageIDs", sb.toString())
                            updateStringValue("znzulrah", "MageIDs", sb.toString())
                        }
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = surface
                    )
                ) {
                    Text("Copy Mage Gear", color = uiColor.value)
                }
            }
        }
    }

    fun copyRangeGearButton() : @Composable () -> Unit? {
        return {
            Spacer(Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    modifier = Modifier.size(165.dp, 40.dp),
                    onClick = {
                        val i: ItemContainer? = client.getItemContainer(InventoryID.EQUIPMENT)
                        val sb = StringBuilder()

                        clientThread.invoke {
                            i?.items?.forEach {
                                if (it.id == -1 || it.id == 0) {
                                    return@forEach
                                }
                                appendVariations(it, sb)
                            }
                            ConfigManager.setConfiguration("znzulrah", "RangeIDs", sb.toString())
                            updateStringValue("znzulrah", "RangeIDs", sb.toString())
                        }
                    },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = surface
                    )
                ) {
                    Text("Copy Range Gear", color = uiColor.value)
                }
            }
        }
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

    override fun onClientTick(it: ClientTick) {
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

    fun getActivePrayers(): List<Prayer> {
        return Prayer.values().filter { Prayers.isEnabled(it) }
    }

    private var firstJadAttack = false
    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN || zulrahNpc == null || Objects.getFirst(11699) == null) {
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

            if (zulrahNpc?.isDead == false) {
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
                    ClientPackets.queueClickPacket(invRecoil.clickPoint)
                    needsRecoil = false
                }
            }
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.message.contains("Your Ring of Recoil has shattered.")) {
            needsRecoil = true
        }
        if (it.message.contains("Your Zulrah kill count is")) {
            for (prayer in getActivePrayers()) {
                val widget = client.getWidget(prayer.widgetInfo)
                widget?.let {
                    deactivatePrayer(prayer)
                }
            }
        }
    }

    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        if (config.offensivePrayerToggle()) {
            when (npc.id) {
                (NpcID.ZULRAH_2044) -> activatePrayer(config.offensiveRangePrayer().prayer)
                (NpcID.ZULRAH) -> activatePrayer(config.offensiveMagePrayer().prayer)
                (NpcID.ZULRAH_2043) -> activatePrayer(config.offensiveMagePrayer().prayer)
            }
        }
        if (config.gearToggle()) {
            when (npc.id){
                (NpcID.ZULRAH_2044) -> equipRangeGear()
                (NpcID.ZULRAH) -> equipMageGear()
                NpcID.ZULRAH_2043 -> equipMageGear()
            }
        }
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc: NPC = it.npc
        if (config.offensivePrayerToggle()){
            when (npc.id) {
                (NpcID.ZULRAH) -> activatePrayer(config.offensiveMagePrayer().prayer)
            }
        }
        if (config.gearToggle()){
            when (npc.id) {
                (NpcID.ZULRAH) -> equipMageGear()
            }
        }
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        if (it.actor !is NPC) {
            return
        }
        val npc = it.actor as NPC
        if (!npc.name.equals("zulrah", ignoreCase = true)) {
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
                .zulrahNpc.isJad && config.autoPray()
        ) { //Mage attack and Jad
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (it.projectile.id == 1044 && currentRotation != null && getCurrentPhase(currentRotation)!!
                .zulrahNpc.isJad && config.autoPray()
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
                                type
                            ), getNextPhase(type)
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
            mageGear.forEach { id ->
                getFirst(id)?.let {
                    it.interact(2)
                    ClientPackets.queueClickPacket(it.clickPoint)
                }
            }
        }
    }

    private fun equipRangeGear() {
        invokeLater {
            for (id in rangeGear) {
                getFirst(id)?.let {
                    it.interact(2)
                    ClientPackets.queueClickPacket(it.clickPoint)
                }
            }
        }
    }

    fun deactivatePrayer(prayer: Prayer) {

        val widgetInfo = prayer.widgetInfo ?: return
        val prayerWidget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }

        ClientPackets.createClientPacket(AutomatedMenu(1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id))!!.send()
        ClientPackets.queueClickPacket(prayerWidget.clickPoint)
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
        val prayerWidget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }

        ClientPackets.createClientPacket(AutomatedMenu(1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id))!!.send()
        ClientPackets.queueClickPacket(prayerWidget.clickPoint)
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