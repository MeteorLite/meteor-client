package net.runelite.client.plugins.externals.oneclick.clickables.skilling;

import eventbus.events.MenuEntryAdded;
import eventbus.events.MenuOptionClicked;
import lombok.extern.slf4j.Slf4j;
import meteor.Main;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable;
import net.runelite.client.plugins.externals.oneclick.pojos.ItemData;

@Slf4j
public class HighAlch extends Clickable
{
	@Override
	public boolean isValidEntry(MenuEntryAdded event)
	{
		if (!event.getOption().equals("Cast") ||
			!event.getTarget().contains("High Level Alchemy") ||
			event.getForceLeftClick() ||
			event.getOpcode() != MenuAction.WIDGET_TARGET.getId())
		{
			return false;
		}
		ItemData item = findItemWithIds(plugin.getHighAlchs());
		if (item == null)
		{
			return false;
		}
		MenuEntry menuEntry = client.createMenuEntry(client.getMenuOptionCount())
			.setOption("Cast")
			.setTarget("<col=00ff00>High Level Alchemy</col><col=ffffff> -> <col=ff9040>" + item.getName() + "</col>")
			.setType(MenuAction.WIDGET_TARGET_ON_WIDGET)
			.setIdentifier(0)
			.setParam0(item.getIndex())
			.setParam1(9764864)
			.setForceLeftClick(true);
		Main.INSTANCE.getOnClicks().put(menuEntry, me -> {
					refreshInventory();
					setSelectSpell(WidgetInfo.SPELL_HIGH_LEVEL_ALCHEMY);
				});
		return true;
	}

	@Override
	public boolean isValidClick(MenuOptionClicked event)
	{
		return false;
	}
}
