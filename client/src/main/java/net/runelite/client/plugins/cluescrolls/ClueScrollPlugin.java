/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls;

import com.google.common.base.MoreObjects;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import eventbus.events.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.game.ItemManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import meteor.ui.worldmap.WorldMapPointManager;
import meteor.util.ImageUtil;
import meteor.util.OverlayUtil;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Point;
import net.runelite.api.Scene;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.cluescrolls.clues.AnagramClue;
import net.runelite.client.plugins.cluescrolls.clues.BeginnerMapClue;
import net.runelite.client.plugins.cluescrolls.clues.CipherClue;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.CoordinateClue;
import net.runelite.client.plugins.cluescrolls.clues.CrypticClue;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.plugins.cluescrolls.clues.FairyRingClue;
import net.runelite.client.plugins.cluescrolls.clues.FaloTheBardClue;
import net.runelite.client.plugins.cluescrolls.clues.HotColdClue;
import net.runelite.client.plugins.cluescrolls.clues.LocationClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.LocationsClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.MapClue;
import net.runelite.client.plugins.cluescrolls.clues.MusicClue;
import net.runelite.client.plugins.cluescrolls.clues.NamedObjectClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.NpcClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.ObjectClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.SkillChallengeClue;
import net.runelite.client.plugins.cluescrolls.clues.TextClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.ThreeStepCrypticClue;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import org.apache.commons.lang3.ArrayUtils;
import meteor.ui.table.TextComponent;

@PluginDescriptor(
	name = "Clue Scroll",
	description = "Show answers to clue scroll riddles, anagrams, ciphers, and cryptic clues",
	tags = {"arrow", "hints", "world", "map", "coordinates", "emotes"}
)
@Slf4j
public class ClueScrollPlugin extends Plugin
{
	private static final Color HIGHLIGHT_BORDER_COLOR = Color.ORANGE;
	private static final Color HIGHLIGHT_HOVER_BORDER_COLOR = HIGHLIGHT_BORDER_COLOR.darker();
	private static final Color HIGHLIGHT_FILL_COLOR = new Color(0, 255, 0, 20);
	private static final String CLUE_TAG_NAME = "clue";
	private static final int[] RUNEPOUCH_AMOUNT_VARBITS = {
		Varbits.RUNE_POUCH_AMOUNT1, Varbits.RUNE_POUCH_AMOUNT2, Varbits.RUNE_POUCH_AMOUNT3, Varbits.RUNE_POUCH_AMOUNT4
	};
	private static final int[] RUNEPOUCH_RUNE_VARBITS = {
		Varbits.RUNE_POUCH_RUNE1, Varbits.RUNE_POUCH_RUNE2, Varbits.RUNE_POUCH_RUNE3, Varbits.RUNE_POUCH_RUNE4
	};

	@Getter
	private ClueScroll clue;

	@Getter
	private final List<NPC> npcsToMark = new ArrayList<>();

	@Getter
	private final List<TileObject> objectsToMark = new ArrayList<>();

	@Getter
	private final Set<TileObject> namedObjectsToMark = new HashSet<>();

	@Getter
	private Item[] equippedItems;

	@Getter
	private Item[] inventoryItems;

	@Getter
	private Client c = Main.client;

	private ClientThread clientThread = ClientThread.INSTANCE;

	private ItemManager itemManager = ItemManager.INSTANCE;

	private OverlayManager overlayManager = OverlayManager.INSTANCE;

	private ClueScrollOverlay clueScrollOverlay = new ClueScrollOverlay(this);

	private ClueScrollEmoteOverlay clueScrollEmoteOverlay = new ClueScrollEmoteOverlay(this);

	private ClueScrollMusicOverlay clueScrollMusicOverlay = new ClueScrollMusicOverlay(this);

	private ClueScrollWorldOverlay clueScrollWorldOverlay = new ClueScrollWorldOverlay(this);

	private ClueScrollConfig config = (ClueScrollConfig) javaConfiguration(ClueScrollConfig.class);

	private WorldMapPointManager worldMapPointManager = WorldMapPointManager.INSTANCE;

/*	private TagManager tagManager;*/

	boolean developerMode = false;

	private BufferedImage emoteImage;
	private BufferedImage mapArrow;
	private Integer clueItemId;
	private boolean worldMapPointsSet = false;

	// Some objects will only update to their "active" state when changing to their plane after varbit changes,
	// which take one extra tick to fire after the plane change. These fields are used to track those changes and delay
	// scans of the current plane's tiles accordingly.
	private int currentPlane = -1;
	private boolean namedObjectCheckThisTick;

	private final TextComponent textComponent = new TextComponent();

	@Getter
	private EmoteClue activeSTASHClue;
	private EmoteClue clickedSTASHClue;

/*	@Override
	public void configure(Binder binder)
	{
		binder.bind(ClueScrollService.class).to(ClueScrollServiceImpl.class);
	}*/

	@Override
	public void onStart()
	{
		overlayManager.add(clueScrollOverlay);
		overlayManager.add(clueScrollEmoteOverlay);
		overlayManager.add(clueScrollWorldOverlay);
		overlayManager.add(clueScrollMusicOverlay);
		//tagManager.registerTag(CLUE_TAG_NAME, this::testClueTag);
	}

	@Override
	public void onStop()
	{
		//tagManager.unregisterTag(CLUE_TAG_NAME);
		overlayManager.remove(clueScrollOverlay);
		overlayManager.remove(clueScrollEmoteOverlay);
		overlayManager.remove(clueScrollWorldOverlay);
		overlayManager.remove(clueScrollMusicOverlay);
		npcsToMark.clear();
		namedObjectsToMark.clear();
		inventoryItems = null;
		equippedItems = null;
		currentPlane = -1;
		namedObjectCheckThisTick = false;
		resetClue(true);
	}

	@Override
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String message = event.getMessage();

		if (clue instanceof HotColdClue)
		{
			if (((HotColdClue) clue).update(message, this))
			{
				worldMapPointsSet = false;
			}
		}

		if (clue instanceof SkillChallengeClue)
		{
			String text = Text.removeTags(message);
			if (text.equals("Skill challenge completed.") ||
				text.equals("You have completed your master level challenge!") ||
				text.startsWith("You have completed Charlie's task,") ||
				text.equals("You have completed this challenge scroll."))
			{
				((SkillChallengeClue) clue).setChallengeCompleted(true);
			}
		}

		if (message.endsWith(" the STASH unit."))
		{
			if (clue instanceof EmoteClue && clickedSTASHClue != null && message.equals("You withdraw your items from the STASH unit."))
			{
				activeSTASHClue = clickedSTASHClue;
			}
			else if (message.equals("You deposit your items into the STASH unit."))
			{
				activeSTASHClue = null;
			}
			clickedSTASHClue = null;
		}
	}

/*	@Override
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals("Reset")
			&& overlayMenuClicked.getOverlay() == clueScrollOverlay)
		{
			resetClue(true);
		}
	}*/

	@Override
	public void onMenuOptionClicked(final MenuOptionClicked event)
	{
		if (event.getMenuOption() == null)
		{
			return;
		}

		final boolean isXMarksTheSpotOrb = event.getItemId() == ItemID.MYSTERIOUS_ORB_23069;
		if (isXMarksTheSpotOrb || event.getMenuOption().equals("Read"))
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(event.getItemId());

			if (isXMarksTheSpotOrb
				|| itemComposition.getName().startsWith("Clue scroll")
				|| itemComposition.getName().startsWith("Challenge scroll")
				|| itemComposition.getName().startsWith("Treasure scroll"))
			{
				clueItemId = itemComposition.getId();
				updateClue(MapClue.forItemId(clueItemId));
			}
		}
		else if (event.getMenuOption().equals("Search")	&& clue instanceof EmoteClue)
		{
			EmoteClue emoteClue = (EmoteClue) clue;
			if (emoteClue.getStashUnit() != null && emoteClue.getStashUnit().getObjectId() == event.getId())
			{
				clickedSTASHClue = emoteClue;
			}
		}
	}

	@Override
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		final ItemContainer itemContainer = event.getItemContainer();
		if (event.getContainerId() == InventoryID.EQUIPMENT.getId())
		{
			equippedItems = itemContainer.getItems();
			return;
		}

		if (event.getContainerId() != InventoryID.INVENTORY.getId())
		{
			return;
		}

		inventoryItems = itemContainer.getItems();

		// Add runes from rune pouch to inventoryItems
		if (itemContainer.contains(ItemID.RUNE_POUCH) || itemContainer.contains(ItemID.RUNE_POUCH_L)
			|| itemContainer.contains(ItemID.DIVINE_RUNE_POUCH))
		{
			List<Item> runePouchContents = getRunepouchContents();

			if (!runePouchContents.isEmpty())
			{
				for (int i = 0; i < inventoryItems.length; i++)
				{
					Item invItem = inventoryItems[i];
					for (Item rune : runePouchContents)
					{
						if (invItem.getId() == rune.getId())
						{
							inventoryItems[i] = new Item(invItem.getId(), rune.getQuantity() + invItem.getQuantity());
							runePouchContents.remove(rune);
							break;
						}
					}
				}

				inventoryItems = ArrayUtils.addAll(inventoryItems, runePouchContents.toArray(new Item[0]));
			}
		}

		// Check if item was removed from inventory
		if (clue != null && clueItemId != null)
		{
			// Check if clue was removed from inventory
			if (!itemContainer.contains(clueItemId))
			{
				resetClue(true);
			}
		}

		// if three step clue check for clue scroll pieces
		if (clue instanceof ThreeStepCrypticClue)
		{
			if (((ThreeStepCrypticClue) clue).update(event.getContainerId(), itemContainer))
			{
				worldMapPointsSet = false;
				npcsToMark.clear();

				if (config.displayHintArrows())
				{
					c.clearHintArrow();
				}

				checkClueNPCs(clue, c.getCachedNPCs());
			}
		}
	}

	private List<Item> getRunepouchContents()
	{
		EnumComposition runepouchEnum = c.getEnum(EnumID.RUNEPOUCH_RUNE);
		List<Item> items = new ArrayList<>(RUNEPOUCH_AMOUNT_VARBITS.length);
		for (int i = 0; i < RUNEPOUCH_AMOUNT_VARBITS.length; i++)
		{
			int amount = c.getVarbitValue(RUNEPOUCH_AMOUNT_VARBITS[i]);
			if (amount <= 0)
			{
				continue;
			}

			int runeId = c.getVarbitValue(RUNEPOUCH_RUNE_VARBITS[i]);
			if (runeId == 0)
			{
				continue;
			}

			final int itemId = runepouchEnum.getIntValue(runeId);
			Item item = new Item(itemId, amount);
			items.add(item);
		}
		return items;
	}

	@Override
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		checkClueNPCs(clue, npc);
	}

	@Override
	public void onNpcDespawned(final NpcDespawned event)
	{
		final boolean removed = npcsToMark.remove(event.getNpc());

		if (removed)
		{
			if (npcsToMark.isEmpty())
			{
				c.clearHintArrow();
			}
			else
			{
				// Always set hint arrow to first seen NPC
				c.setHintArrow(npcsToMark.get(0));
			}
		}
	}

	@Override
	public void onDecorativeObjectDespawned(final DecorativeObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getDecorativeObject());
	}

	@Override
	public void onDecorativeObjectSpawned(final DecorativeObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getDecorativeObject());
	}

	@Override
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getGameObject());
	}

	@Override
	public void onGameObjectSpawned(final GameObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getGameObject());
	}

	@Override
	public void onGroundObjectDespawned(final GroundObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getGroundObject());
	}

	@Override
	public void onGroundObjectSpawned(final GroundObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getGroundObject());
	}

	@Override
	public void onWallObjectDespawned(final WallObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getWallObject());
	}

	@Override
	public void onWallObjectSpawned(final WallObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getWallObject());
	}

	private void tileObjectDespawnedHandler(final TileObject despawned)
	{
		namedObjectsToMark.remove(despawned);
	}

	private void tileObjectSpawnedHandler(final TileObject spawned)
	{
		checkClueNamedObject(clue, spawned);
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cluescroll") && !config.displayHintArrows())
		{
			c.clearHintArrow();
		}
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event)
	{
		final GameState state = event.getGameState();

		if (state != GameState.LOGGED_IN)
		{
			namedObjectsToMark.clear();
		}

		if (state == GameState.LOGIN_SCREEN)
		{
			resetClue(true);
		}
		else if (state == GameState.HOPPING)
		{
			namedObjectCheckThisTick = true;
		}
	}

	@Override
	public void onGameTick(final GameTick event)
	{
		objectsToMark.clear();

		if (clue instanceof LocationsClueScroll)
		{
			final WorldPoint[] locations = ((LocationsClueScroll) clue).getLocations();

			if (locations.length > 0)
			{
				addMapPoints(locations);
			}

			if (clue instanceof ObjectClueScroll)
			{
				int[] objectIds = ((ObjectClueScroll) clue).getObjectIds();

				if (objectIds.length > 0)
				{
					for (WorldPoint location : locations)
					{
						if (location != null)
						{
							highlightObjectsForLocation(location, objectIds);
						}
					}
				}
			}
		}

		if (clue instanceof LocationClueScroll)
		{
			final WorldPoint[] locations = ((LocationClueScroll) clue).getLocations();
			final boolean npcHintArrowMarked = c.getHintArrowNpc() != null && npcsToMark.contains(c.getHintArrowNpc());

			if (!npcHintArrowMarked)
			{
				c.clearHintArrow();
			}

			for (WorldPoint location : locations)
			{
				// Only set the location hint arrow if we do not already have more accurate location
				if (location.isInScene(c) && config.displayHintArrows() && !npcHintArrowMarked)
				{
					c.setHintArrow(location);
				}

				addMapPoints(location);

				if (clue instanceof ObjectClueScroll)
				{
					int[] objectIds = ((ObjectClueScroll) clue).getObjectIds();

					if (objectIds.length > 0)
					{
						highlightObjectsForLocation(location, objectIds);
					}
				}
			}
		}

		// Delay one tick when changing planes before scanning for new named objects on the new plane
		if (currentPlane != c.getPlane())
		{
			namedObjectsToMark.clear();
			currentPlane = c.getPlane();
			namedObjectCheckThisTick = true;
		}
		// Load the current plane's tiles if a tick has elapsed since the player has changed planes
		// or upon reaching a logged in state after hopping worlds
		else if (namedObjectCheckThisTick)
		{
			namedObjectCheckThisTick = false;
			checkClueNamedObjects(clue);
		}

		// Reset clue when receiving a new beginner or master clue
		// These clues use a single item ID, so we cannot detect step changes based on the item ID changing
		final Widget chatDialogClueItem = c.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);
		if (chatDialogClueItem != null
			&& (chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_BEGINNER || chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_MASTER))
		{
			resetClue(false);
		}
	}

	@Override
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() >= WidgetID.BEGINNER_CLUE_MAP_CHAMPIONS_GUILD
			&& event.getGroupId() <= WidgetID.BEGINNER_CLUE_MAP_WIZARDS_TOWER)
		{
			updateClue(BeginnerMapClue.forWidgetID(event.getGroupId()));
		}
		else if (event.getGroupId() == WidgetID.CLUE_SCROLL_GROUP_ID)
		{
			clientThread.invokeLater(() ->
			{
				final Widget clueScrollText = c.getWidget(WidgetInfo.CLUE_SCROLL_TEXT);
				if (clueScrollText != null)
				{
					ClueScroll clueScroll = findClueScroll(clueScrollText.getText());
					if (clueScroll != null)
					{
						updateClue(clueScroll);
					}
					else
					{
						log.info("Unknown clue text: {}", clueScrollText.getText());
						resetClue(true);
					}
				}
			});
		}
	}

/*
	@Override
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (developerMode && commandExecuted.getCommand().equals("clue"))
		{
			String text = Strings.join(commandExecuted.getArguments(), " ");

			if (text.isEmpty())
			{
				resetClue(true);
			}
			else
			{
				ClueScroll clueScroll = findClueScroll(text);
				log.debug("Found clue scroll for '{}': {}", text, clueScroll);
				updateClue(clueScroll);
			}
		}
	}
*/

	public BufferedImage getClueScrollImage()
	{
		return itemManager.getImage(ItemID.CLUE_SCROLL_MASTER);
	}

	public BufferedImage getEmoteImage()
	{
		if (emoteImage != null)
		{
			return emoteImage;
		}

		emoteImage = ImageUtil.INSTANCE.loadImageResource(getClass(), "emote.png");

		return emoteImage;
	}

	public BufferedImage getSpadeImage()
	{
		return itemManager.getImage(ItemID.SPADE);
	}

	BufferedImage getMapArrow()
	{
		if (mapArrow != null)
		{
			return mapArrow;
		}

		mapArrow = ImageUtil.INSTANCE.loadImageResource(getClass(), "/util/clue_arrow.png");

		return mapArrow;
	}

	private void resetClue(boolean withItemId)
	{
		if (clue instanceof LocationsClueScroll)
		{
			((LocationsClueScroll) clue).reset();
		}

		if (withItemId)
		{
			clueItemId = null;
		}

		clue = null;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);
		worldMapPointsSet = false;
		npcsToMark.clear();
		namedObjectsToMark.clear();

		if (config.displayHintArrows())
		{
			c.clearHintArrow();
		}
	}

	private ClueScroll findClueScroll(String rawText)
	{
		// Remove line breaks and also the rare occasion where there are double line breaks
		final String text = Text.sanitizeMultilineText(rawText).toLowerCase();

		// Early return if this is same clue as already existing one
		if (clue instanceof TextClueScroll)
		{
			if (((TextClueScroll) clue).getText().equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		if (text.startsWith("i'd like to hear some music."))
		{
			return MusicClue.forText(rawText);
		}

		if (text.contains("degrees") && text.contains("minutes"))
		{
			return coordinatesToWorldPoint(text);
		}

		final AnagramClue anagramClue = AnagramClue.forText(text);
		if (anagramClue != null)
		{
			return anagramClue;
		}

		final CipherClue cipherClue = CipherClue.forText(text);
		if (cipherClue != null)
		{
			return cipherClue;
		}

		final CrypticClue crypticClue = CrypticClue.forText(text);

		if (crypticClue != null)
		{
			return crypticClue;
		}

		final EmoteClue emoteClue = EmoteClue.forText(text);

		if (emoteClue != null)
		{
			return emoteClue;
		}

		final FairyRingClue fairyRingClue = FairyRingClue.forText(text);

		if (fairyRingClue != null)
		{
			return fairyRingClue;
		}

		final FaloTheBardClue faloTheBardClue = FaloTheBardClue.forText(text);

		if (faloTheBardClue != null)
		{
			return faloTheBardClue;
		}

		final HotColdClue hotColdClue = HotColdClue.forText(text);

		if (hotColdClue != null)
		{
			return hotColdClue;
		}

		final SkillChallengeClue skillChallengeClue = SkillChallengeClue.forText(text, rawText);

		if (skillChallengeClue != null)
		{
			return skillChallengeClue;
		}

		// three step cryptic clues need unedited text to check which steps are already done
		final ThreeStepCrypticClue threeStepCrypticClue = ThreeStepCrypticClue.forText(text, rawText);

		if (threeStepCrypticClue != null)
		{
			return threeStepCrypticClue;
		}

		return null;
	}

	/**
	 * Example input: "00 degrees 00 minutes north 07 degrees 13 minutes west"
	 * Note: some clues use "1 degree" instead of "01 degrees"
	 */
	private CoordinateClue coordinatesToWorldPoint(String text)
	{
		String[] splitText = text.split(" ");

		if (splitText.length != 10)
		{
			log.warn("Splitting \"" + text + "\" did not result in an array of 10 cells");
			return null;
		}

		if (!splitText[1].startsWith("degree") || !splitText[3].startsWith("minute"))
		{
			log.warn("\"" + text + "\" is not a well formed coordinate string");
			return null;
		}

		int degY = Integer.parseInt(splitText[0]);
		int minY = Integer.parseInt(splitText[2]);

		if (splitText[4].equals("south"))
		{
			degY *= -1;
			minY *= -1;
		}

		int degX = Integer.parseInt(splitText[5]);
		int minX = Integer.parseInt(splitText[7]);

		if (splitText[9].equals("west"))
		{
			degX *= -1;
			minX *= -1;
		}

		WorldPoint coordinate = coordinatesToWorldPoint(degX, minX, degY, minY);
		// Convert from overworld to real
		WorldPoint mirrorPoint = WorldPoint.getMirrorPoint(coordinate, false);
		// Use mirror point as mirrorLocation if there is one
		return new CoordinateClue(text, coordinate, coordinate == mirrorPoint ? null : mirrorPoint);
	}

	/**
	 * This conversion is explained on
	 * https://oldschool.runescape.wiki/w/Treasure_Trails/Guide/Coordinates
	 */
	private WorldPoint coordinatesToWorldPoint(int degX, int minX, int degY, int minY)
	{
		// Center of the Observatory
		int x2 = 2440;
		int y2 = 3161;

		x2 += degX * 32 + Math.round(minX / 1.875);
		y2 += degY * 32 + Math.round(minY / 1.875);

		return new WorldPoint(x2, y2, 0);
	}

	private void addMapPoints(WorldPoint... points)
	{
		if (worldMapPointsSet)
		{
			return;
		}

		worldMapPointsSet = true;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);

		for (final WorldPoint point : points)
		{
			worldMapPointManager.add(new ClueScrollWorldMapPoint(point, this));
		}
	}

	private void highlightObjectsForLocation(final WorldPoint location, final int... objectIds)
	{
		final LocalPoint localLocation = LocalPoint.fromWorld(c, location);

		if (localLocation == null)
		{
			return;
		}

		final Scene scene = c.getScene();
		final Tile[][][] tiles = scene.getTiles();
		final Tile tile = tiles[c.getPlane()][localLocation.getSceneX()][localLocation.getSceneY()];

		for (GameObject object : tile.getGameObjects())
		{
			if (object == null)
			{
				continue;
			}

			for (int id : objectIds)
			{
				if (object.getId() == id)
				{
					objectsToMark.add(object);
					continue;
				}

				// Check impostors
				final ObjectComposition comp = c.getObjectDefinition(object.getId());
				final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

				if (impostor != null && impostor.getId() == id)
				{
					objectsToMark.add(object);
				}
			}
		}
	}

	private void checkClueNPCs(ClueScroll clue, final NPC... npcs)
	{
		if (!(clue instanceof NpcClueScroll))
		{
			return;
		}

		final NpcClueScroll npcClueScroll = (NpcClueScroll) clue;

		if (npcClueScroll.getNpcs() == null || npcClueScroll.getNpcs().length == 0)
		{
			return;
		}

		for (NPC npc : npcs)
		{
			if (npc == null || npc.getName() == null)
			{
				continue;
			}

			for (String npcName : npcClueScroll.getNpcs())
			{
				if (!Objects.equals(npc.getName(), npcName))
				{
					continue;
				}

				npcsToMark.add(npc);
			}
		}

		if (!npcsToMark.isEmpty() && config.displayHintArrows())
		{
			// Always set hint arrow to first seen NPC
			c.setHintArrow(npcsToMark.get(0));
		}
	}

	/**
	 * Scans all of the current plane's loaded tiles for {@link TileObject}s and passes any found objects to
	 * {@link ClueScrollPlugin#checkClueNamedObject(ClueScroll, TileObject)} for storing in the cache of discovered
	 * named objects.
	 *
	 * @param clue The active clue scroll
	 */
	private void checkClueNamedObjects(@Nullable ClueScroll clue)
	{
		if (!(clue instanceof NamedObjectClueScroll))
		{
			return;
		}

		// Search loaded tiles for objects
		for (final Tile[] tiles : c.getScene().getTiles()[c.getPlane()])
		{
			for (final Tile tile : tiles)
			{
				if (tile == null)
				{
					continue;
				}

				for (final GameObject object : tile.getGameObjects())
				{
					if (object == null)
					{
						continue;
					}

					checkClueNamedObject(clue, object);
				}
			}
		}
	}

	/**
	 * Checks passed objects against the active clue's object names and regions. If the clue is a
	 * {@link NamedObjectClueScroll} and the object matches its allowable object names and is within its regions, the
	 * object will be stored in the cache of discovered named objects.
	 *
	 * @param clue   The active clue scroll
	 * @param object The spawned or scanned object
	 */
	private void checkClueNamedObject(@Nullable final ClueScroll clue, @Nonnull final TileObject object)
	{
		if (!(clue instanceof NamedObjectClueScroll))
		{
			return;
		}

		final NamedObjectClueScroll namedObjectClue = (NamedObjectClueScroll) clue;

		final String[] objectNames = namedObjectClue.getObjectNames();
		final int[] regionIds = namedObjectClue.getObjectRegions();

		if (objectNames == null || objectNames.length == 0
			|| regionIds != null && !ArrayUtils.contains(regionIds, object.getWorldLocation().getRegionID()))
		{
			return;
		}

		final ObjectComposition comp = c.getObjectDefinition(object.getId());
		final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

		for (final String name : objectNames)
		{
			if (comp.getName().equals(name) || impostor.getName().equals(name))
			{
				namedObjectsToMark.add(object);
			}
		}
	}

	private void updateClue(final ClueScroll clue)
	{
		if (clue == null || clue == this.clue)
		{
			return;
		}

		resetClue(false);
		checkClueNPCs(clue, c.getCachedNPCs());
		checkClueNamedObjects(clue);
		// If we have a clue, save that knowledge
		// so the clue window doesn't have to be open.
		this.clue = clue;
	}

	void highlightWidget(Graphics2D graphics, Widget toHighlight, Widget container, Rectangle padding, String text)
	{
		padding = MoreObjects.firstNonNull(padding, new Rectangle());

		Point canvasLocation = toHighlight.getCanvasLocation();

		if (canvasLocation == null)
		{
			return;
		}

		Point windowLocation = container.getCanvasLocation();

		if (windowLocation.getY() > canvasLocation.getY() + toHighlight.getHeight()
			|| windowLocation.getY() + container.getHeight() < canvasLocation.getY())
		{
			return;
		}

		// Visible area of widget
		Area widgetArea = new Area(
			new Rectangle(
				canvasLocation.getX() - padding.x,
				Math.max(canvasLocation.getY(), windowLocation.getY()) - padding.y,
				toHighlight.getWidth() + padding.x + padding.width,
				Math.min(
					Math.min(windowLocation.getY() + container.getHeight() - canvasLocation.getY(), toHighlight.getHeight()),
					Math.min(canvasLocation.getY() + toHighlight.getHeight() - windowLocation.getY(), toHighlight.getHeight())) + padding.y + padding.height
			));

		OverlayUtil.INSTANCE.renderHoverableArea(graphics, widgetArea, c.getMouseCanvasPosition(),
			HIGHLIGHT_FILL_COLOR, HIGHLIGHT_BORDER_COLOR, HIGHLIGHT_HOVER_BORDER_COLOR);

		if (text == null)
		{
			return;
		}

		FontMetrics fontMetrics = graphics.getFontMetrics();

		textComponent.setPosition(new java.awt.Point(
			canvasLocation.getX() + toHighlight.getWidth() / 2 - fontMetrics.stringWidth(text) / 2,
			canvasLocation.getY() + fontMetrics.getHeight()));
		textComponent.setText(text);
		textComponent.render(graphics);
	}

	void scrollToWidget(WidgetInfo list, WidgetInfo scrollbar, Widget ... toHighlight)
	{
		final Widget parent = c.getWidget(list);
		int averageCentralY = 0;
		int nonnullCount = 0;
		for (Widget widget : toHighlight)
		{
			if (widget != null)
			{
				averageCentralY += widget.getRelativeY() + widget.getHeight() / 2;
				nonnullCount += 1;
			}
		}
		if (nonnullCount == 0)
		{
			return;
		}
		averageCentralY /= nonnullCount;
		final int newScroll = Math.max(0, Math.min(parent.getScrollHeight(),
			averageCentralY - parent.getHeight() / 2));

		c.runScript(
			ScriptID.UPDATE_SCROLLBAR,
			scrollbar.getId(),
			list.getId(),
			newScroll
		);
	}

	private boolean testClueTag(int itemId)
	{
		ClueScroll c = clue;
		if (c == null)
		{
			return false;
		}

		if (c instanceof EmoteClue)
		{
			EmoteClue emote = (EmoteClue) c;

			for (ItemRequirement ir : emote.getItemRequirements())
			{
				if (ir.fulfilledBy(itemId))
				{
					return true;
				}
			}
		}
		else if (c instanceof CoordinateClue || c instanceof HotColdClue || c instanceof FairyRingClue)
		{
			return itemId == ItemID.SPADE;
		}
		else if (c instanceof MapClue)
		{
			MapClue mapClue = (MapClue) c;

			return mapClue.getObjectId() == -1 && itemId == ItemID.SPADE;
		}
		else if (c instanceof SkillChallengeClue)
		{
			SkillChallengeClue challengeClue = (SkillChallengeClue) c;

			for (ItemRequirement ir : challengeClue.getItemRequirements())
			{
				if (ir.fulfilledBy(itemId))
				{
					return true;
				}
			}
		}

		return false;
	}
}
