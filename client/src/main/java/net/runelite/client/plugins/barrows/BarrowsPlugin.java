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
package net.runelite.client.plugins.barrows;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import eventbus.events.BeforeRender;
import eventbus.events.ConfigChanged;
import eventbus.events.GameStateChanged;
import eventbus.events.WidgetClosed;
import eventbus.events.WidgetLoaded;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import lombok.Getter;
import meteor.Main;
import meteor.game.ItemManager;
import meteor.game.SpriteManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.ui.overlay.OverlayManager;
import meteor.ui.overlay.infobox.InfoBoxManager;
import meteor.ui.overlay.infobox.InfoBoxPriority;
import meteor.ui.overlay.infobox.LoopTimer;
import meteor.util.QuantityFormatter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Barrows Brothers",
	description = "Show helpful information for the Barrows minigame",
	tags = {"combat", "minigame", "bosses", "pve", "pvm"}
)
public class BarrowsPlugin extends Plugin
{
	private static final ImmutableList<WidgetInfo> POSSIBLE_SOLUTIONS = ImmutableList.of(
		WidgetInfo.BARROWS_PUZZLE_ANSWER1,
		WidgetInfo.BARROWS_PUZZLE_ANSWER2,
		WidgetInfo.BARROWS_PUZZLE_ANSWER3
	);

	private static final long PRAYER_DRAIN_INTERVAL_MS = 18200;
	private static final int CRYPT_REGION_ID = 14231;
	private static final int BARROWS_REGION_ID = 14131;

	private LoopTimer barrowsPrayerDrainTimer;

	@Getter
	private Widget puzzleAnswer;
	private OverlayManager overlayManager = OverlayManager.INSTANCE;
	private Client client = Main.client;
	private ItemManager itemManager = ItemManager.INSTANCE;
	private SpriteManager spriteManager = SpriteManager.INSTANCE;
	private InfoBoxManager infoBoxManager = InfoBoxManager.INSTANCE;
	private ChatMessageManager chatMessageManager = Main.INSTANCE.getChatMessageManager();
	private BarrowsConfig config = (BarrowsConfig) javaConfiguration(BarrowsConfig.class);
	private BarrowsOverlay barrowsOverlay = new BarrowsOverlay(this, config);
	private BarrowsBrotherSlainOverlay brotherOverlay = new BarrowsBrotherSlainOverlay(this);

	@Override
	public void onStart()
	{
		overlayManager.add(barrowsOverlay);
		overlayManager.add(brotherOverlay);
	}

	@Override
	public void onStop()
	{
		overlayManager.remove(barrowsOverlay);
		overlayManager.remove(brotherOverlay);
		puzzleAnswer = null;
		stopPrayerDrainTimer();

		// Restore widgets
		final Widget potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL);
		if (potential != null)
		{
			potential.setHidden(false);
		}

		final Widget barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS);
		if (barrowsBrothers != null)
		{
			barrowsBrothers.setHidden(false);
		}
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("barrows") && !config.showPrayerDrainTimer())
		{
			stopPrayerDrainTimer();
		}
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			boolean isInCrypt = isInCrypt();
			if (!isInCrypt && barrowsPrayerDrainTimer != null)
			{
				stopPrayerDrainTimer();
			}
			else if (isInCrypt && barrowsPrayerDrainTimer == null)
			{
				startPrayerDrainTimer();
			}
		}
	}

	@Override
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && config.showChestValue())
		{
			ItemContainer barrowsRewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			if (barrowsRewardContainer == null)
			{
				return;
			}

			Item[] items = barrowsRewardContainer.getItems();
			long chestPrice = 0;

			for (Item item : items)
			{
				long itemStack = (long) itemManager.getItemPrice(item.getId()) * (long) item.getQuantity();
				chestPrice += itemStack;
			}

			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Your chest is worth around ")
				.append(QuantityFormatter.INSTANCE.formatNumber(chestPrice))
				.append(" coins.")
				.append(ChatColorType.NORMAL);

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.ITEM_EXAMINE)
				.runeLiteFormattedMessage(message.build())
				.build());
		}
		else if (event.getGroupId() == WidgetID.BARROWS_PUZZLE_GROUP_ID)
		{
			final int answer = client.getWidget(WidgetInfo.BARROWS_FIRST_PUZZLE).getModelId() - 3;
			puzzleAnswer = null;

			for (WidgetInfo puzzleNode : POSSIBLE_SOLUTIONS)
			{
				final Widget widgetToCheck = client.getWidget(puzzleNode);

				if (widgetToCheck != null && widgetToCheck.getModelId() == answer)
				{
					puzzleAnswer = client.getWidget(puzzleNode);
					break;
				}
			}
		}
	}

	@Override
	public void onBeforeRender(BeforeRender beforeRender)
	{
		// The barrows brothers and potential overlays have timers to unhide them each tick. Set them
		// hidden here instead of in the overlay, because if the overlay renders on the ABOVE_WIDGETS
		// layer due to being moved outside of the snap corner, it will be running after the overlays
		// had already been rendered.
		final Widget barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS);
		if (barrowsBrothers != null)
		{
			barrowsBrothers.setHidden(true);
		}

		final Widget potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL);
		if (potential != null)
		{
			potential.setHidden(true);
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

	private void startPrayerDrainTimer()
	{
		if (config.showPrayerDrainTimer())
		{
			assert barrowsPrayerDrainTimer == null;
			final LoopTimer loopTimer = new LoopTimer(
				PRAYER_DRAIN_INTERVAL_MS,
				ChronoUnit.MILLIS,
				null,
				this,
				true);

			spriteManager.getSpriteAsync(SpriteID.TAB_PRAYER, 0, loopTimer);

			loopTimer.setPriority(InfoBoxPriority.MED);
			loopTimer.setTooltip("Prayer Drain");

			infoBoxManager.addInfoBox(loopTimer);
			barrowsPrayerDrainTimer = loopTimer;
		}
	}

	private void stopPrayerDrainTimer()
	{
		infoBoxManager.removeInfoBox(barrowsPrayerDrainTimer);
		barrowsPrayerDrainTimer = null;
	}

	private boolean isInCrypt()
	{
		Player localPlayer = client.getLocalPlayer();
		return localPlayer != null && localPlayer.getWorldLocation().getRegionID() == CRYPT_REGION_ID;
	}

	boolean isBarrowsLoaded()
	{
		return ArrayUtils.contains(client.getMapRegions(), BARROWS_REGION_ID);
	}
}
