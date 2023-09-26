import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("ic")
public class class228 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1909;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1912;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1911;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1915;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1913;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1910;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	static final class228 field1914;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "[Lic;"
	)
	static final class228[] field1916;
	@ObfuscatedName("ab")
	final int field1917;
	@ObfuscatedName("am")
	final int field1918;
	@ObfuscatedName("av")
	final int field1919;

	static {
		field1909 = new class228(5, 8, 8);
		field1912 = new class228(0, 16, 16);
		field1911 = new class228(1, 32, 32);
		field1915 = new class228(6, 48, 48);
		field1913 = new class228(4, 64, 64);
		field1910 = new class228(2, 96, 96);
		field1914 = new class228(3, 128, 128);
		class228[] var0 = new class228[]{field1912, field1911, field1910, field1914, field1913, field1909, field1915};
		field1916 = var0;
		Arrays.sort(field1916, new class233());
	}

	class228(int var1, int var2, int var3) {
		this.field1917 = var1;
		this.field1918 = var2;
		this.field1919 = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "14"
	)
	int method1168() {
		return this.field1919 * this.field1918;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1760324394"
	)
	public static int method1169(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 7 & 127L);
		return var1;
	}
}