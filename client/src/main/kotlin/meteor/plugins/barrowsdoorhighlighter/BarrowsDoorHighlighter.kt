package meteor.plugins.barrowsdoorhighlighter

import com.google.common.collect.ImmutableSet
import eventbus.events.GameStateChanged
import eventbus.events.WallObjectDespawned
import eventbus.events.WallObjectSpawned
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import net.runelite.api.NullObjectID
import net.runelite.api.WallObject


@PluginDescriptor(name = "Barrows Door Highlighter")
class BarrowsDoorHighlighter : Plugin() {
    val doors: MutableSet<WallObject> = HashSet()
    val config = configuration<BarrowsDoorHighlighterConfig>()
    val overlay =  overlay(BarrowsDoorHighlighterOverlay(this))

    override fun onStop() {
        doors.clear()
    }


    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            doors.clear()
        }
    }


    override fun onWallObjectSpawned(it: WallObjectSpawned) {
        val wallObject = it.wallObject
        if (DOOR_IDS.contains(wallObject.id)) {
            doors.add(wallObject)
        }
    }


    override fun onWallObjectDespawned(it: WallObjectDespawned) {
        val wallObject = it.wallObject
        doors.remove(wallObject)
    }

    companion object {
        val DOOR_IDS = ImmutableSet.of(
            NullObjectID.NULL_20681,
            NullObjectID.NULL_20682,
            NullObjectID.NULL_20683,
            NullObjectID.NULL_20684,
            NullObjectID.NULL_20685,
            NullObjectID.NULL_20686,
            NullObjectID.NULL_20687,
            NullObjectID.NULL_20688,
            NullObjectID.NULL_20689,
            NullObjectID.NULL_20690,
            NullObjectID.NULL_20691,
            NullObjectID.NULL_20692,
            NullObjectID.NULL_20693,
            NullObjectID.NULL_20694,
            NullObjectID.NULL_20695,
            NullObjectID.NULL_20696,
            NullObjectID.NULL_20700,
            NullObjectID.NULL_20701,
            NullObjectID.NULL_20702,
            NullObjectID.NULL_20703,
            NullObjectID.NULL_20704,
            NullObjectID.NULL_20705,
            NullObjectID.NULL_20706,
            NullObjectID.NULL_20707,
            NullObjectID.NULL_20708,
            NullObjectID.NULL_20709,
            NullObjectID.NULL_20710,
            NullObjectID.NULL_20711,
            NullObjectID.NULL_20712,
            NullObjectID.NULL_20713,
            NullObjectID.NULL_20714,
            NullObjectID.NULL_20715
        )
    }
}