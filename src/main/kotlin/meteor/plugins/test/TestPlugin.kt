package meteor.plugins.test

import dev.hoot.api.entities.Players
import dev.hoot.api.entities.TileObjects
import dev.hoot.api.items.Inventory
import dev.hoot.api.packets.ObjectPackets
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(
    name = "Test",
    description = "Show woodcutting statistics and/or bird nest notifications",
    tags = ["birds", "nest", "notifications", "overlay", "skilling", "wc"],
    enabledByDefault = false
)
class TestPlugin : Plugin() {
    override fun onGameTick(it: GameTick) {
        for (item in Inventory.getAll())
            if (item.id != -1) {
                val door = TileObjects.getNearest(Players.getLocal().worldLocation, "Door")
                door?.let {
                    println("Using ${item.name} on ${it.name}")
                    item.useOn(it)
                    return
                }
            }
    }
}