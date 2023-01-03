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
package net.runelite.rs.api;

import net.runelite.api.Model;
import net.runelite.api.MoveSpeed;
import net.runelite.api.Player;
import net.runelite.mapping.Import;

public interface RSPlayer extends RSActor, Player
{
	@Import("username")
	RSUsername getRsName();

	@Import("index")
	int getPlayerId();

	@Import("appearance")
	@Override
	RSPlayerComposition getPlayerComposition();

	@Import("combatLevel")
	@Override
	int getCombatLevel();

	@Import("skillLevel")
	int getTotalLevel();

	@Import("team")
	@Override
	int getTeam();

	@Import("isFriendsChatMember")
	@Override
	boolean isFriendsChatMember$api();

	@Import("isClanMember")
	@Override
	boolean isClanMember$api();

	@Import("isFriend")
	@Override
	boolean isFriend$api();

	boolean isFriended();

	@Import("headIconPrayer")
	int getRsOverheadIcon();

	@Import("headIconPk")
	int getRsSkullIcon();

	@Import("skillLevel")
	int getRSSkillLevel();

/*	@Import("actions")
	String[] getRawActions();*/


	// Kris changes

	@Import("hidden")
	@Override
	boolean isHidden();
	@Import("minX")
	int minX();
	@Import("maxX")
	int maxX();
	@Import("minY")
	int minY();
	@Import("maxY")
	int maxY();
	@Import("animationCycleStart")
	int animationCycleStart();
	@Import("animationCycleEnd")
	int animationCycleEnd();
	@Import("attachedModel")
	Model getAttachedModel();
	@Import("move")
	@Override
	void move(int x, int y, MoveSpeed type);
	@Import("resetPath")
	@Override
	void stopMovement(int x, int y);
	@Import("plane")
	@Override
	int getPlane();
}
