package meteor.plugins.crabfighter

import meteor.config.legacy.Config
import net.runelite.api.Client
import net.runelite.api.coords.WorldPoint

interface AIOPlayerInfo {
    var config: Config
    var client: Client

    var location: WorldPoint
    var state: Int
    var health: Double
}