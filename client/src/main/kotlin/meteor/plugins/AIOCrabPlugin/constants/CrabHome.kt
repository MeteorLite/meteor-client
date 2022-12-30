package meteor.plugins.AIOCrabPlugin.constants

import net.runelite.api.coords.WorldPoint

enum class CrabHome(val home: WorldPoint, val location: String, val npc1: String) {
    RELLEKA_NORTH(
        WorldPoint(2704, 3726, 0),
        "Rellekka",
        "Rock Crab"
    ),
    RELLEKA_SOUTH(
        WorldPoint(2701, 3719, 0),
        "Rellekka",
        "Rock Crab")
//    FOSSIL_ISLAND_(WorldPoint(0,0,0), "Fossil Island"),
//    KOUREND_(WorldPoint(0,0,0), "Kourend"),
}