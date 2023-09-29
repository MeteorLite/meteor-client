import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("gu")
	static String field1042;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lun;"
	)
	IndexedSprite[] field1058;
	@ObfuscatedName("ar")
	int[] field1054;
	@ObfuscatedName("ab")
	int field1043;
	@ObfuscatedName("am")
	int[] field1052;
	@ObfuscatedName("av")
	int[] field1057;
	@ObfuscatedName("ag")
	int[] field1050;
	@ObfuscatedName("aa")
	int[] field1049;
	@ObfuscatedName("ap")
	int field1046;
	@ObfuscatedName("ay")
	int field1048;
	@ObfuscatedName("as")
	int[] field1055;
	@ObfuscatedName("aj")
	int[] field1051;
	@ObfuscatedName("an")
	int[] field1053;
	@ObfuscatedName("au")
	int[] field1056;
	@ObfuscatedName("ai")
	int field1045;
	@ObfuscatedName("ae")
	int field1044;
	@ObfuscatedName("aw")
	int field1047;

	@ObfuscatedSignature(
		descriptor = "([Lun;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1054 = new int[256];
		this.field1043 = 0;
		this.field1046 = 0;
		this.field1048 = 0;
		this.field1045 = 0;
		this.field1044 = 0;
		this.field1047 = 0;
		this.field1058 = var1;
		this.initColors();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "75"
	)
	@Export("initColors")
	void initColors() {
		this.field1057 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1057[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1057[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1057[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1057[var1 + 192] = 16777215;
		}

		this.field1050 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1050[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1050[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1050[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1050[var1 + 192] = 16777215;
		}

		this.field1049 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 192] = 16777215;
		}

		this.field1052 = new int[256];
		this.field1045 = 0;
		this.field1053 = new int[32768];
		this.field1056 = new int[32768];
		this.method535((IndexedSprite)null);
		this.field1055 = new int[32768];
		this.field1051 = new int[32768];
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-6404822"
	)
	void method527() {
		this.field1057 = null;
		this.field1050 = null;
		this.field1049 = null;
		this.field1052 = null;
		this.field1053 = null;
		this.field1056 = null;
		this.field1055 = null;
		this.field1051 = null;
		this.field1045 = 0;
		this.field1044 = 0;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1382576663"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1055 == null) {
			this.initColors();
		}

		if (this.field1047 == 0) {
			this.field1047 = var2;
		}

		int var3 = var2 - this.field1047;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1047 = var2;
		if (var3 > 0) {
			this.method530(var3);
		}

		this.method532(var1);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1766870241"
	)
	final void method530(int var1) {
		this.field1045 += 128 * var1;
		int var2;
		if (this.field1045 > this.field1053.length) {
			this.field1045 -= this.field1053.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method535(this.field1058[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1055[var2 + var3] - this.field1053[var2 + this.field1045 & this.field1053.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1055[var2++] = var6;
		}

		byte var15 = 10;
		var6 = 128 - var15;

		int var7;
		int var10;
		for (var7 = 256 - var1; var7 < 256; ++var7) {
			int var8 = var7 * 128;

			for (int var9 = 0; var9 < 128; ++var9) {
				var10 = (int)(Math.random() * 100.0D);
				if (var10 < 50 && var9 > var15 && var9 < var6) {
					this.field1055[var8 + var9] = 255;
				} else {
					this.field1055[var8 + var9] = 0;
				}
			}
		}

		if (this.field1046 > 0) {
			this.field1046 -= var1 * 4;
		}

		if (this.field1048 > 0) {
			this.field1048 -= var1 * 4;
		}

		if (this.field1046 == 0 && this.field1048 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1046 = 1024;
			}

			if (var7 == 1) {
				this.field1048 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1054[var7] = this.field1054[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1054[var7] = (int)(Math.sin((double)this.field1043 / 14.0D) * 16.0D + Math.sin((double)this.field1043 / 15.0D) * 14.0D + Math.sin((double)this.field1043 / 16.0D) * 12.0D);
			++this.field1043;
		}

		this.field1044 += var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1044 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1055[var12 + (var13 << 7)] = 192;
			}

			this.field1044 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1055[var13 + var14 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1055[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1051[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var7 + var13 < 256) {
						var12 += this.field1051[var7 * 128 + var11 + var14];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1051[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1055[var14 + var11] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "92"
	)
	final int method531(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-527981427"
	)
	final void method532(int var1) {
		int var2 = this.field1052.length;
		if (this.field1046 > 0) {
			this.method533(this.field1046, this.field1050);
		} else if (this.field1048 > 0) {
			this.method533(this.field1048, this.field1049);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1052[var3] = this.field1057[var3];
			}
		}

		this.method534(var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I[II)V",
		garbageValue = "-1793969695"
	)
	final void method533(int var1, int[] var2) {
		int var3 = this.field1052.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1052[var4] = this.method531(this.field1057[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1052[var4] = var2[var4];
			} else {
				this.field1052[var4] = this.method531(var2[var4], this.field1057[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1816590027"
	)
	final void method534(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1054[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= class223.rasterProvider.width) {
				var7 = class223.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * class223.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1055[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1052[var10];
					int var14 = class223.rasterProvider.pixels[var8];
					class223.rasterProvider.pixels[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lun;I)V",
		garbageValue = "129400298"
	)
	final void method535(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1053.length; ++var2) {
			this.field1053[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1053[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1056[var5] = (this.field1053[var5 + 128] + this.field1053[var5 - 128] + this.field1053[var5 + 1] + this.field1053[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1053;
			this.field1053 = this.field1056;
			this.field1056 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1053[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIILiz;IB)V",
		garbageValue = "-106"
	)
	static void method529(int var0, int var1, int var2, ObjectComposition var3, int var4) {
		ObjectSound var5 = new ObjectSound();
		var5.plane = var0;
		var5.x = var1 * 128;
		var5.y = var2 * 128;
		int var6 = var3.sizeX;
		int var7 = var3.sizeY;
		if (var4 == 1 || var4 == 3) {
			var6 = var3.sizeY;
			var7 = var3.sizeX;
		}

		var5.maxX = (var6 + var1) * 128;
		var5.maxY = (var7 + var2) * 128;
		var5.soundEffectId = var3.ambientSoundId;
		var5.field696 = var3.int7 * 128;
		var5.field697 = var3.int5;
		var5.field690 = var3.int6;
		var5.soundEffectIds = var3.soundEffectIds;
		if (var3.transforms != null) {
			var5.obj = var3;
			var5.set();
		}

		ObjectSound.objectSounds.addFirst(var5);
		if (var5.soundEffectIds != null) {
			var5.field695 = var5.field697 + (int)(Math.random() * (double)(var5.field690 - var5.field697));
		}

	}
}