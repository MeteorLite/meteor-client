package meteor.api.entities

import Main.client
import meteor.api.game.GameThread
import net.runelite.api.NPC
import net.runelite.api.coords.WorldPoint
import java.util.ArrayList
import java.util.function.Predicate
import java.util.stream.Collectors

class NPCs : Entities<NPC>() {
    override fun all(filter: Predicate<in NPC>): List<NPC> {
        val out: MutableList<NPC> = ArrayList()
        val npcs: List<NPC> = client.npcs
        val uncached = npcs.stream()
            .filter { x: NPC -> x.isTransformRequired && !x.isDefinitionCached }
            .collect(Collectors.toList())
        if (uncached.isNotEmpty()) {
            GameThread.invokeLater {
                for (npc in uncached) {
                    npc.name // Transform and cache it by calling getName
                }
                true
            }
        }
        for (npc in npcs) {
            if (filter.test(npc)) {
                out.add(npc)
            }
        }
        return out
    }

    companion object {
        private val NPCS = NPCs()
        fun getAll(filter: Predicate<NPC>): List<NPC> {
            return NPCS.all(filter)
        }

        fun getAll(vararg ids: Int): List<NPC>? {
            return NPCS.all(*ids)
        }

        fun getAll(vararg names: String): List<NPC> {
            return NPCS.all(*names)
        }

        fun getNearest(to: WorldPoint?, filter: Predicate<NPC>): NPC? {
            return NPCS.nearest(to, filter)
        }

        fun getNearest(to: WorldPoint, vararg ids: Int): NPC? {
            return NPCS.nearest(to, *ids)
        }

        fun getNearest(to: WorldPoint, vararg names: String): NPC? {
            return NPCS.nearest(to, *names)
        }

        fun getNearest(filter: Predicate<NPC>): NPC? {
            return getNearest(Players.local.worldLocation, filter)
        }

        fun getNearest(vararg ids: Int): NPC? {
            return getNearest(Players.local.worldLocation, *ids)
        }

        fun getNearest(vararg names: String): NPC? {
            return getNearest(Players.local.worldLocation, *names)
        }
    }
}