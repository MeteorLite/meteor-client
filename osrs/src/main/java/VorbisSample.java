import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("VorbisSample")
public class VorbisSample extends Node {
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lce;"
	)
	static class60 field267;
	@ObfuscatedName("az")
	static int field276;
	@ObfuscatedName("av")
	static int field275;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "[Lct;"
	)
	static VorbisCodebook[] field268;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "[Lbu;"
	)
	static VorbisFloor[] field266;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lbm;"
	)
	static class46[] field263;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[Lbg;"
	)
	static VorbisMapping[] field262;
	@ObfuscatedName("ax")
	static boolean[] field265;
	@ObfuscatedName("aa")
	static int[] field277;
	@ObfuscatedName("au")
	static boolean field264;
	@ObfuscatedName("ak")
	static float[] field271;
	@ObfuscatedName("an")
	static float[] field273;
	@ObfuscatedName("af")
	static float[] field269;
	@ObfuscatedName("ai")
	static float[] field270;
	@ObfuscatedName("al")
	static float[] field272;
	@ObfuscatedName("bd")
	static float[] field274;
	@ObfuscatedName("bb")
	static int[] field278;
	@ObfuscatedName("bn")
	static int[] field279;
	@ObfuscatedName("aw")
	byte[][] field283;
	@ObfuscatedName("ay")
	@Export("sampleRate")
	int sampleRate;
	@ObfuscatedName("ar")
	@Export("sampleCount")
	int sampleCount;
	@ObfuscatedName("am")
	@Export("start")
	int start;
	@ObfuscatedName("as")
	@Export("end")
	int end;
	@ObfuscatedName("aj")
	boolean field280;
	@ObfuscatedName("ae")
	float[] field285;
	@ObfuscatedName("ab")
	int field286;
	@ObfuscatedName("ad")
	int field287;
	@ObfuscatedName("ao")
	boolean field281;
	@ObfuscatedName("ac")
	float[] field284;
	@ObfuscatedName("ba")
	@Export("samples")
	byte[] samples;
	@ObfuscatedName("bf")
	int field292;
	@ObfuscatedName("bs")
	int field293;

	static {
		field267 = new class60();
		field264 = false;
	}

	VorbisSample(byte[] var1) {
		this.read(var1);
	}

	@ObfuscatedName("ay")
	@Export("read")
	void read(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		this.sampleRate = var2.readInt();
		this.sampleCount = var2.readInt();
		this.start = var2.readInt();
		this.end = var2.readInt();
		if (this.end < 0) {
			this.end = ~this.end;
			this.field280 = true;
		}

		int var3 = var2.readInt();
		this.field283 = new byte[var3][];

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = 0;

			int var6;
			do {
				var6 = var2.readUnsignedByte();
				var5 += var6;
			} while(var6 >= 255);

			byte[] var7 = new byte[var5];
			var2.readBytes(var7, 0, var5);
			this.field283[var4] = var7;
		}

	}

	@ObfuscatedName("am")
	float[] method302(int var1) {
		class60 var2 = new class60();
		var2.method327(this.field283[var1], 0);
		this.field284 = new float[field275];
		var2.method326();
		int var3 = var2.method325(WorldMapRegion.iLog(field277.length - 1));
		boolean var4 = field265[var3];
		int var5 = var4 ? field275 : field276;
		boolean var6 = false;
		boolean var7 = false;
		if (var4) {
			var6 = var2.method326() != 0;
			var7 = var2.method326() != 0;
		}

		int var8 = var5 >> 1;
		int var9;
		int var10;
		int var11;
		if (var4 && !var6) {
			var9 = (var5 >> 2) - (field276 >> 2);
			var10 = (field276 >> 2) + (var5 >> 2);
			var11 = field276 >> 1;
		} else {
			var9 = 0;
			var10 = var8;
			var11 = var5 >> 1;
		}

		int var12;
		int var13;
		int var14;
		if (var4 && !var7) {
			var12 = var5 - (var5 >> 2) - (field276 >> 2);
			var13 = (field276 >> 2) + (var5 - (var5 >> 2));
			var14 = field276 >> 1;
		} else {
			var12 = var8;
			var13 = var5;
			var14 = var5 >> 1;
		}

		VorbisMapping var15 = field262[field277[var3]];
		int var16 = var15.field251;
		int var17 = var15.field253[var16];
		class59 var18 = field266[var17].method198(var2);
		boolean var19 = !var18.method319();

		int var20;
		for (var20 = 0; var20 < var15.field250; ++var20) {
			class46 var21 = field263[var15.field252[var20]];
			float[] var22 = this.field284;
			var21.method232(var22, var5 >> 1, var19, var2);
		}

		if (var18.method319()) {
			var16 = var15.field251;
			int var10000 = var15.field253[var16];
			var18.method318(this.field284, var5 >> 1);
		}

		int var43;
		int var44;
		if (!var18.method319()) {
			for (var20 = var5 >> 1; var20 < var5; ++var20) {
				this.field284[var20] = 0.0F;
			}
		} else {
			var20 = var5 >> 1;
			var43 = var5 >> 2;
			var44 = var5 >> 3;
			float[] var23 = this.field284;

			int var24;
			for (var24 = 0; var24 < var20; ++var24) {
				var23[var24] *= 0.5F;
			}

			for (var24 = var20; var24 < var5; ++var24) {
				var23[var24] = -var23[var5 - var24 - 1];
			}

			float[] var45 = var4 ? field270 : field271;
			float[] var25 = var4 ? field272 : field273;
			float[] var26 = var4 ? field274 : field269;
			int[] var27 = var4 ? field279 : field278;

			int var28;
			float var29;
			float var30;
			float var31;
			float var32;
			for (var28 = 0; var28 < var43; ++var28) {
				var29 = var23[var28 * 4] - var23[var5 - var28 * 4 - 1];
				var30 = var23[var28 * 4 + 2] - var23[var5 - var28 * 4 - 3];
				var31 = var45[var28 * 2];
				var32 = var45[var28 * 2 + 1];
				var23[var5 - var28 * 4 - 1] = var29 * var31 - var30 * var32;
				var23[var5 - var28 * 4 - 3] = var29 * var32 + var30 * var31;
			}

			float var33;
			float var34;
			for (var28 = 0; var28 < var44; ++var28) {
				var29 = var23[var20 + var28 * 4 + 3];
				var30 = var23[var20 + var28 * 4 + 1];
				var31 = var23[var28 * 4 + 3];
				var32 = var23[var28 * 4 + 1];
				var23[var20 + var28 * 4 + 3] = var29 + var31;
				var23[var20 + var28 * 4 + 1] = var30 + var32;
				var33 = var45[var20 - 4 - var28 * 4];
				var34 = var45[var20 - 3 - var28 * 4];
				var23[var28 * 4 + 3] = (var29 - var31) * var33 - (var30 - var32) * var34;
				var23[var28 * 4 + 1] = (var30 - var32) * var33 + (var29 - var31) * var34;
			}

			var28 = WorldMapRegion.iLog(var5 - 1);

			int var49;
			int var50;
			int var51;
			int var52;
			for (var49 = 0; var49 < var28 - 3; ++var49) {
				var50 = var5 >> var49 + 2;
				var51 = 8 << var49;

				for (var52 = 0; var52 < 2 << var49; ++var52) {
					int var53 = var5 - var50 * var52 * 2;
					int var54 = var5 - var50 * (var52 * 2 + 1);

					for (int var35 = 0; var35 < var5 >> var49 + 4; ++var35) {
						int var36 = var35 * 4;
						float var37 = var23[var53 - 1 - var36];
						float var38 = var23[var53 - 3 - var36];
						float var39 = var23[var54 - 1 - var36];
						float var40 = var23[var54 - 3 - var36];
						var23[var53 - 1 - var36] = var37 + var39;
						var23[var53 - 3 - var36] = var38 + var40;
						float var41 = var45[var35 * var51];
						float var42 = var45[var35 * var51 + 1];
						var23[var54 - 1 - var36] = (var37 - var39) * var41 - (var38 - var40) * var42;
						var23[var54 - 3 - var36] = (var38 - var40) * var41 + (var37 - var39) * var42;
					}
				}
			}

			for (var49 = 1; var49 < var44 - 1; ++var49) {
				var50 = var27[var49];
				if (var49 < var50) {
					var51 = var49 * 8;
					var52 = var50 * 8;
					var33 = var23[var51 + 1];
					var23[var51 + 1] = var23[var52 + 1];
					var23[var52 + 1] = var33;
					var33 = var23[var51 + 3];
					var23[var51 + 3] = var23[var52 + 3];
					var23[var52 + 3] = var33;
					var33 = var23[var51 + 5];
					var23[var51 + 5] = var23[var52 + 5];
					var23[var52 + 5] = var33;
					var33 = var23[var51 + 7];
					var23[var51 + 7] = var23[var52 + 7];
					var23[var52 + 7] = var33;
				}
			}

			for (var49 = 0; var49 < var20; ++var49) {
				var23[var49] = var23[var49 * 2 + 1];
			}

			for (var49 = 0; var49 < var44; ++var49) {
				var23[var5 - 1 - var49 * 2] = var23[var49 * 4];
				var23[var5 - 2 - var49 * 2] = var23[var49 * 4 + 1];
				var23[var5 - var43 - 1 - var49 * 2] = var23[var49 * 4 + 2];
				var23[var5 - var43 - 2 - var49 * 2] = var23[var49 * 4 + 3];
			}

			for (var49 = 0; var49 < var44; ++var49) {
				var30 = var26[var49 * 2];
				var31 = var26[var49 * 2 + 1];
				var32 = var23[var20 + var49 * 2];
				var33 = var23[var20 + var49 * 2 + 1];
				var34 = var23[var5 - 2 - var49 * 2];
				float var55 = var23[var5 - 1 - var49 * 2];
				float var56 = var31 * (var32 - var34) + var30 * (var33 + var55);
				var23[var20 + var49 * 2] = (var32 + var34 + var56) * 0.5F;
				var23[var5 - 2 - var49 * 2] = (var32 + var34 - var56) * 0.5F;
				var56 = var31 * (var33 + var55) - var30 * (var32 - var34);
				var23[var20 + var49 * 2 + 1] = (var33 - var55 + var56) * 0.5F;
				var23[var5 - 1 - var49 * 2] = (-var33 + var55 + var56) * 0.5F;
			}

			for (var49 = 0; var49 < var43; ++var49) {
				var23[var49] = var23[var20 + var49 * 2] * var25[var49 * 2] + var23[var20 + var49 * 2 + 1] * var25[var49 * 2 + 1];
				var23[var20 - 1 - var49] = var23[var20 + var49 * 2] * var25[var49 * 2 + 1] - var23[var20 + var49 * 2 + 1] * var25[var49 * 2];
			}

			for (var49 = 0; var49 < var43; ++var49) {
				var23[var49 + (var5 - var43)] = -var23[var49];
			}

			for (var49 = 0; var49 < var43; ++var49) {
				var23[var49] = var23[var43 + var49];
			}

			for (var49 = 0; var49 < var43; ++var49) {
				var23[var43 + var49] = -var23[var43 - var49 - 1];
			}

			for (var49 = 0; var49 < var43; ++var49) {
				var23[var20 + var49] = var23[var5 - var49 - 1];
			}

			float[] var57;
			for (var49 = var9; var49 < var10; ++var49) {
				var30 = (float)Math.sin(((double)(var49 - var9) + 0.5D) / (double)var11 * 0.5D * 3.141592653589793D);
				var57 = this.field284;
				var57[var49] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}

			for (var49 = var12; var49 < var13; ++var49) {
				var30 = (float)Math.sin(((double)(var49 - var12) + 0.5D) / (double)var14 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				var57 = this.field284;
				var57[var49] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}
		}

		float[] var46 = null;
		if (this.field286 > 0) {
			var43 = var5 + this.field286 >> 2;
			var46 = new float[var43];
			int var47;
			if (!this.field281) {
				for (var44 = 0; var44 < this.field287; ++var44) {
					var47 = var44 + (this.field286 >> 1);
					var46[var44] += this.field285[var47];
				}
			}

			if (var18.method319()) {
				for (var44 = var9; var44 < var5 >> 1; ++var44) {
					var47 = var46.length - (var5 >> 1) + var44;
					var46[var47] += this.field284[var44];
				}
			}
		}

		float[] var48 = this.field285;
		this.field285 = this.field284;
		this.field284 = var48;
		this.field286 = var5;
		this.field287 = var13 - (var5 >> 1);
		this.field281 = !var18.method319();
		return var46;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "([I)Lbi;"
	)
	@Export("toRawSound")
	RawSound toRawSound(int[] var1) {
		if (var1 != null && var1[0] <= 0) {
			return null;
		} else {
			if (this.samples == null) {
				this.field286 = 0;
				this.field285 = new float[field275];
				this.samples = new byte[this.sampleCount];
				this.field292 = 0;
				this.field293 = 0;
			}

			for (; this.field293 < this.field283.length; ++this.field293) {
				if (var1 != null && var1[0] <= 0) {
					return null;
				}

				float[] var2 = this.method302(this.field293);
				if (var2 != null) {
					int var3 = this.field292;
					int var4 = var2.length;
					if (var4 > this.sampleCount - var3) {
						var4 = this.sampleCount - var3;
					}

					for (int var5 = 0; var5 < var4; ++var5) {
						int var6 = (int)(128.0F + var2[var5] * 128.0F);
						if ((var6 & -256) != 0) {
							var6 = ~var6 >> 31;
						}

						this.samples[var3++] = (byte)(var6 - 128);
					}

					if (var1 != null) {
						var1[0] -= var3 - this.field292;
					}

					this.field292 = var3;
				}
			}

			this.field285 = null;
			byte[] var7 = this.samples;
			this.samples = null;
			return new RawSound(this.sampleRate, var7, this.start, this.end, this.field280);
		}
	}

	@ObfuscatedName("aw")
	@Export("float32Unpack")
	static float float32Unpack(int var0) {
		int var1 = var0 & 2097151;
		int var2 = var0 & Integer.MIN_VALUE;
		int var3 = (var0 & 2145386496) >> 21;
		if (var2 != 0) {
			var1 = -var1;
		}

		return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
	}

	@ObfuscatedName("ar")
	static void method301(byte[] var0) {
		class60 var1 = field267;
		var1.method327(var0, 0);
		field276 = 1 << var1.method325(4);
		field275 = 1 << var1.method325(4);

		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		for (var2 = 0; var2 < 2; ++var2) {
			var3 = var2 != 0 ? field275 : field276;
			var4 = var3 >> 1;
			var5 = var3 >> 2;
			var6 = var3 >> 3;
			float[] var13 = new float[var4];

			for (int var8 = 0; var8 < var5; ++var8) {
				var13[var8 * 2] = (float)Math.cos((double)(var8 * 4) * 3.141592653589793D / (double)var3);
				var13[var8 * 2 + 1] = -((float)Math.sin((double)(var8 * 4) * 3.141592653589793D / (double)var3));
			}

			float[] var14 = new float[var4];

			for (int var9 = 0; var9 < var5; ++var9) {
				var14[var9 * 2] = (float)Math.cos((double)(var9 * 2 + 1) * 3.141592653589793D / (double)(var3 * 2));
				var14[var9 * 2 + 1] = (float)Math.sin((double)(var9 * 2 + 1) * 3.141592653589793D / (double)(var3 * 2));
			}

			float[] var15 = new float[var5];

			for (int var10 = 0; var10 < var6; ++var10) {
				var15[var10 * 2] = (float)Math.cos((double)(var10 * 4 + 2) * 3.141592653589793D / (double)var3);
				var15[var10 * 2 + 1] = -((float)Math.sin((double)(var10 * 4 + 2) * 3.141592653589793D / (double)var3));
			}

			int[] var16 = new int[var6];
			int var11 = WorldMapRegion.iLog(var6 - 1);

			for (int var12 = 0; var12 < var6; ++var12) {
				var16[var12] = WorldMapEvent.method1546(var12, var11);
			}

			if (var2 != 0) {
				field270 = var13;
				field272 = var14;
				field274 = var15;
				field279 = var16;
			} else {
				field271 = var13;
				field273 = var14;
				field269 = var15;
				field278 = var16;
			}
		}

		var2 = var1.method325(8) + 1;
		field268 = new VorbisCodebook[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			field268[var3] = new VorbisCodebook();
		}

		var3 = var1.method325(6) + 1;

		for (var4 = 0; var4 < var3; ++var4) {
			var1.method325(16);
		}

		var3 = var1.method325(6) + 1;
		field266 = new VorbisFloor[var3];

		for (var4 = 0; var4 < var3; ++var4) {
			field266[var4] = new VorbisFloor();
		}

		var4 = var1.method325(6) + 1;
		field263 = new class46[var4];

		for (var5 = 0; var5 < var4; ++var5) {
			field263[var5] = new class46();
		}

		var5 = var1.method325(6) + 1;
		field262 = new VorbisMapping[var5];

		for (var6 = 0; var6 < var5; ++var6) {
			field262[var6] = new VorbisMapping();
		}

		var6 = var1.method325(6) + 1;
		field265 = new boolean[var6];
		field277 = new int[var6];

		for (int var7 = 0; var7 < var6; ++var7) {
			field265[var7] = var1.method326() != 0;
			var1.method325(16);
			var1.method325(16);
			field277[var7] = var1.method325(8);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lnd;)Z"
	)
	static boolean method303(AbstractArchive var0) {
		if (!field264) {
			byte[] var1 = var0.takeFile(0, 0);
			if (var1 == null) {
				return false;
			}

			method301(var1);
			field264 = true;
		}

		return true;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lnd;II)Lcz;"
	)
	@Export("readMusicSample")
	static VorbisSample readMusicSample(AbstractArchive var0, int var1, int var2) {
		if (!method303(var0)) {
			var0.tryLoadFile(var1, var2);
			return null;
		} else {
			byte[] var3 = var0.takeFile(var1, var2);
			return var3 == null ? null : new VorbisSample(var3);
		}
	}
}
