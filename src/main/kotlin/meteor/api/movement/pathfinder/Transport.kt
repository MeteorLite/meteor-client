package meteor.api.movement.pathfinder

import net.runelite.api.coords.WorldPoint


data class Transport(var source: WorldPoint? = null,
                     var destination: WorldPoint? = null,
                     var sourceRadius: Int = 0,
                     var destinationRadius: Int = 0,
                     var handler: Runnable? = null,
                     var action: String? = null,) {

}