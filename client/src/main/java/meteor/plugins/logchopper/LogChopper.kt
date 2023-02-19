package meteor.plugins.logchopper

import dev.hoot.api.items.Bank
import eventbus.events.GameTick
import meteor.api.Items
import meteor.api.Objects
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import net.runelite.api.queries.GameObjectQuery


@PluginDescriptor(name = "Log Chopper", description = "Chops down trees", enabledByDefault = false)
class LogChopper : Plugin() {
    val config = configuration<LogChopperConfig>()
    val objects = Objects
    var currentTree = 0
    val trees = listOf(NullObjectID.NULL_30482, NullObjectID.NULL_30480, NullObjectID.NULL_30481)
    var area: WorldArea = WorldArea( WorldPoint(3695, 3801,0), WorldPoint(3748, 3839,0))
    override fun onGameTick(it: GameTick) {
        if (config.useSpec() && !isFull()){
            spec()
        }
        if (client.localPlayer?.isIdle == true) {
            when (config.type()) {
                LogChopperConfig.LogType.Teak -> processBoth()
                LogChopperConfig.LogType.Mahogany -> processBoth()
                LogChopperConfig.LogType.Redwood -> processRedwood()
                else -> processNormal()
            }
        }
    }

    private fun processBoth() {
        if (client.localPlayer?.worldLocation!!.isInArea(area)) {
            processPatches()
        } else processNormal()
    }

    private fun processRedwood(){
        if (isFull()){
            if (config.trees() == LogChopperConfig.MethodType.Drop){
                dropLogs()
            } else {
                if (client.localPlayer?.worldLocation!!.x in 1567..1574) ladderDown()
                else if (bankOpen()) {
                    depositLogs()
                } else useBank()
            }
        } else {
            if (client.localPlayer?.worldLocation!!.x > 1575) {
                return ladderUp()
            }
            chopRedwood()
        }
    }

    private fun processPatches() {
        if (isFull()) {
            if (config.trees() == LogChopperConfig.MethodType.Drop) {
                dropLogs()
            } else {
                if (client.localPlayer?.worldLocation!!.y > 3823) obstacleOut()
                else if (bankOpen()) {
                    depositLogs()
                } else useNullBank()
            }
        } else {
            if (client.localPlayer?.worldLocation!!.y < 3823) {
                return obstacleIn()
            }
            if (!chopMahogany(trees[currentTree])) currentTree = (currentTree + 1) % trees.size
        }
    }

    private fun processNormal() {
        when (config.trees()) {
            LogChopperConfig.MethodType.Bank -> {
                if (!client.localPlayer?.isAnimating!! && !client.localPlayer?.isMoving!! && !isFull()) {
                    chopTree()
                } else if (isFull() && !bankOpen()) {
                    useBank()
                }
                if (bankOpen()) {
                    depositLogs()
                }
            }
            LogChopperConfig.MethodType.Drop -> {
                if (!client.localPlayer?.isAnimating!! && !client.localPlayer?.isMoving!!) {
                    chopTree()
                }
                dropLogs()
            }
        }
    }
    private fun spec() {
        if (client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT) == 1000) {
            client.invokeMenuAction(
                "Use",
                "Special Attack",
                1,
                57,
                -1,
                10485795
            )
        }
    }
    private fun isFull(): Boolean {
        return Items.isFull()
    }

    private fun bankOpen(): Boolean {
        return client.getItemContainer(InventoryID.BANK) != null
    }

    private fun depositLogs() {
        val logs = Items.getFirst(config.type().logID)
        if (logs != null) {
            Items.deposit(logs, 28)
        }
    }

    private fun dropLogs() {
        val logs = Items.getAll(config.type().logID)
        logs?.forEach { it.drop() }
    }

    private fun chopTree() {
        val tree = objects.getFirst(config.type().treeID)
        tree?.interact("Chop down")
    }
    private fun chopRedwood(){
        val redwood = objects.getFirst(ObjectID.REDWOOD_29670, ObjectID.REDWOOD)
        redwood?.interact("Cut")

    }
    private fun useBank() {
        if (!Bank.bankPinIsOpen()) {
            objects.getAll("Bank chest")?.firstOrNull { it.hasAction("Use") }?.interact("Use")
            objects.getAll("Bank booth" )?.firstOrNull { it.hasAction("Bank") }?.interact("Bank")
        }
    }

    private  fun ladderUp(){
        val upLadder = objects.getFirst(ObjectID.ROPE_LADDER_28857)
        upLadder?.interact("Climb-up")
    }
    private fun ladderDown(){
        val downLadder = objects.getFirst(ObjectID.ROPE_LADDER_28858)
        downLadder?.interact("Climb-down")
    }
    private fun obstacleIn() {
        val ob1 = objects.getFirst(ObjectID.HOLE_31481)
        ob1?.interact("Climb through")
    }

    private fun obstacleOut() {
        val ob1 = objects.getFirst(ObjectID.HOLE_31482)
        ob1?.interact("Climb through")
    }

    private fun getGameObject(id: Int): GameObject? {
        return GameObjectQuery().idEquals(id).result(client).nearestTo(client.localPlayer)
    }

    private fun chopMahogany(id: Int): Boolean {
        val comp = client.getObjectDefinition(id)
        val imposter = comp.impostor ?: return false
        if (imposter.actions.contains("Chop down")) {
            val obj = getGameObject(id) ?: return false
            client.invokeMenuAction(
                "Chop down", "Mahogany tree", id, 3, obj.sceneMinLocation.x, obj.sceneMinLocation.y
            )
            return true
        }
        return false
    }

    private fun useNullBank() {
        if (!Bank.bankPinIsOpen()) {
            val obj = getGameObject(31427) ?: return
            client.invokeMenuAction(
                "Use",
                null,
                31427,
                MenuAction.GAME_OBJECT_FIRST_OPTION.id,
                obj.sceneMinLocation.x,
                obj.sceneMinLocation.y
            )
        }
    }
}