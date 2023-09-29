import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class230 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lli;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("ac")
	final int[][] field1931;
	@ObfuscatedName("al")
	final int[][] field1932;
	@ObfuscatedName("ak")
	int field1926;
	@ObfuscatedName("ax")
	int field1927;
	@ObfuscatedName("ao")
	final int[] field1930;
	@ObfuscatedName("ah")
	final int[] field1929;
	@ObfuscatedName("ar")
	final int field1928;

	class230(int var1, int var2) {
		this.field1931 = new int[var1][var2];
		this.field1932 = new int[var1][var2];
		int var3 = var2 * var1;
		int var4 = EnumComposition.method999(var3 / 4);
		this.field1930 = new int[var4];
		this.field1929 = new int[var4];
		this.field1928 = var4 - 1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "79"
	)
	void method1173() {
		for (int var1 = 0; var1 < this.field1931.length; ++var1) {
			for (int var2 = 0; var2 < this.field1931[var1].length; ++var2) {
				this.field1931[var1][var2] = 0;
				this.field1932[var1][var2] = 99999999;
			}
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-19"
	)
	void method1174(int var1, int var2) {
		this.field1926 = var1;
		this.field1927 = var2;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-9624"
	)
	int method1175() {
		return this.field1926;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-3816"
	)
	int method1176() {
		return this.field1927;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-796520814"
	)
	int method1177() {
		return this.field1931.length;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1493129305"
	)
	int method1178() {
		return this.field1931[0].length;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "-1798810715"
	)
	int[][] method1179() {
		return this.field1931;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)[[I",
		garbageValue = "19"
	)
	int[][] method1180() {
		return this.field1932;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "40"
	)
	int[] method1181() {
		return this.field1930;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1267204855"
	)
	int[] method1182() {
		return this.field1929;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2043277042"
	)
	int method1183() {
		return this.field1928;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IZIZI)V",
		garbageValue = "-575404360"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (UserComparator3.World_worlds != null) {
			FloorDecoration.doWorldSorting(0, UserComparator3.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;IZI)I",
		garbageValue = "-527981427"
	)
	public static int method1184(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						throw new NumberFormatException();
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					throw new NumberFormatException();
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					throw new NumberFormatException();
				}

				var5 = var9;
				var4 = true;
			}

			if (!var4) {
				throw new NumberFormatException();
			} else {
				return var5;
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
}