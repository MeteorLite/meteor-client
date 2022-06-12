package meteor.plugins.highalchemy

import dev.hoot.api.magic.Regular
import dev.hoot.api.packets.ItemPackets
import dev.hoot.api.packets.MousePackets
import eventbus.events.GameTick
import eventbus.events.StatChanged
import meteor.api.items.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Skill
import java.util.*
import kotlin.math.roundToInt

@PluginDescriptor(
    name = "Auto High Alch",
    description = "Cast High Alchemy for you",
    tags = [],
    enabledByDefault = false,
    disabledOnStartup = true
)
class HighAlchPlugin : Plugin() {
    var timeout = 0
    var rand = Random()
    override val config: HighAlchConfig = configuration()

    override fun onStatChanged(it: StatChanged) {
        if (it.skill === Skill.MAGIC) {
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
            val x = Items.getFirst(config.itemID())
            if (x != null) {
                MousePackets.queueClickPacket(0, 0)
                ItemPackets.queueSpellOnItemPacket (x.id, x.slot, Regular.HIGH_LEVEL_ALCHEMY.widget.id)
            }
        }
        timeout--
    }

    fun delay(): Int {
        var delay: Int
        do {
            val random = rand.nextGaussian() * 1 + 3
            delay = random.roundToInt().toInt()
        } while (delay <= 1 || delay >= 9)
        return delay
    }

}