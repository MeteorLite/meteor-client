package meteor.plugins.questrunner

import meteor.api.coords.RectangularArea
import meteor.api.entities.Loot
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.api.movement.Movement
import net.runelite.api.coords.WorldPoint

object Util {
    fun openObstacle(id: Int, loc: WorldPoint) : Boolean {
        val closedWheatGate = Objects.getAt(loc, id)
        if (closedWheatGate.isNotEmpty()) {
            closedWheatGate.first()!!.interact("Open")
            return true
        }
        return false
    }

    fun openObstacle(id: Int) : Boolean {
        val obj = Objects.getNearest(id)
        if (obj != null) {
            obj.interact("Open")
            return true
        }
        return false
    }

    fun pickupItem(id: Int) : Boolean {
        val loot = Loot.getNearest(id)
        if (loot != null) {
            loot.pickup()
            return true
        }
        return false
    }

    fun interactObject(id: Int, action: Any, waitTicks: Int = 0) : Boolean {
        if (QuestRunnerPlugin.waitTicks == 0) {
            val obj = Objects.getNearest(id)
            if (obj != null) {
                if (action is Int)
                    obj.interact(action)
                else if (action is String)
                    obj.interact(action)
                QuestRunnerPlugin.waitTicks = waitTicks
                return true
            }
        }
        return false
    }

    fun travelWorldArea(area: RectangularArea, distance: Int = 7) : Boolean {
        val randomPoint = area.getRandomTile()
        if (randomPoint.distanceTo(Players.local.worldLocation) > distance) {
            QuestRunnerPlugin.walkTarget = randomPoint
            Movement.walkTo(QuestRunnerPlugin.walkTarget!!)
            return true
        }
        return false
    }
}