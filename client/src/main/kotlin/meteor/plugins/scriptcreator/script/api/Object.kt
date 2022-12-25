package meteor.plugins.scriptcreator.script.api

import meteor.Main
import meteor.api.objects.Objects
import net.runelite.api.Tile
import net.runelite.api.TileObject

object Object {

    inline infix fun <reified T> first(id: T) = getFirst(id)
    inline infix fun <reified T> exists(id: T) = contains(id)
    inline infix fun <reified T> exists(id: Iterable<T>) = contains(id)

    inline fun <reified T> contains(ids: Iterable<T>): Boolean {
        ids.forEach{if(contains(it)) return true}
        return  false
    }
    inline fun <reified T> contains(id: T): Boolean {
        return when(T::class){
            Int::class -> getAll().any { it.id == id }
            String::class -> getAll().any { it.name == id  }
            else -> throw IllegalArgumentException("Wrong type use String || Int")
        }
    }

    fun getAll(): List<TileObject> {
        return Main.client.scene.tiles.flatMap { plane ->
            plane.flatMap { tileX ->
                tileX.flatMap { tileY -> getTileObjects(tileY) }
            }
        }
    }

    inline fun <reified T> getAll( ids: Iterable<T>): MutableList<TileObject>  {
        return when(T::class) {
            Int::class ->   getAll().filter { obj -> ids.any { it == obj.id } }.toMutableList()
            String::class -> getAll().filter { obj -> ids.any { it.toString().lowercase() == obj.name.lowercase()}}.toMutableList()
            else -> throw IllegalArgumentException("Use the right type getAll() requires  String || Int")
        }
    }

    inline fun <reified T> getFirst(id: T): TileObject  {
        return when(T::class){
            Int::class -> getAll().sortedBy { Main.client.localPlayer?.distanceTo(it.worldLocation) }.first { it.id == id }
            String::class -> getAll().sortedBy { Main.client.localPlayer?.distanceTo(it.worldLocation) }.first {it.name.lowercase()  == id.toString().lowercase()}
            else -> throw IllegalArgumentException("Use the right type getFirst() requires  String || Int")
        }
    }


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