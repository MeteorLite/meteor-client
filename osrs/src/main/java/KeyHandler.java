import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@ObfuscatedName("af")
@Implements("KeyHandler")
public class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "[Ltr;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("ah")
	Collection field77;
	@ObfuscatedName("ar")
	Collection field78;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Lbi;"
	)
	class29[] field75;
	@ObfuscatedName("ab")
	@Export("KeyHandler_pressedKeys")
	boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("au")
	@Export("KeyHandler_idleCycles")
	volatile int KeyHandler_idleCycles;

	KeyHandler() {
		this.field75 = new class29[3];
		this.KeyHandler_pressedKeys = new boolean[112];
		this.KeyHandler_idleCycles = 0;
		this.field77 = new ArrayList(100);
		this.field78 = new ArrayList(100);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lbi;II)V",
		garbageValue = "-22982573"
	)
	void method99(class29 var1, int var2) {
		this.field75[var2] = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2119301753"
	)
	@Export("getIdleCycles")
	int getIdleCycles() {
		return this.KeyHandler_idleCycles;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "54"
	)
	void method101(Component var1) {
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(this);
		var1.addFocusListener(this);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "-62"
	)
	synchronized void method102(Component var1) {
		var1.removeKeyListener(this);
		var1.removeFocusListener(this);
		synchronized(this) {
			this.field77.add(new class33(4, 0));
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1170925164"
	)
	void method103() {
		++this.KeyHandler_idleCycles;
		this.method104();
		Iterator var1 = this.field78.iterator();

		while (var1.hasNext()) {
			class33 var2 = (class33)var1.next();

			for (int var3 = 0; var3 < this.field75.length && !var2.method142(this.field75[var3]); ++var3) {
			}
		}

		this.field78.clear();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-5600"
	)
	synchronized void method104() {
		Collection var1 = this.field78;
		this.field78 = this.field77;
		this.field77 = var1;
	}

	public final synchronized void keyPressed(KeyEvent var1) {
		int var2 = var1.getKeyCode();
		if (var2 >= 0 && var2 < WorldMapRectangle.method1326()) {
			int var3 = class28.KeyHandler_keyCodes[var2];
			var2 = var3;
			boolean var4 = (var3 & 128) != 0;
			if (var4) {
				var2 = -1;
			}
		} else {
			var2 = -1;
		}

		if (var2 >= 0) {
			if (!this.KeyHandler_pressedKeys[var2]) {
				this.KeyHandler_idleCycles = 0;
			}

			this.KeyHandler_pressedKeys[var2] = true;
			this.field77.add(new class33(1, var2));
		}

		var1.consume();
	}

	@Export("keyReleased")
	@ObfuscatedName("keyReleased")
	public final synchronized void keyReleased(KeyEvent var1) {
		int var2 = var1.getKeyCode();
		if (var2 >= 0 && var2 < WorldMapRectangle.method1326()) {
			int var3 = class28.KeyHandler_keyCodes[var2];
			var2 = var3 & -129;
		} else {
			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = false;
			this.field77.add(new class33(2, var2));
		}

		var1.consume();
	}

	@Export("keyTyped")
	@ObfuscatedName("keyTyped")
	public final synchronized void keyTyped(KeyEvent var1) {
		char var2 = var1.getKeyChar();
		if (var2 != 0 && var2 != '\uffff' && WorldMapArea.method1207(var2)) {
			this.field77.add(new class33(3, var2));
		}

		var1.consume();
	}

	public final synchronized void focusGained(FocusEvent var1) {
		this.field77.add(new class33(4, 1));
	}

	@Export("focusLost")
	@ObfuscatedName("focusLost")
	public final synchronized void focusLost(FocusEvent var1) {
		for (int var2 = 0; var2 < 112; ++var2) {
			if (this.KeyHandler_pressedKeys[var2]) {
				this.KeyHandler_pressedKeys[var2] = false;
				this.field77.add(new class33(2, var2));
			}
		}

		this.field77.add(new class33(4, 0));
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "76"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("le")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIII)V",
		garbageValue = "-2097696373"
	)
	static final void method106(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
		GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var0, var1, var2, var3, var4, var5, var6, false);
	}
}