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

import net.runelite.api.Character;
import net.runelite.api.Client;
import net.runelite.mapping.Import;

public interface RSCharacter extends Character
{
    @Import("hash")
    long getHash();

    @Import("name")
    String getName();

    @Import("name")
    void setName(String name);

    @Import("serverIndex")
    int getServerIndex();

    @Import("serverID")
    int getServerID();

    @Import("currentX")
    int getCurrentX();

    @Import("currentY")
    int getCurrentY();

    @Import("npcID")
    int getNPCID();

    @Import("animation")
    int getAnimation();

    @Import("message")
    String getMessage();

    @Import("bubbleItem")
    int getBubbleItem();

    @Import("bubbleItem")
    void setBubbleItem(int itemID);

    @Import("currentHealth")
    int getCurrentHealth();

    @Import("maxHealth")
    int getMaxHealth();

    @Import("combatLevel")
    int getCombatLevel();

    @Import("screenX")
    int getScreenX();

    @Import("screenX")
    void setScreenX(int screenX);

    @Import("screenY")
    int getScreenY();

    @Import("screenCenterX")
    int getScreenCenterX();

    @Import("screenCenterY")
    int getScreenCenterY();

    @Import("screenY")
    void setScreenY(int screenY);

    @Import("combatTimer")
    int getCombatTimer();

    @Import("damageTaken")
    int getDamageTaken();
}
