package meteor.plugins.muspahassist

import eventbus.events.AnimationChanged
import eventbus.events.GameTick
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

    override fun onGameTick(it: GameTick) {
        if (NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) != null){
            activatePrayer(Prayer.PROTECT_FROM_MELEE)
            if (config.offensivePrayerToggle() && !config.rangeOnly()) {
                activatePrayer(config.mageOffensivePrayer().prayer)
            } else if (config.offensivePrayerToggle() && config.rangeOnly()) {
                activatePrayer(config.rangeOffensivePrayer().prayer)
            }
        }
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        if (this.client.localPlayer != null) {
            if (it.actor.name != null && it.actor is NPC) {
                if (it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")
                    && (it.actor.animation == 9918)
                ) {
                    activatePrayer(Prayer.PROTECT_FROM_MAGIC)
                    if (config.offensivePrayerToggle())
                        activatePrayer(config.rangeOffensivePrayer().prayer)
                }
                if (it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")
                    && (it.actor.animation == -1 && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12078, true, true) == null)
                ) {
                    activatePrayer(Prayer.PROTECT_FROM_MISSILES)
                    if (config.offensivePrayerToggle())
                        activatePrayer(config.rangeOffensivePrayer().prayer)
                }
                if (it.actor.name.lowercase(Locale.getDefault()).contains("phantom muspah")
                    && config.smiteToggle() && (it.actor.animation == 9922 && NPCs.getFirst(NpcID.PHANTOM_MUSPAH_12079, true, true) != null)
                ) {
                    activatePrayer(Prayer.SMITE)
                }
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