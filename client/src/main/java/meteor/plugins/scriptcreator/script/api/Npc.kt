package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.NPC

object Npc {
    /**
     * Returns the first NPC in the client's scene with a name or ID that is equal to the given value.
     *
     * @param id the name or ID to search for
     * @return the first NPC in the client's scene with a name or ID that is equal to the given value
     * @throws NoSuchElementException if no NPC in the client's scene has a name or ID that is equal to the given value
     */
    inline infix fun <reified T> first(id: T): NPC {
        return when (T::class) {
            Int::class -> getAll().first { it.id == id }
            String::class -> getAll().first { it.name.lowercase() == id.toString().lowercase() }
            else -> throw IllegalArgumentException("Use the right type first() requires  String || Int")
        }
    }

    /**
     * Returns whether there is any NPC in the client's scene with a name or ID that is equal to the given value.
     *
     * @param id the name or ID to search for
     * @return true if there is an NPC in the client's scene with a name or ID that is equal to the given value, false otherwise
     */
    inline infix fun <reified T> exists(id: T) = contains(id)

    /**
     * Returns whether there is any NPC in the client's scene with a name or ID that is contained in the given iterable.
     *
     * @param id the iterable of names or IDs to search for
     * @return true if there is an NPC in the client's scene with a name or ID that is contained in the given iterable, false otherwise
     */
    inline infix fun <reified T> exists(id: Iterable<T>) = contains(id)

    /**
     * Interacts with the first NPC in the client's scene with a name or ID that is equal to the given value, using the "Attack" action.
     *
     * @param id the name or ID of the NPC to attack
     */

    inline infix fun <reified T> attack(id: T) = getFirst(id).interact("Attack")

    /**
     * Attempts to pickpocket the NPC with the given name or ID.
     *
     * @param id the name or ID of the NPC to pickpocket
     * @throws NoSuchElementException if no NPC in the client's scene has a name or ID that is equal to the given value
     */
    inline infix fun <reified T> pickPocket(id: T) = getFirst(id).interact("Pick pocket")

    /**
     * Returns a list of all NPCs in the client's scene.
     *
     * @param alive only include NPCs that are alive if true, include all NPCs if false
     * @param sortByDistance sort the list by distance to the local player if true, do not sort the list if false
     * @return a list of all NPCs in the client's scene
     */
    fun getAll(alive: Boolean = false, sortByDistance: Boolean = false): List<NPC> {
        var npcs = Main.client.npcs.filter { (alive && !it.isDead) || !alive }
        if (sortByDistance) {
            npcs = npcs.sortedBy { it.distanceTo(Main.client.localPlayer) }
        }
        return npcs
    }
    /**
     * Returns a list of NPCs in the client's scene with IDs or names that are equal to any of the given values.
     *
     * @param ids the IDs or names to search for
     * @param alive whether to include only NPCs that are alive (default is false)
     * @param sortByDistance whether to sort the list of NPCs by distance to the local player (default is false)
     * @return a list of NPCs in the client's scene with IDs or names that are equal to any of the given values
     */
    inline fun <reified T> getAll(
        ids: Iterable<T>,
        alive: Boolean = false,
        sortByDistance: Boolean = false
    ): MutableList<NPC> {
        return when (T::class) {
            Int::class -> getAll(alive,sortByDistance).filter { obj -> ids.any { it == obj.id } }.toMutableList()
            String::class -> getAll(alive, sortByDistance).filter { obj -> ids.any { it.toString().lowercase() == obj.name.lowercase() } }
                .toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }

    /**
     * Returns whether any NPCs in the client's scene have an ID or name that is equal to any of the given values.
     *
     * @param ids the IDs or names to search for
     * @return whether any NPCs in the client's scene have an ID or name that is equal to any of the given values
     */
    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach { if (contains(it)) return true }
        return false
    }

    /**
     * Returns whether any NPC in the client's scene has an ID or name that is equal to the given value.
     *
     * @param id the ID or name to search for
     * @return whether any NPC in the client's scene has an ID or name that is equal to the given value
     */
    inline fun <reified T> contains(id: T): Boolean {
        return when (T::class) {
            Int::class -> getAll().any { it.id == id as Int }
            String::class -> getAll().any { it.name == id }
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }

    /**
     * Returns the first NPC in the client's scene with an ID or name that is equal to the given value.
     *
     * @param id the ID or name to search for
     * @return the first NPC in the client's scene with an ID or name that is equal to the given value
     * @throws NoSuchElementException if no NPC in the client's scene has an ID or name that is equal to the given value
     */
    inline fun <reified T> getFirst(id: T): NPC {
        return when (T::class) {
            Int::class -> getAll().first { it.id == id as Int }
            String::class -> getAll().first { it.name.lowercase() == id.toString().lowercase() }
            else -> throw IllegalArgumentException("Use the right type getFirst() requires  String || Int")
        }
    }

}