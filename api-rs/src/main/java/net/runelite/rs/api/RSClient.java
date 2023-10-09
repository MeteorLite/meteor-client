/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.rs.api;

import net.runelite.api.*;
import net.runelite.mapping.Import;

import java.awt.*;

public interface RSClient extends Client
{
	//inits the applet for us
	@Import("main")
	void main$api();

	@Import("injected")
	boolean isInjected();

	@Import("injected")
	void setInjected(boolean isInjected);

	@Import("isMembers")
	void setIsMembers(boolean isMembers);

	@Import("inventorySize")
	int getInventorySize();

	@Import("inventoryItemsIDs")
	int[] getInventoryItemsIDs();

	@Import("inventoryItemsEquipped")
	int[] getInventoryItemsEquipped();

	@Import("inventoryItemsStackable")
	int[] getInventoryItemsStackable();

	@Import("inventoryItemsQuantities")
	int[] getInventoryItemsQuantities();

	@Import("loggedIn")
	int getRSCLoggedIn();

	@Import("fogOfWar")
	void setFogOfWar(boolean fogOfWar);

	@Import("localPlayer")
	@Override
	RSCharacter getLocalPlayer();

	@Import("skillNamesShort")
	String[] getSkillNamesShort();

	@Import("boostedSkillLevels")
	int[] getBoostedSkillLevels();

	@Import("realSkillLevels")
	int[] getRealSkillLevels();

	@Import("statFatigue")
	int getFatigue();

	@Import("levelXPs")
	int[] getLevelXPs();

	@Import("skillXPs")
	int[] getSkillXPs();

	@Import("graphics")
	Graphics getGraphics$api();

	@Import("surface")
	RSSpriteSurface getSurface();

	@Import("showUiTab")
	int getShowUITab();

	@Import("showUiTab")
	void setShowUITab(int tab);

	@Import("optionMenuCount")
	int getMenuOptionsSize();

	@Import("chooseOption")
	void chooseOption$api(int optionIdx);

	@Import("selectedItemSlot")
	int getSelectedItemSlot();
}
