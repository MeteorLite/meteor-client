import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "[Luu;"
	)
	IndexedSprite[] field1052;
	@ObfuscatedName("ag")
	int[] field1046;
	@ObfuscatedName("az")
	int field1042;
	@ObfuscatedName("av")
	int[] field1051;
	@ObfuscatedName("ap")
	int[] field1047;
	@ObfuscatedName("aq")
	int[] field1048;
	@ObfuscatedName("at")
	int[] field1049;
	@ObfuscatedName("ah")
	int field1039;
	@ObfuscatedName("ax")
	int field1041;
	@ObfuscatedName("aa")
	int[] field1043;
	@ObfuscatedName("au")
	int[] field1050;
	@ObfuscatedName("ae")
	int[] field1045;
	@ObfuscatedName("ab")
	int[] field1044;
	@ObfuscatedName("ad")
	int field1038;
	@ObfuscatedName("ao")
	int field1040;
	@ObfuscatedName("ac")
	int field1037;

	@ObfuscatedSignature(
		descriptor = "([Luu;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1046 = new int[256];
		this.field1042 = 0;
		this.field1039 = 0;
		this.field1041 = 0;
		this.field1038 = 0;
		this.field1040 = 0;
		this.field1037 = 0;
		this.field1052 = var1;
		this.initColors();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1971878867"
	)
	@Export("initColors")
	void initColors() {
		this.field1047 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1047[var1 + 192] = 16777215;
		}

		this.field1048 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1048[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1048[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1048[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1048[var1 + 192] = 16777215;
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

		this.field1051 = new int[256];
		this.field1038 = 0;
		this.field1045 = new int[32768];
		this.field1044 = new int[32768];
		this.method543((IndexedSprite)null);
		this.field1043 = new int[32768];
		this.field1050 = new int[32768];
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-14"
	)
	void method536() {
		this.field1047 = null;
		this.field1048 = null;
		this.field1049 = null;
		this.field1051 = null;
		this.field1045 = null;
		this.field1044 = null;
		this.field1043 = null;
		this.field1050 = null;
		this.field1038 = 0;
		this.field1040 = 0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2005060089"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1043 == null) {
			this.initColors();
		}

		if (this.field1037 == 0) {
			this.field1037 = var2;
		}

		int var3 = var2 - this.field1037;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1037 = var2;
		if (var3 > 0) {
			this.method538(var3);
		}

		this.method540(var1);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "16626"
	)
	final void method538(int var1) {
		this.field1038 += var1 * 128;
		int var2;
		if (this.field1038 > this.field1045.length) {
			this.field1038 -= this.field1045.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method543(this.field1052[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1043[var2 + var3] - this.field1045[var2 + this.field1038 & this.field1045.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1043[var2++] = var6;
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
					this.field1043[var9 + var8] = 255;
				} else {
					this.field1043[var8 + var9] = 0;
				}
			}
		}

		if (this.field1039 > 0) {
			this.field1039 -= var1 * 4;
		}

		if (this.field1041 > 0) {
			this.field1041 -= var1 * 4;
		}

		if (this.field1039 == 0 && this.field1041 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1039 = 1024;
			}

			if (var7 == 1) {
				this.field1041 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1046[var7] = this.field1046[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1046[var7] = (int)(Math.sin((double)this.field1042 / 14.0D) * 16.0D + Math.sin((double)this.field1042 / 15.0D) * 14.0D + Math.sin((double)this.field1042 / 16.0D) * 12.0D);
			++this.field1042;
		}

		this.field1040 += var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1040 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1043[var12 + (var13 << 7)] = 192;
			}

			this.field1040 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1043[var7 + var14 + var13];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1043[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1050[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var7 + var13 < 256) {
						var12 += this.field1050[var7 * 128 + var11 + var14];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1050[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1043[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "24"
	)
	final int method539(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2121548101"
	)
	final void method540(int var1) {
		int var2 = this.field1051.length;
		if (this.field1039 > 0) {
			this.method541(this.field1039, this.field1048);
		} else if (this.field1041 > 0) {
			this.method541(this.field1041, this.field1049);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1051[var3] = this.field1047[var3];
			}
		}

		this.method542(var1);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I[IB)V",
		garbageValue = "2"
	)
	final void method541(int var1, int[] var2) {
		int var3 = this.field1051.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1051[var4] = this.method539(this.field1047[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1051[var4] = var2[var4];
			} else {
				this.field1051[var4] = this.method539(var2[var4], this.field1047[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2130924481"
	)
	final void method542(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1046[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= class156.rasterProvider.width) {
				var7 = class156.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * class156.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1043[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1051[var10];
					int var14 = class156.rasterProvider.pixels[var8];
					class156.rasterProvider.pixels[var8++] = -16777216 | (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) + ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Luu;B)V",
		garbageValue = "38"
	)
	final void method543(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1045.length; ++var2) {
			this.field1045[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1045[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1044[var5] = (this.field1045[var5 - 128] + this.field1045[var5 + 1] + this.field1045[var5 + 128] + this.field1045[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1045;
			this.field1045 = this.field1044;
			this.field1044 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1045[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)I",
		garbageValue = "-66"
	)
	static final int method534(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Lhb;I)Z",
		garbageValue = "1149776403"
	)
	static boolean method544(ObjectComposition var0) {
		if (var0.transforms != null) {
			int[] var1 = var0.transforms;

			for (int var2 = 0; var2 < var1.length; ++var2) {
				int var3 = var1[var2];
				ObjectComposition var4 = class90.getObjectDefinition(var3);
				if (var4.mapIconId != -1) {
					return true;
				}
			}
		} else if (var0.mapIconId != -1) {
			return true;
		}

		return false;
	}
}
