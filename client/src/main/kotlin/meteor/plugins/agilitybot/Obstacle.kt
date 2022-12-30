package meteor.plugins.agilitybot

import net.runelite.api.TileObject

class Obstacle {
    val area: Area
    val name: String
    val action: String
    val location // exact location for obstacle, only needed if script tries 2 do prev obstacle agen
            : Location?
    private val isNpc: Boolean
    var id = 0
        private set

    constructor(area: Area, name: String, action: String, npc: Boolean, tile: Location?) {
        this.area = area
        this.name = name
        this.action = action
        isNpc = npc
        location = tile
    }

    constructor(area: Area, name: String, action: String, npc: Boolean, tile: Location?, id: Int) {
        this.area = area
        this.name = name
        this.action = action
        isNpc = npc
        location = tile
        this.id = id
    }

    constructor(location: Area, name: String, action: String, tile: Location?) : this(
        location,
        name,
        action,
        false,
        tile
    )

    constructor(location: Area, name: String, action: String) : this(location, name, action, false, null) {}
}