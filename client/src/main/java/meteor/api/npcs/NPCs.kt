package meteor.api.npcs

import meteor.Main
import net.runelite.api.NPC

object NPCs {
    fun getAll(alive: Boolean = false, sortByDistance: Boolean = false): ArrayList<NPC>? {
        var npcs: ArrayList<NPC>? = null
        for (npc in Main.client.npcs) {
            npc?.let {
                if (npcs == null) {
                    npcs = ArrayList()
                    if ((alive && !it.isDead) || !alive) {
                        npcs!!.add(it)
                    } else {}

                } else
                    if ((alive && !it.isDead) || !alive) {
                        npcs!!.add(it)
                    } else {}
            }
        }
        npcs?.let {
            if (sortByDistance) {
                return ArrayList(it.sortedBy { npc -> npc.distanceTo(Main.client.localPlayer) })
            }
        }
        return npcs
    }

    fun getAll(alive: Boolean = true, sortByDistance: Boolean = true, vararg ids: Int): ArrayList<NPC>? {
        return getAll(alive, sortByDistance)?.filter { ids.contains(it.id) } as ArrayList?
    }

    fun getAll(alive: Boolean = true, sortByDistance: Boolean = true, vararg names: String): ArrayList<NPC>? {
        return getAll(alive, sortByDistance)?.filter { names.contains(it.name) } as ArrayList?
    }

    fun getFirst(id: Int, alive: Boolean = true, sortByDistance: Boolean = true): NPC? {
        return getAll(alive, sortByDistance, id)?.firstOrNull()
    }

    fun getFirst(name: String, alive: Boolean = true, sortByDistance: Boolean = true): NPC? {
        return getAll(alive, sortByDistance, name)?.firstOrNull()
    }
}