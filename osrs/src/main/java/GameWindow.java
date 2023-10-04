// Decompiled by Jad v1.5.8c. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

import net.runelite.mapping.Implements;

import java.awt.*;

@Implements("RSGameWindow")
public class GameWindow extends Frame {

	public GameWindow(GameShell gameshell, int i, int j, String s, boolean flag, boolean flag1) {
		anInt49 = 28;
		anInt44 = i;
		anInt45 = j;
		gameShell = gameshell;
		if(flag1)
			anInt49 = 48;
		else
			anInt49 = 28;
		setTitle(s);
		setResizable(flag);
		show();
		toFront();
		if (mudclient.injected)
			hide();
		resize(anInt44, anInt45);
		graphics = getGraphics();

	}

	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		if(anInt47 == 0)
			g.translate(0, 24);
		else
			g.translate(-5, 0);
		return g;
	}

	public boolean handleEvent(Event event) {
		if(event.id == 401)
			gameShell.keyDown(event, event.key);
		else
		if(event.id == 402)
			gameShell.keyUp(event, event.key);
		else
		if(event.id == 501)
			gameShell.mouseDown(event.metaDown(), event.x, event.y - 24);
		else
		if(event.id == 506)
			gameShell.mouseDrag(event.metaDown(), event.x, event.y - 24);
		else
		if(event.id == 502)
			gameShell.mouseUp(event, event.x, event.y - 24);
		else
		if(event.id == 503)
			gameShell.mouseMove(event, event.x, event.y - 24);
		else
		if(event.id == 201)
			gameShell.destroy();
		else
		if(event.id == 1001)
			gameShell.action(event, event.target);
		else
		if(event.id == 403)
			gameShell.keyDown(event, event.key);
		else
		if(event.id == 404)
			gameShell.keyUp(event, event.key);
		return true;
	}

	public final void paint(Graphics g) {
		gameShell.paint(g);
	}

	public void resize(int i, int j) {
		super.resize(i, j + anInt49);
	}

	int anInt44;
	int anInt45;
	Graphics graphics;
	int anInt47;
	GameShell gameShell;
	int anInt49;
}
