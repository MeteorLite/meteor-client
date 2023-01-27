/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.barrows

import com.google.common.collect.ImmutableList
import eventbus.events.BeforeRender
import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.WidgetLoaded
import meteor.Main
import meteor.game.ItemManager
import meteor.game.SpriteManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.ui.overlay.infobox.InfoBoxPriority
import meteor.ui.overlay.infobox.LoopTimer
import meteor.util.QuantityFormatter.formatNumber
import net.runelite.api.ChatMessageType
import net.runelite.api.GameState
import net.runelite.api.InventoryID
import net.runelite.api.SpriteID
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import meteor.chat.ChatColorType
import meteor.chat.ChatMessageBuilder
import meteor.chat.QueuedMessage
import meteor.plugins.attackstyles.AttackStylesConfig
import org.apache.commons.lang3.ArrayUtils
import java.time.temporal.ChronoUnit

@PluginDescriptor(name = "Barrows Brothers", description = "Show helpful information for the Barrows minigame", tags = ["combat", "minigame", "bosses", "pve", "pvm"])
class BarrowsPlugin : Plugin() {
    private var barrowsPrayerDrainTimer: LoopTimer? = null

	var puzzleAnswer: Widget? = null

    private val itemManager = ItemManager
    private val spriteManager = SpriteManager
    private val infoBoxManager = InfoBoxManager
    private val chatMessageManager = Main.chatMessageManager
    private val config = configuration<BarrowsConfig>()
    private val barrowsOverlay = BarrowsOverlay(this, config)
    private val brotherOverlay = BarrowsBrotherSlainOverlay(this)
    override fun onStart() {
        overlayManager.add(barrowsOverlay)
        overlayManager.add(brotherOverlay)
    }

    override fun onStop() {
        overlayManager.remove(barrowsOverlay)
        overlayManager.remove(brotherOverlay)
        puzzleAnswer = null
        stopPrayerDrainTimer()

        // Restore widgets
        val potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL)
        if (potential != null) {
            potential.isHidden = false
        }
        val barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS)
        if (barrowsBrothers != null) {
            barrowsBrothers.isHidden = false
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "barrows" && !config.showPrayerDrainTimer()) {
            stopPrayerDrainTimer()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGGED_IN) {
            val isInCrypt = isInCrypt
            if (!isInCrypt && barrowsPrayerDrainTimer != null) {
                stopPrayerDrainTimer()
            } else if (isInCrypt && barrowsPrayerDrainTimer == null) {
                startPrayerDrainTimer()
            }
        }
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.BARROWS_REWARD_GROUP_ID && config.showChestValue()) {
            val barrowsRewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD)
                    ?: return
            val items = barrowsRewardContainer.items
            var chestPrice: Long = 0
            for (item in items) {
                val itemStack = itemManager.getItemPrice(item.id).toLong() * item.quantity.toLong()
                chestPrice += itemStack
            }
            val message = ChatMessageBuilder()
                    .append(ChatColorType.HIGHLIGHT)
                    .append("Your chest is worth around ")
                    .append(formatNumber(chestPrice))
                    .append(" coins.")
                    .append(ChatColorType.NORMAL)
            chatMessageManager!!.queue(QueuedMessage.builder()
                    .type(ChatMessageType.ITEM_EXAMINE)
                    .runeLiteFormattedMessage(message.build()))
        } else if (it.groupId == WidgetID.BARROWS_PUZZLE_GROUP_ID) {
            val answer = client.getWidget(WidgetInfo.BARROWS_FIRST_PUZZLE)!!.modelId - 3
            puzzleAnswer = null
            for (puzzleNode in POSSIBLE_SOLUTIONS) {
                val widgetToCheck = client.getWidget(puzzleNode)
                if (widgetToCheck != null && widgetToCheck.modelId == answer) {
                    puzzleAnswer = client.getWidget(puzzleNode)
                    break
                }
            }
        }
    }

    override fun onBeforeRender(it: BeforeRender) {
        // The barrows brothers and potential overlays have timers to unhide them each tick. Set them
        // hidden here instead of in the overlay, because if the overlay renders on the ABOVE_WIDGETS
        // layer due to being moved outside of the snap corner, it will be running after the overlays
        // had already been rendered.
        val barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS)
        if (barrowsBrothers != null) {
            barrowsBrothers.isHidden = true
        }
        val potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL)
        if (potential != null) {
            potential.isHidden = true
        }
    }

    /*	@Override
	public void onWidgetClosed(WidgetClosed widgetClosed)
	{
		if (widgetClosed.getGroupId() == WidgetID.BARROWS_PUZZLE_GROUP_ID)
		{
			puzzleAnswer = null;
		}
	}*/
    private fun startPrayerDrainTimer() {
        if (config.showPrayerDrainTimer()) {
            assert(barrowsPrayerDrainTimer == null)
            val loopTimer = LoopTimer(
                    PRAYER_DRAIN_INTERVAL_MS,
                    ChronoUnit.MILLIS,
                    null,
                    this,
                    true)
            spriteManager.getSpriteAsync(SpriteID.TAB_PRAYER, 0, loopTimer)
            loopTimer.priority = InfoBoxPriority.MED
            loopTimer.tooltip = "Prayer Drain"
            infoBoxManager.addInfoBox(loopTimer)
            barrowsPrayerDrainTimer = loopTimer
        }
    }

    private fun stopPrayerDrainTimer() {
        infoBoxManager.removeInfoBox(barrowsPrayerDrainTimer)
        barrowsPrayerDrainTimer = null
    }

    private val isInCrypt: Boolean
        private get() {
            val localPlayer = client.localPlayer
            return localPlayer != null && localPlayer.worldLocation.regionID == CRYPT_REGION_ID
        }
    val isBarrowsLoaded: Boolean
        get() = ArrayUtils.contains(client.mapRegions, BARROWS_REGION_ID)

    companion object {
        private val POSSIBLE_SOLUTIONS = ImmutableList.of(
                WidgetInfo.BARROWS_PUZZLE_ANSWER1,
                WidgetInfo.BARROWS_PUZZLE_ANSWER2,
                WidgetInfo.BARROWS_PUZZLE_ANSWER3
        )
        private const val PRAYER_DRAIN_INTERVAL_MS: Long = 18200
        private const val CRYPT_REGION_ID = 14231
        private const val BARROWS_REGION_ID = 14131
    }
}