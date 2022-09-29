import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
public class class353 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1481351603
	)
	int field4239;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1371054721
	)
	int field4242;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2136791495
	)
	int field4241;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1546057299
	)
	int field4240;

	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field4239).length();
		int var3 = 10 - Integer.toString(this.field4241).length();
		int var4 = 10 - Integer.toString(this.field4242).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field4239 + var5 + "Created: " + this.field4242 + var7 + "Total used: " + this.field4241 + var6 + "Max-In-Use: " + this.field4240;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[IIII)V",
		garbageValue = "1517796655"
	)
	static void method6683(String[] var0, int[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			int var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					int var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			method6683(var0, var1, var2, var5 - 1);
			method6683(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(B)Lqu;",
		garbageValue = "7"
	)
	static IndexedSprite method6681() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = SecureRandomCallable.SpriteBuffer_spriteWidth;
		var0.height = class402.SpriteBuffer_spriteHeight;
		var0.xOffset = class458.SpriteBuffer_xOffsets[0];
		var0.yOffset = class458.SpriteBuffer_yOffsets[0];
		var0.subWidth = ApproximateRouteStrategy.SpriteBuffer_spriteWidths[0];
		var0.subHeight = UserComparator9.SpriteBuffer_spriteHeights[0];
		var0.palette = class458.SpriteBuffer_spritePalette;
		var0.pixels = FileSystem.SpriteBuffer_pixels[0];
		class458.SpriteBuffer_xOffsets = null;
		class458.SpriteBuffer_yOffsets = null;
		ApproximateRouteStrategy.SpriteBuffer_spriteWidths = null;
		UserComparator9.SpriteBuffer_spriteHeights = null;
		class458.SpriteBuffer_spritePalette = null;
		FileSystem.SpriteBuffer_pixels = null;
		return var0;
	}
}
