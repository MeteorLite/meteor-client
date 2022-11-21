package meteor.plugins.oneclickagility

import eventbus.events.*
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.GameEventManager
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.widgets.WidgetItem
import java.util.Set

@PluginDescriptor(name = "One Click Agility", description = "Reclined gaming", enabledByDefault = false)
class OneClickAgilityPlugin : Plugin() {

    var gameEventManager = GameEventManager
    var itemManager = ItemManager
    private val config = configuration<OneClickAgilityConfig>()

    var marks = ArrayList<Tile>()
    var portals = ArrayList<GameObject>()
    var pyramidTopObstacle: DecorativeObject? = null
    var pyramidTop: GameObject? = null
    var course: Course? = null
    override fun onStart() {
        resetCourse()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "oneclickagility") {
            resetCourse()
        }
    }

    fun resetCourse() {
        course = CourseFactory.build(config.courseSelection())
        gameEventManager.simulateGameEvents(this)
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption() == "<col=00ff00>One Click Agility") {
            handleClick(it)
        } else if (it.getMenuOption() == "One Click Agility") {
            it.consume()
        }
    }

    override fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) return
        val text: String = if (course!!.getCurrentObstacleArea(client.localPlayer) == null) {
            if (config.consumeMisclicks()) {
                "One Click Agility"
            } else {
                return
            }
        } else {
            "<col=00ff00>One Click Agility"
        }
        client.insertMenuItem(
            text,
            "",
            MenuAction.UNKNOWN.id,
            0,
            0,
            0,
            true
        )
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        if (it.gameObject == null) {
            return
        }
        if (it.gameObject.id == 10869) {
            pyramidTop = it.gameObject
        }
        if (PORTAL_IDS.contains(it.gameObject.id)) {
            portals.add(it.gameObject)
            return
        }
        addToCourse(it.gameObject)
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        if (it?.gameObject == null) {
            return
        }
        if (PORTAL_IDS.contains(it.gameObject.id)) {
            portals.remove(it.gameObject)
            return
        }
        if (it.gameObject.id == 10869) {
            pyramidTop = null
        }
        removeFromCourse(it.gameObject)
    }

    override fun onWallObjectSpawned(it: WallObjectSpawned) {
        addToCourse(it.wallObject)
    }

    override fun onWallObjectDespawned(it: WallObjectDespawned) {
        removeFromCourse(it.wallObject)
    }

    override fun onDecorativeObjectSpawned(it: DecorativeObjectSpawned) {
        if (it.decorativeObject.id == 10851) {
            if (pyramidTopObstacle == null || pyramidTopObstacle!!.y > it.decorativeObject.y) {
                pyramidTopObstacle = it.decorativeObject
                return
            }
        }
        addToCourse(it.decorativeObject)
    }

    override fun onDecorativeObjectDespawned(it: DecorativeObjectDespawned) {
        if (it.decorativeObject.id == 10851 && it.decorativeObject === pyramidTopObstacle) {
            pyramidTopObstacle = null
            return
        }
        removeFromCourse(it.decorativeObject)
    }

    override fun onGroundObjectSpawned(it: GroundObjectSpawned) {
        addToCourse(it.groundObject)
    }

    override fun onGroundObjectDespawned(it: GroundObjectDespawned) {
        removeFromCourse(it.groundObject)
    }

    override fun onItemSpawned(it: ItemSpawned) {
        if (it.item.id == MARK_ID) {
            marks.add(it.tile)
        }
    }

    override fun onItemDespawned(it: ItemDespawned) {
        if (it.item.id == MARK_ID) {
            marks.remove(it.tile)
        }
    }

    private fun addToCourse(tileObject: TileObject) {
        if (course!!.obstacleIDs.contains(tileObject.id)) {
            course!!.addObstacle(tileObject)
        }
    }

    private fun removeFromCourse(tileObject: TileObject) {
        if (course!!.obstacleIDs.contains(tileObject.id)) {
            course!!.removeObstacle(tileObject)
        }
    }

    private fun handleClick(it: MenuOptionClicked) {
        if (config.skillBoost()) {
            val boost = client.getBoostedSkillLevel(Skill.AGILITY) - client.getRealSkillLevel(Skill.AGILITY)
            if (config.boostAmount() > boost) {
                val food = getWidgetItem(SUMMER_PIE_ID)
                if (food != null) {
                    it.menuEntry = createSummerPieMenuEntry(food)
                    return
                }
            }
        }
        if (config.seersTele() && config.courseSelection() == AgilityCourse.SEERS_VILLAGE) {   //spellbook varbit, worldpoint of dropdown tile, teleportation animation ID
            if (client.getVarbitValue(4070) == 0 && client.localPlayer!!
                    .worldLocation == SEERS_END && client.localPlayer!!
                    .animation != 714
            ) {
                it.menuEntry = createSeersTeleportMenuEntry()
                return
            }
        }
        if (config.courseSelection() == AgilityCourse.AGILITY_PYRAMID) {
            if ((client.localPlayer!!
                    .worldLocation == PYRAMID_TOP_RIGHT || client.localPlayer!!
                    .worldLocation == PYRAMID_TOP_LEFT)
                && pyramidTop!!.renderable.modelHeight == 309
            ) {
                it.menuEntry = createPyramidTopMenuEntry()
                return
            }
        }
        val obstacleArea = course!!.getCurrentObstacleArea(client.localPlayer) ?: return
        if (config.pickUpMarks() && !marks.isEmpty()) {
            var wrongMarkTile: Tile? = null
            for (mark in marks) {
                if (obstacleArea.containsObject(mark)) {
                    val markTile = client.scene.tiles[mark.plane][mark.sceneLocation.x][mark.sceneLocation.y]
                    if (markTile != null && checkTileForMark(markTile)) {
                        if (config.pickUpCoins() && checkTileForCoins(markTile)) {
                            it.menuEntry = createCoinsMenuEntry(mark)
                        } else {
                            it.menuEntry = createMarkMenuEntry(mark)
                        }
                        return
                    } else {
                        wrongMarkTile = mark
                    }
                }
            }
            if (wrongMarkTile != null) {
                marks.remove(wrongMarkTile)
            }
        }
        if (portals.isNotEmpty()) {
            for (portal in portals) {
                if (obstacleArea.containsObject(portal) && portal.clickbox != null) {
                    it.menuEntry = createPortalMenuEntry(portal)
                    return
                }
            }
        }
        if (config.consumeMisclicks() &&
            (client.localPlayer!!.isMoving
                    || client.localPlayer!!.poseAnimation != client.localPlayer!!.idlePoseAnimation)
        ) {
            it.consume()
            return
        }
        obstacleArea.createMenuEntry()?.let {thisMenu->
            it.menuEntry = thisMenu
        }
    }

    private fun checkTileForMark(tile: Tile): Boolean {
        val items = tile.groundItems ?: return false
        for (item in items) {
            if (item == null) continue
            if (item.id == MARK_ID) return true
        }
        return false
    }

    private fun checkTileForCoins(tile: Tile): Boolean {
        val items = tile.groundItems ?: return false
        for (item in items) {
            if (item == null) continue
            if (item.id == COIN_ID) return true
        }
        return false
    }

    fun getWidgetItem(ids: Collection<Int?>): WidgetItem? {
        val inventoryWidget = client.getWidget(WidgetInfo.INVENTORY)
        if (inventoryWidget != null) {
            val items = inventoryWidget.widgetItems
            for (item in items) {
                if (ids.contains(item.id)) {
                    return item
                }
            }
        }
        return null
    }

    private fun createSeersTeleportMenuEntry(): MenuEntry {
        return client.createMenuEntry(
            "Seers'",
            "Camelot Teleport",
            2,
            MenuAction.CC_OP.id,
            -1,
            14286879,
            true
        )
    }

    private fun createSummerPieMenuEntry(food: WidgetItem): MenuEntry {
        val foodMenuOptions = itemManager.getItemComposition(food.id)!!.inventoryActions
        return client.createMenuEntry(
            foodMenuOptions[0],
            foodMenuOptions[0],
            food.id,
            MenuAction.ITEM_FIRST_OPTION.id,
            food.index,
            WidgetInfo.INVENTORY.packedId,
            true
        )
    }

    private fun createMarkMenuEntry(tile: Tile): MenuEntry {
        return client.createMenuEntry(
            "Take",
            "Mark of Grace",
            MARK_ID, MenuAction.GROUND_ITEM_THIRD_OPTION.id,
            tile.sceneLocation.x,
            tile.sceneLocation.y,
            true
        )
    }

    private fun createCoinsMenuEntry(tile: Tile): MenuEntry {
        return client.createMenuEntry(
            "Take",
            "Coins",
            COIN_ID, MenuAction.GROUND_ITEM_THIRD_OPTION.id,
            tile.sceneLocation.x,
            tile.sceneLocation.y,
            true
        )
    }

    private fun createPortalMenuEntry(portal: GameObject): MenuEntry {
        return client.createMenuEntry(
            "Travel",
            "Portal",
            portal.id,
            MenuAction.GAME_OBJECT_FIRST_OPTION.id,
            portal.localLocation.sceneX,
            portal.localLocation.sceneY,
            true
        )
    }

    private fun createPyramidTopMenuEntry(): MenuEntry {
        return client.createMenuEntry(
            "Climb",
            "Climbing rocks",
            pyramidTopObstacle!!.id,
            MenuAction.GAME_OBJECT_FIRST_OPTION.id,
            pyramidTopObstacle!!.localLocation.sceneX,
            pyramidTopObstacle!!.localLocation.sceneY,
            true
        )
    }

    companion object {
        private const val MARK_ID = 11849
        private const val COIN_ID = 995
        private val PORTAL_IDS = Set.of(36241, 36242, 36243, 36244, 36245, 36246)
        private val SUMMER_PIE_ID = Set.of(7220, 7218)
        private val SEERS_END = WorldPoint(2704, 3464, 0)
        private val PYRAMID_TOP_RIGHT = WorldPoint(3043, 4697, 3)
        private val PYRAMID_TOP_LEFT = WorldPoint(3042, 4697, 3)
    }
}