package meteor.plugins.agility

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import net.runelite.api.ItemID
import net.runelite.api.Tile
import net.runelite.api.TileObject

@Suppress("UnstableApiUsage", "NAME_SHADOWING")
@PluginDescriptor(
    name = "Agility",
    description = "Show helpful information about agility courses and obstacles",
    enabledByDefault = true,
    configGroup = "agility"
)
class AgilityPlugin : Plugin() {
    var overlay = overlay(AgilityOverlay(this))
    val obstacles: MutableMap<TileObject, Obstacle> = HashMap()
    var marks: MutableList<Tile> = ArrayList()

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            marks.clear()
            obstacles.clear()
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        onTileObject(it.tile, null, it.gameObject)
    }

    override fun onGameObjectChanged(it: GameObjectChanged) {
        onTileObject(it.tile, it.oldObject, it.newObject)
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        onTileObject(it.tile, it.gameObject, null)
    }

    override fun onGroundObjectSpawned(it: GroundObjectSpawned) {
        onTileObject(it.tile, null, it.groundObject)
    }

    override fun onGroundObjectChanged(it: GroundObjectChanged) {
        onTileObject(it.tile, it.previous, it.groundObject)
    }

    override fun onGroundObjectDespawned(it: GroundObjectDespawned) {
        onTileObject(it.tile, it.groundObject, null)
    }

    override fun onWallObjectSpawned(it: WallObjectSpawned) {
        onTileObject(it.tile, null, it.wallObject)
    }

    override fun onWallObjectChanged(it: WallObjectChanged) {
        onTileObject(it.tile, it.previous, it.wallObject)
    }

    override fun onWallObjectDespawned(it: WallObjectDespawned) {
        onTileObject(it.tile, it.wallObject, null)
    }

    override fun onDecorativeObjectSpawned(it: DecorativeObjectSpawned) {
        onTileObject(it.tile, null, it.decorativeObject)
    }

    override fun onDecorativeObjectChanged(it: DecorativeObjectChanged) {
        onTileObject(it.tile, it.previous, it.decorativeObject)
    }

    override fun onDecorativeObjectDespawned(it: DecorativeObjectDespawned) {
        onTileObject(it.tile, it.decorativeObject, null)
    }

    override fun onItemSpawned(it: ItemSpawned) {
        if (it.item.getId() == ItemID.MARK_OF_GRACE) {
            marks.add(it.tile)
        }
    }

    override fun onItemDespawned(it: ItemDespawned) {
        if (it.item.getId() == ItemID.MARK_OF_GRACE) {
            marks.remove(it.tile)
        }
    }

    private fun onTileObject(tile: Tile?, oldObject: TileObject?, newObject: TileObject?) {
        obstacles.remove(oldObject)
        if (newObject == null) {
            return
        }
        if (Obstacles.OBSTACLE_IDS.contains(newObject.id) ||
            Obstacles.PORTAL_OBSTACLE_IDS.contains(newObject.id) ||
            (Obstacles.TRAP_OBSTACLE_IDS.contains(newObject.id)
                    && Obstacles.TRAP_OBSTACLE_REGIONS.contains(newObject.worldLocation.regionID))
            ||
            Obstacles.SEPULCHRE_OBSTACLE_IDS.contains(newObject.id) ||
            Obstacles.SEPULCHRE_SKILL_OBSTACLE_IDS.contains(newObject.id)
        ) {
            obstacles[newObject] = Obstacle(tile!!, null)
        }
        if (Obstacles.SHORTCUT_OBSTACLE_IDS!!.containsKey(newObject.id)) {
            var closestShortcut: AgilityShortcut? = null
            var distance = -1

            // Find the closest shortcut to this object
            for (shortcut in Obstacles.SHORTCUT_OBSTACLE_IDS!![newObject.id]) {
                if (!shortcut!!.matches(newObject)) {
                    continue
                }
                if (shortcut.worldLocation == null) {
                    closestShortcut = shortcut
                    break
                } else {
                    val newDistance: Int = shortcut.worldLocation.distanceTo2D(newObject.worldLocation)
                    if (closestShortcut == null || newDistance < distance) {
                        closestShortcut = shortcut
                        distance = newDistance
                    }
                }
            }
            if (closestShortcut != null) {
                obstacles[newObject] = Obstacle(tile!!, closestShortcut)
            }
        }
    }
}