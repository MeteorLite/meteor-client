/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2020, Anthony Alves
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
package meteor.plugins.gauntletextended.resource

import meteor.Main
import meteor.game.ItemManager
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.util.Text
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import java.util.regex.Pattern

class ResourceManager(private val plugin: GauntletExtendedPlugin, private val config: GauntletExtendedConfig) {
    private val client = Main.client
    private val itemManager = ItemManager
    private val infoBoxManager = InfoBoxManager
    private val resources: MutableMap<Resource?, ResourceCounter?> = mutableMapOf()
    private var region = Region.UNKNOWN
    private var prefix: String? = null
    fun init() {
        prefix = if (isLootVarbitSet) MESSAGE_UNTRADEABLE_DROP else namedDropMessage
        region = getRegion()
        createCustomCounters()
    }

    fun reset() {
        prefix = null
        region = Region.UNKNOWN
        resources.clear()
        infoBoxManager.removeIf { obj: InfoBox? -> ResourceCounter::class.java.isInstance(obj) }
    }

    fun parseChatMessage(chatMessage: String) {
        var chatMessage = chatMessage
        if (config.resourceTracker() == GauntletExtendedConfig.ResourceFilter.OFF || region == Region.UNKNOWN || prefix == null) {
            return
        }
        chatMessage = Text.removeTags(chatMessage)
        if (chatMessage.startsWith(prefix!!)) {
            chatMessage = chatMessage.replace(prefix!!, "")
            processNpcResource(chatMessage)
        } else {
            processSkillResource(chatMessage)
        }
    }

    private fun processNpcResource(chatMessage: String) {
        val matcher = PATTERN_RESOURCE_DROP.matcher(chatMessage)
        if (!matcher.matches()) {
            return
        }
        val itemName = matcher.group("name") ?: return
        val resource: Resource? = Resource.fromName(itemName, region == Region.CORRUPTED)
        if (resource == null ||
            config.resourceTracker() == GauntletExtendedConfig.ResourceFilter.CUSTOM && !resources.containsKey(resource) ||
            config.resourceTracker() == GauntletExtendedConfig.ResourceFilter.BASIC && isNonBasicResource(resource)
        ) {
            return
        }
        val quantity = matcher.group("quantity")
        val itemCount = quantity?.toInt() ?: 1
        processResource(resource, itemCount)
    }

    private fun processSkillResource(chatMessage: String) {
        val mapping: Map<Resource, Int> = Resource.fromPattern(
            chatMessage,
            region == Region.CORRUPTED
        )
            ?: return
        val resource = mapping.keys.iterator().next()
        if (config.resourceTracker() == GauntletExtendedConfig.ResourceFilter.CUSTOM && !resources.containsKey(resource)) {
            return
        }
        val itemCount = mapping[resource]!!
        processResource(resource, itemCount)
    }

    private fun processResource(resource: Resource, itemCount: Int) {
        if (!resources.containsKey(resource)) {
            initResource(resource, itemCount)
        } else {
            val counter = resources[resource]
            if (config.resourceTracker() == GauntletExtendedConfig.ResourceFilter.CUSTOM) {
                counter!!.decrementCount(itemCount)
            } else {
                counter!!.incrementCount(itemCount)
            }
        }
    }

    private fun initResource(resource: Resource, itemCount: Int) {
        val counter = ResourceCounter(
            plugin, resource,
            itemManager.getImage(resource.itemId), itemCount
        )
        resources[resource] = counter
        infoBoxManager.addInfoBox(counter)
    }

    private fun createCustomCounters() {
        if (config.resourceTracker() != GauntletExtendedConfig.ResourceFilter.CUSTOM || region == Region.UNKNOWN) {
            return
        }
        val ore = config.resourceOre()
        val bark = config.resourceBark()
        val tirinum = config.resourceTirinum()
        val grym = config.resourceGrym()
        val frame = config.resourceFrame()
        val fish = config.resourcePaddlefish()
        val shard = config.resourceShard()
        val bowstring = config.resourceBowstring()
        val spike = config.resourceSpike()
        val orb = config.resourceOrb()
        val corrupted = region == Region.CORRUPTED
        if (ore > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_ORE else Resource.CRYSTAL_ORE, ore)
        }
        if (bark > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_PHREN_BARK else Resource.PHREN_BARK, bark)
        }
        if (tirinum > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_LINUM_TIRINUM else Resource.LINUM_TIRINUM, tirinum)
        }
        if (grym > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_GRYM_LEAF else Resource.GRYM_LEAF, grym)
        }
        if (frame > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_WEAPON_FRAME else Resource.WEAPON_FRAME, frame)
        }
        if (fish > 0) {
            initResource(Resource.RAW_PADDLEFISH, fish)
        }
        if (shard > 0) {
            initResource(if (corrupted) Resource.CORRUPTED_SHARDS else Resource.CRYSTAL_SHARDS, shard)
        }
        if (bowstring) {
            initResource(if (corrupted) Resource.CORRUPTED_BOWSTRING else Resource.CRYSTALLINE_BOWSTRING, 1)
        }
        if (spike) {
            initResource(if (corrupted) Resource.CORRUPTED_SPIKE else Resource.CRYSTAL_SPIKE, 1)
        }
        if (orb) {
            initResource(if (corrupted) Resource.CORRUPTED_ORB else Resource.CRYSTAL_ORB, 1)
        }
    }

    private val namedDropMessage: String?
        get() {
            val player = client.localPlayer ?: return null
            return player.name + " received a drop: "
        }
    private val isLootVarbitSet: Boolean
        get() = client.getVarbitValue(5399) == 1 &&
                client.getVarbitValue(5402) == 1

    private fun getRegion(): Region {
        val regionId = client.mapRegions[0]
        if (regionId == CORRUPTED_GAUNTLET_REGION_ID) {
            return Region.CORRUPTED
        }
        return if (regionId == NORMAL_GAUNTLET_REGION_ID) {
            Region.NORMAL
        } else Region.UNKNOWN
    }

    private enum class Region {
        UNKNOWN, NORMAL, CORRUPTED
    }

    companion object {
        private const val NORMAL_GAUNTLET_REGION_ID = 7512
        private const val CORRUPTED_GAUNTLET_REGION_ID = 7768
        private const val MESSAGE_UNTRADEABLE_DROP = "Untradeable drop: "
        private val PATTERN_RESOURCE_DROP = Pattern.compile("((?<quantity>\\d+) x )?(?<name>.+)")
        private fun isNonBasicResource(resource: Resource): Boolean {
            return when (resource) {
                Resource.TELEPORT_CRYSTAL, Resource.CORRUPTED_TELEPORT_CRYSTAL, Resource.WEAPON_FRAME, Resource.CORRUPTED_WEAPON_FRAME, Resource.CRYSTALLINE_BOWSTRING, Resource.CORRUPTED_BOWSTRING, Resource.CRYSTAL_SPIKE, Resource.CORRUPTED_SPIKE, Resource.CRYSTAL_ORB, Resource.CORRUPTED_ORB -> true
                else -> false
            }
        }
    }
}