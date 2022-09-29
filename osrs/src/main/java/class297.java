import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public enum class297 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lkh;"
	)
	field3557(0),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lkh;"
	)
	field3554(1),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lkh;"
	)
	field3555(2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lkh;"
	)
	field3556(3),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lkh;"
	)
	field3558(4);

	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 570966065
	)
	final int field3553;

	class297(int var3) {
		this.field3553 = var3;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3553;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
		garbageValue = "-115"
	)
	public static String method5904(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var10 = var0[var1];
			return var10 == null ? "null" : var10.toString();
		} else {
			int var3 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var3; ++var5) {
				CharSequence var9 = var0[var5];
				if (var9 == null) {
					var4 += 4;
				} else {
					var4 += var9.length();
				}
			}

			StringBuilder var8 = new StringBuilder(var4);

			for (int var6 = var1; var6 < var3; ++var6) {
				CharSequence var7 = var0[var6];
				if (var7 == null) {
					var8.append("null");
				} else {
					var8.append(var7);
				}
			}

			return var8.toString();
		}
	}
}
