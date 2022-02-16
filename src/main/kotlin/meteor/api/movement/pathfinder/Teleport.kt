package meteor.api.movement.pathfinder


import net.runelite.api.coords.WorldPoint


data class Teleport(var destination: WorldPoint? = null,
                    var radius: Int = 0,
                    var handler: Runnable? = null,) {

}