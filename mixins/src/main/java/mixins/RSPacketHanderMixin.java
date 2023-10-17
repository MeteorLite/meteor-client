/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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
package mixins;


import net.runelite.api.Item;
import net.runelite.api.SpriteID;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSCharacter;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSItem;
import net.runelite.rs.api.RSPacketHandler;

import org.rationalityfrontline.kevent.KEventKt;

import java.util.ArrayList;

import eventbus.events.InventoryUpdated;


@Mixin(RSPacketHandler.class)
public abstract class RSPacketHanderMixin implements RSPacketHandler {

	@Shadow("mudClient")
	public static RSClient client;

	@Inject
	@MethodHook(value = "updateInventory", end = true)
	private void onUpdateInventory$tail(){
		refreshItems();
	}

	@Inject
	@MethodHook(value = "updateInventoryItem", end = true)
	private void updateInventoryItem$tail(){
		refreshItems();
	}

	@Inject
	@MethodHook(value = "removeItem", end = true)
	private void removeItem$tail(){
		refreshItems();
	}

	@Inject
	public void refreshItems() {
		ArrayList<Item> items = new ArrayList<>();
		for (RSItem item : client.getInventory()) {
			if (item != null && item.getItemDef() != null)
				items.add(item);
		}
		client.setInventoryItems(items);
		KEventKt.getKEVENT().post(new InventoryUpdated(items));
	}
}
