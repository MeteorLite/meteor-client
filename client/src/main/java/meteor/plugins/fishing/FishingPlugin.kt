package meteor.plugins.fishing

import eventbus.events.GameStateChanged
import eventbus.events.InteractingChanged
import eventbus.events.NpcDespawned
import eventbus.events.NpcSpawned
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Actor
import net.runelite.api.GameState
import net.runelite.api.NPC

@PluginDescriptor("Fishing", configGroup = "fishing")
class FishingPlugin : Plugin() {
    var config = configuration<FishingConfig>()
    val spotsOverlay = overlay(FishingSpotOverlay(this, config))

    val fishingSpots: ArrayList<NPC> = ArrayList()
    val minnowSpots: HashMap<Int, MinnowSpot> = HashMap()
    var currentSpot: FishingSpot? = null

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.CONNECTION_LOST,
            GameState.LOGIN_SCREEN,
            GameState.HOPPING -> {
                fishingSpots.clear()
                minnowSpots.clear()
            }
            else -> {}
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source == client.localPlayer) {
            if (it.target is NPC) {
                val target: Actor = it.target as NPC
                target as NPC
                FishingSpot.findSpot(target.id)?.let {
                    currentSpot = it
                }
            }
        }
    }


    override fun onNPCSpawned(it: NpcSpawned) {
        FishingSpot.findSpot(it.npc.id)?.let { _ ->
            fishingSpots.add(it.npc)
        }
    }

    override fun onNPCDespawned(it: NpcDespawned) {
        FishingSpot.findSpot(it.npc.id)?.let { _ ->
            fishingSpots.remove(it.npc)
        }
    }
}