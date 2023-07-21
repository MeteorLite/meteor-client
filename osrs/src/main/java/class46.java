import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class46 {
	@ObfuscatedName("aw")
	int field224;
	@ObfuscatedName("ay")
	int field225;
	@ObfuscatedName("ar")
	int field222;
	@ObfuscatedName("am")
	int field221;
	@ObfuscatedName("as")
	int field223;
	@ObfuscatedName("aj")
	int field220;
	@ObfuscatedName("ag")
	int[] field226;

	class46() {
		class60 var1 = VorbisSample.field267;
		this.field224 = var1.method325(16);
		this.field225 = var1.method325(24);
		this.field222 = var1.method325(24);
		this.field221 = var1.method325(24) + 1;
		this.field223 = var1.method325(6) + 1;
		this.field220 = var1.method325(8);
		int[] var2 = new int[this.field223];

		int var3;
		for (var3 = 0; var3 < this.field223; ++var3) {
			int var4 = 0;
			int var5 = var1.method325(3);
			boolean var6 = var1.method326() != 0;
			if (var6) {
				var4 = var1.method325(5);
			}

			var2[var3] = var4 << 3 | var5;
		}

		this.field226 = new int[this.field223 * 8];

		for (var3 = 0; var3 < this.field223 * 8; ++var3) {
			this.field226[var3] = (var2[var3 >> 3] & 1 << (var3 & 7)) != 0 ? var1.method325(8) : -1;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([FIZLce;)V"
	)
	void method232(float[] var1, int var2, boolean var3, class60 var4) {
		int var5;
		for (var5 = 0; var5 < var2; ++var5) {
			var1[var5] = 0.0F;
		}

		if (!var3) {
			var5 = VorbisSample.field268[this.field220].field255;
			int var6 = this.field222 - this.field225;
			int var7 = var6 / this.field221;
			int[] var8 = new int[var7];

			for (int var9 = 0; var9 < 8; ++var9) {
				int var10 = 0;

				while (var10 < var7) {
					int var11;
					int var12;
					if (var9 == 0) {
						var11 = VorbisSample.field268[this.field220].method292(var4);

						for (var12 = var5 - 1; var12 >= 0; --var12) {
							if (var10 + var12 < var7) {
								var8[var10 + var12] = var11 % this.field223;
							}

							var11 /= this.field223;
						}
					}

					for (var11 = 0; var11 < var5; ++var11) {
						var12 = var8[var10];
						int var13 = this.field226[var9 + var12 * 8];
						if (var13 >= 0) {
							int var14 = var10 * this.field221 + this.field225;
							VorbisCodebook var15 = VorbisSample.field268[var13];
							int var16;
							if (this.field224 == 0) {
								var16 = this.field221 / var15.field255;

								for (int var17 = 0; var17 < var16; ++var17) {
									float[] var21 = var15.method293(var4);

									for (int var19 = 0; var19 < var15.field255; ++var19) {
										var1[var14 + var17 + var19 * var16] += var21[var19];
									}
								}
							} else {
								var16 = 0;

								while (var16 < this.field221) {
									float[] var20 = var15.method293(var4);

									for (int var18 = 0; var18 < var15.field255; ++var18) {
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
