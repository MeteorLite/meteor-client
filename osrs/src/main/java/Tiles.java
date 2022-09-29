import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("c")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("p")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1384721217
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("w")
	@Export("Tiles_shapes")
	static byte[][][] Tiles_shapes;
	@ObfuscatedName("s")
	static byte[][][] field1001;
	@ObfuscatedName("m")
	static int[][] field1002;
	@ObfuscatedName("t")
	static int[] field1008;
	@ObfuscatedName("l")
	static final int[] field1013;
	@ObfuscatedName("e")
	static final int[] field1005;
	@ObfuscatedName("g")
	static final int[] field1006;
	@ObfuscatedName("y")
	static final int[] field1000;
	@ObfuscatedName("i")
	static final int[] field1003;
	@ObfuscatedName("r")
	static final int[] field1009;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2056000543
	)
	@Export("rndHue")
	static int rndHue;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 533087545
	)
	@Export("rndLightness")
	static int rndLightness;
	@ObfuscatedName("lr")
	@ObfuscatedGetter(
		intValue = -1028329921
	)
	@Export("Client_plane")
	static int Client_plane;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field1013 = new int[]{1, 2, 4, 8};
		field1005 = new int[]{16, 32, 64, 128};
		field1006 = new int[]{1, 0, -1, 0};
		field1000 = new int[]{0, -1, 0, 1};
		field1003 = new int[]{1, -1, -1, 1};
		field1009 = new int[]{-1, -1, 1, 1};
		rndHue = (int)(Math.random() * 17.0D) - 8;
		rndLightness = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "([BIIIIIIILgp;[Lgj;)V"
	)
	static final void method2148(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
		Buffer var10 = new Buffer(var0);
		int var11 = -1;

		while (true) {
			int var12 = var10.method8003();
			if (var12 == 0) {
				return;
			}

			var11 += var12;
			int var13 = 0;

			while (true) {
				int var14 = var10.readUShortSmart();
				if (var14 == 0) {
					break;
				}

				var13 += var14 - 1;
				int var15 = var13 & 63;
				int var16 = var13 >> 6 & 63;
				int var17 = var13 >> 12;
				int var18 = var10.readUnsignedByte();
				int var19 = var18 >> 2;
				int var20 = var18 & 3;
				if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
					ObjectComposition var21 = PlayerComposition.getObjectDefinition(var11);
					int var24 = var16 & 7;
					int var25 = var15 & 7;
					int var27 = var21.sizeX;
					int var28 = var21.sizeY;
					int var29;
					if ((var20 & 1) == 1) {
						var29 = var27;
						var27 = var28;
						var28 = var29;
					}

					int var26 = var7 & 3;
					int var23;
					if (var26 == 0) {
						var23 = var24;
					} else if (var26 == 1) {
						var23 = var25;
					} else if (var26 == 2) {
						var23 = 7 - var24 - (var27 - 1);
					} else {
						var23 = 7 - var25 - (var28 - 1);
					}

					var29 = var23 + var2;
					int var30 = var3 + class239.method5121(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
					if (var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
						int var31 = var1;
						if ((Tiles_renderFlags[1][var29][var30] & 2) == 2) {
							var31 = var1 - 1;
						}

						CollisionMap var32 = null;
						if (var31 >= 0) {
							var32 = var9[var31];
						}

						WorldMapAreaData.addObjects(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
					}
				}
			}
		}
	}
}
