package meteor.plugins.wintertodtfletcher

import dev.hoot.api.game.Skills
import eventbus.events.GameTick
import eventbus.events.HitsplatApplied
import meteor.api.ClientPackets
import meteor.api.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Item
import net.runelite.api.Skill

@PluginDescriptor(
    name = "Wintertodt Helper",
    description = "fletches when inv full",
    enabledByDefault = false
)
class WintertodtHelper : Plugin() {
    val config = configuration<WintertodtHelperConfig>()
    var waitForFullInv = false
    var allowance = 0
    override fun onHitsplatApplied(it: HitsplatApplied) {
        if (it.actor == client.localPlayer) {
            if (!waitForFullInv)
                fletch()
        }
    }

    override fun onGameTick(it: GameTick) {
        if (heal())
            return

        if (Items.getFreeSlots() <= allowance) {
            waitForFullInv = false
        }

        if (getRoot() == null && getKindling() == null) {
            allowance = 0
            waitForFullInv = true
        }

        if (client.localPlayer!!.isIdle) {
            if (!waitForFullInv)
                fletch()
        }
    }

    fun getRoot(): Item? {
        return Items.getFirst("Bruma root")
    }

    fun getKindling(): Item? {
        return Items.getFirst("Bruma root")
    }

    fun getKnife(): Item? {
        return Items.getFirst("Knife")
    }

    fun fletch(): Boolean {
        if (client.localPlayer!!.isIdle)
            if (Items.isFull())
                getRoot()?.let {
                    getKnife()?.useOn(it)
                    return true
                }
        return false
    }

    fun heal(): Boolean {
        if (Skills.getBoostedLevel(Skill.HITPOINTS) <= config.healAt())
            Items.getAll()?.let { items ->
                for (item in items) {
                    if (item.actions?.contains("Eat") == true) {
                        allowance++
                        ClientPackets.queueClickPacket(item.clickPoint)
                        item.interact("Eat")
                        return true
                    }
                }
            }
        return false
    }
}