@file:Suppress("DEPRECATION")

package meteor.plugins.muspahassist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventbus.events.*
import meteor.api.Items
import meteor.api.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.composables.preferences.secondColor
import meteor.ui.composables.preferences.surface
import net.runelite.api.*
import net.runelite.api.widgets.WidgetInfo
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.util.*


@PluginDescriptor(name = "Muspah Assist", description = "Auto prays for you at muspah", enabledByDefault = false)
class MuspahAssist : Plugin() {
    @Composable
    override fun instructions() : @Composable () -> Unit? {
        return {
            Spacer(Modifier.height(10.dp))
            Row(Modifier.heightIn(100.dp).background(color = surface, shape = RoundedCornerShape(3.dp)), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically)  {
                Text(
                    style = (TextStyle(fontSize = 16.sp)),
                    text = "You can copy your equipped gear by right clicking inside the equipment tab and selecting copy gear and then paste it into the appropriate section.",
                    color = secondColor.value,
                    textAlign = TextAlign.Center)
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
        val rangeMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH,true,true)
        if (shieldMuspah != null) {
            if (client.isPrayerActive(Prayer.SMITE) && config.smiteToggle()) {
                smiteEndTime = System.currentTimeMillis() + 2000
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
            if (client.isPrayerActive(Prayer.PROTECT_FROM_MELEE)) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
        } else if (client.isPrayerActive(Prayer.SMITE)) {
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (rangeMuspah != null){
            equipRangeGear()
        }
    }
    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        if (config.gearToggle()) {
            when (npc.id) {
                NpcID.PHANTOM_MUSPAH_12080 -> equipRangeGear()
                NpcID.PHANTOM_MUSPAH_12079 -> equipShieldGear()
            }
        }
    }
    override fun onClientTick(it: ClientTick) {
        val gear = client.getWidget(WidgetInfo.EQUIPMENT.id)
        val mousePoint = client.mouseCanvasPosition
        if (gear != null && gear.isVisible) {
            if (gear.bounds.contains(mousePoint.x, mousePoint.y)) client.insertMenuItem(
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
    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer == null || it.actor.name == null || !it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")) {
            return
        }
        val isPhantomMuspah = it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")
        val hasNoMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) == null
        if (it.actor.animation == 9918 && isPhantomMuspah) {
            activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            if (config.offensivePrayerToggle()) activatePrayer(config.rangeOffensivePrayer().prayer)
        }
        if (it.actor.animation == -1 && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (it.actor.animation == -1 && hasNoMuspah) {
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            if (config.offensivePrayerToggle()) activatePrayer(config.rangeOffensivePrayer().prayer)
        }
    }

    override fun onProjectileSpawned(it: ProjectileSpawned) {
        val projectile: Projectile = it.projectile
        if (projectile.id == ProjectileID.PHANTOM_MUSPAH_RANGE_ATTACK && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null && config.smiteToggle()){
            activatePrayer(Prayer.SMITE)
        }
    }
    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if ("<col=00FFFF>Copy Gear</col>" in it.getMenuOption()!!) {
            val i: ItemContainer? = client.getItemContainer(InventoryID.EQUIPMENT)
            val sb = StringBuilder()
            i?.items?.forEach {
                if (it.id == -1 || it.id == 0) {
                    return@forEach
                }
                sb.append(it.name)
                sb.append(",")
            }
            Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(sb.toString()), null)
        }
    }
    private fun protectMelee() {
        val meleeMuspah = NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true)
        if (meleeMuspah == null) return
        activatePrayer(Prayer.PROTECT_FROM_MELEE)
        if (config.offensivePrayerToggle()) {
            val prayer = if (config.rangeOnly()) {
                config.rangeOffensivePrayer().prayer
            } else {
                config.mageOffensivePrayer().prayer
            }
            activatePrayer(prayer)
        }
        if (config.gearToggle() && !config.rangeOnly()) {
            equipMageGear()
        }
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