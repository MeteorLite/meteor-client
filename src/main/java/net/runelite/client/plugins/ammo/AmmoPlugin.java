/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.ammo;

import java.awt.image.BufferedImage;

import eventbus.events.ItemContainerChanged;
import meteor.game.ItemManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.infobox.InfoBoxManager;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;

@PluginDescriptor(
	name = "Ammo",
	description = "Shows the current ammo the player has equipped",
	tags = {"bolts", "darts", "chinchompa", "equipment"}
)
public class AmmoPlugin extends Plugin
{
	private ClientThread clientThread = ClientThread.INSTANCE;
	private InfoBoxManager infoBoxManager = InfoBoxManager.INSTANCE;
	private ItemManager itemManager = ItemManager.INSTANCE;

	private AmmoCounter counterBox;

	@Override
	public void onStart()
	{
		clientThread.invokeLater(() ->
		{
			final ItemContainer container = getClient().getItemContainer(InventoryID.EQUIPMENT);

			if (container != null)
			{
				checkInventory(container.getItems());
			}
		});
	}

	@Override
	public void onStop()
	{
		infoBoxManager.removeInfoBox(counterBox);
		counterBox = null;
	}

	@Override
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != getClient().getItemContainer(InventoryID.EQUIPMENT))
		{
			return;
		}

		checkInventory(event.getItemContainer().getItems());
	}

	private void checkInventory(final Item[] items)
	{
		// Check for weapon slot items. This overrides the ammo slot,
		// as the player will use the thrown weapon (eg. chinchompas, knives, darts)
		if (items.length > EquipmentInventorySlot.WEAPON.getSlotIdx())
		{
			final Item weapon = items[EquipmentInventorySlot.WEAPON.getSlotIdx()];
			final ItemComposition weaponComp = itemManager.getItemComposition(weapon.getId());
			if (weaponComp.isStackable())
			{
				updateInfobox(weapon, weaponComp);
				return;
			}
		}

		if (items.length <= EquipmentInventorySlot.AMMO.getSlotIdx())
		{
			removeInfobox();
			return;
		}

		final Item ammo = items[EquipmentInventorySlot.AMMO.getSlotIdx()];
		final ItemComposition comp = itemManager.getItemComposition(ammo.getId());

		if (!comp.isStackable())
		{
			removeInfobox();
			return;
		}

		updateInfobox(ammo, comp);
	}

	private void updateInfobox(final Item item, final ItemComposition comp)
	{
		if (counterBox != null && counterBox.getItemID() == item.getId())
		{
			counterBox.setCount(item.getQuantity());
			return;
		}

		removeInfobox();
		final BufferedImage image = itemManager.getImage(item.getId(), 5, false);
		counterBox = new AmmoCounter(this, item.getId(), item.getQuantity(), comp.getName(), image);
		infoBoxManager.addInfoBox(counterBox);
	}

	private void removeInfobox()
	{
		infoBoxManager.removeInfoBox(counterBox);
		counterBox = null;
	}
}
