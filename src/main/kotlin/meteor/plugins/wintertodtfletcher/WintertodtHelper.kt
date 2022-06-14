package meteor.plugins.wintertodtfletcher

import dev.hoot.api.game.Skills
import eventbus.events.GameTick
import meteor.api.items.Item
import meteor.api.items.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Skill
import net.runelite.client.config.Config

@PluginDescriptor(
    name = "Wintertodt Helper",
    description = "fletches when inv full",
    enabledByDefault = false,
    disabledOnStartup = true
)
class WintertodtHelper : Plugin() {
    override val config = configuration<WintertodtHelperConfig>()
    var waitForFullInv = true

    override fun onGameTick(it: GameTick) {
        if (heal())
            return

        if (Items.isFull())
            waitForFullInv = false

        if (getRoot() == null && getKindling() == null) {
            waitForFullInv = true
        }

        if (!waitForFullInv)
            if (fletch())
                return
    }

    fun getRoot(): Item? { return Items.getFirst("Bruma root") }
    fun getKindling(): Item? { return Items.getFirst("Bruma root") }
    fun getKnife(): Item? { return Items.getFirst("Knife") }

    fun fletch() : Boolean {
        if (client.localPlayer!!.isIdle)
            if (Items.isFull())
                getRoot()?.let {
                    getKnife()?.useOn(it)
                    return true
                }
        return false
    }

    fun heal() : Boolean {
        if (Skills.getBoostedLevel(Skill.HITPOINTS) <= config.healAt())
            Items.getAll()?.let { items ->
                for (item in items) {
                    if (item.actions.contains("Eat")) {
                        item.interact("Eat")
                        return true
                    }
                }
            }
        return false
    }
}