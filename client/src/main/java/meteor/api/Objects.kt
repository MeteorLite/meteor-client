package meteor.api

import meteor.Main
import net.runelite.api.Tile
import net.runelite.api.TileObject
import net.runelite.api.coords.WorldPoint

/**
 * an object for working with Objects
 * @author Null
 * @author Dab
 */
object Objects {

    /**
     * gets all objects
     */
    fun getAll(): ArrayList<TileObject>? {
        var objects: ArrayList<TileObject>? = null
        for (plane in Main.client.scene.tiles)
            for (tileX in plane)
                for (tileY in tileX) {
                    if (objects == null) {
                        objects = ArrayList()
                        objects.addAll(getObjectsAt(tileY))
                    } else
                        objects.addAll(getObjectsAt(tileY))
                }
        return objects
    }

    /**
     * gets all objects which match any of the provided [ids]
     * @param ids the object ids we should filter for
     */
    fun getAll(vararg ids: Int): ArrayList<TileObject>? {
        return getAll()?.filter { obj -> ids.any { it == obj.id } } as ArrayList?
    }

    /**
     * gets all objects which match any of the provided [names]
     * @param names the object names we should filter for
     */
    fun getAll(vararg names: String): ArrayList<TileObject>? {
        return getAll()?.filter { obj -> names.any { it.equals(obj.name, true) } } as ArrayList?
    }

    /**
     * Gets object at specific [WorldPoint]
     * @param location the WorldPoint for the object.
     */
    fun getAt(location: WorldPoint): TileObject? {
        return getAll()?.lastOrNull { obj -> obj.worldLocation == location }
    }

    /**
     * gets the first object with an id matching the provided [ids]
     * @param ids the object ids we should filter for
     */
    fun getFirst(vararg ids: Int): TileObject? {
        return getAll(*ids)?.minByOrNull { it.distanceTo(Main.client.localPlayer) }
    }

    /**
     * gets the first object with an id matching the provided [name]
     * @param name the object name we should filter for
     */
    fun getFirst(name: String): TileObject? {
        return getAll(name)?.minByOrNull { it.distanceTo(Main.client.localPlayer) }
    }

    /**
     * gets the first object with an id and action matching the provided [name] [action]
     * @param name the object name we should filter for
     * @param action the object action we should filter for
     */
    fun getFirstWithAction(name: String, action: String): TileObject? {
        return getAll(name)?.firstOrNull { it.hasAction((action)) }
    }

    private fun getObjectsAt(tile: Tile?): List<TileObject> {
        val out: MutableList<TileObject> = java.util.ArrayList()
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
        val grnd = tile.groundObject
        if (grnd != null && grnd.id != -1) {
            out.add(grnd)
        }
        val gameObjects = tile.gameObjects
        if (gameObjects != null) {
            for (gameObject in gameObjects) {
                if (gameObject == null || !Main.client
                        .isTileObjectValid(tile, gameObject) || gameObject.id == -1
                ) {
                    continue
                }
                out.add(gameObject)
            }
        }
        return out
    }
}