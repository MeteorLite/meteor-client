package meteor.api.scene

import Main.client
import meteor.Logger
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.util.ArrayList
import java.util.function.Predicate


object Tiles {
    private val log: Logger = Logger("Tiles")
    fun getTiles(filter: Predicate<Tile?>): List<Tile> {
        val out: MutableList<Tile> = ArrayList()
        for (x in 0 until Constants.SCENE_SIZE) {
            for (y in 0 until Constants.SCENE_SIZE) {
                val tile: Tile? = client.scene.tiles[client.plane][x][y]
                if (tile != null && filter.test(tile)) {
                    out.add(tile)
                }
            }
        }
        return out
    }

    val tiles: List<Tile>
        get() = getTiles { true }

    fun getAt(worldPoint: WorldPoint): Tile? {
        return getAt(worldPoint.x, worldPoint.y, worldPoint.plane)
    }

    fun getAt(localPoint: LocalPoint): Tile {
        return client.scene.tiles[client.plane][localPoint.sceneX][localPoint.sceneY]
    }

    fun getAt(worldX: Int, worldY: Int, plane: Int): Tile? {
        if (!WorldPoint.isInScene(client, worldX, worldY)) {
            return null
        }
        val x: Int = worldX - client.baseX
        val y: Int = worldY - client.baseY
        return client.scene.tiles[plane][x][y]
    }

    val hoveredTile: Tile?
        get() = client.selectedSceneTile

    private fun findTileObject(x: Int, y: Int, id: Int): TileObject? {
        val scene: Scene = client.scene
        val tiles = scene.tiles
        val tile = tiles[client.plane][x][y]
        if (tile != null) {
            for (gameObject in tile.gameObjects) {
                if (gameObject != null && gameObject.id == id) {
                    return gameObject
                }
            }
            val wallObject = tile.wallObject
            if (wallObject != null && wallObject.id == id) {
                return wallObject
            }
            val decorativeObject = tile.decorativeObject
            if (decorativeObject != null && decorativeObject.id == id) {
                return decorativeObject
            }
            val groundObject = tile.groundObject
            if (groundObject != null && groundObject.id == id) {
                return groundObject
            }
        }
        return null
    }

    private fun findNpc(id: Int): NPC {
        return client.cachedNPCs[id]
    }
}