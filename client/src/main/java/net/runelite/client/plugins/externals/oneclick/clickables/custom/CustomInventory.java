package net.runelite.client.plugins.externals.oneclick.clickables.custom;

import eventbus.events.MenuEntryAdded;
import eventbus.events.MenuOptionClicked;
import net.runelite.api.MenuAction;
import net.runelite.api.util.Text;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;
import net.runelite.client.plugins.externals.oneclick.pojos.CustomItem;

public class CustomInventory extends Clickable
{
	private CustomItem currentItemTarget = null;

	@Override
	public boolean isValidEntry(MenuEntryAdded event)
	{
		if (event.getOpcode() != MenuAction.WIDGET_TARGET.getId() || !isValid(event.getTarget()))
		{
			return false;
		}
		client.createMenuEntry(client.getMenuOptionCount())
			.setOption(event.getOption())
			.setTarget(currentItemTarget.getTargetString())
			.setIdentifier(0)
			.setType(MenuAction.WIDGET_TARGET_ON_WIDGET)
			.setParam0(event.getParam0())
			.setParam1(event.getParam1())
			.setForceLeftClick(true);
		return true;
	}

	@Override
	public boolean isValidClick(MenuOptionClicked event)
	{
		if (currentItemTarget == null || !event.getMenuTarget().equals(currentItemTarget.getTargetString()))
		{
			return false;
		}
		return updateSelectedItem(currentItemTarget.getOnThisId());
	}

	private boolean isValid(String target)
	{
		currentItemTarget = plugin.getItems()
			.stream()
			.filter(item -> item.getUseThisName().equalsIgnoreCase(Text.removeTags(target)))
			.filter(item -> findItem(item.getUseThisId()) != null && findItem(item.getOnThisId()) != null)
			.findFirst()
			.orElse(null);
		return currentItemTarget != null;
	}
}