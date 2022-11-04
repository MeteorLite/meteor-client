/*
 * Copyright (c) 2016-2017, Cameron Moberg <Moberg@tuta.io>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package meteor.plugins.bosstimer

import eventbus.events.NpcDespawned
import meteor.Logger
import meteor.game.ItemManager
import meteor.game.NpcUtil
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager

@PluginDescriptor(name = "Boss Timers", description = "Show boss spawn timer overlays", tags = ["combat", "pve", "overlay", "spawn"])
class BossTimersPlugin : Plugin() {
    private val infoBoxManager = InfoBoxManager
    private val itemManager = ItemManager
    private val npcUtil = NpcUtil
    override fun onStop() {
        infoBoxManager.removeIf { t: InfoBox? -> t is RespawnTimer }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        val npc = it.npc
        if (!npcUtil.isDying(npc)) {
            return
        }
        val npcId = npc.id
        val boss: Boss = Boss.find(npcId) ?: return

        // remove existing timer
        infoBoxManager.removeIf { t: InfoBox? -> t is RespawnTimer && t.boss == boss }
        Logger("Boss Timers").debug("Creating spawn timer for {} ({} seconds)", npc.name, boss.spawnTime)
        val timer = itemManager.getImage(boss.itemSpriteId)?.let { RespawnTimer(boss, it, this) }
        if (timer != null) {
            timer.tooltip = npc.name
            infoBoxManager.addInfoBox(timer)
        }
    }
}