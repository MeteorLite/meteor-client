package meteor.plugins.apitest

import dev.hoot.api.entities.Players
import dev.hoot.api.game.Combat
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.NPC

@PluginDescriptor(
    name = "Api Test",
    description = "Dev shit"
)
class ApiTestPlugin : Plugin() {
    var overlay = overlay(ApiTestOverlay(this))
    var nearestTarget: NPC? = null

    override fun onGameTick(it: GameTick) {
/*        nearestTarget = Combat.getAttackableNPC("Gargoyle")
        if (Players.getLocal().isIdle)
            nearestTarget?.interact("Attack")*/
    }
}