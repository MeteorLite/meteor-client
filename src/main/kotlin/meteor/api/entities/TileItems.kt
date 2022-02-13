package meteor.api.entities

import Main.client
import meteor.api.game.GameThread
import meteor.api.scene.Tiles
import net.runelite.api.Tile
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint
import java.util.ArrayList
import java.util.function.Predicate
import java.util.stream.Collectors

class TileItems : Entities<TileItem>() {
    override fun all(filter: Predicate<in TileItem>): List<TileItem?> {
        return Tiles.tiles.stream()
            .flatMap { tile -> parseTile(tile, filter).stream() }
            .collect(Collectors.toList())
    }

    companion object {
        private val TILE_ITEMS = TileItems()
        fun getAll(filter: Predicate<TileItem>): List<TileItem?> {
            return TILE_ITEMS.all(filter)
        }

        fun getAll(vararg ids: Int): List<TileItem?>? {
            return TILE_ITEMS.all(*ids)
        }

        fun getAll(vararg names: String): List<TileItem?>? {
            return TILE_ITEMS.all(*names)
        }

        fun getNearest(filter: Predicate<TileItem?>): TileItem? {
            return getNearest(Players.local.worldLocation, filter)
        }

        fun getNearest(vararg ids: Int): TileItem? {
            return getNearest(Players.local.worldLocation, *ids)
        }

        fun getNearest(vararg names: String): TileItem? {
            return getNearest(Players.local.worldLocation, *names)
        }

        fun getNearest(to: WorldPoint?, filter: Predicate<TileItem?>): TileItem? {
            return TILE_ITEMS.nearest(to, filter)
        }

        fun getNearest(to: WorldPoint?, vararg ids: Int): TileItem? {
            return TILE_ITEMS.nearest(to, *ids)
        }

        fun getNearest(to: WorldPoint?, vararg names: String): TileItem? {
            return TILE_ITEMS.nearest(to, *names)
        }

        fun getAt(worldX: Int, worldY: Int, plane: Int, vararg ids: Int?): List<TileItem?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), ids)
        }


        fun getAt(worldX: Int, worldY: Int, plane: Int, vararg names: String): List<TileItem?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), names)
        }



        fun getAt(worldX: Int, worldY: Int, plane: Int, filter: Predicate<TileItem>): List<TileItem?> {
            return getAt(Tiles.getAt(worldX, worldY, plane), filter)
        }



        fun getAt(worldPoint: WorldPoint, filter: Predicate<TileItem>): List<TileItem?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, filter)
        }

        fun getAt(worldPoint: WorldPoint, vararg ids: Int?): List<TileItem?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, *ids)
        }

        fun getAt(worldPoint: WorldPoint, names:Array<out String>): List<TileItem?> {
            return getAt(worldPoint.x, worldPoint.y, worldPoint.plane, *names)
        }

        fun getAt(tile: Tile?,  ids: Array<out Int?>): List<TileItem?> {
            return getAt(tile) { x: TileItem ->
                for (id in ids) {
                    if (id == x.id) {
                        return@getAt true
                    }
                }
                false
            }
        }

        fun getAt(tile: Tile?, names: Array<out String>): List<TileItem?> {
            return getAt(tile) { x: TileItem ->
                if (x.name == null) {
                    return@getAt false
                }
                for (name in names) {
                    if (name == x.name) {
                        return@getAt true
                    }
                }
                false
            }
        }

        fun getAt(tile: Tile?, filter: Predicate<TileItem>): List<TileItem?> {
            return if (tile == null) {
                emptyList<TileItem>()
            } else parseTile(tile, filter)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, vararg ids: Int?): TileItem? {
            return getAt(worldX, worldY, plane, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, vararg names: String): TileItem? {
            return getAt(worldX, worldY, plane, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldX: Int, worldY: Int, plane: Int, filter: Predicate<TileItem>): TileItem? {
            return getAt(worldX, worldY, plane, filter).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, vararg ids: Int?): TileItem? {
            return getAt(worldPoint, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, vararg names: String): TileItem? {
            return getAt(worldPoint, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(worldPoint: WorldPoint, filter: Predicate<TileItem>): TileItem? {
            return getAt(worldPoint, filter).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile, vararg ids: Int): TileItem {
            return getAt(tile, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile, vararg names: String): TileItem {
            return getAt(tile, *names).stream().findFirst().orElse(null)
        }

        fun getFirstAt(tile: Tile?, filter: Predicate<TileItem>): TileItem? {
            return getAt(tile, filter).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg ids: Int): TileItem? {
            return getSurrounding(worldX, worldY, plane, radius, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg names: String): TileItem? {
            return getSurrounding(worldX, worldY, plane, radius, *names).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(
            worldX: Int,
            worldY: Int,
            plane: Int,
            radius: Int,
            filter: Predicate<TileItem>
        ): TileItem? {
            return getSurrounding(worldX, worldY, plane, radius, filter).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, vararg ids: Int): TileItem? {
            return getSurrounding(worldPoint, radius, *ids).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, vararg names: String): TileItem? {
            return getSurrounding(worldPoint, radius, *names).stream().findFirst().orElse(null)
        }

        fun getFirstSurrounding(worldPoint: WorldPoint, radius: Int, filter: Predicate<TileItem>): TileItem? {
            return getSurrounding(worldPoint, radius, filter).stream().findFirst().orElse(null)
        }

        fun getSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg ids: Int): List<TileItem?> {
            return getSurrounding(worldX, worldY, plane, radius) { x: TileItem ->
                for (id in ids) {
                    if (id == x.id) {
                        return@getSurrounding true
                    }
                }
                false
            }
        }

        fun getSurrounding(worldX: Int, worldY: Int, plane: Int, radius: Int, vararg names: String): List<TileItem?> {
            return getSurrounding(worldX, worldY, plane, radius) { x: TileItem ->
                if (x.name == null) {
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
            filter: Predicate<TileItem>
        ): List<TileItem?> {
            val out: MutableList<TileItem?> = ArrayList()
            for (x in -radius..radius) {
                for (y in -radius..radius) {
                    val tile: Tile = Tiles.getAt(worldX + x, worldY + y, plane) ?: continue
                    out.addAll(getAt(tile, filter))
                }
            }
            return out
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, vararg ids: Int): List<TileItem?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, *ids)
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, vararg names: String): List<TileItem?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, *names)
        }

        fun getSurrounding(worldPoint: WorldPoint, radius: Int, filter: Predicate<TileItem>): List<TileItem?> {
            return getSurrounding(worldPoint.x, worldPoint.y, worldPoint.plane, radius, filter)
        }

        private fun parseTile(tile: Tile, pred: Predicate<in TileItem>): List<TileItem?> {
            val out: MutableList<TileItem?> = ArrayList()
            if (tile.groundItems != null) {
                for (item in tile.groundItems) {
                    if (item == null || item.id == -1) {
                        continue
                    }
                    if (!client.isItemDefinitionCached(item.id)) {
                        GameThread.invokeLater { client.getItemComposition(item.id) }
                    }
                    if (!pred.test(item)) {
                        continue
                    }
                    out.add(item)
                }
            }
            return out
        }
    }
}