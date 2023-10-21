// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import net.runelite.mapping.Implements;

import java.awt.Component;

@Implements("RSSpriteSurface")
public final class SpriteSurface extends Surface {

	public void spriteClipping(int x, int y, int width, int height, int id, int tX, int tY) {
		if(id >= 50000) {
			mudclient.mudClient.drawTeleportBubble(x, y, width, height, id - 50000, tX, tY);
			return;
		}
		if(id >= 40000) {
			mudclient.mudClient.drawItem(x, y, width, height, id - 40000, tX, tY);
			return;
		}
		if(id >= 20000) {
			mudclient.mudClient.drawNPC(x, y, width, height, id - 20000, tX, tY);
			return;
		}
		if(id >= 5000) {
			mudclient.mudClient.drawPlayer(x, y, width, height, id - 5000, tX, tY);
        } else {
			super.spriteClipping(x, y, width, height, id);
        }
	}

	public SpriteSurface(int i, int j, int k, Component component) {
		super(i, j, k, component);
		boolean flag = false;
		if(flag)
			new Surface(i, j, k, component);
	}
}
