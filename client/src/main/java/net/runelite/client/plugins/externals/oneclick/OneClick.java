package net.runelite.client.plugins.externals.oneclick;

import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import eventbus.events.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import net.runelite.api.*;

import static net.runelite.api.MenuAction.CC_OP_LOW_PRIORITY;

import net.runelite.api.events.MenuOpened;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;
import net.runelite.client.plugins.externals.oneclick.clickables.minigames.Healers;
import net.runelite.client.plugins.externals.oneclick.config.Combat;
import net.runelite.client.plugins.externals.oneclick.config.Custom;
import net.runelite.client.plugins.externals.oneclick.config.Minigame;
import net.runelite.client.plugins.externals.oneclick.config.Skilling;
import net.runelite.client.plugins.externals.oneclick.pojos.CustomItem;
import net.runelite.client.plugins.externals.oneclick.pojos.ItemData;
@PluginDescriptor(
	name = "One Click",
	description = "OP One Click methods.",
	tags = "ganom"
)
public class OneClick extends Plugin
{
	private static final String MAGIC_IMBUE_EXPIRED_MESSAGE = "Your Magic Imbue charge has ended.";
	private static final String MAGIC_IMBUE_MESSAGE = "You are charged to combine runes!";
	private static final int BA_CALL_LISTEN = 7;
	private static final int BA_HEALER_GROUP_ID = 488;

	private Client client = Main.client;
	private ClientThread clientThread = ClientThread.INSTANCE;
	public OneClickConfig config = configuration(OneClickConfig.class);

	@Getter
	private final List<ItemData> inventory = new ArrayList<>();
	@Getter
	private final List<CustomItem> items = new ArrayList<>();
	private final List<Clickable> clickable = new ArrayList<>();
	@Getter
	private final Set<Integer> highAlchs = new HashSet<>();
	@Setter
	private boolean tick;
	@Getter
	private String roleText = "";
	@Getter
	private boolean imbued;
	@Getter
	private int highAlchTicks;

	@Override
	public void onStart()
	{
		updateConfig();
	}

	@Override
	public void onStop()
	{
		clickable.clear();
		imbued = false;
	}

	@Override
	public void onGameTick(GameTick event)
	{
		if (highAlchTicks > 0)
		{
			highAlchTicks--;
		}
		if (tick)
		{
			tick = false;
		}

		updateBarbarianAssaultRoleCallText();
	}

	@Override
	public void onChatMessage(ChatMessage event)
	{
		switch (event.getMessage())
		{
			case MAGIC_IMBUE_MESSAGE:
				imbued = true;
				break;
			case MAGIC_IMBUE_EXPIRED_MESSAGE:
				imbued = false;
				break;
		}
	}

	@Override
	public void onXPDrop(XPDrop event)
	{
		if (event.getExp() != 65 || event.getSkill() != Skill.MAGIC)
		{
			return;
		}
		highAlchTicks = 4;
	}

	@Override
	public void onMenuOpened(MenuOpened event)
	{
		if (!Set.of(Skilling.values()).contains(Skilling.HIGH_ALCH) || !client.isKeyPressed(KeyCode.KC_SHIFT))
		{
			return;
		}

		boolean hasExamineItemEntry = Arrays.stream(event.getMenuEntries())
			.filter(e -> !e.isForceLeftClick())
			.filter(e -> e.getOption().equals("Examine"))
			.anyMatch(e -> e.getType() == CC_OP_LOW_PRIORITY);

		if (!hasExamineItemEntry)
		{
			return;
		}

		var item = inventory.stream()
			.filter(itemData -> itemData.getIndex() == event.getFirstEntry().getParam0())
			.findFirst()
			.orElse(null);

		if (item == null)
		{
			return;
		}

		if (highAlchs.contains(item.getId()))
		{
			MenuEntry menuEntry = client.createMenuEntry(client.getMenuOptionCount())
				.setOption("Remove")
				.setTarget("<col=ff0000>Alch Target</col><col=ffffff> -> <col=ff9040>" + item.getName() + "</col>")
				.setType(MenuAction.RUNELITE_HIGH_PRIORITY);
			Main.INSTANCE.getOnClicks().put(menuEntry, e ->
					highAlchs.remove(item.getId()));
			return;
		}

		MenuEntry menuEntry = client.createMenuEntry(client.getMenuOptionCount())
			.setOption("Select")
			.setTarget("<col=00ff00>Alch Target</col><col=ffffff> -> <col=ff9040>" + item.getName() + "</col>")
			.setType(MenuAction.RUNELITE_HIGH_PRIORITY);
		Main.INSTANCE.getOnClicks().put(menuEntry, e ->
				highAlchs.add(item.getId()));
	}

	@Override
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		for (Clickable method : clickable)
		{
			if (method.isValidEntry(event))
			{
				//Don't allow more than 2 methods to modify same event.
				break;
			}
		}
	}

	@Override
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (tick)
		{
			event.consume();
			return;
		}

		for (Clickable method : clickable)
		{
			if (method.isValidClick(event))
			{
				//Don't allow more than 2 methods to modify same event.
				break;
			}
		}
	}

	@Override
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId() || event.getItemContainer() == null)
		{
			return;
		}

		inventory.clear();

		var containerItems = event.getItemContainer().getItems();

		for (int index = 0; index < containerItems.length; index++)
		{
			var item = containerItems[index];

			if (item.getId() == -1 || item.getId() == 6512 || item.getQuantity() < 1)
			{
				continue;
			}

			var def = client.getItemComposition(item.getId());
			inventory.add(new ItemData(item.getId(), item.getQuantity(), index, def.getName(), def));
		}
	}

	@Override
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("oneclick"))
		{
			return;
		}
		updateConfig();
	}

	private void updateConfig()
	{
		clickable.clear();
		clientThread.invoke(() ->
		{
			convertStringToCustomItemMap();
			clickable.addAll(Combat.Companion.createInstances(Combat.values()));
			clickable.addAll(Custom.Companion.createInstances(Custom.values()));
			clickable.addAll(Minigame.Companion.createInstances(Minigame.values()));
			clickable.addAll(Skilling.Companion.createInstances(Skilling.values()));
		});
	}

	private void updateBarbarianAssaultRoleCallText()
	{
		if (clickable.stream().noneMatch(c -> c instanceof Healers))
		{
			return;
		}

		Widget widget = client.getWidget(BA_HEALER_GROUP_ID, BA_CALL_LISTEN);

		if (widget == null || widget.getText() == null)
		{
			roleText = "";
			return;
		}

		roleText = widget.getText().trim();
	}

	@SuppressWarnings("UnstableApiUsage")
	private void convertStringToCustomItemMap()
	{
		items.clear();
		Splitter.on("\n")
			.omitEmptyStrings()
			.trimResults()
			.splitToStream(config.getCustomIds())
			.map((string) -> CustomItem.from(client, string))
			.filter(Objects::nonNull)
			.forEach(items::add);
	}
}
