package meteor.plugins.scriptcreator.script.api

import meteor.Main
import net.runelite.api.Tile
import net.runelite.api.TileObject

object Object {

    /**
     * Returns the first element that matches the specified ID.
     * @param id the ID to search for
     * @return the first element that matches the specified ID, or null if no such element exists
     */
    inline infix fun <reified T> first(id: T) = getFirst(id)

    /**
     * Returns true if an element with the specified ID exists in the collection.
     * @param id the ID to search for
     * @return true if an element with the specified ID exists in the collection, false otherwise
     */
    inline infix fun <reified T> exists(id: T) = contains(id)

    /**
     * Returns true if all elements in the specified iterable have a corresponding element in the collection with the same ID.
     * @param id the iterable of IDs to search for
     * @return true if all elements in the specified iterable have a corresponding element in the collection with the same ID, false otherwise
     */
    inline infix fun <reified T> exists(id: Iterable<T>) = contains(id)

    /**
     * Returns all elements that have IDs that are contained in the specified iterable.
     * @param id the iterable of IDs to search for
     * @return a list of all elements that have IDs that are contained in the specified iterable
     */
    inline infix fun <reified T> all(id: Iterable<T>) = getAll(id)


    /**
     * Returns true if any element in the collection has an ID that is contained in the specified iterable.
     * @param ids the iterable of IDs to search for
     * @return true if any element in the collection has an ID that is contained in the specified iterable, false otherwise
     */
    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach { if (contains(it)) return true }
        return false
    }

    /**
     * Returns true if an element with the specified ID exists in the collection.
     * @param id the ID to search for
     * @return true if an element with the specified ID exists in the collection, false otherwise
     */
    inline fun <reified T> contains(id: T): Boolean {
        return when (T::class) {
            Int::class -> getAll().any { it.id == id }
            String::class -> getAll().any { it.name == id }
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }

    /**
     * Returns a list of all elements in the collection. The list is sorted by the distance of each element to the local player.
     * @return a list of all elements in the collection
     */
    fun getAll(): List<TileObject> {
        return Main.client.scene.tiles.flatMap { plane ->
            plane.flatMap { tileX ->
                tileX.flatMap { tileY -> getTileObjects(tileY) }
            }.sortedBy { it.distanceTo(Main.client.localPlayer) }
        }
    }

    /**
     * Returns all elements that have IDs that are contained in the specified iterable.
     * @param ids the iterable of IDs to search for
     * @return a list of all elements that have IDs that are contained in the specified iterable
     */
    inline fun <reified T> getAll(ids: Iterable<T>): List<TileObject> {
        return when (T::class) {
            Int::class -> getAll().filter { obj -> ids.any { it == obj.id } }.toMutableList()
            String::class -> getAll().filter { obj ->
                ids.any {
                    obj.name.contains(it.toString(), true)
                }
            }.toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }

    /**
     * Returns all elements that have IDs that match the specified ID.
     * @param ids the ID to search for
     * @return a list of all elements that have IDs that match the specified ID
     */
    inline infix fun <reified T> getAll(ids: T): List<TileObject?>? {
        return when (T::class) {
            Int::class -> getAll()?.filter { obj -> ids == obj.id }?.toMutableList()
            String::class -> getAll()?.filter { obj -> obj.name.contains(ids.toString(),true )  }
                ?.toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }

    /**
     * Returns the first element that has an ID that matches the specified ID. The element is sorted by distance to the local player.
     * @param id the ID to search for
     * @return the first element that has an ID that matches the specified ID
     */
    inline infix fun <reified T> getFirst(id: T): TileObject {
        return when (T::class) {
            Int::class -> getAll().sortedBy { Main.client.localPlayer?.distanceTo(it.worldLocation) }
                .first { it.id == id }
            String::class -> getAll().sortedBy { Main.client.localPlayer?.distanceTo(it.worldLocation) }
                .first { it.name.contains(id.toString(),true) }
            else -> throw IllegalArgumentException("Use the right type getFirst() requires  String || Int")
        }
    }

    /**
     * Returns a list of all objects on the specified tile.
     * @param tile the tile to search for objects on
     * @return a list of all objects on the specified tile
     */
    private fun getTileObjects(tile: Tile?): MutableList<TileObject> {
        val out: MutableList<TileObject> = mutableListOf()
        if (tile == null) {
            return out
        }
        val dec = tile.decorativeObject
        if (dec != null && dec.id != -1) {
            out.add(dec)
        }
        val wall = tile.wallObject
        if (wall != null && wall.id != -1) {
            out.add(wall)
        }
        val ground = tile.groundObject
        if (ground != null && ground.id != -1) {
            out.add(ground)
        }
        val gameObjects = tile.gameObjects
        if (gameObjects != null) {
            for (gameObject in gameObjects) {
                if (gameObject == null || !Main.client.isTileObjectValid(tile, gameObject) || gameObject.id == -1) {
                    continue
                }
                out.add(gameObject)
            }
        }
        return out
    }


}