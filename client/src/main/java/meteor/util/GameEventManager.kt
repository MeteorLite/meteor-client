/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.util

import eventbus.Events
import eventbus.events.*
import meteor.Main
import meteor.plugins.EventSubscriber
import meteor.rs.ClientThread
import net.runelite.api.*
import java.util.*
import java.util.function.Consumer

object GameEventManager {
    private val clientThread = ClientThread
    private val client = Main.client

    /**
     * Iterates over each tile in the scene if player is logged in
     *
     * @param consumer consumer accepting tile as parameter
     */
    private fun forEachTile(consumer: Consumer<Tile>) {
        val scene = client.scene
        val tiles = scene.tiles
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    val tile = tiles[z][x][y] ?: continue
                    consumer.accept(tile)
                }
            }
        }
    }

    /**
     * Simulate game events for EventBus subscriber
     *
     * @param subscriber EventBus subscriber
     */
    fun simulateGameEvents(subscriber: EventSubscriber) {
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        clientThread.invoke {
            subscriber.subscribe()
            for (itemContainer in client.itemContainers) {
                Main.eventBus.post(Events.ITEM_CONTAINER_CHANGED, ItemContainerChanged(itemContainer.id, itemContainer))
            }
            for (npc in client.cachedNPCs) {
                if (npc != null) {
                    val npcSpawned = NpcSpawned(npc)
                    Main.eventBus.post(Events.NPC_SPAWNED, npcSpawned)
                }
            }
            for (player in client.cachedPlayers) {
                if (player != null) {
                    val playerSpawned = PlayerSpawned(player)
                    Main.eventBus.post(Events.PLAYER_SPAWNED, playerSpawned)
                }
            }
            forEachTile { tile: Tile ->
                Optional.ofNullable(tile.wallObject).ifPresent { wallObj: WallObject ->
                    val objectSpawned = WallObjectSpawned(tile, wallObj)
                    Main.eventBus.post(Events.WALL_OBJECT_SPAWNED, objectSpawned)
                }
                Optional.ofNullable(tile.decorativeObject).ifPresent { decObj: DecorativeObject ->
                    val objectSpawned = DecorativeObjectSpawned(tile, decObj)
                    Main.eventBus.post(Events.DECORATIVE_OBJECT_SPAWNED, objectSpawned)
                }
                Optional.ofNullable(tile.groundObject).ifPresent { gndObj: GroundObject ->
                    val objectSpawned = GroundObjectSpawned(tile, gndObj)
                    Main.eventBus.post(Events.GROUND_OBJECT_SPAWNED, objectSpawned)
                }
                Arrays.stream(tile.gameObjects)
                    .filter { obj: GameObject? -> Objects.nonNull(obj) }
                    .filter { obj: GameObject? -> obj?.sceneMinLocation == tile.sceneLocation }
                    .forEach { obj: GameObject? ->
                        val objectSpawned = GameObjectSpawned(tile, obj!!)
                        Main.eventBus.post(Events.GAME_OBJECT_SPAWNED, objectSpawned)
                    }
                Optional.ofNullable(tile.itemLayer).ifPresent { itemLayer: ItemLayer ->
                    var current: Node = itemLayer.bottom
                    while (current is TileItem) {
                        val itemSpawned = ItemSpawned(tile, current)
                        Main.eventBus.post(Events.ITEM_SPAWNED, itemSpawned)
                        current = current.getNext()
                    }
                }
            }
        }
    }
}