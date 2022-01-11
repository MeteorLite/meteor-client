package rs117.hd

import eventbus.Events
import eventbus.events.*
import meteor.plugins.EventSubscriber
import meteor.plugins.PluginManager
import org.rationalityfrontline.kevent.KEVENT as EventBus

// This allows java plugins to interface with the new eventbus
class GpuHDEventAdapter : EventSubscriber() {
    fun registerEvents() {
        val hdPlugin = PluginManager.getPlugin<GpuHDPlugin>()!!
        EventBus.subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { hdPlugin.onGameStateChanged(it.data) }
        EventBus.subscribe<ConfigChanged>(Events.CONFIG_CHANGED) { hdPlugin.onConfigChanged(it.data) }
        EventBus.subscribe<ProjectileMoved>(Events.PROJECTILE_MOVED) { hdPlugin.onProjectileMoved(it.data) }
        EventBus.subscribe<NpcSpawned>(Events.NPC_SPAWNED) { hdPlugin.onNpcSpawned(it.data) }
        EventBus.subscribe<NpcDespawned>(Events.NPC_DESPAWNED) { hdPlugin.onNpcDespawned(it.data) }
        EventBus.subscribe<NpcChanged>(Events.NPC_CHANGED) { hdPlugin.onNpcChanged(it.data) }
        EventBus.subscribe<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) { hdPlugin.onGameObjectSpawned(it.data) }
        EventBus.subscribe<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) { hdPlugin.onGameObjectChanged(it.data) }
        EventBus.subscribe<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) { hdPlugin.onGameObjectDespawned(it.data) }
        EventBus.subscribe<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) { hdPlugin.onWallObjectSpawned(it.data) }
        EventBus.subscribe<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) { hdPlugin.onWallObjectChanged(it.data) }
        EventBus.subscribe<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) { hdPlugin.onWallObjectDespawned(it.data) }
        EventBus.subscribe<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) { hdPlugin.onDecorativeObjectSpawned(
            it.data
        ) }
        EventBus.subscribe<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) { hdPlugin.onDecorativeObjectChanged(
            it.data
        ) }
        EventBus.subscribe<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) { hdPlugin.onDecorativeObjectDespawned(
            it.data
        ) }
        EventBus.subscribe<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) { hdPlugin.onGroundObjectSpawned(it.data) }
        EventBus.subscribe<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) { hdPlugin.onGroundObjectChanged(it.data) }
        EventBus.subscribe<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) { hdPlugin.onGroundObjectDespawned(it.data) }
        EventBus.subscribe<ItemSpawned>(Events.ITEM_SPAWNED) { hdPlugin.onItemSpawned(it.data) }
        EventBus.subscribe<ItemDespawned>(Events.ITEM_DESPAWNED) { hdPlugin.onItemDespawned(it.data) }
    }
}