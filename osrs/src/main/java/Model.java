import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;
import java.util.HashMap;

@ObfuscatedName("ka")
@Implements("Model")
public class Model extends Renderable {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	@Export("Model_sharedSequenceModel")
	static Model Model_sharedSequenceModel;
	@ObfuscatedName("ah")
	@Export("Model_sharedSequenceModelFaceAlphas")
	static byte[] Model_sharedSequenceModelFaceAlphas;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	@Export("Model_sharedSpotAnimationModel")
	static Model Model_sharedSpotAnimationModel;
	@ObfuscatedName("ao")
	@Export("Model_sharedSpotAnimationModelFaceAlphas")
	static byte[] Model_sharedSpotAnimationModelFaceAlphas;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	static class462 field2385;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	static class462 field2386;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	static class462 field2384;
	@ObfuscatedName("bo")
	static boolean[] field2353;
	@ObfuscatedName("bt")
	static boolean[] field2354;
	@ObfuscatedName("bu")
	@Export("modelViewportXs")
	static int[] modelViewportXs;
	@ObfuscatedName("by")
	@Export("modelViewportYs")
	static int[] modelViewportYs;
	@ObfuscatedName("bh")
	static float[] field2359;
	@ObfuscatedName("bz")
	static int[] field2370;
	@ObfuscatedName("bc")
	static int[] field2364;
	@ObfuscatedName("bs")
	static int[] field2366;
	@ObfuscatedName("bx")
	static int[] field2368;
	@ObfuscatedName("bk")
	static char[] field2357;
	@ObfuscatedName("br")
	static char[][] field2358;
	@ObfuscatedName("bq")
	static int[] field2365;
	@ObfuscatedName("cf")
	static int[][] field2381;
	@ObfuscatedName("cg")
	static int[] field2373;
	@ObfuscatedName("cv")
	static int[] field2379;
	@ObfuscatedName("cx")
	static int[] field2380;
	@ObfuscatedName("cp")
	static int[] field2377;
	@ObfuscatedName("ce")
	static int[] field2372;
	@ObfuscatedName("ci")
	static int[] field2374;
	@ObfuscatedName("ct")
	static float[] field2360;
	@ObfuscatedName("cw")
	@Export("Model_transformTempX")
	static int Model_transformTempX;
	@ObfuscatedName("cq")
	@Export("Model_transformTempY")
	static int Model_transformTempY;
	@ObfuscatedName("cl")
	@Export("Model_transformTempZ")
	static int Model_transformTempZ;
	@ObfuscatedName("cs")
	static boolean field2352;
	@ObfuscatedName("cn")
	static int[] field2376;
	@ObfuscatedName("cr")
	static int[] field2378;
	@ObfuscatedName("cj")
	static int[] field2375;
	@ObfuscatedName("ca")
	static int[] field2371;
	@ObfuscatedName("ch")
	static final float field2387;
	@ObfuscatedName("ac")
	@Export("verticesCount")
	public int verticesCount;
	@ObfuscatedName("al")
	@Export("verticesX")
	int[] verticesX;
	@ObfuscatedName("az")
	@Export("verticesY")
	int[] verticesY;
	@ObfuscatedName("ap")
	@Export("verticesZ")
	int[] verticesZ;
	@ObfuscatedName("av")
	@Export("indicesCount")
	public int indicesCount;
	@ObfuscatedName("ax")
	@Export("indices1")
	int[] indices1;
	@ObfuscatedName("as")
	@Export("indices2")
	int[] indices2;
	@ObfuscatedName("ay")
	@Export("indices3")
	int[] indices3;
	@ObfuscatedName("ak")
	@Export("faceColors1")
	int[] faceColors1;
	@ObfuscatedName("aj")
	@Export("faceColors2")
	int[] faceColors2;
	@ObfuscatedName("am")
	@Export("faceColors3")
	int[] faceColors3;
	@ObfuscatedName("aq")
	@Export("faceRenderPriorities")
	byte[] faceRenderPriorities;
	@ObfuscatedName("ai")
	@Export("faceAlphas")
	byte[] faceAlphas;
	@ObfuscatedName("aw")
	byte[] field2390;
	@ObfuscatedName("ae")
	@Export("faceTextures")
	short[] faceTextures;
	@ObfuscatedName("an")
	public byte field2415;
	@ObfuscatedName("ag")
	public int field2421;
	@ObfuscatedName("ad")
	int[] field2396;
	@ObfuscatedName("af")
	int[] field2397;
	@ObfuscatedName("be")
	int[] field2407;
	@ObfuscatedName("bd")
	@Export("vertexLabels")
	int[][] vertexLabels;
	@ObfuscatedName("bl")
	@Export("faceLabelsAlpha")
	int[][] faceLabelsAlpha;
	@ObfuscatedName("bi")
	int[][] field2409;
	@ObfuscatedName("bv")
	int[][] field2411;
	@ObfuscatedName("bf")
	@Export("isSingleTile")
	public boolean isSingleTile;
	@ObfuscatedName("bg")
	@Export("boundsType")
	int boundsType;
	@ObfuscatedName("ba")
	@Export("bottomY")
	int bottomY;
	@ObfuscatedName("bm")
	@Export("xzRadius")
	int xzRadius;
	@ObfuscatedName("bp")
	@Export("diameter")
	int diameter;
	@ObfuscatedName("bw")
	@Export("radius")
	int radius;
	@ObfuscatedName("bj")
	@Export("aabb")
	HashMap aabb;
	@ObfuscatedName("cb")
	@Export("overrideHue")
	public byte overrideHue;
	@ObfuscatedName("cz")
	@Export("overrideSaturation")
	public byte overrideSaturation;
	@ObfuscatedName("cy")
	@Export("overrideLuminance")
	public byte overrideLuminance;
	@ObfuscatedName("ck")
	@Export("overrideAmount")
	public byte overrideAmount;
	@ObfuscatedName("cd")
	public short field2423;

	static {
		Model_sharedSequenceModel = new Model();
		Model_sharedSequenceModelFaceAlphas = new byte[1];
		Model_sharedSpotAnimationModel = new Model();
		Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
		field2385 = new class462();
		field2386 = new class462();
		field2384 = new class462();
		field2353 = new boolean[6500];
		field2354 = new boolean[6500];
		modelViewportXs = new int[6500];
		modelViewportYs = new int[6500];
		field2359 = new float[6500];
		field2370 = new int[6500];
		field2364 = new int[6500];
		field2366 = new int[6500];
		field2368 = new int[6500];
		field2357 = new char[6000];
		field2358 = new char[6000][512];
		field2365 = new int[12];
		field2381 = new int[12][2000];
		field2373 = new int[2000];
		field2379 = new int[2000];
		field2377 = new int[12];
		field2372 = new int[10];
		field2380 = new int[10];
		field2374 = new int[10];
		field2360 = new float[10];
		field2352 = true;
		field2376 = Rasterizer3D.Rasterizer3D_sine;
		field2378 = Rasterizer3D.Rasterizer3D_cosine;
		field2375 = Rasterizer3D.Rasterizer3D_colorPalette;
		field2371 = Rasterizer3D.field2219;
		field2387 = WorldMapAreaData.method1364(50);
	}

	Model() {
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2415 = 0;
		this.field2421 = 0;
		this.isSingleTile = false;
		this.aabb = new HashMap();
	}

	public Model(int var1, int var2, int var3, byte var4) {
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2415 = 0;
		this.field2421 = 0;
		this.isSingleTile = false;
		this.aabb = new HashMap();
		this.method1530(var1, var2, var3);
		this.field2415 = var4;
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2421 = 0;
	}

	@ObfuscatedSignature(
		descriptor = "([Lka;I)V"
	)
	public Model(Model[] var1, int var2) {
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2415 = 0;
		this.field2421 = 0;
		this.isSingleTile = false;
		this.aabb = new HashMap();
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2421 = 0;
		this.field2415 = -1;

		int var3;
		for (var3 = 0; var3 < var2; ++var3) {
			Model var4 = var1[var3];
			if (var4 != null) {
				this.verticesCount += var4.verticesCount;
				this.indicesCount += var4.indicesCount;
				this.field2421 += var4.field2421;
				if (this.field2415 == -1) {
					this.field2415 = var4.field2415;
				}
			}
		}

		this.method1530(this.verticesCount, this.indicesCount, this.field2421);
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field2421 = 0;

		for (var3 = 0; var3 < var2; ++var3) {
			this.method1532(var1[var3]);
		}

	}

	@ObfuscatedName("at")
	void method1530(int var1, int var2, int var3) {
		this.verticesX = new int[var1];
		this.verticesY = new int[var1];
		this.verticesZ = new int[var1];
		this.indices1 = new int[var2];
		this.indices2 = new int[var2];
		this.indices3 = new int[var2];
		this.faceColors1 = new int[var2];
		this.faceColors2 = new int[var2];
		this.faceColors3 = new int[var2];
		if (var3 > 0) {
			this.field2396 = new int[var3];
			this.field2397 = new int[var3];
			this.field2407 = new int[var3];
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lka;)V"
	)
	void method1531(Model var1) {
		int var2 = this.indices1.length;
		if (this.faceRenderPriorities == null && (var1.faceRenderPriorities != null || this.field2415 != var1.field2415)) {
			this.faceRenderPriorities = new byte[var2];
			Arrays.fill(this.faceRenderPriorities, this.field2415);
		}

		if (this.faceAlphas == null && var1.faceAlphas != null) {
			this.faceAlphas = new byte[var2];
			Arrays.fill(this.faceAlphas, (byte)0);
		}

		if (this.faceTextures == null && var1.faceTextures != null) {
			this.faceTextures = new short[var2];
			Arrays.fill(this.faceTextures, (short)-1);
		}

		if (this.field2390 == null && var1.field2390 != null) {
			this.field2390 = new byte[var2];
			Arrays.fill(this.field2390, (byte)-1);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lka;)V"
	)
	public void method1532(Model var1) {
		if (var1 != null) {
			this.method1531(var1);

			int var2;
			for (var2 = 0; var2 < var1.indicesCount; ++var2) {
				this.indices1[this.indicesCount] = this.verticesCount + var1.indices1[var2];
				this.indices2[this.indicesCount] = this.verticesCount + var1.indices2[var2];
				this.indices3[this.indicesCount] = this.verticesCount + var1.indices3[var2];
				this.faceColors1[this.indicesCount] = var1.faceColors1[var2];
				this.faceColors2[this.indicesCount] = var1.faceColors2[var2];
				this.faceColors3[this.indicesCount] = var1.faceColors3[var2];
				if (this.faceRenderPriorities != null) {
					this.faceRenderPriorities[this.indicesCount] = var1.faceRenderPriorities != null ? var1.faceRenderPriorities[var2] : var1.field2415;
				}

				if (this.faceAlphas != null && var1.faceAlphas != null) {
					this.faceAlphas[this.indicesCount] = var1.faceAlphas[var2];
				}

				if (this.faceTextures != null) {
					this.faceTextures[this.indicesCount] = var1.faceTextures != null ? var1.faceTextures[var2] : -1;
				}

				if (this.field2390 != null) {
					if (var1.field2390 != null && var1.field2390[var2] != -1) {
						this.field2390[this.indicesCount] = (byte)(var1.field2390[var2] + this.field2421);
					} else {
						this.field2390[this.indicesCount] = -1;
					}
				}

				++this.indicesCount;
			}

			for (var2 = 0; var2 < var1.field2421; ++var2) {
				this.field2396[this.field2421] = this.verticesCount + var1.field2396[var2];
				this.field2397[this.field2421] = this.verticesCount + var1.field2397[var2];
				this.field2407[this.field2421] = this.verticesCount + var1.field2407[var2];
				++this.field2421;
			}

			for (var2 = 0; var2 < var1.verticesCount; ++var2) {
				this.verticesX[this.verticesCount] = var1.verticesX[var2];
				this.verticesY[this.verticesCount] = var1.verticesY[var2];
				this.verticesZ[this.verticesCount] = var1.verticesZ[var2];
				++this.verticesCount;
			}

		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "([[IIIIZI)Lka;"
	)
	@Export("contourGround")
	public Model contourGround(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
		this.calculateBoundsCylinder();
		int var7 = var2 - this.xzRadius;
		int var8 = var2 + this.xzRadius;
		int var9 = var4 - this.xzRadius;
		int var10 = var4 + this.xzRadius;
		if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
			var7 >>= 7;
			var8 = var8 + 127 >> 7;
			var9 >>= 7;
			var10 = var10 + 127 >> 7;
			if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
				return this;
			} else {
				Model var11;
				if (var5) {
					var11 = new Model();
					var11.verticesCount = this.verticesCount;
					var11.indicesCount = this.indicesCount;
					var11.field2421 = this.field2421;
					var11.verticesX = this.verticesX;
					var11.verticesZ = this.verticesZ;
					var11.indices1 = this.indices1;
					var11.indices2 = this.indices2;
					var11.indices3 = this.indices3;
					var11.faceColors1 = this.faceColors1;
					var11.faceColors2 = this.faceColors2;
					var11.faceColors3 = this.faceColors3;
					var11.faceRenderPriorities = this.faceRenderPriorities;
					var11.faceAlphas = this.faceAlphas;
					var11.field2390 = this.field2390;
					var11.faceTextures = this.faceTextures;
					var11.field2415 = this.field2415;
					var11.field2396 = this.field2396;
					var11.field2397 = this.field2397;
					var11.field2407 = this.field2407;
					var11.vertexLabels = this.vertexLabels;
					var11.faceLabelsAlpha = this.faceLabelsAlpha;
					var11.isSingleTile = this.isSingleTile;
					var11.verticesY = new int[var11.verticesCount];
				} else {
					var11 = this;
				}

				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				int var20;
				int var21;
				if (var6 == 0) {
					for (var12 = 0; var12 < var11.verticesCount; ++var12) {
						var13 = var2 + this.verticesX[var12];
						var14 = var4 + this.verticesZ[var12];
						var15 = var13 & 127;
						var16 = var14 & 127;
						var17 = var13 >> 7;
						var18 = var14 >> 7;
						var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
						var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
						var21 = var19 * (128 - var16) + var20 * var16 >> 7;
						var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
					}
				} else {
					for (var12 = 0; var12 < var11.verticesCount; ++var12) {
						var13 = (-this.verticesY[var12] << 16) / super.height;
						if (var13 < var6) {
							var14 = var2 + this.verticesX[var12];
							var15 = var4 + this.verticesZ[var12];
							var16 = var14 & 127;
							var17 = var15 & 127;
							var18 = var14 >> 7;
							var19 = var15 >> 7;
							var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
							var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
							int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
							var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
						}
					}
				}

				var11.resetBounds();
				return var11;
			}
		} else {
			return this;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Z)Lka;"
	)
	@Export("toSharedSequenceModel")
	public Model toSharedSequenceModel(boolean var1) {
		if (!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
			Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
		}

		return this.buildSharedModel(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Z)Lka;"
	)
	@Export("toSharedSpotAnimationModel")
	public Model toSharedSpotAnimationModel(boolean var1) {
		if (!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
			Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
		}

		return this.buildSharedModel(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(ZLka;[B)Lka;"
	)
	@Export("buildSharedModel")
	Model buildSharedModel(boolean var1, Model var2, byte[] var3) {
		var2.verticesCount = this.verticesCount;
		var2.indicesCount = this.indicesCount;
		var2.field2421 = this.field2421;
		if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
			var2.verticesX = new int[this.verticesCount + 100];
			var2.verticesY = new int[this.verticesCount + 100];
			var2.verticesZ = new int[this.verticesCount + 100];
		}

		int var4;
		for (var4 = 0; var4 < this.verticesCount; ++var4) {
			var2.verticesX[var4] = this.verticesX[var4];
			var2.verticesY[var4] = this.verticesY[var4];
			var2.verticesZ[var4] = this.verticesZ[var4];
		}

		if (var1) {
			var2.faceAlphas = this.faceAlphas;
		} else {
			var2.faceAlphas = var3;
			if (this.faceAlphas == null) {
				for (var4 = 0; var4 < this.indicesCount; ++var4) {
					var2.faceAlphas[var4] = 0;
				}
			} else {
				for (var4 = 0; var4 < this.indicesCount; ++var4) {
					var2.faceAlphas[var4] = this.faceAlphas[var4];
				}
			}
		}

		var2.indices1 = this.indices1;
		var2.indices2 = this.indices2;
		var2.indices3 = this.indices3;
		var2.faceColors1 = this.faceColors1;
		var2.faceColors2 = this.faceColors2;
		var2.faceColors3 = this.faceColors3;
		var2.faceRenderPriorities = this.faceRenderPriorities;
		var2.field2390 = this.field2390;
		var2.faceTextures = this.faceTextures;
		var2.field2415 = this.field2415;
		var2.field2396 = this.field2396;
		var2.field2397 = this.field2397;
		var2.field2407 = this.field2407;
		var2.vertexLabels = this.vertexLabels;
		var2.faceLabelsAlpha = this.faceLabelsAlpha;
		var2.field2409 = this.field2409;
		var2.field2411 = this.field2411;
		var2.isSingleTile = this.isSingleTile;
		var2.resetBounds();
		var2.overrideAmount = 0;
		return var2;
	}

	@ObfuscatedName("ax")
	@Export("calculateBoundingBox")
	void calculateBoundingBox(int var1) {
		if (!this.aabb.containsKey(var1)) {
			int var2 = 0;
			int var3 = 0;
			int var4 = 0;
			int var5 = 0;
			int var6 = 0;
			int var7 = 0;
			int var8 = field2378[var1];
			int var9 = field2376[var1];

			for (int var10 = 0; var10 < this.verticesCount; ++var10) {
				int var11 = WorldMapEvent.method1381(this.verticesX[var10], this.verticesZ[var10], var8, var9);
				int var12 = this.verticesY[var10];
				int var14 = this.verticesX[var10];
				int var15 = this.verticesZ[var10];
				int var13 = var15 * var8 - var9 * var14 >> 16;
				if (var11 < var2) {
					var2 = var11;
				}

				if (var11 > var5) {
					var5 = var11;
				}

				if (var12 < var3) {
					var3 = var12;
				}

				if (var12 > var6) {
					var6 = var12;
				}

				if (var13 < var4) {
					var4 = var13;
				}

				if (var13 > var7) {
					var7 = var13;
				}
			}

			AABB var17 = new AABB((var5 + var2) / 2, (var6 + var3) / 2, (var7 + var4) / 2, (var5 - var2 + 1) / 2, (var6 - var3 + 1) / 2, (var7 - var4 + 1) / 2);
			boolean var18 = true;
			if (var17.xMidOffset < 32) {
				var17.xMidOffset = 32;
			}

			if (var17.zMidOffset < 32) {
				var17.zMidOffset = 32;
			}

			if (this.isSingleTile) {
				boolean var19 = true;
				var17.xMidOffset += 8;
				var17.zMidOffset += 8;
			}

			this.aabb.put(var1, var17);
		}
	}

	@ObfuscatedName("as")
	@Export("calculateBoundsCylinder")
	public void calculateBoundsCylinder() {
		if (this.boundsType != 1) {
			this.boundsType = 1;
			super.height = 0;
			this.bottomY = 0;
			this.xzRadius = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1) {
				int var2 = this.verticesX[var1];
				int var3 = this.verticesY[var1];
				int var4 = this.verticesZ[var1];
				if (-var3 > super.height) {
					super.height = -var3;
				}

				if (var3 > this.bottomY) {
					this.bottomY = var3;
				}

				int var5 = var2 * var2 + var4 * var4;
				if (var5 > this.xzRadius) {
					this.xzRadius = var5;
				}
			}

			this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
			this.radius = (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + super.height * super.height)) + 0.99D);
			this.diameter = this.radius + (int)(Math.sqrt((double)(this.xzRadius * this.xzRadius + this.bottomY * this.bottomY)) + 0.99D);
		}
	}

	@ObfuscatedName("ay")
	void method1539() {
		if (this.boundsType != 2) {
			this.boundsType = 2;
			this.xzRadius = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1) {
				int var2 = this.verticesX[var1];
				int var3 = this.verticesY[var1];
				int var4 = this.verticesZ[var1];
				int var5 = var2 * var2 + var4 * var4 + var3 * var3;
				if (var5 > this.xzRadius) {
					this.xzRadius = var5;
				}
			}

			this.xzRadius = (int)(Math.sqrt((double)this.xzRadius) + 0.99D);
			this.radius = this.xzRadius;
			this.diameter = this.xzRadius + this.xzRadius;
		}
	}

	@ObfuscatedName("ak")
	public int method1540() {
		this.calculateBoundsCylinder();
		return this.xzRadius;
	}

	@ObfuscatedName("aj")
	@Export("resetBounds")
	public void resetBounds() {
		this.boundsType = 0;
		this.aabb.clear();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lko;I)V"
	)
	@Export("animate")
	public void animate(Frames var1, int var2) {
		if (this.vertexLabels != null) {
			if (var2 != -1) {
				Animation var3 = var1.frames[var2];
				Skeleton var4 = var3.skeleton;
				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;

				for (int var5 = 0; var5 < var3.transformCount; ++var5) {
					int var6 = var3.transformSkeletonLabels[var5];
					this.transform(var4.transformTypes[var6], var4.labels[var6], var3.transformXs[var5], var3.transformYs[var5], var3.transformZs[var5]);
				}

				this.resetBounds();
			}
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lfo;I)V"
	)
	public void method1543(class139 var1, int var2) {
		Skeleton var3 = var1.field1317;
		class267 var4 = var3.method1455();
		if (var4 != null) {
			var3.method1455().method1442(var1, var2);
			this.method1545(var3.method1455(), var1.method742());
		}

		if (var1.method743()) {
			this.method1544(var1, var2);
		}

		this.resetBounds();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lfo;I)V"
	)
	void method1544(class139 var1, int var2) {
		Skeleton var3 = var1.field1317;

		for (int var4 = 0; var4 < var3.count; ++var4) {
			int var5 = var3.transformTypes[var4];
			if (var5 == 5 && var1.field1316 != null && var1.field1316[var4] != null && var1.field1316[var4][0] != null && this.faceLabelsAlpha != null && this.faceAlphas != null) {
				class131 var6 = var1.field1316[var4][0];
				int[] var7 = var3.labels[var4];
				int var8 = var7.length;

				for (int var9 = 0; var9 < var8; ++var9) {
					int var10 = var7[var9];
					if (var10 < this.faceLabelsAlpha.length) {
						int[] var11 = this.faceLabelsAlpha[var10];

						for (int var12 = 0; var12 < var11.length; ++var12) {
							int var13 = var11[var12];
							int var14 = (int)((float)(this.faceAlphas[var13] & 255) + var6.method716(var2) * 255.0F);
							if (var14 < 0) {
								var14 = 0;
							} else if (var14 > 255) {
								var14 = 255;
							}

							this.faceAlphas[var13] = (byte)var14;
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lkz;I)V"
	)
	void method1545(class267 var1, int var2) {
		this.method1565(var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lko;ILko;I[I)V"
	)
	@Export("animate2")
	public void animate2(Frames var1, int var2, Frames var3, int var4, int[] var5) {
		if (var2 != -1) {
			if (var5 != null && var4 != -1) {
				Animation var6 = var1.frames[var2];
				Animation var7 = var3.frames[var4];
				Skeleton var8 = var6.skeleton;
				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;
				byte var9 = 0;
				int var13 = var9 + 1;
				int var10 = var5[var9];

				int var11;
				int var12;
				for (var11 = 0; var11 < var6.transformCount; ++var11) {
					for (var12 = var6.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 != var10 || var8.transformTypes[var12] == 0) {
						this.transform(var8.transformTypes[var12], var8.labels[var12], var6.transformXs[var11], var6.transformYs[var11], var6.transformZs[var11]);
					}
				}

				Model_transformTempX = 0;
				Model_transformTempY = 0;
				Model_transformTempZ = 0;
				var9 = 0;
				var13 = var9 + 1;
				var10 = var5[var9];

				for (var11 = 0; var11 < var7.transformCount; ++var11) {
					for (var12 = var7.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 == var10 || var8.transformTypes[var12] == 0) {
						this.transform(var8.transformTypes[var12], var8.labels[var12], var7.transformXs[var11], var7.transformYs[var11], var7.transformZs[var11]);
					}
				}

				this.resetBounds();
			} else {
				this.animate(var1, var2);
			}
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lkd;Lfo;I[ZZZ)V"
	)
	public void method1547(Skeleton var1, class139 var2, int var3, boolean[] var4, boolean var5, boolean var6) {
		class267 var7 = var1.method1455();
		if (var7 != null) {
			var7.method1443(var2, var3, var4, var5);
			if (var6) {
				this.method1545(var7, var2.method742());
			}
		}

		if (!var5 && var2.method743()) {
			this.method1544(var2, var3);
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lko;I[IZ)V"
	)
	public void method1548(Frames var1, int var2, int[] var3, boolean var4) {
		if (var3 == null) {
			this.animate(var1, var2);
		} else {
			Animation var5 = var1.frames[var2];
			Skeleton var6 = var5.skeleton;
			byte var7 = 0;
			int var11 = var7 + 1;
			int var8 = var3[var7];
			Model_transformTempX = 0;
			Model_transformTempY = 0;
			Model_transformTempZ = 0;

			for (int var9 = 0; var9 < var5.transformCount; ++var9) {
				int var10;
				for (var10 = var5.transformSkeletonLabels[var9]; var10 > var8; var8 = var3[var11++]) {
				}

				if (var4) {
					if (var10 == var8 || var6.transformTypes[var10] == 0) {
						this.transform(var6.transformTypes[var10], var6.labels[var10], var5.transformXs[var9], var5.transformYs[var9], var5.transformZs[var9]);
					}
				} else if (var10 != var8 || var6.transformTypes[var10] == 0) {
					this.transform(var6.transformTypes[var10], var6.labels[var10], var5.transformXs[var9], var5.transformYs[var9], var5.transformZs[var9]);
				}
			}

		}
	}

	@ObfuscatedName("ad")
	@Export("transform")
	void transform(int var1, int[] var2, int var3, int var4, int var5) {
		int var6 = var2.length;
		int var7;
		int var8;
		int var11;
		int var12;
		if (var1 == 0) {
			var7 = 0;
			Model_transformTempX = 0;
			Model_transformTempY = 0;
			Model_transformTempZ = 0;

			for (var8 = 0; var8 < var6; ++var8) {
				int var18 = var2[var8];
				if (var18 < this.vertexLabels.length) {
					int[] var19 = this.vertexLabels[var18];

					for (var11 = 0; var11 < var19.length; ++var11) {
						var12 = var19[var11];
						Model_transformTempX += this.verticesX[var12];
						Model_transformTempY += this.verticesY[var12];
						Model_transformTempZ += this.verticesZ[var12];
						++var7;
					}
				}
			}

			if (var7 > 0) {
				Model_transformTempX = var3 + Model_transformTempX / var7;
				Model_transformTempY = var4 + Model_transformTempY / var7;
				Model_transformTempZ = var5 + Model_transformTempZ / var7;
			} else {
				Model_transformTempX = var3;
				Model_transformTempY = var4;
				Model_transformTempZ = var5;
			}

		} else {
			int[] var9;
			int var10;
			int[] var10000;
			if (var1 == 1) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var9 = this.vertexLabels[var8];

						for (var10 = 0; var10 < var9.length; ++var10) {
							var11 = var9[var10];
							var10000 = this.verticesX;
							var10000[var11] += var3;
							var10000 = this.verticesY;
							var10000[var11] += var4;
							var10000 = this.verticesZ;
							var10000[var11] += var5;
						}
					}
				}

			} else if (var1 == 2) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var9 = this.vertexLabels[var8];

						for (var10 = 0; var10 < var9.length; ++var10) {
							var11 = var9[var10];
							var10000 = this.verticesX;
							var10000[var11] -= Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] -= Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] -= Model_transformTempZ;
							var12 = (var3 & 255) * 8;
							int var13 = (var4 & 255) * 8;
							int var14 = (var5 & 255) * 8;
							int var15;
							int var16;
							int var17;
							if (var14 != 0) {
								var15 = field2376[var14];
								var16 = field2378[var14];
								var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
								this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
								this.verticesX[var11] = var17;
							}

							if (var12 != 0) {
								var15 = field2376[var12];
								var16 = field2378[var12];
								var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
								this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
								this.verticesY[var11] = var17;
							}

							if (var13 != 0) {
								var15 = field2376[var13];
								var16 = field2378[var13];
								var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
								this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
								this.verticesX[var11] = var17;
							}

							var10000 = this.verticesX;
							var10000[var11] += Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] += Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] += Model_transformTempZ;
						}
					}
				}

			} else if (var1 == 3) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.vertexLabels.length) {
						var9 = this.vertexLabels[var8];

						for (var10 = 0; var10 < var9.length; ++var10) {
							var11 = var9[var10];
							var10000 = this.verticesX;
							var10000[var11] -= Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] -= Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] -= Model_transformTempZ;
							this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
							this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
							this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
							var10000 = this.verticesX;
							var10000[var11] += Model_transformTempX;
							var10000 = this.verticesY;
							var10000[var11] += Model_transformTempY;
							var10000 = this.verticesZ;
							var10000[var11] += Model_transformTempZ;
						}
					}
				}

			} else if (var1 == 5) {
				if (this.faceLabelsAlpha != null && this.faceAlphas != null) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var2[var7];
						if (var8 < this.faceLabelsAlpha.length) {
							var9 = this.faceLabelsAlpha[var8];

							for (var10 = 0; var10 < var9.length; ++var10) {
								var11 = var9[var10];
								var12 = (this.faceAlphas[var11] & 255) + var3 * 8;
								if (var12 < 0) {
									var12 = 0;
								} else if (var12 > 255) {
									var12 = 255;
								}

								this.faceAlphas[var11] = (byte)var12;
							}
						}
					}
				}

			}
		}
	}

	@ObfuscatedName("af")
	@Export("rotateY90Ccw")
	public void rotateY90Ccw() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			int var2 = this.verticesX[var1];
			this.verticesX[var1] = this.verticesZ[var1];
			this.verticesZ[var1] = -var2;
		}

		this.resetBounds();
	}

	@ObfuscatedName("be")
	@Export("rotateY180")
	public void rotateY180() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			this.verticesX[var1] = -this.verticesX[var1];
			this.verticesZ[var1] = -this.verticesZ[var1];
		}

		this.resetBounds();
	}

	@ObfuscatedName("bd")
	@Export("rotateY270Ccw")
	public void rotateY270Ccw() {
		for (int var1 = 0; var1 < this.verticesCount; ++var1) {
			int var2 = this.verticesZ[var1];
			this.verticesZ[var1] = this.verticesX[var1];
			this.verticesX[var1] = -var2;
		}

		this.resetBounds();
	}

	@ObfuscatedName("bl")
	@Export("rotateZ")
	public void rotateZ(int var1) {
		int var2 = field2376[var1];
		int var3 = field2378[var1];

		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
			this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
			this.verticesY[var4] = var5;
		}

		this.resetBounds();
	}

	@ObfuscatedName("bi")
	@Export("offsetBy")
	public void offsetBy(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			int[] var10000 = this.verticesX;
			var10000[var4] += var1;
			var10000 = this.verticesY;
			var10000[var4] += var2;
			var10000 = this.verticesZ;
			var10000[var4] += var3;
		}

		this.resetBounds();
	}

	@ObfuscatedName("bv")
	@Export("scale")
	public void scale(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.verticesCount; ++var4) {
			this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
			this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
			this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
		}

		this.resetBounds();
	}

	@ObfuscatedName("bf")
	public final void method1556(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (this.boundsType != 2 && this.boundsType != 1) {
			this.method1539();
		}

		int var8 = Rasterizer3D.getClipMidX();
		int var9 = Rasterizer3D.getClipMidY();
		int var10 = field2376[var1];
		int var11 = field2378[var1];
		int var12 = field2376[var2];
		int var13 = field2378[var2];
		int var14 = field2376[var3];
		int var15 = field2378[var3];
		int var16 = field2376[var4];
		int var17 = field2378[var4];
		int var18 = var16 * var6 + var17 * var7 >> 16;

		for (int var19 = 0; var19 < this.verticesCount; ++var19) {
			int var20 = this.verticesX[var19];
			int var21 = this.verticesY[var19];
			int var22 = this.verticesZ[var19];
			int var23;
			if (var3 != 0) {
				var23 = var21 * var14 + var20 * var15 >> 16;
				var21 = var21 * var15 - var20 * var14 >> 16;
				var20 = var23;
			}

			if (var1 != 0) {
				var23 = var21 * var11 - var22 * var10 >> 16;
				var22 = var21 * var10 + var22 * var11 >> 16;
				var21 = var23;
			}

			if (var2 != 0) {
				var23 = var22 * var12 + var20 * var13 >> 16;
				var22 = var22 * var13 - var20 * var12 >> 16;
				var20 = var23;
			}

			var20 += var5;
			var21 += var6;
			var22 += var7;
			var23 = var21 * var17 - var22 * var16 >> 16;
			var22 = var21 * var16 + var22 * var17 >> 16;
			field2370[var19] = var22 - var18;
			modelViewportXs[var19] = var8 + var20 * Rasterizer3D.get3dZoom() / var22;
			modelViewportYs[var19] = var9 + var23 * Rasterizer3D.get3dZoom() / var22;
			field2359[var19] = WorldMapAreaData.method1364(var22);
			if (this.field2421 > 0) {
				field2364[var19] = var20;
				field2366[var19] = var23;
				field2368[var19] = var22;
			}
		}

		try {
			this.draw0(false, false, false, 0L);
		} catch (Exception var25) {
		}

	}

	@ObfuscatedName("bg")
	public final void method1557(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (this.boundsType != 2 && this.boundsType != 1) {
			this.method1539();
		}

		int var9 = Rasterizer3D.getClipMidX();
		int var10 = Rasterizer3D.getClipMidY();
		int var11 = field2376[var1];
		int var12 = field2378[var1];
		int var13 = field2376[var2];
		int var14 = field2378[var2];
		int var15 = field2376[var3];
		int var16 = field2378[var3];
		int var17 = field2376[var4];
		int var18 = field2378[var4];
		int var19 = var17 * var6 + var18 * var7 >> 16;

		for (int var20 = 0; var20 < this.verticesCount; ++var20) {
			int var21 = this.verticesX[var20];
			int var22 = this.verticesY[var20];
			int var23 = this.verticesZ[var20];
			int var24;
			if (var3 != 0) {
				var24 = var22 * var15 + var21 * var16 >> 16;
				var22 = var22 * var16 - var21 * var15 >> 16;
				var21 = var24;
			}

			if (var1 != 0) {
				var24 = var22 * var12 - var23 * var11 >> 16;
				var23 = var22 * var11 + var23 * var12 >> 16;
				var22 = var24;
			}

			if (var2 != 0) {
				var24 = var23 * var13 + var21 * var14 >> 16;
				var23 = var23 * var14 - var21 * var13 >> 16;
				var21 = var24;
			}

			var21 += var5;
			var22 += var6;
			var23 += var7;
			var24 = var22 * var18 - var23 * var17 >> 16;
			var23 = var22 * var17 + var23 * var18 >> 16;
			field2370[var20] = var23 - var19;
			modelViewportXs[var20] = var9 + var21 * Rasterizer3D.get3dZoom() / var8;
			modelViewportYs[var20] = var10 + var24 * Rasterizer3D.get3dZoom() / var8;
			field2359[var20] = WorldMapAreaData.method1364(var8);
			if (this.field2421 > 0) {
				field2364[var20] = var21;
				field2366[var20] = var24;
				field2368[var20] = var23;
			}
		}

		try {
			this.draw0(false, false, false, 0L);
		} catch (Exception var26) {
		}

	}

	@ObfuscatedName("ba")
	@Export("draw0")
	final void draw0(boolean var1, boolean var2, boolean var3, long var4) {
		if (this.diameter < 6000) {
			int var6;
			for (var6 = 0; var6 < this.diameter; ++var6) {
				field2357[var6] = 0;
			}

			var6 = var3 ? 20 : 5;

			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			int var15;
			int var16;
			int var18;
			for (char var7 = 0; var7 < this.indicesCount; ++var7) {
				if (this.faceColors3[var7] != -2) {
					var8 = this.indices1[var7];
					var9 = this.indices2[var7];
					var10 = this.indices3[var7];
					var11 = modelViewportXs[var8];
					var12 = modelViewportXs[var9];
					var13 = modelViewportXs[var10];
					int var27;
					if (var1 && (var11 == -5000 || var12 == -5000 || var13 == -5000)) {
						var27 = field2364[var8];
						var15 = field2364[var9];
						var16 = field2364[var10];
						int var17 = field2366[var8];
						var18 = field2366[var9];
						int var19 = field2366[var10];
						int var20 = field2368[var8];
						int var21 = field2368[var9];
						int var22 = field2368[var10];
						var27 -= var15;
						var16 -= var15;
						var17 -= var18;
						var19 -= var18;
						var20 -= var21;
						var22 -= var21;
						int var23 = var17 * var22 - var20 * var19;
						int var24 = var20 * var16 - var27 * var22;
						int var25 = var27 * var19 - var17 * var16;
						if (var15 * var23 + var18 * var24 + var21 * var25 > 0) {
							field2354[var7] = true;
							int var26 = (field2370[var8] + field2370[var9] + field2370[var10]) / 3 + this.radius;
							field2358[var26][field2357[var26]++] = var7;
						}
					} else {
						if (var2 && class225.method1148(modelViewportYs[var8], modelViewportYs[var9], modelViewportYs[var10], var11, var12, var13, var6)) {
							ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var4;
							var2 = false;
						}

						if ((var11 - var12) * (modelViewportYs[var10] - modelViewportYs[var9]) - (var13 - var12) * (modelViewportYs[var8] - modelViewportYs[var9]) > 0) {
							field2354[var7] = false;
							var27 = Rasterizer3D.method1425();
							if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= var27 && var12 <= var27 && var13 <= var27) {
								field2353[var7] = false;
							} else {
								field2353[var7] = true;
							}

							var15 = (field2370[var8] + field2370[var9] + field2370[var10]) / 3 + this.radius;
							field2358[var15][field2357[var15]++] = var7;
						}
					}
				}
			}

			char[] var28;
			int var32;
			char var33;
			if (this.faceRenderPriorities == null) {
				for (var32 = this.diameter - 1; var32 >= 0; --var32) {
					var33 = field2357[var32];
					if (var33 > 0) {
						var28 = field2358[var32];

						for (var10 = 0; var10 < var33; ++var10) {
							this.drawFace(var28[var10]);
						}
					}
				}

			} else {
				for (var32 = 0; var32 < 12; ++var32) {
					field2365[var32] = 0;
					field2377[var32] = 0;
				}

				for (var32 = this.diameter - 1; var32 >= 0; --var32) {
					var33 = field2357[var32];
					if (var33 > 0) {
						var28 = field2358[var32];

						for (var10 = 0; var10 < var33; ++var10) {
							char var34 = var28[var10];
							byte var35 = this.faceRenderPriorities[var34];
							var13 = field2365[var35]++;
							field2381[var35][var13] = var34;
							if (var35 < 10) {
								int[] var36 = field2377;
								var36[var35] += var32;
							} else if (var35 == 10) {
								field2373[var13] = var32;
							} else {
								field2379[var13] = var32;
							}
						}
					}
				}

				var32 = 0;
				if (field2365[1] > 0 || field2365[2] > 0) {
					var32 = (field2377[1] + field2377[2]) / (field2365[1] + field2365[2]);
				}

				var8 = 0;
				if (field2365[3] > 0 || field2365[4] > 0) {
					var8 = (field2377[3] + field2377[4]) / (field2365[3] + field2365[4]);
				}

				var9 = 0;
				if (field2365[6] > 0 || field2365[8] > 0) {
					var9 = (field2377[8] + field2377[6]) / (field2365[8] + field2365[6]);
				}

				var11 = 0;
				var12 = field2365[10];
				int[] var29 = field2381[10];
				int[] var30 = field2373;
				if (var11 == var12) {
					var11 = 0;
					var12 = field2365[11];
					var29 = field2381[11];
					var30 = field2379;
				}

				if (var11 < var12) {
					var10 = var30[var11];
				} else {
					var10 = -1000;
				}

				for (var15 = 0; var15 < 10; ++var15) {
					while (var15 == 0 && var10 > var32) {
						this.drawFace(var29[var11++]);
						if (var11 == var12 && var29 != field2381[11]) {
							var11 = 0;
							var12 = field2365[11];
							var29 = field2381[11];
							var30 = field2379;
						}

						if (var11 < var12) {
							var10 = var30[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 3 && var10 > var8) {
						this.drawFace(var29[var11++]);
						if (var11 == var12 && var29 != field2381[11]) {
							var11 = 0;
							var12 = field2365[11];
							var29 = field2381[11];
							var30 = field2379;
						}

						if (var11 < var12) {
							var10 = var30[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 5 && var10 > var9) {
						this.drawFace(var29[var11++]);
						if (var11 == var12 && var29 != field2381[11]) {
							var11 = 0;
							var12 = field2365[11];
							var29 = field2381[11];
							var30 = field2379;
						}

						if (var11 < var12) {
							var10 = var30[var11];
						} else {
							var10 = -1000;
						}
					}

					var16 = field2365[var15];
					int[] var31 = field2381[var15];

					for (var18 = 0; var18 < var16; ++var18) {
						this.drawFace(var31[var18]);
					}
				}

				while (var10 != -1000) {
					this.drawFace(var29[var11++]);
					if (var11 == var12 && var29 != field2381[11]) {
						var11 = 0;
						var29 = field2381[11];
						var12 = field2365[11];
						var30 = field2379;
					}

					if (var11 < var12) {
						var10 = var30[var11];
					} else {
						var10 = -1000;
					}
				}

			}
		}
	}

	@ObfuscatedName("bm")
	@Export("drawFace")
	final void drawFace(int var1) {
		if (field2354[var1]) {
			this.method1563(var1);
		} else {
			int var2 = this.indices1[var1];
			int var3 = this.indices2[var1];
			int var4 = this.indices3[var1];
			Rasterizer3D.clips.field2446 = field2353[var1];
			if (this.faceAlphas == null) {
				Rasterizer3D.clips.field2452 = 0;
			} else {
				Rasterizer3D.clips.field2452 = (this.faceAlphas[var1] == -1 ? 253 : this.faceAlphas[var1]) & 255;
			}

			this.method1562(var1, modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], field2359[var2], field2359[var3], field2359[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
		}
	}

	@ObfuscatedName("bp")
	boolean method1561(int var1) {
		return this.overrideAmount > 0 && var1 < this.field2423;
	}

	@ObfuscatedName("bw")
	final void method1562(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10, int var11, int var12, int var13) {
		if (this.faceTextures != null && this.faceTextures[var1] != -1) {
			int var15;
			int var16;
			int var18;
			if (this.field2390 != null && this.field2390[var1] != -1) {
				int var17 = this.field2390[var1] & 255;
				var18 = this.field2396[var17];
				var15 = this.field2397[var17];
				var16 = this.field2407[var17];
			} else {
				var18 = this.indices1[var1];
				var15 = this.indices2[var1];
				var16 = this.indices3[var1];
			}

			if (this.faceColors3[var1] == -1) {
				Rasterizer3D.method1434(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var11, var11, field2364[var18], field2364[var15], field2364[var16], field2366[var18], field2366[var15], field2366[var16], field2368[var18], field2368[var15], field2368[var16], this.faceTextures[var1]);
			} else {
				Rasterizer3D.method1434(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, field2364[var18], field2364[var15], field2364[var16], field2366[var18], field2366[var15], field2366[var16], field2368[var18], field2368[var15], field2368[var16], this.faceTextures[var1]);
			}
		} else {
			boolean var14 = this.method1561(var1);
			if (this.faceColors3[var1] == -1 && var14) {
				Rasterizer3D.method1437(var2, var3, var4, var5, var6, var7, var8, var9, var10, field2375[this.faceColors1[var1]], this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
			} else if (this.faceColors3[var1] == -1) {
				Rasterizer3D.method1433(var2, var3, var4, var5, var6, var7, var8, var9, var10, field2375[this.faceColors1[var1]]);
			} else if (var14) {
				Rasterizer3D.method1436(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
			} else {
				Rasterizer3D.method1432(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
			}
		}

	}

	@ObfuscatedName("bj")
	final void method1563(int var1) {
		int var2 = Rasterizer3D.getClipMidX();
		int var3 = Rasterizer3D.getClipMidY();
		int var4 = 0;
		int var5 = this.indices1[var1];
		int var6 = this.indices2[var1];
		int var7 = this.indices3[var1];
		int var8 = field2368[var5];
		int var9 = field2368[var6];
		int var10 = field2368[var7];
		if (this.faceAlphas == null) {
			Rasterizer3D.clips.field2452 = 0;
		} else {
			Rasterizer3D.clips.field2452 = this.faceAlphas[var1] & 255;
		}

		int var11;
		int var12;
		int var13;
		int var14;
		if (var8 >= 50) {
			field2372[var4] = modelViewportXs[var5];
			field2380[var4] = modelViewportYs[var5];
			field2360[var4] = field2359[var7];
			field2374[var4++] = this.faceColors1[var1];
		} else {
			var11 = field2364[var5];
			var12 = field2366[var5];
			var13 = this.faceColors1[var1];
			if (var10 >= 50) {
				var14 = field2371[var10 - var8] * (50 - var8);
				field2372[var4] = var2 + (var11 + ((field2364[var7] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var7] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2360[var4] = field2387;
				field2374[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
			}

			if (var9 >= 50) {
				var14 = field2371[var9 - var8] * (50 - var8);
				field2372[var4] = var2 + (var11 + ((field2364[var6] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var6] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2360[var4] = field2387;
				field2374[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
			}
		}

		if (var9 >= 50) {
			field2372[var4] = modelViewportXs[var6];
			field2380[var4] = modelViewportYs[var6];
			field2360[var4] = field2359[var7];
			field2374[var4++] = this.faceColors2[var1];
		} else {
			var11 = field2364[var6];
			var12 = field2366[var6];
			var13 = this.faceColors2[var1];
			if (var8 >= 50) {
				var14 = field2371[var8 - var9] * (50 - var9);
				field2372[var4] = var2 + (var11 + ((field2364[var5] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var5] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2360[var4] = field2387;
				field2374[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
			}

			if (var10 >= 50) {
				var14 = field2371[var10 - var9] * (50 - var9);
				field2372[var4] = var2 + (var11 + ((field2364[var7] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var7] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2374[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
			}
		}

		if (var10 >= 50) {
			field2372[var4] = modelViewportXs[var7];
			field2380[var4] = modelViewportYs[var7];
			field2360[var4] = field2359[var7];
			field2374[var4++] = this.faceColors3[var1];
		} else {
			var11 = field2364[var7];
			var12 = field2366[var7];
			var13 = this.faceColors3[var1];
			if (var9 >= 50) {
				var14 = field2371[var9 - var10] * (50 - var10);
				field2372[var4] = var2 + (var11 + ((field2364[var6] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var6] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2360[var4] = field2387;
				field2374[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
			}

			if (var8 >= 50) {
				var14 = field2371[var8 - var10] * (50 - var10);
				field2372[var4] = var2 + (var11 + ((field2364[var5] - var11) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2380[var4] = var3 + (var12 + ((field2366[var5] - var12) * var14 >> 16)) * Rasterizer3D.get3dZoom() / 50;
				field2360[var4] = field2387;
				field2374[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
			}
		}

		var11 = field2372[0];
		var12 = field2372[1];
		var13 = field2372[2];
		var14 = field2380[0];
		int var15 = field2380[1];
		int var16 = field2380[2];
		float var17 = field2360[0];
		float var18 = field2360[1];
		float var19 = field2360[2];
		Rasterizer3D.clips.field2446 = false;
		int var20 = Rasterizer3D.method1425();
		if (var4 == 3) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > var20 || var12 > var20 || var13 > var20) {
				Rasterizer3D.clips.field2446 = true;
			}

			this.method1562(var1, var14, var15, var16, var11, var12, var13, var17, var18, var19, field2374[0], field2374[1], field2374[2]);
		}

		if (var4 == 4) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > var20 || var12 > var20 || var13 > var20 || field2372[3] < 0 || field2372[3] > var20) {
				Rasterizer3D.clips.field2446 = true;
			}

			int var22;
			if (this.faceTextures != null && this.faceTextures[var1] != -1) {
				int var23;
				int var25;
				if (this.field2390 != null && this.field2390[var1] != -1) {
					int var24 = this.field2390[var1] & 255;
					var25 = this.field2396[var24];
					var22 = this.field2397[var24];
					var23 = this.field2407[var24];
				} else {
					var25 = var5;
					var22 = var6;
					var23 = var7;
				}

				short var26 = this.faceTextures[var1];
				if (this.faceColors3[var1] == -1) {
					Rasterizer3D.method1434(var14, var15, var16, var11, var12, var13, var17, var18, var19, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2364[var25], field2364[var22], field2364[var23], field2366[var25], field2366[var22], field2366[var23], field2368[var25], field2368[var22], field2368[var23], var26);
					Rasterizer3D.method1434(var14, var16, field2380[3], var11, var13, field2372[3], var17, var19, field2360[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field2364[var25], field2364[var22], field2364[var23], field2366[var25], field2366[var22], field2366[var23], field2368[var25], field2368[var22], field2368[var23], var26);
				} else {
					Rasterizer3D.method1434(var14, var15, var16, var11, var12, var13, var17, var18, var19, field2374[0], field2374[1], field2374[2], field2364[var25], field2364[var22], field2364[var23], field2366[var25], field2366[var22], field2366[var23], field2368[var25], field2368[var22], field2368[var23], var26);
					Rasterizer3D.method1434(var14, var16, field2380[3], var11, var13, field2372[3], var17, var19, field2360[3], field2374[0], field2374[2], field2374[3], field2364[var25], field2364[var22], field2364[var23], field2366[var25], field2366[var22], field2366[var23], field2368[var25], field2368[var22], field2368[var23], var26);
				}
			} else {
				boolean var21 = this.method1561(var1);
				if (this.faceColors3[var1] == -1 && var21) {
					var22 = field2375[this.faceColors1[var1]];
					Rasterizer3D.method1437(var14, var15, var16, var11, var12, var13, var17, var18, var19, var22, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
					Rasterizer3D.method1437(var14, var16, field2380[3], var11, var13, field2372[3], var17, var19, field2360[3], var22, this.overrideHue, this.overrideSaturation, this.overrideLuminance, this.overrideAmount);
				} else if (this.faceColors3[var1] == -1) {
					var22 = field2375[this.faceColors1[var1]];
					Rasterizer3D.method1433(var14, var15, var16, var11, var12, var13, var17, var18, var19, var22);
					Rasterizer3D.method1433(var14, var16, field2380[3], var11, var13, field2372[3], var17, var19, field2360[3], var22);
				} else if (var21) {
					Rasterizer3D.method1436(var14, var15, var16, var11, var12, var13, var17, var18, var19, field2374[0], field2374[1], field2374[2], this.overrideHue, this.overrideLuminance, this.overrideSaturation, this.overrideAmount);
					Rasterizer3D.method1436(var14, var16, field2380[3], var11, var13, field2372[3], 0.0F, 0.0F, 0.0F, field2374[0], field2374[2], field2374[3], this.overrideHue, this.overrideLuminance, this.overrideSaturation, this.overrideAmount);
				} else {
					Rasterizer3D.method1432(var14, var15, var16, var11, var12, var13, var17, var18, var19, field2374[0], field2374[1], field2374[2]);
					Rasterizer3D.method1432(var14, var16, field2380[3], var11, var13, field2372[3], var17, var19, field2360[3], field2374[0], field2374[2], field2374[3]);
				}
			}
		}

	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ILrz;)V"
	)
	void method1564(int var1, class462 var2) {
		float var3 = (float)this.verticesX[var1];
		float var4 = (float)(-this.verticesY[var1]);
		float var5 = (float)(-this.verticesZ[var1]);
		float var6 = 1.0F;
		this.verticesX[var1] = (int)(var2.field3908[0] * var3 + var2.field3908[4] * var4 + var2.field3908[8] * var5 + var2.field3908[12] * var6);
		this.verticesY[var1] = -((int)(var2.field3908[1] * var3 + var2.field3908[5] * var4 + var2.field3908[9] * var5 + var2.field3908[13] * var6));
		this.verticesZ[var1] = -((int)(var2.field3908[2] * var3 + var2.field3908[6] * var4 + var2.field3908[10] * var5 + var2.field3908[14] * var6));
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(Lkz;I)V"
	)
	void method1565(class267 var1, int var2) {
		if (this.field2409 != null) {
			for (int var3 = 0; var3 < this.verticesCount; ++var3) {
				int[] var4 = this.field2409[var3];
				if (var4 != null && var4.length != 0) {
					int[] var5 = this.field2411[var3];
					field2385.method2319();

					for (int var6 = 0; var6 < var4.length; ++var6) {
						int var7 = var4[var6];
						class128 var8 = var1.method1440(var7);
						if (var8 != null) {
							field2386.method2321((float)var5[var6] / 255.0F);
							field2384.method2320(var8.method704(var2));
							field2384.method2324(field2386);
							field2385.method2323(field2384);
						}
					}

					this.method1564(var3, field2385);
				}
			}

		}
	}

	@ObfuscatedName("dw")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		if (this.boundsType != 1) {
			this.calculateBoundsCylinder();
		}

		this.calculateBoundingBox(var1);
		int var11 = var5 * var8 - var4 * var6 >> 16;
		int var12 = var2 * var7 + var3 * var11 >> 16;
		int var13 = var3 * this.xzRadius >> 16;
		int var14 = var12 + var13;
		if (var14 > 50 && var12 < 3500) {
			int var15 = var8 * var4 + var5 * var6 >> 16;
			int var16 = (var15 - this.xzRadius) * Rasterizer3D.get3dZoom();
			if (var16 / var14 < Rasterizer3D.getClipMidX2()) {
				int var17 = (var15 + this.xzRadius) * Rasterizer3D.get3dZoom();
				if (var17 / var14 > Rasterizer3D.method1420()) {
					int var18 = var3 * var7 - var11 * var2 >> 16;
					int var19 = var2 * this.xzRadius >> 16;
					int var20 = (var3 * this.bottomY >> 16) + var19;
					int var21 = (var18 + var20) * Rasterizer3D.get3dZoom();
					if (var21 / var14 > Rasterizer3D.method1423()) {
						int var22 = (var3 * super.height >> 16) + var19;
						int var23 = (var18 - var22) * Rasterizer3D.get3dZoom();
						if (var23 / var14 < Rasterizer3D.getClipMidY2()) {
							int var24 = var13 + (var2 * super.height >> 16);
							boolean var25 = false;
							boolean var26 = false;
							if (var12 - var24 <= 50) {
								var26 = true;
							}

							boolean var27 = var26 || this.field2421 > 0;
							int var28 = ViewportMouse.ViewportMouse_x;
							int var30 = ViewportMouse.ViewportMouse_y;
							boolean var32 = ViewportMouse.ViewportMouse_isInViewport;
							boolean var34 = class207.method1059(var9);
							boolean var35 = false;
							int var40;
							int var41;
							int var42;
							int var43;
							int var56;
							int var61;
							int var62;
							int var63;
							if (var34 && var32) {
								boolean var36 = false;
								if (field2352) {
									boolean var39 = ViewportMouse.ViewportMouse_isInViewport;
									boolean var37;
									if (!var39) {
										var37 = false;
									} else {
										int var46;
										int var47;
										int var48;
										int var49;
										int var64;
										if (!ViewportMouse.ViewportMouse_false0) {
											var40 = Scene.Scene_cameraPitchSine;
											var41 = Scene.Scene_cameraPitchCosine;
											var42 = Scene.Scene_cameraYawSine;
											var43 = Scene.Scene_cameraYawCosine;
											byte var44 = 50;
											short var45 = 3500;
											var46 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.getClipMidX()) * var44 / Rasterizer3D.get3dZoom();
											var47 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.getClipMidY()) * var44 / Rasterizer3D.get3dZoom();
											var48 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.getClipMidX()) * var45 / Rasterizer3D.get3dZoom();
											var49 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.getClipMidY()) * var45 / Rasterizer3D.get3dZoom();
											int var51 = var40 * var44 + var41 * var47 >> 16;
											int var52 = var44 * var41 - var40 * var47 >> 16;
											int var53 = var49 * var41 + var40 * var45 >> 16;
											int var54 = var41 * var45 - var49 * var40 >> 16;
											int var50 = LoginScreenAnimation.method520(var46, var52, var43, var42);
											var63 = class167.method867(var46, var52, var43, var42);
											var46 = var50;
											var50 = LoginScreenAnimation.method520(var48, var54, var43, var42);
											var64 = class167.method867(var48, var54, var43, var42);
											class422.field3763 = (var50 + var46) / 2;
											class106.field1113 = (var51 + var53) / 2;
											ObjTypeCustomisation.field1431 = (var64 + var63) / 2;
											class303.field2512 = (var50 - var46) / 2;
											class402.field3694 = (var53 - var51) / 2;
											ViewportMouse.field2433 = (var64 - var63) / 2;
											ViewportMouse.field2429 = Math.abs(class303.field2512);
											MusicPatchNode2.field2777 = Math.abs(class402.field3694);
											ViewportMouse.field2432 = Math.abs(ViewportMouse.field2433);
										}

										AABB var55 = (AABB)this.aabb.get(var1);
										var41 = var55.xMid + var6;
										var42 = var7 + var55.yMid;
										var43 = var8 + var55.zMid;
										var63 = var55.xMidOffset;
										var64 = var55.yMidOffset;
										var46 = var55.zMidOffset;
										var47 = class422.field3763 - var41;
										var48 = class106.field1113 - var42;
										var49 = ObjTypeCustomisation.field1431 - var43;
										if (Math.abs(var47) > var63 + ViewportMouse.field2429) {
											var37 = false;
										} else if (Math.abs(var48) > var64 + MusicPatchNode2.field2777) {
											var37 = false;
										} else if (Math.abs(var49) > var46 + ViewportMouse.field2432) {
											var37 = false;
										} else if (Math.abs(var49 * class402.field3694 - var48 * ViewportMouse.field2433) > var46 * MusicPatchNode2.field2777 + var64 * ViewportMouse.field2432) {
											var37 = false;
										} else if (Math.abs(var47 * ViewportMouse.field2433 - var49 * class303.field2512) > var46 * ViewportMouse.field2429 + var63 * ViewportMouse.field2432) {
											var37 = false;
										} else if (Math.abs(var48 * class303.field2512 - var47 * class402.field3694) > var63 * MusicPatchNode2.field2777 + var64 * ViewportMouse.field2429) {
											var37 = false;
										} else {
											var37 = true;
										}
									}

									var36 = var37;
								} else {
									var62 = var12 - var13;
									if (var62 <= 50) {
										var62 = 50;
									}

									if (var15 > 0) {
										var16 /= var14;
										var17 /= var62;
									} else {
										var17 /= var14;
										var16 /= var62;
									}

									if (var18 > 0) {
										var23 /= var14;
										var21 /= var62;
									} else {
										var21 /= var14;
										var23 /= var62;
									}

									var56 = var28 - Rasterizer3D.getClipMidX();
									var61 = var30 - Rasterizer3D.getClipMidY();
									if (var56 > var16 && var56 < var17 && var61 > var23 && var61 < var21) {
										var36 = true;
									}
								}

								if (var36) {
									if (this.isSingleTile) {
										ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var9;
									} else {
										var35 = true;
									}
								}
							}

							int var60 = Rasterizer3D.getClipMidX();
							var62 = Rasterizer3D.getClipMidY();
							var56 = 0;
							var61 = 0;
							if (var1 != 0) {
								var56 = field2376[var1];
								var61 = field2378[var1];
							}

							for (var40 = 0; var40 < this.verticesCount; ++var40) {
								var41 = this.verticesX[var40];
								var42 = this.verticesY[var40];
								var43 = this.verticesZ[var40];
								if (var1 != 0) {
									var63 = var43 * var56 + var41 * var61 >> 16;
									var43 = var43 * var61 - var41 * var56 >> 16;
									var41 = var63;
								}

								var41 += var6;
								var42 += var7;
								var43 += var8;
								var63 = var43 * var4 + var5 * var41 >> 16;
								var43 = var5 * var43 - var41 * var4 >> 16;
								var41 = var63;
								var63 = var3 * var42 - var43 * var2 >> 16;
								var43 = var42 * var2 + var3 * var43 >> 16;
								field2370[var40] = var43 - var12;
								if (var43 >= 50) {
									modelViewportXs[var40] = var60 + var41 * Rasterizer3D.get3dZoom() / var43;
									modelViewportYs[var40] = var62 + var63 * Rasterizer3D.get3dZoom() / var43;
									field2359[var40] = WorldMapAreaData.method1364(var43);
								} else {
									modelViewportXs[var40] = -5000;
									var25 = true;
								}

								if (var27) {
									field2364[var40] = var41;
									field2366[var40] = var63;
									field2368[var40] = var43;
								}
							}

							try {
								this.draw0(var25, var35, this.isSingleTile, var9);
							} catch (Exception var59) {
							}

						}
					}
				}
			}
		}
	}
}