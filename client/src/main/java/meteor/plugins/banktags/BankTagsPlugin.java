/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.plugins.banktags;

import com.google.common.collect.Lists;
import com.google.common.primitives.Shorts;
import com.google.inject.Provides;
import eventbus.events.*;
import kotlin.Unit;
import meteor.Main;
import meteor.config.ConfigManager;
import meteor.game.ItemManager;
import meteor.game.ItemVariationMapping;
import meteor.game.SpriteManager;
import meteor.game.chatbox.ChatboxPanelManager;
import meteor.input.MouseManager;
import meteor.input.MouseWheelListener;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.plugins.banktags.tabs.TabInterface;
import meteor.plugins.banktags.tabs.TabManager;
import meteor.plugins.banktags.tabs.TabSprites;
import meteor.plugins.banktags.tabs.TagTab;
import meteor.rs.ClientThread;
import net.runelite.api.*;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;

import java.awt.event.MouseWheelEvent;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static meteor.plugins.banktags.tabs.TabInterface.FILTERED_CHARS;

@PluginDescriptor(
	name = "Bank Tags",
	description = "Enable tagging of bank items and searching of bank tags",
	tags = {"searching", "tagging"}
)
public class BankTagsPlugin extends Plugin implements MouseWheelListener
{
	public static final String CONFIG_GROUP = "banktags";
	public static final String TAG_SEARCH = "tag:";
	private static final String EDIT_TAGS_MENU_OPTION = "Edit-tags";
	public static final String ICON_SEARCH = "icon_";
	public static final String TAG_TABS_CONFIG = "tagtabs";
	public static final String VAR_TAG_SUFFIX = "*";
	private static final int ITEMS_PER_ROW = 8;
	private static final int ITEM_VERTICAL_SPACING = 36;
	private static final int ITEM_HORIZONTAL_SPACING = 48;
	private static final int ITEM_ROW_START = 51;
	private static final int ITEM_CONTAINER_BOTTOM_PADDING = 4;

	private static final int MAX_RESULT_COUNT = 250;

	private static final String SEARCH_BANK_INPUT_TEXT =
		"Show items whose names or tags contain the following text:<br>" +
			"(To show only tagged items, start your search with 'tag:')";
	private static final String SEARCH_BANK_INPUT_TEXT_FOUND =
		"Show items whose names or tags contain the following text: (%d found)<br>" +
			"(To show only tagged items, start your search with 'tag:')";

	private ItemManager itemManager = ItemManager.INSTANCE;

	private Client client = Main.client;

	private ClientThread clientThread = ClientThread.INSTANCE;

	private ChatboxPanelManager chatboxPanelManager = ChatboxPanelManager.INSTANCE;

	private MouseManager mouseManager = MouseManager.INSTANCE;

	private BankTagsConfig config = configuration(BankTagsConfig.class);

	private TagManager tagManager = new TagManager();

	private TabManager tabManager = new TabManager();

	private TabInterface tabInterface = new TabInterface(tagManager, tabManager, config);

	private SpriteManager spriteManager = SpriteManager.INSTANCE;

	private ConfigManager configManager = ConfigManager.INSTANCE;

	@Override
	public void resetConfiguration()
	{
		List<String> extraKeys = Lists.newArrayList(
			CONFIG_GROUP + "." + TagManager.ITEM_KEY_PREFIX,
			CONFIG_GROUP + "." + ICON_SEARCH,
			CONFIG_GROUP + "." + TAG_TABS_CONFIG
		);

		for (String prefix : extraKeys)
		{
			List<String> keys = configManager.getConfigurationKeys(prefix);
			for (String key : keys)
			{
				String[] str = key.split("\\.", 2);
				if (str.length == 2)
				{
					configManager.unsetConfiguration(str[0], str[1]);
				}
			}
		}

		clientThread.invokeLater(() ->
		{
			tabInterface.destroy();
			tabInterface.init();
		});
	}


	@Override
	public void onStart()
	{
		cleanConfig();
		mouseManager.registerMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::init);
		spriteManager.addSpriteOverrides(TabSprites.values());
	}

	@Deprecated
	private void cleanConfig()
	{
		removeInvalidTags("tagtabs");

		List<String> tags = configManager.getConfigurationKeys(CONFIG_GROUP + ".item_");
		tags.forEach(s ->
		{
			String[] split = s.split("\\.", 2);
			removeInvalidTags(split[1]);
		});

		List<String> icons = configManager.getConfigurationKeys(CONFIG_GROUP + ".icon_");
		icons.forEach(s ->
		{
			String[] split = s.split("\\.", 2);
			String replaced = split[1].replaceAll("[<>/]", "");
			if (!split[1].equals(replaced))
			{
				String value = configManager.getConfiguration(CONFIG_GROUP, split[1]);
				configManager.unsetConfiguration(CONFIG_GROUP, split[1]);
				if (replaced.length() > "icon_".length())
				{
					configManager.setConfiguration(CONFIG_GROUP, replaced, value);
				}
			}
		});
	}

	@Deprecated
	private void removeInvalidTags(final String key)
	{
		final String value = configManager.getConfiguration(CONFIG_GROUP, key);
		if (value == null)
		{
			return;
		}

		String replaced = value.replaceAll("[<>:/]", "");
		if (!value.equals(replaced))
		{
			replaced = Text.toCSV(Text.fromCSV(replaced));
			if (replaced.isEmpty())
			{
				configManager.unsetConfiguration(CONFIG_GROUP, key);
			}
			else
			{
				configManager.setConfiguration(CONFIG_GROUP, key, replaced);
			}
		}
	}

	@Override
	public void onStop()
	{
		mouseManager.unregisterMouseWheelListener(this);
		clientThread.invokeLater(tabInterface::destroy);
		spriteManager.removeSpriteOverrides(TabSprites.values());
	}

	@Override
	public void onGrandExchangeSearched(GrandExchangeSearched event)
	{
		final String input = client.getVarcStrValue(VarClientStr.INPUT_TEXT.getIndex());
		if (!input.startsWith(TAG_SEARCH))
		{
			return;
		}

		event.consume();

		final String tag = input.substring(TAG_SEARCH.length()).trim();
		final Set<Integer> ids = tagManager.getItemsForTag(tag)
			.stream()
			.mapToInt(Math::abs)
			.mapToObj(ItemVariationMapping.INSTANCE::getVariations)
			.flatMap(Collection::stream)
			.distinct()
			.filter(i -> itemManager.getItemComposition(i).isTradeable())
			.limit(MAX_RESULT_COUNT)
			.collect(Collectors.toCollection(TreeSet::new));

		client.setGeSearchResultIndex(0);
		client.setGeSearchResultCount(ids.size());
		client.setGeSearchResultIds(Shorts.toArray(ids));
	}

	@Override
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();

		int[] intStack = client.getIntStack();
		String[] stringStack = client.getStringStack();
		int intStackSize = client.getIntStackSize();
		int stringStackSize = client.getStringStackSize();

		tabInterface.handleScriptEvent(event);

		switch (eventName)
		{
			case "setSearchBankInputText":
				stringStack[stringStackSize - 1] = SEARCH_BANK_INPUT_TEXT;
				break;
			case "setSearchBankInputTextFound":
			{
				int matches = intStack[intStackSize - 1];
				stringStack[stringStackSize - 1] = String.format(SEARCH_BANK_INPUT_TEXT_FOUND, matches);
				break;
			}
			case "bankSearchFilter":
				final int itemId = intStack[intStackSize - 1];
				final String searchfilter = stringStack[stringStackSize - 1];

				// This event only fires when the bank is in search mode. It will fire even if there is no search
				// input. We prevent having a tag tab open while also performing a normal search, so if a tag tab
				// is active here it must mean we have placed the bank into search mode. See onScriptPostFired().
				TagTab activeTab = tabInterface.getActiveTab();
				// Shared storage uses the bankmain filter scripts too. Allow using tag searches in it but don't
				// apply the tag search from the active tab.
				final boolean bankOpen = client.getItemContainer(InventoryID.BANK) != null;
				String search = activeTab != null && bankOpen ? TAG_SEARCH + activeTab.getTag() : searchfilter;

				if (search.isEmpty())
				{
					return;
				}

				boolean tagSearch = search.startsWith(TAG_SEARCH);
				if (tagSearch)
				{
					search = search.substring(TAG_SEARCH.length()).trim();
				}

				if (tagManager.findTag(itemId, search))
				{
					// return true
					intStack[intStackSize - 2] = 1;
				}
				else if (tagSearch)
				{
					// if the item isn't tagged we return false to prevent the item matching if the item name happens
					// to contain the tag name.
					intStack[intStackSize - 2] = 0;
				}
				break;
			case "getSearchingTagTab":
				intStack[intStackSize - 1] = tabInterface.isActive() ? 1 : 0;
				break;
		}
	}

	@Override
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (event.getParam1() == WidgetInfo.BANK_ITEM_CONTAINER.getId()
			&& event.getOption().equals("Examine"))
		{
			Widget container = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
			Widget item = container.getChild(event.getParam0());
			int itemID = item.getItemId();
			String text = EDIT_TAGS_MENU_OPTION;
			int tagCount = tagManager.getTags(itemID, false).size() + tagManager.getTags(itemID, true).size();

			if (tagCount > 0)
			{
				text += " (" + tagCount + ")";
			}

			MenuEntry menuEntry = client.createMenuEntry(-1)
				.setParam0(event.getParam0())
				.setParam1(event.getParam1())
				.setTarget(event.getTarget())
				.setOption(text)
				.setType(MenuAction.RUNELITE)
				.setIdentifier(event.getIdentifier());

			Main.INSTANCE.getOnClicks().put(menuEntry, this::editTags);
		}

		tabInterface.handleAdd(event);
	}

	private void editTags(MenuEntry entry)
	{
		int inventoryIndex = entry.getParam0();
		ItemContainer bankContainer = client.getItemContainer(InventoryID.BANK);
		if (bankContainer == null)
		{
			return;
		}
		Item[] items = bankContainer.getItems();
		if (inventoryIndex < 0 || inventoryIndex >= items.length)
		{
			return;
		}
		Item item = bankContainer.getItems()[inventoryIndex];
		if (item == null)
		{
			return;
		}

		int itemId = item.getId();
		ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		String name = itemComposition.getName();

		// Get both tags and vartags and append * to end of vartags name
		Collection<String> tags = tagManager.getTags(itemId, false);
		tagManager.getTags(itemId, true).stream()
			.map(i -> i + "*")
			.forEach(tags::add);

		String initialValue = Text.toCSV(tags);

		chatboxPanelManager.openTextInput(name + " tags:<br>(append " + VAR_TAG_SUFFIX + " for variation tag)")
			.addCharValidator(FILTERED_CHARS::test)
			.value(initialValue)
			.onDone(newValue -> {
				clientThread.invoke(() ->
				{
					// Split inputted tags to vartags (ending with *) and regular tags
					final Collection<String> newTags = new ArrayList<>(Text.fromCSV(newValue.toLowerCase()));
					final Collection<String> newVarTags = new ArrayList<>(newTags).stream().filter(s -> s.endsWith(VAR_TAG_SUFFIX)).map(s ->
					{
						newTags.remove(s);
						return s.substring(0, s.length() - VAR_TAG_SUFFIX.length());
					}).collect(Collectors.toList());

					// And save them
					tagManager.setTagString(itemId, Text.toCSV(newTags), false);
					tagManager.setTagString(itemId, Text.toCSV(newVarTags), true);

					// Check both previous and current tags in case the tag got removed in new tags or in case
					// the tag got added in new tags
					tabInterface.updateTabIfActive(Text.fromCSV(initialValue.toLowerCase().replaceAll(Pattern.quote(VAR_TAG_SUFFIX), "")));
					tabInterface.updateTabIfActive(Text.fromCSV(newValue.toLowerCase().replaceAll(Pattern.quote(VAR_TAG_SUFFIX), "")));
				});
			})
			.build();
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		tabInterface.handleClick(event);
	}

	@Override
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(CONFIG_GROUP) && configChanged.getKey().equals("useTabs"))
		{
			if (config.tabs())
			{
				clientThread.invokeLater(tabInterface::init);
			}
			else
			{
				clientThread.invokeLater(tabInterface::destroy);
			}
		}
	}

	@Override
	public void onScriptPreFired(ScriptPreFired event)
	{
		int scriptId = event.getScriptId();
		if (scriptId == ScriptID.BANKMAIN_FINISHBUILDING)
		{
			// Since we apply tag tab search filters even when the bank is not in search mode,
			// bankkmain_build will reset the bank title to "The Bank of Gielinor". So apply our
			// own title.
			TagTab activeTab = tabInterface.getActiveTab();
			if (tabInterface.isTagTabActive())
			{
				// Tag tab tab has its own title since it isn't a real tag
				Widget bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
				bankTitle.setText("Tag tab tab");
			}
			else if (activeTab != null)
			{
				Widget bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
				bankTitle.setText("Tag tab <col=ff0000>" + activeTab.getTag() + "</col>");
			}

			// Recompute scroll size. Only required for tag tab tab and with remove separators, to remove the
			// space that the separators took.
			if (tabInterface.isTagTabActive() || (tabInterface.isActive() && config.removeSeparators()))
			{
				Widget itemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
				Widget[] children = itemContainer.getChildren();
				int items = 0;
				for (Widget child : children)
				{
					if (child != null && child.getItemId() != -1 && !child.isHidden())
					{
						++items;
					}
				}

				// New scroll height for if_setscrollsize
				final int adjustedScrollHeight = (Math.max(0, items - 1) / ITEMS_PER_ROW) * ITEM_VERTICAL_SPACING +
					ITEM_VERTICAL_SPACING + ITEM_CONTAINER_BOTTOM_PADDING;

				// This is prior to bankmain_finishbuilding running, so the arguments are still on the stack. Overwrite
				// argument int12 (7 from the end) which is the height passed to if_setscrollsize
				final int[] intStack = client.getIntStack();
				final int intStackSize = client.getIntStackSize();
				intStack[intStackSize - 7] = adjustedScrollHeight;
			}
		}
		else if (scriptId == ScriptID.BANKMAIN_SEARCH_TOGGLE)
		{
			tabInterface.handleSearch();
		}
	}

	@Override
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.BANKMAIN_SEARCHING)
		{
			// The return value of bankmain_searching is on the stack. If we have a tag tab active
			// and are in the bank, make it return true to put the bank in a searching state.
			boolean bankOpen = client.getItemContainer(InventoryID.BANK) != null;
			if (bankOpen && (tabInterface.getActiveTab() != null || tabInterface.isTagTabActive()))
			{
				client.getIntStack()[client.getIntStackSize() - 1] = 1; // true
			}
			return;
		}

		if (event.getScriptId() != ScriptID.BANKMAIN_BUILD)
		{
			return;
		}

		Widget itemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		if (itemContainer == null)
		{
			return;
		}

		if (!tabInterface.isActive() || !config.removeSeparators())
		{
			return;
		}

		int items = 0;

		Widget[] containerChildren = itemContainer.getDynamicChildren();

		// sort the child array as the items are not in the displayed order
		Arrays.sort(containerChildren, Comparator.comparingInt(Widget::getOriginalY)
			.thenComparingInt(Widget::getOriginalX));

		for (Widget child : containerChildren)
		{
			if (child.getItemId() != -1 && !child.isHidden())
			{
				// calculate correct item position as if this was a normal tab
				int adjYOffset = (items / ITEMS_PER_ROW) * ITEM_VERTICAL_SPACING;
				int adjXOffset = (items % ITEMS_PER_ROW) * ITEM_HORIZONTAL_SPACING + ITEM_ROW_START;

				if (child.getOriginalY() != adjYOffset || child.getOriginalX() != adjXOffset)
				{
					child.setOriginalY(adjYOffset);
					child.setOriginalX(adjXOffset);
					child.revalidate();
				}

				items++;
			}

			// separator line or tab text
			if (child.getSpriteId() == SpriteID.RESIZEABLE_MODE_SIDE_PANEL_BACKGROUND
				|| child.getText().contains("Tab"))
			{
				child.setHidden(true);
			}
		}
	}

	@Override
	public void onGameTick(GameTick event)
	{
		tabInterface.update();
	}

	@Override
	public void onDraggingWidgetChanged(DraggingWidgetChanged event)
	{
		final boolean shiftPressed = client.isKeyPressed(KeyCode.KC_SHIFT);
		tabInterface.handleDrag(event.getDraggingWidget(), shiftPressed);
	}

	@Override
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			tabInterface.init();
		}
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		tabInterface.handleWheel(event);
		return event;
	}
}
