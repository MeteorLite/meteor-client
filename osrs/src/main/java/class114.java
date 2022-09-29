import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class114 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -922141965
	)
	int field1407;
	@ObfuscatedName("p")
	float field1409;
	@ObfuscatedName("f")
	float field1406;
	@ObfuscatedName("n")
	float field1412;
	@ObfuscatedName("k")
	float field1410;
	@ObfuscatedName("w")
	float field1411;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Ldz;"
	)
	class114 field1414;

	class114() {
		this.field1406 = Float.MAX_VALUE;
		this.field1412 = Float.MAX_VALUE;
		this.field1410 = Float.MAX_VALUE;
		this.field1411 = Float.MAX_VALUE;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "1931269991"
	)
	void method2807(Buffer var1, int var2) {
		this.field1407 = var1.readShort();
		this.field1409 = var1.method7930();
		this.field1406 = var1.method7930();
		this.field1412 = var1.method7930();
		this.field1410 = var1.method7930();
		this.field1411 = var1.method7930();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Llv;III)Lqi;",
		garbageValue = "1230406258"
	)
	@Export("SpriteBuffer_getSprite")
	public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		if (!Occluder.method4475(var0, var1, var2)) {
			return null;
		} else {
			SpritePixels var4 = new SpritePixels();
			var4.width = SecureRandomCallable.SpriteBuffer_spriteWidth;
			var4.height = class402.SpriteBuffer_spriteHeight;
			var4.xOffset = class458.SpriteBuffer_xOffsets[0];
			var4.yOffset = class458.SpriteBuffer_yOffsets[0];
			var4.subWidth = ApproximateRouteStrategy.SpriteBuffer_spriteWidths[0];
			var4.subHeight = UserComparator9.SpriteBuffer_spriteHeights[0];
			int var5 = var4.subWidth * var4.subHeight;
			byte[] var6 = FileSystem.SpriteBuffer_pixels[0];
			var4.pixels = new int[var5];

			for (int var7 = 0; var7 < var5; ++var7) {
				var4.pixels[var7] = class458.SpriteBuffer_spritePalette[var6[var7] & 255];
			}

			class458.SpriteBuffer_xOffsets = null;
			class458.SpriteBuffer_yOffsets = null;
			ApproximateRouteStrategy.SpriteBuffer_spriteWidths = null;
			UserComparator9.SpriteBuffer_spriteHeights = null;
			class458.SpriteBuffer_spritePalette = null;
			FileSystem.SpriteBuffer_pixels = null;
			return var4;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "55"
	)
	public static boolean method2806(int var0) {
		return var0 >= 0 && var0 < 112 ? KeyHandler.field133[var0] : false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(B)Lfx;",
		garbageValue = "0"
	)
	public static Clock method2805() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		descriptor = "(ZLqf;B)V",
		garbageValue = "85"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		if (!Client.isInInstance) {
			int var2 = var1.method7964();
			var3 = var1.method7964();
			var4 = var1.readUnsignedShort();
			class202.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					class202.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			class269.regions = new int[var4];
			class124.regionMapArchiveIds = new int[var4];
			HitSplatDefinition.regionLandArchiveIds = new int[var4];
			class269.regionLandArchives = new byte[var4][];
			class33.regionMapArchives = new byte[var4][];
			var4 = 0;

			for (var5 = (var3 - 6) / 8; var5 <= (var3 + 6) / 8; ++var5) {
				for (var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
					var7 = var6 + (var5 << 8);
					class269.regions[var4] = var7;
					class124.regionMapArchiveIds[var4] = class434.archive9.getGroupId("m" + var5 + "_" + var6);
					HitSplatDefinition.regionLandArchiveIds[var4] = class434.archive9.getGroupId("l" + var5 + "_" + var6);
					++var4;
				}
			}

			WorldMapSectionType.method5076(var3, var2, true);
		} else {
			boolean var15 = var1.method8023() == 1;
			var3 = var1.method8143();
			var4 = var1.method7965();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var8;
			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			class202.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					class202.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			class269.regions = new int[var5];
			class124.regionMapArchiveIds = new int[var5];
			HitSplatDefinition.regionLandArchiveIds = new int[var5];
			class269.regionLandArchives = new byte[var5][];
			class33.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (class269.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								class269.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								class124.regionMapArchiveIds[var5] = class434.archive9.getGroupId("m" + var13 + "_" + var14);
								HitSplatDefinition.regionLandArchiveIds[var5] = class434.archive9.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			WorldMapSectionType.method5076(var3, var4, !var15);
		}

	}
}
