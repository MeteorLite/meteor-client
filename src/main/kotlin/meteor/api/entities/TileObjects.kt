package meteor.api.entities

import meteor.api.game.GameThread
import meteor.api.scene.Tiles
import net.runelite.api.Tile
import net.runelite.api.TileObject
import net.runelite.api.coords.WorldPoint
import java.util.ArrayList
import java.util.function.Predicate
import java.util.stream.Collectors

class TileObjects : Entities<TileObject>() {
    override fun all(filter: Predicate<in TileObject?>): List<TileObject> {
        return getTileObjects(Tiles.tiles).stream()
            .filter(filter )
            .collect<List<TileObject>, Any>(Collectors.toList<TileObject>())
    }

    companion object {
        private val TILE_OBJECTS = TileObjects()
        fun getAll(filter: Predicate<TileObject>): List<TileObject> {
            return TILE_OBJECTS.all(filter)
        }

        fun getAll(vararg ids: Int): List<TileObject?>? {
            return TILE_OBJECTS.all(*ids)
        }

        fun getAll(vararg names: String): List<TileObject?>? {
            return TILE_OBJECTS.all(*names)
        }

        fun getNearest(filter: Predicate<TileObject?>): TileObject? {
            return TILE_OBJECTS.nearest(Players.local.worldLocation, filter)
        }

        fun getNearest(vararg ids: Int): TileObject? {
            return TILE_OBJECTS.nearest(Players.local.worldLocation, *ids)
        }

        fun getNearest(vararg names: String): TileObject? {
            return TILE_OBJECTS.nearest(Players.local.worldLocation, *names)
        }

        fun getNearest(to: WorldPoint?, filter: Predicate<TileObject?>): TileObject? {
            return TILE_OBJECTS.nearest(to, filter)
        }

        fun getNearest(to: WorldPoint?, vararg ids: Int): TileObject? {
            return TILE_OBJECTS.nearest(to, *ids)
        }

        fun getNearest(to: WorldPoint?, vararg names: String): TileObject? {
            return TILE_OBJECTS.nearest(to, *names)
        }

        fun getAt(worldX: Int, worldY: Int, plane: Int, vararg ids: Int): List<TileObject?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), ids)
        }

        fun getAt(worldX: Int, worldY: Int, plane: Int, vararg names: String): List<TileObject?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), names)
        }



        fun getAt(worldX: Int, worldY: Int, plane: Int, filter: Predicate<TileObject?>?): List<TileObject?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), filter)
        }


        fun getAt(worldPoint: WorldPoint, filter: Predicate<TileObject?>?): List<TileObject?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, filter)
        }

        fun getAt(worldPoint: WorldPoint, vararg ids: Int): List<TileObject?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, *ids)
        }

        fun getAt(worldPoint: WorldPoint, vararg names: String): List<TileObject?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, *names)
        }

        fun getAt(tile: Tile?, vararg ids: IntArray): List<TileObject?> {
            return getAt(tile) { x: TileObject? ->
                for (id in ids) {
                    if (id == x!!.id) {
                        return@getAt true
                    }
                }
                false
            }
        }

        fun getAt(tile: Tile?, vararg names: Array<out String>): List<TileObject?> {
            return getAt(tile) { x: TileObject? ->
                if (x!!.name == null) {
                    return@getAt false
                }
                for (name in names) {
                    return@getAt true
                }
                false
            }
        }

        fun getAt(tile: Tile?, filter: Predicate<TileObject?>?): List<TileObject?> {
            return if (tile == null) {
                emptyList<TileObject>()
            } else parseTile(tile, filter)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, vararg ids: Int): TileObject? {
            return getAt(worldX, worldY, plane, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, vararg names: String): TileObject? {
            return getAt(worldX, worldY, plane, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, filter: Predicate<TileObject?>?): TileObject? {
            return getAt(worldX, worldY, plane, filter).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, vararg ids: Int): TileObject? {
            return getAt(worldPoint, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, vararg names: String): TileObject? {
            return getAt(worldPoint, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, filter: Predicate<TileObject?>?): TileObject? {
            return getAt(worldPoint, filter).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile?, vararg ids: Int): TileObject? {
            return getAt(tile, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile?, vararg names: String?): TileObject? {
            return getAt(tile, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile?, filter: Predicate<TileObject?>): TileObject? {
            return getAt(tile, filter).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg ids: Int): TileObject? {
            return getSurrounding(worldX, worldY, plane, radius, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg names: String): TileObject? {
            return getSurrounding(worldX, worldY, plane, radius, *names).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(
            worldX: Int,
            worldY: Int,
            plane: Int,
            radius: Int,
            filter: Predicate<TileObject?>
        ): TileObject? {
            return getSurrounding(worldX, worldY, plane, radius, filter).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, vararg ids: Int): TileObject? {
            return getSurrounding(worldPoint, radius, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, vararg names: String?): TileObject? {
            return getSurrounding(worldPoint, radius, *names).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, filter: Predicate<TileObject?>): TileObject? {
            return getSurrounding(worldPoint, radius, filter).stream().findFirst().orElse(null)
        }

        fun getSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg ids: Int): List<TileObject?> {
            return getSurrounding(worldX, worldY, plane, radius) { x: TileObject? ->
                for (id in ids) {
                    if (id == x!!.id) {
                        return@getSurrounding true
                    }
                }
                false
            }
        }

        fun getSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg names: String): List<TileObject?> {
            return getSurrounding(worldX, worldY, plane, radius) { x: TileObject? ->
                if (x!!.name == null) {
                    return@getSurrounding false
                }
                for (name in names) {
                    if (name == x.name) {
                        return@getSurrounding true
                    }
                }
                false
            }
        }

        fun getSurrounding(
            worldX: Int,
            worldY: Int,
            plane: Int,
            radius: Int,
            filter: Predicate<TileObject?>
        ): List<TileObject?> {
            val out: MutableList<TileObject?> = ArrayList()
            for (x in -radius..radius) {
                for (y in -radius..radius) {
                    val tile: Tile = Tiles.getAt(worldX + x, worldY + y, plane) ?: continue
                    out.addAll(getAt(tile, filter))
                }
            }
            return out
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, vararg ids: Int): List<TileObject?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, *ids)
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, vararg names: String?): List<TileObject?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, *names)
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, filter: Predicate<TileObject?>): List<TileObject?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, filter)
        }

        private fun parseTile(tile: Tile, pred: Predicate<TileObject?>?): List<TileObject?> {
            val filter = label@ Predicate { x: TileObject? ->
                if (!x!!.isDefinitionCached) {
                    return GameThread.invokeLater {
                        x.cachedDefinition // cache it
                        pred.test(x)
                    }
                }
                pred.test(x)
            }
            return getTileObjects(tile).stream()
                .filter(filter)
                .collect(Collectors.toList())
        }

        private fun getTileObjects(tiles: List<Tile>): List<TileObject?> {
            val out: MutableList<TileObject?> = ArrayList()
            for (tile in tiles) {
                out.addAll(getTileObjects(tile))
            }
            val notCached = out.stream()
                .filter { x: TileObject? -> !x!!.isDefinitionCached }
                .collect(Collectors.toList())
            if (!notCached.isEmpty()) {
                GameThread.invokeLater {
                    for (tileObject in notCached) {
                        tileObject!!.definition
                    }
                    true
                }
            }
            return out
        }

        private fun getTileObjects(tile: Tile): List<TileObject?> {
            val out: MutableList<TileObject?> = ArrayList()
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
                    if (gameObject == null || !Game.getClient().isTileObjectValid(tile, gameObject)
                        || gameObject.id == -1
                    ) {
                        continue
                    }
                    out.add(gameObject)
                }
            }
            return out
        }
    }
}