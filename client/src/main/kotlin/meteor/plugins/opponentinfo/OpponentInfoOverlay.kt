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

import com.google.common.base.Strings
import meteor.Main
import meteor.game.NPCManager
import meteor.hiscore.HiscoreManager
import meteor.hiscore.HiscoreSkill
import meteor.ui.components.ComponentConstants
import meteor.ui.components.ProgressBarComponent
import meteor.ui.components.ProgressBarComponent.LabelDisplayMode
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.ui.table.TitleComponent.Companion.builder
import net.runelite.api.*
import net.runelite.api.util.Text
import java.awt.*
import java.awt.Point

internal class OpponentInfoOverlay(
    private val opponentInfoPlugin: OpponentInfoPlugin,
    private val opponentInfoConfig: OpponentInfoConfig
) : OverlayPanel() {
    private val hiscoreManager = HiscoreManager
    private val npcManager = NPCManager
    private var lastMaxHealth: Int? = null
    private var lastRatio = 0
    private var lastHealthScale = 0
    private var opponentName: String? = null

    init {
        position = OverlayPosition.TOP_LEFT
        priority = OverlayPriority.HIGH
        panelComponent.border = Rectangle(2, 2, 2, 2)
        panelComponent.gap = Point(0, 2)
        //addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay");
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val opponent = opponentInfoPlugin.lastOpponent
        if (opponent == null) {
            opponentName = null
            return null
        }
        if (opponent.name != null && opponent.healthScale > 0) {
            lastRatio = opponent.healthRatio
            lastHealthScale = opponent.healthScale
            opponentName = Text.removeTags(opponent.name)
            lastMaxHealth = null
            if (opponent is NPC) {
                val composition = opponent.transformedComposition
                if (composition != null) {
                    val longName = composition.getStringValue(ParamID.NPC_HP_NAME)
                    if (!Strings.isNullOrEmpty(longName)) {
                        opponentName = longName
                    }
                }
                lastMaxHealth = npcManager.getHealth(opponent.id)
            } else if (opponent is Player) {
                val hiscoreResult = hiscoreManager.lookupAsync(opponentName!!, opponentInfoPlugin.hiscoreEndpoint)
                if (hiscoreResult != null) {
                    val hp = hiscoreResult.getSkill(HiscoreSkill.HITPOINTS)!!.level
                    if (hp > 0) {
                        lastMaxHealth = hp
                    }
                }
            }
        }

        // The in-game hp hud is more accurate than our overlay and duplicates all of the information on it,
        // so hide ours if it is visible.
        if (opponentName == null || hasHpHud(opponent)) {
            return null
        }
        val fontMetrics = graphics.fontMetrics

        // Opponent name
        val panelWidth = Math.max(
            ComponentConstants.STANDARD_WIDTH,
            fontMetrics.stringWidth(opponentName) + ComponentConstants.STANDARD_BORDER + ComponentConstants.STANDARD_BORDER
        )
        panelComponent.setPreferredSize(Dimension(panelWidth, 0))
        panelComponent.children.add(
            builder()
                .text(opponentName!!)
        )

        // Health bar
        if (lastRatio >= 0 && lastHealthScale > 0) {
            val progressBarComponent = ProgressBarComponent()
            progressBarComponent.backgroundColor = HP_RED
            progressBarComponent.foregroundColor = HP_GREEN
            val displayStyle = opponentInfoConfig.hitpointsDisplayStyle()
            if ((displayStyle == HitpointsDisplayStyle.HITPOINTS || displayStyle == HitpointsDisplayStyle.BOTH)
                && lastMaxHealth != null
            ) {
                // This is the reverse of the calculation of healthRatio done by the server
                // which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
                // It's able to recover the exact health if maxHealth <= healthScale.
                var health = 0
                if (lastRatio > 0) {
                    var minHealth = 1
                    var maxHealth: Int
                    if (lastHealthScale > 1) {
                        if (lastRatio > 1) {
                            // This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
                            // health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
                            minHealth =
                                (lastMaxHealth!! * (lastRatio - 1) + lastHealthScale - 2) / (lastHealthScale - 1)
                        }
                        maxHealth = (lastMaxHealth!! * lastRatio - 1) / (lastHealthScale - 1)
                        if (maxHealth > lastMaxHealth!!) {
                            maxHealth = lastMaxHealth!!
                        }
                    } else {
                        // If healthScale is 1, healthRatio will always be 1 unless health = 0
                        // so we know nothing about the upper limit except that it can't be higher than maxHealth
                        maxHealth = lastMaxHealth!!
                    }
                    // Take the average of min and max possible healths
                    health = (minHealth + maxHealth + 1) / 2
                }

                // Show both the hitpoint and percentage values if enabled in the config
                val progressBarDisplayMode =
                    if (displayStyle == HitpointsDisplayStyle.BOTH) LabelDisplayMode.BOTH else LabelDisplayMode.FULL
                progressBarComponent.labelDisplayMode = progressBarDisplayMode
                progressBarComponent.maximum = lastMaxHealth!!.toLong()
                progressBarComponent.value = health.toDouble()
            } else {
                val floatRatio = lastRatio.toFloat() / lastHealthScale.toFloat()
                progressBarComponent.value = floatRatio * 100.0
            }
            panelComponent.children.add(progressBarComponent)
        }
        return super.render(graphics)
    }

    /**
     * Check if the hp hud is active for an opponent
     * @param opponent
     * @return
     */
    private fun hasHpHud(opponent: Actor): Boolean {
        val settingEnabled = client.getVarbitValue(Varbits.BOSS_HEALTH_OVERLAY) == 0
        if (settingEnabled && opponent is NPC) {
            val opponentId = client.getVarpValue(VarPlayer.HP_HUD_NPC_ID)
            return opponentId != -1 && opponentId == opponent.id
        }
        return false
    }

    companion object {
        private val HP_GREEN = Color(0, 146, 54, 230)
        private val HP_RED = Color(102, 15, 16, 230)
    }
}