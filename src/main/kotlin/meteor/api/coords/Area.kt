package meteor.api.coords

import meteor.api.entities.Players
import net.runelite.api.Locatable
import net.runelite.api.coords.WorldPoint

interface Area {
    fun contains(point: WorldPoint): Boolean

    fun contains(locatable: Locatable = Players.local!!): Boolean {
        return contains(locatable.worldLocation)
    }

    companion object {
        fun union(vararg areas: Area): Area {
            return object : Area {
                override fun contains(point: WorldPoint): Boolean {
                    return areas.any { it.contains(point) }
                }
            }
        }

        fun intersect(vararg areas: Area): Area {
            return object : Area {
                override fun contains(point: WorldPoint): Boolean {
                    return areas.all { it.contains(point) }
                }
            }
        }
    }

    fun minus(other: Area): Area {
        return object : Area {
            override fun contains(point: WorldPoint): Boolean {
                return this.contains(point) && !other.contains(point)
            }
        }
    }
}
