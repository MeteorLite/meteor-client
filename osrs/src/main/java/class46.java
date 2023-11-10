import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class46 {
	@ObfuscatedName("at")
	int field219;
	@ObfuscatedName("ah")
	int field216;
	@ObfuscatedName("ar")
	int field218;
	@ObfuscatedName("ao")
	int field217;
	@ObfuscatedName("ab")
	int field215;
	@ObfuscatedName("au")
	int field220;
	@ObfuscatedName("aa")
	int[] field221;

	class46() {
		class60 var1 = VorbisSample.field264;
		this.field219 = var1.method335(16);
		this.field216 = var1.method335(24);
		this.field218 = var1.method335(24);
		this.field217 = var1.method335(24) + 1;
		this.field215 = var1.method335(6) + 1;
		this.field220 = var1.method335(8);
		int[] var2 = new int[this.field215];

		int var3;
		for (var3 = 0; var3 < this.field215; ++var3) {
			int var4 = 0;
			int var5 = var1.method335(3);
			boolean var6 = var1.method336() != 0;
			if (var6) {
				var4 = var1.method335(5);
			}

			var2[var3] = var4 << 3 | var5;
		}

		this.field221 = new int[this.field215 * 8];

		for (var3 = 0; var3 < this.field215 * 8; ++var3) {
			this.field221[var3] = (var2[var3 >> 3] & 1 << (var3 & 7)) != 0 ? var1.method335(8) : -1;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([FIZLcw;)V"
	)
	void method243(float[] var1, int var2, boolean var3, class60 var4) {
		int var5;
		for (var5 = 0; var5 < var2; ++var5) {
			var1[var5] = 0.0F;
		}

		if (!var3) {
			var5 = VorbisSample.field263[this.field220].field252;
			int var6 = this.field218 - this.field216;
			int var7 = var6 / this.field217;
			int[] var8 = new int[var7];

			for (int var9 = 0; var9 < 8; ++var9) {
				int var10 = 0;

				while (var10 < var7) {
					int var11;
					int var12;
					if (var9 == 0) {
						var11 = VorbisSample.field263[this.field220].method301(var4);

						for (var12 = var5 - 1; var12 >= 0; --var12) {
							if (var10 + var12 < var7) {
								var8[var10 + var12] = var11 % this.field215;
							}

							var11 /= this.field215;
						}
					}

					for (var11 = 0; var11 < var5; ++var11) {
						var12 = var8[var10];
						int var13 = this.field221[var9 + var12 * 8];
						if (var13 >= 0) {
							int var14 = var10 * this.field217 + this.field216;
							VorbisCodebook var15 = VorbisSample.field263[var13];
							int var16;
							if (this.field219 == 0) {
								var16 = this.field217 / var15.field252;

								for (int var17 = 0; var17 < var16; ++var17) {
									float[] var21 = var15.method302(var4);

									for (int var19 = 0; var19 < var15.field252; ++var19) {
										var1[var14 + var17 + var19 * var16] += var21[var19];
									}
								}
							} else {
								var16 = 0;

								while (var16 < this.field217) {
									float[] var20 = var15.method302(var4);

									for (int var18 = 0; var18 < var15.field252; ++var18) {
										var1[var14 + var16] += var20[var18];
										++var16;
									}
								}
							}
						}

						++var10;
						if (var10 >= var7) {
							break;
						}
					}
				}
			}

		}
	}
}