/*
 * Copyright (c) 2018 gazivodag <https://github.com/gazivodag>
 * Copyright (c) 2019 lucwousin <https://github.com/lucwousin>
 * Copyright (c) 2019 infinitay <https://github.com/Infinitay>
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
package meteor.plugins.blackjack

import eventbus.events.ChatMessage
import eventbus.events.ClientTick
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ChatMessageType
import net.runelite.api.GameState
import net.runelite.api.MenuEntry
import org.apache.commons.lang3.ArrayUtils


@PluginDescriptor(
    name = "[b] Blackjack",
    enabledByDefault = false,
    description = "Allows for one-click blackjacking, both knocking out and pickpocketing",
    tags = ["blackjack", "thieving"]
)
class BlueBlackjackPlugin : Plugin() {

    private val config = configuration<BlueBlackjackConfig>()
    private var nextKnockOutTick: Long = 0
    private var knockout = true

    override fun onClientTick(it: ClientTick) {
        if (client.gameState != GameState.LOGGED_IN || client.mapRegions == null ||
            !ArrayUtils.contains(client.mapRegions, POLLNIVNEACH_REGION)
        ) {
            return
        }
        val entries: Array<MenuEntry> = client.menuEntries
        var putAtTopId = -1
        for (i in entries.indices) {
            val entry: MenuEntry = entries[i]
            if (entry.target.contains(BANDIT) || entry.target.contains(MENAPHITE)) {
                if (entry.option == KNOCK_OUT && knockout || entry.option == PICKPOCKET && !knockout) {
                    putAtTopId = i
                    break
                }
            }
        }
        if (putAtTopId != -1) {
            val temp: MenuEntry = entries[entries.size - 1]
            entries[entries.size - 1] = entries[putAtTopId]
            entries[putAtTopId] = temp
            client.menuEntries = entries
        }
    }

    override fun onGameTick(it: GameTick) {
        if (client.tickCount >= nextKnockOutTick) {
            knockout = true
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        val msg: String = it.message
        if (it.type == ChatMessageType.SPAM && msg == SUCCESS_BLACKJACK || msg == FAILED_BLACKJACK && config!!.pickpocketOnAggro()) {
            knockout = false
            val ticks = 4
            nextKnockOutTick = (client.tickCount + ticks).toLong()
        }
    }

    companion object {
        private const val POLLNIVNEACH_REGION = 13358
        private const val SUCCESS_BLACKJACK = "You smack the bandit over the head and render them unconscious."
        private const val FAILED_BLACKJACK = "Your blow only glances off the bandit's head."
        private const val PICKPOCKET = "Pickpocket"
        private const val KNOCK_OUT = "Knock-Out"
        private const val BANDIT = "Bandit"
        private const val MENAPHITE = "Menaphite Thug"
    }
}