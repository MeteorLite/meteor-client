/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2019, Brandon White <bmwqg@live.com>
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
package meteor.plugins.blastfurnace

import eventbus.events.GameObjectDespawned
import eventbus.events.GameObjectSpawned
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.*
import net.runelite.api.util.Text
import net.runelite.api.widgets.WidgetInfo
import java.time.Duration
import java.time.Instant

@PluginDescriptor(name = "Blast Furnace", description = "Show helpful information for the Blast Furnace minigame", tags = ["minigame", "overlay", "skilling", "smithing"])
class BlastFurnacePlugin : Plugin() {
    var conveyorBelt: GameObject? = null
    var barDispenser: GameObject? = null
    private var foremanTimer: ForemanTimer? = null
    private val overlay = BlastFurnaceOverlay(this)
    private val config = configuration<BlastFurnaceConfig>()
    private val cofferOverlay = BlastFurnaceCofferOverlay(this, config)
    private val clickBoxOverlay = BlastFurnaceClickBoxOverlay(this, config)
    private val itemManager = ItemManager
    private val infoBoxManager = InfoBoxManager
    override fun onStart() {
        overlayManager.add(overlay)
        overlayManager.add(cofferOverlay)
        overlayManager.add(clickBoxOverlay)
    }

    override fun onStop() {
        infoBoxManager.removeIf { obj: InfoBox? -> ForemanTimer::class.java.isInstance(obj) }
        overlayManager.remove(overlay)
        overlayManager.remove(cofferOverlay)
        overlayManager.remove(clickBoxOverlay)
        conveyorBelt = null
        barDispenser = null
        foremanTimer = null
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject = it.gameObject
        when (gameObject.id) {
            ObjectID.CONVEYOR_BELT -> conveyorBelt = gameObject
            BAR_DISPENSER -> barDispenser = gameObject
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        val gameObject = it.gameObject
        when (gameObject.id) {
            ObjectID.CONVEYOR_BELT -> conveyorBelt = null
            BAR_DISPENSER -> barDispenser = null
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            conveyorBelt = null
            barDispenser = null
        }
    }

    override fun onGameTick(it: GameTick) {
        val npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT) ?: return

        // blocking dialog check until 5 minutes needed to avoid re-adding while dialog message still displayed
        val shouldCheckForemanFee = (client.getRealSkillLevel(Skill.SMITHING) < 60
                && (foremanTimer == null || Duration.between(Instant.now(), foremanTimer!!.endTime).toMinutes() <= 5))
        if (shouldCheckForemanFee) {
            val npcText = Text.sanitizeMultilineText(npcDialog.text)
            if (npcText == FOREMAN_PERMISSION_TEXT) {
                infoBoxManager.removeIf { obj: InfoBox? -> ForemanTimer::class.java.isInstance(obj) }
                foremanTimer = ForemanTimer(this, itemManager)
                infoBoxManager.addInfoBox(foremanTimer!!)
            }
        }
    }

    companion object {
        private const val BAR_DISPENSER = NullObjectID.NULL_9092
        private const val FOREMAN_PERMISSION_TEXT = "Okay, you can use the furnace for ten minutes. Remember, you only need half as much coal as with a regular furnace."
    }
}