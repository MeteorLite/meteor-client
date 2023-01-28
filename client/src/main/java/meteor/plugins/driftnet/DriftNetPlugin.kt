/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.driftnet

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableSet
import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import java.util.function.Consumer
import java.util.stream.Collectors

@PluginDescriptor(name = "Drift Net", description = "Display information about drift nets", tags = ["hunter", "fishing", "drift", "net"], enabledByDefault = false)
class DriftNetPlugin : Plugin() {
    private val clientThread = ClientThread
    private val config = configuration<DriftNetConfig>()
    private val overlay = DriftNetOverlay(this, config)
    val fish: MutableSet<NPC> = HashSet()
    val taggedFish: MutableMap<NPC?, Int> = HashMap()
    val NETS: List<DriftNet> = ImmutableList.of(
            DriftNet(NullObjectID.NULL_31433, Varbits.NORTH_NET_STATUS, Varbits.NORTH_NET_CATCH_COUNT, ImmutableSet.of(
                    WorldPoint(3746, 10297, 1),
                    WorldPoint(3747, 10297, 1),
                    WorldPoint(3748, 10297, 1),
                    WorldPoint(3749, 10297, 1)
            )),
            DriftNet(NullObjectID.NULL_31434, Varbits.SOUTH_NET_STATUS, Varbits.SOUTH_NET_CATCH_COUNT, ImmutableSet.of(
                    WorldPoint(3742, 10288, 1),
                    WorldPoint(3742, 10289, 1),
                    WorldPoint(3742, 10290, 1),
                    WorldPoint(3742, 10291, 1),
                    WorldPoint(3742, 10292, 1)
            )))
    var inDriftNetArea = false
    private var armInteraction = false
    var driftNetsInInventory = false
    var annette: GameObject? = null
    override fun onStart() {
        overlayManager.add(overlay)
        if (client.gameState == GameState.LOGGED_IN) {
            clientThread.invokeLater {
                inDriftNetArea = checkArea()
                updateDriftNetVarbits()
            }
        }
    }

    override fun onStop() {
        overlayManager.remove(overlay)
        reset()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState != GameState.LOGGED_IN) {
            annette = null
        }
        when (it.gameState) {
            GameState.LOGIN_SCREEN, GameState.HOPPING, GameState.LOADING -> reset()
            GameState.LOGGED_IN -> {
                inDriftNetArea = checkArea()
                updateDriftNetVarbits()
            }

            else -> {}
        }
    }

    private fun reset() {
        fish.clear()
        taggedFish.clear()
        armInteraction = false
        inDriftNetArea = false
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        updateDriftNetVarbits()
    }

    private fun updateDriftNetVarbits() {
        if (!inDriftNetArea) {
            return
        }
        for (net in NETS) {
            val status: DriftNetStatus? = DriftNetStatus.of(client.getVarbitValue(net.statusVarbit))
            val count = client.getVarbitValue(net.countVarbit)
            net.status = status
            net.count = count
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (armInteraction && it.source === client.localPlayer && it.target is NPC && (it.target as NPC?)!!.id == NpcID.FISH_SHOAL) {
            tagFish(it.target)
            armInteraction = false
        }
    }

    private fun isFishNextToNet(fish: NPC?, nets: Collection<DriftNet>): Boolean {
        val fishTile = WorldPoint.fromLocalInstance(client, fish!!.localLocation)
        return nets.stream().anyMatch { net: DriftNet -> net.adjacentTiles.contains(fishTile) }
    }

    private fun isTagExpired(tick: Int): Boolean {
        return tick + config.timeoutDelay() < client.tickCount
    }

    override fun onGameTick(tick: GameTick) {
        if (!inDriftNetArea) {
            return
        }
        val closedNets = NETS.stream()
                .filter { obj: DriftNet -> obj.isNotAcceptingFish }
                .collect(Collectors.toList())
        taggedFish.entries.removeIf { (key, value): Map.Entry<NPC?, Int> ->
            isTagExpired(value) ||
                    isFishNextToNet(key, closedNets)
        }
        NETS.forEach(Consumer { net: DriftNet -> net.prevTickStatus = net.status })
        armInteraction = false
    }

    override fun onChatMessage(it: ChatMessage) {
        if (!inDriftNetArea) {
            return
        }
        if (it.type == ChatMessageType.SPAM && it.message == CHAT_PRODDING_FISH) {
            val target = client.localPlayer!!.interacting
            if (target is NPC && target.id == NpcID.FISH_SHOAL) {
                tagFish(target)
            } else {
                // If the fish is on an adjacent tile, the interaction change happens after
                // the chat message is sent, so we arm it
                armInteraction = true
            }
        }
    }

    private fun tagFish(fish: Actor?) {
        val fishTarget = fish as NPC?
        taggedFish[fishTarget] = client.tickCount
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc = it.npc
        if (npc.id == NpcID.FISH_SHOAL) {
            fish.add(npc)
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        val npc = it.npc
        fish.remove(npc)
        taggedFish.remove(npc)
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObj = it.gameObject
        if (gameObj.id == ObjectID.ANNETTE) {
            annette = gameObj
        }
        for (net in NETS) {
            if (net.objectId == gameObj.id) {
                net.net = gameObj
            }
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        val gameObj = it.gameObject
        if (gameObj === annette) {
            annette = null
        }
        for (net in NETS) {
            if (net.objectId == gameObj.id) {
                net.net = null
            }
        }
    }

    override fun onItemContainerChanged(it: ItemContainerChanged) {
        val itemContainer = it.itemContainer
        if (itemContainer !== client.getItemContainer(InventoryID.INVENTORY)) {
            return
        }
        driftNetsInInventory = itemContainer.contains(ItemID.DRIFT_NET)
    }

    private fun checkArea(): Boolean {
        val localPlayer = client.localPlayer
        if (localPlayer == null || !client.isInInstancedRegion) {
            return false
        }
        val point = WorldPoint.fromLocalInstance(client, localPlayer.localLocation)
        return point.regionID == UNDERWATER_REGION
    }

    companion object {
        const val CONFIG_GROUP = "driftnet"
        private const val UNDERWATER_REGION = 15008
        private const val CHAT_PRODDING_FISH = "You prod at the shoal of fish to scare it."
    }
}