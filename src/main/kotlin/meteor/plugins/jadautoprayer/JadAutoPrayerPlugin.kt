package meteor.plugins.jadautoprayer

import com.google.common.eventbus.Subscribe
import eventbus.events.AnimationChanged
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

    @Inject
    private val clientThread: ClientThread? = null

    @Throws(Exception::class)
    protected fun startUp() {
    }

    @Throws(Exception::class)
    protected fun shutDown() {
    }

    @Subscribe
    override fun onAnimationChanged(event: AnimationChanged) {
        val actor: Actor = event.actor
        when (actor.animation) {
            AnimationID.TZTOK_JAD_MAGIC_ATTACK, JALTOK_JAD_MAGE_ATTACK -> if (client.getVar(
                    Varbits.PRAYER_PROTECT_FROM_MAGIC.id
                ) === 0
            ) {
                activatePrayer(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC)
            }
            AnimationID.TZTOK_JAD_RANGE_ATTACK, JALTOK_JAD_RANGE_ATTACK -> if (client.getVar(Varbits.PRAYER_PROTECT_FROM_MISSILES.id) === 0) {
                activatePrayer(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES)
            }
            else -> {}
        }
    }

    fun activatePrayer(widgetInfo: WidgetInfo?) {
        val prayer_widget: Widget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        clientThread!!.invoke {
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
        const val JALTOK_JAD_MAGE_ATTACK = 7592
        const val JALTOK_JAD_RANGE_ATTACK = 7593
    }
}