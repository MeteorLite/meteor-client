package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint

object Loot {
    /**
     * Returns the first tile item in the client's scene that has an ID or noted ID matching the given value.
     *
     * @param T the type of the input
     * @param id the ID or noted ID to find
     * @return the first tile item with a matching ID or noted ID
     * @throws NullPointerException if no tile item with a matching ID or noted ID is found
     */
    inline infix fun <reified T> first(id: T) = getFirst(id)

    /**
     * Returns true if there is at least one tile item in the client's scene that has an ID or noted ID matching the given value.
     *
     * @param T the type of the input
     * @param id the ID or noted ID to find
     * @return true if a matching tile item is found, false otherwise
     */
    inline infix fun <reified T> exists(id: T) = contains(id)

    /**
     * Returns true if there is at least one tile item in the client's scene that has an ID or noted ID matching any of the given values.
     *
     * @param T the type of the input
     * @param ids the IDs or noted IDs to find
     * @return true if a matching tile item is found, false otherwise
     */
    inline infix fun <reified T> exists(ids: Iterable<T>) = contains(ids)

    /**
     * Returns a list of all tile items at the given world point.
     *
     * @param worldPoint the world point to search for tile items
     * @return a list of all tile items at the given world point
     */
    fun getAt(worldPoint: WorldPoint) : ArrayList<TileItem>? {
        val loots = ArrayList<TileItem>()
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                    y?.groundItems?.let { groundItems ->
                        groundItems.filter { it.getWorldLocation().x == worldPoint.x && it.getWorldLocation().y == worldPoint.y && it.getWorldLocation().plane == worldPoint.plane }
                            .forEach { loots.add(it) }
                    }
                }
            }
        }
        return if (loots.isEmpty()) null else loots
    }
    /**
     * Returns a list of all tile items in the client's scene.
     *
     * @param sortByDistance whether to sort the list of tile items by distance from the player (default is false)
     * @return a list of all tile items in the client's scene
     */
    fun getAll(sortByDistance: Boolean = false): ArrayList<TileItem>? {
        val loots = ArrayList<TileItem>()
        Main.client.scene.tiles.forEach { z ->
            z?.forEach { x ->
                x?.forEach { y ->
                    y?.groundItems?.let { groundItems ->
                        loots.addAll(groundItems)
                    }
                }
            }
        }
        if (sortByDistance) {
            loots.sortBy { loot -> Main.client.localPlayer?.let { loot.distanceTo(it) } }
        }
        return if (loots.isEmpty()) null else loots
    }

    /**
     * Returns the first tile item in the client's scene that matches the given name or id.
     *
     * @param nameOrId the name or id of the tile item to search for
     * @return the first tile item in the client's scene that matches the given name or id
     * @throws NullPointerException if no tile item with the given name or id is found
     */
    inline fun <reified T> getFirst(nameOrId: T): TileItem {
        return when(T::class){
            String::class -> getAll()!!.first { it.getName()?.contains(nameOrId as String,true) == true }
            Int::class -> getAll()!!.first { it.getId() == nameOrId as Int }
            else -> throw NullPointerException("No name or id matching the predicate")
        }
    }

    /**
     * Returns whether any of the tile items in the client's scene have a name or ID that is contained in the given iterable.
     *
     * @param ids the iterable of names or IDs to search for
     * @return true if any of the tile items in the client's scene have a name or ID that is contained in the given iterable, false otherwise
     */
    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach { if (contains(it)) return true }
        return false
    }

    /**
     * Returns a list of all tile items in the client's scene that have a name or ID that is contained in the given iterable.
     *
     * @param ids the iterable of names or IDs to search for
     * @return a list of all tile items in the client's scene that have a name or ID that is contained in the given iterable
     */
    inline infix fun <reified T> getAll(ids: T): List<TileItem> {
        return when (T::class) {
            Int::class -> getAll()?.filter { obj -> ids as Int == obj.getId() }!!.toMutableList()
            String::class -> getAll()?.filter { obj ->
                obj.getName()!!.contains(ids.toString(), ignoreCase = true)
            }!!.toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }

    /**
     * Returns whether any of the tile items in the client's scene have a name or ID that is equal to the given ID.
     *
     * @param id the name or ID to search for
     * @return true if any of the tile items in the client's scene have a name or ID that is equal to the given ID, false otherwise
     */
    inline fun <reified T> contains(id: T): Boolean {
        return when (T::class) {
            Int::class -> getAll()!!.any { it.getId() == id as Int || it.notedId == id as Int }
            String::class -> getAll()!!.any { it.getName() == id }
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }
}