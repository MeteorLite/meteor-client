package meteor.plugins.dropbones

import dev.hoot.api.entities.Players
import dev.hoot.api.items.Inventory
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ItemID
@PluginDescriptor(name = "asfasfasf", description = "")
class BoneBuryPlugin : Plugin() {

    override fun onGameTick(it: GameTick) {
        if (Players.getLocal().isIdle) {
            Inventory.getFirst(ItemID.BONES)?.interact("Drop")
        }
    }
}