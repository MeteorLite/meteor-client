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

import net.runelite.api.InventoryItem;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.mixins.*;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSItem;

import java.util.ArrayList;
import java.util.HashMap;

import eventbus.events.ExperienceGained;
import eventbus.events.GameStateChanged;
import rscplus.ItemNamePatchLevel;

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient {

	@Shadow("mudClient")
	public static RSClient client;

	@Inject
	@javax.inject.Inject
	private Callbacks callbacks;

	@Inject
	@Override
	public void setCallbacks(Callbacks callbacks) {
		this.callbacks = callbacks;
	}

	@Inject
	@Override
	public Callbacks getCallbacks() {
		return callbacks;
	}

	@Inject
	HashMap<Skill, Integer> lastXPs = new HashMap<>();

	@Inject
	@Override
	public boolean isLoggedIn() {
		return getGameState() == getGameState().GAME();
	}


	@Inject
	@FieldHook("gameState1")
	public void onLoggedInChanged(int idx) {
		if (!isLoggedIn())
			lastXPs = null;
		client.getCallbacks().post(new GameStateChanged(getGameState()));
	}

	@Inject
	@FieldHook("skillXPs")
	public void onSkillXPChanged(int idx) {
		if (lastXPs == null)
			lastXPs = new HashMap<>();

		for (Skill skillChanged : Skill.values()) {
			if (skillChanged == Skill.OVERALL)
				continue;
			int newXP = getSkillXPs()[skillChanged.ordinal()];

			if (lastXPs.get(skillChanged) != null) {
				int lastXP = lastXPs.get(skillChanged);

				//Only post if it skill already initialized after login
				if (lastXP != 0 && lastXP != -1 && lastXP != newXP) {
					client.getCallbacks().post(new ExperienceGained(skillChanged));
				}
			}

			lastXPs.put(skillChanged, newXP);
		}
	}

	@Inject
	private ItemNamePatchLevel itemPatchLevel = ItemNamePatchLevel.DISABLED;

	@Inject
	@Override
	public  void setItemPatchLevel(ItemNamePatchLevel itemPatchLevel) {
		this.itemPatchLevel = itemPatchLevel;
	}

	@Inject
	@Override
	public ItemNamePatchLevel getItemPatchLevel() {
		return itemPatchLevel;
	}

	@Shadow("pixels")
	public static int[] pixels;

	@Inject
	@MethodHook("drawUi")
	public void drawUi$head(int var1){
/*		if (client.isHitsplatsAboveScene())
			drawHitsplats();*/
		client.getCallbacks().drawScene(pixels);
	}

	@Inject
	@MethodHook(value = "drawUi", end = true)
	public void drawUi$tail(int var1){
		client.getCallbacks().drawOnTop(pixels);
	}

/*	@Shadow("itemNames")
	public static String[] itemNames;

	@Inject
	@MethodHook(value = "loadData", end = true)
	void loadData$tail(){
		ItemNamePatch.init(itemNames);
	}

	@Inject
	@Override
	public String[] getItemNames() {
		return itemNames;
	}

	@Inject
	@Override
	public void setItemNames(String[] itemNames) {
		this.itemNames = itemNames;
	}*/

	@Inject
	@Override
	public int getRealLevel(Skill skill) {
		return client.getRealSkillLevels()[skill.ordinal()];
	}

	@Inject
	@Override
	public int getBoostedLevel(Skill skill) {
		return client.getBoostedSkillLevels()[skill.ordinal()];
	}

	@Inject
	@Override
	public int getNextLevelXP(Skill skill) {
		int nextLevelXP = getLevelXPs$api()[0];
		for(int level = 0; level < 98; level++)
			if(getXP(skill) >= getLevelXPs$api()[level])
				nextLevelXP = getLevelXPs$api()[level + 1];
		return nextLevelXP;
	}

	@Inject
	@Override
	public int getFatiguePercentage() {
		return getFatigue();
	}

	@Inject
	@Override
	public int getCurrentLevelXP(Skill skill) {
		int nextLevelXP = getLevelXPs$api()[0];
		for(int level = 0; level < 98; level++)
			if(getXP(skill) >= getLevelXPs$api()[level])
				nextLevelXP = getLevelXPs$api()[level];
		return nextLevelXP;
	}

	@Inject
	@Override
	public int getXPUntilLevel(Skill skill) {
		int nextLevelXP = getNextLevelXP(skill);
		return nextLevelXP - getXP(skill);
	}

	@Inject
	@Override
	public int getXP(Skill skill) {
		return getSkillXPs()[skill.ordinal()];
	}

	@Inject
	@Override
	public boolean showingInventory() {
		return getShowUITab() == 1;
	}

	@Inject
	public ArrayList<Item> inventoryItems = new ArrayList<>();

	@Inject
	@Override
	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	@Inject
	@Override
	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@Inject
	public int lastUITab = -1;

	@Inject
	@FieldHook("showUiTab")
	public void onShowUiTabChanged(int idx) {
		boolean keptInventory = false;
		if (getShowUITab() != 1) {
			if (lastUITab == 1) {
				//prevent inventory from closing when "Use"ing an item
				//this behavior exists on mobile preservation
				if (getSelectedItemSlot() != -1) {
					setShowUITab(1);
					keptInventory = true;
				}
			}
		}
		if (!keptInventory)
			lastUITab = getShowUITab();
	}

	//force close inventory after an item on item menu selection
	//this behavior exists on mobile preservation
	@Inject
	@MethodHook(value = "chooseOption", end = true)
	void chooseOption$tail(int optionIdx){
		setShowUITab(0);
	}
}
