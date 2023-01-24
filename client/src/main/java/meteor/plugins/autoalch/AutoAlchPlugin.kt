package meteor.plugins.autoalch

import dev.hoot.api.magic.Magic
import dev.hoot.api.magic.Regular
import dev.hoot.api.packets.ItemPackets
import dev.hoot.api.packets.WidgetPackets
import eventbus.events.GameTick
import eventbus.events.StatChanged
import meteor.api.items.Items
import meteor.api.packets.ClientPackets
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Skill
import java.util.*
import kotlin.math.roundToInt

@PluginDescriptor(
    name = "Auto Alch",
    description = "Cast Alchemy for you",
    tags = [],
    enabledByDefault = false,
    disabledOnStartup = true
)
class AutoAlchPlugin : Plugin() {
    var timeout = 0
    var rand = Random()
    val config: AutoAlchConfig = configuration()

    override fun onStatChanged(it: StatChanged) {
        if (it.skill == Skill.MAGIC) {
            if (it.xp != 0) {
                timeout = delay()
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        if (timeout <= -20) {
            timeout = 0
        }
        if (timeout == 0) {
            val spellToUse =
                if (config.alchType() == AutoAlchConfig.AlchType.HIGH)
                    Regular.HIGH_LEVEL_ALCHEMY
                else
                    Regular.LOW_LEVEL_ALCHEMY
            Items.getFirst(config.itemID())?.let{
                Magic.cast(spellToUse,it)
                ClientPackets.queueClickPacket(it.clickPoint)
            }
        }
        timeout--
    }

    fun delay(): Int {
        var delay: Int
        do {
            val random = rand.nextGaussian() * 1 + 3
            delay = random.roundToInt()
        } while (delay <= 1 || delay >= 9)
        return delay
    }
}