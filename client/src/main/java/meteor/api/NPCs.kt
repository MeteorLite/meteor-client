package meteor.api

import meteor.Main
import net.runelite.api.NPC

/**
 * an object for working with NPCS
 * @author Null
 */
object NPCs {

    /**
     * gets all npcs
     * @param alive option to include alive npcs only
     * @param sortByDistance option to sort npcs by distance nearest to farthest
     */
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

    /**
     * gets all npcs that match any of the provided [ids]
     * @param alive option to include alive npcs only
     * @param sortByDistance option to sort npcs by distance nearest to farthest
     * @param ids npc ids we should filter with
     */
    fun getAll(alive: Boolean = true, sortByDistance: Boolean = true, vararg ids: Int): ArrayList<NPC>? {
        return getAll(alive, sortByDistance)?.filter {
            it.transformedComposition
            ids.contains(it.transformedId!!)
        } as ArrayList?
    }

    /**
     * gets all npcs that match any of the provided [names]
     * @param alive option to include alive npcs only
     * @param sortByDistance option to sort npcs by distance nearest to farthest
     * @param names npc names we should filter with
     */
    fun getAll(alive: Boolean = true, sortByDistance: Boolean = true, vararg names: String): ArrayList<NPC>? {
        return getAll(alive, sortByDistance)?.filter {
            it.transformedComposition
            names.contains(it.transformedName!!)
        } as ArrayList?
    }

    /**
     * gets the first npc we can find with a matching [id]
     * @param alive option to include alive npcs only
     * @param sortByDistance option to sort npcs by distance nearest to farthest
     * @param id npc id we should filter with
     */
    fun getFirst(id: Int, alive: Boolean = true, sortByDistance: Boolean = true): NPC? {
        return getAll(alive, sortByDistance, id)?.firstOrNull()
    }

    /**
     * gets the first npc we can find with a matching [name]
     * @param alive option to include alive npcs only
     * @param sortByDistance option to sort npcs by distance nearest to farthest
     * @param name npc name we should filter with
     */
    fun getFirst(name: String, alive: Boolean = true, sortByDistance: Boolean = true): NPC? {
        return getAll(alive, sortByDistance, name)?.firstOrNull()
    }
}