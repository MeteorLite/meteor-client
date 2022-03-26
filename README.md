# meteor-client

 ![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)  
![OSRS](https://img.shields.io/badge/osrs-204-blue.svg) ![api](https://img.shields.io/badge/api-1.1.5-blue.svg) ![rel](https://img.shields.io/badge/rel-1-blue.svg) ![Build Status](https://img.shields.io/github/workflow/status/meteorlite/meteor-client/Build%20MeteorLite)


A modern Old School Runescape client  
Building depends on artifacts from https://github.com/MeteorLite/meteor-api

- Client separated from build artifacts (api). This cleans up the client project and improves building substantially.
- The client core is 100% Kotlin (plugins may be java or kotlin)
- Uses a Global design that drastically reduces boilerplate from RuneLite's dependency injection design (Koin can be used if need be)
- The UI is built using https://github.com/JetBrains/compose-jb, offering a modern, cross platform solution (client overlays still use swing)
- Uses Unethical apis: https://github.com/unethicalite/unethicalite
- Uses OpenOSRS injector: https://github.com/open-osrs/runelite
- Uses many ideas / functionality from https://github.com/runelite/runelite


## Meteor Kotlin plugin  
```kotlin
package meteor.plugins.fishing

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Actor
import net.runelite.api.GameState
import net.runelite.api.NPC
import org.rationalityfrontline.kevent.Event

@PluginDescriptor("Fishing", configGroup = "fishing")
class FishingPlugin: Plugin() {
    override var config = configuration<FishingConfig>()            // No need for a repetative Provides block here
    val spotsOverlay = overlay(FishingSpotOverlay(this, config))    // Overlays are enabled/disabled automatically if passed through overlay()
    val c = client                                                  // Commonly used objects are provided to plugins by default, this call is an unnecessary example
    val fishingSpots: ArrayList<NPC> = ArrayList()
    val minnowSpots: HashMap<Int, MinnowSpot> = HashMap()
    var currentSpot: FishingSpot? = null

    // No Subscribe annotation, simply override.
    // Defining events as an interface allows IntelliJ auto-complete to list all possible event methods
    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gamestate) {
            GameState.CONNECTION_LOST,
            GameState.LOGIN_SCREEN,
            GameState.HOPPING -> {
                fishingSpots.clear()
                minnowSpots.clear()
            }
            else -> {}
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source == client.localPlayer) {
            if (it.target is NPC) {
                val npc: NPC = it.target as NPC
                val spot: FishingSpot? = FishingSpot.findSpot(npc.id)
                spot?.let { currentSpot = it }
            }
        }
    }

    override fun onNPCSpawned(it: NpcSpawned) {
        if (FishingSpot.findSpot(it.npc.id) != null) {
            fishingSpots.add(it.npc)
        }
    }

    override fun onNPCDespawned(it: NpcDespawned) {
        if (FishingSpot.findSpot(it.npc.id) != null) {
            fishingSpots.remove(it.npc)
        }
    }
}
```
