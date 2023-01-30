@file:Suppress("DEPRECATION")

package meteor.plugins.muspahassist

import eventbus.events.AnimationChanged
import eventbus.events.GameTick
import eventbus.events.ProjectileSpawned
import meteor.api.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import java.util.*


@PluginDescriptor(name = "Muspah Assist", description = "Auto prays for you at muspah", enabledByDefault = false)
class MuspahAssist : Plugin() {
    private val clientThread = ClientThread
    private var config = configuration<MuspahAssistConfig>()
    var smiteEndTime = 0L
    override fun onGameTick(it: GameTick) {
        protectMelee()
        if (System.currentTimeMillis() < smiteEndTime) {
            return
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null && client.isPrayerActive(Prayer.SMITE) && config.smiteToggle()){
            smiteEndTime = System.currentTimeMillis() + 2000
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079,true,true) != null && client.isPrayerActive(Prayer.PROTECT_FROM_MELEE)){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079,true,true) == null && client.isPrayerActive(Prayer.SMITE)){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
    }
    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer == null || it.actor.name == null || !it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")) {
            return
        }
        if (it.actor.animation == 9918) {
            activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            if (config.offensivePrayerToggle()) activatePrayer(config.rangeOffensivePrayer().prayer)
        }
        if (it.actor.animation == -1 && client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)){
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
        }
        if (
            (it.actor.animation == -1 && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) == null && config.smiteToggle())
        ) {
            activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            if (config.offensivePrayerToggle()) activatePrayer(config.rangeOffensivePrayer().prayer)
        }
        if (
            (it.actor.animation == -1 && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null && !config.smiteToggle())
        ) {
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
    private fun protectMelee(){
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) != null){
            activatePrayer(Prayer.PROTECT_FROM_MELEE)
            if (config.offensivePrayerToggle() && !config.rangeOnly()) {
                activatePrayer(config.mageOffensivePrayer().prayer)
            } else if (config.offensivePrayerToggle() && config.rangeOnly()) {
                activatePrayer(config.rangeOffensivePrayer().prayer)
            }
        }
    }
    private fun activatePrayer(prayer: Prayer?) {
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