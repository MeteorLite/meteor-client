@file:Suppress("DEPRECATION")

package meteor.plugins.muspahassist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.hoot.api.game.GameThread
import eventbus.events.*
import meteor.api.Items
import meteor.api.NPCs
import meteor.config.ConfigManager
import meteor.game.ItemVariationMapping
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.composables.preferences.secondColor
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
            Spacer(Modifier.height(10.dp))
            Text(
                style = (TextStyle(fontSize = 12.sp)),
                text = "EQUIP YOUR GEAR AND CLICK THE BUTTON",
                color = secondColor.value,
                textAlign = TextAlign.Center)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(10.dp))
                Button(
                    modifier = Modifier.size(200.dp, 40.dp),
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
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = surface
                    )
                ) {
                    Text("Copy Range Gear", color = uiColor.value)
                }
            }
        }
    }

    fun mageGearButton() : @Composable () -> Unit? {
        return {
            Spacer(Modifier.height(10.dp))
            Text(
                style = (TextStyle(fontSize = 12.sp)),
                text = "EQUIP YOUR GEAR AND CLICK THE BUTTON",
                color = secondColor.value,
                textAlign = TextAlign.Center)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(10.dp))
                Button(
                    modifier = Modifier.size(200.dp, 40.dp),
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
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = surface
                    )
                ) {
                    Text("Copy Mage Gear", color = uiColor.value)
                }
            }
        }
    }

    fun shieldGearButton() : @Composable () -> Unit? {
        return {
            Spacer(Modifier.height(10.dp))
            Text(
                style = (TextStyle(fontSize = 12.sp)),
                text = "EQUIP YOUR GEAR AND CLICK THE BUTTON",
                color = secondColor.value,
                textAlign = TextAlign.Center)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(10.dp))
                Button(
                    modifier = Modifier.size(200.dp, 40.dp),
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
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = surface
                    )
                ) {
                    Text("Copy Shield Gear", color = uiColor.value)
                }
            }
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
    var smiteEndTime = 0L
    override fun onGameTick(it: GameTick) {
        protectMelee()
        if (System.currentTimeMillis() < smiteEndTime) return
        val shieldMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true)
        if (shieldMuspah != null) {
            if (client.isPrayerActive(Prayer.SMITE) && config.smiteToggle()) {
                smiteEndTime = System.currentTimeMillis() + 1800
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MELEE)) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
        }
        if (shieldMuspah == null && client.isPrayerActive(Prayer.SMITE)){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
    }
    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        when (npc.id) {
            NpcID.PHANTOM_MUSPAH -> equipRangeGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
            NpcID.PHANTOM_MUSPAH_12078 -> equipMageGear().also { activatePrayer(config.mageOffensivePrayer().prayer) }
            NpcID.PHANTOM_MUSPAH_12080 -> equipRangeGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
            NpcID.PHANTOM_MUSPAH_12079 -> equipShieldGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
        }
    }
    override fun onNpcSpawned(it: NpcSpawned) {
        val npc: NPC = it.npc
        when (npc.id) {
            (NpcID.PHANTOM_MUSPAH_12078) -> equipMageGear().also { activatePrayer(config.mageOffensivePrayer().prayer) }
            (NpcID.PHANTOM_MUSPAH) -> equipRangeGear().also { activatePrayer(config.rangeOffensivePrayer().prayer) }
        }
    }
    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer == null || it.actor.name == null || !it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah"))
            return
        val animation = it.actor.animation
        val isPhantomMuspah = it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")
        val hasNoMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) == null
        when (isPhantomMuspah) {
            (animation == 9918) -> activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            (animation == -1 && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            (animation == -1 && hasNoMuspah) -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            else -> {}
        }
    }
    override fun onProjectileSpawned(it: ProjectileSpawned) {
        val projectile: Projectile = it.projectile
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_RANGE_ATTACK && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null && config.smiteToggle()) {
            activatePrayer(Prayer.SMITE)
        }
    }
    private fun protectMelee() {
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null) return
            activatePrayer(Prayer.PROTECT_FROM_MELEE)
            val prayer = if (config.rangeOnly()) {
                config.rangeOffensivePrayer().prayer
            } else {
                config.mageOffensivePrayer().prayer
            }
            activatePrayer(prayer)
    }
    private fun equipMageGear(){
        ClientThread.invokeLater {
            mageGear.forEach {
                Items.getFirst(it)?.interact(2)
            }
        }
    }
    private fun equipRangeGear(){
        ClientThread.invokeLater {
            rangeGear.forEach {
                Items.getFirst(it)?.interact(2)
            }
        }
    }
    private fun equipShieldGear(){
        ClientThread.invokeLater {
            shieldGear.forEach {
                Items.getFirst(it)?.interact(2)
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
        clientThread.invoke {
            client.invokeMenuAction(
                "Activate",
                prayerWidget.name,
                1,
                MenuAction.CC_OP.id,
                prayerWidget.itemId,
                prayerWidget.id
            )
        }
    }
}