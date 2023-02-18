/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.game

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ImmutableMap
import com.google.common.collect.ListMultimap
import eventbus.Events

import eventbus.events.*
import meteor.Logger
import meteor.Main.client
import meteor.events.NpcLootReceived
import meteor.events.PlayerLootReceived
import meteor.plugins.EventSubscriber
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.util.*
import kotlin.math.min

object LootManager:EventSubscriber(){

    private val npcUtil =  NpcUtil
    private val itemSpawns: ListMultimap<Int, ItemStack> = ArrayListMultimap.create()
    private val killPoints: MutableSet<LocalPoint> = HashSet<LocalPoint>()
    private var playerLocationLastTick: WorldPoint? = null
    private var krakenPlayerLocation: WorldPoint? = null
    private var delayedLootNpc: NPC? = null
    private var delayedLootTickLimit = 0
    val log = Logger("LootManager")

init {
    subscribe()
}

    override fun onNpcDespawned(it: NpcDespawned) {
        val npc: NPC = it.npc
        if (npc === delayedLootNpc) {
            delayedLootNpc = null
            delayedLootTickLimit = 0
        }
        if (!npcUtil.isDying(npc)) {
            when (npc.id) {
                NpcID.GARGOYLE, NpcID.GARGOYLE_413, NpcID.GARGOYLE_1543, NpcID.MARBLE_GARGOYLE, NpcID.MARBLE_GARGOYLE_7408, NpcID.DUSK_7888, NpcID.DUSK_7889, NpcID.ROCKSLUG, NpcID.ROCKSLUG_422, NpcID.GIANT_ROCKSLUG, NpcID.SMALL_LIZARD, NpcID.SMALL_LIZARD_463, NpcID.DESERT_LIZARD, NpcID.DESERT_LIZARD_460, NpcID.DESERT_LIZARD_461, NpcID.LIZARD, NpcID.ZYGOMITE, NpcID.ZYGOMITE_1024, NpcID.ANCIENT_ZYGOMITE -> {}
                else -> return
            }
        }
        processNpcLoot(npc)
    }


    override fun onPlayerDespawned(it: PlayerDespawned) {
        val player: Player = it.player
        // Only care about dead Players
        if (player.healthRatio != 0) {
            return
        }
        val location: LocalPoint? = LocalPoint.fromWorld(client, player.worldLocation)
        if (location == null || killPoints.contains(location)) {
            return
        }
        val x: Int = location.sceneX
        val y: Int = location.sceneY
        val packed = x shl 8 or y
        val items: MutableCollection<ItemStack> = itemSpawns[packed]
        if (items.isEmpty()) {
            return
        }
        killPoints.add(location)
        client.callbacks.post(Events.PLAYER_LOOT_RECEIVED,PlayerLootReceived(items,player))
    }

    override fun onItemSpawned(it: ItemSpawned) {
        val item: TileItem = it.item
        val tile: Tile = it.tile
        val location: LocalPoint = tile.localLocation
        val packed: Int = location.sceneX shl 8 or location.sceneY
        itemSpawns.put(packed, ItemStack(item.getId(), item.quantity, location))
        //log.info("Item spawn {} ({}) location {}", item.id, item.quantity, location)
    }

    override fun onItemDespawned(it: ItemDespawned) {
        val item: TileItem = it.item
        val location: LocalPoint = it.tile.localLocation
        //log.debug("Item despawn {} ({}) location {}", item.id, item.quantity, location)
    }

    override fun onItemQuantityChanged(it: ItemQuantityChanged) {
        val item: TileItem = it.item
        val tile: Tile = it.tile
        val location: LocalPoint = tile.localLocation
        val packed: Int = location.sceneX shl 8 or location.sceneY
        val diff: Int = it.newQuantity - it.oldQuantity
        if (diff <= 0) {
            return
        }
        itemSpawns.put(packed, ItemStack(item.getId(), diff, location))
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        if (it.actor !is NPC) {
            return
        }
        val npc = it.actor as NPC
        val id = npc.id

        // We only care about certain NPCs
        val deathAnim = NPC_DEATH_ANIMATIONS[id]

        // Current animation is death animation?
        if (deathAnim != null && deathAnim == npc.animation) {
            if (id == NpcID.CAVE_KRAKEN) {
                // Big Kraken drops loot wherever player is standing when animation starts.
                krakenPlayerLocation = client.localPlayer!!.worldLocation
            } else {
                // These NPCs drop loot on death animation, which is right now.
                processNpcLoot(npc)
            }
        }
    }

    override fun onNpcChanged(it: NpcChanged) {
        val npc: NPC = it.npc
        if (npc.id == NpcID.THE_NIGHTMARE_9433 || npc.id == NpcID.PHOSANIS_NIGHTMARE_9424) {
            delayedLootNpc = npc
            delayedLootTickLimit = 15
        }
    }

    override fun onGameTick(it: GameTick) {
        if (delayedLootNpc != null && delayedLootTickLimit-- > 0) {
            processDelayedLoot()
        }
        playerLocationLastTick = client.localPlayer!!.worldLocation
        itemSpawns.clear()
        killPoints.clear()
    }

    private fun processDelayedLoot() {
        val adjacentLootTile: WorldPoint = getAdjacentSquareLootTile(delayedLootNpc)
        val localPoint: LocalPoint? = LocalPoint.fromWorld(client, adjacentLootTile)
        if (localPoint == null) {
            log.debug("Scene changed away from delayed loot location")
            delayedLootNpc = null
            delayedLootTickLimit = 0
            return
        }
        val sceneX: Int = localPoint.sceneX
        val sceneY: Int = localPoint.sceneY
        val packed = sceneX shl 8 or sceneY
        val itemStacks = itemSpawns[packed]
        if (itemStacks.isEmpty()) {
            // no loot yet
            return
        }
        log.debug("Got delayed loot stack from {}: {}", delayedLootNpc!!.name!!, itemStacks)
        client.callbacks.post(Events.NPC_LOOT_RECEIVED,NpcLootReceived(delayedLootNpc, itemStacks))
        delayedLootNpc = null
        delayedLootTickLimit = 0
    }

    private fun processNpcLoot(npc: NPC) {
        val location: LocalPoint? = LocalPoint.fromWorld(client, getDropLocation(npc, npc.worldLocation))
        if (location == null || killPoints.contains(location)) {
            return
        }
        val x: Int = location.sceneX
        val y: Int = location.sceneY
        val size = npc.composition!!.size

        // Some NPCs drop items onto multiple tiles
        val allItems: MutableCollection<ItemStack> = ArrayList()
        for (i in 0 until size) {
            for (j in 0 until size) {
                val packed = x + i shl 8 or y + j
                val items: Collection<ItemStack> = itemSpawns[packed]
                allItems.addAll(items)
            }
        }
        if (allItems.isEmpty()) {
            return
        }
        killPoints.add(location)
        client.callbacks.post(Events.NPC_LOOT_RECEIVED,NpcLootReceived(npc, allItems))
    }

    private fun getDropLocation(npc: NPC, worldLocation: WorldPoint): WorldPoint? {
        var worldLocation: WorldPoint? = worldLocation
        when (npc.id) {
            NpcID.KRAKEN, NpcID.KRAKEN_6640, NpcID.KRAKEN_6656 -> worldLocation = playerLocationLastTick
            NpcID.CAVE_KRAKEN -> worldLocation = krakenPlayerLocation
            NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044 -> for ((packed, value) in itemSpawns.entries()) {
                if (value.id == ItemID.ZULRAHS_SCALES) {
                    val unpackedX = packed shr 8
                    val unpackedY = packed and 0xFF
                    if (worldLocation != null) {
                        worldLocation = WorldPoint.fromScene(client, unpackedX, unpackedY, worldLocation.plane)
                    }
                    break
                }
            }
            NpcID.VORKATH, NpcID.VORKATH_8058, NpcID.VORKATH_8059, NpcID.VORKATH_8060, NpcID.VORKATH_8061 -> {
                var x: Int = worldLocation!!.x + 3
                var y: Int = worldLocation.y + 3
                if (playerLocationLastTick!!.x < x) {
                    x -= 4
                } else if (playerLocationLastTick!!.x > x) {
                    x += 4
                }
                if (playerLocationLastTick!!.y < y) {
                    y -= 4
                } else if (playerLocationLastTick!!.y > y) {
                    y += 4
                }
                worldLocation = WorldPoint(x, y, worldLocation.getPlane())
            }
            NpcID.NEX, NpcID.NEX_11279, NpcID.NEX_11280, NpcID.NEX_11281, NpcID.NEX_11282 -> {

                // Nex loot is under the player, or under nex
                val localPoint: LocalPoint? = LocalPoint.fromWorld(client, playerLocationLastTick)
                if (localPoint != null) {
                    val x: Int = localPoint.sceneX
                    val y: Int = localPoint.sceneY
                    val packed = x shl 8 or y
                    if (itemSpawns.containsKey(packed)) {
                        return playerLocationLastTick
                    }
                }
            }
        }
        return worldLocation
    }

    private fun getAdjacentSquareLootTile(npc: NPC?): WorldPoint {
        val composition = npc!!.composition
        val worldLocation: WorldPoint = npc.worldLocation
        var x: Int = worldLocation.x
        var y: Int = worldLocation.y
        if (playerLocationLastTick!!.x < x) {
            x -= 1
        } else {
            x += min(playerLocationLastTick!!.x - x, composition!!.size)
        }
        if (playerLocationLastTick!!.y < y) {
            y -= 1
        } else {
            y += min(playerLocationLastTick!!.getY() - y, composition!!.size)
        }
        return WorldPoint(x, y, worldLocation.plane)
    }

    /**
     * Get the list of items present at the provided WorldPoint that spawned this tick.
     *
     * @param worldPoint the location in question
     * @return the list of item stacks
     */
    fun getItemSpawns(worldPoint: WorldPoint?): MutableList<ItemStack> {
        val localPoint: LocalPoint = LocalPoint.fromWorld(client, worldPoint) ?: return mutableListOf()
        val sceneX: Int = localPoint.sceneX
        val sceneY: Int = localPoint.sceneY
        val packed = sceneX shl 8 or sceneY
        val itemStacks = itemSpawns[packed]
        return Collections.unmodifiableList(itemStacks)
    }
    val NPC_DEATH_ANIMATIONS: Map<Int, Int> = ImmutableMap.of(
        NpcID.CAVE_KRAKEN, AnimationID.CAVE_KRAKEN_DEATH
    )
}