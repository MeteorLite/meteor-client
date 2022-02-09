/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 * Copyright (c) 2021, BickusDiggus <https://github.com/BickusDiggus>
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
package meteor.plugins.entityhider

import eventbus.events.ConfigChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.WildcardMatcher
import net.runelite.api.GameState
import net.runelite.api.NPC
import net.runelite.api.util.Text
import org.rationalityfrontline.kevent.Event
import java.util.*
import java.util.function.Consumer
import java.util.function.Supplier
import java.util.stream.Collectors

@PluginDescriptor(
    name = "Entity Hider",
    enabledByDefault = false,
    description = "Hide dead NPCs animations",
    tags = ["npcs"]
)
class EntityHiderPlugin : Plugin() {
     override val config = configuration<EntityHiderConfig>()
    private var hiddenIndices: java.util.ArrayList<Int>? = null
    private var animationHiddenIndices: java.util.ArrayList<Int>? = null
    private var hideNPCsOnDeathName: MutableSet<String>? = null
    private var hideNPCsOnDeathID: MutableSet<Int>? = null
    private var hideNPCsOnAnimationID: MutableSet<Int>? = null
    private var blacklistName: MutableSet<String>? = null
    private var blacklistID: MutableSet<Int>? = null
    override fun onStart() {
        client.setIsHidingEntities(true)
        //client.setDeadNPCsHidden(true);
        hiddenIndices = ArrayList()
        animationHiddenIndices = ArrayList()
        updateConfig()
        Text.fromCSV(config.hideNPCsNames()).forEach { s: String? -> client.addHiddenNpcName(s) }
    }

    override fun onGameStateChanged(): ((Event<eventbus.events.GameStateChanged>) -> Unit) = {
        if (it.data.new == GameState.LOGGED_IN) {
            client.setIsHidingEntities(true)
            clearHiddenNpcs()
        }
    }


   override fun onStop() {
        client.setIsHidingEntities(false)
        //client.setDeadNPCsHidden(false);
        clearHiddenNpcs()
        hiddenIndices = null
        animationHiddenIndices = null
        client.setOthersHidden(false)
        client.setOthersHidden2D(false)
        client.setFriendsHidden(false)
        client.setFriendsChatMembersHidden(false)
        client.setIgnoresHidden(false)
        client.setLocalPlayerHidden(false)
        client.setLocalPlayerHidden2D(false)
        client.setNPCsHidden(false)
        client.setNPCsHidden2D(false)
        client.setPetsHidden(false)
        client.setAttackersHidden(false)
        client.setProjectilesHidden(false)
    }

    override fun onClientTick(): ((Event<eventbus.events.ClientTick>) -> Unit) =  {
        for (npc in client.npcs) {
            if (npc == null) {
                continue
            }
            if (config.hideDeadNPCs() && npc.healthRatio == 0 && npc.name != null && !matchWildCards(
                    blacklistName, Text
                        .standardize(npc.name)
                ) && !blacklistID!!.contains(npc.id)
                || npc.healthRatio == 0 && npc.name != null && matchWildCards(
                    hideNPCsOnDeathName, Text
                        .standardize(npc.name)
                )
                || npc.healthRatio == 0 && hideNPCsOnDeathID!!.contains(npc.id)
                || hideNPCsOnAnimationID!!.contains(npc.animation)
            ) {
                if (!hiddenIndices!!.contains(npc.index)) {
                    setHiddenNpc(npc, true)
                }
            }
            if (animationHiddenIndices!!.contains(npc.index) && !hideNPCsOnAnimationID
                    ?.contains(npc.animation)!!
            ) {
                if (hiddenIndices!!.contains(npc.index)) {
                    setHiddenNpc(npc, false)
                }
            }
        }
    }

    override fun onNpcDespawned(): ((Event<eventbus.events.NpcDespawned>) -> Unit) = {
        if (hiddenIndices!!.contains(it.data.npc.index)) {
            setHiddenNpc(it.data.npc, false)
        }
    }

    override fun onConfigChanged(): ((Event<ConfigChanged>) -> Unit)= {
        if (!it.data.group.equals("entityhiderextended")) {


            client.setIsHidingEntities(true)
            updateConfig()
            if (it.data.oldValue == null || it.data.newValue == null) {

            if (it.data.key.equals("hideNPCsNames")) {
                val oldList: List<String> = Text.fromCSV(it.data.oldValue)
                val newList: List<String> = Text.fromCSV(it.data.newValue)
                val removed: List<String> = oldList.stream().filter { s: String -> !newList.contains(s) }
                    .collect(
                        Collectors.toCollection(Supplier { ArrayList() })
                    )
                val added: List<String> = newList.stream().filter { s: String -> !oldList.contains(s) }
                    .collect(
                        Collectors.toCollection(Supplier { ArrayList() })
                    )
                removed.forEach(Consumer { s: String? -> client.removeHiddenNpcName(s) })
                added.forEach(Consumer { s: String? -> client.addHiddenNpcName(s) })
            }
        }
        }
    }

    fun updateConfig() {
        client.setIsHidingEntities(true)
        client.setOthersHidden(config.hideOthers())
        client.setOthersHidden2D(config.hideOthers2D())
        client.setFriendsHidden(config.hideFriends())
        client.setFriendsChatMembersHidden(config.hideFriendsChatMembers())
        client.setIgnoresHidden(config.hideIgnores())
        client.setLocalPlayerHidden(config.hideLocalPlayer())
        client.setLocalPlayerHidden2D(config.hideLocalPlayer2D())
        client.setNPCsHidden(config.hideNPCs())
        client.setNPCsHidden2D(config.hideNPCs2D())
        client.setPetsHidden(config.hidePets())
        client.setAttackersHidden(config.hideAttackers())
        client.setProjectilesHidden(config.hideProjectiles())
        hideNPCsOnDeathName = HashSet()
        hideNPCsOnDeathID = HashSet()
        hideNPCsOnAnimationID = HashSet()
        blacklistID = HashSet()
        blacklistName = HashSet()
        for (s in Text.COMMA_SPLITTER
            .split(config.hideNPCsOnDeathName().lowercase(Locale.getDefault()))) {
            (hideNPCsOnDeathName as HashSet<String>).add(s)
        }
        for (s in Text.COMMA_SPLITTER.split(config.hideNPCsOnDeathID())) {
            try {
                (hideNPCsOnDeathID as HashSet<Int>).add(s.toInt())
            } catch (ignored: NumberFormatException) {
            }
        }
        for (s in Text.COMMA_SPLITTER
            .split(config.hideNPCsOnAnimationID())) {
            try {
                (hideNPCsOnAnimationID as HashSet<Int>).add(s.toInt())
            } catch (ignored: NumberFormatException) {
            }
        }
        for (s in Text.COMMA_SPLITTER
            .split(config.blacklistDeadNpcsName().lowercase(Locale.getDefault()))) {
            (blacklistName as HashSet<String>).add(s)
        }
        for (s in Text.COMMA_SPLITTER.split(config.blacklistDeadNpcsID())) {
            try {
                (blacklistID as HashSet<Int>).add(s.toInt())
            } catch (ignored: NumberFormatException) {
            }
        }
    }

    private fun setHiddenNpc(npc: NPC, hidden: Boolean) {
        val newHiddenNpcIndicesList = client.hiddenNpcIndices
        if (hidden) {
            newHiddenNpcIndicesList.add(npc.index)
            hiddenIndices!!.add(npc.index)
            if (hideNPCsOnAnimationID!!.contains(npc.animation)) {
                animationHiddenIndices!!.add(npc.index)
            }
        } else {
            if (newHiddenNpcIndicesList.contains(npc.index)) {
                newHiddenNpcIndicesList.remove(npc.index)
                hiddenIndices!!.remove(npc.index)
                animationHiddenIndices!!.remove(npc.index)
            }
        }
        client.hiddenNpcIndices = newHiddenNpcIndicesList
    }

    private fun clearHiddenNpcs() {
        if (!hiddenIndices.isNullOrEmpty()) {
            val newHiddenNpcIndicesList = client.hiddenNpcIndices
            newHiddenNpcIndicesList.removeAll(hiddenIndices!!)
            client.hiddenNpcIndices = newHiddenNpcIndicesList
            hiddenIndices!!.clear()
            animationHiddenIndices!!.clear()
        }
    }

    private fun matchWildCards(items: Set<String>?, pattern: String): Boolean {
        var matched = false
        for (item in items!!) {
            matched = WildcardMatcher.matches(item, pattern)
            if (matched) {
                break
            }
        }
        return matched
    }
}