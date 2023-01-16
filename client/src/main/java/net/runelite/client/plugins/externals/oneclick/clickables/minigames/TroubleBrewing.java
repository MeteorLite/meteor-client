package net.runelite.client.plugins.externals.oneclick.clickables.minigames;

import eventbus.events.MenuEntryAdded;
import eventbus.events.MenuOptionClicked;
import net.runelite.api.MenuAction;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;

public class TroubleBrewing extends Clickable
{
	@Override
	public boolean isValidEntry(MenuEntryAdded event)
	{
		if (event.getOpcode() != MenuAction.EXAMINE_OBJECT.getId() || event.getForceLeftClick() ||
			!event.getTarget().toLowerCase().contains("hopper") || findItem(1929) == null)
		{
			return false;
		}
		client.createMenuEntry(client.getMenuOptionCount())
			.setOption("Use")
			.setTarget("<col=ff9040>Water Bucket<col=ffffff> -> " + event.getTarget())
			.setType(MenuAction.WIDGET_TARGET_ON_GAME_OBJECT)
			.setIdentifier(event.getIdentifier())
			.setParam0(event.getParam0())
			.setParam1(event.getParam1())
			.setForceLeftClick(true);
		return true;
	}

	@Override
	public boolean isValidClick(MenuOptionClicked event)
	{
		return event.getMenuTarget().contains("<col=ff9040>Water Bucket<col=ffffff> -> ") && updateSelectedItem(1929);
	}
}
