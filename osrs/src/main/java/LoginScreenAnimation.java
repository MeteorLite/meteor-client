import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "[Luk;"
	)
	IndexedSprite[] field1055;
	@ObfuscatedName("az")
	int[] field1054;
	@ObfuscatedName("ap")
	int field1043;
	@ObfuscatedName("aa")
	int[] field1046;
	@ObfuscatedName("af")
	int[] field1049;
	@ObfuscatedName("ad")
	int[] field1048;
	@ObfuscatedName("aq")
	int[] field1052;
	@ObfuscatedName("al")
	int field1041;
	@ObfuscatedName("an")
	int field1042;
	@ObfuscatedName("ar")
	int[] field1053;
	@ObfuscatedName("ab")
	int[] field1047;
	@ObfuscatedName("ag")
	int[] field1050;
	@ObfuscatedName("am")
	int[] field1051;
	@ObfuscatedName("ax")
	int field1045;
	@ObfuscatedName("ah")
	int field1040;
	@ObfuscatedName("as")
	int field1044;

	@ObfuscatedSignature(
		descriptor = "([Luk;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1054 = new int[256];
		this.field1043 = 0;
		this.field1041 = 0;
		this.field1042 = 0;
		this.field1045 = 0;
		this.field1040 = 0;
		this.field1044 = 0;
		this.field1055 = var1;
		this.initColors();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-111"
	)
	@Export("initColors")
	void initColors() {
		this.field1049 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1049[var1 + 192] = 16777215;
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

		this.field1052 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1052[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1052[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1052[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1052[var1 + 192] = 16777215;
		}

		this.field1046 = new int[256];
		this.field1045 = 0;
		this.field1050 = new int[32768];
		this.field1051 = new int[32768];
		this.method535((IndexedSprite)null);
		this.field1053 = new int[32768];
		this.field1047 = new int[32768];
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1799116765"
	)
	void method528() {
		this.field1049 = null;
		this.field1048 = null;
		this.field1052 = null;
		this.field1046 = null;
		this.field1050 = null;
		this.field1051 = null;
		this.field1053 = null;
		this.field1047 = null;
		this.field1045 = 0;
		this.field1040 = 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-48"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1053 == null) {
			this.initColors();
		}

		if (this.field1044 == 0) {
			this.field1044 = var2;
		}

		int var3 = var2 - this.field1044;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1044 = var2;
		if (var3 > 0) {
			this.method530(var3);
		}

		this.method532(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "0"
	)
	final void method530(int var1) {
		this.field1045 += var1 * 128;
		int var2;
		if (this.field1045 > this.field1050.length) {
			this.field1045 -= this.field1050.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method535(this.field1055[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1053[var3 + var2] - this.field1050[var2 + this.field1045 & this.field1050.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1053[var2++] = var6;
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
					this.field1053[var9 + var8] = 255;
				} else {
					this.field1053[var9 + var8] = 0;
				}
			}
		}

		if (this.field1041 > 0) {
			this.field1041 -= var1 * 4;
		}

		if (this.field1042 > 0) {
			this.field1042 -= var1 * 4;
		}

		if (this.field1041 == 0 && this.field1042 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1041 = 1024;
			}

			if (var7 == 1) {
				this.field1042 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1054[var7] = this.field1054[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1054[var7] = (int)(Math.sin((double)this.field1043 / 14.0D) * 16.0D + Math.sin((double)this.field1043 / 15.0D) * 14.0D + Math.sin((double)this.field1043 / 16.0D) * 12.0D);
			++this.field1043;
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
				this.field1053[var12 + (var13 << 7)] = 192;
			}

			this.field1040 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var7 + var14 < 128) {
						var12 += this.field1053[var7 + var14 + var13];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1053[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1047[var14 + var13] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var7 + var13 < 256) {
						var12 += this.field1047[var7 * 128 + var14 + var11];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1047[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1053[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIIS)I",
		garbageValue = "1630"
	)
	final int method531(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1503103603"
	)
	final void method532(int var1) {
		int var2 = this.field1046.length;
		if (this.field1041 > 0) {
			this.method533(this.field1041, this.field1048);
		} else if (this.field1042 > 0) {
			this.method533(this.field1042, this.field1052);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1046[var3] = this.field1049[var3];
			}
		}

		this.method534(var1);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I[IB)V",
		garbageValue = "106"
	)
	final void method533(int var1, int[] var2) {
		int var3 = this.field1046.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1046[var4] = this.method531(this.field1049[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1046[var4] = var2[var4];
			} else {
				this.field1046[var4] = this.method531(var2[var4], this.field1049[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1021290032"
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

			if (var5 + 128 >= AttackOption.rasterProvider.width) {
				var7 = AttackOption.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * AttackOption.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1053[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1046[var10];
					int var14 = AttackOption.rasterProvider.pixels[var8];
					AttackOption.rasterProvider.pixels[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Luk;I)V",
		garbageValue = "-1981831992"
	)
	final void method535(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1050.length; ++var2) {
			this.field1050[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1050[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1051[var5] = (this.field1050[var5 + 128] + this.field1050[var5 - 128] + this.field1050[var5 + 1] + this.field1050[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1050;
			this.field1050 = this.field1051;
			this.field1051 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1050[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("mf")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)V",
		garbageValue = "1528651927"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (ModeWhere.loadInterface(var0)) {
			class9.updateInterface(PacketBufferNode.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}