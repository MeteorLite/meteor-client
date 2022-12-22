package dev.hoot.api;

import dev.hoot.api.events.AutomatedMenu;
import net.runelite.api.util.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Interactable
{
	Point getClickPoint();

	String[] getRawActions();

	int getActionOpcode(int action);

	default List<String> getActions()
	{
		if (getRawActions() == null)
		{
			return null;
		}

		return Arrays.stream(getRawActions()).map(Text::removeTags).collect(Collectors.toList());
	}

	default void interact(Predicate<String> predicate)
	{
		String[] raw = getRawActions();
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
		for (String s : getRawActions())
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
		String[] raw = getRawActions();
		if (raw == null)
		{
			return false;
		}

		if (actions.length == 0)
		{
			return Arrays.stream(raw).anyMatch(Objects::nonNull);
		}

		return Arrays.stream(actions).anyMatch(x -> getActions().contains(x));
	}

	default AutomatedMenu getMenu(String action)
	{
		return getMenu(getActions().indexOf(action));
	}

	AutomatedMenu getMenu(int actionIndex);

	AutomatedMenu getMenu(int actionIndex, int opcode);

	default AutomatedMenu getMenu(int identifier, int opcode, int param0, int param1)
	{
		if (this instanceof SceneEntity)
		{
			return new AutomatedMenu(identifier, opcode, param0, param1, -1, -1,
					((SceneEntity) this).getTag());
		}
		else
		{
			return new AutomatedMenu(identifier, opcode, param0, param1, -1, -1);
		}
	}
}
