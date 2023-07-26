import java.io.IOException;
import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class215 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1882;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1883;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	public static final class215 field1877;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1880;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1881;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1879;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	static final class215 field1878;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "[Lir;"
	)
	static final class215[] field1884;
	@ObfuscatedName("az")
	final int field1885;
	@ObfuscatedName("av")
	public final int field1887;
	@ObfuscatedName("ap")
	public final int field1886;

	static {
		field1882 = new class215(2, 8, 8);
		field1883 = new class215(4, 16, 16);
		field1877 = new class215(1, 32, 32);
		field1880 = new class215(0, 48, 48);
		field1881 = new class215(6, 64, 64);
		field1879 = new class215(5, 96, 96);
		field1878 = new class215(3, 128, 128);
		field1884 = UserComparator9.method678();
		Arrays.sort(field1884, new class220());
	}

	class215(int var1, int var2, int var3) {
		this.field1885 = var1;
		this.field1887 = var2;
		this.field1886 = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-9015084"
	)
	int method1105() {
		return this.field1887 * this.field1886;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SIII)V",
		garbageValue = "-2129316412"
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

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "1689417395"
	)
	public static byte[] method1106() {
		byte[] var0 = new byte[24];

		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.readFully(var0);

			int var1;
			for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
			}

			if (var1 >= 24) {
				throw new IOException();
			}
		} catch (Exception var4) {
			for (int var2 = 0; var2 < 24; ++var2) {
				var0[var2] = -1;
			}
		}

		return var0;
	}
}
