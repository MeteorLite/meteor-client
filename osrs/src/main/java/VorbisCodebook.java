import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("VorbisCodebook")
public class VorbisCodebook {
	@ObfuscatedName("aw")
	int field255;
	@ObfuscatedName("ay")
	@Export("entries")
	int entries;
	@ObfuscatedName("ar")
	@Export("lengthMap")
	int[] lengthMap;
	@ObfuscatedName("am")
	int[] field258;
	@ObfuscatedName("as")
	float[][] field254;
	@ObfuscatedName("aj")
	@Export("keys")
	int[] keys;

	VorbisCodebook() {
		class60 var1 = VorbisSample.field267;
		var1.method325(24);
		this.field255 = var1.method325(16);
		this.entries = var1.method325(24);
		this.lengthMap = new int[this.entries];
		boolean var2 = var1.method326() != 0;
		int var3;
		int var4;
		int var6;
		if (var2) {
			var3 = 0;

			for (var4 = var1.method325(5) + 1; var3 < this.entries; ++var4) {
				int var5 = var1.method325(WorldMapRegion.iLog(this.entries - var3));

				for (var6 = 0; var6 < var5; ++var6) {
					this.lengthMap[var3++] = var4;
				}
			}
		} else {
			boolean var15 = var1.method326() != 0;

			for (var4 = 0; var4 < this.entries; ++var4) {
				if (var15 && var1.method326() == 0) {
					this.lengthMap[var4] = 0;
				} else {
					this.lengthMap[var4] = var1.method325(5) + 1;
				}
			}
		}

		this.method291();
		var3 = var1.method325(4);
		if (var3 > 0) {
			float var16 = VorbisSample.float32Unpack(var1.method325(32));
			float var17 = VorbisSample.float32Unpack(var1.method325(32));
			var6 = var1.method325(4) + 1;
			boolean var7 = var1.method326() != 0;
			int var8;
			if (var3 == 1) {
				var8 = mapType1QuantValues(this.entries, this.field255);
			} else {
				var8 = this.entries * this.field255;
			}

			this.field258 = new int[var8];

			int var9;
			for (var9 = 0; var9 < var8; ++var9) {
				this.field258[var9] = var1.method325(var6);
			}

			this.field254 = new float[this.entries][this.field255];
			float var10;
			int var11;
			int var12;
			if (var3 == 1) {
				for (var9 = 0; var9 < this.entries; ++var9) {
					var10 = 0.0F;
					var11 = 1;

					for (var12 = 0; var12 < this.field255; ++var12) {
						int var13 = var9 / var11 % var8;
						float var14 = (float)this.field258[var13] * var17 + var16 + var10;
						this.field254[var9][var12] = var14;
						if (var7) {
							var10 = var14;
						}

						var11 *= var8;
					}
				}
			} else {
				for (var9 = 0; var9 < this.entries; ++var9) {
					var10 = 0.0F;
					var11 = var9 * this.field255;

					for (var12 = 0; var12 < this.field255; ++var12) {
						float var18 = (float)this.field258[var11] * var17 + var16 + var10;
						this.field254[var9][var12] = var18;
						if (var7) {
							var10 = var18;
						}

						++var11;
					}
				}
			}
		}

	}

	@ObfuscatedName("ay")
	void method291() {
		int[] var1 = new int[this.entries];
		int[] var2 = new int[33];

		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var10;
		for (var3 = 0; var3 < this.entries; ++var3) {
			var4 = this.lengthMap[var3];
			if (var4 != 0) {
				var5 = 1 << 32 - var4;
				var6 = var2[var4];
				var1[var3] = var6;
				int var9;
				if ((var6 & var5) != 0) {
					var7 = var2[var4 - 1];
				} else {
					var7 = var6 | var5;

					for (var8 = var4 - 1; var8 >= 1; --var8) {
						var9 = var2[var8];
						if (var9 != var6) {
							break;
						}

						var10 = 1 << 32 - var8;
						if ((var9 & var10) != 0) {
							var2[var8] = var2[var8 - 1];
							break;
						}

						var2[var8] = var9 | var10;
					}
				}

				var2[var4] = var7;

				for (var8 = var4 + 1; var8 <= 32; ++var8) {
					var9 = var2[var8];
					if (var9 == var6) {
						var2[var8] = var7;
					}
				}
			}
		}

		this.keys = new int[8];
		int var11 = 0;

		for (var3 = 0; var3 < this.entries; ++var3) {
			var4 = this.lengthMap[var3];
			if (var4 != 0) {
				var5 = var1[var3];
				var6 = 0;

				for (var7 = 0; var7 < var4; ++var7) {
					var8 = Integer.MIN_VALUE >>> var7;
					if ((var5 & var8) != 0) {
						if (this.keys[var6] == 0) {
							this.keys[var6] = var11;
						}

						var6 = this.keys[var6];
					} else {
						++var6;
					}

					if (var6 >= this.keys.length) {
						int[] var12 = new int[this.keys.length * 2];

						for (var10 = 0; var10 < this.keys.length; ++var10) {
							var12[var10] = this.keys[var10];
						}

						this.keys = var12;
					}

					var8 >>>= 1;
				}

				this.keys[var6] = ~var3;
				if (var6 >= var11) {
					var11 = var6 + 1;
				}
			}
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lce;)I"
	)
	int method292(class60 var1) {
		int var2;
		for (var2 = 0; this.keys[var2] >= 0; var2 = var1.method326() != 0 ? this.keys[var2] : var2 + 1) {
		}

		return ~this.keys[var2];
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lce;)[F"
	)
	float[] method293(class60 var1) {
		return this.field254[this.method292(var1)];
	}

	@ObfuscatedName("aw")
	@Export("mapType1QuantValues")
	static int mapType1QuantValues(int var0, int var1) {
		int var2;
		for (var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; CollisionMap.method1091(var2, var1) > var0; --var2) {
		}

		return var2;
	}
}
