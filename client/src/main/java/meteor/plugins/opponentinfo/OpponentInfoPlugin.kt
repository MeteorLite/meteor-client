/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package meteor.plugins.opponentinfo

import com.google.common.annotations.VisibleForTesting
import eventbus.events.*
import lombok.AccessLevel
import lombok.Getter
import meteor.hiscore.HiscoreEndpoint
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import net.runelite.api.*
import net.runelite.api.widgets.WidgetInfo
import java.text.DecimalFormat
import java.time.Duration
import java.time.Instant

@PluginDescriptor(
    name = "Opponent Information",
    description = "Show name and hitpoints information about the NPC you are fighting",
    tags = ["combat", "health", "hitpoints", "npcs", "overlay"]
)
class OpponentInfoPlugin : Plugin() {
    private val config = configuration<OpponentInfoConfig>()
    private val opponentInfoOverlay = OpponentInfoOverlay(this, config)
    private val playerComparisonOverlay = PlayerComparisonOverlay(this, config)

    @Getter(AccessLevel.PACKAGE)
    var hiscoreEndpoint = HiscoreEndpoint.NORMAL

    @Getter(AccessLevel.PACKAGE)
    var lastOpponent: Actor? = null

    @Getter(AccessLevel.PACKAGE)
    @VisibleForTesting
    private var lastTime: Instant? = null
    override fun onStart() {
        overlayManager.add(opponentInfoOverlay)
        overlayManager.add(playerComparisonOverlay)
    }

    override fun onStop() {
        lastOpponent = null
        lastTime = null
        overlayManager.remove(opponentInfoOverlay)
        overlayManager.remove(playerComparisonOverlay)
    }

    override fun onGameStateChanged(gameStateChanged: GameStateChanged) {
        if (gameStateChanged.gameState != GameState.LOGGED_IN) {
            return
        }
        hiscoreEndpoint = HiscoreEndpoint.fromWorldTypes(client.worldType)
    }

    override fun onInteractingChanged(event: InteractingChanged) {
        if (event.source !== client.localPlayer) {
            return
        }
        val opponent = event.target
        if (opponent == null) {
            lastTime = Instant.now()
            return
        }
        lastOpponent = opponent
    }

    override fun onGameTick(gameTick: GameTick) {
        if (lastOpponent != null && lastTime != null && client.localPlayer!!.interacting == null) {
            if (Duration.between(lastTime, Instant.now()).compareTo(WAIT) > 0) {
                lastOpponent = null
            }
        }
    }

    override fun onMenuEntryAdded(menuEntryAdded: MenuEntryAdded) {
        if (menuEntryAdded.opcode != MenuAction.NPC_SECOND_OPTION.id || menuEntryAdded.option != "Attack"
            || !config.showOpponentsInMenu()
        ) {
            return
        }
        val npc = menuEntryAdded.menuEntry!!.npc ?: return
        if (npc.interacting === client.localPlayer || lastOpponent === npc) {
            val menuEntries = client.menuEntries
            menuEntries[menuEntries.size - 1].target = "*" + menuEntries[menuEntries.size - 1].target
        }
    }

    override fun onScriptPostFired(event: ScriptPostFired) {
        if (event.scriptId == ScriptID.HP_HUD_UPDATE) {
            updateBossHealthBarText()
        }
    }

    /**
     * Update the in-game boss health bar overlay text to what the user's config specifies.
     * This health bar is used in CoX, ToA, Gauntlet, quest bosses, etc. It is not used in ToB, which has its own.
     */
    private fun updateBossHealthBarText() {
        val widget = client.getWidget(WidgetInfo.HEALTH_OVERLAY_BAR_TEXT) ?: return
        val currHp = client.getVarbitValue(Varbits.BOSS_HEALTH_CURRENT)
        val maxHp = client.getVarbitValue(Varbits.BOSS_HEALTH_MAXIMUM)
        if (maxHp <= 0) {
            return
        }
        when (config.hitpointsDisplayStyle()) {
            HitpointsDisplayStyle.PERCENTAGE -> widget.text = getPercentText(currHp, maxHp)
            HitpointsDisplayStyle.BOTH -> widget.text = widget.text + " (" + getPercentText(currHp, maxHp) + ")"
            else -> {}
        }
    }

    companion object {
        private val WAIT = Duration.ofSeconds(5)
        private val PERCENT_FORMAT = DecimalFormat("0.0")
        private fun getPercentText(current: Int, maximum: Int): String {
            val percent = 100.0 * current / maximum
            return PERCENT_FORMAT.format(percent) + "%"
        }
    }
}