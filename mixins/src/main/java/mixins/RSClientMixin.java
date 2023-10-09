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

import eventbus.events.ClientTick;
import eventbus.events.ExperienceGained;
import net.runelite.api.InventoryItem;
import net.runelite.api.Skill;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.mixins.*;
import net.runelite.rs.api.RSClient;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

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
	@FieldHook("isMembers")
	public void onIsMembersChanged(int idx) {
		setIsMembers(true);
	}

	@Inject
	@MethodHook("<init>")
	public void onInit() {
		setInjected(true);
	}

	@Inject
	public ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();

	@Inject
	@Override
	public ArrayList<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	@Inject
	@Override
	public void setInventoryItems(ArrayList<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@Inject
	Canvas canvas = null;

	@Inject
	@Override
	public Canvas getCanvas() {
		return canvas;
	}

	@Inject
	@Override
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	@Inject
	JPanel gamePanel = null;

	@Inject
	@Override
	public JPanel getGamePanel() {
		return gamePanel;
	}

	@Inject
	@Override
	public void setGamePanel(JPanel canvas) {
		this.gamePanel = gamePanel;
	}

	@Inject
	public boolean isResized = false;

	@Inject
	@Override
	public boolean isResized() {
		return isResized;
	}

	@Inject
	@Override
	public void setResized(boolean resized) {
		this.isResized = resized;
	}

	@Inject
	boolean isResizeCanvasNextFrame = false;

	@Inject
	@Override
	public boolean isResizeCanvasNextFrame() {
		return isResizeCanvasNextFrame;
	}

	@Inject
	@Override
	public void setResizeCanvasNextFrame(boolean resizeCanvasNextFrame) {
		this.isResizeCanvasNextFrame = resizeCanvasNextFrame;
	}

	@Inject
	@Override
	public void setMaxCanvasHeight(int maxHeight) {
		int maxWidth = getCanvas().getMaximumSize().width;
		getCanvas().setMaximumSize(new Dimension(maxWidth, maxHeight));
	}

	@Inject
	@Override
	public void setMaxCanvasWidth(int maxWidth) {
		int maxHeight = getCanvas().getMaximumSize().height;
		getCanvas().setMaximumSize(new Dimension(maxWidth, maxHeight));
	}

	@Inject
	@Override
	public boolean isLoggedIn() {
		return getRSCLoggedIn() == 1;
	}

	@Inject
	private Thread thread;

	@Inject
	@Override
	public boolean isClientThread()
	{
		return thread == Thread.currentThread();
	}

	@Inject
	@FieldHook(value = "cycle")
	void onCycle(int idx) {
		client.getCallbacks().post(ClientTick.INSTANCE);
	}

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
	public int getFatiguePercentage() {
		return (getFatigue() * 100) / 750;
	}

	@Inject
	@Override
	public int getNextLevelXP(Skill skill) {
		int nextLevelXP = getLevelXPs()[0];
		for(int level = 0; level < 98; level++)
			if(getXP(skill) >= getLevelXPs()[level])
				nextLevelXP = getLevelXPs()[level + 1];
		return nextLevelXP;
	}

	@Inject
	@Override
	public int getCurrentLevelXP(Skill skill) {
		int nextLevelXP = getLevelXPs()[0];
		for(int level = 0; level < 98; level++)
			if(getXP(skill) >= getLevelXPs()[level])
				nextLevelXP = getLevelXPs()[level];
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

	@Shadow("pixels")
	public static int[] pixels;

	@Inject
	@MethodHook("drawUI")
	public void beforeDrawUI(){
		client.getCallbacks().drawScene(pixels);
	}

	@Inject
	public int lastUITab = -1;

	@Inject
	@Override
	public boolean showingInventory() {
		return getShowUITab() == 1;
	}

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

	@Inject
	HashMap<Skill, Integer> lastXPs = new HashMap<>();

	@Inject
	@FieldHook("loggedIn")
	public void onLoggedInChanged(int idx) {
		if (!isLoggedIn())
			lastXPs = null;
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
	public int lastCombatStyle = 0;

	@Inject
	public File meteorDir;

	@Inject
	public File lastCombatStyleFile;

	@Inject
	@FieldHook("combatStyle")
	public void onCombatStyleChanged(int idx) {
		if (isLoggedIn()) {
			try {
				Files.writeString(lastCombatStyleFile.toPath(), String.valueOf(getCombatStyle()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Replace(value = "getDefaultCombatStyle")
	public int getDefaultCombatStyle(){
		int combatStyle = 0;

		//TODO: This should be initialized in a better place
		if (meteorDir == null)
			meteorDir = new File(System.getProperty("user.home"), ".meteor-rsc");
		if (lastCombatStyleFile == null)
			lastCombatStyleFile = new File(meteorDir, "lastCombatStyle.txt");

		if (!lastCombatStyleFile.exists()) {
			try {
				Files.writeString(lastCombatStyleFile.toPath(), String.valueOf(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			combatStyle = Integer.parseInt(Files.readString(lastCombatStyleFile.toPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return combatStyle;
	}
}
