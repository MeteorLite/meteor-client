package meteor.plugins.nmzguzzle

import eventbus.events.GameTick
import eventbus.events.HitsplatApplied
import meteor.api.items.Items
import meteor.api.npcs.NPCs
import meteor.api.objects.Objects
import meteor.api.packets.ClientPackets
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ObjectID.POTION_26276
import net.runelite.api.Skill
import kotlin.random.Random

@PluginDescriptor(name = "NightmareZone AFK", description = "", enabledByDefault = false)
class NightmareZoneAFKPlugin : Plugin() {
    private var overloading = false
    private var nextAbsorptionRefill = -1
    private var ticksSinceLastHitsplat = 0
    private var ticksSinceLastManualAttack = 0

    override fun onGameTick(it: GameTick) {
        ticksSinceLastHitsplat++
        ticksSinceLastManualAttack++

        if (client.getBoostedSkillLevel(Skill.HITPOINTS) == 1)
            overloading = false

        if (Objects.getFirst(POTION_26276) == null)
            return

        if (ticksSinceLastManualAttack > 5) {
            if (ticksSinceLastHitsplat > 100 + Random.nextInt(200)) {
                NPCs.getAll(alive = true, sortByDistance = true)?.firstOrNull()?.let {
                    if (it.distanceTo(client.localPlayer) < 2) {
                        it.interact("Attack")
                    }
                }
                ticksSinceLastManualAttack = 0
                return
            }
        }

        when (client.getBoostedSkillLevel(Skill.HITPOINTS)) {
            2 -> Items.getFirst("Dwarven rock cake")?.interact("Guzzle")?.also { return }
        }

        if (overloading)
            return

        when (client.getBoostedSkillLevel(Skill.HITPOINTS)) {
            51 -> {
                val overload = Items.getFirst("Overload (1)", "Overload (2)", "Overload (3)", "Overload (4)")
                overload?.let {
                    overloading = true
                    it.interact("Drink")
                }
                return
            }
            in 52..60 -> Items.getFirst("Dwarven rock cake")?.interact("Eat")?.also { return }
            in 61..130 -> Items.getFirst("Dwarven rock cake")?.interact("Guzzle")?.also { return }
        }

        // Emergency absorption - only uses them if you use one first i.e. widget was visible
        val text = client.getWidget(13238274)?.getChild(5)?.text
        text?.let {
            if (it != "" && it != "1,000") {
                val absorptionPoints = it.toInt()
                if (nextAbsorptionRefill == -1) {
                    nextAbsorptionRefill = 50 + Random.nextInt(100)
                }
                if (absorptionPoints < nextAbsorptionRefill) {
                    Items.getFirst("Absorption (1)", "Absorption (2)", "Absorption (3)", "Absorption (4)")?.interact("Drink")
                }
            }
        }
    }

    override fun onHitsplatApplied(it: HitsplatApplied) {
        if (it.actor != client.localPlayer) {
            ticksSinceLastHitsplat = 0
        }
    }
}