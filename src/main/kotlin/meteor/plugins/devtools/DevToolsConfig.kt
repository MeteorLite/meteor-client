package meteor.plugins.devtools

import net.runelite.client.config.*

@ConfigGroup("devtools")
interface DevToolsConfig : Config {
    @ConfigItem(keyName = "playersActive", name = "Players", description = "")
    fun playersActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "npcsActive", name = "NPCs", description = "")
    fun npcsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "groundItemsActive", name = "Ground Items", description = "")
    fun groundItemsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "groundObjectsActive", name = "Ground Objects", description = "")
    fun groundObjectsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "wallsActive", name = "Walls", description = "")
    fun wallsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "gameObjectsActive", name = "Game Objects", description = "")
    fun gameObjectsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "decorationsActive", name = "Ground Decorations", description = "")
    fun decorationsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "tileLocationsActive", name = "Tile Location", description = "")
    fun tileLocationsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "movementFlagsActive", name = "Movement Flags", description = "")
    fun movementFlagsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "inventoryActive", name = "Inventory", description = "")
    fun inventoryActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "projectilesActive", name = "Projectiles", description = "")
    fun projectilesActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "graphcisObjectsActive", name = "Graphics Objects", description = "")
    fun graphcisObjectsActive(): Boolean {
        return false
    }

    @ConfigItem(keyName = "roofsActive", name = "Roofs", description = "")
    fun roofsActive(): Boolean {
        return false
    }
}