package dev.hoot.api;

import dev.hoot.api.events.MenuAutomated;
import net.runelite.api.MenuAction;
import net.runelite.api.util.Text;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Interactable
{
	net.runelite.api.Point getClickPoint();

	int getActionOpcode(int action);

	String[] getActions();

	default void interact(Predicate<String> predicate)
	{
		String[] raw = getActions();
		if (raw == null)
		{
			return;
		}

		for (int i = 0; i < raw.length; i++)
		{
			if (predicate.test(raw[i]))
			{
				interact(i);
				return;
			}
		}
	}

	default void interact(String action)
	{
		if (getActions() == null)
		{
			return;
		}

		ArrayList<String> actions = new ArrayList<>();
		for (String s : getActions())
		{
			if (s == null)
				s = "null";
			actions.add(s);
		}
		int index = actions.indexOf(action);
		if (index == -1)
		{
			return;
		}

		interact(index);
	}

	void interact(int index);

	void interact(int index, int opcode);

	void interact(int identifier, int opcode, int param0, int param1);

	default boolean hasAction(String... actions)
	{
		String[] raw = getActions();
		if (raw == null)
		{
			return false;
		}

		if (actions.length == 0)
		{
			return Arrays.stream(raw).anyMatch(Objects::nonNull);
		}

		return Arrays.stream(actions).anyMatch(x -> Arrays.stream(getActions()).toList().contains(x));
	}

	MenuAutomated getMenu(int actionIndex);

	MenuAutomated getMenu(int actionIndex, int opcode);

	default int getActionIndex(String action)
	{
		return Collections.singletonList(getActions()).indexOf(action);
	}

	default MenuAutomated getMenu(String action)
	{
		return getMenu(getActionIndex(action));
	}

	default MenuAutomated getMenu(int identifier, int opcode, int param0, int param1)
	{
		return getMenu(identifier, opcode, param0, param1, -1);
	}

	default MenuAutomated getMenu(int identifier, int opcode, int param0, int param1, int itemId)
	{
		MenuAutomated builder = MenuAutomated.Companion.builder()
				.identifier(identifier)
				.opcode(MenuAction.of(opcode))
				.param0(param0)
				.param1(param1)
				.itemId(itemId);

		if (this instanceof SceneEntity)
		{
			builder.entity((SceneEntity) this);
		}
		else
		{
			net.runelite.api.Point clickPoint = getClickPoint();
			builder.clickX(clickPoint.x)
					.clickY(clickPoint.y);
		}

		return builder;
	}
}
