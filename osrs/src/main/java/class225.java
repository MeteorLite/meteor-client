import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("ir")
public class class225 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1912;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1909;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1911;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1910;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1908;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1913;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class225 field1907;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "[Lir;"
	)
	static final class225[] field1914;
	@ObfuscatedName("ac")
	final int field1915;
	@ObfuscatedName("al")
	final int field1916;
	@ObfuscatedName("az")
	final int field1917;

	static {
		field1912 = new class225(0, 8, 8);
		field1909 = new class225(1, 16, 16);
		field1911 = new class225(3, 32, 32);
		field1910 = new class225(5, 48, 48);
		field1908 = new class225(6, 64, 64);
		field1913 = new class225(4, 96, 96);
		field1907 = new class225(2, 128, 128);
		field1914 = RouteStrategy.method1149();
		Arrays.sort(field1914, new class230());
	}

	class225(int var1, int var2, int var3) {
		this.field1915 = var1;
		this.field1916 = var2;
		this.field1917 = var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-524801234"
	)
	int method1147() {
		return this.field1917 * this.field1916;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)Z",
		garbageValue = "-1539205894"
	)
	static final boolean method1148(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = ViewportMouse.ViewportMouse_y + var6;
		if (var7 < var0 && var7 < var1 && var7 < var2) {
			return false;
		} else {
			var7 = ViewportMouse.ViewportMouse_y - var6;
			if (var7 > var0 && var7 > var1 && var7 > var2) {
				return false;
			} else {
				var7 = ViewportMouse.ViewportMouse_x + var6;
				if (var7 < var3 && var7 < var4 && var7 < var5) {
					return false;
				} else {
					var7 = ViewportMouse.ViewportMouse_x - var6;
					return var7 <= var3 || var7 <= var4 || var7 <= var5;
				}
			}
		}
	}
}