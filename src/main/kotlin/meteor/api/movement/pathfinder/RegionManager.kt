package meteor.api.movement.pathfinder

import meteor.Logger
import net.runelite.api.coords.WorldPoint

object RegionManager {
    const val API_URL = "http://174.138.15.181:8080"
    val logger = Logger.getLogger(javaClass)

    fun isTransport(transports: List<Transport>, from: WorldPoint, to: WorldPoint): Boolean {
        return transports.stream()
            .anyMatch { t: Transport -> t.source.equals(from) && t.destination.equals(to) }
    }
}