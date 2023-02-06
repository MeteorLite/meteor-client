@file:Suppress("DEPRECATION")

package meteor.plugins.muspahassist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.Copy
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.GameThread
import dev.hoot.api.widgets.Prayers
import eventbus.events.*
import meteor.api.ClientPackets
import meteor.api.Items
import meteor.api.NPCs
import meteor.config.ConfigManager
import meteor.game.ItemVariationMapping
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.updateStringValue
import net.runelite.api.*
import java.util.*


@PluginDescriptor(name = "Muspah Assist", description = "Auto prays for you at muspah", enabledByDefault = false)
class MuspahAssist() : Plugin() {
    init {
        setConfigComposable("muspahassist", "rangeGearButton", rangeGearButton())
        setConfigComposable("muspahassist", "mageGearButton", mageGearButton())
        setConfigComposable("muspahassist", "shieldGearButton", shieldGearButton())
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

    fun rangeGearButton() : @Composable () -> Unit? {
        return {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(10.dp))
                ExtendedFloatingActionButton(
                    modifier = Modifier.size(200.dp, 40.dp),
                    icon = { Icon(TablerIcons.Copy, "", tint = uiColor.value) },
                    shape = RoundedCornerShape(6.dp),
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
                            ConfigManager.setConfiguration("muspahassist", "RangeIDs", sb.toString())
                            updateStringValue("muspahassist", "RangeIDs", sb.toString())
                        }
                    },
                    backgroundColor = surface,
                    text = {
                        Text(
                            "Copy Range Gear",
                            color = uiColor.value
                        )
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                )
            }
            Spacer(Modifier.height(5.dp))
        }
    }

    fun mageGearButton() : @Composable () -> Unit? {
        return {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(5.dp))
                ExtendedFloatingActionButton(
                    modifier = Modifier.size(200.dp, 40.dp),
                    icon = { Icon(TablerIcons.Copy, "", tint = uiColor.value) },
                    shape = RoundedCornerShape(6.dp),
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
                            ConfigManager.setConfiguration("muspahassist", "MageIDs", sb.toString())
                            updateStringValue("muspahassist", "MageIDs", sb.toString())
                        }
                    },
                    backgroundColor = surface,
                    text = {
                        Text(
                            "Copy Mage Gear",
                            color = uiColor.value
                        )
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                )
            }
            Spacer(Modifier.height(5.dp))
        }
    }

    fun shieldGearButton() : @Composable () -> Unit? {
        return {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(5.dp))
                ExtendedFloatingActionButton(
                    modifier = Modifier.size(200.dp, 40.dp),
                    icon = { Icon(TablerIcons.Copy, "", tint = uiColor.value) },
                    shape = RoundedCornerShape(6.dp),
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
                            ConfigManager.setConfiguration("muspahassist", "shieldIDs", sb.toString())
                            updateStringValue("muspahassist", "shieldIDs", sb.toString())
                        }
                    },
                    backgroundColor = surface,
                    text = {
                        Text(
                            "Copy Shield Gear",
                            color = uiColor.value
                        )
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                )
            }
            Spacer(Modifier.height(5.dp))
        }
    }

    val mageGear: MutableList<String>
        get() = mutableListOf(*config.MageIDs()!!.split(",").toTypedArray())
    val rangeGear: MutableList<String>
        get() = mutableListOf(*config.RangeIDs()!!.split(",").toTypedArray())
    val shieldGear: MutableList<String>
        get() = mutableListOf(*config.ShieldIDs()!!.split(",").toTypedArray())
    private val clientThread = ClientThread
    private var config = configuration<MuspahAssistConfig>()
    private val muspahOverlay = overlay(MuspahAssistOverlay(this, config))
    private var ticks = -1

    override fun onStart() {
        overlayManager.add(muspahOverlay)
    }
    override fun onStop() {
        overlayManager.remove(muspahOverlay)
    }
    override fun onGameTick(it: GameTick) {
        rangePhase()
        meleePhase()
        shieldPhase()
        finalPhase()
        if (ticks >= 0) --ticks
    }
    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        when (npc.id) {
            NpcID.PHANTOM_MUSPAH -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            NpcID.PHANTOM_MUSPAH_12080 -> equipRangeGear().also { if (!client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)) activatePrayer(Prayer.PROTECT_FROM_MISSILES) }
            NpcID.PHANTOM_MUSPAH_12079 -> equipShieldGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }.also { if (!client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)) activatePrayer(Prayer.PROTECT_FROM_MISSILES) }
        }
    }
    override fun onNpcSpawned(it: NpcSpawned) {
        val npc: NPC = it.npc
        if (npc.id == NpcID.PHANTOM_MUSPAH) activatePrayer(Prayer.PROTECT_FROM_MISSILES)
    }
    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer == null || it.actor.name == null || !it.actor.name.equals("phantom muspah",true))
            return
        val animation = it.actor.animation
        val range = NPCs.getFirst(NpcID.PHANTOM_MUSPAH)
        val melee = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078)
        val shield = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079)
        val rangedMuspah = melee == null && shield == null
        val shieldMuspah = shield != null
        val finalMuspah = range == null && melee == null && shield == null
        when (it.actor.name.equals("phantom muspah",true)) {
            (animation == 9918 && shieldMuspah && config.smiteToggle() && !client.isPrayerActive(Prayer.SMITE)) -> activatePrayer(Prayer.SMITE)
            (animation == -1 && shieldMuspah && !config.smiteToggle() && !config.flickPrayer()) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == 9918 && !config.smiteToggle() && !config.flickPrayer()) -> activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            (animation == -1 && rangedMuspah && !config.flickPrayer() && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == -1 && rangedMuspah && !config.flickPrayer()) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == -1 && finalMuspah && !config.flickPrayer() && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == -1 && finalMuspah && !config.flickPrayer()) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == 9918 && range != null) -> ticks = 6
            (animation == 9920 && melee != null) -> ticks = 6
            (animation == 9922 && range != null) -> ticks = 6
            (animation == 9922 && shieldMuspah) -> ticks = 5
            (animation == 9918 && finalMuspah) -> ticks = 5
            (animation == 9922 && finalMuspah) -> ticks = 5
            else -> {}
        }
    }
    override fun onProjectileSpawned(it: ProjectileSpawned) {
        val projectile: Projectile = it.projectile
        var ticksRemaining = projectile.remainingCycles / 30
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_RANGE_ATTACK && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079) != null && config.smiteToggle()) {
            activatePrayer(Prayer.SMITE)
        }
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_MAGE_ATTACK && ticksRemaining == 1 && config.flickPrayer()) {
            activatePrayer(Prayer.PROTECT_FROM_MAGIC)
        }
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_MAGE_ATTACK && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079) != null){
            ticks = 5
        }
    }
    override fun onChatMessage(it: ChatMessage) {
        if (it.message.contains("Your Phantom Muspah kill count is")) {
            for (prayer in getActivePrayers()) {
                val widget = client.getWidget(prayer.widgetInfo)
                widget?.let {
                    deactivatePrayer(prayer)
                }
            }
        }
    }
    fun getTicks(): Int {
        return ticks
    }
    private fun meleePhase() {
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12082) != null && config.tele()) {
            ticks = -1
            equipRangeGear()
            deactivatePrayer(Prayer.PROTECT_FROM_MELEE)
            activatePrayer(config.rangeOffensivePrayer().prayer)
        }

        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078) == null) return
        if (!config.rangeOnly()) {
            equipMageGear()
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12082) == null) {
            activatePrayer(Prayer.PROTECT_FROM_MELEE)
            activatePrayer(
                if (config.rangeOnly()) {
                    config.rangeOffensivePrayer().prayer
                } else {
                    config.mageOffensivePrayer().prayer
                }
            )
        }
    }
    private fun rangePhase(){
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12082) != null && config.tele()) {
            ticks = -1
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
                deactivatePrayer(Prayer.PROTECT_FROM_MISSILES)
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
                deactivatePrayer(Prayer.PROTECT_FROM_MAGIC)
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH) == null) return
        equipRangeGear()
        activatePrayer(config.rangeOffensivePrayer().prayer)
        if (ticks == 1 && config.flickPrayer()){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (ticks > 1 && config.flickPrayer()) {
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
                deactivatePrayer(Prayer.PROTECT_FROM_MISSILES)
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
                deactivatePrayer(Prayer.PROTECT_FROM_MAGIC)
        }
    }
    private fun shieldPhase(){
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079) == null){
            if (client.isPrayerActive(Prayer.SMITE)) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079) != null) {
            if (ticks == 1)
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MELEE))
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
    }
    private fun finalPhase() {
        NPCs.getAll()?.forEach {
            it.transformedComposition
            if (it.transformedId == 12080) {
                if (ticks == 1 && config.flickPrayer())
                    activatePrayer(Prayer.PROTECT_FROM_MISSILES)
                if (ticks > 1 && config.flickPrayer()) {
                    if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES))
                        deactivatePrayer(Prayer.PROTECT_FROM_MISSILES)
                    if (client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC))
                        deactivatePrayer(Prayer.PROTECT_FROM_MAGIC)
                }
            }
        }
    }
    private fun equipMageGear(){
        ClientThread.invokeLater {
            mageGear.forEach {id ->
                Items.getFirst(id)?.let {
                    ClientPackets.queueClickPacket(it.clickPoint)
                    it.interact(2)
                }
            }
        }
    }
    private fun equipRangeGear(){
        ClientThread.invokeLater {
            rangeGear.forEach {id ->
                Items.getFirst(id)?.let {
                 ClientPackets.queueClickPacket(it.clickPoint)
                 it.interact(2)
                }
            }
        }
    }
    private fun equipShieldGear(){
        ClientThread.invokeLater {
            shieldGear.forEach {id ->
                Items.getFirst(id)?.let {
                 ClientPackets.queueClickPacket(it.clickPoint)
                 it.interact(2)
                }
            }
        }
    }
    private fun activatePrayer(prayer: Prayer?) {
        if (prayer == null) {
            return
        }
        if (client.isPrayerActive(prayer)) {
            return
        }
        val widgetInfo = prayer.widgetInfo ?: return
        val prayerWidget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        ClientPackets.queueClickPacket(prayerWidget.clickPoint)
        ClientPackets.createClientPacket(AutomatedMenu(1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id))!!.send()
    }
    fun getActivePrayers(): List<Prayer> {
        return Prayer.values().filter { Prayers.isEnabled(it) }
    }
    private fun deactivatePrayer(prayer: Prayer?) {
        if (prayer == null) {
            return
        }
        if (!client.isPrayerActive(prayer)) {
            return
        }
        val widgetInfo = prayer.widgetInfo ?: return
        val prayerWidget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        ClientPackets.queueClickPacket(prayerWidget.clickPoint)
        ClientPackets.createClientPacket(AutomatedMenu(1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id))!!.send()
    }
}