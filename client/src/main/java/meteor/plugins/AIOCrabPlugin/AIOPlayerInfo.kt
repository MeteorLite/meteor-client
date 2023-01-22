package meteor.plugins.AIOCrabPlugin

import meteor.config.legacy.Config
import meteor.plugins.AIOCrabPlugin.constants.StateController
import net.runelite.api.Client
import net.runelite.api.coords.WorldPoint

interface AIOPlayerInfo {
    var config: Config
    var client: Client

    var location: WorldPoint
    var state: StateController
    var health: Double
}