package meteor.plugins.jadautoprayer

import com.google.common.eventbus.Subscribe
import dev.hoot.api.events.AutomatedMenu
import eventbus.events.AnimationChanged
import meteor.api.ClientPackets
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.mixins.Inject
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(
    name = "Jad Auto Prayer",
    description = "Auto click proper prayers against Jad(s).",
    tags = ["bosses", "combat", "minigame", "overlay", "prayer", "pve", "pvm", "jad", "firecape", "fight", "cave", "caves"],
    enabledByDefault = false
)
class JadAutoPrayerPlugin : Plugin() {

    private val clientThread = ClientThread

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        val actor: Actor = it.actor
        when (actor.animation) {
            AnimationID.TZTOK_JAD_MAGIC_ATTACK, JALTOK_JAD_MAGE_ATTACK -> if (client.getVar(
                    Varbits.PRAYER_PROTECT_FROM_MAGIC
                ) == 0
            ) {
                activatePrayer(Prayer.PROTECT_FROM_MAGIC)
            }
            AnimationID.TZTOK_JAD_RANGE_ATTACK, JALTOK_JAD_RANGE_ATTACK -> if (client.getVar(Varbits.PRAYER_PROTECT_FROM_MISSILES) == 0) {
                activatePrayer(Prayer.PROTECT_FROM_MISSILES)
            }
            else -> {}
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
        ClientPackets.createClientPacket(AutomatedMenu(1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id))!!.send()
        ClientPackets.queueClickPacket(prayerWidget.clickPoint)
    }

    companion object {
        const val JALTOK_JAD_MAGE_ATTACK = 7592
        const val JALTOK_JAD_RANGE_ATTACK = 7593
    }
}