/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.grounditems;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.EvictingQueue;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Rectangle;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

import eventbus.events.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import meteor.Main;
import meteor.events.NpcLootReceived;
import meteor.events.PlayerLootReceived;
import meteor.game.ItemManager;
import meteor.game.ItemStack;
import meteor.input.KeyManager;
import meteor.input.MouseManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import meteor.util.ColorUtil;
import meteor.util.QuantityFormatter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.grounditems.config.HighlightTier;
import net.runelite.client.plugins.grounditems.config.ItemHighlightMode;
import net.runelite.client.plugins.grounditems.config.MenuHighlightMode;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.BOTH;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.NAME;
import static net.runelite.client.plugins.grounditems.config.MenuHighlightMode.OPTION;

@PluginDescriptor(
	name = "Ground Items",
	description = "Highlight ground items and/or show price information",
	tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay", "lootbeam"}
)
public class GroundItemsPlugin extends Plugin
{
	@Value
	static class PriceHighlight
	{
		private final int price;
		private final Color color;
	}

	// ItemID for coins
	private static final int COINS = ItemID.COINS_995;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> textBoxBounds;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> hiddenBoxBounds;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Map.Entry<Rectangle, GroundItem> highlightBoxBounds;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hideAll;

	private List<String> hiddenItemList = new CopyOnWriteArrayList<>();
	private List<String> highlightedItemsList = new CopyOnWriteArrayList<>();
	
	private GroundItemsConfig config = configuration(GroundItemsConfig.class);
	private GroundItemHotkeyListener hotkeyListener = new GroundItemHotkeyListener(this, config);
	private GroundItemMouseAdapter mouseAdapter = new GroundItemMouseAdapter(this);
	private MouseManager mouseManager = MouseManager.INSTANCE;
	private KeyManager keyManager = KeyManager.INSTANCE;
	private Client client = Main.client;
	private ClientThread clientThread = ClientThread.INSTANCE;
	private ItemManager itemManager = ItemManager.INSTANCE;
	private OverlayManager overlayManager = OverlayManager.INSTANCE;
	private GroundItemsOverlay overlay = new GroundItemsOverlay(this, config);

	private ScheduledExecutorService executor = Main.INSTANCE.getExecutor();

	@Getter
	private final Table<WorldPoint, Integer, GroundItem> collectedGroundItems = HashBasedTable.create();
	private List<PriceHighlight> priceChecks = ImmutableList.of();
	private LoadingCache<NamedQuantity, Boolean> highlightedItems;
	private LoadingCache<NamedQuantity, Boolean> hiddenItems;
	private final Queue<Integer> droppedItemQueue = EvictingQueue.create(16); // recently dropped items
	private int lastUsedItem;
	private final Map<WorldPoint, Lootbeam> lootbeams = new HashMap<>();

	@Override
	public void onStart()
	{
		overlayManager.add(overlay);
		mouseManager.registerMouseListener(mouseAdapter);
		keyManager.registerKeyListener(hotkeyListener, getClass());
		executor.execute(this::reset);
		lastUsedItem = -1;
	}

	@Override
	public void onStop()
	{
		overlayManager.remove(overlay);
		mouseManager.unregisterMouseListener(mouseAdapter);
		keyManager.unregisterKeyListener(hotkeyListener);
		highlightedItems.invalidateAll();
		highlightedItems = null;
		hiddenItems.invalidateAll();
		hiddenItems = null;
		hiddenItemList = null;
		highlightedItemsList = null;
		collectedGroundItems.clear();
		clientThread.invokeLater(this::removeAllLootbeams);
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("grounditems"))
		{
			executor.execute(this::reset);
		}
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			collectedGroundItems.clear();
			lootbeams.clear();
		}
	}

	@Override
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		TileItem item = itemSpawned.getItem();
		Tile tile = itemSpawned.getTile();

		GroundItem groundItem = buildGroundItem(tile, item);
		GroundItem existing = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (existing != null)
		{
			existing.setQuantity(existing.getQuantity() + groundItem.getQuantity());
			// The spawn time remains set at the oldest spawn
		}
		else
		{
			collectedGroundItems.put(tile.getWorldLocation(), item.getId(), groundItem);
		}

		if (!config.onlyShowLoot())
		{
			notifyHighlightedItem(groundItem);
		}

		handleLootbeam(tile.getWorldLocation());
	}

	@Override
	public void onItemDespawned(ItemDespawned itemDespawned)
	{
		TileItem item = itemDespawned.getItem();
		Tile tile = itemDespawned.getTile();

		GroundItem groundItem = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (groundItem == null)
		{
			return;
		}

		if (groundItem.getQuantity() <= item.getQuantity())
		{
			collectedGroundItems.remove(tile.getWorldLocation(), item.getId());
		}
		else
		{
			groundItem.setQuantity(groundItem.getQuantity() - item.getQuantity());
			// When picking up an item when multiple stacks appear on the ground,
			// it is not known which item is picked up, so we invalidate the spawn
			// time
			groundItem.setSpawnTime(null);
		}

		handleLootbeam(tile.getWorldLocation());
	}

	@Override
	public void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged)
	{
		TileItem item = itemQuantityChanged.getItem();
		Tile tile = itemQuantityChanged.getTile();
		int oldQuantity = itemQuantityChanged.getOldQuantity();
		int newQuantity = itemQuantityChanged.getNewQuantity();

		int diff = newQuantity - oldQuantity;
		GroundItem groundItem = collectedGroundItems.get(tile.getWorldLocation(), item.getId());
		if (groundItem != null)
		{
			groundItem.setQuantity(groundItem.getQuantity() + diff);
		}

		handleLootbeam(tile.getWorldLocation());
	}

	@Override
	public void onNpcLootReceived(NpcLootReceived npcLootReceived)
	{
		Collection<ItemStack> items = npcLootReceived.getItems();
		lootReceived(items, LootType.PVM);
	}

	@Override
	public void onPlayerLootReceived(PlayerLootReceived playerLootReceived)
	{
		Collection<ItemStack> items = playerLootReceived.getItems();
		lootReceived(items, LootType.PVP);
	}

	@Override
	public void onClientTick(ClientTick event)
	{
		if (!config.collapseEntries())
		{
			return;
		}

		final MenuEntry[] menuEntries = client.getMenuEntries();
		final List<MenuEntryWithCount> newEntries = new ArrayList<>(menuEntries.length);

		outer:
		for (int i = menuEntries.length - 1; i >= 0; i--)
		{
			MenuEntry menuEntry = menuEntries[i];

			MenuAction menuType = menuEntry.getType();
			if (menuType == MenuAction.GROUND_ITEM_FIRST_OPTION || menuType == MenuAction.GROUND_ITEM_SECOND_OPTION
				|| menuType == MenuAction.GROUND_ITEM_THIRD_OPTION || menuType == MenuAction.GROUND_ITEM_FOURTH_OPTION
				|| menuType == MenuAction.GROUND_ITEM_FIFTH_OPTION || menuType == MenuAction.EXAMINE_ITEM_GROUND)
			{
				for (MenuEntryWithCount entryWCount : newEntries)
				{
					if (entryWCount.getEntry().equals(menuEntry))
					{
						entryWCount.increment();
						continue outer;
					}
				}
			}

			newEntries.add(new MenuEntryWithCount(menuEntry));
		}

		Collections.reverse(newEntries);

		client.setMenuEntries(newEntries.stream().map(e ->
		{
			final MenuEntry entry = e.getEntry();
			final int count = e.getCount();
			if (count > 1)
			{
				entry.setTarget(entry.getTarget() + " x " + count);
			}

			return entry;
		}).toArray(MenuEntry[]::new));
	}

	private void lootReceived(Collection<ItemStack> items, LootType lootType)
	{
		for (ItemStack itemStack : items)
		{
			WorldPoint location = WorldPoint.fromLocal(client, itemStack.getLocation());
			GroundItem groundItem = collectedGroundItems.get(location, itemStack.getId());
			if (groundItem != null)
			{
				groundItem.setLootType(lootType);

				if (config.onlyShowLoot())
				{
					notifyHighlightedItem(groundItem);
				}
			}
		}

		// Since the loot can potentially be over multiple tiles, make sure to process lootbeams on all those tiles
		items.stream()
			.map(ItemStack::getLocation)
			.map(l -> WorldPoint.fromLocal(client, l))
			.distinct()
			.forEach(this::handleLootbeam);
	}

	private GroundItem buildGroundItem(final Tile tile, final TileItem item)
	{
		// Collect the data for the item
		final int itemId = item.getId();
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;
		final int alchPrice = itemComposition.getHaPrice();
		final boolean dropped = tile.getWorldLocation().equals(client.getLocalPlayer().getWorldLocation()) && droppedItemQueue.remove(itemId);
		final boolean table = itemId == lastUsedItem && tile.getItemLayer().getHeight() > 0;

		final GroundItem groundItem = GroundItem.builder()
			.id(itemId)
			.location(tile.getWorldLocation())
			.itemId(realItemId)
			.quantity(item.getQuantity())
			.name(itemComposition.getName())
			.haPrice(alchPrice)
			.height(tile.getItemLayer().getHeight())
			.tradeable(itemComposition.isTradeable())
			.lootType(dropped ? LootType.DROPPED : (table ? LootType.TABLE : LootType.UNKNOWN))
			.spawnTime(Instant.now())
			.stackable(itemComposition.isStackable())
			.build();

		// Update item price in case it is coins
		if (realItemId == COINS)
		{
			groundItem.setHaPrice(1);
			groundItem.setGePrice(1);
		}
		else
		{
			groundItem.setGePrice(itemManager.getItemPrice(realItemId));
		}

		return groundItem;
	}

	private void reset()
	{
		// gets the hidden items from the text box in the config
		hiddenItemList = Text.fromCSV(config.getHiddenItems());

		// gets the highlighted items from the text box in the config
		highlightedItemsList = Text.fromCSV(config.getHighlightItems());

		highlightedItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(highlightedItemsList));

		hiddenItems = CacheBuilder.newBuilder()
			.maximumSize(512L)
			.expireAfterAccess(10, TimeUnit.MINUTES)
			.build(new WildcardMatchLoader(hiddenItemList));

		// Cache colors
		ImmutableList.Builder<PriceHighlight> priceCheckBuilder = ImmutableList.builder();

		if (config.insaneValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.insaneValuePrice(), config.insaneValueColor()));
		}

		if (config.highValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.highValuePrice(), config.highValueColor()));
		}

		if (config.mediumValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.mediumValuePrice(), config.mediumValueColor()));
		}

		if (config.lowValuePrice() > 0)
		{
			priceCheckBuilder.add(new PriceHighlight(config.lowValuePrice(), config.lowValueColor()));
		}

		priceChecks = priceCheckBuilder.build();

		clientThread.invokeLater(this::handleLootbeams);
	}

	@Override
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuAction type = MenuAction.of(event.getOpcode());
		if (type == MenuAction.GROUND_ITEM_FIRST_OPTION || type == MenuAction.GROUND_ITEM_SECOND_OPTION ||
			type == MenuAction.GROUND_ITEM_THIRD_OPTION || type == MenuAction.GROUND_ITEM_FOURTH_OPTION ||
			type == MenuAction.GROUND_ITEM_FIFTH_OPTION || type == MenuAction.WIDGET_TARGET_ON_GROUND_ITEM)
		{
			final int itemId = event.getIdentifier();
			final int sceneX = event.getParam0();
			final int sceneY = event.getParam1();

			MenuEntry[] menuEntries = client.getMenuEntries();
			MenuEntry lastEntry = menuEntries[menuEntries.length - 1];

			final WorldPoint worldPoint = WorldPoint.fromScene(client, sceneX, sceneY, client.getPlane());
			GroundItem groundItem = collectedGroundItems.get(worldPoint, itemId);

			//This can happen if you drop an item before turning on ground items then moving your mouse over it after its enabled
			if (groundItem == null) {
				return;
			}
			int quantity = groundItem.getQuantity();

			final int gePrice = groundItem.getGePrice();
			final int haPrice = groundItem.getHaPrice();
			final Color hidden = getHidden(new NamedQuantity(groundItem.getName(), quantity), gePrice, haPrice, groundItem.isTradeable());
			final Color highlighted = getHighlighted(new NamedQuantity(groundItem.getName(), quantity), gePrice, haPrice);
			final Color color = getItemColor(highlighted, hidden);
			final boolean canBeRecolored = highlighted != null || (hidden != null && config.recolorMenuHiddenItems());

			if ((config.itemHighlightMode() == ItemHighlightMode.MENU || config.itemHighlightMode() == ItemHighlightMode.BOTH) &&
				(color != null && canBeRecolored && !color.equals(config.defaultColor())))
			{
				final MenuHighlightMode mode = config.menuHighlightMode();

				if (mode == BOTH || mode == OPTION)
				{
					lastEntry.setOption(ColorUtil.prependColorTag(lastEntry.getOption(), color));
				}

				if (mode == BOTH || mode == NAME)
				{
					// <col=ff9040>Logs
					// <col=00ff00>Telekinetic Grab</col><col=ffffff> -> <col=ff9040>Logs
					String target = lastEntry.getTarget();

					int i = target.lastIndexOf('>');
					lastEntry.setTarget(target.substring(0, i - 11) + ColorUtil.INSTANCE.colorTag(color) + target.substring(i + 1));
				}
			}

			if (config.showMenuItemQuantities() && groundItem.isStackable() && quantity > 1)
			{
				lastEntry.setTarget(lastEntry.getTarget() + " (" + quantity + ")");
			}

			if (hidden != null && highlighted == null && config.deprioritizeHiddenItems())
			{
				lastEntry.setDeprioritized(true);
			}
		}
	}

	void updateList(String item, boolean hiddenList)
	{
		final List<String> hiddenItemSet = new ArrayList<>(hiddenItemList);
		final List<String> highlightedItemSet = new ArrayList<>(highlightedItemsList);

		if (hiddenList)
		{
			highlightedItemSet.removeIf(item::equalsIgnoreCase);
		}
		else
		{
			hiddenItemSet.removeIf(item::equalsIgnoreCase);
		}

		final List<String> items = hiddenList ? hiddenItemSet : highlightedItemSet;

		if (!items.removeIf(item::equalsIgnoreCase))
		{
			items.add(item);
		}

		config.setHiddenItems(Text.toCSV(hiddenItemSet));
		config.setHighlightedItem(Text.toCSV(highlightedItemSet));
	}

	Color getHighlighted(NamedQuantity item, int gePrice, int haPrice)
	{
		if (TRUE.equals(highlightedItems.getUnchecked(item)))
		{
			return config.highlightedColor();
		}

		// Explicit hide takes priority over implicit highlight
		if (TRUE.equals(hiddenItems.getUnchecked(item)))
		{
			return null;
		}

		final int price = getValueByMode(gePrice, haPrice);
		for (PriceHighlight highlight : priceChecks)
		{
			if (price > highlight.getPrice())
			{
				return highlight.getColor();
			}
		}

		return null;
	}

	Color getHidden(NamedQuantity item, int gePrice, int haPrice, boolean isTradeable)
	{
		final boolean isExplicitHidden = TRUE.equals(hiddenItems.getUnchecked(item));
		final boolean isExplicitHighlight = TRUE.equals(highlightedItems.getUnchecked(item));
		final boolean canBeHidden = gePrice > 0 || isTradeable || !config.dontHideUntradeables();
		final boolean underGe = gePrice < config.getHideUnderValue();
		final boolean underHa = haPrice < config.getHideUnderValue();

		// Explicit highlight takes priority over implicit hide
		return isExplicitHidden || (!isExplicitHighlight && canBeHidden && underGe && underHa)
			? config.hiddenColor()
			: null;
	}

	Color getItemColor(Color highlighted, Color hidden)
	{
		if (highlighted != null)
		{
			return highlighted;
		}

		if (hidden != null)
		{
			return hidden;
		}

		return config.defaultColor();
	}

	@Override
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.getFocused())
		{
			setHotKeyPressed(false);
		}
	}

	private void notifyHighlightedItem(GroundItem item)
	{
		final boolean shouldNotifyHighlighted = config.notifyHighlightedDrops() &&
			TRUE.equals(highlightedItems.getUnchecked(new NamedQuantity(item)));

		final boolean shouldNotifyTier = config.notifyTier() != HighlightTier.OFF &&
			getValueByMode(item.getGePrice(), item.getHaPrice()) > config.notifyTier().getValueFromTier(config) &&
			FALSE.equals(hiddenItems.getUnchecked(new NamedQuantity(item)));

		final String dropType;
		if (shouldNotifyHighlighted)
		{
			dropType = "highlighted";
		}
		else if (shouldNotifyTier)
		{
			dropType = "valuable";
		}
		else
		{
			return;
		}

		final StringBuilder notificationStringBuilder = new StringBuilder()
			.append("You received a ")
			.append(dropType)
			.append(" drop: ")
			.append(item.getName());

		if (item.getQuantity() > 1)
		{
			notificationStringBuilder.append(" (")
				.append(QuantityFormatter.quantityToStackSize(item.getQuantity()))
				.append(')');
		}
		
		//notifier.notify(notificationStringBuilder.toString());
	}

	private int getValueByMode(int gePrice, int haPrice)
	{
		switch (config.valueCalculationMode())
		{
			case GE:
				return gePrice;
			case HA:
				return haPrice;
			default: // Highest
				return Math.max(gePrice, haPrice);
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (menuOptionClicked.isItemOp() && menuOptionClicked.getMenuOption().equals("Drop"))
		{
			int itemId = menuOptionClicked.getItemId();
			// Keep a queue of recently dropped items to better detect
			// item spawns that are drops
			droppedItemQueue.add(itemId);
		}
		else if (menuOptionClicked.getMenuAction() == MenuAction.WIDGET_TARGET_ON_GAME_OBJECT && client.getSelectedWidget().getId() == WidgetInfo.INVENTORY.getId())
		{
			lastUsedItem = client.getSelectedWidget().getItemId();
		}
	}

	private void handleLootbeam(WorldPoint worldPoint)
	{
		/*
		 * Return and remove the lootbeam from this location if lootbeam are disabled
		 * Lootbeam can be at this location if the config was just changed
		 */
		if (!(config.showLootbeamForHighlighted() || config.showLootbeamTier() != HighlightTier.OFF))
		{
			removeLootbeam(worldPoint);
			return;
		}

		int price = -1;
		Collection<GroundItem> groundItems = collectedGroundItems.row(worldPoint).values();
		for (GroundItem groundItem : groundItems)
		{
			if ((config.onlyShowLoot() && !groundItem.isMine()))
			{
				continue;
			}

			/*
			 * highlighted items have the highest priority so if an item is highlighted at this location
			 * we can early return
			 */
			NamedQuantity item = new NamedQuantity(groundItem);
			if (config.showLootbeamForHighlighted()
				&& TRUE.equals(highlightedItems.getUnchecked(item)))
			{
				addLootbeam(worldPoint, config.highlightedColor());
				return;
			}

			// Explicit hide takes priority over implicit highlight
			if (TRUE.equals(hiddenItems.getUnchecked(item)))
			{
				continue;
			}

			int itemPrice = getValueByMode(groundItem.getGePrice(), groundItem.getHaPrice());
			price = Math.max(itemPrice, price);
		}

		if (config.showLootbeamTier() != HighlightTier.OFF)
		{
			for (PriceHighlight highlight : priceChecks)
			{
				if (price > highlight.getPrice() && price > config.showLootbeamTier().getValueFromTier(config))
				{
					addLootbeam(worldPoint, highlight.color);
					return;
				}
			}
		}

		removeLootbeam(worldPoint);
	}

	private void handleLootbeams()
	{
		for (WorldPoint worldPoint : collectedGroundItems.rowKeySet())
		{
			handleLootbeam(worldPoint);
		}
	}

	private void removeAllLootbeams()
	{
		for (Lootbeam lootbeam : lootbeams.values())
		{
			lootbeam.remove();
		}

		lootbeams.clear();
	}

	private void addLootbeam(WorldPoint worldPoint, Color color)
	{
		Lootbeam lootbeam = lootbeams.get(worldPoint);
		if (lootbeam == null)
		{
			lootbeam = new Lootbeam(client, clientThread, worldPoint, color, config.lootbeamStyle());
			lootbeams.put(worldPoint, lootbeam);
		}
		else
		{
			lootbeam.setColor(color);
			lootbeam.setStyle(config.lootbeamStyle());
		}
	}

	private void removeLootbeam(WorldPoint worldPoint)
	{
		Lootbeam lootbeam = lootbeams.remove(worldPoint);
		if (lootbeam != null)
		{
			lootbeam.remove();
		}
	}
}
