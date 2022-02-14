package meteor.plugins.fishing

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Actor
import net.runelite.api.GameState
import net.runelite.api.NPC
import org.rationalityfrontline.kevent.Event

@PluginDescriptor("Fishing", configGroup = "fishing")
class FishingPlugin: Plugin() {
    override var config = configuration<FishingConfig>()
    val spotsOverlay = overlay(FishingSpotOverlay(this, config))

    val fishingSpots: ArrayList<NPC> = ArrayList()
    val minnowSpots: HashMap<Int, MinnowSpot> = HashMap()
    var currentSpot: FishingSpot? = null

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.new) {
            GameState.CONNECTION_LOST,
            GameState.LOGIN_SCREEN,
            GameState.HOPPING -> {
                fishingSpots.clear()
                minnowSpots.clear()
            }
            else -> {}
        }
    }

    override fun onInteractingChanged():((Event<InteractingChanged>)->Unit) = {
        val it = it.data
        if (it.source == client.localPlayer) {
            if (it.target is NPC) {
                val target: Actor = it.target as NPC
                target as NPC
                val spot: FishingSpot? = FishingSpot.findSpot(target.id)

                spot.also { currentSpot = spot }
            }
        }
    }


    override fun onNPCSpawned():((Event<NpcSpawned>)->Unit) = {
        val it = it.data
        if (FishingSpot.findSpot(it.npc.id) != null) {
            fishingSpots.add(it.npc)
        }
    }

    override fun onNPCDespawned():((Event<NpcDespawned>)->Unit) = {
        val it = it.data
        if (FishingSpot.findSpot(it.npc.id) != null) {
            fishingSpots.remove(it.npc)
        }
    }
}