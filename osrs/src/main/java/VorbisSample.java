import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("VorbisSample")
public class VorbisSample extends Node {
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lcw;"
	)
	static class60 field264;
	@ObfuscatedName("ac")
	static int field271;
	@ObfuscatedName("al")
	static int field272;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "[Lcf;"
	)
	static VorbisCodebook[] field263;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "[Lbu;"
	)
	static VorbisFloor[] field262;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "[Lbs;"
	)
	static class46[] field261;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "[Lbr;"
	)
	static VorbisMapping[] field260;
	@ObfuscatedName("as")
	static boolean[] field259;
	@ObfuscatedName("ay")
	static int[] field273;
	@ObfuscatedName("ak")
	static boolean field258;
	@ObfuscatedName("ae")
	static float[] field266;
	@ObfuscatedName("an")
	static float[] field269;
	@ObfuscatedName("ag")
	static float[] field268;
	@ObfuscatedName("ad")
	static float[] field265;
	@ObfuscatedName("af")
	static float[] field267;
	@ObfuscatedName("be")
	static float[] field270;
	@ObfuscatedName("bd")
	static int[] field274;
	@ObfuscatedName("bl")
	static int[] field275;
	@ObfuscatedName("at")
	byte[][] field279;
	@ObfuscatedName("ah")
	@Export("sampleRate")
	int sampleRate;
	@ObfuscatedName("ar")
	@Export("sampleCount")
	int sampleCount;
	@ObfuscatedName("ao")
	@Export("start")
	int start;
	@ObfuscatedName("ab")
	@Export("end")
	int end;
	@ObfuscatedName("au")
	boolean field277;
	@ObfuscatedName("aj")
	float[] field280;
	@ObfuscatedName("am")
	int field284;
	@ObfuscatedName("aq")
	int field286;
	@ObfuscatedName("ai")
	boolean field276;
	@ObfuscatedName("aw")
	float[] field281;
	@ObfuscatedName("bi")
	@Export("samples")
	byte[] samples;
	@ObfuscatedName("bv")
	int field289;
	@ObfuscatedName("bf")
	int field288;

	static {
		field264 = new class60();
		field258 = false;
	}

	VorbisSample(byte[] var1) {
		this.read(var1);
	}

	@ObfuscatedName("ah")
	@Export("read")
	void read(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		this.sampleRate = var2.readInt();
		this.sampleCount = var2.readInt();
		this.start = var2.readInt();
		this.end = var2.readInt();
		if (this.end < 0) {
			this.end = ~this.end;
			this.field277 = true;
		}

		int var3 = var2.readInt();
		this.field279 = new byte[var3][];

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = 0;

			int var6;
			do {
				var6 = var2.readUnsignedByte();
				var5 += var6;
			} while(var6 >= 255);

			byte[] var7 = new byte[var5];
			var2.readBytes(var7, 0, var5);
			this.field279[var4] = var7;
		}

	}

	@ObfuscatedName("ao")
	float[] method312(int var1) {
		class60 var2 = new class60();
		var2.method337(this.field279[var1], 0);
		this.field281 = new float[field272];
		var2.method336();
		int var3 = var2.method335(LoginScreenAnimation.iLog(field273.length - 1));
		boolean var4 = field259[var3];
		int var5 = var4 ? field272 : field271;
		boolean var6 = false;
		boolean var7 = false;
		if (var4) {
			var6 = var2.method336() != 0;
			var7 = var2.method336() != 0;
		}

		int var8 = var5 >> 1;
		int var9;
		int var10;
		int var11;
		if (var4 && !var6) {
			var9 = (var5 >> 2) - (field271 >> 2);
			var10 = (field271 >> 2) + (var5 >> 2);
			var11 = field271 >> 1;
		} else {
			var9 = 0;
			var10 = var8;
			var11 = var5 >> 1;
		}

		int var12;
		int var13;
		int var14;
		if (var4 && !var7) {
			var12 = var5 - (var5 >> 2) - (field271 >> 2);
			var13 = (field271 >> 2) + (var5 - (var5 >> 2));
			var14 = field271 >> 1;
		} else {
			var12 = var8;
			var13 = var5;
			var14 = var5 >> 1;
		}

		VorbisMapping var15 = field260[field273[var3]];
		int var16 = var15.field246;
		int var17 = var15.field249[var16];
		class59 var18 = field262[var17].method209(var2);
		boolean var19 = !var18.method330();

		int var20;
		for (var20 = 0; var20 < var15.field247; ++var20) {
			class46 var21 = field261[var15.field248[var20]];
			float[] var22 = this.field281;
			var21.method243(var22, var5 >> 1, var19, var2);
		}

		if (var18.method330()) {
			var16 = var15.field246;
			int var10000 = var15.field249[var16];
			var18.method329(this.field281, var5 >> 1);
		}

		int var43;
		int var44;
		if (!var18.method330()) {
			for (var20 = var5 >> 1; var20 < var5; ++var20) {
				this.field281[var20] = 0.0F;
			}
		} else {
			var20 = var5 >> 1;
			var43 = var5 >> 2;
			var44 = var5 >> 3;
			float[] var23 = this.field281;

			int var24;
			for (var24 = 0; var24 < var20; ++var24) {
				var23[var24] *= 0.5F;
			}

			for (var24 = var20; var24 < var5; ++var24) {
				var23[var24] = -var23[var5 - var24 - 1];
			}

			float[] var45 = var4 ? field265 : field266;
			float[] var25 = var4 ? field267 : field269;
			float[] var26 = var4 ? field270 : field268;
			int[] var27 = var4 ? field275 : field274;

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

			var28 = LoginScreenAnimation.iLog(var5 - 1);

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
				var57 = this.field281;
				var57[var49] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}

			for (var49 = var12; var49 < var13; ++var49) {
				var30 = (float)Math.sin(((double)(var49 - var12) + 0.5D) / (double)var14 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				var57 = this.field281;
				var57[var49] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}
		}

		float[] var46 = null;
		if (this.field284 > 0) {
			var43 = var5 + this.field284 >> 2;
			var46 = new float[var43];
			int var47;
			if (!this.field276) {
				for (var44 = 0; var44 < this.field286; ++var44) {
					var47 = var44 + (this.field284 >> 1);
					var46[var44] += this.field280[var47];
				}
			}

			if (var18.method330()) {
				for (var44 = var9; var44 < var5 >> 1; ++var44) {
					var47 = var46.length - (var5 >> 1) + var44;
					var46[var47] += this.field281[var44];
				}
			}
		}

		float[] var48 = this.field280;
		this.field280 = this.field281;
		this.field281 = var48;
		this.field284 = var5;
		this.field286 = var13 - (var5 >> 1);
		this.field276 = !var18.method330();
		return var46;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "([I)Lbt;"
	)
	@Export("toRawSound")
	RawSound toRawSound(int[] var1) {
		if (var1 != null && var1[0] <= 0) {
			return null;
		} else {
			if (this.samples == null) {
				this.field284 = 0;
				this.field280 = new float[field272];
				this.samples = new byte[this.sampleCount];
				this.field289 = 0;
				this.field288 = 0;
			}

			for (; this.field288 < this.field279.length; ++this.field288) {
				if (var1 != null && var1[0] <= 0) {
					return null;
				}

				float[] var2 = this.method312(this.field288);
				if (var2 != null) {
					int var3 = this.field289;
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
						var1[0] -= var3 - this.field289;
					}

					this.field289 = var3;
				}
			}

			this.field280 = null;
			byte[] var7 = this.samples;
			this.samples = null;
			return new RawSound(this.sampleRate, var7, this.start, this.end, this.field277);
		}
	}

	@ObfuscatedName("at")
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
	static void method311(byte[] var0) {
		class60 var1 = field264;
		var1.method337(var0, 0);
		field271 = 1 << var1.method335(4);
		field272 = 1 << var1.method335(4);

		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		for (var2 = 0; var2 < 2; ++var2) {
			var3 = var2 != 0 ? field272 : field271;
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
			int var11 = LoginScreenAnimation.iLog(var6 - 1);

			for (int var12 = 0; var12 < var6; ++var12) {
				var16[var12] = class361.method1902(var12, var11);
			}

			if (var2 != 0) {
				field265 = var13;
				field267 = var14;
				field270 = var15;
				field275 = var16;
			} else {
				field266 = var13;
				field269 = var14;
				field268 = var15;
				field274 = var16;
			}
		}

		var2 = var1.method335(8) + 1;
		field263 = new VorbisCodebook[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			field263[var3] = new VorbisCodebook();
		}

		var3 = var1.method335(6) + 1;

		for (var4 = 0; var4 < var3; ++var4) {
			var1.method335(16);
		}

		var3 = var1.method335(6) + 1;
		field262 = new VorbisFloor[var3];

		for (var4 = 0; var4 < var3; ++var4) {
			field262[var4] = new VorbisFloor();
		}

		var4 = var1.method335(6) + 1;
		field261 = new class46[var4];

		for (var5 = 0; var5 < var4; ++var5) {
			field261[var5] = new class46();
		}

		var5 = var1.method335(6) + 1;
		field260 = new VorbisMapping[var5];

		for (var6 = 0; var6 < var5; ++var6) {
			field260[var6] = new VorbisMapping();
		}

		var6 = var1.method335(6) + 1;
		field259 = new boolean[var6];
		field273 = new int[var6];

		for (int var7 = 0; var7 < var6; ++var7) {
			field259[var7] = var1.method336() != 0;
			var1.method335(16);
			var1.method335(16);
			field273[var7] = var1.method335(8);
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lol;)Z"
	)
	static boolean method313(AbstractArchive var0) {
		if (!field258) {
			byte[] var1 = var0.takeFile(0, 0);
			if (var1 == null) {
				return false;
			}

			method311(var1);
			field258 = true;
		}

		return true;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lol;II)Lcv;"
	)
	@Export("readMusicSample")
	static VorbisSample readMusicSample(AbstractArchive var0, int var1, int var2) {
		if (!method313(var0)) {
			var0.tryLoadFile(var1, var2);
			return null;
		} else {
			byte[] var3 = var0.takeFile(var1, var2);
			return var3 == null ? null : new VorbisSample(var3);
		}
	}
}