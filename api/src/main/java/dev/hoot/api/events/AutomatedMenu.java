package dev.hoot.api.events;

import eventbus.events.MenuOptionClicked;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;

import java.util.HashMap;
import java.util.function.Consumer;

@Getter
@Setter
public class AutomatedMenu
{
	private String option;
	private String target;
	public int identifier;
	private MenuAction opcode;
	public int param0;
	public int param1;
	private int clickX;
	private int clickY;
	private long entityTag;
	private int itemId = -1;
	@Setter
	private long timestamp;

	public AutomatedMenu(int identifier, int opcode, int param0, int param1)
	{
		this(identifier, MenuAction.of(opcode), param0, param1);
	}

	public AutomatedMenu(int identifier, MenuAction opcode, int param0, int param1)
	{
		this(identifier, opcode, param0, param1, -1337);
	}

	public AutomatedMenu(int identifier, int opcode, int param0, int param1, long entityTag)
	{
		this(identifier, MenuAction.of(opcode), param0, param1, entityTag);
	}

	public AutomatedMenu(int identifier, MenuAction opcode, int param0, int param1, long entityTag)
	{
		this(identifier, opcode, param0, param1, -1, -1, entityTag);
	}

	public AutomatedMenu(int identifier, int opcode, int param0, int param1, int clickX, int clickY)
	{
		this(identifier, opcode, param0, param1, clickX, clickY, -1337);
	}

	public AutomatedMenu(int identifier, int opcode, int param0, int param1, int clickX, int clickY, long entityTag)
	{
		this(identifier, MenuAction.of(opcode), param0, param1, clickX, clickY, entityTag);
	}

	public AutomatedMenu(int identifier, MenuAction opcode, int param0, int param1, int clickX, int clickY, long entityTag)
	{
		this("Automated", "", identifier, opcode, param0, param1, clickX, clickY, entityTag);
	}

	public AutomatedMenu(String option, String target, int identifier, MenuAction opcode, int param0, int param1,
			int clickX, int clickY, long entityTag)
	{
		this.option = option;
		this.target = target;
		this.identifier = identifier;
		this.opcode = opcode;
		this.param0 = param0;
		this.param1 = param1;
		this.clickX = clickX;
		this.clickY = clickY;
		this.entityTag = entityTag;
		this.timestamp = System.currentTimeMillis();
	}

	public MenuEntry toEntry(Client client, int idx)
	{
		return toEntry(client, idx, null);
	}

	public MenuEntry toEntry(Client client, int idx, Consumer<MenuEntry> consumer)
	{
		return toEntry(client, idx, option, target, consumer);
	}

	public MenuEntry toEntry(Client client, int idx, String option, String target)
	{
		return toEntry(client, idx, option, target, null);
	}

	public static HashMap<MenuEntry, Consumer<MenuEntry>> onClicks = new HashMap<>();

	public MenuEntry toEntry(Client client, int idx, String option, String target, Consumer<MenuEntry> consumer)
	{
		MenuEntry menuEntry = client.createMenuEntry(idx)
				.setOption(option)
				.setTarget(target)
				.setIdentifier(identifier)
				.setType(opcode)
				.setParam0(param0)
				.setParam1(param1);
		if (consumer != null) {
			onClicks.put(menuEntry, consumer);
		}
		return menuEntry;
	}

	public MenuEntry toEntry(Client client)
	{
		return toEntry(client, null);
	}

	public MenuEntry toEntry(Client client, Consumer<MenuEntry> consumer)
	{
		return toEntry(client, option, target, consumer);
	}

	public MenuEntry toEntry(Client client, String option, String target)
	{
		return toEntry(client, option, target, null);
	}

	public MenuEntry toEntry(Client client, String option, String target, Consumer<MenuEntry> consumer)
	{
		return toEntry(client, -1, option, target, consumer);
	}

	public MenuEntry toBareEntry(Client client)
	{
		return client.createMenuEntry(
				option,
				target,
				identifier,
				opcode.getId(),
				param0,
				param1,
				false
		);
	}
}