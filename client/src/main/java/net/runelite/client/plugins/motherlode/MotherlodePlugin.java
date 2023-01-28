/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import eventbus.events.*;
import lombok.AccessLevel;
import lombok.Getter;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import static net.runelite.api.ObjectID.BROKEN_STRUT;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKFALL;
import static net.runelite.api.ObjectID.ROCKFALL_26680;
import net.runelite.api.Perspective;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@PluginDescriptor(
	name = "Motherlode Mine",
	description = "Show helpful information inside the Motherload Mine",
	tags = {"pay", "dirt", "mining", "mlm", "skilling", "overlay"},
	enabledByDefault = false
)
public class MotherlodePlugin extends Plugin
{
	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final Set<Integer> MINE_SPOTS = ImmutableSet.of(ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664);
	private static final Set<Integer> MLM_ORE_TYPES = ImmutableSet.of(ItemID.RUNITE_ORE, ItemID.ADAMANTITE_ORE,
		ItemID.MITHRIL_ORE, ItemID.GOLD_ORE, ItemID.COAL, ItemID.GOLDEN_NUGGET);
	private static final Set<Integer> ROCK_OBSTACLES = ImmutableSet.of(ROCKFALL, ROCKFALL_26680);

	private static final int MAX_INVENTORY_SIZE = 28;

	private static final int SACK_LARGE_SIZE = 162;
	private static final int SACK_SIZE = 81;

	private static final int UPPER_FLOOR_HEIGHT = -490;

	private MotherlodeSession session = new MotherlodeSession();
	private MotherlodeConfig config = configuration(MotherlodeConfig.class);
	private OverlayManager overlayManager = OverlayManager.INSTANCE;
	private MotherlodeOverlay overlay = new MotherlodeOverlay(this, session, config);
	private MotherlodeSceneOverlay sceneOverlay = new MotherlodeSceneOverlay(this, config);
	private MotherlodeSackOverlay motherlodeSackOverlay = new MotherlodeSackOverlay(config, this);
	private MotherlodeGemOverlay motherlodeGemOverlay = new MotherlodeGemOverlay(this, session, config);
	private MotherlodeOreOverlay motherlodeOreOverlay = new MotherlodeOreOverlay(this, session, config);
	private ClientThread clientThread = ClientThread.INSTANCE;

	@Getter(AccessLevel.PACKAGE)
	private boolean inMlm;

	@Getter(AccessLevel.PACKAGE)
	private int curSackSize;
	@Getter(AccessLevel.PACKAGE)
	private int maxSackSize;
	@Getter(AccessLevel.PACKAGE)
	private Integer depositsLeft;
	private boolean shouldUpdateOres;
	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> veins = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> rocks = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> brokenStruts = new HashSet<>();

	private int lastCheck = 0;

	@Override
	public void onStart()
	{
		overlayManager.add(overlay);
		overlayManager.add(sceneOverlay);
		overlayManager.add(motherlodeGemOverlay);
		overlayManager.add(motherlodeOreOverlay);
		overlayManager.add(motherlodeSackOverlay);

		inMlm = checkInMlm();

		if (inMlm)
		{
			clientThread.invokeLater(this::refreshSackValues);
		}
	}

	@Override
	public void onStop()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(sceneOverlay);
		overlayManager.remove(motherlodeGemOverlay);
		overlayManager.remove(motherlodeOreOverlay);
		overlayManager.remove(motherlodeSackOverlay);
		veins.clear();
		rocks.clear();
		brokenStruts.clear();

		Widget sack = getClient().getWidget(WidgetInfo.MOTHERLODE_MINE);

		clientThread.invokeLater(() ->
		{
			if (sack != null && sack.isHidden())
			{
				sack.setHidden(false);
			}
		});
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{
		if (inMlm)
		{
			int lastSackValue = curSackSize;
			refreshSackValues();
			shouldUpdateOres = curSackSize < lastSackValue;
			if (shouldUpdateOres)
			{
				// Take a snapshot of the inventory before the new ore is added.
				ItemContainer itemContainer = getClient().getItemContainer(InventoryID.INVENTORY);
				if (itemContainer != null)
				{
					inventorySnapshot = HashMultiset.create();
					Arrays.stream(itemContainer.getItems())
						.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
						.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
				}
			}
		}
	}

	@Override
	public void onChatMessage(ChatMessage event)
	{
		if (!inMlm || event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMessage = event.getMessage();

		switch (chatMessage)
		{
			case "You manage to mine some pay-dirt.":
				session.incrementPayDirtMined();
				break;

			case "You just found a Diamond!":
				session.incrementGemFound(ItemID.UNCUT_DIAMOND);
				break;

			case "You just found a Ruby!":
				session.incrementGemFound(ItemID.UNCUT_RUBY);
				break;

			case "You just found an Emerald!":
				session.incrementGemFound(ItemID.UNCUT_EMERALD);
				break;

			case "You just found a Sapphire!":
				session.incrementGemFound(ItemID.UNCUT_SAPPHIRE);
				break;
		}
	}

	@Override
	public void onGameTick(GameTick event) {
		if (!inMlm)
		{
			return;
		}

		if (lastCheck == 0) {
			lastCheck++;
			return;
		} else {
			lastCheck = 0;
		}

		depositsLeft = calculateDepositsLeft();

		Instant lastPayDirtMined = session.getLastPayDirtMined();
		if (lastPayDirtMined == null)
		{
			return;
		}

		// reset recentPayDirtMined if you haven't mined anything recently
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceMined = Duration.between(lastPayDirtMined, Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
		}
	}


	@Override
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		if (MINE_SPOTS.contains(wallObject.getId()))
		{
			veins.add(wallObject);
		}
	}

	@Override
	public void onWallObjectChanged(WallObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		veins.remove(previous);
		if (MINE_SPOTS.contains(wallObject.getId()))
		{
			veins.add(wallObject);
		}
	}

	@Override
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		veins.remove(wallObject);
	}

	@Override
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		addGameObject(event.getGameObject());
	}

	@Override
	public void onGameObjectChanged(GameObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		removeGameObject(event.getOldObject());
		addGameObject(event.getNewObject());
	}

	@Override
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		removeGameObject(event.getGameObject());
	}

	@Override
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			// on region changes the tiles get set to null
			veins.clear();
			rocks.clear();
			brokenStruts.clear();

			inMlm = checkInMlm();
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent code from running while logged out.
			inMlm = false;
		}
	}

	@Override
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer container = event.getItemContainer();

		if (!inMlm || !shouldUpdateOres || inventorySnapshot == null || container != getClient().getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		// Build set of current inventory
		Multiset<Integer> current = HashMultiset.create();
		Arrays.stream(container.getItems())
			.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
			.forEach(item -> current.add(item.getId(), item.getQuantity()));

		// Take the difference
		Multiset<Integer> delta = Multisets.difference(current, inventorySnapshot);

		// Update the session
		delta.forEachEntry(session::updateOreFound);
		inventorySnapshot = null;
		shouldUpdateOres = false;
	}

	private Integer calculateDepositsLeft()
	{
		if (maxSackSize == 0) // check if maxSackSize has been initialized
		{
			refreshSackValues();
		}

		double depositsLeft = 0;
		int nonPayDirtItems = 0;

		ItemContainer inventory = getClient().getItemContainer(InventoryID.INVENTORY);
		if (inventory == null)
		{
			return null;
		}

		Item[] result = inventory.getItems();

		for (Item item : result)
		{
			// Assume that MLM ores are being banked and exclude them from the check,
			// so the user doesn't see the Overlay switch between deposits left and N/A.
			//
			// Count other items at nonPayDirtItems so depositsLeft is calculated accordingly.
			if (item.getId() != ItemID.PAYDIRT && item.getId() != -1 && !MLM_ORE_TYPES.contains(item.getId()))
			{
				nonPayDirtItems += 1;
			}
		}

		double inventorySpace = MAX_INVENTORY_SIZE - nonPayDirtItems;
		double sackSizeRemaining = maxSackSize - curSackSize;

		if (inventorySpace > 0 && sackSizeRemaining > 0)
		{
			depositsLeft = Math.ceil(sackSizeRemaining / inventorySpace);
		}
		else if (inventorySpace == 0)
		{
			return null;
		}

		return (int) depositsLeft;
	}

	private boolean checkInMlm()
	{
		GameState gameState = getClient().getGameState();
		if (gameState != GameState.LOGGED_IN
			&& gameState != GameState.LOADING)
		{
			return false;
		}

		int[] currentMapRegions = getClient().getMapRegions();

		// Verify that all regions exist in MOTHERLODE_MAP_REGIONS
		for (int region : currentMapRegions)
		{
			if (!MOTHERLODE_MAP_REGIONS.contains(region))
			{
				return false;
			}
		}

		return true;
	}

	private void refreshSackValues()
	{
		curSackSize = getClient().getVarbitValue(Varbits.SACK_NUMBER);
		boolean sackUpgraded = getClient().getVarbitValue(Varbits.SACK_UPGRADED) == 1;
		maxSackSize = sackUpgraded ? SACK_LARGE_SIZE : SACK_SIZE;
	}

	/**
	 * Checks if the given point is "upstairs" in the mlm.
	 * The upper floor is actually on z=0.
	 *
	 * @param localPoint
	 * @return
	 */
	boolean isUpstairs(LocalPoint localPoint)
	{
		return Perspective.getTileHeight(getClient(), localPoint, 0) < UPPER_FLOOR_HEIGHT;
	}

	private void addGameObject(GameObject gameObject)
	{
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}

		if (BROKEN_STRUT == gameObject.getId())
		{
			brokenStruts.add(gameObject);
		}
	}

	private void removeGameObject(GameObject gameObject)
	{
		rocks.remove(gameObject);
		brokenStruts.remove(gameObject);
	}
}
