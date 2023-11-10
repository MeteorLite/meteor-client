import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;

@ObfuscatedName("bf")
public class class31 {
	@ObfuscatedName("at")
	static Applet field85;
	@ObfuscatedName("ah")
	static String field86;
	@ObfuscatedName("kp")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;

	static {
		field85 = null;
		field86 = "";
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "978522160"
	)
	public static int method135(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Lco;",
		garbageValue = "67"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}
}