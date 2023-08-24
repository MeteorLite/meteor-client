import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@ObfuscatedName("ak")
@Implements("KeyHandler")
public class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("uw")
	static int field70;
	@ObfuscatedName("gp")
	static int field69;
	@ObfuscatedName("rb")
	@ObfuscatedSignature(
		descriptor = "Lej;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("ae")
	Collection field73;
	@ObfuscatedName("ao")
	Collection field74;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lbv;"
	)
	class29[] field72;
	@ObfuscatedName("ac")
	@Export("KeyHandler_pressedKeys")
	boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("ai")
	@Export("KeyHandler_idleCycles")
	volatile int KeyHandler_idleCycles;

	KeyHandler() {
		this.field72 = new class29[3];
		this.KeyHandler_pressedKeys = new boolean[112];
		this.KeyHandler_idleCycles = 0;
		this.field73 = new ArrayList(100);
		this.field74 = new ArrayList(100);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lbv;II)V",
		garbageValue = "226491014"
	)
	void method86(class29 var1, int var2) {
		this.field72[var2] = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2034769800"
	)
	@Export("getIdleCycles")
	public int getIdleCycles() {
		return this.KeyHandler_idleCycles;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "77"
	)
	void method89(Component var1) {
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(this);
		var1.addFocusListener(this);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "70"
	)
	synchronized void method90(Component var1) {
		var1.removeKeyListener(this);
		var1.removeFocusListener(this);
		synchronized(this) {
			this.field73.add(new class33(4, 0));
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2096534148"
	)
	void method92() {
		++this.KeyHandler_idleCycles;
		this.method94();
		Iterator var1 = this.field74.iterator();

		while (var1.hasNext()) {
			class33 var2 = (class33)var1.next();

			for (int var3 = 0; var3 < this.field72.length && !var2.method130(this.field72[var3]); ++var3) {
			}
		}

		this.field74.clear();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1568153203"
	)
	synchronized void method94() {
		Collection var1 = this.field74;
		this.field74 = this.field73;
		this.field73 = var1;
	}

	@Export("keyPressed")
	@ObfuscatedName("keyPressed")
	public final synchronized void keyPressed(KeyEvent var1) {
		int var2 = var1.getKeyCode();
		if (var2 >= 0 && var2 < class1.method2()) {
			var2 = JagexCache.method909(var2);
			boolean var3 = (var2 & 128) != 0;
			if (var3) {
				var2 = -1;
			}
		} else {
			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = true;
			this.field73.add(new class33(1, var2));
			this.KeyHandler_idleCycles = 0;
		}

		var1.consume();
	}

	@Export("keyReleased")
	@ObfuscatedName("keyReleased")
	public final synchronized void keyReleased(KeyEvent var1) {
		int var2;
		label16: {
			var2 = var1.getKeyCode();
			if (var2 >= 0) {
				int var4 = class28.KeyHandler_keyCodes.length;
				if (var2 < var4) {
					var2 = JagexCache.method909(var2) & -129;
					break label16;
				}
			}

			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = false;
			this.field73.add(new class33(2, var2));
		}

		var1.consume();
	}

	@Export("keyTyped")
	@ObfuscatedName("keyTyped")
	public final synchronized void keyTyped(KeyEvent var1) {
		char var2 = var1.getKeyChar();
		if (var2 != 0 && var2 != '\uffff') {
			boolean var3;
			if ((var2 <= 0 || var2 >= 128) && (var2 < 160 || var2 > 255)) {
				label47: {
					if (var2 != 0) {
						char[] var4 = class384.cp1252AsciiExtension;

						for (int var5 = 0; var5 < var4.length; ++var5) {
							char var6 = var4[var5];
							if (var6 == var2) {
								var3 = true;
								break label47;
							}
						}
					}

					var3 = false;
				}
			} else {
				var3 = true;
			}

			if (var3) {
				this.field73.add(new class33(3, var2));
			}
		}

		var1.consume();
	}

	public final synchronized void focusGained(FocusEvent var1) {
		this.field73.add(new class33(4, 1));
	}

	@Export("focusLost")
	@ObfuscatedName("focusLost")
	public final synchronized void focusLost(FocusEvent var1) {
		for (int var2 = 0; var2 < 112; ++var2) {
			if (this.KeyHandler_pressedKeys[var2]) {
				this.KeyHandler_pressedKeys[var2] = false;
				this.field73.add(new class33(2, var2));
			}
		}

		this.field73.add(new class33(4, 0));
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([Lob;II)Lob;",
		garbageValue = "-1278288180"
	)
	@Export("findEnumerated")
	public static class371 findEnumerated(class371[] var0, int var1) {
		class371[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class371 var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "-2016250661"
	)
	public static void method85(Applet var0, String var1) {
		class31.field85 = var0;
		if (var1 != null) {
			class31.field86 = var1;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(CI)C",
		garbageValue = "-1543892590"
	)
	public static char method91(char var0) {
		switch(var0) {
		case ' ':
		case '-':
		case '_':
		case '\u00a0':
			return '_';
		case '#':
		case '[':
		case ']':
			return var0;
		case '\u00c0':
		case '\u00c1':
		case '\u00c2':
		case '\u00c3':
		case '\u00c4':
		case '\u00e0':
		case '\u00e1':
		case '\u00e2':
		case '\u00e3':
		case '\u00e4':
			return 'a';
		case '\u00c7':
		case '\u00e7':
			return 'c';
		case '\u00c8':
		case '\u00c9':
		case '\u00ca':
		case '\u00cb':
		case '\u00e8':
		case '\u00e9':
		case '\u00ea':
		case '\u00eb':
			return 'e';
		case '\u00cd':
		case '\u00ce':
		case '\u00cf':
		case '\u00ed':
		case '\u00ee':
		case '\u00ef':
			return 'i';
		case '\u00d1':
		case '\u00f1':
			return 'n';
		case '\u00d2':
		case '\u00d3':
		case '\u00d4':
		case '\u00d5':
		case '\u00d6':
		case '\u00f2':
		case '\u00f3':
		case '\u00f4':
		case '\u00f5':
		case '\u00f6':
			return 'o';
		case '\u00d9':
		case '\u00da':
		case '\u00db':
		case '\u00dc':
		case '\u00f9':
		case '\u00fa':
		case '\u00fb':
		case '\u00fc':
			return 'u';
		case '\u00df':
			return 'b';
		case '\u00ff':
		case '\u0178':
			return 'y';
		default:
			return Character.toLowerCase(var0);
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ltm;[II)[Ljava/lang/Object;",
		garbageValue = "-165535984"
	)
	static Object[] method88(Buffer var0, int[] var1) {
		int var2 = var0.readUShortSmart();
		Object[] var3 = new Object[var1.length * var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			for (int var5 = 0; var5 < var1.length; ++var5) {
				int var6 = var1.length * var4 + var5;
				class502 var7 = SequenceDefinition.method1074(var1[var5]);
				var3[var6] = var7.method2497(var0);
			}
		}

		return var3;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "24"
	)
	static void method93(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}
}