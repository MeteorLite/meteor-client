package meteor.api.movement.pathfinder

import net.runelite.api.coords.WorldPoint

class Transport(var source: WorldPoint, var destination: WorldPoint, var sourceRadius: Int, var destinationRadius: Int,
                var handler: Runnable, var action: String) {}