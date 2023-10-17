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

import net.runelite.api.SpriteID;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSCharacter;
import net.runelite.rs.api.RSClient;

import java.awt.*;
import java.awt.geom.Rectangle2D;


@Mixin(RSCharacter.class)
public abstract class RSCharacterMixin implements RSCharacter {

	@Shadow("mudClient")
	public static RSClient client;

	@Inject
	@Override
	public void drawHitSplat(int spriteID) {
		if (getScreenCenterX() <= 0 || getScreenCenterY() <= 0)
			return;
		int sprite = spriteID;
		if (getCombatTimer() > 150) {
			if (client.isCorrectHitsplats()) {
				if (sprite == SpriteID.HITSPLAT_BLUE)
					if (getDamageTaken() > 0)
						sprite = SpriteID.HITSPLAT_RED;
				if (sprite == SpriteID.HITSPLAT_RED)
					if (getDamageTaken() == 0)
						sprite = SpriteID.HITSPLAT_BLUE;
			}
			client.getSurface().drawSprite$api(getScreenCenterX() - 12, getScreenCenterY() - 12, sprite);
			client.getSurface().drawStringCenter$api(String.valueOf(getDamageTaken()), getScreenCenterX() - 1, getScreenCenterY() + 5, 3, 0xffffff);
		}
	}

	@Inject
	public int screenX;

	@Inject
	public int screenY;

	@Inject
	public int screenWidth;

	@Inject
	public int screenHeight;

	@Inject
	@Override
	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}

	@Inject
	@Override
	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}

	@Inject
	@Override
	public int getScreenX() {
		return this.screenX;
	}

	@Inject
	@Override
	public int getScreenY() {return this.screenY;}

	@Inject
	@Override
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	@Inject
	@Override
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	@Inject
	@Override
	public int getScreenWidth() {
		return this.screenWidth;
	}

	@Inject
	@Override
	public int getScreenHeight() {
		return this.screenHeight;
	}

	@Inject
	@Override
	public Rectangle getBounds() {
		return new Rectangle(screenX, screenY, screenWidth, screenHeight);
	}

	@Inject
	@Override
	public void drawTextAboveBounds(Graphics2D graphics, String text) {
		int textWidth = getTextWidth(graphics, text);
		int padding = getScreenWidth() - textWidth;
		graphics.drawString(text, getScreenX() + (padding / 2), getScreenY());
	}

	@Inject
	@Override
	public void drawTextAboveBoundsShadowed(Graphics2D graphics, String text) {
		Color originalColor = graphics.getColor();
		int textWidth = getTextWidth(graphics, text);
		int padding = getScreenWidth() - textWidth;
		graphics.setColor(Color.BLACK);
		graphics.drawString(text, getScreenX() + (padding / 2) + 1, getScreenY() + 1);
		graphics.setColor(originalColor);
		graphics.drawString(text, getScreenX() + (padding / 2), getScreenY());
	}

	@Inject
	public int getTextWidth(Graphics2D graphics, String text) {
		return (int) graphics.getFontMetrics().getStringBounds(text, graphics).getWidth();
	}

	@Inject
	public boolean isNPC = false;

	@Inject
	public boolean isNPC() {
		return isNPC;
	}

	@Inject
	public void setIsNPC(boolean isNPC) {
		this.isNPC = isNPC;
	}
}
