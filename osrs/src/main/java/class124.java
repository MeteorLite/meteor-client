import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public enum class124 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1531(0, 0),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1528(1, 1),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1525(2, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1523(3, 3),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1527(4, 4),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1526(5, 5),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1529(6, 6),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1530(7, 7),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Ldc;"
	)
	field1524(8, 8);

	@ObfuscatedName("y")
	@Export("operatingSystemName")
	static String operatingSystemName;
	@ObfuscatedName("hh")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2497053
	)
	final int field1532;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -357833305
	)
	final int field1533;

	class124(int var3, int var4) {
		this.field1532 = var3;
		this.field1533 = var4;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int rsOrdinal() {
		return this.field1533;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;I)V",
		garbageValue = "259178183"
	)
	public static void method2964(AbstractArchive var0) {
		StructComposition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(S)[Lqi;",
		garbageValue = "255"
	)
	static SpritePixels[] method2967() {
		SpritePixels[] var0 = new SpritePixels[class458.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class458.SpriteBuffer_spriteCount; ++var1) {
			SpritePixels var2 = var0[var1] = new SpritePixels();
			var2.width = SecureRandomCallable.SpriteBuffer_spriteWidth;
			var2.height = class402.SpriteBuffer_spriteHeight;
			var2.xOffset = class458.SpriteBuffer_xOffsets[var1];
			var2.yOffset = class458.SpriteBuffer_yOffsets[var1];
			var2.subWidth = ApproximateRouteStrategy.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = UserComparator9.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subWidth * var2.subHeight;
			byte[] var4 = FileSystem.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class458.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		class458.SpriteBuffer_xOffsets = null;
		class458.SpriteBuffer_yOffsets = null;
		ApproximateRouteStrategy.SpriteBuffer_spriteWidths = null;
		UserComparator9.SpriteBuffer_spriteHeights = null;
		class458.SpriteBuffer_spritePalette = null;
		FileSystem.SpriteBuffer_pixels = null;
		return var0;
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "(Lce;II)V",
		garbageValue = "-2011953728"
	)
	static final void method2956(Actor var0, int var1) {
		class82.worldToScreen(var0.x, var0.y, var1);
	}

	@ObfuscatedName("kn")
	static final void method2965(double var0) {
		Rasterizer3D.Rasterizer3D_setBrightness(var0);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(var0);
		MouseRecorder.method2247();
		Player.clientPreferences.method2399(var0);
	}
}
