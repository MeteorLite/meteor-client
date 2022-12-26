package meteor.plugins.nmzguzzle

import eventbus.events.GameTick
import meteor.api.items.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Skill
import kotlin.random.Random

@PluginDescriptor(name = "NightmareZone AFK", description = "", enabledByDefault = false)
class NightmareZoneAFKPlugin : Plugin() {
    var overloading = false
    var nextAbsorptionRefill = -1

    override fun onGameTick(it: GameTick) {
        val health = client.getBoostedSkillLevel(Skill.HITPOINTS)
        if (health > 1) {
            if (overloading)
                return
            if (health > 2) {
                if (health != 51) {
                    return
                } else {
                    val overload = Items.getFirst("Overload (1)", "Overload (2)", "Overload (3)", "Overload (4)")
                    overload?.let {
                        overloading = true
                        it.interact("Drink")
                    }
                    return
                }
            } else { // health == 2
                Items.getFirst("Dwarven rock cake")?.interact("Guzzle")
            }

        } else {
            overloading = false
        }

        val absorptionPoints = client.getWidget(13238274)?.getChild(5)?.text?.toInt()
        if (nextAbsorptionRefill == -1) {
            nextAbsorptionRefill = 50 + Random.nextInt(100)
        }
        if (absorptionPoints != null) {
            if (absorptionPoints < nextAbsorptionRefill) {
                Items.getFirst("Absorption (1)", "Absorption (2)", "Absorption (3)", "Absorption (4)")?.interact("Drink")
            }
        }

    }
}