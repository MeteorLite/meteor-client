package meteor.api.objects

import meteor.Main
import net.runelite.api.Tile
import net.runelite.api.TileObject

object Objects {
    fun getAll(): ArrayList<TileObject>? {
        var objects: ArrayList<TileObject>? = null
        for (plane in Main.client.scene.tiles)
            for (tileX in plane)
                for (tileY in tileX) {
                    if (objects == null) {
                        objects = ArrayList()
                        objects.addAll(getTileObjects(tileY))
                    } else
                        objects.addAll(getTileObjects(tileY))
                }
        return objects
    }

    fun getAll(vararg ids: Int): ArrayList<TileObject>? {
        return getAll()?.filter { obj -> ids.any { it == obj.id } } as ArrayList?
    }

    fun getAll(vararg names: String): ArrayList<TileObject>? {
        return getAll()?.filter { obj -> names.any { it.equals(obj.name, true) } } as ArrayList?
    }

    fun getFirst(id: Int): TileObject? {
        return getAll(id)?.minByOrNull { it.distanceTo(Main.client.localPlayer) }
    }

    fun getFirst(name: String): TileObject? {
        return getAll(name)?.minByOrNull { it.distanceTo(Main.client.localPlayer) }
    }

    private fun getTileObjects(tile: Tile?): List<TileObject> {
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