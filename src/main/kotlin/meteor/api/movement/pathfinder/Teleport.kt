package meteor.api.movement.pathfinder

import net.runelite.api.coords.WorldPoint

class Teleport(var destination: WorldPoint, var radius: Int, var handler: Runnable)