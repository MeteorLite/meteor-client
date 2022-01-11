package meteor.plugins.agility

import eventbus.events.*

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import net.runelite.api.ItemID
import net.runelite.api.Tile
import net.runelite.api.TileObject
import org.rationalityfrontline.kevent.Event
import java.util.ArrayList

@Suppress("UnstableApiUsage")
@PluginDescriptor(
    name = "Agility",
    description = "Show helpful information about agility courses and obstacles",
    enabledByDefault = true,
    configGroup = "agility"
)
class AgilityPlugin : Plugin() {
    var overlay = overlay<AgilityOverlay>(AgilityOverlay(this))
    val obstacles: MutableMap<TileObject, Obstacle> = HashMap()
    var marks: MutableList<Tile> = ArrayList()

    override fun onGameStateChanged():((Event<GameStateChanged>)->Unit) =  {
        val it = it.data
        if (it.new == GameState.LOADING) {
            marks.clear()
            obstacles.clear()
        }
    }

    override fun onGameObjectSpawned():((Event<GameObjectSpawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, null, it.gameObject)
    }

    override fun onGameObjectChanged():((Event<GameObjectChanged>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.oldObject, it.newObject)
    }

    override fun onGameObjectDespawned():((Event<GameObjectDespawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.gameObject, null)
    }

    override fun onGroundObjectSpawned():((Event<GroundObjectSpawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, null, it.groundObject)
    }

    override fun onGroundObjectChanged():((Event<GroundObjectChanged>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.previous, it.groundObject)
    }

    override fun onGroundObjectDespawned():((Event<GroundObjectDespawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.groundObject, null)
    }

    override fun onWallObjectSpawned():((Event<WallObjectSpawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, null, it.wallObject)
    }

    override fun onWallObjectChanged():((Event<WallObjectChanged>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.previous, it.wallObject)
    }

    override fun onWallObjectDespawned():((Event<WallObjectDespawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.wallObject, null)
    }

    override fun onDecorativeObjectSpawned():((Event<DecorativeObjectSpawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, null, it.decorativeObject)
    }

    override fun onDecorativeObjectChanged():((Event<DecorativeObjectChanged>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.previous, it.decorativeObject)
    }

    override fun onDecorativeObjectDespawned():((Event<DecorativeObjectDespawned>)->Unit) =  {
        val it = it.data
        onTileObject(it.tile, it.decorativeObject, null)
    }

    override fun onItemSpawned():((Event<ItemSpawned>)->Unit) =  {
        val it = it.data
        if (it.item.id == ItemID.MARK_OF_GRACE) {
            marks.add(it.tile)
        }
    }

    override fun onItemDespawned():((Event<ItemDespawned>)->Unit) =  {
        val it = it.data
        if (it.item.id == ItemID.MARK_OF_GRACE) {
            marks.remove(it.tile)
        }
    }

    private fun onTileObject(tile: Tile, oldObject: TileObject?, newObject: TileObject?) {
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
            obstacles[newObject] = Obstacle(tile, null)
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
                obstacles[newObject] = Obstacle(tile, closestShortcut)
            }
        }
    }
}