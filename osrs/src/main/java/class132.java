import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class132 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1279;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1276;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1278;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1277;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1275;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class132 field1280;
	@ObfuscatedName("aa")
	final int field1281;
	@ObfuscatedName("ac")
	final int field1282;
	@ObfuscatedName("al")
	final int field1283;

	static {
		field1279 = new class132(0, 0, (String)null, 0);
		field1276 = new class132(1, 1, (String)null, 9);
		field1278 = new class132(2, 2, (String)null, 3);
		field1277 = new class132(3, 3, (String)null, 6);
		field1275 = new class132(4, 4, (String)null, 1);
		field1280 = new class132(5, 5, (String)null, 3);
	}

	class132(int var1, int var2, String var3, int var4) {
		this.field1281 = var1;
		this.field1282 = var2;
		this.field1283 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1282;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "361473055"
	)
	int method725() {
		return this.field1283;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SIII)V",
		garbageValue = "676709272"
	)
	@Export("sortItemsByName")
	static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("li")
	@ObfuscatedSignature(
		descriptor = "([Lnn;Lnn;ZI)V",
		garbageValue = "-2026134195"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		UrlRequest.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			UrlRequest.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			NPCComposition.method952(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}
}