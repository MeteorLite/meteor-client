package meteor.api.objects

import dev.hoot.api.game.Game
import meteor.Main
import net.runelite.api.Tile
import net.runelite.api.TileObject

object Objects {
    fun getAll(): ArrayList<Object>? {
        var objects : ArrayList<Object>? = null
        for (plane in Main.client.scene.tiles)
            for (tileX in plane)
                for (tileY in tileX) {
                    if (objects == null) {
                        objects = ArrayList()
                        objects.addAll(getTileObjects(tileY))
                    }
                    else
                        objects.addAll(getTileObjects(tileY))
                }
        return objects
    }

    fun getAll(vararg ids: Int): ArrayList<Object>? {
        return getAll()?.filter { obj -> ids.any { it == obj.obj.id } } as ArrayList?
    }

    fun getAll(vararg names: String): ArrayList<Object>? {
        return getAll()?.filter { obj -> names.any { it.equals(obj.obj.name, true) } } as ArrayList?
    }
    
    fun getFirst(id: Int): Object? {
        return getAll(id)?.firstOrNull()
    }

    fun getFirst(name: String): Object? {
        return getAll(name)?.firstOrNull()
    }

    private fun getTileObjects(tile: Tile?): List<Object> {
        val out: MutableList<Object> = java.util.ArrayList()
        if (tile == null) {
            return out
        }
        val dec = tile.decorativeObject
        if (dec != null && dec.id != -1) {
            out.add(Object(dec))
        }
        val wall = tile.wallObject
        if (wall != null && wall.id != -1) {
            out.add(Object(wall))
        }
        val grnd = tile.groundObject
        if (grnd != null && grnd.id != -1) {
            out.add(Object(grnd))
        }
        val gameObjects = tile.gameObjects
        if (gameObjects != null) {
            for (gameObject in gameObjects) {
                if (gameObject == null || !Game.getClient()
                        .isTileObjectValid(tile, gameObject) || gameObject.id == -1) {
                    continue
                }
                out.add(Object(gameObject))
            }
        }
        return out
    }
}