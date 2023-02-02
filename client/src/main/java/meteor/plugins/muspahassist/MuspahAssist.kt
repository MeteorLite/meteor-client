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
class MuspahAssist : Plugin() {
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
                    icon = { Icon(TablerIcons.Copy,"", tint = uiColor.value)},
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
                    text = { Text("Copy Range Gear",
                        color = uiColor.value) },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),)
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
                    icon = { Icon(TablerIcons.Copy,"", tint = uiColor.value)},
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
                    text = { Text("Copy Mage Gear",
                        color = uiColor.value) },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),)
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
                    icon = { Icon(TablerIcons.Copy,"", tint = uiColor.value)},
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
                    text = { Text("Copy Shield Gear",
                        color = uiColor.value) },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),)
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
    private var tickTimestampIndex = 0
    private val tickTimestamps = mutableListOf<Long>()
    private var gameTick = 0
    private var lastTick: Long = 0
    override fun onGameTick(it: GameTick) {
        rangePhase()
        meleePhase()
        shieldPhase()
    }
    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        when (npc.id) {
            NpcID.PHANTOM_MUSPAH_12080 -> equipRangeGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
            NpcID.PHANTOM_MUSPAH_12079 -> equipShieldGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
        }
    }
    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer == null || it.actor.name == null || !it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah"))
            return
        val animation = it.actor.animation
        val normalMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) == null
        val specialMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true)
        when (it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")) {
            (animation == 9918 && specialMuspah != null && config.smiteToggle() && !client.isPrayerActive(Prayer.SMITE)) -> activatePrayer(Prayer.SMITE)
            (animation == 9918 && normalMuspah) -> activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            (animation == -1 && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == -1 && normalMuspah) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == 9941 && client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)) -> deactivatePrayer(Prayer.PROTECT_FROM_MISSILES).also { deactivatePrayer(config.rangeOffensivePrayer().prayer) }
            (animation == 9941 && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) -> deactivatePrayer(Prayer.PROTECT_FROM_MAGIC).also { deactivatePrayer(config.rangeOffensivePrayer().prayer) }
            else -> {}
        }
    }
    override fun onProjectileSpawned(it: ProjectileSpawned) {
        val projectile: Projectile = it.projectile
        var ticksRemaining = projectile.remainingCycles / 30
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_RANGE_ATTACK && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null && config.smiteToggle()) {
            activatePrayer(Prayer.SMITE)
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null && projectile.id == ProjectileID.PHANTOM_MUSPAH_MAGE_ATTACK && ticksRemaining == 1) {
            activatePrayer(Prayer.PROTECT_FROM_MAGIC)
        }
    }
    private fun meleePhase() {
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null) return
        if (!config.rangeOnly()){
            equipMageGear()
        }
        activatePrayer(Prayer.PROTECT_FROM_MELEE)
        activatePrayer(if (config.rangeOnly()) { config.rangeOffensivePrayer().prayer } else { config.mageOffensivePrayer().prayer })
    }
    private fun rangePhase(){
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH,true,true) == null) return
        equipRangeGear()
        activatePrayer(config.rangeOffensivePrayer().prayer)
    }
    private fun shieldPhase(){
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) == null) {
            if (client.isPrayerActive(Prayer.SMITE)) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
            return
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null) {
            updateTickTimestamps()
            lastTick = getCurrentMinTickTimestamp()
            gameTick++

            if (client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES) ||
                client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) {
                gameTick = 0
            }
            if (gameTick == 4) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MELEE)) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
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
    private fun getCurrentMinTickTimestamp(): Long {
        var min: Long = 0
        for (i in tickTimestamps.indices) {
            min = if (min == 0L) {
                tickTimestamps[i] + 600 * ((tickTimestampIndex - i + 5) % 5)
            } else {
                Math.min(min, tickTimestamps[i] + 600 * ((tickTimestampIndex - i + 5) % 5))
            }
        }
        return min
    }
    private fun updateTickTimestamps() {
        if (tickTimestamps.size <= tickTimestampIndex) {
            tickTimestamps.add(System.currentTimeMillis())
        } else {
            tickTimestamps.set(tickTimestampIndex, System.currentTimeMillis())
        }
        tickTimestampIndex = (tickTimestampIndex + 1) % 5
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